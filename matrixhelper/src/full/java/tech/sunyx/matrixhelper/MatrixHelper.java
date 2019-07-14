package tech.sunyx.matrixhelper;

import android.app.Application;

import com.tencent.matrix.Matrix;
import com.tencent.matrix.iocanary.IOCanaryPlugin;
import com.tencent.matrix.iocanary.config.IOConfig;
import com.tencent.matrix.resource.ResourcePlugin;
import com.tencent.matrix.resource.config.ResourceConfig;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.sqlitelint.SQLiteLint;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;

/**
 * @author by SunYuXing on 2019-07-14.
 */
public class MatrixHelper extends BaseMatrixHelper {

    @Override
    public void init(Application context, String splashName) {

        DynamicConfigImpl dynamicConfig = new DynamicConfigImpl();
        boolean matrixEnable = dynamicConfig.isMatrixEnable();
        boolean fpsEnable = dynamicConfig.isFpsEnable();
        boolean traceEnable = dynamicConfig.isTraceEnable();

        MatrixLog.i(TAG, "init start:%s", System.currentTimeMillis());

        Matrix.Builder builder = new Matrix.Builder(context);
        builder.patchListener(new DelegatePluginListener(context));

        //trace
        TraceConfig traceConfig = new TraceConfig.Builder()
                .dynamicConfig(dynamicConfig)
                .enableFPS(fpsEnable)
                .enableEvilMethodTrace(traceEnable)
                .enableAnrTrace(traceEnable)
                .enableStartup(traceEnable)
                .splashActivities(splashName)
                .isDebug(true)
                .isDevEnv(false)
                .build();

        TracePlugin tracePlugin = (new TracePlugin(traceConfig));
        builder.plugin(tracePlugin);

        if (matrixEnable) {

            //resource
            builder.plugin(new ResourcePlugin(new ResourceConfig.Builder()
                    .dynamicConfig(dynamicConfig)
                    .setDumpHprof(false)
                    //only set true when in sample, not in your app
                    .setDetectDebuger(true)
                    .build()));
            ResourcePlugin.activityLeakFixer(context);

            //io
            IOCanaryPlugin ioCanaryPlugin = new IOCanaryPlugin(new IOConfig.Builder()
                    .dynamicConfig(dynamicConfig)
                    .build());
            builder.plugin(ioCanaryPlugin);


            // prevent api 19 UnsatisfiedLinkError
            //sqlite
            SQLiteLintConfig config = initSqliteLintConfig();
            SQLiteLintPlugin sqLiteLintPlugin = new SQLiteLintPlugin(config);
            builder.plugin(sqLiteLintPlugin);
        }

        Matrix.init(builder.build());

        //start only startup tracer, close other tracer.
        tracePlugin.start();

        MatrixLog.i(TAG, "init end:%s", System.currentTimeMillis());

    }

    private static SQLiteLintConfig initSqliteLintConfig() {
        try {
            /*
             * HOOK模式下，SQLiteLint会自己去获取所有已执行的sql语句及其耗时(by hooking sqlite3_profile)
             * @see 而另一个模式：SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY , 则需要调用 {@link SQLiteLint#notifySqlExecution(String, String, int)}来通知
             * SQLiteLint 需要分析的、已执行的sql语句及其耗时
             * @see TestSQLiteLintActivity#doTest()
             */
            return new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.HOOK);
        } catch (Throwable t) {
            return new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.HOOK);
        }
    }

}

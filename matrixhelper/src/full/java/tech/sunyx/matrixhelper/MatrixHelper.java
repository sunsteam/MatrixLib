package tech.sunyx.matrixhelper;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.tencent.matrix.Matrix;
import com.tencent.matrix.iocanary.IOCanaryPlugin;
import com.tencent.matrix.iocanary.config.IOConfig;
import com.tencent.matrix.resource.ResourcePlugin;
import com.tencent.matrix.resource.config.ResourceConfig;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.MatrixUtil;
import com.tencent.sqlitelint.SQLiteLint;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;

import java.util.HashMap;

import tech.sunyx.matrixhelper.params.InitConfig;
import tech.sunyx.matrixhelper.params.MatrixConfig;
import tech.sunyx.matrixhelper.params.PluginInfo;


/**
 * @author by SunYuXing on 2019-07-14.
 */
public class MatrixHelper {

    static final String TAG = "MatrixHelper";

    static HashMap<String, Plugin> pluginMap = new HashMap<>();

    public static void init(Application context, InitConfig allConfig) {

        MatrixLog.i(TAG, "init start:%s", System.currentTimeMillis());

        MatrixConfig matrixConfig = allConfig.getMatrixConfig();
        DelegateConfigImpl dynamicConfig = new DelegateConfigImpl(allConfig.getDynamicConfig());

        Matrix.Builder builder = new Matrix.Builder(context);
        builder.patchListener(new DelegatePluginListener(context, allConfig.getListener()));


        if (matrixConfig.isMatrixEnable()) {

            //trace
            TraceConfig traceConfig = new TraceConfig.Builder()
                    .dynamicConfig(dynamicConfig)
                    .enableFPS(matrixConfig.isFpsEnable())
                    .enableEvilMethodTrace(matrixConfig.isEvilMethodEnable())
                    .enableAnrTrace(matrixConfig.isAnrTraceEnable())
                    .enableStartup(matrixConfig.isStartupEnable())
                    .splashActivities(matrixConfig.getSplashActivity())
                    .isDebug(matrixConfig.isDebug())
                    .isDevEnv(matrixConfig.isDevEnv())
                    .build();

            TracePlugin tracePlugin = (new TracePlugin(traceConfig));
            builder.plugin(tracePlugin);

            //resource
            builder.plugin(new ResourcePlugin(new ResourceConfig.Builder()
                    .dynamicConfig(dynamicConfig)
                    .setDumpHprof(matrixConfig.isDumpHprof())
                    //only set true when in sample, not in your app
                    .setDetectDebuger(matrixConfig.isDetectDebug())
                    .build()));
            ResourcePlugin.activityLeakFixer(context);

            //io
            IOCanaryPlugin ioCanaryPlugin = new IOCanaryPlugin(new IOConfig.Builder()
                    .dynamicConfig(dynamicConfig)
                    .build());
            builder.plugin(ioCanaryPlugin);

            // sqlite
            // prevent api 19 UnsatisfiedLinkError
            SQLiteLintConfig config = initSqliteLintConfig();
            SQLiteLintPlugin sqLiteLintPlugin = new SQLiteLintPlugin(config);
            builder.plugin(sqLiteLintPlugin);

        }

        Matrix.init(builder.build());

        saveDelegatePlugin(SQLiteLintPlugin.class);
        saveDelegatePlugin(TracePlugin.class);
        saveDelegatePlugin(IOCanaryPlugin.class);
        saveDelegatePlugin(ResourcePlugin.class);

        MatrixLog.i(TAG, "init end:%s", System.currentTimeMillis());

    }

    private static void saveDelegatePlugin(Class<? extends com.tencent.matrix.plugin.Plugin> pluginClass) {
        Plugin plugin = new Plugin(Matrix.with().getPluginByClass(pluginClass));
        pluginMap.put(plugin.getTag(), plugin);
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


    public static void clearCacheFile(Context context, String pluginTag) {
        SharedPreferences spf = context.getSharedPreferences(pluginTag + MatrixUtil.getProcessName(context), Context.MODE_PRIVATE);
        spf.edit().clear().commit();
    }

    public static Plugin getSqlLiteLintPlugin() {
        return pluginMap.get(PluginInfo.SQL.TAG_PLUGIN);
    }

    public static Plugin getTracePlugin() {
        return pluginMap.get(PluginInfo.Trace.TAG_PLUGIN);
    }

    public static Plugin getIoPlugin() {
        return pluginMap.get(PluginInfo.IO.TAG_PLUGIN);
    }

    public static Plugin getResourcePlugin() {
        return pluginMap.get(PluginInfo.Resource.TAG_PLUGIN);
    }

}

package tech.sunyx.matrixhelper.params;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author by SunYuXing on 2019-07-14.
 */
@Builder
@ToString
@Getter
public class MatrixConfig {

    /**
     * 总开关
     */
    @Builder.Default
    private boolean matrixEnable = true;

    /*Trace 性能追踪 */

    /**
     * 帧数
     */
    @Builder.Default
    private boolean fpsEnable = true;
    /**
     * Anr
     */
    @Builder.Default
    private boolean anrTraceEnable = true;
    /**
     * 启动耗时
     */
    @Builder.Default
    private boolean startupEnable = true;
    /**
     * 慢方法
     */
    @Builder.Default
    private boolean evilMethodEnable = true;
    /**
     * 指定LauncherActivity的完整类名
     */
    private String splashActivity;
    /**
     * 调试模式
     */
    private boolean debug;
    /**
     * 开发设备
     */
    private boolean devEnv;

    /*resource 资源泄露*/


    /**
     * 开启 Hprof 文件 dump，会收到上传后的 Hprof 压缩包地址，不开启的话只会收到泄露简报
     */
    private boolean dumpHprof;
    /**
     * 调试侦测开关, 正常使用时不需要开启
     */
    private boolean detectDebug;

    /*io*/



    /*sqlite*/


}

package tech.sunyx.matrixhelper;

import lombok.Builder;

/**
 * @author by SunYuXing on 2019-07-14.
 */
@Builder
public class MatrixAllConfig {

    /**
     * 总开关
     */
    boolean matrixEnable;

    /*Trace 性能追踪 */

    /**
     * 性能追踪开关
     */
    boolean traceEnable;
    /**
     * 帧数
     */
    boolean fpsEnable;
    /**
     * Anr
     */
    boolean anrTraceEnable;
    /**
     * 启动耗时
     */
    boolean startupEnable;
    /**
     * 慢方法
     */
    boolean evilMethodEnable;
    /**
     * 指定LauncherActivity的完整类名
     */
    String splashActivity;
    /**
     * 调试模式
     */
    boolean debug;
    /**
     * 开发设备
     */
    boolean devEnv;

    /*resource 资源泄露*/

    /**
     * 资源泄露开关
     */
    boolean resourceEnable;

    /**
     * 开启 Hprof 文件 dump，会收到上传后的 Hprof 压缩包地址，不开启的话只会收到泄露简报
     */
    boolean dumpHprof;
    /**
     * 调试侦测开关, 正常使用时不需要开启
     */
    boolean detectDebug;

    /*io*/

    /**
     * io侦测开关
     */
    boolean ioEnable;


    /*sqlite*/

    /**
     * sql侦测开关
     */
    boolean sqlEnable;

}

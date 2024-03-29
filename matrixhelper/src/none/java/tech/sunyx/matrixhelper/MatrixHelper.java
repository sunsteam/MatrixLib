package tech.sunyx.matrixhelper;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;

import tech.sunyx.matrixhelper.params.InitConfig;

/**
 * @author by SunYuXing on 2019-07-14.
 */
public class MatrixHelper {

    static final String TAG = "MatrixHelper";

    static HashMap<String, Plugin> pluginMap = new HashMap<>();

    public static void init(Application context, InitConfig allConfig) {
        pluginMap.put(Plugin.TAG, new Plugin());
    }

    public static void clearCacheFile(Context context, String pluginTag) {

    }

    public static Plugin getSqlLiteLintPlugin() {
        return pluginMap.get(Plugin.TAG);
    }

    public static Plugin getTracePlugin() {
        return pluginMap.get(Plugin.TAG);
    }

    public static Plugin getIoPlugin() {
        return pluginMap.get(Plugin.TAG);
    }

    public static Plugin getResourcePlugin() {
        return pluginMap.get(Plugin.TAG);
    }
}


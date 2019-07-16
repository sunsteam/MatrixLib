package tech.sunyx.matrixhelper;

import com.tencent.mrs.plugin.IDynamicConfig;

import tech.sunyx.matrixhelper.params.DynamicConfigInterface;

/**
 * @author by SunYuXing on 2019-07-14.
 */
public class DelegateConfigImpl implements IDynamicConfig {
    private static final String TAG = "Matrix.DelegateConfigImpl";

    private DynamicConfigInterface realConfig;

    DelegateConfigImpl(DynamicConfigInterface realConfig) {
        this.realConfig = realConfig;
    }

    @Override
    public String get(String key, String def) {
        if (realConfig == null) {
            return def;
        }
        return realConfig.get(key, def);
    }

    @Override
    public int get(String key, int def) {
        if (realConfig == null) {
            return def;
        }
        return realConfig.get(key, def);
    }

    @Override
    public long get(String key, long def) {
        if (realConfig == null) {
            return def;
        }
        return realConfig.get(key, def);
    }

    @Override
    public boolean get(String key, boolean def) {
        if (realConfig == null) {
            return def;
        }
        return realConfig.get(key, def);
    }

    @Override
    public float get(String key, float def) {
        if (realConfig == null) {
            return def;
        }
        return realConfig.get(key, def);
    }
}

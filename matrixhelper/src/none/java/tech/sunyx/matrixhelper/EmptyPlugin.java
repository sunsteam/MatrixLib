package tech.sunyx.matrixhelper;

public class EmptyPlugin extends Plugin {

    public static final String TAG = "fake";

    EmptyPlugin(com.tencent.matrix.plugin.Plugin plugin) {
        super(plugin);
    }

    @Override
    public int getStatus() {
        return 0x08;
    }

    @Override
    public boolean isPluginStarted() {
        return false;
    }

    @Override
    public boolean isPluginStoped() {
        return true;
    }

    @Override
    public boolean isPluginDestroyed() {
        return true;
    }

    @Override
    public boolean isSupported() {
        return false;
    }

    @Override
    public String getTag() {
        return TAG;
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
    }
}

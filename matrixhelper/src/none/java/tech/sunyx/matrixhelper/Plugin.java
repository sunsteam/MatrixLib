package tech.sunyx.matrixhelper;

public class Plugin {

    public static final String TAG = "fake";

    public int getStatus() {
        return 0x08;
    }

    public boolean isPluginStarted() {
        return false;
    }

    public boolean isPluginStoped() {
        return true;
    }

    public boolean isPluginDestroyed() {
        return true;
    }

    public boolean isSupported() {
        return false;
    }

    public String getTag() {
        return TAG;
    }

    public void start() {
    }

    public void stop() {
    }

    public void destroy() {
    }
}

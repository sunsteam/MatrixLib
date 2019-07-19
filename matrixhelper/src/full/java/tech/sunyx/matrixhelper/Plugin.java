package tech.sunyx.matrixhelper;

public class Plugin {

    private com.tencent.matrix.plugin.Plugin plugin;

    Plugin(com.tencent.matrix.plugin.Plugin plugin) {
        this.plugin = plugin;
    }

    com.tencent.matrix.plugin.Plugin getRealPlugin() {
        return plugin;
    }

    public int getStatus() {
        return plugin.getStatus();
    }

    public boolean isPluginStarted() {
        return plugin.isPluginStarted();
    }

    public boolean isPluginStoped() {
        return plugin.isPluginStoped();
    }

    public boolean isPluginDestroyed() {
        return plugin.isPluginDestroyed();
    }

    public boolean isSupported() {
        return plugin.isSupported();
    }

    public String getTag() {
        return plugin.getTag();
    }

    public void start() {
        plugin.start();
    }

    public void stop() {
        plugin.stop();
    }

    public void destroy() {
        plugin.destroy();
    }
}

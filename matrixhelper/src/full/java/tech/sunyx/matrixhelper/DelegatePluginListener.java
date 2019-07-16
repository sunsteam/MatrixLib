package tech.sunyx.matrixhelper;

import android.content.Context;

import com.tencent.matrix.plugin.DefaultPluginListener;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.report.Issue;

/**
 * @author by SunYuXing on 2019-07-15.
 */
public class DelegatePluginListener extends DefaultPluginListener {

    private static final String TAG = "DelegatePluginListener";
    /**
     * real callback
     */
    private MatrixListener listener;

    DelegatePluginListener(Context context, MatrixListener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    public void onReportIssue(Issue issue) {
        super.onReportIssue(issue);
        if (listener != null) {
            listener.onReportIssue(new tech.sunyx.matrixhelper.Issue(issue));
        }
    }

    @Override
    public void onInit(Plugin plugin) {
        super.onInit(plugin);
        if (listener != null) {
            listener.onInit(MatrixHelper.pluginMap.get(plugin.getTag()));
        }
    }

    @Override
    public void onStart(Plugin plugin) {
        super.onStart(plugin);
        if (listener != null) {
            listener.onStart(MatrixHelper.pluginMap.get(plugin.getTag()));
        }
    }

    @Override
    public void onStop(Plugin plugin) {
        super.onStop(plugin);
        if (listener != null) {
            listener.onStop(MatrixHelper.pluginMap.get(plugin.getTag()));
        }
    }

    @Override
    public void onDestroy(Plugin plugin) {
        super.onDestroy(plugin);
        if (listener != null) {
            listener.onDestroy(MatrixHelper.pluginMap.get(plugin.getTag()));
        }
    }
}
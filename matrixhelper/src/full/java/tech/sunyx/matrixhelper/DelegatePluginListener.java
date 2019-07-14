package tech.sunyx.matrixhelper;

import android.content.Context;

import com.tencent.matrix.plugin.DefaultPluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.util.MatrixLog;

import java.lang.ref.SoftReference;

/**
 *
 *
 * @author by SunYuXing on 2019-07-15.
 */
public class DelegatePluginListener extends DefaultPluginListener {

    private static final String TAG = "DelegatePluginListener";

    DelegatePluginListener(Context context) {
        super(context);
    }

    @Override
    public void onReportIssue(Issue issue) {
        super.onReportIssue(issue);
        MatrixLog.e(TAG, issue.toString());

    }


}
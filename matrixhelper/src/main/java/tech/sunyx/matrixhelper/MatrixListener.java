package tech.sunyx.matrixhelper;


/**
 * 回调
 *
 * @author by SunYuXing on 2019-07-16.
 */
public abstract class MatrixListener {

    public void onInit(Plugin plugin){}

    public void onStart(Plugin plugin){}

    public void onStop(Plugin plugin){}

    public void onDestroy(Plugin plugin){}

    public abstract void onReportIssue(Issue issue);
}

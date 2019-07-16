package tech.sunyx.matrixhelper;


/**
 * 回调
 *
 * @author by SunYuXing on 2019-07-16.
 */
public abstract class MatrixListener {

    void onInit(Plugin plugin){}

    void onStart(Plugin plugin){}

    void onStop(Plugin plugin){}

    void onDestroy(Plugin plugin){}

    abstract void onReportIssue(Issue issue);
}

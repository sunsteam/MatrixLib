package tech.sunyx.matrixhelper;

import android.app.Application;

/**
 * @author by SunYuXing on 2019-07-14.
 */
public abstract class BaseMatrixHelper {

    static final String TAG = "MatrixHelper";

    public abstract void init(Application context, String splashName);
}

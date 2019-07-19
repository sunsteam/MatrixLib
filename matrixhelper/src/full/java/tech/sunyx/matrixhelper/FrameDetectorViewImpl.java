package tech.sunyx.matrixhelper;

import android.content.Context;

import com.tencent.matrix.trace.view.FrameDecorator;

public class FrameDetectorViewImpl implements FrameDetectorView {

    private FrameDecorator decorator;

    public FrameDetectorViewImpl(Context context) {
        decorator = FrameDecorator.create(context);
    }

    @Override
    public void show() {
        decorator.show();
    }

    @Override
    public void dismiss() {
        if (decorator != null) {
            decorator.dismiss();
        }
    }
}

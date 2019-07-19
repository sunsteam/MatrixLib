package tech.sunyx.matrixhelper;


public interface FrameDetectorView {

    void show();

    /**
     * 界面退出时必须要释放
     */
    void dismiss();
}

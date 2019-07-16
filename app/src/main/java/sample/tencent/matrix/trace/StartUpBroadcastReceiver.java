package sample.tencent.matrix.trace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static sample.tencent.matrix.MatrixApplication.getContext;

public class StartUpBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "StartUpeceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "[onReceive]");
        getContext().startActivity(new Intent(getContext(), TestOtherProcessActivity.class));
    }
}

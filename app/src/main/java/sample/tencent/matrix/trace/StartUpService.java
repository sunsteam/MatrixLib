package sample.tencent.matrix.trace;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class StartUpService extends Service {
    private static String TAG = "Matrix.StartUpService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "[onStartCommand]");
        return super.onStartCommand(intent, flags, startId);
    }
}

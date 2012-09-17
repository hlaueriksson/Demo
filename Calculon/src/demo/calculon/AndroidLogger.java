package demo.calculon;

import android.util.Log;

public class AndroidLogger implements Logger {
    private static final String TAG = AndroidLogger.class.getSimpleName();

    @Override
    public void debug(String message) {
        Log.d(TAG, message);
    }
}

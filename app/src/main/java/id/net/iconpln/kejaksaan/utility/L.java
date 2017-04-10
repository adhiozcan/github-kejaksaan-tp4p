package id.net.iconpln.kejaksaan.utility;

import android.util.Log;

/**
 * Created by Ozcan on 15/03/2017.
 */

public class L {
    private static final String TAG = "[DEMO]";

    public static void d(String msg, Object... args) {
        Log.d(TAG, String.format(msg, args));
    }

    public static void e(Throwable t, String msg, Object... args) {
        Log.e(TAG, String.format(msg, args), t);
    }
}

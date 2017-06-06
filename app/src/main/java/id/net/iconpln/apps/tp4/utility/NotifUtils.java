package id.net.iconpln.apps.tp4.utility;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;


import id.net.iconpln.apps.tp4.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Ozcan on 18/04/2017.
 */

public class NotifUtils {
    public static void showMessage(Context context) {
        Toast.makeText(context, "Ini notifikasi", Toast.LENGTH_SHORT).show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void notification(Context context) {
        NotificationManager nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Kejaksaan RI")
                .setContentText("Ada 5 berita baru yang belum dibaca")
                .build();
        nm.notify(0, notification);
    }
}
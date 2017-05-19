package id.net.iconpln.apps.tp4;

import android.app.Application;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;

import id.net.iconpln.apps.tp4.model.UserProfile;

/**
 * Created by Ozcan on 09/03/2017.
 */

public class KejaksaanApp extends Application {
    public static String      userId;
    public static String      kejaksaanId;
    public static UserProfile profile;

    static {
        userId = "";
        kejaksaanId = "";
        profile = new UserProfile();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }
}

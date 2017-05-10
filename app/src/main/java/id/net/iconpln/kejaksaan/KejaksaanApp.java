package id.net.iconpln.kejaksaan;

import android.app.Application;
import android.support.design.widget.BottomSheetBehavior;

import id.net.iconpln.kejaksaan.model.UserProfile;

/**
 * Created by Ozcan on 09/03/2017.
 */

public class KejaksaanApp extends Application {
    public static String      LOGIN_ID       = "";
    public static String      LOGIN_NAME     = "";
    public static String      KEJAKSAAN_ID   = "";
    public static String      KEJAKSAAN_NAME = "";
    public static UserProfile PROFILE        = new UserProfile();
}

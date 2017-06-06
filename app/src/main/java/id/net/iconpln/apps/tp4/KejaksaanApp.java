package id.net.iconpln.apps.tp4;

import android.app.Application;
import android.net.Uri;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;

import id.net.iconpln.apps.tp4.model.UserProfile;
import okhttp3.MultipartBody;

/**
 * Created by Ozcan on 09/03/2017.
 */

public class KejaksaanApp extends Application {
    public static String      userId;
    public static String      kejaksaanId;
    public static String      noRegistrasi;
    public static String      noProyek;
    public static String      anev;
    public static String      uraian;
    public static String      sequence;
    public static String      namaPhoto;
    public static Uri         filePhoto;
    public static UserProfile profile;

    static {
        userId = "";
        kejaksaanId = "";
        noRegistrasi = "";
        noProyek = "";
        anev = "";
        uraian = "";
        sequence = "";
        namaPhoto = "";
        profile = new UserProfile();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }
}

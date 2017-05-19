package id.net.iconpln.apps.tp4;

import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import id.net.iconpln.apps.tp4.model.UserProfile;

/**
 * Created by Ozcan on 19/05/2017.
 */

public class Config {

    public static class User {
        public static boolean isAlwaysRemember() {
            boolean isRemember = Hawk.get("app.user.remember", false);
            return isRemember;
        }

        public static void setAlwaysRemember(boolean remember) {
            Hawk.put("app.user.remember", remember);
        }

        public static void saveLocalInfoUser(UserProfile userProfile) {
            String user = new Gson().toJson(userProfile);
            Hawk.put("app.user.profile", user);
        }

        public static UserProfile getLocalInfoUser() {
            String      userLocal = Hawk.get("app.user.profile", "");
            UserProfile user      = new Gson().fromJson(userLocal, UserProfile.class);
            return user;
        }

    }
}

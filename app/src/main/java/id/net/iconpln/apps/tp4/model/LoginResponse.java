package id.net.iconpln.apps.tp4.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 15/03/2017.
 */

public class LoginResponse {
    @SerializedName("success")
    private String      isSuccess;
    @SerializedName("profile")
    private UserProfile userProfile;

    public boolean getIsSuccess() {
        if (isSuccess.equals("1")) return true;
        return false;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}

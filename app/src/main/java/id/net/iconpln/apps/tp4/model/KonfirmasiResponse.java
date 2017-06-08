package id.net.iconpln.apps.tp4.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 02/06/2017.
 */

public class KonfirmasiResponse {
    @SerializedName("STATUS")
    public String status;
    @SerializedName("MESSAGE")
    public String message;
    @SerializedName("IS_ACCEPTED")
    public String acceptStatus;

    @Override
    public String toString() {
        return "KonfirmasiResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", isAccepted=" + acceptStatus +
                '}';
    }
}


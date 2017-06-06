package id.net.iconpln.apps.tp4.utility;

import android.net.Uri;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;

/**
 * Created by Ozcan on 02/06/2017.
 */

public class RequestBody {

    public static okhttp3.RequestBody create(String name) {
        return okhttp3.RequestBody.create(MediaType.parse("multipart/form-data"), name);
    }

    public static MultipartBody.Part createImage(Uri fileUri) {
        File mediaFile = new File(fileUri.getPath()).getAbsoluteFile();
        return MultipartBody.Part.createFormData(
                "file",
                mediaFile.getName(),
                okhttp3.RequestBody.create(MediaType.parse("image/*"), mediaFile)
        );
    }
}

package id.net.iconpln.apps.tp4.utility;

import android.os.Environment;

import java.io.File;

/**
 * Created by Ozcan on 31/05/2017.
 */

public class BaseAlbumDirFactory {
    // Standard storage location for digital camera files
    private static final String CAMERA_DIR = "/dcim/";

    public File getAlbumStorageDir(String albumName) {
        return new File(
                Environment.getExternalStorageDirectory()
                        + CAMERA_DIR
                        + albumName
        );
    }
}

package id.net.iconpln.apps.tp4.utility;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ozcan on 31/05/2017.
 */

public class CameraUtils {
    private static BaseAlbumDirFactory mAlbumStorageDirFactory;
    private static String              mCurrentPhotoPath;

    private static final String JPEG_FILE_PREFIX    = "FSO_";
    private static final String JPEG_FILE_SUFFIX    = ".jpg";
    private static final int    IMG_WIDTH           = 640;
    private static final int    IMG_HEIGHT          = 480;
    private static       int    COMPRESSION_QUALITY = 100;

    private static String getAlbumName() {
        return "FSO";
    }

    private static File getAlbumDir() {
        File storageDir = null;

        if (null == mAlbumStorageDirFactory)
            mAlbumStorageDirFactory = new BaseAlbumDirFactory();

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

            storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());

            if (storageDir != null) {
                if (!storageDir.mkdirs()) {
                    if (!storageDir.exists()) {
                        L.d("failed to create directory");
                        return null;
                    }
                }
            }

        } else {
            L.d("External storage is not mounted READ/WRITE.");
        }

        return storageDir;
    }

    public static File createImageFile() {
        // Create an image file name
        String timeStamp     = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_";
        File   image         = null;
        try {
            image = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, getAlbumDir());
        } catch (IOException e) {
            L.e(e, "Failed to get image physical file");
        }
        return image;
    }

    public static File setUpPhotoFile() {
        File f = createImageFile();
        mCurrentPhotoPath = f.getAbsolutePath();
        if (null == f) return null;
        return f;
    }

    public static void galleryAddPic(AppCompatActivity activity, String photoPath) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File   f               = new File(photoPath);
        Uri    contentUri      = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        activity.sendBroadcast(mediaScanIntent);
    }

    public static Bitmap setOptimumPict(Context context, Uri photoPath) {
        Log.d("Photo Image", "\n[Starting]-------------------------------------------------");
        Log.d("Photo Image", "[Step 1/3] Preparing, CQ " + COMPRESSION_QUALITY);

        Bitmap bitmap = CameraUtils.uriToBitmap(context, Uri.parse("file://" + photoPath));
        bitmap = scaleDown(bitmap, IMG_HEIGHT, IMG_WIDTH);
        bitmap = compressImage(bitmap);
        resetCompressionQuality();
        Log.d("Photo Image", "Compression finish, reset the compression quality to default " + COMPRESSION_QUALITY);
        return bitmap;
    }

    private static Bitmap scaleDown(Bitmap bitmap, int height, int width) {
        Log.d("Photo Image", "[Step 2/3] Scaling");
        return Bitmap.createScaledBitmap(bitmap, height, width, true);
    }

    private static Bitmap compressImage(Bitmap bitmap) {
        Log.d("Photo Image", "[Step 3/3] Compression, CQ " + COMPRESSION_QUALITY);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteFormat = stream.toByteArray();

        for (int i = 0; i < 12; i++) {
            ByteArrayOutputStream streamCompressed = new ByteArrayOutputStream();
            if (byteFormat.length > 21048) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, COMPRESSION_QUALITY, streamCompressed);
                byteFormat = streamCompressed.toByteArray();
                COMPRESSION_QUALITY -= 5;

                Log.d("Photo Image", "\t|---Compress on Iteration " + i + " with compression level "
                        + COMPRESSION_QUALITY + "\t\tResult size " + byteFormat.length / 1024 + " kb");
            }
        }

        InputStream           inputStream = new ByteArrayInputStream(byteFormat);
        BitmapFactory.Options option      = new BitmapFactory.Options();
        bitmap = BitmapFactory.decodeStream(inputStream, null, option);
        return bitmap;
    }

    private static byte[] getBitmapByteArray(Bitmap bitmap) {
        Log.d("Photo Image", "[Step 3/3] Get The Result");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, COMPRESSION_QUALITY, stream);
        byte[] byteFormat = stream.toByteArray();
        Log.d("Photo Image", "\t|---Final Size " + byteFormat.length / 1024 + "kb");
        return byteFormat;
    }

    private static void resetCompressionQuality() {
        CameraUtils.COMPRESSION_QUALITY = 100;
    }

    /**
     * Get image from uri
     *
     * @param context
     * @param selectedFileUri
     * @return
     */
    public static Bitmap uriToBitmap(Context context, Uri selectedFileUri) {
        Bitmap image = null;
        try {
            InputStream image_stream;
            try {
                image_stream = context.getContentResolver().openInputStream(selectedFileUri);
                image = BitmapFactory.decodeStream(image_stream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}

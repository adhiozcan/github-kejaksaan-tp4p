package id.net.iconpln.apps.tp4.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.KejaksaanApp;
import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.Anev;
import id.net.iconpln.apps.tp4.model.WalmanPhotoResponse;
import id.net.iconpln.apps.tp4.model.WalmanResponse;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.BeautifulProgressDialog;
import id.net.iconpln.apps.tp4.utility.CameraUtils;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.utility.L;
import id.net.iconpln.apps.tp4.utility.NetworkUtil;
import id.net.iconpln.apps.tp4.utility.RequestBody;
import okhttp3.MultipartBody;

/**
 * Created by Ozcan on 16/03/2017.
 */

public class WalmanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final String TAG = WalmanActivity.class.getSimpleName();

    private static final int CAMERA_REQUEST_CODE_1 = 111;
    private static final int CAMERA_REQUEST_CODE_2 = 112;
    private static final int CAMERA_REQUEST_CODE_3 = 113;
    private static final int CAMERA_REQUEST_CODE_4 = 114;

    private BeautifulProgressDialog mProgressDialog;

    private EditText edNoProyek;
    private EditText edNoRegistrasi;
    private EditText edJudul;
    private EditText edUraian;

    private Spinner      spnAnev;
    private ArrayAdapter mAdapter;
    private List<String> mAnev;

    private ImageView imgPhoto1;
    private ImageView imgPhoto2;
    private ImageView imgPhoto3;
    private ImageView imgPhoto4;

    private FieldValue mFieldValue;

    private File mPhotoFile;

    private boolean updateStatus = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_input_walman);
        CommonUtils.installToolbar(this);

        mFieldValue = new FieldValue();

        edNoProyek = (EditText) findViewById(R.id.ed_noproyek);
        edNoRegistrasi = (EditText) findViewById(R.id.ed_noreg);
        edJudul = (EditText) findViewById(R.id.ed_judul);
        edUraian = (EditText) findViewById(R.id.ed_uraian);
        spnAnev = (Spinner) findViewById(R.id.anev);

        mAnev = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mAnev);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAnev.setOnItemSelectedListener(this);
        spnAnev.setAdapter(mAdapter);

        mProgressDialog = new BeautifulProgressDialog(this);
        mProgressDialog.setMessage("Mengunggah laporan, harap tunggu...");

        imgPhoto1 = (ImageView) findViewById(R.id.photo1);
        imgPhoto2 = (ImageView) findViewById(R.id.photo2);
        imgPhoto3 = (ImageView) findViewById(R.id.photo3);
        imgPhoto4 = (ImageView) findViewById(R.id.photo4);

        edNoProyek.setText(KejaksaanApp.noProyek);
        edNoRegistrasi.setText(KejaksaanApp.noRegistrasi);

        if (NetworkUtil.isConnectToInternet(this)) {
            getDataAnevFromNetwork();
        }
    }

    private void getDataAnevFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.ANEV);
        request.execute(new ResponseListener<Anev[]>() {
            @Override
            public void onResponse(Anev[] response) {
                mAnev.clear();
                for (Anev anev : response) {
                    mAnev.add(anev.getNama());
                }
                mAdapter.notifyDataSetChanged();
                spnAnev.setSelection(0);
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    public void onTakePictureClicked(View viewId) {
        switch (viewId.getId()) {
            case R.id.photo1:
                imgPhoto1.setImageResource(R.drawable.ic_camera);
                dispatchTakePictureIntent(CAMERA_REQUEST_CODE_1);
                break;
            case R.id.photo2:
                imgPhoto2.setImageResource(R.drawable.ic_camera);
                dispatchTakePictureIntent(CAMERA_REQUEST_CODE_2);
                break;
            case R.id.photo3:
                imgPhoto3.setImageResource(R.drawable.ic_camera);
                dispatchTakePictureIntent(CAMERA_REQUEST_CODE_3);
                break;
            case R.id.photo4:
                imgPhoto4.setImageResource(R.drawable.ic_camera);
                dispatchTakePictureIntent(CAMERA_REQUEST_CODE_4);
                break;
        }
    }

    private void dispatchTakePictureIntent(int camera) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            mPhotoFile = CameraUtils.setUpPhotoFile();

            if (null == mPhotoFile) {
                Toast.makeText(this, "Gagal mengakses camera dan storage Anda", Toast.LENGTH_SHORT).show();
                return;
            }

            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPhotoFile));
            startActivityForResult(takePictureIntent, camera);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == AppCompatActivity.RESULT_OK) {
            Bitmap bitmap = CameraUtils.setOptimumPict(WalmanActivity.this, Uri.fromFile(mPhotoFile));
            switch (requestCode) {
                case CAMERA_REQUEST_CODE_1:
                    imgPhoto1.setImageBitmap(bitmap);
                    imgPhoto1.setTag(Uri.fromFile(mPhotoFile));
                    break;

                case CAMERA_REQUEST_CODE_2:
                    imgPhoto2.setImageBitmap(bitmap);
                    imgPhoto2.setTag(Uri.fromFile(mPhotoFile));
                    break;

                case CAMERA_REQUEST_CODE_3:
                    imgPhoto3.setImageBitmap(bitmap);
                    imgPhoto3.setTag(Uri.fromFile(mPhotoFile));
                    break;

                case CAMERA_REQUEST_CODE_4:
                    imgPhoto4.setImageBitmap(bitmap);
                    imgPhoto4.setTag(Uri.fromFile(mPhotoFile));
                    break;
                default:
                    break;
            }
        }
    }

    public void onUpdateButtonClicked(View view) {
        if (!NetworkUtil.isConnectToInternet(this)) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.container_layout),
                    "Tidak ada jaringan internet",
                    Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.pink_A200));
            snackbar.show();
            return;
        }

        mFieldValue.grabFieldValue();
        uploadToServer();
    }


    private void uploadToServer() {
        mProgressDialog.show();

        KejaksaanApp.noRegistrasi = mFieldValue.noRegistrasi;
        KejaksaanApp.anev = mFieldValue.jenisPekerjaan;
        KejaksaanApp.uraian = mFieldValue.uraian;
        L.d("Param Field Value : " + mFieldValue.toString());

        if (attemptUploadData()) {
            attemptUploadPhoto();
        }
    }

    private boolean attemptUploadData() {
        updateStatus = true;
        RequestServer request = new RequestServer(ServiceUrl.WALMAN);
        request.execute(new ResponseListener<WalmanResponse>() {
            @Override
            public void onResponse(WalmanResponse response) {
                mProgressDialog.dismiss();
                if (response.status.equals("1")) {
                    updateStatus = true;
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.container_layout),
                            "Laporan berhasil diunggah",
                            Snackbar.LENGTH_LONG);
                    snackbar.getView().setBackgroundColor(
                            ContextCompat.getColor(WalmanActivity.this,
                                    R.color.light_green_500));
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.container_layout),
                            "Gagal mengunggah update laporan",
                            Snackbar.LENGTH_LONG);
                    snackbar.getView().setBackgroundColor(
                            ContextCompat.getColor(WalmanActivity.this, R.color.pink_A200)
                    );
                }
            }

            @Override
            public void onFailed(String message) {
                mProgressDialog.dismiss();
                updateStatus = false;
                Snackbar snackbar = Snackbar.make(findViewById(R.id.container_layout),
                        "Gagal mengunggah laporan, periksa jaringan Anda.",
                        Snackbar.LENGTH_LONG);
                snackbar.getView().setBackgroundColor(
                        ContextCompat.getColor(WalmanActivity.this,
                                R.color.pink_A200));
                snackbar.show();
            }
        });
        return updateStatus;
    }

    private boolean attemptUploadPhoto() {
        List<Uri> photoPath = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (!mFieldValue.foto[i].toString().equals("")) {
                photoPath.add(mFieldValue.foto[i]);
            }
        }

        for (int i = 0; i < photoPath.size(); i++) {
            Uri fileImage = photoPath.get(i);
            KejaksaanApp.sequence = "P" + String.valueOf(i + 1);
            KejaksaanApp.namaPhoto = fileImage.getLastPathSegment();
            KejaksaanApp.filePhoto = fileImage;

            RequestServer request = new RequestServer(ServiceUrl.WALMAN_UPLOAD_PHOTO);
            request.execute(new ResponseListener<WalmanPhotoResponse>() {
                @Override
                public void onResponse(WalmanPhotoResponse response) {
                    L.d("Status Upload Photo", response.status);
                    mPhotoFile.delete();
                }

                @Override
                public void onFailed(String message) {
                    L.d("Status Upload Photo", message);
                    mPhotoFile.delete();
                }
            });
        }
        WalmanActivity.this.finish();
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#ac455a64"));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private class FieldValue {
        public String judul;
        public String noRegistrasi;
        public String noProyek;
        public String jenisPekerjaan;
        public String uraian;
        public Uri[] foto = new Uri[4];

        public void grabFieldValue() {
            mFieldValue.judul = edJudul.getText().toString();
            mFieldValue.noRegistrasi = edNoRegistrasi.getText().toString();
            mFieldValue.noProyek = edNoProyek.getText().toString();
            mFieldValue.jenisPekerjaan = spnAnev.getSelectedItem().toString();
            mFieldValue.uraian = edUraian.getText().toString();
            mFieldValue.foto[0] = Uri.parse(imgPhoto1.getTag().toString());
            mFieldValue.foto[1] = Uri.parse(imgPhoto2.getTag().toString());
            mFieldValue.foto[2] = Uri.parse(imgPhoto3.getTag().toString());
            mFieldValue.foto[3] = Uri.parse(imgPhoto4.getTag().toString());
        }

        @Override
        public String toString() {
            return "FieldValue{" +
                    "judul='" + judul + '\n' +
                    ", noRegistrasi='" + noRegistrasi + '\n' +
                    ", noProyek='" + noProyek + '\n' +
                    ", jenisPekerjaan='" + jenisPekerjaan + '\n' +
                    ", uraian='" + uraian + '\n' +
                    ", foto=" + Arrays.toString(foto) +
                    '}';
        }
    }
}

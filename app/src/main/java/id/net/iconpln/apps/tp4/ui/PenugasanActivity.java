package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import id.net.iconpln.apps.tp4.KejaksaanApp;
import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.KonfirmasiResponse;
import id.net.iconpln.apps.tp4.model.Penugasan;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.utility.L;

/**
 * Created by Ozcan on 13/03/2017.
 */

public class PenugasanActivity extends AppCompatActivity {
    private static final String TAG = PenugasanActivity.class.getSimpleName();

    private Penugasan penugasan = new Penugasan();

    private TextView txtJudulPermohonan;
    private TextView txtTanggal;
    private TextView txtIdentitasPengirim;
    private TextView txtIdentitasPerusahaan;
    private TextView txtNilaiProyek;
    private TextView txtJadwalPaparan;
    private TextView btnKonfirmasi;

    private View boxInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penugasan);
        CommonUtils.installToolbar(this);

        txtJudulPermohonan = (TextView) findViewById(R.id.judul_permohonan);
        txtTanggal = (TextView) findViewById(R.id.tanggal);
        txtIdentitasPengirim = (TextView) findViewById(R.id.identitas_pengirim);
        txtIdentitasPerusahaan = (TextView) findViewById(R.id.identitas_perusahaan);
        txtNilaiProyek = (TextView) findViewById(R.id.nilai_proyek);
        txtJadwalPaparan = (TextView) findViewById(R.id.jadwal_paparan);
        btnKonfirmasi = (TextView) findViewById(R.id.btn_konfirmasi);
        boxInfo = findViewById(R.id.container_info);

        if (getIntent().getExtras() != null) {
            getDataFromIntent();
            setDataIntoView();
        }
    }

    private void setDataIntoView() {
        txtJudulPermohonan.setText(penugasan.getNamaProject());
        txtTanggal.setText(penugasan.getTanggalMasuk());
        txtIdentitasPengirim.setText(penugasan.getNamaPemohon());
        txtIdentitasPerusahaan.setText(penugasan.getInstansiPemohon());
        txtNilaiProyek.setText(penugasan.getNilai());
        txtJadwalPaparan.setText(penugasan.getTanggalPaparan());
    }

    private void getDataFromIntent() {
        Bundle data = getIntent().getExtras();
        penugasan.setNoProject(data.getString("no_proyek"));
        penugasan.setNoRegistrasi(data.getString("no_registrasi"));
        penugasan.setNamaProject(data.getString("nama_proyek"));
        penugasan.setTanggalMasuk(data.getString("tanggal_masuk"));
        penugasan.setTanggalPaparan(data.getString("tanggal_paparan"));
        penugasan.setNamaPemohon(data.getString("nama_pemohon"));
        penugasan.setInstansiPemohon(data.getString("instansi_pemohon"));
        penugasan.setKeterangan(data.getString("keterangan"));
        penugasan.setNilai(data.getString("nilai_proyek"));
        penugasan.setAccept(data.getBoolean("is_accept"));

        getPetugasConfirmStatus();
    }

    private void getPetugasConfirmStatus() {
        KejaksaanApp.noRegistrasi = penugasan.getNoRegistrasi();
        RequestServer request = new RequestServer(ServiceUrl.GET_KONFIRMASI);
        request.execute(new ResponseListener<KonfirmasiResponse[]>() {
            @Override
            public void onResponse(KonfirmasiResponse[] response) {
                L.d("Status Konfirmasi", response[0].toString());
                if (response[0].acceptStatus.equals("1")) {
                    btnKonfirmasi.setText("Anda telah terkonfirmasi");
                    btnKonfirmasi.setBackgroundColor(ContextCompat.getColor(PenugasanActivity.this, R.color.light_green_500));
                    btnKonfirmasi.setClickable(false);
                    btnKonfirmasi.setEnabled(false);
                    boxInfo.setVisibility(View.GONE);
                } else {
                    btnKonfirmasi.setText("Konfirmasi");
                    btnKonfirmasi.setClickable(true);
                    btnKonfirmasi.setEnabled(true);
                    boxInfo.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailed(String message) {
                L.d("Konfirmasi", message);
            }
        });
    }

    public void onConfirmButtonClicked(View viewId) {
        RequestServer request = new RequestServer(ServiceUrl.DO_KONFIRMASI);
        request.execute(new ResponseListener<KonfirmasiResponse[]>() {
            @Override
            public void onResponse(KonfirmasiResponse[] response) {
                L.d(TAG, response.toString());
                Snackbar snackbar = Snackbar.make(findViewById(R.id.container_layout),
                        "Konfirmasi berhasil dilakukan :)",
                        Snackbar.LENGTH_LONG);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(PenugasanActivity.this, R.color.pink_A200));
                snackbar.show();
                new CountDownTimer(3_500, 1_000) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        PenugasanActivity.this.finish();
                    }
                }.start();

            }

            @Override
            public void onFailed(String message) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.container_layout),
                        "Gagal melakukan konfirmasi, sesuatu terjadi dengan server. :(",
                        Snackbar.LENGTH_LONG);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(PenugasanActivity.this, R.color.pink_A200));
                snackbar.show();
            }
        });
    }
}

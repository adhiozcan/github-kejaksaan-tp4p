package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
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

/**
 * Created by Ozcan on 13/03/2017.
 */

public class PenugasanActivity extends AppCompatActivity {

    private Penugasan penugasan = new Penugasan();

    private TextView txtJudulPermohonan;
    private TextView txtTanggal;
    private TextView txtIdentitasPengirim;
    private TextView txtJadwalPaparan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penugasan);
        CommonUtils.installToolbar(this);

        txtJudulPermohonan = (TextView) findViewById(R.id.judul_permohonan);
        txtTanggal = (TextView) findViewById(R.id.tanggal);
        txtIdentitasPengirim = (TextView) findViewById(R.id.identitas_pengirim);
        txtJadwalPaparan = (TextView) findViewById(R.id.jadwal_paparan);

        if (getIntent().getExtras() != null) {
            getDataFromIntent();
            setDataIntoView();
        }
    }

    private void setDataIntoView() {
        txtJudulPermohonan.setText(penugasan.getNamaProject());
        txtTanggal.setText(penugasan.getTanggalMasuk());
        txtIdentitasPengirim.setText(penugasan.getNoProject() + " | " + penugasan.getNilai());
        txtJadwalPaparan.setText(penugasan.getTanggalMasuk());
    }

    private void getDataFromIntent() {
        Bundle data = getIntent().getExtras();
        penugasan.setNoProject(data.getString("no_proyek"));
        penugasan.setNoRegistrasi(data.getString("no_registrasi"));
        penugasan.setNamaProject(data.getString("nama_proyek"));
        penugasan.setTanggalMasuk(data.getString("tanggal_masuk"));
        penugasan.setKeterangan(data.getString("keterangan"));
        penugasan.setNilai(data.getString("nilai_proyek"));
        penugasan.setAccept(data.getBoolean("is_accept"));

        getPetugasConfirmStatus();
    }

    private void getPetugasConfirmStatus() {
        KejaksaanApp.noRegistrasi = penugasan.getNoRegistrasi();
        RequestServer request = new RequestServer(ServiceUrl.GET_KONFIRMASI);
        request.execute(new ResponseListener<KonfirmasiResponse>() {
            @Override
            public void onResponse(KonfirmasiResponse response) {
                //TODO show hide the button 'terima' by this condition in here
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    public void onConfirmButtonClicked(View viewId) {
        RequestServer request = new RequestServer(ServiceUrl.DO_KONFIRMASI);
        request.execute(new ResponseListener<KonfirmasiResponse>() {
            @Override
            public void onResponse(KonfirmasiResponse response) {
                Toast.makeText(PenugasanActivity.this, "Konfirmasi berhasil dilakukan", Toast.LENGTH_SHORT).show();
                PenugasanActivity.this.finish();
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

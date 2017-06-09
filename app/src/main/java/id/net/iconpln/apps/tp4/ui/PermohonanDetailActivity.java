package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.Permohonan;
import id.net.iconpln.apps.tp4.utility.CommonUtils;

/**
 * Created by Ozcan on 07/03/2017.
 */

public class PermohonanDetailActivity extends AppCompatActivity {
    private TextView txtJudulPermohonan;
    private TextView txtTanggalMasuk;
    private TextView txtIdentitasPemohon;
    private TextView txtContent;
    private TextView txtKeterangan;
    private TextView txtJadwal;

    private View btnUnduhDokumen;

    private Permohonan permohonan = new Permohonan();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permohonan);
        CommonUtils.installToolbar(this);

        txtJudulPermohonan = (TextView) findViewById(R.id.judul_permohonan);
        txtTanggalMasuk = (TextView) findViewById(R.id.tanggal);
        txtIdentitasPemohon = (TextView) findViewById(R.id.identitas_pengirim);
        txtContent = (TextView) findViewById(R.id.content_permohonan);
        txtJadwal = (TextView) findViewById(R.id.jadwal_paparan);
        txtKeterangan = (TextView) findViewById(R.id.keterangan);
        btnUnduhDokumen = findViewById(R.id.btn_unduh_dokumen);

        System.out.println("Im Here !!! ----------");
        getIntentData();
    }

    private void getIntentData() {
        if (getIntent().getExtras() != null) {
            Bundle data = getIntent().getExtras();
            permohonan.setJudul(data.getString("judul_permohonan"));
            permohonan.setTanggalPermohonan(data.getString("tanggal"));
            permohonan.setPemohon(data.getString("identitas"));
            permohonan.setContent(data.getString("content"));
            permohonan.setTanggalPaparan(data.getString("jadwal"));
            permohonan.setKeterangan(data.getString("keterangan"));

            setDataIntoView();
        }
    }

    private void setDataIntoView() {
        txtJudulPermohonan.setText(permohonan.getJudul());
        txtTanggalMasuk.setText(permohonan.getTanggalPermohonan());
        txtIdentitasPemohon.setText(permohonan.getPemohon());
        txtContent.setText(permohonan.getContent());
        txtJadwal.setText(permohonan.getTanggalPaparan());
        txtKeterangan.setText(permohonan.getKeterangan());
    }
}

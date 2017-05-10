package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.ListBeritaAdapter;
import id.net.iconpln.kejaksaan.model.Berita;
import id.net.iconpln.kejaksaan.network.RequestServer;
import id.net.iconpln.kejaksaan.network.ResponseListener;
import id.net.iconpln.kejaksaan.network.ServiceUrl;
import id.net.iconpln.kejaksaan.utility.CommonUtils;

/**
 * Created by Ozcan on 17/03/2017.
 */

public class ListBeritaActivity extends AppCompatActivity {
    private ListBeritaAdapter mAdapter;
    private RecyclerView      mRecyclerView;

    private List<Berita> mBeritaList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_berita);
        CommonUtils.installToolbar(this);

        mBeritaList = new ArrayList<>();

        mAdapter = new ListBeritaAdapter(this, mBeritaList);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_berita);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));

        getDataFromNetwork();
    }

    private void getDataFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.BERITA);
        request.execute(new ResponseListener<Berita[]>() {
            @Override
            public void onResponse(Berita[] response) {
                mBeritaList.clear();
                mBeritaList.addAll(Arrays.asList(response));
                refreshAdapter();
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    private List<Berita> getDataFromLocal() {
        List<Berita> mockupList = new ArrayList<>();
        Berita       berita1    = new Berita();
        berita1.setJudulBerita("Sosialisasi TP4P Kejaksaan Agung RI Guna Mendukung Proyek Strategis di Kementrian PUPR di Surabaya");
        berita1.setTanggalTerbit("16 Maret 2017");
        berita1.setContent("Selayang pandang TP4 dan Pengawalan dan Pengamanan Proyek Strategis Nasional. Tindak Pidana Korupsi, Mekanisme pengadaan tanah bagi pembangunan untuk kepentingn Umum berdasarkan Undang-Undang No.2 Tahu  2004");

        Berita berita2 = new Berita();
        berita2.setJudulBerita("Sosialisasi TP4P Kejaksaan Agung RI di badan Kependudukan dan Keluarga Berencana Nasional Kantor Pusat");
        berita2.setTanggalTerbit("15 Maret 2017");
        berita2.setContent("Pengenalan Tim Pengawalan dan Pengamanan Pemerintahan dan Pembangunan dan Pengadaan Barang/Jasa Pemerintah berdasarkan Perpres No.54 Tahun 2010");

        Berita berita3 = new Berita();
        berita3.setJudulBerita("Sosialisasi TP4P Kejagung RI Guna Mendukung Proyek Ketenagalistrikan 35.000 MW di Surabaya");
        berita3.setTanggalTerbit("15 Maret 2017");
        berita3.setContent("Sosialisasi Tim TP4P untuk mendukung Proyek Ketenagalistrikan 35.000 MW pada Regional Jawa Bali. Strategi Pengawalan Proyek oleh TP4P");

        mockupList.add(berita1);
        mockupList.add(berita2);
        mockupList.add(berita3);

        return mockupList;
    }

    private void refreshAdapter() {
        mAdapter.notifyDataSetChanged();
    }
}

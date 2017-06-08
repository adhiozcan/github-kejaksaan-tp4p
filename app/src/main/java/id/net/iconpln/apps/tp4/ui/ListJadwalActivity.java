package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.adapter.ListJadwalAdapter;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.model.Jadwal;
import id.net.iconpln.apps.tp4.utility.L;

/**
 * Created by Ozcan on 09/03/2017.
 */

public class ListJadwalActivity extends AppCompatActivity {
    private ListJadwalAdapter mAdapter;
    private RecyclerView      mRecyclerView;

    private SwipeRefreshLayout mSwipeRefresh;

    private List<Jadwal> mJadwalList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal);
        CommonUtils.installToolbar(this);

        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        mJadwalList = new ArrayList<>();
        mAdapter = new ListJadwalAdapter(this, mJadwalList);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_daftar_jadwal);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));

        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataFromNetwork();
            }
        });

        getDataFromNetwork();
    }

    private void getDataFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.JADWAL);
        request.execute(new ResponseListener<Jadwal[]>() {
            @Override
            public void onResponse(Jadwal[] response) {
                mJadwalList.clear();
                mJadwalList.addAll(Arrays.asList(response));
                refrestData();
                mSwipeRefresh.setRefreshing(false);
            }

            @Override
            public void onFailed(String message) {
                mSwipeRefresh.setRefreshing(false);
                L.d("Get Data Berita", message);
            }
        });
    }

    private List<Jadwal> getDataFromLocal() {
        List<Jadwal> mockupList = new ArrayList<>();

        Jadwal jadwal1 = new Jadwal();
        jadwal1.setJadwalId("1");
        jadwal1.setNamaAgenda("Paparan Kementrian Sosial Terhadap Proyek Penutupan Seluruh Prostitusi Ilegal");
        jadwal1.setKeterangan("Permohonan yang diajukan Kementrian Sosial mengenai Pendampingan Hukum terhadap kebijakan yang akan dikeluarkan terhadap aturan penutupan seluruh prostitusi ilegal terfokus daerah Jakarta Selatan.");
        jadwal1.setLokasi("Aula Gd.1 Kementrian Sosial RI");
        jadwal1.setTanggal("08.00 WIB, 20 April 2017");
        jadwal1.createLokasidanTanggal();
        jadwal1.hitungJatuhTempo();

        Jadwal jadwal2 = new Jadwal();
        jadwal2.setJadwalId("2");
        jadwal2.setNamaAgenda("Paparan PLN mengenai Proyek 75.000 Giga Watt");
        jadwal2.setKeterangan("PLN mencanangkan proyek 75.000 Giga Watt untuk menerangi seluruh rakyat yang berada di Papua");
        jadwal2.setLokasi("Ruang Rapat, Lt. 10 Gd. Utama, PLN Pusat Trunojoyo");
        jadwal2.setTanggal("14.00 WIB, 20 April 2017");
        jadwal2.createLokasidanTanggal();
        jadwal2.hitungJatuhTempo();

        Jadwal jadwal3 = new Jadwal();
        jadwal3.setJadwalId("3");
        jadwal3.setNamaAgenda("Pengawalan Sidang Kasus Pencurian Listrik Massive Jabar");
        jadwal3.setKeterangan("Kuasa Hukum PLN melayangkan surat untuuk apps.tp4 melakukan kawal dalam proses sidang TIPIKOR Listrik di daerah Jawa Barat");
        jadwal3.setLokasi("Pengadilan Negri Jabar");
        jadwal3.setTanggal("10.00 WIB, 08 Mei 2017");
        jadwal3.createLokasidanTanggal();
        jadwal3.hitungJatuhTempo();

        mockupList.add(jadwal1);
        mockupList.add(jadwal2);
        mockupList.add(jadwal3);

        return mockupList;
    }

    private void refrestData() {
        mAdapter.notifyDataSetChanged();
    }
}

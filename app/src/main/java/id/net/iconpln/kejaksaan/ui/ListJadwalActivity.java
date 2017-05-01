package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.ListJadwalAdapter;
import id.net.iconpln.kejaksaan.model.Jadwal;
import id.net.iconpln.kejaksaan.utility.CommonUtils;

/**
 * Created by Ozcan on 09/03/2017.
 */

public class ListJadwalActivity extends AppCompatActivity {
    private ListJadwalAdapter mAdapter;
    private RecyclerView      mRecyclerView;

    private List<Jadwal> mJadwalList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_schedule);
        CommonUtils.installToolbar(this);

        mJadwalList = new ArrayList<>();
        mAdapter = new ListJadwalAdapter(this, provideListJadwalMockupModel());
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_daftar_jadwal);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));
    }

    private List<Jadwal> provideListJadwalMockupModel() {
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
        jadwal3.setKeterangan("Kuasa Hukum PLN melayangkan surat untuuk kejaksaan melakukan kawal dalam proses sidang TIPIKOR Listrik di daerah Jawa Barat");
        jadwal3.setLokasi("Pengadilan Negri Jabar");
        jadwal3.setTanggal("10.00 WIB, 08 Mei 2017");
        jadwal3.createLokasidanTanggal();
        jadwal3.hitungJatuhTempo();

        mockupList.add(jadwal1);
        mockupList.add(jadwal2);
        mockupList.add(jadwal3);

        return mockupList;
    }
}

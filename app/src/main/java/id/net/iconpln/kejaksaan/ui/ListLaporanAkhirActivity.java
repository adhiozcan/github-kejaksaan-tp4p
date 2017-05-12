package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.ListLaporanAkhirAdapter;
import id.net.iconpln.kejaksaan.model.LaporanAkhir;
import id.net.iconpln.kejaksaan.network.RequestServer;
import id.net.iconpln.kejaksaan.network.ResponseListener;
import id.net.iconpln.kejaksaan.network.ServiceUrl;
import id.net.iconpln.kejaksaan.utility.CommonUtils;

/**
 * Created by Ozcan on 01/05/2017.
 */

public class ListLaporanAkhirActivity extends AppCompatActivity {

    private List<LaporanAkhir>      laporanAkhirList;
    private ListLaporanAkhirAdapter mAdapter;
    private RecyclerView            mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_akhir);
        CommonUtils.installToolbar(this);

        laporanAkhirList = new ArrayList<>();
        mAdapter = new ListLaporanAkhirAdapter(this, laporanAkhirList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));
        //provideMockupDataMode();

        getDataFromNetwork();
    }

    private void getDataFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.LAPORAN_AKHIR);
        request.execute(new ResponseListener<LaporanAkhir[]>() {
            @Override
            public void onResponse(LaporanAkhir[] response) {
                laporanAkhirList.clear();
                laporanAkhirList.addAll(Arrays.asList(response));
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    private void provideMockupDataMode() {
        LaporanAkhir laporanAkhir = new LaporanAkhir();
        laporanAkhir.setNoProject("201701-TP4-01");
        laporanAkhir.setNamaProject("Sosialisasi TP4P Kejaksaan Agung RI Guna Mendukung Proyek Strategis di Kementrian PUPR di Surabaya");
        laporanAkhir.setTanggalTerbit("16 Januari 2017");
        laporanAkhir.setRingkasan("Selayang pandang TP4 dan Pengawalan dan Pengamanan Proyek Strategis Nasional. Tindak Pidana Korupsi, Mekanisme pengadaan tanah bagi pembangunan untuk kepentingn Umum berdasarkan Undang-Undang No.2 Tahu  2004");

        LaporanAkhir laporanAkhir2 = new LaporanAkhir();
        laporanAkhir2.setNoProject("201703-TP4-2");
        laporanAkhir2.setNamaProject("Sosialisasi TP4P Kejaksaan Agung RI di badan Kependudukan dan Keluarga Berencana Nasional Kantor Pusat");
        laporanAkhir2.setTanggalTerbit("18 Maret 2017");
        laporanAkhir2.setRingkasan("Pengenalan Tim Pengawalan dan Pengamanan Pemerintahan dan Pembangunan dan Pengadaan Barang/Jasa Pemerintah berdasarkan Perpres No.54 Tahun 2010");

        LaporanAkhir laporanAkhir3 = new LaporanAkhir();
        laporanAkhir3.setNoProject("2017-TP4-3");
        laporanAkhir3.setNamaProject("Sosialisasi TP4P Kejagung RI Guna Mendukung Proyek Ketenagalistrikan 35.000 MW di Surabaya");
        laporanAkhir3.setTanggalTerbit("19 April 2017");
        laporanAkhir3.setRingkasan("Sosialisasi Tim TP4P untuk mendukung Proyek Ketenagalistrikan 35.000 MW pada Regional Jawa Bali. Strategi Pengawalan Proyek oleh TP4P");

        laporanAkhirList.add(laporanAkhir);
        laporanAkhirList.add(laporanAkhir2);
        laporanAkhirList.add(laporanAkhir3);

        mAdapter.notifyDataSetChanged();
    }
}

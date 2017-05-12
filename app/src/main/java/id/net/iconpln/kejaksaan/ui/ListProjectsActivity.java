package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.kejaksaan.network.RequestServer;
import id.net.iconpln.kejaksaan.network.ResponseListener;
import id.net.iconpln.kejaksaan.network.ServiceUrl;
import id.net.iconpln.kejaksaan.utility.CommonUtils;
import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.ListProjectsAdapter;
import id.net.iconpln.kejaksaan.model.Proyek;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class ListProjectsActivity extends AppCompatActivity {

    private ListProjectsAdapter mAdapter;
    private RecyclerView        mRecyclerView;

    private List<Proyek> mProyekList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_projects);
        CommonUtils.installToolbar(this);

        mProyekList = new ArrayList<>();
        mAdapter = new ListProjectsAdapter(this, mProyekList);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_projects);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));

        getDataFromNetwork();
    }

    private void getDataFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.PROJECT);
        request.execute(new ResponseListener<Proyek[]>() {
            @Override
            public void onResponse(Proyek[] response) {
                mProyekList.clear();
                mProyekList.addAll(Arrays.asList(response));
                System.out.println(response.toString());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailed(String message) {

            }
        });

    }

    private List<Proyek> provideListProyekMockupModel() {
        List<Proyek> mockupList = new ArrayList<>();

        Proyek proyek = new Proyek();
        proyek.setNamaProject("Nama Proyek");
        proyek.setNamaPemohon("Nama Pemohon");
        proyek.setInstansiPemohon("Instansi Pemohon");
        proyek.setTanggalMasuk("23 Januari 2017");
        proyek.setLokasi("Alamat Proyek");
        proyek.setKeterangan(getString(R.string.ipsum));
        proyek.setDurasiPengerjaan("8 hari");

        for (int i = 0; i < 5; i++) {
            mockupList.add(proyek);
        }

        return mockupList;
    }

}

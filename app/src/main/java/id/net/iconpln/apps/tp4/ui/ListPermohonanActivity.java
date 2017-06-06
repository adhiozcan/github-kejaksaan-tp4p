package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.model.Permohonan;
import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.ui.fragment.ListPermohonanDitanganiFragment;
import id.net.iconpln.apps.tp4.ui.fragment.ListPermohonanDitolakFragment;
import id.net.iconpln.apps.tp4.ui.fragment.ListPermohonanMasukFragment;
import id.net.iconpln.apps.tp4.ui.fragment.ListPermohonanSelesaiFragment;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.adapter.PermohonanViewPagerAdapter;

/**
 * Created by Ozcan on 08/03/2017.
 */

public class ListPermohonanActivity extends AppCompatActivity {
    public static int TAB_PERMOHONAN_MASUK     = 0;
    public static int TAB_PERMOHONAN_DITANGANI = 1;
    public static int TAB_PERMOHONAN_SELESAI   = 2;
    public static int TAB_PERMOHONAN_DITOLAK   = 3;

    private ViewPager                  vp;
    private PermohonanViewPagerAdapter vpAdapter;
    private TabLayout                  tabLayout;

    private List<Fragment>   mFragmentList;
    private List<Permohonan> mPermohonanList;
    private List<Permohonan> mPermohonanMasuk;
    private List<Permohonan> mPermohonanDitangani;
    private List<Permohonan> mPermohonanSelesai;
    private List<Permohonan> mPermohonanDitolak;

    private int mTabPosition = 0;

    private void checkIntentData() {
        if (getIntent().getExtras() != null) {
            mTabPosition = getIntent().getExtras().getInt("tab_position", 0);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_permohonan);
        CommonUtils.installToolbar(this);

        mFragmentList = new ArrayList<>();
        mPermohonanMasuk = new ArrayList<>();
        mPermohonanDitangani = new ArrayList<>();
        mPermohonanSelesai = new ArrayList<>();
        mPermohonanDitolak = new ArrayList<>();

        vp = (ViewPager) findViewById(R.id.view_pager);
        vpAdapter = new PermohonanViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        vp.setAdapter(vpAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vp);

        checkIntentData();
        getDataFromNetwork();
    }

    private void setupFragment() {
        String listMasuk     = new Gson().toJson(mPermohonanMasuk);
        String listDitangani = new Gson().toJson(mPermohonanDitangani);
        String listSelesai   = new Gson().toJson(mPermohonanSelesai);
        String listDitolak   = new Gson().toJson(mPermohonanDitolak);
        mFragmentList.add(ListPermohonanMasukFragment.newInstance(listMasuk));
        mFragmentList.add(ListPermohonanDitanganiFragment.newInstance(listDitangani));
        mFragmentList.add(ListPermohonanSelesaiFragment.newInstance(listSelesai));
        mFragmentList.add(ListPermohonanDitolakFragment.newInstance(listDitolak));
        vp.getAdapter().notifyDataSetChanged();
        vp.setCurrentItem(mTabPosition);
    }

    private void getDataFromNetwork() {
        mPermohonanList = new ArrayList<>();
        RequestServer request = new RequestServer(ServiceUrl.DAFTAR_PERMOHONAN);
        request.execute(new ResponseListener<Permohonan[]>() {
            @Override
            public void onResponse(Permohonan[] response) {
                mPermohonanList.clear();
                mPermohonanList.addAll(Arrays.asList(response));
                categorizingPermohonan();
            }

            @Override
            public void onFailed(String message) {
            }
        });
    }

    private void categorizingPermohonan() {
        mPermohonanMasuk.clear();
        mPermohonanDitangani.clear();
        mPermohonanSelesai.clear();
        mPermohonanDitolak.clear();

        for (Permohonan permohonan : mPermohonanList) {
            switch (permohonan.getStatus()) {
                case "Masuk":
                    mPermohonanMasuk.add(permohonan);
                    break;
                case "Ditangani":
                    mPermohonanDitangani.add(permohonan);
                    break;
                case "Selesai":
                    mPermohonanSelesai.add(permohonan);
                    break;
                case "Ditolak":
                    mPermohonanDitolak.add(permohonan);
                    break;
            }
        }

        setupFragment();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


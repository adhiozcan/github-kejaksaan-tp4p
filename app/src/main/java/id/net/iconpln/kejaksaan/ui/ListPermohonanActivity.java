package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.kejaksaan.utility.CommonUtils;
import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.PermohonanViewPagerAdapter;

/**
 * Created by Ozcan on 08/03/2017.
 */

public class ListPermohonanActivity extends AppCompatActivity {

    private ViewPager                  vp;
    private PermohonanViewPagerAdapter vpAdapter;
    private TabLayout                  tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_permohonan);
        CommonUtils.installToolbar(this);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ListPermohonanMasukFragment());
        fragmentList.add(new ListPermohonanDiterimaFragment());
        fragmentList.add(new ListPermohonanDitolakFragment());

        vp = (ViewPager) findViewById(R.id.view_pager);
        vpAdapter = new PermohonanViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        vp.setAdapter(vpAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vp);
    }

}

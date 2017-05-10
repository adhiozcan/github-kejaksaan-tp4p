package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.kejaksaan.utility.CommonUtils;
import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.PermohonanViewPagerAdapter;

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

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ListPermohonanMasukFragment());
        fragmentList.add(new ListPermohonanDitanganiFragment());
        fragmentList.add(new ListPermohonanSelesaiFragment());
        fragmentList.add(new ListPermohonanDitolakFragment());

        vp = (ViewPager) findViewById(R.id.view_pager);
        vpAdapter = new PermohonanViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        vp.setAdapter(vpAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vp);

        checkIntentData();
        vp.setCurrentItem(mTabPosition);
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

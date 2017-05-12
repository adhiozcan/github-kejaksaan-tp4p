package id.net.iconpln.kejaksaan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Ozcan on 13/03/2017.
 */

public class PermohonanViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public PermohonanViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Masuk";
            case 1:
                return "Diterima";
            case 2:
                return "Selesai";
            case 3:
                return "Ditolak";
            default:
                return "Masuk";
        }
    }
}

package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.RekapProyekAdapter;
import id.net.iconpln.kejaksaan.model.Rekapitulasi;
import id.net.iconpln.kejaksaan.utility.CommonUtils;

/**
 * Created by Ozcan on 26/04/2017.
 */

public class RekapProyekActivity extends AppCompatActivity {
    private List<Rekapitulasi> mRekapList;
    private RekapProyekAdapter mAdapter;
    private RecyclerView       mRecycleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_proyek);
        CommonUtils.installToolbar(this);

        mRekapList = new ArrayList<>();
        mAdapter = new RekapProyekAdapter(mRekapList);
        mRecycleView = (RecyclerView) findViewById(R.id.rv_list_rekap_proyek);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));

        provideDummy();
    }

    private void provideDummy() {
        for (int i = 0; i < 10; i++) {
            Rekapitulasi rekap = new Rekapitulasi();
            rekap.setNomorProyek("TP4P-201704-" + (i + 4));
            rekap.setNamaProyek(getString(R.string.ipsum_short));
            rekap.setNilai("400M");

            mRekapList.add(rekap);
        }
        mAdapter.notifyDataSetChanged();
    }
}

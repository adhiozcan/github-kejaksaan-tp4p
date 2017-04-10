package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.kejaksaan.utility.CommonUtils;
import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.ListPenugasanAdapter;
import id.net.iconpln.kejaksaan.model.Penugasan;

/**
 * Created by Ozcan on 08/03/2017.
 */

public class ListPenugasanActivity extends AppCompatActivity {
    private ListPenugasanAdapter mAdapter;
    private RecyclerView         mRecyclerView;

    private List<Penugasan> mPenugasanList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_penugasan);
        CommonUtils.installToolbar(this);

        mPenugasanList = new ArrayList<>();
        mAdapter = new ListPenugasanAdapter(this, provideListPenugasanMockupModel());
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_penugasan);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));


    }

    private List<Penugasan> provideListPenugasanMockupModel() {
        List<Penugasan> mockupList = new ArrayList<>();

        Penugasan penugasan = new Penugasan();
        penugasan.setJudulPenugasan("Title Goes Here");
        penugasan.setContentPenugasan(getString(R.string.ipsum));

        for (int i = 0; i < 6; i++) {
            mockupList.add(penugasan);
        }

        return mockupList;
    }

}

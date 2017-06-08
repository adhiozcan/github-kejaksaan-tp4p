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
import id.net.iconpln.apps.tp4.adapter.ListPenugasanAdapter;
import id.net.iconpln.apps.tp4.model.Penugasan;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.utility.L;
import id.net.iconpln.apps.tp4.utility.QueryUtils;

/**
 * Created by Ozcan on 08/03/2017.
 */

public class ListPenugasanActivity extends AppCompatActivity {
    private ListPenugasanAdapter mAdapter;
    private RecyclerView         mRecyclerView;

    private List<Penugasan> mPenugasanList;

    private SwipeRefreshLayout mSwipeRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_penugasan);
        CommonUtils.installToolbar(this);

        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        //mPenugasanList = new ArrayList<>(QueryUtils.provideListPenugasanData(this));
        mPenugasanList = new ArrayList<>();
        mAdapter = new ListPenugasanAdapter(this, mPenugasanList);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_penugasan);
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
        RequestServer request = new RequestServer(ServiceUrl.PENUGASAN);
        request.execute(new ResponseListener<Penugasan[]>() {
            @Override
            public void onResponse(Penugasan[] response) {
                mPenugasanList.clear();
                mPenugasanList.addAll(Arrays.asList(response));
                refreshAdapter();
                mSwipeRefresh.setRefreshing(false);
            }

            @Override
            public void onFailed(String message) {
                L.d("Get Data Berita", message);
                mSwipeRefresh.setRefreshing(false);
            }
        });
    }


    private void refreshAdapter() {
        mAdapter.notifyDataSetChanged();
    }

}

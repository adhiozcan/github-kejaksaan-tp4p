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
import id.net.iconpln.apps.tp4.adapter.ListBeritaAdapter;
import id.net.iconpln.apps.tp4.model.Berita;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.utility.L;
import id.net.iconpln.apps.tp4.utility.QueryUtils;

/**
 * Created by Ozcan on 17/03/2017.
 */

public class ListBeritaActivity extends AppCompatActivity {
    private ListBeritaAdapter mAdapter;
    private RecyclerView      mRecyclerView;

    private SwipeRefreshLayout mSwipeRefresh;

    private List<Berita> mBeritaList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_berita);
        CommonUtils.installToolbar(this);

        //mBeritaList = new ArrayList<>(QueryUtils.provideListBerita());
        mBeritaList = new ArrayList<>();

        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mAdapter = new ListBeritaAdapter(this, mBeritaList);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_berita);
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
        RequestServer request = new RequestServer(ServiceUrl.BERITA);
        request.execute(new ResponseListener<Berita[]>() {
            @Override
            public void onResponse(Berita[] response) {
                mBeritaList.clear();
                mBeritaList.addAll(Arrays.asList(response));
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

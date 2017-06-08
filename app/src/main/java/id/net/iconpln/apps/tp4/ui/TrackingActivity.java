package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.adapter.ListBeritaAdapter;
import id.net.iconpln.apps.tp4.adapter.TrackingAdapter;
import id.net.iconpln.apps.tp4.model.TrackingProject;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.utility.L;

/**
 * Created by Ozcan on 29/05/2017.
 */

public class TrackingActivity extends AppCompatActivity {

    private TrackingAdapter       mAdapter;
    private RecyclerView          mRecyclerView;
    private List<TrackingProject> mTrackingList;

    private View txtNoData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_laporan);
        CommonUtils.installToolbar(this);

        mTrackingList = new ArrayList<>();
        mAdapter = new TrackingAdapter(mTrackingList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));

        txtNoData = findViewById(R.id.no_data);
        txtNoData.setVisibility(View.VISIBLE);

        getDataFromNetwork();
    }

    private void getDataFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.TRACKING);
        request.execute(new ResponseListener<TrackingProject[]>() {
            @Override
            public void onResponse(TrackingProject[] response) {
                mTrackingList.clear();
                mTrackingList.addAll(Arrays.asList(response));
                mAdapter.notifyDataSetChanged();

                if (response.length > 0)
                    txtNoData.setVisibility(View.GONE);
            }

            @Override
            public void onFailed(String message) {
                L.d("Get Data Berita", message);
                txtNoData.setVisibility(View.VISIBLE);
            }
        });
    }


}

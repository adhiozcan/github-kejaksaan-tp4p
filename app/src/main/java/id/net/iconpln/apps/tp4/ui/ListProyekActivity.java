package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.adapter.ListProyekAdapter;
import id.net.iconpln.apps.tp4.model.Proyek;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.utility.QueryUtils;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class ListProyekActivity extends AppCompatActivity {

    private ListProyekAdapter mAdapter;
    private RecyclerView      mRecyclerView;

    private List<Proyek> mProyekList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_proyek);
        CommonUtils.installToolbar(this);

        //mProyekList = new ArrayList<>(QueryUtils.provideListProyekData(this));
        mProyekList = new ArrayList<>();

        mAdapter = new ListProyekAdapter(this, mProyekList);
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
}

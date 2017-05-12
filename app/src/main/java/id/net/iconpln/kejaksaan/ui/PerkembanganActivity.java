package id.net.iconpln.kejaksaan.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.db.chart.view.LineChartView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.RekapProyekAdapter;
import id.net.iconpln.kejaksaan.model.Rekapitulasi;
import id.net.iconpln.kejaksaan.network.RequestServer;
import id.net.iconpln.kejaksaan.network.ResponseListener;
import id.net.iconpln.kejaksaan.network.ServiceUrl;
import id.net.iconpln.kejaksaan.utility.CommonUtils;

public class PerkembanganActivity extends AppCompatActivity {
    private List<Rekapitulasi> mRekapList;
    private RekapProyekAdapter mAdapter;
    private RecyclerView       mRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perkembangan);

        initToolbar();
        initView();
        getDataFromNetwork();
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Perkembangan");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initView(){
        mRekapList = new ArrayList<>();
        mAdapter = new RekapProyekAdapter(mRekapList);
        mAdapter.setOnItemSelected(new RekapProyekAdapter.OnItemSelected() {
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(getApplicationContext(), HistoryPerkembanganActivity.class)
                             .putExtra("data", mRekapList.get(position)));

            }
        });
        mRecycleView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));
    }

    private void getDataFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.PROJECT_SUMMARY_DETAIL);
        request.execute(new ResponseListener<Rekapitulasi[]>() {
            @Override
            public void onResponse(Rekapitulasi[] response) {
                mRekapList.clear();
                mRekapList.addAll(Arrays.asList(response));
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailed(String message) {

            }
        });

    }

}

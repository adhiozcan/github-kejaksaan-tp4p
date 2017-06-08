package id.net.iconpln.apps.tp4.ui;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.adapter.ListLaporanAkhirAdapter;
import id.net.iconpln.apps.tp4.model.LaporanAkhir;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.utility.L;
import id.net.iconpln.apps.tp4.utility.QueryUtils;

/**
 * Created by Ozcan on 01/05/2017.
 */

public class ListLaporanAkhirActivity extends AppCompatActivity {

    private List<LaporanAkhir>      laporanAkhirList;
    private ListLaporanAkhirAdapter mAdapter;
    private RecyclerView            mRecyclerView;

    private SwipeRefreshLayout mSwipeRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_akhir);
        CommonUtils.installToolbar(this);

        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        //laporanAkhirList = new ArrayList<>(QueryUtils.provideLaporanAkhirList());
        laporanAkhirList = new ArrayList<>();

        mAdapter = new ListLaporanAkhirAdapter(this, laporanAkhirList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));
        //provideMockupDataMode();

        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataFromNetwork();
            }
        });

        getDataFromNetwork();
    }

    private void getDataFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.LAPORAN_AKHIR);
        request.execute(new ResponseListener<LaporanAkhir[]>() {
            @Override
            public void onResponse(LaporanAkhir[] response) {
                laporanAkhirList.clear();
                laporanAkhirList.addAll(Arrays.asList(response));
                mAdapter.notifyDataSetChanged();
                mSwipeRefresh.setRefreshing(false);
            }

            @Override
            public void onFailed(String message) {
                mSwipeRefresh.setRefreshing(false);
                L.d("Get Data Berita", message);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.laporan_menu, menu);

        MenuItem   searchItem = menu.findItem(R.id.act_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        SearchView.OnQueryTextListener queryListener = new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String constraint) {
                mAdapter.getFilter().filter(constraint);
                return true;
            }
        };
        searchView.setOnQueryTextListener(queryListener);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.act_search) {

        }
        return super.onOptionsItemSelected(item);
    }*/
}

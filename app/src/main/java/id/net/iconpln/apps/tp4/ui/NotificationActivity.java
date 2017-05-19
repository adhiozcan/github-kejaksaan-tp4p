package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import id.net.iconpln.apps.tp4.R;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.apps.tp4.adapter.ListNotificationAdapter;
import id.net.iconpln.apps.tp4.model.Notifikasi;
import id.net.iconpln.apps.tp4.utility.CommonUtils;

/**
 * Created by Ozcan on 07/03/2017.
 */

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView            mRecyclerView;
    private ListNotificationAdapter mAdapter;
    private List<Notifikasi>        mNotifList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        installToolbar();

        mNotifList = new ArrayList<>();
        mAdapter = new ListNotificationAdapter(mNotifList);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));

        provideDummyData();
    }

    private void installToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    private void provideDummyData() {
        for (int i = 0; i < 5; i++) {
            Notifikasi notif = new Notifikasi();
            notif.setType("Type of Notification");
            notif.setContent(getString(R.string.ipsum_short));
            mNotifList.add(notif);
        }

        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notif_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.act_clear) {

        }
        return super.onOptionsItemSelected(item);
    }
}

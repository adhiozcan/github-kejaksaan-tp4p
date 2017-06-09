package id.net.iconpln.apps.tp4.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import id.net.iconpln.apps.tp4.R;

import android.view.View;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.HashMap;
import java.util.Map;

import id.net.iconpln.apps.tp4.network.Param;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.model.ProyekSummary;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.utility.Formatter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTxtTotalNilaiProyek;
    private TextView mTxtStatMasuk;
    private TextView mTxtStatDitangani;
    private TextView mTxtStatSelesai;
    private TextView mTxtStatDitolak;

    private View mNotifView;

    private ProyekSummary mProyekSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alternative);
        CommonUtils.installToolbarForMain(this);

        mTxtTotalNilaiProyek = (TextView) findViewById(R.id.nilai_proyek);
        mTxtStatMasuk = (TextView) findViewById(R.id.stat_masuk);
        mTxtStatDitangani = (TextView) findViewById(R.id.stat_ditangani);
        mTxtStatSelesai = (TextView) findViewById(R.id.stat_selesai);
        mTxtStatDitolak = (TextView) findViewById(R.id.stat_ditolak);

        KenBurnsView kbv = (KenBurnsView) findViewById(R.id.kenburns_effect);
        kbv.restart();

        getDataFromNetwork();
    }

    private void getDataFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.PROJECT_SUMMARY);
        request.execute(new ResponseListener<ProyekSummary[]>() {
            @Override
            public void onResponse(ProyekSummary[] response) {
                mProyekSummary = new ProyekSummary();
                mProyekSummary = response[0];
                setDataIntoView();
            }

            @Override
            public void onFailed(String message) {
            }
        });
    }

    private void setDataIntoView() {
        mTxtTotalNilaiProyek.setText(Formatter.getCurrencyFormat(mProyekSummary.getTotalNasional()));
        mTxtStatMasuk.setText(mProyekSummary.getProyekMasuk());
        mTxtStatDitangani.setText(mProyekSummary.getProyekDitangani());
        mTxtStatSelesai.setText(mProyekSummary.getProyekSelesai());
        mTxtStatDitolak.setText(mProyekSummary.getProyekDitolak());

        //setNotifIntoIconToolbar(0);
        //setNotifIntoView(R.id.notif_stat_akun, 18);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        mNotifView = menu.findItem(R.id.act_notif).getActionView();
        setNotifIntoIconToolbar(0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.act_notif:
                navigateTo(NotificationActivity.class);
                break;
            case R.id.act_about:
                navigateTo(AboutActivity.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onRekapStatisticClicked(View rekapMenuId) {
        switch (rekapMenuId.getId()) {
            case R.id.menu_stat_masuk:
                navigateTo(ListPermohonanActivity.class, ListPermohonanActivity.TAB_PERMOHONAN_MASUK);
                break;
            case R.id.menu_stat_ditangani:
                navigateTo(ListPermohonanActivity.class, ListPermohonanActivity.TAB_PERMOHONAN_DITANGANI);
                break;
            case R.id.menu_stat_selesai:
                navigateTo(ListPermohonanActivity.class, ListPermohonanActivity.TAB_PERMOHONAN_SELESAI);
                break;
            case R.id.menu_stat_ditolak:
                navigateTo(ListPermohonanActivity.class, ListPermohonanActivity.TAB_PERMOHONAN_DITOLAK);
                break;
        }
    }

    public void onMenuButtonClicked(View menuId) {
        switch (menuId.getId()) {
            case R.id.btn_detail_statistic:
                navigateTo(RekapProyekActivity.class);
                break;
            case R.id.menu_berita:
                navigateTo(ListBeritaActivity.class);
                break;
            case R.id.menu_jadwal:
                navigateTo(ListJadwalActivity.class);
                break;
            case R.id.menu_assignment:
                navigateTo(ListPenugasanActivity.class);
                break;
            case R.id.menu_proyek:
                navigateTo(ListProyekActivity.class);
                break;
            case R.id.menu_data_permohonan:
                navigateTo(ListPermohonanActivity.class);
                break;
            case R.id.menu_laporan:
                navigateTo(ListLaporanAkhirActivity.class);
                break;
            case R.id.menu_arsip:
                navigateTo(ListArsipActivity.class);
                break;
            case R.id.menu_user_profile:
                navigateTo(ProfileActivity.class);
                finish();
                break;
        }
    }

    private void navigateTo(Class activity, int tabPosition) {
        Intent intentActivity = new Intent(this, activity);
        intentActivity.putExtra("tab_position", tabPosition);
        startActivity(intentActivity);
    }

    private void navigateTo(Class activity) {
        Intent intentActivity = new Intent(this, activity);
        startActivity(intentActivity);
    }

    private void setNotifIntoView(int viewId, int notf) {
        TextView txtNotif = (TextView) findViewById(viewId);
        txtNotif.setVisibility(View.VISIBLE);
        txtNotif.setText(String.valueOf(notf));
    }

    private void setNotifIntoIconToolbar(int notif) {
        TextView txtViewCount = (TextView) mNotifView.findViewById(R.id.txtCount);
        txtViewCount.setVisibility(View.GONE);
        if (notif != 0) {
            txtViewCount.setText(String.valueOf(notif));
            txtViewCount.setVisibility(View.VISIBLE);
        }

        mNotifView.findViewById(R.id.button_notif_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(NotificationActivity.class);
            }
        });
    }
}

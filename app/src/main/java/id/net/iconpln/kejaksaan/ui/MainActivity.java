package id.net.iconpln.kejaksaan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.HashMap;
import java.util.Map;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.model.ProyekSummary;
import id.net.iconpln.kejaksaan.network.Param;
import id.net.iconpln.kejaksaan.network.RequestServer;
import id.net.iconpln.kejaksaan.network.ResponseListener;
import id.net.iconpln.kejaksaan.network.ServiceUrl;
import id.net.iconpln.kejaksaan.utility.CommonUtils;
import id.net.iconpln.kejaksaan.utility.Formatter;

import static android.R.string.no;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTxtTotalNilaiProyek;
    private TextView mTxtStatMasuk;
    private TextView mTxtStatDitangani;
    private TextView mTxtStatSelesai;
    private TextView mTxtStatDitolak;

    private ProyekSummary mProyekSummary;
    private Menu menu;

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
        Map<String, String> param = new HashMap<>();
        param.put(Param.USER_UNIT_ID, "5");
        RequestServer request = new RequestServer(ServiceUrl.PROJECT_SUMMARY, param);
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

        setNotifIntoIconToolbar(10);
        setNotifIntoView(R.id.notif_stat_akun, 18);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
                navigateTo(ListProjectsActivity.class);
                break;
            case R.id.menu_data_permohonan:
                navigateTo(ListPermohonanActivity.class);
                break;
            case R.id.menu_laporan:
                navigateTo(ListLaporanAkhirActivity.class);
                break;
            case R.id.menu_arsip:
                navigateTo(ListArchiveActivity.class);
                break;
            case R.id.menu_user_profile:
                navigateTo(ProfileActivity.class);
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

    private void setNotifIntoView(int viewId, int notf){
        TextView txtNotif = (TextView) findViewById(viewId);
        txtNotif.setVisibility(View.VISIBLE);
        txtNotif.setText(String.valueOf(notf));
    }

    private void setNotifIntoIconToolbar(int notif){
        View notifView = menu.findItem(R.id.act_notif).getActionView();
        TextView txtViewCount = (TextView) notifView.findViewById(R.id.txtCount);
        txtViewCount.setText(String.valueOf(notif));
        notifView.findViewById(R.id.button_notif_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(NotificationActivity.class);
            }
        });
    }
}

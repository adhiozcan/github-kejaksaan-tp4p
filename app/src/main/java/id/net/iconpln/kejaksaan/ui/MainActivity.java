package id.net.iconpln.kejaksaan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.flaviofaria.kenburnsview.KenBurnsView;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.utility.CommonUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alternative);
        CommonUtils.installToolbarForMain(this);

        KenBurnsView kbv = (KenBurnsView) findViewById(R.id.kenburns_effect);
        kbv.restart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
}

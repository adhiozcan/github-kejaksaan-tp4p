package id.net.iconpln.kejaksaan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.kejaksaan.utility.CommonUtils;
import id.net.iconpln.kejaksaan.KejaksaanApp;
import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.ListBeritaAdapter;
import id.net.iconpln.kejaksaan.model.Berita;

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
            /*case R.id.act_menu:
                ImageView arrowDrop = (ImageView) findViewById(R.id.arrow_drop);
                if (mBottomSheet.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    mBottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
                    arrowDrop.setImageResource(R.drawable.ic_arrow_down);
                } else {
                    mBottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    arrowDrop.setImageResource(R.drawable.ic_arrow_up);
                }
                break;*/
        }
        return super.onOptionsItemSelected(item);
    }

    public void onMenuButtonClicked(View menuId) {
        switch (menuId.getId()) {
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
        }
    }

    private void navigateTo(Class activity) {
        Intent intentActivity = new Intent(this, activity);
        startActivity(intentActivity);
    }
}

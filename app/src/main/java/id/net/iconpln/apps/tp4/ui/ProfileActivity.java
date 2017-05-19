package id.net.iconpln.apps.tp4.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import id.net.iconpln.apps.tp4.KejaksaanApp;
import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.UserProfile;
import id.net.iconpln.apps.tp4.utility.CommonUtils;

public class ProfileActivity extends AppCompatActivity {

    private TextView mNamaPetugas;
    private TextView mJabatan;
    private TextView mDaerahKejaksaan;
    private TextView mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CommonUtils.installToolbar(this);
        mNamaPetugas = (TextView) findViewById(R.id.nama_petugas);
        mJabatan = (TextView) findViewById(R.id.jabatan);
        mDaerahKejaksaan = (TextView) findViewById(R.id.area_kejaksaan);
        mStatus = (TextView) findViewById(R.id.status);

        UserProfile user = KejaksaanApp.PROFILE;

        mNamaPetugas.setText(user.getNama());
        mJabatan.setText(user.getJabatan());
        mDaerahKejaksaan.setText(user.getUnitKejaksaan());
        mStatus.setText("Aktif");
    }

    public void logout(View view) {
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }

}

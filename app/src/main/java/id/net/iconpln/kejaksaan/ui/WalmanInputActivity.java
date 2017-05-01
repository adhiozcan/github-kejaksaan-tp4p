package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.utility.CommonUtils;

/**
 * Created by Ozcan on 16/03/2017.
 */

public class WalmanInputActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_input_walman);
        CommonUtils.installToolbar(this);
    }
}

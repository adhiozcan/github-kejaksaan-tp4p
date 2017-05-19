package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.R;

/**
 * Created by Ozcan on 21/04/2017.
 */

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        CommonUtils.installToolbar(this);
    }
}

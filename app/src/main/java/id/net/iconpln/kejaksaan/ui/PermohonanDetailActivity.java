package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import id.net.iconpln.kejaksaan.utility.CommonUtils;
import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.utility.Notif;

/**
 * Created by Ozcan on 07/03/2017.
 */

public class PermohonanDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permohonan);
        CommonUtils.installToolbar(this);
    }
}

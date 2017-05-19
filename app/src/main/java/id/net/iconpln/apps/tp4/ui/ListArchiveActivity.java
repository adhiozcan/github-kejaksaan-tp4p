package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.utility.CommonUtils;

/**
 * Created by Ozcan on 21/04/2017.
 */

public class ListArchiveActivity extends AppCompatActivity {

    private Spinner mSpinnerTahun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_archive);
        CommonUtils.installToolbar(this);

        mSpinnerTahun = (Spinner) findViewById(R.id.spinner_year);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.available_tahun, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerTahun.setAdapter(adapter);
    }
}
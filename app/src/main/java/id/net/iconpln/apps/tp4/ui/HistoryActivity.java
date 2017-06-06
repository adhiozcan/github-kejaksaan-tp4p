package id.net.iconpln.apps.tp4.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import id.net.iconpln.apps.tp4.R;
import android.view.View;

import id.net.iconpln.apps.tp4.model.Rekapitulasi;

public class HistoryActivity extends AppCompatActivity {

    private Rekapitulasi mRekap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_perkembangan);

        mRekap = getIntent().getParcelableExtra("data");
        initToolbar();
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(mRekap.getNamaProyek());
        toolbar.setSubtitle(mRekap.getNomorProyek());
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}

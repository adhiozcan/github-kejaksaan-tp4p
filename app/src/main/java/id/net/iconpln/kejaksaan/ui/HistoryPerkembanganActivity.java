package id.net.iconpln.kejaksaan.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.model.Rekapitulasi;

import static android.R.attr.data;

public class HistoryPerkembanganActivity extends AppCompatActivity {

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

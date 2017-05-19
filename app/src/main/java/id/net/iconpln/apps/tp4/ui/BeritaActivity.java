package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.Berita;
import id.net.iconpln.apps.tp4.utility.CommonUtils;

/**
 * Created by Ozcan on 15/03/2017.
 */

public class BeritaActivity extends AppCompatActivity {
    private TextView mTxtJudul;
    private TextView mTxtTanggal;
    private TextView mTxtPenulis;
    private TextView mTxtContent;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private Berita mBerita;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        CommonUtils.installToolbar(this);

        mTxtJudul = (TextView) findViewById(R.id.judul_berita);
        mTxtTanggal = (TextView) findViewById(R.id.tanggal_terbit);
        mTxtPenulis = (TextView) findViewById(R.id.penulis);
        mTxtContent = (TextView) findViewById(R.id.content_berita);

        if (getIntent().getExtras() != null) {
            getExtraContent();
            setDataIntoView();
        }
        setToolbar();
    }

    private void setToolbar(){
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsible_toolbar);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
        mCollapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        mCollapsingToolbarLayout.setStatusBarScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        mCollapsingToolbarLayout.setTitle(mBerita.getJudulBerita());

    }

    private void setDataIntoView() {
        mTxtJudul.setText(mBerita.getJudulBerita());
        mTxtTanggal.setText(mBerita.getTanggalTerbit());
        mTxtPenulis.setText(mBerita.getPenulis());
        mTxtContent.setText(mBerita.getContent());
    }

    private void getExtraContent() {
        mBerita = new Berita();
        Bundle bundle = getIntent().getExtras();
        mBerita.setJudulBerita(bundle.getString("judul_berita"));
        mBerita.setTanggalTerbit(bundle.getString("tanggal_terbit"));
        mBerita.setPenulis(bundle.getString("penulis"));
        mBerita.setContent(bundle.getString("content"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

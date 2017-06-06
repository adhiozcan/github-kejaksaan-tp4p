package id.net.iconpln.apps.tp4.ui;

import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import id.net.iconpln.apps.tp4.R;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.db.chart.Tools;
import com.db.chart.animation.Animation;
import com.db.chart.model.LineSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.tooltip.Tooltip;
import com.db.chart.view.LineChartView;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.adapter.RekapProyekAdapter;
import id.net.iconpln.apps.tp4.model.Rekapitulasi;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.ChartUtils;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.utility.QueryUtils;

/**
 * Created by Ozcan on 26/04/2017.
 */

public class RekapProyekActivity extends AppCompatActivity {

    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private List<Rekapitulasi> mRekapList;
    private RekapProyekAdapter mAdapter;
    private RecyclerView       mRecycleView;

    private LineChartView mChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_proyek);
        initToolbar();

        //mRekapList = new ArrayList<>(QueryUtils.provideRekapitulasiData(this));
        mRekapList = new ArrayList<>();

        mAdapter = new RekapProyekAdapter(mRekapList);
        mRecycleView = (RecyclerView) findViewById(R.id.rv_list_rekap_proyek);
        mChart = (LineChartView) findViewById(R.id.chart1);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));

        KenBurnsView kbv = (KenBurnsView) findViewById(R.id.kenburns_effect);
        kbv.restart();

        getDataFromNetwork();
    }

    private void initChart() {
        LineSet dataset = new LineSet(ChartUtils.getShortMonthLabel(), ChartUtils.getRekapMonthValue(mRekapList));

        //dataset
        mChart.dismissAllTooltips();
        dataset.setColor(ContextCompat.getColor(this, R.color.white));
        dataset.setDotsColor(ContextCompat.getColor(this, R.color.orange_500));
        dataset.setSmooth(false);
        dataset.setDotsRadius(10);
        dataset.setThickness(5);
        mChart.addData(dataset);
        mChart.setYLabels(AxisRenderer.LabelPosition.NONE);
        mChart.setXAxis(false);
        mChart.setYAxis(false);
        mChart.setLabelsColor(ContextCompat.getColor(this, R.color.white));


        Runnable run = new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 1000);
            }
        };

        //animation
        Animation anim = new Animation();
        anim.setEndAction(run);
        anim.setDuration(1000);

        mChart.show(anim);
        setTooltip(true);
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolbarLayout1);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
        mCollapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
        mCollapsingToolbarLayout.setStatusBarScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
    }

    private void getDataFromNetwork() {
        RequestServer request = new RequestServer(ServiceUrl.PROJECT_SUMMARY_DETAIL);
        request.execute(new ResponseListener<Rekapitulasi[]>() {
            @Override
            public void onResponse(Rekapitulasi[] response) {
                mRekapList.clear();
                mRekapList.addAll(Arrays.asList(response));
                mAdapter.notifyDataSetChanged();
                initChart();
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    public void setTooltip(boolean enable) {
        Tooltip mTip = new Tooltip(this, R.layout.linechart_tooltip, R.id.value);

        mTip.setVerticalAlignment(Tooltip.Alignment.BOTTOM_TOP);
        mTip.setDimensions((int) Tools.fromDpToPx(65), (int) Tools.fromDpToPx(25));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {

            mTip.setEnterAnimation(PropertyValuesHolder.ofFloat(View.ALPHA, 1),
                    PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f),
                    PropertyValuesHolder.ofFloat(View.SCALE_X, 1f)).setDuration(200);

            mTip.setExitAnimation(PropertyValuesHolder.ofFloat(View.ALPHA, 0),
                    PropertyValuesHolder.ofFloat(View.SCALE_Y, 0f),
                    PropertyValuesHolder.ofFloat(View.SCALE_X, 0f)).setDuration(200);

            mTip.setDimensions(110, 40);
            mTip.setPivotX(Tools.fromDpToPx(65) / 2);
            mTip.setPivotY(Tools.fromDpToPx(25));
        }

        if (enable) mChart.setTooltips(mTip);
    }

}

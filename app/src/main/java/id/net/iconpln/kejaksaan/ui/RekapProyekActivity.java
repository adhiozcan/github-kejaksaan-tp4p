package id.net.iconpln.kejaksaan.ui;

import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.RekapProyekAdapter;
import id.net.iconpln.kejaksaan.model.Rekapitulasi;
import id.net.iconpln.kejaksaan.utility.ChartUtil;
import id.net.iconpln.kejaksaan.utility.CommonUtils;

import static android.R.attr.action;

/**
 * Created by Ozcan on 26/04/2017.
 */

public class RekapProyekActivity extends AppCompatActivity {
    private List<Rekapitulasi>      mRekapList;
    private RekapProyekAdapter      mAdapter;
    private RecyclerView            mRecycleView;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private LineChartView mChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap_proyek);
        initToolbar();

        mRekapList = new ArrayList<>();
        mAdapter = new RekapProyekAdapter(mRekapList);
        mRecycleView = (RecyclerView) findViewById(R.id.rv_list_rekap_proyek);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));

        provideDummy();
        initChart();
    }

    private void initChart() {
        mChart = (LineChartView) findViewById(R.id.chart1);
        LineSet dataset = new LineSet(ChartUtil.getShortMonthLabel(), ChartUtil.getRekapMonthValue(mRekapList));
        //dataset
        mChart.dismissAllTooltips();
        dataset.setColor(getResources().getColor(R.color.white));
        dataset.setDotsColor(getResources().getColor(R.color.orange_500));
        dataset.setSmooth(false);
        dataset.setDotsRadius(10);
        dataset.setThickness(5);
        mChart.addData(dataset);
        mChart.setYLabels(AxisRenderer.LabelPosition.NONE);
        mChart.setXAxis(false);
        mChart.setYAxis(false);
        mChart.setLabelsColor(getResources().getColor(R.color.white));


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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolbarLayout1);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
        mCollapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        mCollapsingToolbarLayout.setStatusBarScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
    }

    private void provideDummy() {
        for (int i = 0; i < 10; i++) {
            Rekapitulasi rekap = new Rekapitulasi();
            rekap.setNomorProyek("TP4P-201704-" + (i + 4));
            rekap.setNamaProyek(getString(R.string.ipsum_short));
            rekap.setNilai("1280000");

            mRekapList.add(rekap);
        }
        mAdapter.notifyDataSetChanged();
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

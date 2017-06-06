package id.net.iconpln.apps.tp4.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.adapter.ListArsipAdapter;
import id.net.iconpln.apps.tp4.model.Arsip;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.BeautifulProgressDialog;
import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.utility.NetworkUtil;

/**
 * Created by Ozcan on 21/04/2017.
 */

public class ListArsipActivity extends AppCompatActivity {

    private View     imgDescription;
    private EditText edSearchBox;

    private List<Arsip>      mArsipList;
    private ListArsipAdapter mAdapter;
    private RecyclerView     mRecyclerView;

    private BeautifulProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_arsip_old);
        CommonUtils.installToolbar(this);

        imgDescription = findViewById(R.id.img_description);
        edSearchBox = (EditText) findViewById(R.id.ed_search_box);
        edSearchBox.clearFocus();
        edSearchBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    imgDescription.setVisibility(View.GONE);
                } else {
                    imgDescription.setVisibility(View.VISIBLE);
                }
            }
        });

        mProgressDialog = new BeautifulProgressDialog(this);
        mProgressDialog.setMessage("Memuat data ...");

        mArsipList = new ArrayList<>();
        mAdapter = new ListArsipAdapter(this, mArsipList);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_arsip);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(this));

        if (NetworkUtil.isConnectToInternet(this)) {
            getDataFromNetwork();
        }
    }

    private void getDataFromNetwork() {
        mProgressDialog.show();
        RequestServer request = new RequestServer(ServiceUrl.ARSIP);
        request.execute(new ResponseListener<Arsip[]>() {
            @Override
            public void onResponse(Arsip[] response) {
                mProgressDialog.dismiss();
                mArsipList.clear();
                mArsipList.addAll(Arrays.asList(response));
                refreshAdapter();
            }

            @Override
            public void onFailed(String message) {
                mProgressDialog.dismiss();
            }
        });
    }

    private void refreshAdapter() {
        mAdapter.notifyDataSetChanged();
    }

    public void onSearchButtonClicked(View viewId) {
        String constraint = edSearchBox.getText().toString();
        mAdapter.getFilter().filter(constraint);

        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        edSearchBox.clearFocus();

    }
}
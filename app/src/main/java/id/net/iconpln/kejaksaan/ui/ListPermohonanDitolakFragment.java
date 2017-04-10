package id.net.iconpln.kejaksaan.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.kejaksaan.utility.CommonUtils;
import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.adapter.ListPermohonanAdapter;
import id.net.iconpln.kejaksaan.model.Permohonan;

/**
 * Created by Ozcan on 13/03/2017.
 */

public class ListPermohonanDitolakFragment extends Fragment {
    private ListPermohonanAdapter mAdapter;
    private RecyclerView          mRecyclerView;

    private List<Permohonan> mPermohonanList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_permohonan_ditolak, container, false);
        mPermohonanList = new ArrayList<>();
        mAdapter = new ListPermohonanAdapter(getActivity(), provideListPermohonanMockupModel());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_permohonan_ditolak);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(getActivity()));
        return view;
    }

    private List<Permohonan> provideListPermohonanMockupModel() {
        Permohonan permohonan1 = new Permohonan();
        permohonan1.setJudul("Permohonan Penangguhan Penahanan");
        permohonan1.setPemohon("Ir. Putra Pratama, M.Eng");
        permohonan1.setInstansi("Kantor PLN Pusat Trunojoyo");
        permohonan1.createIdentitasPemohon();


        List<Permohonan> mockupList = new ArrayList<>();
        mockupList.add(permohonan1);

        return mockupList;
    }
}

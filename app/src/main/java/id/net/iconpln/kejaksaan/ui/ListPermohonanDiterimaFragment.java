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

public class ListPermohonanDiterimaFragment extends Fragment {
    private ListPermohonanAdapter mAdapter;
    private RecyclerView          mRecyclerView;

    private List<Permohonan> mPermohonanList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_permohonan_diterima, container, false);
        mPermohonanList = new ArrayList<>();
        mAdapter = new ListPermohonanAdapter(getActivity(), provideListPermohonanMockupModel());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_permohonan_diterima);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(CommonUtils.getVerticalLayoutManager(getActivity()));
        return view;
    }

    private List<Permohonan> provideListPermohonanMockupModel() {
        Permohonan permohonan3 = new Permohonan();
        permohonan3.setJudul("Permohonan Pendampingan Hukum Pengadaan Airbus Jet 400");
        permohonan3.setPemohon("Dr. H. Muhammad Rizki, M.Eng");
        permohonan3.setInstansi("Tiger Airlines");
        permohonan3.createIdentitasPemohon();

        Permohonan permohonan4 = new Permohonan();
        permohonan4.setJudul("Permohonan Pendampingan Penegakan Area Lokalisasi Sarkem");
        permohonan4.setPemohon("H. Yandri Hidaya, M.Sos");
        permohonan4.setInstansi("Kementrian Sosial Region DIY-Jateng");
        permohonan4.createIdentitasPemohon();

        List<Permohonan> mockupList = new ArrayList<>();
        mockupList.add(permohonan3);
        mockupList.add(permohonan4);
        return mockupList;
    }
}

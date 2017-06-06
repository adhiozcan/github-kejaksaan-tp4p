package id.net.iconpln.apps.tp4.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.net.iconpln.apps.tp4.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.utility.CommonUtils;
import id.net.iconpln.apps.tp4.adapter.ListPermohonanAdapter;
import id.net.iconpln.apps.tp4.model.Permohonan;

/**
 * Created by Ozcan on 13/03/2017.
 */

public class ListPermohonanDitanganiFragment extends Fragment {
    private ListPermohonanAdapter mAdapter;
    private RecyclerView          mRecyclerView;

    private List<Permohonan> mPermohonanList;

    public static ListPermohonanDitanganiFragment newInstance(String permohonanList) {

        Bundle args = new Bundle();
        args.putString("permohonan_list", permohonanList);
        ListPermohonanDitanganiFragment fragment = new ListPermohonanDitanganiFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_permohonan_diterima, container, false);

        String       permohonanInString = getArguments().getString("permohonan_list");
        Permohonan[] permohonanArgs     = new Gson().fromJson(permohonanInString, Permohonan[].class);

        mPermohonanList = new ArrayList<>(Arrays.asList(permohonanArgs));
        mAdapter = new ListPermohonanAdapter(getActivity(), mPermohonanList);
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

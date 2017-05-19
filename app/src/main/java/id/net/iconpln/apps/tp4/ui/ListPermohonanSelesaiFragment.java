package id.net.iconpln.apps.tp4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import id.net.iconpln.apps.tp4.R;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.net.iconpln.apps.tp4.adapter.ListPermohonanAdapter;
import id.net.iconpln.apps.tp4.model.Permohonan;
import id.net.iconpln.apps.tp4.utility.CommonUtils;

/**
 * Created by Ozcan on 02/05/2017.
 */

public class ListPermohonanSelesaiFragment extends Fragment {
    private ListPermohonanAdapter mAdapter;
    private RecyclerView          mRecyclerView;

    private List<Permohonan> mPermohonanList;

    public static ListPermohonanSelesaiFragment newInstance(String permohonanList) {

        Bundle args = new Bundle();
        args.putString("permohonan_list", permohonanList);
        ListPermohonanSelesaiFragment fragment = new ListPermohonanSelesaiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_permohonan_selesai, container, false);

        String       permohonanInString = getArguments().getString("permohonan_list");
        Permohonan[] permohonanArgs     = new Gson().fromJson(permohonanInString, Permohonan[].class);

        mPermohonanList = new ArrayList<>(Arrays.asList(permohonanArgs));
        mAdapter = new ListPermohonanAdapter(getActivity(), mPermohonanList);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_permohonan_selesai);
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

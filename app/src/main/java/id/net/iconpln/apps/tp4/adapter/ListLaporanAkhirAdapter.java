package id.net.iconpln.apps.tp4.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.apps.tp4.model.Arsip;
import id.net.iconpln.apps.tp4.model.LaporanAkhir;
import id.net.iconpln.apps.tp4.R;

/**
 * Created by Ozcan on 02/05/2017.
 */

public class ListLaporanAkhirAdapter extends BaseAdapter<ListLaporanAkhirAdapter.ViewHolder, LaporanAkhir> implements Filterable {
    private Context            context;
    private LaporanAkhirFilter laporanFilter;
    private List<LaporanAkhir> laporanList;
    private List<LaporanAkhir> filteredList;

    public ListLaporanAkhirAdapter(Context context, List<LaporanAkhir> laporanList) {
        this.context = context;
        this.laporanList = laporanList;
        this.filteredList = laporanList;

        getFilter();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext   = parent.getContext();
        int     itemLayout = R.layout.item_adapter_laporan_akhir;
        View    view       = LayoutInflater.from(mContext).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LaporanAkhir laporanAkhir = filteredList.get(position);
        holder.txtNoProyek.setText(laporanAkhir.getNoProject());
        holder.txtTanggalTerbit.setText(laporanAkhir.getTanggalTerbit());
        holder.txtNamaProyek.setText(laporanAkhir.getNamaProject());
        holder.txtKeterangan.setText(laporanAkhir.getRingkasan());
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        if (laporanFilter == null) {
            laporanFilter = new LaporanAkhirFilter();
        }
        return laporanFilter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNoProyek;
        private TextView txtTanggalTerbit;
        private TextView txtNamaProyek;
        private TextView txtKeterangan;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNoProyek = (TextView) itemView.findViewById(R.id.nomor_proyek);
            txtTanggalTerbit = (TextView) itemView.findViewById(R.id.tanggal_terbit);
            txtNamaProyek = (TextView) itemView.findViewById(R.id.nama_proyek);
            txtKeterangan = (TextView) itemView.findViewById(R.id.keterangan);
        }
    }

    private class LaporanAkhirFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                List<LaporanAkhir> tempList = new ArrayList<>();

                //search content in arsip data
                for (LaporanAkhir laporan : laporanList) {
                    String noWalman = laporan.getNoProject().toLowerCase();
                    String proyek   = laporan.getNamaProject().toLowerCase();
                    if (noWalman.contains(constraint.toString().toLowerCase())) {
                        tempList.add(laporan);
                    } else if (proyek.contains(constraint.toString().toLowerCase())) {
                        tempList.add(laporan);
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = laporanList.size();
                filterResults.values = laporanList;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filteredList = new ArrayList<>((List<LaporanAkhir>) filterResults.values);
            ListLaporanAkhirAdapter.this.notifyDataSetChanged();
        }
    }
}

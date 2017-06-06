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

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.Arsip;

/**
 * Created by Ozcan on 30/05/2017.
 */

public class ListArsipAdapter extends BaseAdapter<ListArsipAdapter.ViewHolder, Arsip> implements Filterable {

    private Context     context;
    private ArsipFilter arsipFilter;

    private List<Arsip> arsipList;
    private List<Arsip> filteredList;

    public ListArsipAdapter(Context context, List<Arsip> arsipList) {
        this.context = context;
        this.arsipList = arsipList;
        this.filteredList = arsipList;

        getFilter();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext   = parent.getContext();
        int     itemLayout = R.layout.item_adapter_arsip;
        View    view       = LayoutInflater.from(mContext).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Arsip arsip = filteredList.get(position);
        holder.txtNoProyek.setText(arsip.getNoProject());
        holder.txtTahun.setText(arsip.getTahun());
        holder.txtJudulLaporan.setText(arsip.getNamaProject());
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        if (arsipFilter == null) {
            arsipFilter = new ArsipFilter();
        }
        return arsipFilter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNoProyek;
        private TextView txtTahun;
        private TextView txtJudulLaporan;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNoProyek = (TextView) itemView.findViewById(R.id.nomor_proyek);
            txtTahun = (TextView) itemView.findViewById(R.id.tahun_proyek);
            txtJudulLaporan = (TextView) itemView.findViewById(R.id.judul_laporan);
        }
    }

    private class ArsipFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                List<Arsip> tempList = new ArrayList<>();

                //search content in arsip data
                for (Arsip arsip : arsipList) {
                    String noWalman = arsip.getNoProject().toLowerCase();
                    String proyek   = arsip.getNamaProject().toLowerCase();
                    if (noWalman.contains(constraint.toString().toLowerCase())) {
                        tempList.add(arsip);
                    } else if (proyek.contains(constraint.toString().toLowerCase())) {
                        tempList.add(arsip);
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = arsipList.size();
                filterResults.values = arsipList;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filteredList = new ArrayList<>((List<Arsip>) filterResults.values);
            ListArsipAdapter.this.notifyDataSetChanged();
        }
    }
}

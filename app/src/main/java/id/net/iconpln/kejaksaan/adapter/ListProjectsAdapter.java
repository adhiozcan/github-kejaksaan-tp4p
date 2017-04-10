package id.net.iconpln.kejaksaan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.model.Proyek;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class ListProjectsAdapter extends KejaksaanBaseAdapter<ListProjectsAdapter.ViewHolder, Proyek> {
    private Context      context;
    private List<Proyek> proyekList;

    public ListProjectsAdapter(Context context, List<Proyek> proyekList) {
        this.context = context;
        this.proyekList = proyekList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext   = parent.getContext();
        int     itemLayout = R.layout.item_adapter_project;
        View    view       = LayoutInflater.from(mContext).inflate(itemLayout, parent, false);
        return new ListProjectsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Proyek proyek = proyekList.get(position);
        holder.judulProyek.setText(proyek.getJudulProyek());
        holder.lokasiProyek.setText(proyek.getLokasi());
        holder.tanggalMulai.setText(proyek.getTanggalMulai());
        holder.contentPenjelasan.setText(proyek.getContentPenjelasan());
        holder.durasi.setText(proyek.getDurasiPengerjaan());
    }

    @Override
    public int getItemCount() {
        return proyekList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judulProyek;
        TextView lokasiProyek;
        TextView tanggalMulai;
        TextView contentPenjelasan;
        TextView durasi;

        public ViewHolder(View itemView) {
            super(itemView);
            judulProyek = (TextView) itemView.findViewById(R.id.judul_project);
            lokasiProyek = (TextView) itemView.findViewById(R.id.lokasi_proyek);
            tanggalMulai = (TextView) itemView.findViewById(R.id.starting_project);
            contentPenjelasan = (TextView) itemView.findViewById(R.id.content_penjelasan);
            durasi = (TextView) itemView.findViewById(R.id.lama_pengerjaan);
        }
    }
}

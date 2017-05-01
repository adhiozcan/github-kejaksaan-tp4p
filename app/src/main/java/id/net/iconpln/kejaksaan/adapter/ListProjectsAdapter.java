package id.net.iconpln.kejaksaan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.model.Proyek;
import id.net.iconpln.kejaksaan.ui.WalmanInputActivity;

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
        holder.judulProyek.setText(proyek.getNamaProject());
        holder.lokasiProyek.setText(proyek.getLokasi());
        holder.tanggalMulai.setText(proyek.getTanggalMasuk());
        holder.contentPenjelasan.setText(proyek.getKeterangan());
        holder.durasi.setText(proyek.getDurasiPengerjaan());
        holder.btnLaporanWalman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, WalmanInputActivity.class));
            }
        });
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
        View     btnLaporanWalman;

        public ViewHolder(View itemView) {
            super(itemView);
            judulProyek = (TextView) itemView.findViewById(R.id.judul_project);
            lokasiProyek = (TextView) itemView.findViewById(R.id.lokasi_proyek);
            tanggalMulai = (TextView) itemView.findViewById(R.id.starting_project);
            contentPenjelasan = (TextView) itemView.findViewById(R.id.content_penjelasan);
            durasi = (TextView) itemView.findViewById(R.id.lama_pengerjaan);
            btnLaporanWalman = itemView.findViewById(R.id.btn_laporan_walman);
        }
    }
}

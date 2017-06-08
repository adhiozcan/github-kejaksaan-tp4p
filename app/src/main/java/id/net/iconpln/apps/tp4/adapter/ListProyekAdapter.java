package id.net.iconpln.apps.tp4.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.net.iconpln.apps.tp4.KejaksaanApp;
import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.Proyek;
import id.net.iconpln.apps.tp4.ui.TrackingActivity;
import id.net.iconpln.apps.tp4.ui.WalmanActivity;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class ListProyekAdapter extends BaseAdapter<ListProyekAdapter.ViewHolder, Proyek> {
    private Context      context;
    private List<Proyek> proyekList;

    public ListProyekAdapter(Context context, List<Proyek> proyekList) {
        this.context = context;
        this.proyekList = proyekList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext   = parent.getContext();
        int     itemLayout = R.layout.item_adapter_project;
        View    view       = LayoutInflater.from(mContext).inflate(itemLayout, parent, false);
        return new ListProyekAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Proyek proyek = proyekList.get(position);
        holder.judulProyek.setText(proyek.getNamaProject());
        holder.namaPemohon.setText(proyek.getNamaPemohon());
        holder.instansiPemohon.setText(proyek.getInstansiPemohon());
        holder.lokasiProyek.setText(proyek.getLokasi());
        holder.tanggalMulai.setText(proyek.getTanggalMasuk());
        holder.durasi.setText(proyek.getDurasiPengerjaan());
        holder.btnLaporanWalman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KejaksaanApp.noProyek = proyek.getNoProject();
                KejaksaanApp.noRegistrasi = proyek.getNoRegistrasi();
                context.startActivity(new Intent(context, WalmanActivity.class));
            }
        });

        holder.btnLaporanTracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KejaksaanApp.noRegistrasi = proyek.getNoRegistrasi();
                context.startActivity(new Intent(context, TrackingActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return proyekList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judulProyek;
        TextView namaPemohon;
        TextView instansiPemohon;
        TextView lokasiProyek;
        TextView tanggalMulai;
        TextView durasi;
        View     btnLaporanWalman;
        View     btnLaporanTracking;

        public ViewHolder(View itemView) {
            super(itemView);
            judulProyek = (TextView) itemView.findViewById(R.id.judul_project);
            namaPemohon = (TextView) itemView.findViewById(R.id.nama_pemohon);
            instansiPemohon = (TextView) itemView.findViewById(R.id.instansi_pemohon);
            lokasiProyek = (TextView) itemView.findViewById(R.id.lokasi_proyek);
            tanggalMulai = (TextView) itemView.findViewById(R.id.starting_project);
            durasi = (TextView) itemView.findViewById(R.id.lama_pengerjaan);
            btnLaporanWalman = itemView.findViewById(R.id.btn_laporan_walman);
            btnLaporanTracking = itemView.findViewById(R.id.btn_laporan_tracking);
        }
    }
}

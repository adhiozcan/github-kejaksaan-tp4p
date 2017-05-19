package id.net.iconpln.apps.tp4.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.net.iconpln.apps.tp4.model.LaporanAkhir;
import id.net.iconpln.apps.tp4.R;

/**
 * Created by Ozcan on 02/05/2017.
 */

public class ListLaporanAkhirAdapter extends KejaksaanBaseAdapter<ListLaporanAkhirAdapter.ViewHolder, LaporanAkhir> {
    private Context            context;
    private List<LaporanAkhir> laporanList;

    public ListLaporanAkhirAdapter(Context context, List<LaporanAkhir> laporanList) {
        this.context = context;
        this.laporanList = laporanList;
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
        LaporanAkhir laporanAkhir = laporanList.get(position);
        holder.txtNoProyek.setText(laporanAkhir.getNoProject());
        holder.txtTanggalTerbit.setText(laporanAkhir.getTanggalTerbit());
        holder.txtNamaProyek.setText(laporanAkhir.getNamaProject());
        holder.txtKeterangan.setText(laporanAkhir.getRingkasan());
    }

    @Override
    public int getItemCount() {
        return laporanList.size();
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
}

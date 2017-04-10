package id.net.iconpln.kejaksaan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.model.Jadwal;

/**
 * Created by Ozcan on 09/03/2017.
 */

public class ListJadwalAdapter extends KejaksaanBaseAdapter<ListJadwalAdapter.ViewHolder, Jadwal> {

    private Context      context;
    private List<Jadwal> jadwalList;

    public ListJadwalAdapter(Context context, List<Jadwal> jadwalList) {
        this.context = context;
        this.jadwalList = jadwalList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext   = parent.getContext();
        int     itemLayout = R.layout.item_adapter_jadwal;
        View    view       = LayoutInflater.from(mContext).inflate(itemLayout, parent, false);
        return new ListJadwalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Jadwal jadwal = jadwalList.get(position);
        holder.namaAcara.setText(jadwal.getJudulAcara());
        holder.lokasiTanggal.setText(jadwal.getLokasiTanggal());
        holder.keterangan.setText(jadwal.getKeterangan());
        holder.tempoRemaining.setText(jadwal.getJatuhTempo());
    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaAcara;
        TextView lokasiTanggal;
        TextView keterangan;
        TextView tempoRemaining;

        public ViewHolder(View itemView) {
            super(itemView);
            namaAcara = (TextView) itemView.findViewById(R.id.judul_permohonan);
            lokasiTanggal = (TextView) itemView.findViewById(R.id.lokasi_dan_tanggal);
            keterangan = (TextView) itemView.findViewById(R.id.keterangan_jadwal);
            tempoRemaining = (TextView) itemView.findViewById(R.id.tempo_remaining);
        }
    }
}

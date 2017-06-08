package id.net.iconpln.apps.tp4.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.net.iconpln.apps.tp4.model.Penugasan;
import id.net.iconpln.apps.tp4.ui.PenugasanActivity;
import id.net.iconpln.apps.tp4.R;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class ListPenugasanAdapter extends BaseAdapter<ListPenugasanAdapter.ViewHolder, Penugasan> {
    private Context         context;
    private List<Penugasan> penugasanList;

    public ListPenugasanAdapter(Context context, List<Penugasan> penugasanList) {
        this.context = context;
        this.penugasanList = penugasanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext   = parent.getContext();
        int     itemLayout = R.layout.item_adapter_penugasan;
        View    view       = LayoutInflater.from(mContext).inflate(itemLayout, parent, false);
        return new ListPenugasanAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Penugasan penugasan = penugasanList.get(position);
        holder.noProyek.setText(penugasan.getNoProject());
        holder.judulPenugasan.setText(penugasan.getNamaProject());
        holder.tanggalProyek.setText(penugasan.getTanggalMasuk());
        holder.namaPemohon.setText(penugasan.getNamaPemohon());
        holder.instansiPemohon.setText(penugasan.getInstansiPemohon());
        //holder.contentPenugasan.setText(penugasan.getNilai());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PenugasanActivity.class);
                intent.putExtra("no_proyek", penugasan.getNoProject());
                intent.putExtra("no_registrasi", penugasan.getNoRegistrasi());
                intent.putExtra("nama_proyek", penugasan.getNamaProject());
                intent.putExtra("tanggal_masuk", penugasan.getTanggalMasuk());
                intent.putExtra("tanggal_paparan", penugasan.getTanggalPaparan());
                intent.putExtra("nama_pemohon", penugasan.getNamaPemohon());
                intent.putExtra("instansi_pemohon", penugasan.getInstansiPemohon());
                intent.putExtra("keterangan", penugasan.getKeterangan());
                intent.putExtra("nilai_proyek", penugasan.getNilai());
                intent.putExtra("is_accept", penugasan.isAccept());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return penugasanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView noProyek;
        TextView judulPenugasan;
        TextView tanggalProyek;
        TextView namaPemohon;
        TextView instansiPemohon;
        TextView contentPenugasan;
        TextView btnDetailPenugasan;

        public ViewHolder(View itemView) {
            super(itemView);
            noProyek = (TextView) itemView.findViewById(R.id.nomor_proyek);
            judulPenugasan = (TextView) itemView.findViewById(R.id.judul_penugasan);
            tanggalProyek = (TextView) itemView.findViewById(R.id.tanggal_proyek);
            namaPemohon = (TextView) itemView.findViewById(R.id.nama_pemohon);
            instansiPemohon = (TextView) itemView.findViewById(R.id.instansi_pemohon);
            contentPenugasan = (TextView) itemView.findViewById(R.id.content_penugasan);
            btnDetailPenugasan = (TextView) itemView.findViewById(R.id.btn_detail_penugasan);
        }
    }
}

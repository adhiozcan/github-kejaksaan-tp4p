package id.net.iconpln.apps.tp4.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.net.iconpln.apps.tp4.ui.PermohonanDetailActivity;
import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.Permohonan;

/**
 * Created by Ozcan on 08/03/2017.
 */

public class ListPermohonanAdapter extends KejaksaanBaseAdapter<ListPermohonanAdapter.ViewHolder, Permohonan> {
    private Context          context;
    private List<Permohonan> listPermohonan;

    public ListPermohonanAdapter(Context context, List<Permohonan> listPermohonan) {
        this.context = context;
        this.listPermohonan = listPermohonan;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        //int     itemLayout = R.layout.item_adapter_permohonan;
        int  itemLayout = R.layout.item_adapter_permohonan_alternative;
        View view       = LayoutInflater.from(mContext).inflate(itemLayout, parent, false);
        return new ListPermohonanAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListPermohonanAdapter.ViewHolder holder, int position) {
        Permohonan permohonan = listPermohonan.get(position);
        holder.judulPermohonan.setText(permohonan.getJudul());
        holder.namaPengirim.setText(permohonan.getPemohon());
        holder.instansiPengirim.setText(permohonan.getInstansi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, PermohonanDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPermohonan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judulPermohonan;
        TextView namaPengirim;
        TextView instansiPengirim;

        public ViewHolder(View itemView) {
            super(itemView);
            judulPermohonan = (TextView) itemView.findViewById(R.id.judul_permohonan);
            namaPengirim = (TextView) itemView.findViewById(R.id.nama_pengirim);
            instansiPengirim = (TextView) itemView.findViewById(R.id.instansi_pengirim);
        }
    }
}

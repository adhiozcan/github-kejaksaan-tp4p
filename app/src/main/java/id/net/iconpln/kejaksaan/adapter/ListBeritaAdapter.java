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
import id.net.iconpln.kejaksaan.adapter.listener.JaksaAdapterOnItemClickListener;
import id.net.iconpln.kejaksaan.model.Berita;
import id.net.iconpln.kejaksaan.ui.BeritaActivity;

/**
 * Created by Ozcan on 15/03/2017.
 */

public class ListBeritaAdapter extends KejaksaanBaseAdapter<ListBeritaAdapter.ViewHolder, Berita> {
    private Context      context;
    private List<Berita> listBerita;

    public ListBeritaAdapter(Context context, List<Berita> listBerita) {
        this.context = context;
        this.listBerita = listBerita;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext   = parent.getContext();
        int     itemLayout = R.layout.item_adapter_berita;
        View    view       = LayoutInflater.from(mContext).inflate(itemLayout, parent, false);
        return new ListBeritaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Berita berita = listBerita.get(position);
        holder.judulBerita.setText(berita.getJudulBerita());
        holder.tanggalTerbit.setText(berita.getTanggalTerbit());
        holder.contentBerita.setText(berita.getContent());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BeritaActivity.class);
                intent.putExtra("judul_berita", berita.getJudulBerita());
                intent.putExtra("tanggal_terbit", berita.getTanggalTerbit());
                intent.putExtra("penulis", berita.getPenulis());
                intent.putExtra("content", berita.getContent());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBerita.size();
    }

    @Override
    public void onItemClicked(int position, Berita data) {
        super.onItemClicked(position, data);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judulBerita;
        TextView tanggalTerbit;
        TextView contentBerita;

        public ViewHolder(View itemView) {
            super(itemView);
            judulBerita = (TextView) itemView.findViewById(R.id.judul_berita);
            tanggalTerbit = (TextView) itemView.findViewById(R.id.tanggal_terbit);
            contentBerita = (TextView) itemView.findViewById(R.id.content_berita);
        }
    }
}

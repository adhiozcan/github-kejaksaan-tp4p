package id.net.iconpln.apps.tp4.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.net.iconpln.apps.tp4.model.Rekapitulasi;
import id.net.iconpln.apps.tp4.R;

/**
 * Created by Ozcan on 26/04/2017.
 */

public class RekapProyekAdapter extends BaseAdapter<RekapProyekAdapter.ViewHolder, Rekapitulasi> {
    private List<Rekapitulasi> rekapitulasiList;
    private OnItemSelected onItemSelected;

    public RekapProyekAdapter(List<Rekapitulasi> rekapitulasiList) {
        this.rekapitulasiList = rekapitulasiList;
    }

    @Override
    public RekapProyekAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context    = parent.getContext();
        int     itemLayout = R.layout.item_adapter_rekap_proyek;
        View    view       = LayoutInflater.from(context).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RekapProyekAdapter.ViewHolder holder, int position) {
        holder.txtNomorProyek.setText(rekapitulasiList.get(position).getNomorProyek());
        holder.txtNamaProyek.setText(rekapitulasiList.get(position).getNamaProyek());
        holder.txtNilai.setText(rekapitulasiList.get(position).getNilai());
    }

    @Override
    public int getItemCount() {
        return rekapitulasiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNomorProyek;
        TextView txtNamaProyek;
        TextView txtNilai;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNomorProyek = (TextView) itemView.findViewById(R.id.nomor_proyek);
            txtNamaProyek = (TextView) itemView.findViewById(R.id.nama_proyek);
            txtNilai = (TextView) itemView.findViewById(R.id.nilai_proyek);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemSelected != null)
                        onItemSelected.onClick(view, getAdapterPosition());

                }
            });
        }
    }

    public void setOnItemSelected(OnItemSelected onItemSelected){
        this.onItemSelected = onItemSelected;
    }

    public interface OnItemSelected{
        void onClick(View view, int position);
    }
}

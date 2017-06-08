package id.net.iconpln.apps.tp4.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.TrackingProject;

/**
 * Created by Ozcan on 07/06/2017.
 */

public class TrackingAdapter extends BaseAdapter<TrackingAdapter.ViewHolder, TrackingProject> {

    List<TrackingProject> trackingList;

    public TrackingAdapter(List<TrackingProject> trackingList) {
        this.trackingList = trackingList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext   = parent.getContext();
        int     itemLayout = R.layout.item_adapter_tracking;
        View    view       = LayoutInflater.from(mContext).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TrackingProject tracking = trackingList.get(position);
        holder.txtTanggal.setText(tracking.getTanggalUpdate());
        holder.txtNamaKegiatan.setText(tracking.getNamaUpdate());
        holder.txtKeterangan.setText(tracking.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return trackingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTanggal;
        private TextView txtNamaKegiatan;
        private TextView txtKeterangan;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTanggal = (TextView) itemView.findViewById(R.id.txt_tanggal);
            txtNamaKegiatan = (TextView) itemView.findViewById(R.id.txt_status);
            txtKeterangan = (TextView) itemView.findViewById(R.id.txt_keterangan);
        }
    }
}

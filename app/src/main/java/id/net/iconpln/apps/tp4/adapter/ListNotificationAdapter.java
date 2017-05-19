package id.net.iconpln.apps.tp4.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.net.iconpln.apps.tp4.model.Notifikasi;
import id.net.iconpln.apps.tp4.R;

/**
 * Created by Ozcan on 26/04/2017.
 */

public class ListNotificationAdapter extends KejaksaanBaseAdapter<ListNotificationAdapter.ViewHolder, Notifikasi> {

    private List<Notifikasi> notifikasiList;

    public ListNotificationAdapter(List<Notifikasi> notifikasiList) {
        this.notifikasiList = notifikasiList;
    }

    @Override
    public ListNotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context    = parent.getContext();
        int     itemLayout = R.layout.item_adapter_notification;
        View    view       = LayoutInflater.from(context).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListNotificationAdapter.ViewHolder holder, int position) {
        holder.txtType.setText(notifikasiList.get(position).getType());
        holder.txtContent.setText(notifikasiList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return notifikasiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtType;
        TextView txtContent;

        public ViewHolder(View itemView) {
            super(itemView);
            txtType = (TextView) itemView.findViewById(R.id.notif_type);
            txtContent = (TextView) itemView.findViewById(R.id.notif_content);
        }
    }
}

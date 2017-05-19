package id.net.iconpln.apps.tp4.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.net.iconpln.apps.tp4.model.Penugasan;
import id.net.iconpln.apps.tp4.ui.PenugasanActivity;
import id.net.iconpln.apps.tp4.R;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class ListPenugasanAdapter extends KejaksaanBaseAdapter<ListPenugasanAdapter.ViewHolder, Penugasan> {
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
        Penugasan penugasan = penugasanList.get(position);
        holder.judulPenugasan.setText(penugasan.getNamaProject());
        holder.contentPenugasan.setText(penugasan.getNilai());
        holder.btnDetailPenugasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, PenugasanActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return penugasanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judulPenugasan;
        TextView contentPenugasan;
        TextView btnDetailPenugasan;

        public ViewHolder(View itemView) {
            super(itemView);
            judulPenugasan = (TextView) itemView.findViewById(R.id.judul_penugasan);
            contentPenugasan = (TextView) itemView.findViewById(R.id.content_penugasan);
            btnDetailPenugasan = (TextView) itemView.findViewById(R.id.btn_detail_penugasan);
        }
    }
}

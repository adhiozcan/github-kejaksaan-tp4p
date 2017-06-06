package id.net.iconpln.apps.tp4.adapter;

import android.support.v7.widget.RecyclerView;

import id.net.iconpln.apps.tp4.adapter.listener.JaksaAdapterOnItemClickListener;

/**
 * Created by Ozcan on 13/03/2017.
 */

public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder, ModelType extends Object>
        extends RecyclerView.Adapter<VH>
        implements JaksaAdapterOnItemClickListener<ModelType> {

    private JaksaAdapterOnItemClickListener adapterOnItemClickListener;

    public void provideAdapterOnClickListener(JaksaAdapterOnItemClickListener adapterOnItemClickListener) {
        this.adapterOnItemClickListener = adapterOnItemClickListener;
    }

    @Override
    public void onItemClicked(int position, ModelType data) {
        adapterOnItemClickListener.onItemClicked(position, data);
    }
}

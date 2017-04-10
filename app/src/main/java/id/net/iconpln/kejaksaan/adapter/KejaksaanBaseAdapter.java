package id.net.iconpln.kejaksaan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import id.net.iconpln.kejaksaan.adapter.listener.JaksaAdapterOnItemClickListener;

/**
 * Created by Ozcan on 13/03/2017.
 */

public abstract class KejaksaanBaseAdapter<VH extends RecyclerView.ViewHolder, ModelType extends Object>
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

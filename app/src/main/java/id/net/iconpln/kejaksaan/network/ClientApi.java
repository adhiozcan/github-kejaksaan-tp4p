package id.net.iconpln.kejaksaan.network;

import android.support.annotation.NonNull;

/**
 * Created by Ozcan createNew 24/11/2016.
 */

public interface ClientApi<T> {
    void execute(@NonNull final ResponseListener<T> fsoApiListener);
}

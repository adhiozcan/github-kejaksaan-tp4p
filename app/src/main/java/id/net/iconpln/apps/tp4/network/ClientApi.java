package id.net.iconpln.apps.tp4.network;

import android.support.annotation.NonNull;

/**
 * Created by Ozcan createNew 24/11/2016.
 */

interface ClientApi<T> {
    void execute(@NonNull final ResponseListener<T> fsoApiListener);
}

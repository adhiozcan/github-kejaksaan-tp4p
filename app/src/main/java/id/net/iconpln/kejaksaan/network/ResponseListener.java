package id.net.iconpln.kejaksaan.network;

/**
 * Created by Ozcan on 20/12/2016.
 */

public interface ResponseListener<T> {
    void onResponse(T response);

    void onFailed(String message);
}
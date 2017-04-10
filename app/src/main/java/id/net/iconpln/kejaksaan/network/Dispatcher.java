package id.net.iconpln.kejaksaan.network;

import android.support.annotation.NonNull;

import java.util.Map;

import id.net.iconpln.kejaksaan.model.LoginResponse;
import retrofit2.Call;

/**
 * Created by Ozcan on 20/12/2016.
 */

class Dispatcher {

    private static Dispatcher sDispatcher;

    /**
     * Create service dispatcher to make request restfull api
     */
    private ServiceApi serviceApi = RestBuilder.getApiService(ServiceApi.class);

    /**
     * Define all service available using by the application.
     * ---------------------------------------------------------------------------------------------
     */
    protected Call<LoginResponse> loginUser(@NonNull Map<String, Object> param) {
        return serviceApi.loginUser(
                String.valueOf(param.get(Param.LOGIN_USERNAME)),
                String.valueOf(param.get(Param.LOGIN_PASSWORD)));
    }

    /**
     * Make this class singleton
     */
    private Dispatcher() {
    }

    public static Dispatcher getDispatcher() {
        if (sDispatcher == null) sDispatcher = new Dispatcher();
        return sDispatcher;
    }
}
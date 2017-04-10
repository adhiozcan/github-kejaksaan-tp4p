package id.net.iconpln.kejaksaan.network;

import java.util.Map;

import id.net.iconpln.kejaksaan.utility.L;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Ozcan on 30/01/2017.
 */

public class RequestServer implements ClientApi {
    private String              endPoint;
    private Map<String, Object> parameter;

    public RequestServer(String endPoint, Map<String, Object> parameters) {
        this.endPoint = endPoint;
        this.parameter = parameters;
    }

    @Override
    public void execute(final ResponseListener fsoListener) {
        Call request = defineRequestType();
        request.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    fsoListener.onResponse(response.body());
                    if (response.body() == null)
                        fsoListener.onFailed("Gagal menterjemahkan response");
                } else {
                    fsoListener.onFailed("Gagal memuat response");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                fsoListener.onFailed(t.getLocalizedMessage());
                L.e(t, t.getLocalizedMessage(), call);
            }
        });
    }

    private Call defineRequestType() {
        Dispatcher mDispatcher = Dispatcher.getDispatcher();
        switch (endPoint) {
            case ServiceUrl.USER_LOGIN:
                return mDispatcher.loginUser(parameter);
            default:
                return null;
        }
    }
}

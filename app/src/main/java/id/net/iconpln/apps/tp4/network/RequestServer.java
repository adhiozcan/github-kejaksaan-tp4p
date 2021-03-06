package id.net.iconpln.apps.tp4.network;

import java.util.Map;

import id.net.iconpln.apps.tp4.utility.L;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Ozcan on 30/01/2017.
 */

public class RequestServer implements ClientApi {
    private String              endPoint;
    private Map<String, String> parameter;

    public RequestServer(String endPoint) {
        this.endPoint = endPoint;
    }

    public RequestServer(String endPoint, Map<String, String> parameters) {
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
                if (t != null)
                    L.e(t, t.getLocalizedMessage(), call);
            }
        });
    }

    private Call defineRequestType() {
        Dispatcher mDispatcher = Dispatcher.getDispatcher();
        switch (endPoint) {
            case ServiceUrl.USER_LOGIN:
                return mDispatcher.loginUser(parameter);
            case ServiceUrl.PROJECT_SUMMARY:
                return mDispatcher.proyekSummary();
            case ServiceUrl.PROJECT_SUMMARY_DETAIL:
                return mDispatcher.proyekSummaryDetail();
            case ServiceUrl.BERITA:
                return mDispatcher.listBerita();
            case ServiceUrl.JADWAL:
                return mDispatcher.listJadwal();
            case ServiceUrl.DAFTAR_PERMOHONAN:
                return mDispatcher.listPermohonan();
            case ServiceUrl.PROJECT:
                return mDispatcher.listProyek();
            case ServiceUrl.ANEV:
                return mDispatcher.listAnev();
            case ServiceUrl.PENUGASAN:
                return mDispatcher.penugasan();
            case ServiceUrl.GET_KONFIRMASI:
                return mDispatcher.getKonfirmasiStatus();
            case ServiceUrl.DO_KONFIRMASI:
                return mDispatcher.konfirmasiPenugasan();
            case ServiceUrl.TRACKING:
                return mDispatcher.trackingProject();
            case ServiceUrl.WALMAN:
                return mDispatcher.prosesWalman();
            case ServiceUrl.WALMAN_UPLOAD_PHOTO:
                return mDispatcher.prosesWalmanPhoto();
            case ServiceUrl.LAPORAN_AKHIR:
                return mDispatcher.listLaporanAkhir();
            case ServiceUrl.ARSIP:
                return mDispatcher.listArsip();
            default:
                return null;
        }
    }
}

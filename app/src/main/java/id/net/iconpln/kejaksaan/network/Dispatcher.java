package id.net.iconpln.kejaksaan.network;

import android.support.annotation.NonNull;

import java.util.Map;

import id.net.iconpln.kejaksaan.model.ArsipResponse;
import id.net.iconpln.kejaksaan.model.Berita;
import id.net.iconpln.kejaksaan.model.Jadwal;
import id.net.iconpln.kejaksaan.model.LaporanAkhirResponse;
import id.net.iconpln.kejaksaan.model.LoginResponse;
import id.net.iconpln.kejaksaan.model.PermohonanResponse;
import id.net.iconpln.kejaksaan.model.ProyekResponse;
import id.net.iconpln.kejaksaan.model.ProyekSummary;
import id.net.iconpln.kejaksaan.model.RekapitulasiDetailResponse;
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
    protected Call<LoginResponse> loginUser(@NonNull Map<String, String> param) {
        return serviceApi.loginUser(
                param.get(Param.USERNAME),
                param.get(Param.PASSWORD));
    }

    protected Call<ProyekSummary[]> proyekSummary(@NonNull Map<String, String> param) {
        return serviceApi.proyekSummary(
                param.get(Param.USER_UNIT_ID));
    }

    protected Call<RekapitulasiDetailResponse> rekapitulasiDetail() {
        return serviceApi.rekapitulasiDetail();
    }

    protected Call<Berita[]> listBerita() {
        return serviceApi.listBerita();
    }

    protected Call<Jadwal[]> listJadwal() {
        return serviceApi.listJadwal();
    }

    protected Call<PermohonanResponse> listPermohonan(@NonNull Map<String, String> param) {
        return serviceApi.listPermohonan(param.get(Param.USER_UNIT_ID));
    }

    protected Call<ProyekResponse> listProyek(@NonNull Map<String, Object> param) {
        return serviceApi.listProyek(
                String.valueOf(param.get(Param.USER_UNIT_ID)));
    }

    protected Call<ArsipResponse> listArsip(@NonNull Map<String, Object> param) {
        return serviceApi.listArsip(
                String.valueOf(param.get(Param.USER_UNIT_ID)));
    }

    protected Call<LaporanAkhirResponse> listLaporanAkhir(@NonNull Map<String, Object> param) {
        return serviceApi.listLaporanAkhir(
                String.valueOf(param.get(Param.USER_UNIT_ID)));
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
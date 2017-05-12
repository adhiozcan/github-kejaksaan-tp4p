package id.net.iconpln.kejaksaan.network;

import android.support.annotation.NonNull;

import java.util.Map;

import id.net.iconpln.kejaksaan.KejaksaanApp;
import id.net.iconpln.kejaksaan.model.ArsipResponse;
import id.net.iconpln.kejaksaan.model.Berita;
import id.net.iconpln.kejaksaan.model.Jadwal;
import id.net.iconpln.kejaksaan.model.LaporanAkhirResponse;
import id.net.iconpln.kejaksaan.model.LoginResponse;
import id.net.iconpln.kejaksaan.model.Permohonan;
import id.net.iconpln.kejaksaan.model.Proyek;
import id.net.iconpln.kejaksaan.model.ProyekSummary;
import id.net.iconpln.kejaksaan.model.Rekapitulasi;
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
                String.valueOf(param.get(Param.USERNAME)),
                String.valueOf(param.get(Param.PASSWORD))
        );
    }

    protected Call<ProyekSummary[]> proyekSummary() {
        return serviceApi.proyekSummary(KejaksaanApp.KEJAKSAAN_ID);
    }

    protected Call<Rekapitulasi[]> proyekSummaryDetail() {
        return serviceApi.rekapitulasiDetail();
    }

    protected Call<Berita[]> listBerita() {
        return serviceApi.listBerita();
    }

    protected Call<Jadwal[]> listJadwal() {
        return serviceApi.listJadwal();
    }

    protected Call<Permohonan[]> listPermohonan() {
        return serviceApi.listPermohonan(KejaksaanApp.KEJAKSAAN_ID);
    }

    protected Call<Proyek[]> listProyek() {
        return serviceApi.listProyek(KejaksaanApp.KEJAKSAAN_ID);
    }

    protected Call<ArsipResponse> listArsip() {
        return serviceApi.listArsip(KejaksaanApp.KEJAKSAAN_ID);
    }

    protected Call<LaporanAkhirResponse> listLaporanAkhir() {
        return serviceApi.listLaporanAkhir(KejaksaanApp.KEJAKSAAN_ID);
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
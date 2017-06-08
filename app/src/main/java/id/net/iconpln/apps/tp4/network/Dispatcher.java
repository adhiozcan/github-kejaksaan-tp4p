package id.net.iconpln.apps.tp4.network;

import android.support.annotation.NonNull;

import java.util.Map;

import id.net.iconpln.apps.tp4.KejaksaanApp;
import id.net.iconpln.apps.tp4.model.Anev;
import id.net.iconpln.apps.tp4.model.Arsip;
import id.net.iconpln.apps.tp4.model.ArsipResponse;
import id.net.iconpln.apps.tp4.model.Berita;
import id.net.iconpln.apps.tp4.model.Jadwal;
import id.net.iconpln.apps.tp4.model.KonfirmasiResponse;
import id.net.iconpln.apps.tp4.model.LaporanAkhir;
import id.net.iconpln.apps.tp4.model.LoginResponse;
import id.net.iconpln.apps.tp4.model.Penugasan;
import id.net.iconpln.apps.tp4.model.Permohonan;
import id.net.iconpln.apps.tp4.model.Proyek;
import id.net.iconpln.apps.tp4.model.ProyekSummary;
import id.net.iconpln.apps.tp4.model.Rekapitulasi;
import id.net.iconpln.apps.tp4.model.TrackingProject;
import id.net.iconpln.apps.tp4.model.WalmanPhotoResponse;
import id.net.iconpln.apps.tp4.model.WalmanResponse;
import id.net.iconpln.apps.tp4.utility.RequestBody;
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
        return serviceApi.proyekSummary(KejaksaanApp.kejaksaanId);
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
        return serviceApi.listPermohonan(KejaksaanApp.kejaksaanId);
    }

    protected Call<Proyek[]> listProyek() {
        return serviceApi.listProyek(KejaksaanApp.kejaksaanId);
    }

    protected Call<Penugasan[]> penugasan() {
        return serviceApi.listPenugasan(KejaksaanApp.userId);
    }

    protected Call<KonfirmasiResponse[]> getKonfirmasiStatus() {
        return serviceApi.getKonfirmasi(KejaksaanApp.noRegistrasi, KejaksaanApp.userId);
    }

    protected Call<KonfirmasiResponse[]> konfirmasiPenugasan() {
        return serviceApi.konfirmasiPenugasan(KejaksaanApp.noRegistrasi, KejaksaanApp.userId);
    }

    protected Call<Anev[]> listAnev() {
        return serviceApi.listAnev();
    }

    protected Call<WalmanResponse> prosesWalman() {
        return serviceApi.prosesWalman(
                KejaksaanApp.noRegistrasi,
                KejaksaanApp.anev,
                KejaksaanApp.uraian,
                KejaksaanApp.userId);
    }

    protected Call<WalmanPhotoResponse> prosesWalmanPhoto() {
        return serviceApi.prosesWalmanPhoto(
                RequestBody.create(KejaksaanApp.noRegistrasi),
                RequestBody.create(KejaksaanApp.sequence),
                RequestBody.create(KejaksaanApp.namaPhoto),
                RequestBody.create(KejaksaanApp.anev),
                RequestBody.createImage(KejaksaanApp.filePhoto));
    }

    protected Call<TrackingProject[]> trackingProject() {
        return serviceApi.trackingProyek(KejaksaanApp.noRegistrasi);
    }

    protected Call<Arsip[]> listArsip() {
        return serviceApi.listArsip(KejaksaanApp.kejaksaanId);
    }

    protected Call<LaporanAkhir[]> listLaporanAkhir() {
        return serviceApi.listLaporanAkhir(KejaksaanApp.kejaksaanId);
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
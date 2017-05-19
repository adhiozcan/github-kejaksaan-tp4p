package id.net.iconpln.apps.tp4.network;

import id.net.iconpln.apps.tp4.model.LoginResponse;
import id.net.iconpln.apps.tp4.model.ProyekSummary;
import id.net.iconpln.apps.tp4.model.Rekapitulasi;
import id.net.iconpln.apps.tp4.model.ArsipResponse;
import id.net.iconpln.apps.tp4.model.Berita;
import id.net.iconpln.apps.tp4.model.Jadwal;
import id.net.iconpln.apps.tp4.model.LaporanAkhir;
import id.net.iconpln.apps.tp4.model.Permohonan;
import id.net.iconpln.apps.tp4.model.Proyek;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Ozcan createNew 24/11/2016.
 *
 * @author Ozcan
 */

public interface ServiceApi {

    @FormUrlEncoded
    @POST(ServiceUrl.USER_LOGIN)
    Call<LoginResponse> loginUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @POST(ServiceUrl.BERITA)
    Call<Berita[]> listBerita();

    @FormUrlEncoded
    @POST(ServiceUrl.PROJECT_SUMMARY)
    Call<ProyekSummary[]> proyekSummary(
            @Field("unitid") String unitId);

    @POST(ServiceUrl.PROJECT_SUMMARY_DETAIL)
    Call<Rekapitulasi[]> rekapitulasiDetail();

    @POST(ServiceUrl.JADWAL)
    Call<Jadwal[]> listJadwal();

    @FormUrlEncoded
    @POST(ServiceUrl.PROJECT)
    Call<Proyek[]> listProyek(
            @Field("unitid") String unitId);

    @FormUrlEncoded
    @POST(ServiceUrl.ARSIP)
    Call<ArsipResponse> listArsip(
            @Field("unitid") String unitId);

    @FormUrlEncoded
    @POST(ServiceUrl.DAFTAR_PERMOHONAN)
    Call<Permohonan[]> listPermohonan(
            @Field("unitid") String unitId);

    @FormUrlEncoded
    @POST(ServiceUrl.LAPORAN_AKHIR)
    Call<LaporanAkhir[]> listLaporanAkhir(
            @Field("unitid") String unitId);
}

package id.net.iconpln.kejaksaan.network;

import id.net.iconpln.kejaksaan.model.ArsipResponse;
import id.net.iconpln.kejaksaan.model.BeritaResponse;
import id.net.iconpln.kejaksaan.model.JadwalResponse;
import id.net.iconpln.kejaksaan.model.LaporanAkhirResponse;
import id.net.iconpln.kejaksaan.model.LoginResponse;
import id.net.iconpln.kejaksaan.model.PermohonanResponse;
import id.net.iconpln.kejaksaan.model.ProyekResponse;
import id.net.iconpln.kejaksaan.model.RekapitulasiDetailResponse;
import id.net.iconpln.kejaksaan.model.RekapitulasiResponse;
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

    @FormUrlEncoded
    @POST(ServiceUrl.BERITA)
    Call<BeritaResponse> listBerita();

    @FormUrlEncoded
    @POST(ServiceUrl.PROJECT_SUMMARY)
    Call<RekapitulasiResponse> rekapitulasi(
            @Field("unitid") String unitId);

    @FormUrlEncoded
    @POST(ServiceUrl.PROJECT_SUMMARY_DETAIL)
    Call<RekapitulasiDetailResponse> rekapitulasiDetail();

    @FormUrlEncoded
    @POST(ServiceUrl.JADWAL)
    Call<JadwalResponse> listJadwal();

    @FormUrlEncoded
    @POST(ServiceUrl.PROJECT)
    Call<ProyekResponse> listProyek(
            @Field("unitid") String unitId);

    @FormUrlEncoded
    @POST(ServiceUrl.ARSIP)
    Call<ArsipResponse> listArsip(
            @Field("unitid") String unitId);

    @FormUrlEncoded
    @POST(ServiceUrl.DAFTAR_PERMOHONAN)
    Call<PermohonanResponse> listPermohonan(
            @Field("unitid") String unitId);

    @FormUrlEncoded
    @POST(ServiceUrl.LAPORAN_AKHIR)
    Call<LaporanAkhirResponse> listLaporanAkhir(
            @Field("unitid") String unitId);
}

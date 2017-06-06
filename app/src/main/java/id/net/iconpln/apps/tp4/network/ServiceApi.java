package id.net.iconpln.apps.tp4.network;

import id.net.iconpln.apps.tp4.model.Anev;
import id.net.iconpln.apps.tp4.model.Arsip;
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
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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
            @Field("password") String password);

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
    @POST(ServiceUrl.TRACKING)
    Call<TrackingProject[]> trackingProyek(
            @Field("userid") String userId);

    @FormUrlEncoded
    @POST(ServiceUrl.ARSIP)
    Call<Arsip[]> listArsip(
            @Field("unitid") String unitId);

    @FormUrlEncoded
    @POST(ServiceUrl.DAFTAR_PERMOHONAN)
    Call<Permohonan[]> listPermohonan(
            @Field("unitid") String unitId);

    @FormUrlEncoded
    @POST(ServiceUrl.PENUGASAN)
    Call<Penugasan[]> listPenugasan(
            @Field("userid") String userId);

    @FormUrlEncoded
    @POST(ServiceUrl.GET_KONFIRMASI)
    Call<KonfirmasiResponse> getKonfirmasi(
            @Field("noregistrasi") String noRegistrasi,
            @Field("userid") String userId);


    @FormUrlEncoded
    @POST(ServiceUrl.DO_KONFIRMASI)
    Call<KonfirmasiResponse> konfirmasiPenugasan(
            @Field("noregistrasi") String noRegistrasi,
            @Field("userid") String userId);

    @POST(ServiceUrl.ANEV)
    Call<Anev[]> listAnev();

    @FormUrlEncoded
    @POST(ServiceUrl.WALMAN)
    Call<WalmanResponse> prosesWalman(
            @Field("noregistrasi") String noRegistrasi,
            @Field("anev") String anev,
            @Field("uraian") String uraian,
            @Field("userid") String userid
    );

    @Multipart
    @POST(ServiceUrl.WALMAN_UPLOAD_PHOTO)
    Call<WalmanPhotoResponse> prosesWalmanPhoto(
            @Part("noregistrasi") RequestBody noRegistrasi,
            @Part("seq") RequestBody sequence,
            @Part("nama") RequestBody nama,
            @Part("anev") RequestBody anev,
            @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST(ServiceUrl.LAPORAN_AKHIR)
    Call<LaporanAkhir[]> listLaporanAkhir(
            @Field("unitid") String unitId);
}

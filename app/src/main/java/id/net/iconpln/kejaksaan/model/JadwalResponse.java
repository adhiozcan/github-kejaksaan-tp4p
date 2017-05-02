package id.net.iconpln.kejaksaan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 01/05/2017.
 */

public class JadwalResponse {
    private String jadwalId;
    @SerializedName("AREA_KEJAKSAAN")
    private String daerahKejaksaan;
    @SerializedName("NAMA_AGENDA")
    private String namaAgenda;
    @SerializedName("LOKASI")
    private String lokasi;
    @SerializedName("TANGGAL")
    private String tanggal;
    @SerializedName("WAKTU")
    private String waktu;
    @SerializedName("KETERANGAN")
    private String keterangan;
    @SerializedName("TIME_REMAINING")
    private String jatuhTempo;
}

package id.net.iconpln.kejaksaan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 01/05/2017.
 */

public class BeritaResponse {
    @SerializedName("JUDUL")
    private String judulBerita;
    @SerializedName("TANGGAL")
    private String tanggalTerbit;
    @SerializedName("PENULIS")
    private String penulis;
    @SerializedName("NAMA_FILE")
    private String content;
}

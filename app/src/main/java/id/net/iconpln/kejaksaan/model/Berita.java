package id.net.iconpln.kejaksaan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 15/03/2017.
 */

public class Berita {
    @SerializedName("JUDUL")
    private String judulBerita;
    @SerializedName("TANGGAL")
    private String tanggalTerbit;
    @SerializedName("PENULIS")
    private String penulis;
    @SerializedName("CONTENT")
    private String content;

    public String getJudulBerita() {
        return judulBerita;
    }

    public void setJudulBerita(String judulBerita) {
        this.judulBerita = judulBerita;
    }

    public String getTanggalTerbit() {
        return tanggalTerbit;
    }

    public void setTanggalTerbit(String tanggalTerbit) {
        this.tanggalTerbit = tanggalTerbit;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
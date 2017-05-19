package id.net.iconpln.apps.tp4.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 07/05/2017.
 */

public class ProyekSummary {
    @SerializedName("TOTAL_NASIONAL")
    private String totalNasional;
    @SerializedName("TOTAK_KEJAKSAAN")
    private String totalRegional;
    @SerializedName("TOTAL_MASUK")
    private String proyekMasuk;
    @SerializedName("TOTAL_DITANGANI")
    private String proyekDitangani;
    @SerializedName("TOTAL_SELESAI")
    private String proyekSelesai;
    @SerializedName("TOTAL_DITOLAK")
    private String proyekDitolak;

    public String getTotalNasional() {
        return totalNasional;
    }

    public void setTotalNasional(String totalNasional) {
        this.totalNasional = totalNasional;
    }

    public String getTotalRegional() {
        return totalRegional;
    }

    public void setTotalRegional(String totalRegional) {
        this.totalRegional = totalRegional;
    }

    public String getProyekMasuk() {
        return proyekMasuk;
    }

    public void setProyekMasuk(String proyekMasuk) {
        this.proyekMasuk = proyekMasuk;
    }

    public String getProyekDitangani() {
        return proyekDitangani;
    }

    public void setProyekDitangani(String proyekDitangani) {
        this.proyekDitangani = proyekDitangani;
    }

    public String getProyekSelesai() {
        return proyekSelesai;
    }

    public void setProyekSelesai(String proyekSelesai) {
        this.proyekSelesai = proyekSelesai;
    }

    public String getProyekDitolak() {
        return proyekDitolak;
    }

    public void setProyekDitolak(String proyekDitolak) {
        this.proyekDitolak = proyekDitolak;
    }
}

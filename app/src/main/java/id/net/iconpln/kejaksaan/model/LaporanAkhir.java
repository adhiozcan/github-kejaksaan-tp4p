package id.net.iconpln.kejaksaan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 27/04/2017.
 */

public class LaporanAkhir {
    @SerializedName("NO_PROYEK")
    private String noProject;
    @SerializedName("NAMA_PROYEK")
    private String namaProject;
    @SerializedName("TGL_TERBIT")
    private String tanggalTerbit;
    @SerializedName("RINGKASAN_LAPORAN")
    private String ringkasan;
    @SerializedName("LINK_DOKUMEN")
    private String tautan;

    public String getNoProject() {
        return noProject;
    }

    public void setNoProject(String noProject) {
        this.noProject = noProject;
    }

    public String getNamaProject() {
        return namaProject;
    }

    public void setNamaProject(String namaProject) {
        this.namaProject = namaProject;
    }

    public String getTanggalTerbit() {
        return tanggalTerbit;
    }

    public void setTanggalTerbit(String tanggalTerbit) {
        this.tanggalTerbit = tanggalTerbit;
    }

    public String getRingkasan() {
        return ringkasan;
    }

    public void setRingkasan(String ringkasan) {
        this.ringkasan = ringkasan;
    }

    public String getTautan() {
        return tautan;
    }

    public void setTautan(String tautan) {
        this.tautan = tautan;
    }
}

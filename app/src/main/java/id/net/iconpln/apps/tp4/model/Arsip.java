package id.net.iconpln.apps.tp4.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 27/04/2017.
 */

public class Arsip {
    @SerializedName("NO_PROYEK")
    private String noProject;
    @SerializedName("NAMA_PROYEK")
    private String namaProject;
    @SerializedName("NAMA_PEMOHON")
    private String pemohon;
    @SerializedName("INSTANSI_PEMOHON")
    private String instansiPemohon;
    @SerializedName("TAHUN_PROYEK")
    private String tahun;
    @SerializedName("TGL_MASUK")
    private String tanggalMasuk;
    @SerializedName("TGL_SELESAI")
    private String tanggalSelesai;

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

    public String getPemohon() {
        return pemohon;
    }

    public void setPemohon(String pemohon) {
        this.pemohon = pemohon;
    }

    public String getInstansiPemohon() {
        return instansiPemohon;
    }

    public void setInstansiPemohon(String instansiPemohon) {
        this.instansiPemohon = instansiPemohon;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }
}

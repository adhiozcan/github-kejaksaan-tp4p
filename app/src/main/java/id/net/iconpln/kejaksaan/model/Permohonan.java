package id.net.iconpln.kejaksaan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 08/03/2017.
 */

public class Permohonan {
    @SerializedName("NO_PROYEK")
    private String noProject;
    @SerializedName("JUDUL_PERMOHONAN")
    private String judul;
    @SerializedName("TGL_PERMOHONAN")
    private String tanggalPermohonan;
    @SerializedName("NAMA_PENGAJU")
    private String pemohon;
    @SerializedName("INSTANSI_PENGAJU")
    private String instansi;
    @SerializedName("TUJUAN_PERMOHONAN")
    private String tujuanPermohonan;
    @SerializedName("CONTENT_PERMOHONAN")
    private String content;
    @SerializedName("TGL_PAPARAN")
    private String tanggalPaparan;
    @SerializedName("WAKTU_PAPARAN")
    private String waktuPaparan;
    @SerializedName("KETERANGAN")
    private String keterangan;
    private String pemohonInstansi;
    @SerializedName("STATUS")
    private String status;

    public String getNoProject() {
        return noProject;
    }

    public void setNoProject(String noProject) {
        this.noProject = noProject;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggalPermohonan() {
        return tanggalPermohonan;
    }

    public void setTanggalPermohonan(String tanggalPermohonan) {
        this.tanggalPermohonan = tanggalPermohonan;
    }

    public String getPemohon() {
        return pemohon;
    }

    public void setPemohon(String pemohon) {
        this.pemohon = pemohon;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    public String getTujuanPermohonan() {
        return tujuanPermohonan;
    }

    public void setTujuanPermohonan(String tujuanPermohonan) {
        this.tujuanPermohonan = tujuanPermohonan;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTanggalPaparan() {
        return tanggalPaparan;
    }

    public void setTanggalPaparan(String tanggalPaparan) {
        this.tanggalPaparan = tanggalPaparan;
    }

    public String getWaktuPaparan() {
        return waktuPaparan;
    }

    public void setWaktuPaparan(String waktuPaparan) {
        this.waktuPaparan = waktuPaparan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void createIdentitasPemohon() {
        pemohonInstansi = pemohon + " | " + instansi;
    }

    public String getPemohonInstansi() {
        return pemohonInstansi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

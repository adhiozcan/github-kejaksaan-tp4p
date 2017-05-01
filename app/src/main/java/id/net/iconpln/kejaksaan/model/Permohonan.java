package id.net.iconpln.kejaksaan.model;

/**
 * Created by Ozcan on 08/03/2017.
 */

public class Permohonan {
    private String noProject;
    private String judul;
    private String tanggalPermohonan;
    private String pemohon;
    private String instansi;
    private String tujuanPermohonan;
    private String content;
    private String tanggalPaparan;
    private String waktuPaparan;
    private String keterangan;
    private String pemohonInstansi;

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
}

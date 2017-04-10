package id.net.iconpln.kejaksaan.model;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class Proyek {
    private String judulProyek;
    private String lokasi;
    private String tanggalMulai;
    private String namaPemohon;
    private String instansiPemohon;
    private String durasiPengerjaan;
    private String contentPenjelasan;

    public String getJudulProyek() {
        return judulProyek;
    }

    public void setJudulProyek(String judulProyek) {
        this.judulProyek = judulProyek;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(String tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public String getNamaPemohon() {
        return namaPemohon;
    }

    public void setNamaPemohon(String namaPemohon) {
        this.namaPemohon = namaPemohon;
    }

    public String getInstansiPemohon() {
        return instansiPemohon;
    }

    public void setInstansiPemohon(String instansiPemohon) {
        this.instansiPemohon = instansiPemohon;
    }

    public String getDurasiPengerjaan() {
        return durasiPengerjaan;
    }

    public void setDurasiPengerjaan(String durasiPengerjaan) {
        this.durasiPengerjaan = durasiPengerjaan;
    }

    public String getContentPenjelasan() {
        return contentPenjelasan;
    }

    public void setContentPenjelasan(String contentPenjelasan) {
        this.contentPenjelasan = contentPenjelasan;
    }
}

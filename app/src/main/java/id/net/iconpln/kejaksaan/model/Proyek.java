package id.net.iconpln.kejaksaan.model;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class Proyek {
    private String noProject;
    private String namaProject;
    private String nilai;
    private String keterangan;
    private String lokasi;
    private String tanggalMasuk;
    private String namaPemohon;
    private String instansiPemohon;
    private String durasiPengerjaan;

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

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
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
}

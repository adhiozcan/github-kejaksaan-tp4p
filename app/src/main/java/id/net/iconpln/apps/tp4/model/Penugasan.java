package id.net.iconpln.apps.tp4.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class Penugasan {
    @SerializedName("NO_PROYEK")
    private String  noProject;
    @SerializedName("NO_REGISTRASI")
    private String  noRegistrasi;
    @SerializedName("NAMA_PROYEK")
    private String  namaProject;
    @SerializedName("TGL_MASUK_PROYEK")
    private String  tanggalMasuk;
    @SerializedName("TGL_PAPARAN")
    private String  tanggalPaparan;
    @SerializedName("KETERANGAN")
    private String  keterangan;
    @SerializedName("NAMA_PEMOHON")
    private String  namaPemohon;
    @SerializedName("INSTANSI_PEMOHON")
    private String  instansiPemohon;
    @SerializedName("NILAI_PROYEK")
    private String  nilai;
    @SerializedName("IS_ACCEPTED")
    private boolean isAccept;

    public String getNoProject() {
        return noProject;
    }

    public void setNoProject(String noProject) {
        this.noProject = noProject;
    }

    public String getNoRegistrasi() {
        return noRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        this.noRegistrasi = noRegistrasi;
    }

    public String getNamaProject() {
        return namaProject;
    }

    public void setNamaProject(String namaProject) {
        this.namaProject = namaProject;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getTanggalPaparan() {
        return tanggalPaparan;
    }

    public void setTanggalPaparan(String tanggalPaparan) {
        this.tanggalPaparan = tanggalPaparan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }

    @Override
    public String toString() {
        return "Penugasan{" +
                "noProject='" + noProject + '\'' +
                ", noRegistrasi='" + noRegistrasi + '\'' +
                ", namaProject='" + namaProject + '\'' +
                ", tanggalMasuk='" + tanggalMasuk + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", namaPemohon='" + namaPemohon + '\'' +
                ", instansiPemohon='" + instansiPemohon + '\'' +
                ", nilai='" + nilai + '\'' +
                ", isAccept=" + isAccept +
                '}';
    }
}

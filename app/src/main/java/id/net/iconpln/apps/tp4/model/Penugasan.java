package id.net.iconpln.apps.tp4.model;

/**
 * Created by Ozcan on 10/03/2017.
 */

public class Penugasan {
    private String  noProject;
    private String  namaProject;
    private String  tanggalMasuk;
    private String  keterangan;
    private String  nilai;
    private boolean isAccept;

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

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
}

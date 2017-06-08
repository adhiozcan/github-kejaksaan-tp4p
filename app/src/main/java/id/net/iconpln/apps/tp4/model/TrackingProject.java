package id.net.iconpln.apps.tp4.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 27/04/2017.
 */

public class TrackingProject {
    @SerializedName("NO_PROYEK")
    private String noProject;
    private String namaProject;
    @SerializedName("NAMA_KEGIATAN")
    private String namaUpdate;
    @SerializedName("TGL_UPDATE")
    private String tanggalUpdate;
    @SerializedName("KETERANGAN")
    private String keterangan;

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

    public String getNamaUpdate() {
        return namaUpdate;
    }

    public void setNamaUpdate(String namaUpdate) {
        this.namaUpdate = namaUpdate;
    }

    public String getTanggalUpdate() {
        return tanggalUpdate;
    }

    public void setTanggalUpdate(String tanggalUpdate) {
        this.tanggalUpdate = tanggalUpdate;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}

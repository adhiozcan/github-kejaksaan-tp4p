package id.net.iconpln.kejaksaan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 26/04/2017.
 */

public class Rekapitulasi {
    @SerializedName("NO_PROYEK")
    private String nomorProyek;
    @SerializedName("NAMA_PROYEK")
    private String namaProyek;
    @SerializedName("NILAI_PROYEK")
    private String nilai;
    @SerializedName("BULAN")
    private String bulan;

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getNomorProyek() {
        return nomorProyek;
    }

    public void setNomorProyek(String nomorProyek) {
        this.nomorProyek = nomorProyek;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }


}

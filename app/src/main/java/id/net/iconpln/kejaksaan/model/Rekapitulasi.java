package id.net.iconpln.kejaksaan.model;

/**
 * Created by Ozcan on 26/04/2017.
 */

public class Rekapitulasi {
    private String nomorProyek;
    private String namaProyek;
    private String nilai;
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

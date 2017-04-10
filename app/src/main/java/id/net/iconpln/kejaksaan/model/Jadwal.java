package id.net.iconpln.kejaksaan.model;

/**
 * Created by Ozcan on 09/03/2017.
 */

public class Jadwal {
    private String jadwalId;
    private String judulAcara;
    private String lokasi;
    private String tanggal;
    private String lokasiTanggal;
    private String keterangan;
    private String jatuhTempo;

    public String getJadwalId() {
        return jadwalId;
    }

    public void setJadwalId(String jadwalId) {
        this.jadwalId = jadwalId;
    }

    public String getJudulAcara() {
        return judulAcara;
    }

    public void setJudulAcara(String judulAcara) {
        this.judulAcara = judulAcara;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLokasiTanggal() {
        return lokasiTanggal;
    }

    public void createLokasidanTanggal() {
        this.lokasiTanggal = lokasi + " | " + tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getJatuhTempo() {
        return jatuhTempo;
    }

    public void hitungJatuhTempo() {
        this.jatuhTempo = "4 hari lagi";
    }
}

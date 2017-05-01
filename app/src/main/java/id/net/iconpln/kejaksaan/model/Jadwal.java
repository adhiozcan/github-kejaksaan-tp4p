package id.net.iconpln.kejaksaan.model;

/**
 * Created by Ozcan on 09/03/2017.
 */

public class Jadwal {
    private String jadwalId;
    private String daerahKejaksaan;
    private String namaAgenda;
    private String lokasi;
    private String tanggal;
    private String waktu;
    private String lokasiTanggal;
    private String keterangan;
    private String jatuhTempo;


    public String getJadwalId() {
        return jadwalId;
    }

    public void setJadwalId(String jadwalId) {
        this.jadwalId = jadwalId;
    }

    public String getDaerahKejaksaan() {
        return daerahKejaksaan;
    }

    public void setDaerahKejaksaan(String daerahKejaksaan) {
        this.daerahKejaksaan = daerahKejaksaan;
    }

    public String getNamaAgenda() {
        return namaAgenda;
    }

    public void setNamaAgenda(String namaAgenda) {
        this.namaAgenda = namaAgenda;
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

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getLokasiTanggal() {
        return lokasiTanggal;
    }

    public void setLokasiTanggal(String lokasiTanggal) {
        this.lokasiTanggal = lokasiTanggal;
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

    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public void hitungJatuhTempo() {
        this.jatuhTempo = "4 hari lagi";
    }

    public void createLokasidanTanggal() {
        setLokasiTanggal(lokasi + " | " + tanggal);
    }
}

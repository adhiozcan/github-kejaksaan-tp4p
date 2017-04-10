package id.net.iconpln.kejaksaan.model;

/**
 * Created by Ozcan on 08/03/2017.
 */

public class Permohonan {
    private String judul;
    private String pemohon;
    private String instansi;
    private String identitasPemohon;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
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

    public String getIdentitasPemohon() {
        return identitasPemohon;
    }

    public void createIdentitasPemohon() {
        this.identitasPemohon = pemohon + " | " + instansi;
    }
}

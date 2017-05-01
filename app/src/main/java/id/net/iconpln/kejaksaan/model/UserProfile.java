package id.net.iconpln.kejaksaan.model;

/**
 * Created by Ozcan on 27/04/2017.
 */

public class UserProfile {
    private String idPetugas;
    private String idKejaksaan;
    private String nama;
    private String jabatan;
    private String namaKejaksaan;
    private String foto;
    private String alamat;
    private String email;
    private String mobile;

    public String getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }

    public String getIdKejaksaan() {
        return idKejaksaan;
    }

    public void setIdKejaksaan(String idKejaksaan) {
        this.idKejaksaan = idKejaksaan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNamaKejaksaan() {
        return namaKejaksaan;
    }

    public void setNamaKejaksaan(String namaKejaksaan) {
        this.namaKejaksaan = namaKejaksaan;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

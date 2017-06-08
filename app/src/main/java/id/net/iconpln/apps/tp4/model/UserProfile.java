package id.net.iconpln.apps.tp4.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 27/04/2017.
 */

public class UserProfile {
    @SerializedName("unitid")
    private String idKejaksaan;
    @SerializedName("namaunit")
    private String unitKejaksaan;
    @SerializedName("nama")
    private String nama;
    @SerializedName("role")
    private String jabatan;
    private String alamat;
    @SerializedName("email")
    private String email;
    @SerializedName("mobile")
    private String mobile;
    private String username;
    private String password;

    public String getIdKejaksaan() {
        return idKejaksaan;
    }

    public void setIdKejaksaan(String idKejaksaan) {
        this.idKejaksaan = idKejaksaan;
    }

    public String getUnitKejaksaan() {
        return unitKejaksaan;
    }

    public void setUnitKejaksaan(String unitKejaksaan) {
        this.unitKejaksaan = unitKejaksaan;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "idKejaksaan='" + idKejaksaan + '\'' +
                ", unitKejaksaan='" + unitKejaksaan + '\'' +
                ", nama='" + nama + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", alamat='" + alamat + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

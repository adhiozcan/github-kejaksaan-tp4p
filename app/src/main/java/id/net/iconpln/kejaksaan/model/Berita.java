package id.net.iconpln.kejaksaan.model;

/**
 * Created by Ozcan on 15/03/2017.
 */

public class Berita {
    private String judulBerita;
    private String tanggalTerbit;
    private String penulis;
    private String content;

    public String getJudulBerita() {
        return judulBerita;
    }

    public void setJudulBerita(String judulBerita) {
        this.judulBerita = judulBerita;
    }

    public String getTanggalTerbit() {
        return tanggalTerbit;
    }

    public void setTanggalTerbit(String tanggalTerbit) {
        this.tanggalTerbit = tanggalTerbit;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
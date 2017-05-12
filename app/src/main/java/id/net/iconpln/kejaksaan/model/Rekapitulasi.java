package id.net.iconpln.kejaksaan.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ozcan on 26/04/2017.
 */

public class Rekapitulasi implements Parcelable {
    @SerializedName("NO_PROYEK")
    private String nomorProyek;
    @SerializedName("NAMA_PROYEK")
    private String namaProyek;
    @SerializedName("NILAI_PROYEK")
    private String nilai;
    @SerializedName("BULAN")
    private String bulan;

    public Rekapitulasi(){}

    protected Rekapitulasi(Parcel in) {
        nomorProyek = in.readString();
        namaProyek = in.readString();
        nilai = in.readString();
        bulan = in.readString();
    }

    public static final Creator<Rekapitulasi> CREATOR = new Creator<Rekapitulasi>() {
        @Override
        public Rekapitulasi createFromParcel(Parcel in) {
            return new Rekapitulasi(in);
        }

        @Override
        public Rekapitulasi[] newArray(int size) {
            return new Rekapitulasi[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomorProyek);
        parcel.writeString(namaProyek);
        parcel.writeString(nilai);
        parcel.writeString(bulan);
    }
}

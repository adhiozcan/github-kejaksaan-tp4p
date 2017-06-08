package id.net.iconpln.apps.tp4.utility;

import android.content.Context;
import android.content.ContextWrapper;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.Berita;
import id.net.iconpln.apps.tp4.model.LaporanAkhir;
import id.net.iconpln.apps.tp4.model.Notifikasi;
import id.net.iconpln.apps.tp4.model.Penugasan;
import id.net.iconpln.apps.tp4.model.Proyek;
import id.net.iconpln.apps.tp4.model.Rekapitulasi;

/**
 * Created by Ozcan on 04/06/2017.
 */

public class QueryUtils {

    /**
     * Provide list berita
     *
     * @return
     */
    public static List<Berita> provideListBerita() {
        List<Berita> mockupList = new ArrayList<>();
        Berita       berita1    = new Berita();
        berita1.setJudulBerita("Sosialisasi TP4P Kejaksaan Agung RI Guna Mendukung Proyek Strategis di Kementrian PUPR di Surabaya");
        berita1.setTanggalTerbit("16 Maret 2017");
        berita1.setContent("Selayang pandang TP4 dan Pengawalan dan Pengamanan Proyek Strategis Nasional. Tindak Pidana Korupsi, Mekanisme pengadaan tanah bagi pembangunan untuk kepentingn Umum berdasarkan Undang-Undang No.2 Tahu  2004");

        Berita berita2 = new Berita();
        berita2.setJudulBerita("Sosialisasi TP4P Kejaksaan Agung RI di badan Kependudukan dan Keluarga Berencana Nasional Kantor Pusat");
        berita2.setTanggalTerbit("15 Maret 2017");
        berita2.setContent("Pengenalan Tim Pengawalan dan Pengamanan Pemerintahan dan Pembangunan dan Pengadaan Barang/Jasa Pemerintah berdasarkan Perpres No.54 Tahun 2010");

        Berita berita3 = new Berita();
        berita3.setJudulBerita("Sosialisasi TP4P Kejagung RI Guna Mendukung Proyek Ketenagalistrikan 35.000 MW di Surabaya");
        berita3.setTanggalTerbit("15 Maret 2017");
        berita3.setContent("Sosialisasi Tim TP4P untuk mendukung Proyek Ketenagalistrikan 35.000 MW pada Regional Jawa Bali. Strategi Pengawalan Proyek oleh TP4P");

        mockupList.add(berita1);
        mockupList.add(berita2);
        mockupList.add(berita3);

        return mockupList;
    }

    /**
     * Provide list penugasan.
     *
     * @param context
     * @return
     */
    public static List<Penugasan> provideListPenugasanData(Context context) {
        List<Penugasan> mockupList = new ArrayList<>();
        Penugasan       penugasan  = new Penugasan();
        penugasan.setNoProject("WAL-01.4a-2017");
        penugasan.setNamaProject("Permohonan Pendampingan Hukum Pengadaan Airbus Jet 400");
        penugasan.setTanggalMasuk("24 Mei 2017");
        penugasan.setNilai(context.getString(R.string.ipsum));

        for (int i = 0; i < 6; i++) {
            mockupList.add(penugasan);
        }

        return mockupList;
    }

    /**
     * Provide data list proyek.
     *
     * @param context
     * @return
     */
    public static List<Proyek> provideListProyekData(Context context) {
        List<Proyek> mockupList = new ArrayList<>();

        Proyek proyek = new Proyek();
        proyek.setNamaProject("Nama Proyek");
        proyek.setNamaPemohon("Nama Pemohon");
        proyek.setInstansiPemohon("Instansi Pemohon");
        proyek.setTanggalMasuk("23 Januari 2017");
        proyek.setLokasi("Alamat Proyek");
        proyek.setKeterangan(context.getString(R.string.ipsum));
        proyek.setDurasiPengerjaan("8 hari");

        for (int i = 0; i < 5; i++) {
            mockupList.add(proyek);
        }

        return mockupList;
    }

    /**
     * Provide data notifikasi.
     *
     * @param context
     * @return
     */
    public static List<Notifikasi> provideNotificationData(Context context) {
        List<Notifikasi> mockupList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Notifikasi notif = new Notifikasi();
            notif.setType("Type of Notification");
            notif.setContent(context.getString(R.string.ipsum_short));
            mockupList.add(notif);
        }

        return mockupList;
    }

    public static List<Rekapitulasi> provideRekapitulasiData(Context context) {
        List<Rekapitulasi> mockupList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Rekapitulasi rekap = new Rekapitulasi();
            rekap.setNomorProyek("TP4P-201704-" + (i + 4));
            rekap.setNamaProyek(context.getString(R.string.ipsum_short));
            rekap.setNilai("1280000");

            mockupList.add(rekap);
        }

        return mockupList;
    }

    public static List<LaporanAkhir> provideLaporanAkhirList() {

        List<LaporanAkhir> mockuplist = new ArrayList<>();

        LaporanAkhir laporanAkhir = new LaporanAkhir();
        laporanAkhir.setNoProject("201701-TP4-01");
        laporanAkhir.setNamaProject("Sosialisasi TP4P Kejaksaan Agung RI Guna Mendukung Proyek Strategis di Kementrian PUPR di Surabaya");
        laporanAkhir.setTanggalTerbit("16 Januari 2017");
        laporanAkhir.setRingkasan("Selayang pandang TP4 dan Pengawalan dan Pengamanan Proyek Strategis Nasional. Tindak Pidana Korupsi, Mekanisme pengadaan tanah bagi pembangunan untuk kepentingn Umum berdasarkan Undang-Undang No.2 Tahu  2004");

        LaporanAkhir laporanAkhir2 = new LaporanAkhir();
        laporanAkhir2.setNoProject("201703-TP4-2");
        laporanAkhir2.setNamaProject("Sosialisasi TP4P Kejaksaan Agung RI di badan Kependudukan dan Keluarga Berencana Nasional Kantor Pusat");
        laporanAkhir2.setTanggalTerbit("18 Maret 2017");
        laporanAkhir2.setRingkasan("Pengenalan Tim Pengawalan dan Pengamanan Pemerintahan dan Pembangunan dan Pengadaan Barang/Jasa Pemerintah berdasarkan Perpres No.54 Tahun 2010");

        LaporanAkhir laporanAkhir3 = new LaporanAkhir();
        laporanAkhir3.setNoProject("2017-TP4-3");
        laporanAkhir3.setNamaProject("Sosialisasi TP4P Kejagung RI Guna Mendukung Proyek Ketenagalistrikan 35.000 MW di Surabaya");
        laporanAkhir3.setTanggalTerbit("19 April 2017");
        laporanAkhir3.setRingkasan("Sosialisasi Tim TP4P untuk mendukung Proyek Ketenagalistrikan 35.000 MW pada Regional Jawa Bali. Strategi Pengawalan Proyek oleh TP4P");

        mockuplist.add(laporanAkhir);
        mockuplist.add(laporanAkhir2);
        mockuplist.add(laporanAkhir3);
        return mockuplist;
    }
}

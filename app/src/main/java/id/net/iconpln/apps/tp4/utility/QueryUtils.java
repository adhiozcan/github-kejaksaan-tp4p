package id.net.iconpln.apps.tp4.utility;

import android.content.Context;
import android.content.ContextWrapper;

import java.util.ArrayList;
import java.util.List;

import id.net.iconpln.apps.tp4.R;
import id.net.iconpln.apps.tp4.model.Notifikasi;
import id.net.iconpln.apps.tp4.model.Penugasan;
import id.net.iconpln.apps.tp4.model.Proyek;
import id.net.iconpln.apps.tp4.model.Rekapitulasi;

/**
 * Created by Ozcan on 04/06/2017.
 */

public class QueryUtils {
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
}

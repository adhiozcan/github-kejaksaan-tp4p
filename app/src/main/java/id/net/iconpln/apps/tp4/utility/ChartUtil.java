package id.net.iconpln.apps.tp4.utility;

import java.util.List;

import id.net.iconpln.apps.tp4.model.Rekapitulasi;

/**
 * Created by rizmaulana on 12/05/17.
 */

public class ChartUtil {
    private static String[] mLabels = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nov", "Des"};

    public static String[] getShortMonthLabel(){
        return mLabels;
    }

    public static float[] getRekapMonthValue(List<Rekapitulasi> mRekapitulasis){
        float[] data = new float[12];
        for (int i=0; i<data.length; i++){
            data[i] = getRekap(mRekapitulasis, i+1);
        }
        return data;
    }


    public static float getRekap(List<Rekapitulasi> mRekapitulasis, int index){
        float data = 0;
        for (Rekapitulasi rekap : mRekapitulasis){
            if (Integer.valueOf(rekap.getBulan()) == index){
                data = data + (Long.valueOf(rekap.getNilai())/1000000);
            }
        }
        return data;
    }

}

package id.net.iconpln.kejaksaan.utility;

import java.util.List;

import id.net.iconpln.kejaksaan.model.Rekapitulasi;

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

        return data;
    }
}

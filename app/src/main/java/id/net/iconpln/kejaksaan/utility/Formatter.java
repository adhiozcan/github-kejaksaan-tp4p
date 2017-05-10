package id.net.iconpln.kejaksaan.utility;

import android.util.Log;

import java.text.NumberFormat;

import static android.R.attr.data;
import static android.R.attr.id;
import static android.R.attr.value;
import static android.content.ContentValues.TAG;

/**
 * Created by rizmaulana on 10/05/17.
 */

public class Formatter {

    public static String getCurrencyFormat(String number){
        String data;
        String denom = "";

        int stringLength = number.length();
        if (stringLength > 0){
            if (stringLength >= 6 && stringLength <= 9){
                //juta
                data = number.substring(0, 3);
                denom = " Juta";
            } else if (stringLength >= 10 && stringLength <= 13){
                //miliar
                data = number.substring(0, 3);
                denom = " Miliar";
            } else if (stringLength >= 14 && stringLength <= 17){
                //triliun
                data = number.substring(0, 3);
                denom = " Triliun";
            }else {
                data = number.replace(",", ".");
            }
            return "Rp "+NumberFormat.getIntegerInstance().format(Integer.valueOf(data))+denom;
        }else {
            Log.i(TAG, "getCurrencyFormat: Cannot format zero lenght String");
            return number;

        }
    }
}

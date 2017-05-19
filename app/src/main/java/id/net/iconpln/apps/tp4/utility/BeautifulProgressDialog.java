package id.net.iconpln.apps.tp4.utility;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import id.net.iconpln.apps.tp4.R;


/**
 * Dibuat oleh Rizki Maulana
 * rizmaulana@live.com
 * Kelas ini digunakan untuk membuat progress dialog yang cantique sekali.
 */

public class BeautifulProgressDialog {
    private Context  context;
    private TextView mTxtMsg;
    private Dialog   mDialog;

    public BeautifulProgressDialog(Activity context) {

        LayoutInflater inflater   = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View           dialogView = inflater.inflate(R.layout.dialog_info_loader, null);
        Dialog         dialog     = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogView);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        this.context = context;
        this.mTxtMsg = (TextView) dialogView.findViewById(R.id.txt_message);
        this.mDialog = dialog;
    }

    public void setMessage(String message){
        this.mTxtMsg.setText(message);
    }

    public void show(){
        this.mDialog.show();
    }

    public void dismiss(){
        this.mDialog.dismiss();
    }


}

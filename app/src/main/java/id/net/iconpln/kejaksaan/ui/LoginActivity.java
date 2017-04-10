package id.net.iconpln.kejaksaan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flaviofaria.kenburnsview.KenBurnsView;

import id.net.iconpln.kejaksaan.R;

/**
 * Created by Ozcan on 07/03/2017.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        KenBurnsView kbv = (KenBurnsView) findViewById(R.id.kenburns_effect);
        kbv.resume();
    }

    public void onLoginButtonClicked(View buttonId) {
        navigateTo(MainActivity.class);
    }

    private void navigateTo(Class activity) {
        Intent intentActivity = new Intent(this, activity);
        startActivity(intentActivity);
    }
}

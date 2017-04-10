package id.net.iconpln.kejaksaan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import id.net.iconpln.kejaksaan.R;

/**
 * Created by Ozcan on 06/03/2017.
 */

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        checkVersionInfo();
        displaySplash();
    }

    private void displaySplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private void checkVersionInfo() {
        TextView footer = (TextView) findViewById(R.id.footer);
        footer.setText(getResources().getString(R.string.footer));
    }
}

package id.net.iconpln.kejaksaan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.HashMap;
import java.util.Map;

import id.net.iconpln.kejaksaan.KejaksaanApp;
import id.net.iconpln.kejaksaan.R;
import id.net.iconpln.kejaksaan.model.LoginResponse;
import id.net.iconpln.kejaksaan.model.UserProfile;
import id.net.iconpln.kejaksaan.network.Param;
import id.net.iconpln.kejaksaan.network.RequestServer;
import id.net.iconpln.kejaksaan.network.ResponseListener;
import id.net.iconpln.kejaksaan.network.ServiceUrl;

/**
 * Created by Ozcan on 07/03/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorLayout;
    private EditText          edUsername;
    private EditText          edPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        edUsername = (EditText) findViewById(R.id.username);
        edPassword = (EditText) findViewById(R.id.password);

        KenBurnsView kbv = (KenBurnsView) findViewById(R.id.kenburns_effect);
        kbv.resume();
    }

    public void onLoginButtonClicked(View buttonId) {
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();

        if (validateInput(username, password)) {
            doLogin(username, password);
        }
    }

    private boolean checkIsEmpty(String field) {
        if (TextUtils.isEmpty(field))
            return true;
        return false;
    }

    private boolean validateInput(String username, String password) {
        if (checkIsEmpty(username)) {
            edUsername.setError("Username tidak boleh kosong");
            return false;
        }
        if (checkIsEmpty(password)) {
            edPassword.setError("Password tidak boleh kosong");
            return false;
        }
        return true;
    }

    private void doLogin(String username, String password) {
        Map<String, String> param = new HashMap<>();
        param.put(Param.USERNAME, username);
        param.put(Param.PASSWORD, password);
        RequestServer request = new RequestServer(ServiceUrl.USER_LOGIN, param);
        request.execute(new ResponseListener<LoginResponse>() {
            @Override
            public void onResponse(LoginResponse response) {
                if (response.getIsSuccess()) {
                    saveUserInfo(response.getUserProfile());
                    navigateTo(MainActivity.class);
                } else {
                    Snackbar snackbar = Snackbar.make(coordinatorLayout, "Username atau Password tidak ditemukan.", Snackbar.LENGTH_LONG);
                    snackbar.getView().setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.pink_A200));
                    snackbar.show();
                }
            }

            @Override
            public void onFailed(String message) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Gagal terhubung jaringan.", Snackbar.LENGTH_LONG);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.pink_A200));
                snackbar.show();
            }
        });
    }

    private void saveUserInfo(UserProfile userProfile) {
        KejaksaanApp.PROFILE = userProfile;
        KejaksaanApp.LOGIN_ID = userProfile.getIdPetugas();
        KejaksaanApp.LOGIN_NAME = userProfile.getNama();
        KejaksaanApp.KEJAKSAAN_ID = userProfile.getIdKejaksaan();
        KejaksaanApp.KEJAKSAAN_NAME = userProfile.getUnitKejaksaan();

        Log.d("LoginActivity", "saveUserInfo: ------------------------------------------------------------");
        Log.d("LoginActivity", "saveUserInfo: " + userProfile.toString());
    }

    private void navigateTo(Class activity) {
        Intent intentActivity = new Intent(this, activity);
        startActivity(intentActivity);
    }
}

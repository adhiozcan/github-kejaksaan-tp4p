package id.net.iconpln.apps.tp4.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;

import id.net.iconpln.apps.tp4.Config;
import id.net.iconpln.apps.tp4.R;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;
import java.util.Map;

import id.net.iconpln.apps.tp4.KejaksaanApp;
import id.net.iconpln.apps.tp4.jobservice.ReminderJob;
import id.net.iconpln.apps.tp4.model.LoginResponse;
import id.net.iconpln.apps.tp4.model.UserProfile;
import id.net.iconpln.apps.tp4.network.Param;
import id.net.iconpln.apps.tp4.network.RequestServer;
import id.net.iconpln.apps.tp4.network.ResponseListener;
import id.net.iconpln.apps.tp4.network.ServiceUrl;
import id.net.iconpln.apps.tp4.utility.BeautifulProgressDialog;
import id.net.iconpln.apps.tp4.utility.NetworkUtil;

/**
 * Created by Ozcan on 07/03/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private CoordinatorLayout       coordinatorLayout;
    private EditText                edUsername;
    private EditText                edPassword;
    private CheckBox                chkRemember;
    private BeautifulProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseMessaging.getInstance().subscribeToTopic("berita");

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        edUsername = (EditText) findViewById(R.id.username);
        edPassword = (EditText) findViewById(R.id.password);
        chkRemember = (CheckBox) findViewById(R.id.remember_me);
        chkRemember.setChecked(Config.User.isAlwaysRemember());
        chkRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Config.User.setAlwaysRemember(b);
            }
        });

        /**
         * Get user information from local storage.
         */
        if (Config.User.isAlwaysRemember()) {
            UserProfile user = Config.User.getLocalInfoUser();
            if (user != null && user.getUsername() != null) {
                edUsername.setText(user.getUsername());
                edPassword.setText(user.getPassword());
            } else {
                chkRemember.setChecked(false);
            }
        }

        mProgressDialog = new BeautifulProgressDialog(this);
        mProgressDialog.setMessage("Autentikasi pengguna, harap tunggu ...");

        KenBurnsView kbv = (KenBurnsView) findViewById(R.id.kenburns_effect);
        kbv.resume();

        // Create a new dispatcher using the Google Play driver.
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
        Job myJob = dispatcher.newJobBuilder()
                .setService(ReminderJob.class) // the JobService that will be called
                .setTag("my-unique-tag")        // uniquely identifies the job
                .build();

        dispatcher.mustSchedule(myJob);
    }

    public void onLoginButtonClicked(View buttonId) {
        if (!NetworkUtil.isConnectToInternet(this)) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.container_layout),
                    "Tidak ada jaringan internet",
                    Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.pink_A200));
            snackbar.show();
            return;
        }

        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();
        //String username = "petugas";
        //String password = "tp4pass";

        if (validateInput(username, password)) {
            doLogin(username, password);
        }
    }

    private boolean validateInput(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            edUsername.setError("Username tidak boleh kosong");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            edPassword.setError("Password tidak boleh kosong");
            return false;
        }
        return true;
    }

    private void doLogin(String username, String password) {
        mProgressDialog.show();

        KejaksaanApp.username = username;
        KejaksaanApp.password = password;

        Map<String, String> param = new HashMap<>();
        param.put(Param.USERNAME, username);
        param.put(Param.PASSWORD, password);

        RequestServer request = new RequestServer(ServiceUrl.USER_LOGIN, param);
        request.execute(new ResponseListener<LoginResponse>() {
            @Override
            public void onResponse(LoginResponse response) {
                mProgressDialog.dismiss();
                if (response.getIsSuccess()) {
                    if (Config.User.isAlwaysRemember()) {
                        UserProfile userProfile = response.getUserProfile();
                        userProfile.setUsername(KejaksaanApp.username);
                        userProfile.setPassword(KejaksaanApp.password);
                        Config.User.saveLocalInfoUser(userProfile);
                    }
                    createCurrentSession(response.getUserProfile());
                    navigateTo(MainActivity.class);
                } else {
                    Snackbar snackbar = Snackbar.make(coordinatorLayout, "Username atau Password tidak ditemukan.", Snackbar.LENGTH_LONG);
                    snackbar.getView().setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.pink_A200));
                    snackbar.show();
                }
            }

            @Override
            public void onFailed(String message) {
                mProgressDialog.dismiss();
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Gagal terhubung jaringan.", Snackbar.LENGTH_LONG);
                snackbar.getView().setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.pink_A200));
                snackbar.show();
            }
        });
    }

    private void createCurrentSession(UserProfile userProfile) {
        KejaksaanApp.profile = userProfile;
        KejaksaanApp.userId = edUsername.getText().toString();
        KejaksaanApp.kejaksaanId = userProfile.getIdKejaksaan();
        //KejaksaanApp.kejaksaanId = "5";

        Log.d("LoginActivity", "createCurrentSession: ------------------------------------------------------------");
        Log.d("LoginActivity", "createCurrentSession: " + userProfile.toString());
    }

    private void navigateTo(Class activity) {
        Intent intentActivity = new Intent(this, activity);
        startActivity(intentActivity);
    }
}

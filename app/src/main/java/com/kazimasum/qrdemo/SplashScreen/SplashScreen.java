package com.kazimasum.qrdemo.SplashScreen;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.kazimasum.qrdemo.Authentication.LoginModule.Login;
import com.kazimasum.qrdemo.MainActivity;
import com.kazimasum.qrdemo.R;
import com.kazimasum.qrdemo.Session.SharedPreference;
import com.kazimasum.qrdemo.scannerView;

public class SplashScreen extends AppCompatActivity {
SharedPreference sharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreference = new SharedPreference(getApplicationContext());
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.codeFilesColor));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                if(sharedPreference.isLogin())
                {
                    try {
                        sleep(500);
                        startActivity(new Intent(SplashScreen.this, scannerView.class));
                        finish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else {
                    try {
                        sleep(500);
                        startActivity(new Intent(SplashScreen.this, Login.class));
                        finish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        });
        thread.start();
    }
}
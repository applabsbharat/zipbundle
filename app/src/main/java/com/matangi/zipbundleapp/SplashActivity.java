package com.matangi.zipbundleapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.matangi.zipbundleapp.activity.HomeActivity;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by matangi.agarwal on 2/10/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);
        Fabric.with(this, new Crashlytics());
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(
                new Runnable() {

                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                        finish();
                    }
                }, 3000);
    }
}

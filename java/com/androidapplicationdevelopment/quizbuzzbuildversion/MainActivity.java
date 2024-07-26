package com.androidapplicationdevelopment.quizbuzzbuildversion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {
    public MaterialCardView easycard, mediumcard, toughcard, aboutcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easycard = (MaterialCardView) findViewById(R.id.easyCard);
        mediumcard = (MaterialCardView) findViewById(R.id.mediumCard);
        toughcard = (MaterialCardView) findViewById(R.id.toughCard);
        aboutcard = (MaterialCardView) findViewById(R.id.aboutCard);

        easycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EBpage.class));
            }
        });

        mediumcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MBpage.class));
            }
        });

        toughcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EBpage.class));
            }
        });

        aboutcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            }
        });
    }

    @Override
    public void onBackPressed () {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Are you sure want to exit the app?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        materialAlertDialogBuilder.show();
        super.onBackPressed();
    }


    @SuppressLint("CustomSplashScreen")
    public static class SplashActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            Thread mSplashThread;
            mSplashThread = new Thread() {
                @Override
                public void run() {
                    try {
                        synchronized (this) {
                            wait(2000);
                        }
                    } catch (InterruptedException ignored) {
                    } finally {
                        startActivity(new Intent(getApplicationContext(), com.androidapplicationdevelopment.quizbuzzbuildversion.MainActivity.class));
                        finish();
                    }
                }
            };
            mSplashThread.start();
        }
    }
}
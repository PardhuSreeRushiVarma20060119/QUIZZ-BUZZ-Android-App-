package com.androidapplicationdevelopment.quizbuzzbuildversion;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class EBpage extends AppCompatActivity {

    public MaterialCardView Mathcard, Phycard, Chemcard, Computercard;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ebpage);
        Mathcard = (MaterialCardView) findViewById(R.id.Mathcard);
        Phycard = (MaterialCardView) findViewById(R.id.Phycard);
        Chemcard = (MaterialCardView) findViewById(R.id.Chemcard);
        Computercard = (MaterialCardView) findViewById(R.id.Computercard);

        Mathcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EBpage.this, MathPage.class));
            }
        });

        Phycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EBpage.this, PhyPage.class));
            }
        });

        Chemcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EBpage.this, ToughBuzzer.class));
            }
        });

        Computercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EBpage.this, AboutUs.class));
            }
        });
    }

    @Override
    public void onBackPressed () {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(EBpage.this);
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
}
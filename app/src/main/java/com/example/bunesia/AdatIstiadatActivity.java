package com.example.bunesia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdatIstiadatActivity extends AppCompatActivity {

    ImageButton backAdat, menuAdat;
    LinearLayout keRumah, keAcara, kePakaian, keSenjata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adat_istiadat);

        backAdat = findViewById(R.id.backAdat);
        menuAdat = findViewById(R.id.menuAdat);
        keRumah = findViewById(R.id.keRumah);
        keAcara = findViewById(R.id.keAcara);
        kePakaian = findViewById(R.id.kePakaian);
        keSenjata = findViewById(R.id.keSenjata);

        buttonNav();
    }

    public void buttonNav(){
        backAdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        keRumah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdatIstiadatActivity.this, RumahAdatActivity.class);
                startActivity(intent);
                 
            }
        });
        keAcara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdatIstiadatActivity.this, AcaraAdatActivity.class);
                startActivity(intent);
                 
            }
        });
        keSenjata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdatIstiadatActivity.this, SenjataTradisionalActivity.class);
                startActivity(intent);
                 
            }
        });
        kePakaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdatIstiadatActivity.this, PakaianTradisionalActivity.class);
                startActivity(intent);
                 
            }
        });

        menuAdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AdatIstiadatActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_menu,null);
                mBuilder.setView(mView);


                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                ImageButton closeMenu = mView.findViewById(R.id.menuClose);
                closeMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                TextView homeDialog = mView.findViewById(R.id.homeDialog);
                homeDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdatIstiadatActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                TextView ceritaDialog = mView.findViewById(R.id.ceritaDialog);
                ceritaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdatIstiadatActivity.this, CeritaDaerahActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                TextView kesenianDialog = mView.findViewById(R.id.kesenianDialog);
                kesenianDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdatIstiadatActivity.this, KesenianDaerahActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                TextView adatDialog = mView.findViewById(R.id.adatDialog);
                adatDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdatIstiadatActivity.this, AdatIstiadatActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                TextView tanyaDialog = mView.findViewById(R.id.tanyaDialog);
                tanyaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdatIstiadatActivity.this, TanyaBuNesiaActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                TextView quizDialog = mView.findViewById(R.id.quizDialog);
                quizDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdatIstiadatActivity.this, QuizBuNesiaActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }

        });
    }

}

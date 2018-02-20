package com.example.bunesia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class KesenianDaerahActivity extends AppCompatActivity {
    
    ImageButton backKesenian, menuKesenian;
    LinearLayout keAlat, keLagu, keTari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kesenian_daerah);
        
        backKesenian = findViewById(R.id.backKesenian);
        menuKesenian = findViewById(R.id.menuKesenian);
        keAlat = findViewById(R.id.keAlat);
        keLagu = findViewById(R.id.keLagu);
        keTari = findViewById(R.id.keTari);
        
        buttonNav();
    }

    public void buttonNav(){
        backKesenian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        keLagu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KesenianDaerahActivity.this, LaguDaerahActivity.class);
                startActivity(intent);
                 
            }
        });
        keTari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KesenianDaerahActivity.this, TariTradisionalActivity.class);
                startActivity(intent);
                 
            }
        });
        keAlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KesenianDaerahActivity.this, AlatMusikActivity.class);
                startActivity(intent);
                 
            }
        });

        menuKesenian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(KesenianDaerahActivity.this);
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
                        Intent intent = new Intent(KesenianDaerahActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                         
                    }
                });
                TextView AlatDialog = mView.findViewById(R.id.ceritaDialog);
                AlatDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(KesenianDaerahActivity.this, CeritaDaerahActivity.class);
                        startActivity(intent);
                        finish();
                         
                    }
                });
                TextView kesenianDialog = mView.findViewById(R.id.kesenianDialog);
                kesenianDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(KesenianDaerahActivity.this, KesenianDaerahActivity.class);
                        startActivity(intent);
                        finish();
                         
                    }
                });
                TextView adatDialog = mView.findViewById(R.id.adatDialog);
                adatDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(KesenianDaerahActivity.this, AdatIstiadatActivity.class);
                        startActivity(intent);
                        finish();
                         
                    }
                });
                TextView tanyaDialog = mView.findViewById(R.id.tanyaDialog);
                tanyaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(KesenianDaerahActivity.this, TanyaBuNesiaActivity.class);
                        startActivity(intent);
                        finish();
                         
                    }
                });
                TextView quizDialog = mView.findViewById(R.id.quizDialog);
                quizDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(KesenianDaerahActivity.this, QuizBuNesiaActivity.class);
                        startActivity(intent);
                        finish();
                         
                    }
                });

            }

        });
    }

}

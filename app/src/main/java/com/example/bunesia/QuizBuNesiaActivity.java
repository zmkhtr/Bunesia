package com.example.bunesia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizBuNesiaActivity extends AppCompatActivity {
    
    ImageButton btnBackQuiz, btnBackMenu;
    EditText namaQuiz;
    Button btnMulaiQuiz;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_bu_nesia);
        
        btnBackQuiz = findViewById(R.id.btnBackQuiz);
        btnBackMenu = findViewById(R.id.btnMenuQuiz);
        namaQuiz = findViewById(R.id.namaQuiz);
        btnMulaiQuiz = findViewById(R.id.btnMulaiQuiz);
        intent = new Intent(QuizBuNesiaActivity.this, TemplateQuizActivity.class);

        nama();
        buttonNav();
    }
    private void nama(){
        btnMulaiQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = namaQuiz.getText().toString();
                if (nama.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Nama tidak Boleh Kosong !", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("nama", nama);
                    startActivity(intent);
                }
            }
        });
    }

    private void buttonNav(){
        btnBackQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(QuizBuNesiaActivity.this);
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
                        Intent intent = new Intent(QuizBuNesiaActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView ceritaDialog = mView.findViewById(R.id.ceritaDialog);
                ceritaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(QuizBuNesiaActivity.this, CeritaDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView kesenianDialog = mView.findViewById(R.id.kesenianDialog);
                kesenianDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(QuizBuNesiaActivity.this, KesenianDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView adatDialog = mView.findViewById(R.id.adatDialog);
                adatDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(QuizBuNesiaActivity.this, AdatIstiadatActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView tanyaDialog = mView.findViewById(R.id.tanyaDialog);
                tanyaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(QuizBuNesiaActivity.this, QuizBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView quizDialog = mView.findViewById(R.id.quizDialog);
                quizDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(QuizBuNesiaActivity.this, QuizBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

            }

        });
    }
}

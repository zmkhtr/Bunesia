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

import com.example.bunesia.API.ApiService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TanyaBuNesiaActivity extends AppCompatActivity {

    EditText et_nama, et_pertanyaan;
    Button bt_add, bt_listqna;
    ImageButton btnBackTanya,btnMenuTanya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanya_bu_nesia);

        et_nama = findViewById(R.id.et_nama_penanya);
        et_pertanyaan =  findViewById(R.id.et_pertanyaan);

        bt_listqna = findViewById(R.id.bt_listqna);
        bt_listqna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TanyaBuNesiaActivity.this, ListQnaActivity.class);
                startActivity(intent);

            }
        });

        btnBackTanya = findViewById(R.id.btnBackTanya);
        btnMenuTanya = findViewById(R.id.btnMenuTanya);


        bt_add = findViewById(R.id.bt_tanya);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama = et_nama.getText().toString();
                String Pertanyaan = et_pertanyaan.getText().toString();
                String Jawaban = "Belum Dijawab";
                if (Nama.isEmpty() && Pertanyaan.isEmpty()){
                    Toast.makeText(TanyaBuNesiaActivity.this, "Tidak Boleh Kosong !", Toast.LENGTH_SHORT).show();
                } else if (Nama.isEmpty() ){
                    Toast.makeText(TanyaBuNesiaActivity.this, "Nama Tidak Boleh Kosong !", Toast.LENGTH_SHORT).show();
                } else if (Pertanyaan.isEmpty()){
                    Toast.makeText(TanyaBuNesiaActivity.this, "Pertanyaan Tidak Boleh Kosong !", Toast.LENGTH_SHORT).show();
                }else{
                    tambahData(Nama, Pertanyaan, Jawaban);
                }

            }
        });
        buttonNav();
    }
    public void tambahData(String nama, String pertanyaan,String jawaban) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<ResponseBody> call = service.tambahPertanyaan(nama, pertanyaan, jawaban);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                BufferedReader reader = null;

                String respon = "";

                try {
                    reader = new BufferedReader(new InputStreamReader(response.body().byteStream()));
                    respon = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(TanyaBuNesiaActivity.this, respon, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(TanyaBuNesiaActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void buttonNav(){
        btnBackTanya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnMenuTanya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(TanyaBuNesiaActivity.this);
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
                        Intent intent = new Intent(TanyaBuNesiaActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView ceritaDialog = mView.findViewById(R.id.ceritaDialog);
                ceritaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TanyaBuNesiaActivity.this, CeritaDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView kesenianDialog = mView.findViewById(R.id.kesenianDialog);
                kesenianDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TanyaBuNesiaActivity.this, KesenianDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView adatDialog = mView.findViewById(R.id.adatDialog);
                adatDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TanyaBuNesiaActivity.this, AdatIstiadatActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView tanyaDialog = mView.findViewById(R.id.tanyaDialog);
                tanyaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TanyaBuNesiaActivity.this, TanyaBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView quizDialog = mView.findViewById(R.id.quizDialog);
                quizDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TanyaBuNesiaActivity.this, QuizBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

            }

        });
    }
}

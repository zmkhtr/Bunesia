package com.example.bunesia;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bunesia.API.ApiService;
import com.example.bunesia.Adapter.ListArrayCerita;
import com.example.bunesia.Model.ModelCerita;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CeritaDaerahActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    ArrayList<ModelCerita> dataCerita = new ArrayList<>();
    ListView listview;
    ListArrayCerita adapter;

    LinearLayout layout_loading;
    TextView text_load;
    ImageView icon_load;

    ImageButton backCeritaDaerah,menuCeritaDaerah;

    SwipeRefreshLayout swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerita_daerah);

        layout_loading = findViewById(R.id.layout_loading);

        text_load = findViewById(R.id.text_load);
        icon_load = findViewById(R.id.icon_load);
        swipe = findViewById(R.id.RefreshCerita);

        backCeritaDaerah = findViewById(R.id.btnBackCerita);
        menuCeritaDaerah = findViewById(R.id.btnMenuCerita);


        listview = findViewById(R.id.ListCerita);
        listview.setOnItemClickListener(CeritaDaerahActivity.this);
        listview.setDividerHeight(0);


        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           setup();
                       }
                   });

        buttonNav();
    }


    public void setup() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        swipe.setRefreshing(true);

        ApiService service = retrofit.create(ApiService.class);

        Call<List<ModelCerita>> call = service.getSemuaContentCerita();
        call.enqueue(new Callback<List<ModelCerita>>() {
            @Override
            public void onResponse(Call<List<ModelCerita>> call, Response<List<ModelCerita>> response) {

                if (response.isSuccessful()) {
                    int jumlah = response.body().size();

                    for (int i = 0; i < jumlah; i++) {

                        ModelCerita data = new ModelCerita(
                                response.body().get(i).getIdCerita(),
                                response.body().get(i).getGambarCerita(),
                                response.body().get(i).getJudulCerita(),
                                response.body().get(i).getAudioCerita(),
                                response.body().get(i).getAsalCerita());
                        dataCerita.add(data);
                        Log.d("RESPON", "onResponse: " + response.body().get(i).getGambarCerita());

                    }
                    listview.setVisibility(View.VISIBLE);
                    adapter = new ListArrayCerita(CeritaDaerahActivity.this, R.layout.row_simple, dataCerita);
                    listview.setAdapter(adapter);

                    if (adapter.getCount() < 1 ) {
                        layout_loading.setVisibility(View.VISIBLE);
                        String error = "Daftar Cerita Kosong";
                        text_load.setText(error);
                        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_data_kosong);
                        icon_load.setImageBitmap(icon);
                    } else {
                        layout_loading.setVisibility(View.GONE);
                    }
                } else {
                    String error = "Error Retrive Data from Server !!!";
                    text_load.setText(error);
                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                    icon_load.setImageBitmap(icon);

                }

                swipe.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<List<ModelCerita>> call, Throwable t) {
                String error = "Error Retrive Data from Server wwaau!!!\n" + t.getMessage();
                text_load.setText(error);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                icon_load.setImageBitmap(icon);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView IdCerita = view.findViewById(R.id.HiddenIdsimple);
        Intent intent = new Intent(CeritaDaerahActivity.this, ViewCeritaActivity.class);
        intent.putExtra(ModelCerita.id, IdCerita.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            adapter.clear();
            setup();
        }
    }

    @Override
    public void onRefresh() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void buttonNav(){
        backCeritaDaerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        menuCeritaDaerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CeritaDaerahActivity.this);
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
                        Intent intent = new Intent(CeritaDaerahActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView ceritaDialog = mView.findViewById(R.id.ceritaDialog);
                ceritaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CeritaDaerahActivity.this, CeritaDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView kesenianDialog = mView.findViewById(R.id.kesenianDialog);
                kesenianDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CeritaDaerahActivity.this, KesenianDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView adatDialog = mView.findViewById(R.id.adatDialog);
                adatDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CeritaDaerahActivity.this, AdatIstiadatActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView tanyaDialog = mView.findViewById(R.id.tanyaDialog);
                tanyaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CeritaDaerahActivity.this, TanyaBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView quizDialog = mView.findViewById(R.id.quizDialog);
                quizDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CeritaDaerahActivity.this, QuizBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

            }

        });
    }


}

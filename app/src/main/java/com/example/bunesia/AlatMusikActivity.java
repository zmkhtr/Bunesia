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
import com.example.bunesia.Adapter.ListArrayAlat;
import com.example.bunesia.Model.ModelAlat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlatMusikActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    ArrayList<ModelAlat> dataAlat = new ArrayList<>();
    ListView listview;
    ListArrayAlat adapter;

    LinearLayout layout_loading;
    TextView text_load;
    ImageView icon_load;

    ImageButton backAlatDaerah,menuAlatDaerah;
    SwipeRefreshLayout swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alat_musik);

        layout_loading = findViewById(R.id.layout_loading);

        text_load = findViewById(R.id.text_load);
        icon_load = findViewById(R.id.icon_load);
        swipe = findViewById(R.id.RefreshAlat);

        backAlatDaerah = findViewById(R.id.btnBackAlat);
        menuAlatDaerah = findViewById(R.id.BtnMenuAlat);


        listview = findViewById(R.id.ListAlat);
        listview.setOnItemClickListener(AlatMusikActivity.this);
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

        Call<List<ModelAlat>> call = service.getSemuaContentAlat();
        call.enqueue(new Callback<List<ModelAlat>>() {
            @Override
            public void onResponse(Call<List<ModelAlat>> call, Response<List<ModelAlat>> response) {

                if (response.isSuccessful()) {
                    int jumlah = response.body().size();

                    for (int i = 0; i < jumlah; i++) {

                        ModelAlat data = new ModelAlat(
                                response.body().get(i).getIdAlat(),
                                response.body().get(i).getGambarAlat(),
                                response.body().get(i).getJudulAlat(),
                                response.body().get(i).getAudioAlat(),
                                response.body().get(i).getAsalAlat());
                        dataAlat.add(data);
                        Log.d("RESPON", "onResponse: " + response.body().get(i).getGambarAlat());

                    }
                    listview.setVisibility(View.VISIBLE);
                    adapter = new ListArrayAlat(AlatMusikActivity.this, R.layout.row_pic, dataAlat);
                    listview.setAdapter(adapter);

                    if (adapter.getCount() < 1 ) {
                        layout_loading.setVisibility(View.VISIBLE);
                        String error = "Daftar Alat Kosong";
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
            public void onFailure(Call<List<ModelAlat>> call, Throwable t) {
                String error = "Error Retrive Data from Server wwaau!!!\n" + t.getMessage();
                text_load.setText(error);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                icon_load.setImageBitmap(icon);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView IdAlat = view.findViewById(R.id.HiddenId);
        Intent intent = new Intent(AlatMusikActivity.this, ViewAlatActivity.class);
        intent.putExtra(ModelAlat.id, IdAlat.getText().toString());
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
        backAlatDaerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        menuAlatDaerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AlatMusikActivity.this);
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
                        Intent intent = new Intent(AlatMusikActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView ceritaDialog = mView.findViewById(R.id.ceritaDialog);
                ceritaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AlatMusikActivity.this, CeritaDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView kesenianDialog = mView.findViewById(R.id.kesenianDialog);
                kesenianDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AlatMusikActivity.this, KesenianDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView adatDialog = mView.findViewById(R.id.adatDialog);
                adatDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AlatMusikActivity.this, AdatIstiadatActivity.class);
                        startActivity(intent);

                    }
                });
                TextView tanyaDialog = mView.findViewById(R.id.tanyaDialog);
                tanyaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AlatMusikActivity.this, TanyaBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView quizDialog = mView.findViewById(R.id.quizDialog);
                quizDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AlatMusikActivity.this, QuizBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

            }
        });
    }


}

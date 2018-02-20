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
import com.example.bunesia.Adapter.ListArrayRumah;
import com.example.bunesia.Model.ModelRumah;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RumahAdatActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    ArrayList<ModelRumah> dataRumah = new ArrayList<>();
    ListView listview;
    ListArrayRumah adapter;

    LinearLayout layout_loading;
    TextView text_load;
    ImageView icon_load;

    ImageButton backRumahDaerah,menuRumahDaerah;
    android.support.design.widget.FloatingActionButton fabRumah;

    SwipeRefreshLayout swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah_adat);

        layout_loading = findViewById(R.id.layout_loading);

        text_load = findViewById(R.id.text_load);
        icon_load = findViewById(R.id.icon_load);
        swipe = findViewById(R.id.RefreshRumah);

        backRumahDaerah = findViewById(R.id.btnBackRumah);
        menuRumahDaerah = findViewById(R.id.btnMenuRumah);

        fabRumah = findViewById(R.id.fabRumah);

        listview = findViewById(R.id.ListRumah);
        listview.setOnItemClickListener(RumahAdatActivity.this);
        listview.setDividerHeight(0);


        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(true);
                setup();
            }
        });
        fabAction();
        buttonNav();
    }
    public void fabAction(){
        fabRumah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RumahAdatActivity.this, AdatIstiadatActivity.class);
                startActivity(intent);
            }
        });
    }


    public void setup() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        swipe.setRefreshing(true);

        ApiService service = retrofit.create(ApiService.class);

        Call<List<ModelRumah>> call = service.getSemuaContentRumah();
        call.enqueue(new Callback<List<ModelRumah>>() {
            @Override
            public void onResponse(Call<List<ModelRumah>> call, Response<List<ModelRumah>> response) {

                if (response.isSuccessful()) {
                    int jumlah = response.body().size();

                    for (int i = 0; i < jumlah; i++) {

                        ModelRumah data = new ModelRumah(
                                response.body().get(i).getIdRumah(),
                                response.body().get(i).getGambarRumah(),
                                response.body().get(i).getJudulRumah(),
                                response.body().get(i).getTargetpicRumah(),
                                response.body().get(i).getAsalRumah());
                        dataRumah.add(data);
                        Log.d("RESPON", "onResponse: " + response.body().get(i).getGambarRumah());

                    }
                    listview.setVisibility(View.VISIBLE);
                    adapter = new ListArrayRumah(RumahAdatActivity.this, R.layout.row_simple, dataRumah);
                    listview.setAdapter(adapter);

                    if (adapter.getCount() < 1 ) {
                        layout_loading.setVisibility(View.VISIBLE);
                        String error = "Daftar Rumah Kosong";
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
            public void onFailure(Call<List<ModelRumah>> call, Throwable t) {
                String error = "Error Retrive Data from Server wwaau!!!\n" + t.getMessage();
                text_load.setText(error);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                icon_load.setImageBitmap(icon);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView IdRumah = view.findViewById(R.id.HiddenIdsimple);
        Intent intent = new Intent(RumahAdatActivity.this, ViewRumahActivity.class);
        intent.putExtra(ModelRumah.id, IdRumah.getText().toString());
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
        backRumahDaerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();;
            }
        });

        menuRumahDaerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(RumahAdatActivity.this);
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
                        Intent intent = new Intent(RumahAdatActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView ceritaDialog = mView.findViewById(R.id.ceritaDialog);
                ceritaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RumahAdatActivity.this, CeritaDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView kesenianDialog = mView.findViewById(R.id.kesenianDialog);
                kesenianDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RumahAdatActivity.this, KesenianDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView adatDialog = mView.findViewById(R.id.adatDialog);
                adatDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RumahAdatActivity.this, AdatIstiadatActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView tanyaDialog = mView.findViewById(R.id.tanyaDialog);
                tanyaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RumahAdatActivity.this, TanyaBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView quizDialog = mView.findViewById(R.id.quizDialog);
                quizDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RumahAdatActivity.this, QuizBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

            }

        });
    }


}

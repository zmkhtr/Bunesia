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
import com.example.bunesia.Adapter.ListArrayAcara;
import com.example.bunesia.Model.ModelAcara;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AcaraAdatActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    ArrayList<ModelAcara> dataAcara = new ArrayList<>();
    ListView listview;
    ListArrayAcara adapter;

    LinearLayout layout_loading;
    TextView text_load;
    ImageView icon_load;

    ImageButton backAcaraDaerah,menuAcaraDaerah;
    android.support.design.widget.FloatingActionButton fabAcara;

    SwipeRefreshLayout swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara_adat);

        layout_loading = findViewById(R.id.layout_loading);

        text_load = findViewById(R.id.text_load);
        icon_load = findViewById(R.id.icon_load);
        swipe = findViewById(R.id.RefreshAcara);

        backAcaraDaerah = findViewById(R.id.btnBackAcara);
        menuAcaraDaerah = findViewById(R.id.btnMenuAcara);

        fabAcara = findViewById(R.id.fabAcara);

        listview = findViewById(R.id.ListAcara);
        listview.setOnItemClickListener(AcaraAdatActivity.this);
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
        fabAcara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AcaraAdatActivity.this, AdatIstiadatActivity.class);
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

        Call<List<ModelAcara>> call = service.getSemuaContentAcara();
        call.enqueue(new Callback<List<ModelAcara>>() {
            @Override
            public void onResponse(Call<List<ModelAcara>> call, Response<List<ModelAcara>> response) {

                if (response.isSuccessful()) {
                    int jumlah = response.body().size();

                    for (int i = 0; i < jumlah; i++) {

                        ModelAcara data = new ModelAcara(
                                response.body().get(i).getIdAcara(),
                                response.body().get(i).getGambarAcara(),
                                response.body().get(i).getJudulAcara(),
                                response.body().get(i).getTargetpicAcara(),
                                response.body().get(i).getAsalAcara());
                        dataAcara.add(data);
                        Log.d("RESPON", "onResponse: " + response.body().get(i).getGambarAcara());

                    }
                    listview.setVisibility(View.VISIBLE);
                    adapter = new ListArrayAcara(AcaraAdatActivity.this, R.layout.row_simple, dataAcara);
                    listview.setAdapter(adapter);

                    if (adapter.getCount() < 1 ) {
                        layout_loading.setVisibility(View.VISIBLE);
                        String error = "Daftar Acara Kosong";
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
            public void onFailure(Call<List<ModelAcara>> call, Throwable t) {
                String error = "Error Retrive Data from Server wwaau!!!\n" + t.getMessage();
                text_load.setText(error);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                icon_load.setImageBitmap(icon);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView IdAcara = view.findViewById(R.id.HiddenIdsimple);
        Intent intent = new Intent(AcaraAdatActivity.this, ViewAcaraActivity.class);
        intent.putExtra(ModelAcara.id, IdAcara.getText().toString());
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
        backAcaraDaerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        menuAcaraDaerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AcaraAdatActivity.this);
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
                        Intent intent = new Intent(AcaraAdatActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView ceritaDialog = mView.findViewById(R.id.ceritaDialog);
                ceritaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AcaraAdatActivity.this, CeritaDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView kesenianDialog = mView.findViewById(R.id.kesenianDialog);
                kesenianDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AcaraAdatActivity.this, KesenianDaerahActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView adatDialog = mView.findViewById(R.id.adatDialog);
                adatDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AcaraAdatActivity.this, AdatIstiadatActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView tanyaDialog = mView.findViewById(R.id.tanyaDialog);
                tanyaDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AcaraAdatActivity.this, TanyaBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                TextView quizDialog = mView.findViewById(R.id.quizDialog);
                quizDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AcaraAdatActivity.this, QuizBuNesiaActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

            }

        });
    }


}

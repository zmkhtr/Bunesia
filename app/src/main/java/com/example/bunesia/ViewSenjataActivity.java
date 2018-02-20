package com.example.bunesia;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunesia.API.ApiService;
import com.example.bunesia.Model.ModelSenjata;
import com.squareup.picasso.Picasso;

import java.util.List;

import me.biubiubiu.justifytext.library.JustifyTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewSenjataActivity extends AppCompatActivity {

    String ID_Senjata;
    TextView JudulViewSenjata, AsalViewSenjata;
    JustifyTextView IsiViewSenjata;
    ImageView ImageViewSenjata;
    Button CirclePlaySenjata;
    Context context;
    MediaPlayer MediaPlayer;
    String file_path,image_path;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_content);

        ID_Senjata = getIntent().getStringExtra(ModelSenjata.id);

        JudulViewSenjata = findViewById(R.id.JudulView);
        AsalViewSenjata = findViewById(R.id.AsalView);
        IsiViewSenjata = findViewById(R.id.IsiView);
        ImageViewSenjata = findViewById(R.id.imgView);
        CirclePlaySenjata = findViewById(R.id.imgCircle);

        toolbar = findViewById(R.id.app_bar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupportNavigateUp();
            }
        });


        bindData();
        playAudio();
    }

    public void bindData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<List<ModelSenjata>> call = service.getSingleDataSenjata(ID_Senjata);
        call.enqueue(new Callback<List<ModelSenjata>>() {
            @Override
            public void onResponse(Call<List<ModelSenjata>> call, Response<List<ModelSenjata>> response) {

                if (response.isSuccessful()) {

                    for (int i = 0; i < response.body().size(); i++) {

                        JudulViewSenjata.setText(response.body().get(i).getJudulSenjata());
                        AsalViewSenjata.setText(response.body().get(i).getAsalSenjata());
                        IsiViewSenjata.setText(response.body().get(i).getIsiSenjata());
                        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/" + response.body().get(i).getGambarSenjata()).resize(200, 150).placeholder(R.drawable.adat_istiadatnew).into(ImageViewSenjata);
                        file_path = "https://bunesia.000webhostapp.com/backend/audio/"+response.body().get(i).getAudioSenjata();
                        image_path = "https://bunesia.000webhostapp.com/backend/gambar/"+response.body().get(i).getTargetpicSenjata();
                    }

                }

            }

            @Override
            public void onFailure(Call<List<ModelSenjata>> call, Throwable t) {

            }

        });
    }

    public void playAudio() {
        CirclePlaySenjata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ViewSenjataActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_targetpic,null);
                mBuilder.setView(mView);


                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                ImageView targetPic = mView.findViewById(R.id.targetPic);
                Picasso.with(context).load(image_path).into(targetPic);
                ImageButton closeMenu = mView.findViewById(R.id.btnCloseTargetPic);
                closeMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

        }
    });
}
    @Override
    public void onBackPressed ()
    {
        if (MediaPlayer != null)
            MediaPlayer.stop();
        super.onBackPressed();
    }
    @Override
    public void onPause ()
    {
        if (MediaPlayer != null)
        {
            MediaPlayer.pause();
            MediaPlayer.stop();
        }
        super.onPause();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}

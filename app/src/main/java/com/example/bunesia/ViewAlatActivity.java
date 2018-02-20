package com.example.bunesia;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bunesia.API.ApiService;
import com.example.bunesia.Model.ModelAlat;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import me.biubiubiu.justifytext.library.JustifyTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewAlatActivity extends AppCompatActivity {

    String ID_Alat;
    TextView JudulViewAlat, AsalViewAlat;
    JustifyTextView IsiViewAlat;
    ImageView ImageViewAlat;
    Button CirclePlayAlat;
    Context context;
    MediaPlayer MediaPlayer;
    String file_path;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_content);

        ID_Alat = getIntent().getStringExtra(ModelAlat.id);

        JudulViewAlat = findViewById(R.id.JudulView);
        AsalViewAlat = findViewById(R.id.AsalView);
        IsiViewAlat = findViewById(R.id.IsiView);
        ImageViewAlat = findViewById(R.id.imgView);
        CirclePlayAlat = findViewById(R.id.imgCircle);

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

        Call<List<ModelAlat>> call = service.getSingleDataAlat(ID_Alat);
        call.enqueue(new Callback<List<ModelAlat>>() {
            @Override
            public void onResponse(Call<List<ModelAlat>> call, Response<List<ModelAlat>> response) {

                if (response.isSuccessful()) {

                    for (int i = 0; i < response.body().size(); i++) {

                        JudulViewAlat.setText(response.body().get(i).getJudulAlat());
                        AsalViewAlat.setText(response.body().get(i).getAsalAlat());
                        IsiViewAlat.setText(response.body().get(i).getIsiAlat());
                        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/" + response.body().get(i).getGambarAlat()).resize(200, 150).placeholder(R.drawable.alat_musik_daerah_banner_01x).into(ImageViewAlat);
                        file_path = "https://bunesia.000webhostapp.com/backend/audio/"+response.body().get(i).getAudioAlat();

                    }

                }

            }

            @Override
            public void onFailure(Call<List<ModelAlat>> call, Throwable t) {

            }

        });
    }

    public void playAudio() {
        CirclePlayAlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer = new MediaPlayer();
                MediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    MediaPlayer.setDataSource(file_path);
                    MediaPlayer.prepare();
                    MediaPlayer.start();
                    CirclePlayAlat.setEnabled(false);
                    Toast.makeText(getApplicationContext(),"Mari berdendang...",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    CirclePlayAlat.setEnabled(true);
                    e.printStackTrace();
                }

                MediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        MediaPlayer.release();
                        MediaPlayer = null;
                        Toast.makeText(getApplicationContext(),"Selesai",Toast.LENGTH_SHORT).show();

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

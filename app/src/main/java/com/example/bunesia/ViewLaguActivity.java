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
import com.example.bunesia.Model.ModelLagu;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import me.biubiubiu.justifytext.library.JustifyTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewLaguActivity extends AppCompatActivity {

    String ID_Lagu;
    TextView JudulViewLagu, AsalViewLagu;
    JustifyTextView IsiViewLagu;
    ImageView ImageViewLagu;
    Button CirclePlayLagu;
    Context context;
    MediaPlayer MediaPlayer;
    String file_path;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_content);

        ID_Lagu = getIntent().getStringExtra(ModelLagu.id);

        JudulViewLagu = findViewById(R.id.JudulView);
        AsalViewLagu = findViewById(R.id.AsalView);
        IsiViewLagu = findViewById(R.id.IsiView);
        ImageViewLagu = findViewById(R.id.imgView);
        CirclePlayLagu = findViewById(R.id.imgCircle);

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

        Call<List<ModelLagu>> call = service.getSingleDataLagu(ID_Lagu);
        call.enqueue(new Callback<List<ModelLagu>>() {
            @Override
            public void onResponse(Call<List<ModelLagu>> call, Response<List<ModelLagu>> response) {

                if (response.isSuccessful()) {

                    for (int i = 0; i < response.body().size(); i++) {

                        JudulViewLagu.setText(response.body().get(i).getJudulLagu());
                        AsalViewLagu.setText(response.body().get(i).getAsalLagu());
                        IsiViewLagu.setText(response.body().get(i).getIsiLagu());
                        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/" + response.body().get(i).getGambarLagu()).resize(200, 150).placeholder(R.drawable.ic_play_arrow).into(ImageViewLagu);
                        file_path = "https://bunesia.000webhostapp.com/backend/audio/"+response.body().get(i).getAudioLagu();

                    }

                }

            }

            @Override
            public void onFailure(Call<List<ModelLagu>> call, Throwable t) {

            }

        });
    }

    public void playAudio() {
        CirclePlayLagu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer = new MediaPlayer();
                MediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    MediaPlayer.setDataSource(file_path);
                    MediaPlayer.prepare();
                    MediaPlayer.start();
                    CirclePlayLagu.setEnabled(false);
                    Toast.makeText(getApplicationContext(),"Bu Nesia Nyanyi dulu ya...",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    CirclePlayLagu.setEnabled(true);
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

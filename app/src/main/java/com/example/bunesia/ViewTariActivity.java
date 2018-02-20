package com.example.bunesia;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bunesia.API.ApiService;
import com.example.bunesia.Model.ModelTari;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

import me.biubiubiu.justifytext.library.JustifyTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewTariActivity extends YouTubeBaseActivity  {

    String ID_Tari;
    TextView JudulViewTari, AsalViewTari;
    JustifyTextView IsiViewTari;
    Button CirclePlayTari;
    String file_path;
    Toolbar toolbar;
    YouTubePlayerView mYoutubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_content_youtube);

        ID_Tari = getIntent().getStringExtra(ModelTari.id);

        JudulViewTari = findViewById(R.id.JudulView);
        AsalViewTari = findViewById(R.id.AsalView);
        IsiViewTari = findViewById(R.id.IsiView);
        CirclePlayTari = findViewById(R.id.imgCircle);

        mYoutubePlayerView = findViewById(R.id.videoView);

        toolbar = findViewById(R.id.app_bar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupportNavigateUp();
            }
        });


        bindData();
        playVideo();
    }
    public void playVideo(){
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(file_path);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        CirclePlayTari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListener);
            }
        });
    }

    public void bindData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<List<ModelTari>> call = service.getSingleDataTari(ID_Tari);
        call.enqueue(new Callback<List<ModelTari>>() {
            @Override
            public void onResponse(Call<List<ModelTari>> call, Response<List<ModelTari>> response) {

                if (response.isSuccessful()) {

                    for (int i = 0; i < response.body().size(); i++) {

                        JudulViewTari.setText(response.body().get(i).getJudulTari());
                        AsalViewTari.setText(response.body().get(i).getAsalTari());
                        IsiViewTari.setText(response.body().get(i).getIsiTari());
                        file_path = response.body().get(i).getYoutubeCode();

                    }

                }

            }

            @Override
            public void onFailure(Call<List<ModelTari>> call, Throwable t) {

            }

        });
    }



    @Override
    public void onBackPressed ()
    {
        super.onBackPressed();
    }
    @Override
    public void onPause ()
    {
        super.onPause();
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}

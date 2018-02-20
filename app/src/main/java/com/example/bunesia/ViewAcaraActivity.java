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
import com.example.bunesia.Model.ModelAcara;
import com.squareup.picasso.Picasso;

import java.util.List;

import me.biubiubiu.justifytext.library.JustifyTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewAcaraActivity extends AppCompatActivity {

    String ID_Acara;
    TextView JudulViewAcara, AsalViewAcara;
    JustifyTextView IsiViewAcara;
    ImageView ImageViewAcara;
    Button CirclePlayAcara;
    Context context;
    MediaPlayer MediaPlayer;
    String file_path,image_path;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_content);

        ID_Acara = getIntent().getStringExtra(ModelAcara.id);

        JudulViewAcara = findViewById(R.id.JudulView);
        AsalViewAcara = findViewById(R.id.AsalView);
        IsiViewAcara = findViewById(R.id.IsiView);
        ImageViewAcara = findViewById(R.id.imgView);
        CirclePlayAcara = findViewById(R.id.imgCircle);

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

        Call<List<ModelAcara>> call = service.getSingleDataAcara(ID_Acara);
        call.enqueue(new Callback<List<ModelAcara>>() {
            @Override
            public void onResponse(Call<List<ModelAcara>> call, Response<List<ModelAcara>> response) {

                if (response.isSuccessful()) {

                    for (int i = 0; i < response.body().size(); i++) {

                        JudulViewAcara.setText(response.body().get(i).getJudulAcara());
                        AsalViewAcara.setText(response.body().get(i).getAsalAcara());
                        IsiViewAcara.setText(response.body().get(i).getIsiAcara());
                        Picasso.with(context).load("https://bunesia.000webhostapp.com/backend/gambar/" + response.body().get(i).getGambarAcara()).resize(200, 150).placeholder(R.drawable.adat_istiadatnew).into(ImageViewAcara);
                        file_path = "https://bunesia.000webhostapp.com/backend/audio/"+response.body().get(i).getAudioAcara();
                        image_path = "https://bunesia.000webhostapp.com/backend/gambar/"+response.body().get(i).getTargetpicAcara();
                    }

                }

            }

            @Override
            public void onFailure(Call<List<ModelAcara>> call, Throwable t) {

            }

        });
    }

    public void playAudio() {
        CirclePlayAcara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ViewAcaraActivity.this);
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

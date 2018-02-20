package com.example.bunesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String ROOT_URL = "https://bunesia.000webhostapp.com/API/";

    ArrayList<String> mText = new ArrayList<>();
    ArrayList<String> mImage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getImage();
    }

    private void getImage(){
        mImage.add("https://i.imgur.com/GoxsfvQ.jpg");
        mText.add("Cerita Daerah");
        mImage.add("https://i.imgur.com/ftj6Y15.jpg");
        mText.add("Kesenian Daerah");
        mImage.add("https://i.imgur.com/gvjufVh.png");
        mText.add("Adat Istiadat");
        mImage.add("https://i.imgur.com/x7E9mqz.jpg");
        mText.add("Tanya Bu Nesia");
        mImage.add("https://i.imgur.com/U3G6ito.jpg");
        mText.add("Quiz Bu Nesia");

        initRecyclerView();
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.mainRecycler);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mText, mImage);
        recyclerView.setAdapter(adapter);
    }
}

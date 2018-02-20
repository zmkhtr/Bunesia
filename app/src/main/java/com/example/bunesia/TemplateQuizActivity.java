package com.example.bunesia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TemplateQuizActivity extends AppCompatActivity {

    ImageView imgSoal;
    RadioGroup radioGroup;
    RadioButton radioButtonA,radioButtonB,radioButtonC, radioButtonID;
    TextView textSoal;
    int score = 0;
    Button btnOkSoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_quiz);

        imgSoal = findViewById(R.id.imgSoal);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonA = findViewById(R.id.radioButtonA);
        radioButtonB = findViewById(R.id.radioButtonB);
        radioButtonC = findViewById(R.id.radioButtonC);
        textSoal = findViewById(R.id.textSoal);
        btnOkSoal =  findViewById(R.id.btnOkSoal);

        setSoal();
        answer();
    }

    private void setSoal(){
        textSoal.setText(R.string.acara_adat);
        radioButtonA.setText(R.string.acara_adat);
        radioButtonB.setText(R.string.rumah_adat);
        radioButtonC.setText(R.string.alat_musik);
        imgSoal.setImageResource(R.drawable.acara_adat_banner_01x);
    }

    private void answer(){
        btnOkSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentValue = getIntent();
                String nama = intentValue.getStringExtra("nama");
                int selectedAnswer = radioGroup.getCheckedRadioButtonId();

                Intent intent = new Intent(TemplateQuizActivity.this, MainActivity.class);

                radioButtonID = findViewById(selectedAnswer);
                if (selectedAnswer == -1) {
                    Toast.makeText(getApplicationContext(), "Pilih jawaban terlebih dahulu ! ", Toast.LENGTH_SHORT).show();
                } else if (selectedAnswer == radioButtonA.getId()) {
                    intent.putExtra("score", score+20);
                    intent.putExtra("nama",nama);
                    startActivity(intent);
                    finish();
                } else if (selectedAnswer == radioButtonB.getId()) {
                    intent.putExtra("score", score);
                    intent.putExtra("nama",nama);
                    startActivity(intent);
                    finish();
                } else if (selectedAnswer == radioButtonC.getId()) {
                    intent.putExtra("score", score);
                    intent.putExtra("nama",nama);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}

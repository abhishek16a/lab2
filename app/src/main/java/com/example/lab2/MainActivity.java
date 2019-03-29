package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnHigh, btnGo, btnLow;
    TextView tvOutputScore, tvOutput;
    Random random=new Random();
    int number, numberNew, Score=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo= findViewById(R.id.btnGo);
        btnHigh= findViewById(R.id.btnHigh);
        btnLow= findViewById(R.id.btnLow);

        String member = String.valueOf(number);

        btnHigh.setText(member);
        btnLow.setText(member);

        tvOutputScore=findViewById(R.id.tvOutputScore);
        tvOutput=findViewById(R.id.tvOutput);

        btnHigh.setVisibility(View.INVISIBLE);
        btnLow.setVisibility(View.INVISIBLE);
        btnGo.setVisibility(View.VISIBLE);




        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=random.nextInt(100); //generate random number between 1 to 50
                tvOutput.setText("" +number);
                Score=0;

                tvOutputScore.setText("Score: " + Score);

                btnHigh.setVisibility(View.VISIBLE);
                btnLow.setVisibility(View.VISIBLE);
                btnGo.setVisibility(View.INVISIBLE);

            }
        });

        btnLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberNew=random.nextInt(100) -1;
                tvOutput.setText("" + numberNew);
                if (numberNew<=number){
                    Score--;
                    tvOutputScore.setText("Score: " + Score );
                    number=numberNew;

                } else{
                    tvOutputScore.setText("Score: " + Score + "/nGame OVER!");
                    btnGo.setVisibility(View.VISIBLE);
                    btnHigh.setVisibility(View.INVISIBLE);
                    btnLow.setVisibility(View.INVISIBLE);

                }

            }
        });

        btnHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberNew=random.nextInt(100) +1;
                tvOutput.setText("" + numberNew);
                if (numberNew>=number){
                    Score++;
                    tvOutputScore.setText("Score: " + Score);
                    number=numberNew;

                } else{
                    tvOutputScore.setText("Score: " + Score + "/nGame OVER!");
                    btnGo.setVisibility(View.VISIBLE);
                    btnHigh.setVisibility(View.INVISIBLE);
                    btnLow.setVisibility(View.INVISIBLE);

                }
            }
        });

    }
}
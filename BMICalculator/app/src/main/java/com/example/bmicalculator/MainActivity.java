package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//xml file connection

        EditText edtWeight, edtHeightF, edtHeightI;
        TextView tResult;
        Button btnCalculate;
        LinearLayout lMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightF=findViewById(R.id.edtHeightF);
        edtHeightI=findViewById(R.id.edtHeightI);
        btnCalculate=findViewById(R.id.btnCalculate);
        tResult=findViewById(R.id.tResult);
        lMain=findViewById(R.id.lMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int ft=Integer.parseInt(edtHeightF.getText().toString());
                int In=Integer.parseInt(edtHeightI.getText().toString());

                int totalIn = ft*12 + In;
                double totalCm =totalIn*2.53;
                double totalM=totalCm/100;
                double bmi=wt/(totalM*totalM);
                if(bmi>25){
                    tResult.setText("You are Overweight");
                    lMain.setBackgroundColor(getResources().getColor(R.color.over));
                } else if (bmi<18) {
                    tResult.setText("You are Underweight") ;
                    lMain.setBackgroundColor(getResources().getColor(R.color.under));
                }else {
                    tResult.setText("You are Healthy and Normal");
                    lMain.setBackgroundColor(getResources().getColor(R.color.normal));
                }
            }
        });

    }
}
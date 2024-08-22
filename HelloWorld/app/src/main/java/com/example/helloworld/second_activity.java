package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class second_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String Student = fromAct.getStringExtra("Student Name");
        int rollno = fromAct.getIntExtra("Roll No",0);

        TextView txtStudentInfo;

        txtStudentInfo =findViewById(R.id.txtStudentInfo);
        txtStudentInfo.setText("Roll No: "+rollno+", Name:"+Student);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }



    }
}
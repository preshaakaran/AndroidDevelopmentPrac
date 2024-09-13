package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
Spinner spinner;
AutoCompleteTextView actxtView;
int[] arrNo=new int[]{1,2,3,4,5};
ArrayList<String> arrNames = new ArrayList<>();
ArrayList<String> arrIds = new ArrayList<>();
ArrayList<String> arrLanguages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        spinner=findViewById(R.id.spinner);
        actxtView =findViewById(R.id.actxtView);

        //ListView
        arrNames.add("Ram");
        arrNames.add("Raman");
        arrNames.add("Ramanujan");
        arrNames.add("Ram");
        arrNames.add("Raman");
        arrNames.add("Ramanujan");
        arrNames.add("Ram");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(MainActivity.this,"Clicked First item",Toast.LENGTH_SHORT).show();

                }


            }
        });

        //Spinner

        arrIds.add("Aadhar Card");
        arrIds.add("PAN Card");
        arrIds.add("Voter ID Card");
        arrIds.add("Driving License Card");
        arrIds.add("Ration Card");
        arrIds.add("Xth Score Card");
        arrIds.add("XIIth Score Card");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,arrIds);
        spinner.setAdapter(spinnerAdapter);


        //AutoCompleteTextView
        arrLanguages.add("C");
        arrLanguages.add("C++");
        arrLanguages.add("C#");
        arrLanguages.add("Java");
        arrLanguages.add("Kotlin");
        arrLanguages.add("Python");

        ArrayAdapter<String> actvAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,arrLanguages);
        actxtView.setAdapter(actvAdapter);
        actxtView.setThreshold(1);









    }
}
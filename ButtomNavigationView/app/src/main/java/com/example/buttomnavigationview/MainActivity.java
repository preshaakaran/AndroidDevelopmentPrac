package com.example.buttomnavigationview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);

        bnView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.nav_home){

                    loadFrag(new AFragment(),false);


                } else if (id==R.id.nav_search) {
                    loadFrag(new BFragment(),false);

                } else if (id==R.id.nav_utilities) {
                    loadFrag(new CFragment(),false);

                } else if (id==R.id.nav_contact)  {
                    loadFrag(new DFragment(),false);

                }else {
                    loadFrag(new EFragment(),true);

                }
                return true;
            }
        });

        bnView.setSelectedItemId(R.id.nav_profile);


    }

    public void loadFrag(Fragment fragment,boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag){
            ft.add(R.id.container, fragment);
        }else {
            ft.replace(R.id.container, fragment);
        }

        ft.commit();
    }
}
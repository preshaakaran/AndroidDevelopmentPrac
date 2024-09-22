package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    String ROOT_FRAGMENT_TAG = "root_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigaionView);
        toolbar = findViewById(R.id.toolbar);

        //Step 1

        setSupportActionBar(toolbar);

        //Step 2
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //Step 3
        loadFragment(new AFragment(),0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_home){
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    loadFragment(new AFragment(),1);


                } else if (id == R.id.nav_notes) {
                    Toast.makeText(MainActivity.this, "Notes", Toast.LENGTH_SHORT).show();
                    loadFragment(new BFragment(),1);

                } else if (id==R.id.nav_settings) {
                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                    loadFragment(new CFragment(),1);

                } else if (id==R.id.nav_share) {
                    Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                    loadFragment(new DFragment(),1);

                } else {
                    Toast.makeText(MainActivity.this, "Gallery", Toast.LENGTH_SHORT).show();
                    loadFragment(new EFragment(),1);

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }


        });



    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment,int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag==0){
            ft.add(R.id.fragment_container, fragment);
            fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);
        }
        else {
            ft.replace(R.id.fragment_container, fragment);
            ft.addToBackStack(null);
        }

        ft.commit();
    }
}
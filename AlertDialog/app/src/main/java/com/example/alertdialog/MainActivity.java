package com.example.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Single Button Dialog Box

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Terms & Conditions");
        alertDialog.setIcon(R.drawable.baseline_info_24);
        alertDialog.setMessage("Have you read all the terms and conditions?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes, I've Read", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yes, You can proceed now...", Toast.LENGTH_SHORT).show();
            }
        });


        alertDialog.show();

        //Two Button Dialog Box

//        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
//        delDialog.setTitle("Delete?");
//        delDialog.setIcon(R.drawable.baseline_delete_24);
//        delDialog.setMessage("Are you sure you want to delete?");
//
//        delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                //for delete
//                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Item not Deleted", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        delDialog.show();








    }
    @Override
    public void onBackPressed(){
        //Three Button Dialog Box

        AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);
        exitDialog.setTitle("Exit?");
        exitDialog.setMessage("Are you sure want to exit?");
        exitDialog.setIcon(R.drawable.baseline_exit_to_app_24);

        exitDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Welcome back!", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });
        
        exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Operation Cancelled!", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.show();

    }
}
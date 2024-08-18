package com.example.customtoast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnToast=findViewById(R.id.btnToast);
//        Default toast
//        btnToast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "This is my first Toast", Toast.LENGTH_LONG).show();
//            }
//        });



//      Custom Toast



        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());
                View view=getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.viewContainer));
                toast.setView(view);

                TextView txtMsg = view.findViewById(R.id.txtMsg);
                txtMsg.setText("Message sent Successfully!");
                toast.setDuration(Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.TOP|Gravity.END,0,0);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });


    }
}
package com.example.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnDial, btnMsg, btnEmail, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnMsg = findViewById(R.id.btnMsg);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel:+919876543210"));
                startActivity(iDial);

            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+919876543210")));
                iMsg.putExtra("sms_body", "Please solve this issue asap.");
                startActivity(iMsg);

            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com","xyz.@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT, "Please resolve this issue asap.");
                startActivity(Intent.createChooser(iEmail, "Email via"));

            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "Download this Amazing App,https://play.google.com/store/apps/details?id=com.example.myapp");
                startActivity(Intent.createChooser(iShare, "Share via"));

            }
        });


    }
}
package com.example.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    static final int ALARM_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtTime = findViewById(R.id.edtTime);
        Button btnSet = findViewById(R.id.btnSet);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(edtTime.getText().toString());

                long triggerTime = System.currentTimeMillis() + (time * 1000);
                Intent iBroadcast = new Intent(MainActivity.this, MyReceiver.class);

                PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, ALARM_REQUEST_CODE, iBroadcast, PendingIntent.FLAG_UPDATE_CURRENT);
                // Write 0 instead of PendingIntent.FLAG_UPDATE_CURRENT if you want to receive two receivers at the same time

                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);

            }
        });



    }
}
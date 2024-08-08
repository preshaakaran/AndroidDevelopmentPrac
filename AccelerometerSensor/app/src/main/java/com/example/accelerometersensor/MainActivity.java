package com.example.accelerometersensor;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager !=null){
            Sensor acclerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(acclerationSensor != null){
                sensorManager.registerListener(this, acclerationSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }



        }else{
            Toast.makeText(this, "Sensor service not detected", Toast.LENGTH_SHORT).show();
        }


    }
}
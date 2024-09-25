package com.example.proximitysensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView txtValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtValues = findViewById(R.id.txtValues);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager != null){
            Sensor proxiSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            if(proxiSensor != null){
                sensorManager.registerListener(this, proxiSensor, SensorManager.SENSOR_DELAY_NORMAL);

            }
        }else{
            Toast.makeText(this, "Sensor not found", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_PROXIMITY){
            ((TextView)findViewById(R.id.txtValues)).setText("Values: " + event.values[0]);

            if(event.values[0] > 0){
                Toast.makeText(this, "Object is far", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Object is near", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
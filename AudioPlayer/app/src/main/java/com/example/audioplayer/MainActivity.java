package com.example.audioplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnPause = findViewById(R.id.btnPause);
        Button btnStop = findViewById(R.id.btnStop);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String aPath = "android.resource://"+getPackageName()+"/raw/downtown";
        String onlineAudioPath = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";

        Uri audioURI = Uri.parse(aPath);
        Uri onlineURI = Uri.parse(onlineAudioPath);
        try {
//            mp.setDataSource(this, audioURI);
            mp.setDataSource(this, onlineURI);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();

            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);


            }
        });

        //mp.seekTo();
//        mp.getDuration();
//        mp.getCurrentPosition();


        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //ek gaana ke baad dusra gaana
            }
        });



    }
}
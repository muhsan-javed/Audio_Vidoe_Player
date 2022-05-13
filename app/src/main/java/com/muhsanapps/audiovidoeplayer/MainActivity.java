package com.muhsanapps.audiovidoeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button pause, play , stop, videoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
        stop = findViewById(R.id.stop);
        videoBtn = findViewById(R.id.btnVideoPlayer);
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VideoPlayer.class);
                startActivity(intent);
            }
        });

        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String aPath = "android.resource://"+getPackageName()+"/raw/bazaar";

//        String onlineAudioPath = "https://www.youtube.com/watch?v=0hJ8s5flRFo&t=217s";
//        Uri onlineURI =  Uri.parse(onlineAudioPath);

        Uri audioURI = Uri.parse(aPath);
        try {
//            mediaPlayer.setDataSource(this,onlineURI);
            mediaPlayer.setDataSource(this,audioURI);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mediaPlayer.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
            }
        });

        //mediaPlayer.seekTo();
        //mediaPlayer.getDuration();
        //mediaPlayer.getCurrentPosition();

//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//
//            }
//        });

    }
}
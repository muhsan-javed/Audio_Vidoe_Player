package com.muhsanapps.audiovidoeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView = findViewById(R.id.videoView);

        String vPath = "android.resource://"+ getPackageName()+ "/raw/allama";

        //String onlineVideoPath = "https://www.youtube.com/watch?v=0hJ8s5flRFo&t=217s.mp4";
        //Uri onlineVideoURI = Uri.parse(onlineVideoPath);

        Uri videoURI = Uri.parse(vPath);

        //videoView.setVideoPath(vPath);
        videoView.setVideoURI(videoURI);
        //videoView.setVideoURI(onlineVideoURI);
        videoView.start();

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }
}
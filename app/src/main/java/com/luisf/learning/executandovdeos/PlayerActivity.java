package com.luisf.learning.executandovdeos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        // set mode full screen and more actions...
        View decorView = getWindow().getDecorView();
        int iActions;
        iActions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            // or select multiples options, adding char "|" before next option...
            //iActions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            // Detail: SYSTEM_UI_FLAG_HIDE_NAVIGATION, esconde a barra de navegação (Portuguese - pt-BR)
        decorView.setSystemUiVisibility(iActions);

        // hide action bar
        getSupportActionBar().hide();

        // execute media...
        videoView.setMediaController(new MediaController(this));
        String pathMedia = "android.resource://" + getPackageName() + "/" + R.raw.video;
        videoView.setVideoPath(pathMedia);
        videoView.start();
    }
}
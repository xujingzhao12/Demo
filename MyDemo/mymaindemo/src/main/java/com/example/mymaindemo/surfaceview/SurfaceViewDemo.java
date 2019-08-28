package com.example.mymaindemo.surfaceview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceView;

import com.example.mymaindemo.R;

import java.io.IOException;

public class SurfaceViewDemo extends AppCompatActivity {
    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view_demo);

        surfaceView=findViewById(R.id.surfaceView);
        mediaPlayer=new MediaPlayer();
        mediaPlayer.reset();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDisplay(surfaceView.getHolder());
        String p="D:/我的资料/start.mp3";
        //int start = R.raw.start;
        try {
            mediaPlayer.setDataSource(String.valueOf(Uri.parse(p)));
           // mediaPlayer.setDataSource(String.valueOf(start));
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

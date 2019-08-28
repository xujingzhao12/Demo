package com.example.mymaindemo.photo_album;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mymaindemo.R;

import java.util.List;

public class MainActivity_AllPicture extends AppCompatActivity {
    private Context context;
    private List<PictureInfo> pictureInfoList;
    private Button btJpeg;
    private Button btPng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__all_picture);

        context=this;
        btJpeg=findViewById(R.id.btJpeg);
        btJpeg.setText("jpeg相册");
        btJpeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity_AllPicture.this, JpegActivity.class);
                Intent intent = new Intent(MainActivity_AllPicture.this, JpegActivity.class);
                startActivity(intent);
            }
        });

        btPng=findViewById(R.id.btPng);
        btPng.setText("png相册");
        btPng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_AllPicture.this, PngActivity.class);
                startActivity(intent);
            }
        });

    }
}

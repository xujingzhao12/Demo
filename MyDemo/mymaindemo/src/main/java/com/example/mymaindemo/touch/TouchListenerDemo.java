package com.example.mymaindemo.touch;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mymaindemo.R;

import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;

public class TouchListenerDemo extends AppCompatActivity {

    private int[] images=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h};
    private int curr=0;//记录索引值
    private ImageView img2;
    private Random ran=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_listener_demo);

        img2=findViewById(R.id.img2);
        //触摸切换图片并且随机改变透明度
        img2.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int image = images[++curr % images.length];
                img2.setImageResource(image);
                //设置图片透明度
                img2.setImageAlpha(ran.nextInt(255));
                Toast.makeText(TouchListenerDemo.this,"触摸监听", LENGTH_SHORT).show();
                return true;
            }
        });

    }
}

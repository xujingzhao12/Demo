package com.example.mymaindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mymaindemo.activity.ActivityInitDemo;
import com.example.mymaindemo.async_task.AsyncTaskDemo;
import com.example.mymaindemo.gestures.GestureDemo;
import com.example.mymaindemo.gestures.GestureDemo2;
import com.example.mymaindemo.gestures.GestureDemo3;
import com.example.mymaindemo.handle.HandleImageDemo;
import com.example.mymaindemo.image_switchar.PictureBrowing;
import com.example.mymaindemo.photo_album.MainActivity_AllPicture;
import com.example.mymaindemo.surfaceview.SurfaceViewDemo;
import com.example.mymaindemo.system_event.ShowSystemConfig;
import com.example.mymaindemo.touch.CustomView;
import com.example.mymaindemo.touch.TouchListenerDemo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button bt10;
    private Button bt11;
    private Button bt12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt1.setText("handle实现切换图片");
        bt1.setOnClickListener(this);

        bt2 = findViewById(R.id.bt2);
        bt2.setText("监听方式");
        bt2.setOnClickListener(this);

        bt3 = findViewById(R.id.bt3);
        bt3.setText("自定义View组件触摸");
        bt3.setOnClickListener(this);

        bt4 = findViewById(R.id.bt4);
        bt4.setText("显示手机信息");
        bt4.setOnClickListener(this);

        bt5 = findViewById(R.id.bt5);
        bt5.setText("异步改变UI");
        bt5.setOnClickListener(this);

        bt6 = findViewById(R.id.bt6);
        bt6.setText("手势入门");
        bt6.setOnClickListener(this);

        bt7 = findViewById(R.id.bt7);
        bt7.setText("手势切换activity");
        bt7.setOnClickListener(this);

        bt8 = findViewById(R.id.bt8);
        bt8.setText("手势添加");
        bt8.setOnClickListener(this);

        bt9 = findViewById(R.id.bt9);
        bt9.setText("activity数据传递");
        bt9.setOnClickListener(this);

        bt10 = findViewById(R.id.bt10);
        bt10.setText("图片浏览");
        bt10.setOnClickListener(this);

        bt11 = findViewById(R.id.bt11);
        bt11.setText("读取手机所有照片");
        bt11.setOnClickListener(this);

        bt12 = findViewById(R.id.bt12);
        bt12.setText("surfaceview的使用");
        bt12.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                Intent intent1 = new Intent(MainActivity.this, HandleImageDemo.class);
                startActivity(intent1);
                break;
            case R.id.bt2:
                Intent intent2 = new Intent(MainActivity.this, TouchListenerDemo.class);
                startActivity(intent2);
                break;
            case R.id.bt3:
                Intent intent3 = new Intent(MainActivity.this, CustomView.class);
                startActivity(intent3);
                break;
            case R.id.bt4:
                Intent intent4 = new Intent(MainActivity.this, ShowSystemConfig.class);
                startActivity(intent4);
                break;
            case R.id.bt5:
                Intent intent5 = new Intent(MainActivity.this, AsyncTaskDemo.class);
                startActivity(intent5);
                break;
            case R.id.bt6:
                Intent intent6 = new Intent(MainActivity.this, GestureDemo.class);
                startActivity(intent6);
                break;
            case R.id.bt7:
                Intent intent7 = new Intent(MainActivity.this, GestureDemo2.class);
                startActivity(intent7);
                break;
            case R.id.bt8:
                Intent intent8 = new Intent(MainActivity.this, GestureDemo3.class);
                startActivity(intent8);
                break;
            case R.id.bt9:
                Intent intent9 = new Intent(MainActivity.this, ActivityInitDemo.class);
                startActivity(intent9);
                break;
            case R.id.bt10:
                Intent intent10 = new Intent(MainActivity.this, PictureBrowing.class);
                startActivity(intent10);
                break;
            case R.id.bt11:
                Intent intent11 = new Intent(MainActivity.this, MainActivity_AllPicture.class);
                startActivity(intent11);
                break;
                case R.id.bt12:
                Intent intent12 = new Intent(MainActivity.this, SurfaceViewDemo.class);
                startActivity(intent12);
                break;
        }
    }

}

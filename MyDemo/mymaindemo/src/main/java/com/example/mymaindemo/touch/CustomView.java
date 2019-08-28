package com.example.mymaindemo.touch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.mymaindemo.R;

//使用自定义的组件类MyViewDemo.
public class CustomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
    }
}

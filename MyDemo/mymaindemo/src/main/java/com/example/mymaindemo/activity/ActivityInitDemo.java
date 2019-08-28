package com.example.mymaindemo.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mymaindemo.R;
//实现activity信息传递,本案例实现另一个avtivity选取图片返回来
public class ActivityInitDemo extends AppCompatActivity {
    private ImageView img4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_demo);

        img4=findViewById(R.id.img4);
        Button bt10=findViewById(R.id.bt10);
        bt10.setText("去选择图片");
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityInitDemo.this, ActivityReceiveDemo.class);
                startActivityForResult(intent,0x123);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==0x123){
            if (resultCode==RESULT_OK){
                Bundle extras = data.getExtras();
                int list = extras.getInt("list");
                img4.setImageResource(list);
            }
        }
    }
}

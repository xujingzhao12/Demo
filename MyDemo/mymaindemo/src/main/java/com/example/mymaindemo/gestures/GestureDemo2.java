package com.example.mymaindemo.gestures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.mymaindemo.MainActivity;
import com.example.mymaindemo.R;
//通过手指切换新的Activity
public class GestureDemo2 extends AppCompatActivity {

    private GestureDetector gestureDetector;
    private MyGestureListener2 gestureListener2;
    private final static int MIN_MOVE=10;//最小距离

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_demo2);
        gestureListener2=new MyGestureListener2();
        gestureDetector=new GestureDetector(this,gestureListener2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener2 extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX()-e2.getX()>MIN_MOVE){
                startActivity(new Intent(GestureDemo2.this, MainActivity.class));
                Toast.makeText(GestureDemo2.this,"通过手势启动了Activity",Toast.LENGTH_LONG).show();
            }else if (e1.getY()-e2.getY()<MIN_MOVE){
                finish();
                Toast.makeText(GestureDemo2.this,"通过手势关闭了Activity",Toast.LENGTH_LONG).show();
            }
            return true;
        }
    }
}

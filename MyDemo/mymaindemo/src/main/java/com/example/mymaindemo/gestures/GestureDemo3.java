package com.example.mymaindemo.gestures;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mymaindemo.R;
//手势添加案例
public class GestureDemo3 extends AppCompatActivity {

    private EditText et1;
    private GestureOverlayView gov1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_demo3);

        gov1=findViewById(R.id.gov1);
        gov1.setGestureColor(Color.RED);
        gov1.setGestureStrokeWidth(5);

        gov1.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView gestureOverlayView, final Gesture gesture) {
                View saveDialog = getLayoutInflater().inflate(R.layout.demo3_add, null, false);
                ImageView img3 = saveDialog.findViewById(R.id.img3);
                final EditText editText=findViewById(R.id.et2);
                Bitmap bitmap = gesture.toBitmap(128,128,10,0xffff0000);
                img3.setImageBitmap(bitmap);
                new AlertDialog.Builder(GestureDemo3.this).setView(saveDialog)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                GestureLibrary gestureLibrary = GestureLibraries.fromFile("/mnt");
                                gestureLibrary.addGesture(editText.toString(),gesture);
                                gestureLibrary.save();
                            }
                        }).setNegativeButton("取消",null).show();
            }
        });
    }
}

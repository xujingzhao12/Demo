package com.example.mymaindemo.image_switchar;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

import com.example.mymaindemo.R;


public class PictureBrowing extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private int[] images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h};
    private ImageSwitcher switcher;
    private float downX;
    private float upX;
    private int index=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_browing);

        switcher=findViewById(R.id.switcher);
        switcher.setFactory(this);


        switcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MotionEvent.ACTION_DOWN==motionEvent.getAction()){
                    downX=motionEvent.getX();
                    return true;
                }else if (MotionEvent.ACTION_UP==motionEvent.getAction()){
                    upX=motionEvent.getX();
                    if (upX-downX>100){//从左到右
                        index=index==0?images.length-1:index-1;
                        //index=++index%images.length;
                        switcher.setInAnimation(AnimationUtils.loadAnimation(PictureBrowing.this,android.R.anim.fade_in));
                        switcher.setOutAnimation(AnimationUtils.loadAnimation(PictureBrowing.this,android.R.anim.fade_out));
                        switcher.setImageResource(images[index]);
                    }else if (downX-upX>100){
                        index=index==images.length-1?0:index+1;
                        //index=++index%images.length;
                        Log.d("8888++++",index+"");
                        switcher.setInAnimation(AnimationUtils.loadAnimation(PictureBrowing.this,android.R.anim.fade_in));
                        switcher.setOutAnimation(AnimationUtils.loadAnimation(PictureBrowing.this,android.R.anim.fade_out));
//                        Log.e("TAG", "" + index + " " + images[index]);
//                        Log.e("TAG", switcher.toString());
                        switcher.setImageResource(images[index]);

                    }
                    return true;
                }
                return true;
            }
        });

    }

    @Override
    public View makeView() {
        ImageView imageView=new ImageView(PictureBrowing.this);
        imageView.setBackgroundColor(0xFFFFFFFF);
        imageView.setImageResource(images[0]);
        imageView.setScaleType(ImageView.ScaleType.CENTER);//居中显示
        imageView.setLayoutParams(new LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));//定义组件位置
        return imageView;
    }
}

package com.example.mymaindemo.touch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PointF;
import android.opengl.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.mymaindemo.R;

public class ZoomImageDemo extends AppCompatActivity implements View.OnTouchListener {
    private ImageView img3;
    //缩放控制
    private Matrix matrix=new Matrix();
    private Matrix saveMatrix=new Matrix();

    //不同状态
    private static final int NONE=0;
    private static final int DRAG=1;
    private static final int ZOOM=2;
    private int mode=NONE;

    //定义第一个按下的点,两只接触点的重点,以及两只手指的距离
    private PointF startPoint=new PointF();
    private PointF midPoint=new PointF();
    private float oriDis=1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_image_demo);

        /*img3=findViewById(R.id.img3);
        img3.setOnTouchListener(this);*/
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        /*ImageView v=(ImageView)view;

        switch (motionEvent.getAction()&motionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                matrix.set(v.getImageMatrix());
                saveMatrix.set(matrix);
                startPoint.set(motionEvent.getX(),motionEvent.getY());
                mode=DRAG;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                oriDis=distance(even);
                if (oriDis>10f){
                    saveMatrix.set(matrix);
                    midPoint=middle(motionEvent);
                    mode=ZOOM;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode=NONE;
                break;
            case MotionEvent.ACTION_MOVE:
                if (mode==DRAG){
                    matrix.set(saveMatrix);
                    matrix.postTranslate(motionEvent.getX()-startPoint.x,motionEvent.getY()-startPoint.y);
                }else if (mode==ZOOM){
                    float newDist=distance(motionEvent);
                    if (newDist>10f){
                        matrix.set(saveMatrix);
                        float scale=newDist/oriDis;
                        matrix.postScale(scale,scale,midPoint.x,midPoint.y);
                    }
                }
                break;
        }
        //设置ImageView的Matrix
        v.setImageMatrix(matrix);*/
        return true;
    }

    public float distance(MotionEvent even){
        float x=even.getX(0)-even.getX(1);
        float y=even.getY(0)-even.getY(1);
        return (float) Math.sqrt(x*x*1.0+y*y);
    }

    public PointF middle(MotionEvent even){
        float x=even.getX(0)+even.getX(1);
        float y=even.getY(0)+even.getY(1);
        return new PointF(x/2,y/2);
    }
}

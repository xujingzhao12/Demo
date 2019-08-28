package com.example.mymaindemo.touch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/*
自定义组件
onTouch(View v, MotionEvent event):这里面的参数依次是触发触摸事件的组件,触碰事件event 封装了触发事件的详细信息，同样包括事件的类型、触发时间等信息。比如event.getX(),event.getY()
我们也可以对触摸的动作类型进行判断,使用event.getAction( )再进行判断;如:
event.getAction == MotionEvent.ACTION_DOWN：按下事件
event.getAction == MotionEvent.ACTION_MOVE:移动事件
event.getAction == MotionEvent.ACTION_UP:弹起事件*/

public class MyViewDemo extends View {
    private float x=50;
    private float y=50;
    private Paint paint=new Paint();//画笔

    public MyViewDemo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x,y,30,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.x=event.getX();
        this.y= event.getY();
        Log.i("x-y",x+"-"+y);
        //获取动作
        Log.i("action", event.getAction()+"");
        //通知重绘
        this.invalidate();
        return true;
    }
}

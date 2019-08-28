package com.example.mymaindemo.gestures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import com.example.mymaindemo.R;
/*按下（onDown）： 刚刚手指接触到触摸屏的那一刹那，就是触的那一下。
抛掷（onFling）： 手指在触摸屏上迅速移动，并松开的动作。
长按（onLongPress）： 手指按在持续一段时间，并且没有松开。
滚动（onScroll）： 手指在触摸屏上滑动。
按住（onShowPress）： 手指按在触摸屏上，它的时间范围在按下起效，在长按之前。
抬起（onSingleTapUp）：手指离开触摸屏的那一刹那。
 */
public class GestureDemo extends AppCompatActivity {

    private MyGestureListener myGestureListener;
    private  GestureDetector gestureDetector;
    private TextView tv3;
    private StringBuffer buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_demo);
        /*Step 1: 创建GestureDetector对象，创建时需实现GestureListener传入
         Step 2: 将Activity或者特定组件上的TouchEvent的事件交给GestureDetector处理即可*/
        tv3=findViewById(R.id.tv3);
        myGestureListener = new MyGestureListener();
        gestureDetector=new GestureDetector(this,myGestureListener);
        buffer=new StringBuffer();
        tv3.setText(buffer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    //自定义一个GestureListener
    public class MyGestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Log.i("onDown","按下被执行");
            buffer.append("onDown,按下被执行"+"\n");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Log.i("onShowPress","手指按下一段十几件,不过没有长按");
            buffer.append("onShowPress,手指按下一段十几件,不过没有长按"+"\n");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.i("onSingleTapUp","手指离开屏幕的一瞬间");
            buffer.append("onSingleTapUp,手指离开屏幕的一瞬间"+"\n");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.i("onScroll","在触摸屏幕上滑动");
            buffer.append("onScroll,在触摸屏幕上滑动"+"\n");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Log.i("onLongPress","长按并且没有松动");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.i("onFling","迅速滑动并且松开");
            buffer.append("onFling,迅速滑动并且松开"+"\n");
            return false;
        }
    }
}

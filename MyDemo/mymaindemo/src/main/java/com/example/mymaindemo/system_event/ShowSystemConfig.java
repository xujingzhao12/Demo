package com.example.mymaindemo.system_event;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymaindemo.R;
//显示手机信息
public class ShowSystemConfig extends AppCompatActivity {

    private TextView tv1;



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_system_config);
        StringBuffer buffer = new StringBuffer();

        tv1=findViewById(R.id.tv1);

        final Configuration configuration = getResources().getConfiguration();
        buffer.append("densityDpi:"+configuration.densityDpi+"\n");
        buffer.append("fontScale:"+configuration.fontScale+"\n");
        buffer.append("keyboard:"+configuration.keyboard+"\n");
        buffer.append("keyboardHidden:"+configuration.keyboardHidden+"\n");
        buffer.append("locale:"+configuration.locale+"\n");
        buffer.append("mcc:"+configuration.mcc +"\n");
        buffer.append("mnc:"+configuration.mnc +"\n");
        buffer.append("navigation:"+configuration.navigation +"\n");
        buffer.append("orientation:"+configuration.orientation +"\n");
        buffer.append("screenHeightDp:"+configuration.screenHeightDp +"\n");
        buffer.append("screenWidthDp:"+configuration.screenWidthDp +"\n");
        buffer.append("screenLayout:"+configuration.screenLayout +"\n");
        buffer.append("smallestScreenWidthDp:"+configuration.smallestScreenWidthDp +"\n");
        buffer.append("touchscreen:"+configuration.touchscreen +"\n");
        buffer.append("uiMode:"+configuration.uiMode +"\n");

        tv1.setText(buffer);

        tv1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Configuration configuration = getResources().getConfiguration();
                //如果是横屏切换成竖屏
                if (configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){
                    ShowSystemConfig.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                //如果是竖屏切换成横屏
                if (configuration.orientation==Configuration.ORIENTATION_PORTRAIT){
                    ShowSystemConfig.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                return true;
            }
        });

    }

    //该方法用于响应系统设置更改
    //该方法用于监听系统设置的更改,是基于回调的时间处理方法,当系统的设置发生改变时就会自动触发; 但是要注意一点,使用下面的方法监控的话,targetSdkVersion属性最高只能设置为12,高于12的话,该方法不会被激发！这里写个横竖屏切换的例子给大家参考参考，其他的可自行谷歌~
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横屏" : "竖屏";
        Toast.makeText(ShowSystemConfig.this,"系统屏幕放生了改变",Toast.LENGTH_SHORT).show();
    }
}

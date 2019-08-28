package com.example.mymaindemo.handle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.example.mymaindemo.R;

public class HandleImageDemo extends AppCompatActivity {

    private int[] images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h};
    private ImageView img1;
    private Handler handler;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_image_demo);

        img1 = findViewById(R.id.img1);
        handler = new Handler() {
            @Override
            //重写handleMessage方法,根据msg中what的值判断是否执行后续操作
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    img1.setImageResource(images[count % images.length]);
                }
            }
        };

        newThreadDemo();

    }


    public void newThreadDemo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Message msg = new Message();
                    msg.what = 1;
                    ++count;
                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

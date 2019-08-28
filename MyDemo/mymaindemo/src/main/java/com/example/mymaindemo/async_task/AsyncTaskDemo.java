package com.example.mymaindemo.async_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mymaindemo.R;

public class AsyncTaskDemo extends AppCompatActivity {

    private TextView tv2;
    private Button bt5;
    private ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_demo);

        tv2=findViewById(R.id.tv2);
        bt5=findViewById(R.id.bt5);
        pb1=findViewById(R.id.pb1);

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*1.自定义的Tast的实例必须在UI线程中创建
                  2.execute方法必须在UI线程中使用
                  3.不要手动调用onPreExecute(),onPostExecute(),doInBackground(),onProgreeUpdate()这几个方法
                  4.该Tast只能被执行一次,否则多次调用会出现异常
                */
                CustomAsyncCase customAsyncCase = new CustomAsyncCase(tv2, pb1);
                customAsyncCase.execute(1000);
            }
        });
    }
}

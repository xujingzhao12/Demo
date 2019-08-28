package com.example.mymaindemo.async_task;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
//自定义异步类
//onpreExecute()主要用户初始化操作->doInBackground()用户处理耗时操作,可调用publishProgress()更新任务进度->publishProgress()更新任务进度->onPostExecute()在doInBackground执行后执行,会被UI线程调用,后台的操作结果通过它传给UI线程->onProgressUpdate()publishProgress方法调用后,UI线程讲这个方法从页面展示任务进度->onCancelled在用户取消线程时调用,在主线程中被调用
public class CustomAsyncCase extends AsyncTask<Integer,Integer,String> {
    private TextView title;
    private ProgressBar pb1;
    private int flag=0;


    public CustomAsyncCase(TextView title, ProgressBar pb1) {
        this.title = title;
        this.pb1 = pb1;
    }

    //不运行于UI线程中,主要用于异步操作,通过调用publishProgress方法
    @Override
    protected String doInBackground(Integer... integers) {
        DelayOperator delayOperator = new DelayOperator();
        int j ;
        for (j = 0; j <100; j+=1) {
            if (flag==0){
                delayOperator.delay();
                publishProgress(j);
            }else {
                break;
            }
        }
        return j+integers[0].intValue()+"";
    }

    //方法运行在UI鲜橙汁,可对UI控件进行操作,通常用于一些初始化操作
    @Override
    protected void onPreExecute() {
        title.setText("异步线程开启");
    }

    //运行在UI线程中,可对Ui控件进行操作
    @Override
    protected void onProgressUpdate(Integer... values) {
        if (pb1.getProgress()<100){
            int progrees=values[0];
            pb1.setProgress(progrees);
        }else {
            flag=1;
            return;
        }
    }
}

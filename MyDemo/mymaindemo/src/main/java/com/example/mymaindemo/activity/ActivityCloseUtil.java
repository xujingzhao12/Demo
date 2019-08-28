package com.example.mymaindemo.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class ActivityCloseUtil {

    public static List<Activity> activityList=new LinkedList<>();

    //添加Activity到集合中
    public static void addActivity(Activity activity){
        activityList.add(activity);
    }

    //从集合删除某个Activity
    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }

    //关闭所有的Activity
    public static void finishAll(){
        for (Activity activity : activityList) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

    //完全退出Activity
    public static void appExit(Context context){
        try{
            finishAll();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        }catch (Exception e){
            Log.e("exit","退出程序异常"+e);
        }
    }
}

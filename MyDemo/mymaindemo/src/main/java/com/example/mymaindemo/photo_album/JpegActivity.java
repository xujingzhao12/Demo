package com.example.mymaindemo.photo_album;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.mymaindemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JpegActivity extends AppCompatActivity {
    private List<PictureInfo> jpegList;
    //private ImageView imgJpeg;
    private GridView gvJpeg;
    private PictureDao pictureDao;
    private Context context;
    private Handler handler;
//    ArrayList<HashMap<String, String>> strings = new ArrayList<>();
   // private SimpleAdapter simpleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpeg);


        context=this;





        //jpegList=pictureDao.getPictureInfoJpegList();
//        jpegList = pictureDao.getDemo();
        jpegList = new ArrayList<PictureInfo>();

        gvJpeg=findViewById(R.id.gvJpeg);
       // imgJpeg=findViewById(R.id.imgJpeg);

       /* long l = System.currentTimeMillis();
        for (int i = 0; i < jpegList.size(); i++) {
            PictureInfo pictureInfo = jpegList.get(i);
            HashMap<String, String> map = new HashMap<>();
            map.put("imgJpeg",pictureInfo.getData());
            strings.add(map);
        }

        Log.e("time main",  (System.currentTimeMillis() - l)+" ");

        l = System.currentTimeMillis();*/

        final PictureAdapter pictureAdapter = new PictureAdapter(jpegList, context);
       /* simpleAdapter = new SimpleAdapter(this, strings, R.layout.item_jpeg, new String[]{"imgJpeg"}, new int[]{R.id.imgJpeg});
        gvJpeg.setAdapter(simpleAdapter);
        Log.e("time main",  (System.currentTimeMillis() - l)+" ");*/

       gvJpeg.setAdapter(pictureAdapter);


        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
//                super.handleMessage(msg);
                if(msg.what == 0x123) {
                    jpegList.add((PictureInfo) msg.obj);
                    pictureAdapter.notifyDataSetChanged();
                }
            }
        };

        pictureDao=new PictureDao(context, handler);

        new Thread(new Runnable() {
            @Override
            public void run() {
                pictureDao.getDemo();
            }
        }).start();

    }

}

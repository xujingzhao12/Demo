package com.example.mymaindemo.photo_album;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.mymaindemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.mymaindemo.R.id.imgPng;

public class PngActivity extends AppCompatActivity {
    private List<PictureInfo> pngList;
    private ImageView imgPng;
    private GridView gvPng;
    private PictureDao pictureDao;
    private Context context;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_png);

        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        context=this;
        imgPng=findViewById(R.id.imgPng);
        gvPng=findViewById(R.id.gvPng);
        pictureDao = new PictureDao(context, handler);
        pngList= this.pictureDao.getPictureInfoPngList();

        for (int i = 0; i < pngList.size(); i++) {
            PictureInfo pictureInfo = pngList.get(i);
            HashMap<String, String> map = new HashMap<>();
            map.put("imgPng",pictureInfo.getData());
            list.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(context, list, R.layout.item_png, new String[]{"imgPng"}, new int[]{R.id.imgPng});
        gvPng.setAdapter(simpleAdapter);

    }
}

package com.example.mymaindemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.mymaindemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityReceiveDemo extends AppCompatActivity {
    private Context context;
    private ImageView img5;
    private GridView gv1;
    private List<Map<String,Integer>> list=new ArrayList<>();
    private int[] images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_demo);

        context=this;
        for (int i = 0; i < images.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("img5",images[i]);
            list.add(map);
        }


        SimpleAdapter simpleAdapter = new SimpleAdapter(context, list, R.layout.item_grid, new String[]{"img5"}, new int[]{R.id.img5});
        gv1=findViewById(R.id.gv1);
        gv1.setAdapter(simpleAdapter);
        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                //将选中的图片传回去
                bundle.putInt("list",list.get(i).get("img5"));
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}

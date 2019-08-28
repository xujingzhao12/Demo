package com.example.mymaindemo.photo_album;

import android.content.Context;
import android.net.Uri;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.mymaindemo.R;

import java.io.File;
import java.net.URI;
import java.util.List;

public class PictureAdapter extends BaseAdapter {
    private List<PictureInfo> jpegList;
    //private ImageView imgJpeg;
    private Context context;

    public PictureAdapter(Context context) {
        this.context = context;
    }

    public PictureAdapter(List<PictureInfo> jpegList, Context context) {
        this.jpegList = jpegList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return jpegList.size();
    }

    @Override
    public Object getItem(int i) {
        return jpegList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        long l = System.currentTimeMillis();

        ViewHolder holder=null;
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_jpeg,viewGroup,false);
            holder = new ViewHolder();
            holder.img=view.findViewById(R.id.imgJpeg);
            view.setTag(holder);
        }else {
            holder=(ViewHolder)view.getTag();
        }
        String data = jpegList.get(i).getData();
        //Uri uri = Uri.fromFile(new File(data));
        Uri uri = Uri.parse(data);
        holder.img.setImageURI(uri);

        Log.e("time adapter",  (System.currentTimeMillis() - l)+" ");

        return view;
    }

    public static class ViewHolder{
        ImageView img;
    }
}

package com.example.mymaindemo.photo_album;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.os.Handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PictureDao {

    private Context context;
    private Handler handler;

    final static String TAG="图片信息";
    private List<PictureInfo> pictureInfoList=new ArrayList<>();
    private List<PictureInfo> pictureInfoJpgList=new ArrayList<>();
    private List<PictureInfo> pictureInfoPngList=new ArrayList<>();
    private List<PictureInfo> pictureInfoJpegList=new ArrayList<>();

    public PictureDao(Context context, Handler handler) {
        this.context = context;
        this.handler = handler;
    }

    public List<PictureInfo> getPicturelist(){
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver resolver = context.getContentResolver();

/*        String[] objs = {
//                MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
//                MediaStore.Video.Media.ARTIST,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.MIME_TYPE,
//                MediaStore.Video.Media.DURATION,
                MediaStore.Images.Media.SIZE,
                MediaStore.Images.Media._ID
        };

        String selection = MediaStore.Images.Media.MIME_TYPE + "=?";

        Cursor cursor = resolver.query(uri, objs, selection, new String[]{"image/jpeg"}, null);*/
        Cursor cursor = resolver.query(uri, null, null,null, null);

        while(cursor.moveToNext()){
            String PATH = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            String SIZE = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.SIZE));
            String ID = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media._ID));
            String MIME_TYPE = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.MIME_TYPE));
           // String TAG_WHITE_BALANCE  = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.TAG_WHITE_BALANCE ));
            Log.e("CBBBBBB", PATH + " " + MIME_TYPE);

            try {
                ExifInterface exifInterface = new ExifInterface(PATH);
                String TAG_APERTURE = exifInterface.getAttribute(ExifInterface.TAG_APERTURE);
                String TAG_DATETIME = exifInterface.getAttribute(ExifInterface.TAG_DATETIME);
                String TAG_EXPOSURE_TIME = exifInterface.getAttribute(ExifInterface.TAG_EXPOSURE_TIME);
                String TAG_FLASH = exifInterface.getAttribute(ExifInterface.TAG_FLASH);
                String TAG_FOCAL_LENGTH = exifInterface.getAttribute(ExifInterface.TAG_FOCAL_LENGTH);
                String TAG_IMAGE_LENGTH = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_LENGTH);
                String TAG_IMAGE_WIDTH = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_WIDTH);
                String TAG_ISO = exifInterface.getAttribute(ExifInterface.TAG_ISO);
                String TAG_MAKE = exifInterface.getAttribute(ExifInterface.TAG_MAKE);
                String TAG_MODEL = exifInterface.getAttribute(ExifInterface.TAG_MODEL);
                String TAG_ORIENTATION = exifInterface.getAttribute(ExifInterface.TAG_ORIENTATION);
                String TAG_WHITE_BALANCE  = exifInterface.getAttribute(ExifInterface.TAG_WHITE_BALANCE );

                PictureInfo p = new PictureInfo();
                p.setAperture(TAG_APERTURE);
                p.setDateTime(TAG_DATETIME);
                p.setExposure(TAG_EXPOSURE_TIME);
                p.setFlash(TAG_FLASH);
                p.setFocal(TAG_FOCAL_LENGTH);
                p.setHeight(TAG_IMAGE_LENGTH);
                p.setWidth(TAG_IMAGE_WIDTH);
                p.setIso(TAG_ISO);
                p.setMake(TAG_MAKE);
                p.setModel(TAG_MODEL);
                p.setOrientation(TAG_ORIENTATION);
                p.setData(PATH);
                p.setMimeType(MIME_TYPE);
                p.setId(ID);
                p.setSize(SIZE);
                pictureInfoList.add(p);

                Log.i(TAG, "光圈值:" + TAG_APERTURE);
                Log.i(TAG, "拍摄时间:" + TAG_DATETIME);
                Log.i(TAG, "曝光时间:" + TAG_EXPOSURE_TIME);
                Log.i(TAG, "闪光灯:" + TAG_FLASH);
                Log.i(TAG, "焦距:" + TAG_FOCAL_LENGTH);
                Log.i(TAG, "图片高度:" + TAG_IMAGE_LENGTH);
                Log.i(TAG, "图片宽度:" + TAG_IMAGE_WIDTH);
                Log.i(TAG, "ISO:" + TAG_ISO);
                Log.i(TAG, "设备品牌:" + TAG_MAKE);
                Log.i(TAG, "设备型号:" + TAG_MODEL);
                Log.i(TAG, "旋转角度:" + TAG_ORIENTATION);
                Log.i(TAG, "大小:" + SIZE);
                Log.i(TAG, "id:" + ID);
                Log.i(TAG, "type:" + MIME_TYPE);
                Log.i(TAG, "xiangxi:" + cursor.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pictureInfoList;
    }

    //获取jpg格式图片
    public List<PictureInfo> getPictureInfoJpgList(){
        pictureInfoList=getPicturelist();
        for (PictureInfo pictureInfo : pictureInfoList) {
            if ("image/jpg".equals(pictureInfo.getMimeType())){
                pictureInfoJpgList.add(pictureInfo);
            }
        }
        return pictureInfoJpgList;
    }

    //获取jpeg格式图片
    public List<PictureInfo> getPictureInfoJpegList(){
        pictureInfoList=getPicturelist();
        for (PictureInfo pictureInfo : pictureInfoList) {
            if ("image/jpeg".equals(pictureInfo.getMimeType())){
                pictureInfoJpegList.add(pictureInfo);
            }
        }
        return pictureInfoJpegList;
    }

    //获取png格式的图片
    public List<PictureInfo> getPictureInfoPngList(){
        pictureInfoList=getPicturelist();
        for (PictureInfo pictureInfo : pictureInfoList) {
            if ("image/png".equals(pictureInfo.getMimeType())){
                pictureInfoPngList.add(pictureInfo);
            }
        }
        return pictureInfoPngList;
    }

    public List<PictureInfo> getDemo(){
        int c = 0;
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{MediaStore.Images.Media.DATA}, MediaStore.Images.Media.MIME_TYPE + "=?", new String[]{"image/jpeg"}, null);
        long l = System.currentTimeMillis();
        while(cursor.moveToNext()){
            c++;
            String PATH = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            //String SIZE = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.SIZE));
            //String ID = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media._ID));
            //String MIME_TYPE = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.MIME_TYPE));

            try {
                ExifInterface exifInterface = new ExifInterface(PATH);
                String TAG_APERTURE = exifInterface.getAttribute(ExifInterface.TAG_APERTURE);
                String TAG_DATETIME = exifInterface.getAttribute(ExifInterface.TAG_DATETIME);
                String TAG_EXPOSURE_TIME = exifInterface.getAttribute(ExifInterface.TAG_EXPOSURE_TIME);
                String TAG_FLASH = exifInterface.getAttribute(ExifInterface.TAG_FLASH);
                String TAG_FOCAL_LENGTH = exifInterface.getAttribute(ExifInterface.TAG_FOCAL_LENGTH);
                String TAG_IMAGE_LENGTH = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_LENGTH);
                String TAG_IMAGE_WIDTH = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_WIDTH);
                String TAG_ISO = exifInterface.getAttribute(ExifInterface.TAG_ISO);
                String TAG_MAKE = exifInterface.getAttribute(ExifInterface.TAG_MAKE);
                String TAG_MODEL = exifInterface.getAttribute(ExifInterface.TAG_MODEL);
                String TAG_ORIENTATION = exifInterface.getAttribute(ExifInterface.TAG_ORIENTATION);

                PictureInfo p = new PictureInfo();
                p.setAperture(TAG_APERTURE);
                p.setDateTime(TAG_DATETIME);
                p.setExposure(TAG_EXPOSURE_TIME);
                p.setFlash(TAG_FLASH);
                p.setFocal(TAG_FOCAL_LENGTH);
                p.setHeight(TAG_IMAGE_LENGTH);
                p.setWidth(TAG_IMAGE_WIDTH);
                p.setIso(TAG_ISO);
                p.setMake(TAG_MAKE);
                p.setModel(TAG_MODEL);
                p.setOrientation(TAG_ORIENTATION);
                p.setData(PATH);
               // p.setMimeType(MIME_TYPE);
               // p.setId(ID);
               // p.setSize(SIZE);

//                pictureInfoList.add(p);

                Message msg = Message.obtain();
                msg.what = 0x123;
                msg.obj = p;

                handler.sendMessage(msg);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        Log.e("time",  (System.currentTimeMillis() - l)+" " + c);

        return pictureInfoList;
    }
}

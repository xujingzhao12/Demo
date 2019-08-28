package com.example.mymaindemo.photo_album;

import java.io.Serializable;

public class PictureInfo implements Serializable {
    private String aperture;//光圈值
    private String dateTime;//拍摄时间
    private String exposure;//曝光时间
    private String flash;//闪光灯
    private String focal;//聚焦
    private String height;//高
    private String width;//宽
    private String iso;//感光度
    private String make;//设备品牌
    private String model;//设备型号
    private String orientation;//旋转角度
    private String data;//绝对路径
    private String mimeType;//格式
    private String id;//唯一标识
    private String size;//大小

    public PictureInfo() {
    }

    public PictureInfo(String aperture, String dateTime, String exposure, String flash, String focal, String height, String width, String iso, String make, String model, String orientation, String whiteBalance, String data) {
        this.aperture = aperture;
        this.dateTime = dateTime;
        this.exposure = exposure;
        this.flash = flash;
        this.focal = focal;
        this.height = height;
        this.width = width;
        this.iso = iso;
        this.make = make;
        this.model = model;
        this.orientation = orientation;
        this.data = data;
    }

    public PictureInfo(String aperture, String dateTime, String exposure, String flash, String focal, String height, String width, String iso, String make, String model, String orientation, String whiteBalance, String data, String mimeType, String id, String size) {
        this.aperture = aperture;
        this.dateTime = dateTime;
        this.exposure = exposure;
        this.flash = flash;
        this.focal = focal;
        this.height = height;
        this.width = width;
        this.iso = iso;
        this.make = make;
        this.model = model;
        this.orientation = orientation;
        this.data = data;
        this.mimeType = mimeType;
        this.id = id;
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String exposure) {
        this.exposure = exposure;
    }

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public String getFocal() {
        return focal;
    }

    public void setFocal(String focal) {
        this.focal = focal;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PictureInfo{" +
                "aperture='" + aperture + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", exposure='" + exposure + '\'' +
                ", flash='" + flash + '\'' +
                ", focal='" + focal + '\'' +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", iso='" + iso + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", orientation='" + orientation + '\'' +
                ", data='" + data + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", id='" + id + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}

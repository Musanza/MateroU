package com.example.materou;

public class Model {
    String lat;
    String lng;
    String title;
    String info;

    public Model(String title2, String info2, String lat2, String lng2) {
        this.title = title2;
        this.info = info2;
        this.lat = lat2;
        this.lng = lng2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getInfo(){
        return  this.info;
    }

    public void setInfo(String info2) {
        this.info = info2;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat2) {
        this.lat = lat2;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String lng2) {
        this.lng = lng2;
    }
}

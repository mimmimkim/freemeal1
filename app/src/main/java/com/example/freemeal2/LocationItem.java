package com.example.freemeal2;

public class LocationItem {
    private long _lid;
    private double lan;
    private double lat;
    private String address;
    private String dt;
    private int num;
    private int _uid;

    public LocationItem() {}

    public LocationItem(double lan, double lat, String address, String dt, int num, int _uid) {
        this.lan = lan;
        this.lat = lat;
        this.address = address;
        this.dt = dt;
        this.num = num;
        this._uid = _uid;
    }

    public long get_lid() {
        return _lid;
    }

    public void set_lid(long _lid) {
        this._lid = _lid;
    }

    public double getLan() {
        return lan;
    }

    public void setLan(double lan) {
        this.lan = lan;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int get_uid() {
        return _uid;
    }

    public void set_uid(int _uid) {
        this._uid = _uid;
    }
}

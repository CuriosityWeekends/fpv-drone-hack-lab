package com.lg.picturesubmitt.model;

import a1.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class LocationInfo {
    private double latitude;
    private double longitude;
    private String time;

    public LocationInfo(double d, double d5, String str) {
        this.longitude = d;
        this.latitude = d5;
        this.time = str;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getTime() {
        return this.time;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LocationInfo{longitude=");
        sb.append(this.longitude);
        sb.append(", latitude=");
        sb.append(this.latitude);
        sb.append(", time='");
        return i.k(sb, this.time, "'}");
    }
}

package com.lg.picturesubmitt.model;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PlaneInfor2 {
    public int AirplaneLat;
    public int AirplaneLon;
    public float Altitude;
    public float Distance;
    public float Speed;
    public float Velocity;

    public PlaneInfor2(int i3, int i5, float f4, float f5, float f6, float f7) {
        this.AirplaneLon = i3;
        this.AirplaneLat = i5;
        this.Altitude = f4;
        this.Distance = f5;
        this.Speed = f6;
        this.Velocity = f7;
    }

    public String toString() {
        return "PlaneInfor2{飞机经度=" + this.AirplaneLon + ", 飞机纬度=" + this.AirplaneLat + ", 飞行高度=" + ((this.Altitude - 1000.0f) / 10.0d) + ", 飞行距离=" + this.Distance + ", 水平速度=" + (this.Speed / 10.0d) + ", 垂直速度=" + (this.Velocity / 10.0d) + '}';
    }
}

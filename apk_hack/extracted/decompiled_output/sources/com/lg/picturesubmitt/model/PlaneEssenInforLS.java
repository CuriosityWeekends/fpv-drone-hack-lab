package com.lg.picturesubmitt.model;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PlaneEssenInforLS {
    public int Gohomehigh;
    public int Maxdistance;
    public int Maxhigh;
    public int Maxpoint;
    public String name;

    public PlaneEssenInforLS(String str, int i3, int i5, int i6, int i7) {
        this.name = str;
        this.Maxhigh = i3;
        this.Maxdistance = i5;
        this.Maxpoint = i6;
        this.Gohomehigh = i7;
    }

    public String toString() {
        return "PlaneEssenInforLS{飞机型号='" + this.name + "', 最大飞行高度=" + this.Maxhigh + ", 最大飞行距离=" + this.Maxdistance + ", 最大航点数=" + this.Maxpoint + ", 返航高度=" + this.Gohomehigh + '}';
    }
}

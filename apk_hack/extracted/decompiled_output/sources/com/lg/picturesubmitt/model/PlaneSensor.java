package com.lg.picturesubmitt.model;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PlaneSensor {
    public int Acc;
    public int BaroTemp;
    public int Gyr;
    public int ImuTemp;
    public int Mag;
    public int Motor1;
    public int Motor2;
    public int Motor3;
    public int Motor4;
    public int Pitch;
    public int Roll;
    public int Thor;
    public int Yaw;
    public int baro;

    public PlaneSensor(int i3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.Acc = i3;
        this.Gyr = i5;
        this.Mag = i6;
        this.baro = i7;
        this.ImuTemp = i8;
        this.BaroTemp = i9;
        this.Roll = i10;
        this.Pitch = i11;
        this.Thor = i12;
        this.Yaw = i13;
        this.Motor1 = i14;
        this.Motor2 = i15;
        this.Motor3 = i16;
        this.Motor4 = i17;
    }

    public String toString() {
        return "{Acc=" + this.Acc + ", Gyr=" + this.Gyr + ", Mag=" + this.Mag + ", baro=" + this.baro + ", ImuTemp=" + this.ImuTemp + ", BaroTemp=" + this.BaroTemp + ", Roll=" + this.Roll + ", Pitch=" + this.Pitch + ", Thor=" + this.Thor + ", Yaw=" + this.Yaw + ", Motor1=" + this.Motor1 + ", Motor2=" + this.Motor2 + ", Motor3=" + this.Motor3 + ", Motor4=" + this.Motor4 + '}';
    }
}

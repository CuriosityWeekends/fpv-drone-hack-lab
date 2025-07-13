package com.lg.picturesubmitt.model;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PlaneInforTrinity {
    public int Armed;
    public int AttitudePitch;
    public int AttitudeRoll;
    public int AttitudeYaw;
    public int AutoLand;
    public int BaroInitOk;
    public int BatVal;
    public int Camera;
    public int CurrOver;
    public int FlowInitOk;
    public int InsCalib;
    public int InsInitOk;
    public int LandFinish;
    public int LowBat;
    public int Photo;
    public int PostBackUpdate;
    public int RcFastMode;
    public int Takeoff;
    public int VideoOn;

    public PlaneInforTrinity() {
    }

    public String toString() {
        return "PlaneInforTrinity{PostBackUpdate=" + this.PostBackUpdate + ", AttitudeRoll=" + this.AttitudeRoll + ", AttitudePitch=" + this.AttitudePitch + ", AttitudeYaw=" + this.AttitudeYaw + ", InsInitOk=" + this.InsInitOk + ", BaroInitOk=" + this.BaroInitOk + ", FlowInitOk=" + this.FlowInitOk + ", InsCalib=" + this.InsCalib + ", BatVal=" + this.BatVal + ", LowBat=" + this.LowBat + ", CurrOver=" + this.CurrOver + ", Armed=" + this.Armed + ", Photo=" + this.Photo + ", Camera=" + this.Camera + ", VideoOn=" + this.VideoOn + ", Takeoff=" + this.Takeoff + ", AutoLand=" + this.AutoLand + ", LandFinish=" + this.LandFinish + ", RcFastMode=" + this.RcFastMode + '}';
    }

    public PlaneInforTrinity(int i3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22) {
        this.PostBackUpdate = i3;
        this.AttitudeRoll = i5;
        this.AttitudePitch = i6;
        this.AttitudeYaw = i7;
        this.InsInitOk = i8;
        this.BaroInitOk = i9;
        this.FlowInitOk = i10;
        this.InsCalib = i11;
        this.BatVal = i12;
        this.LowBat = i13;
        this.CurrOver = i14;
        this.Armed = i15;
        this.Photo = i16;
        this.Camera = i17;
        this.VideoOn = i18;
        this.Takeoff = i19;
        this.AutoLand = i20;
        this.LandFinish = i21;
        this.RcFastMode = i22;
    }
}

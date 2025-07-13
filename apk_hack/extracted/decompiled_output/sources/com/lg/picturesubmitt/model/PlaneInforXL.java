package com.lg.picturesubmitt.model;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PlaneInforXL {
    public int Armed;
    public int AttitudePitch;
    public int AttitudeRoll;
    public int AttitudeYaw;
    public int AutoLand;
    public int BaroInitOk;
    public int BatVal;
    public int CalibProgress;
    public int Camera;
    public int CurrOver;
    public int FlowInitOk;
    public int FlyMode;
    public int GoHomeStatu;
    public int GpsFine;
    public int GpsInitOk;
    public int GpsNum;
    public int GpsQuality;
    public int InsCalib;
    public int InsInitOk;
    public int LandFinish;
    public int LowBat;
    public int MagInitOk;
    public int MagXYCalib;
    public int MagZCalib;
    public int PTZadj;
    public int Photo;
    public int RcFastMode;
    public int Takeoff;
    public int VideoOn;
    public int WiFiReset;
    public int mode_gps;

    public PlaneInforXL() {
    }

    public String toString() {
        return "{AttitudeRoll=" + this.AttitudeRoll + ", AttitudePitch=" + this.AttitudePitch + ", AttitudeYaw=" + this.AttitudeYaw + ", InsInitOk=" + this.InsInitOk + ", BaroInitOk=" + this.BaroInitOk + ", MagInitOk=" + this.MagInitOk + ", GpsInitOk=" + this.GpsInitOk + ", FlowInitOk=" + this.FlowInitOk + ", InsCalib=" + this.InsCalib + ", MagXYCalib=" + this.MagXYCalib + ", MagZCalib=" + this.MagZCalib + ", CalibProgress=" + this.CalibProgress + ", BatVal=" + this.BatVal + ", LowBat=" + this.LowBat + ", WiFiReset=" + this.WiFiReset + ", CurrOver=" + this.CurrOver + ", Armed=" + this.Armed + ", FlyMode=" + this.FlyMode + ", GoHomeStatu=" + this.GoHomeStatu + ", Photo=" + this.Photo + ", Camera=" + this.Camera + ", VideoOn=" + this.VideoOn + ", Takeoff=" + this.Takeoff + ", AutoLand=" + this.AutoLand + ", LandFinish=" + this.LandFinish + ", GpsNum=" + this.GpsNum + ", GpsFine=" + this.GpsFine + ", GpsQuality=" + this.GpsQuality + ", mode_gps=" + this.mode_gps + ", RcFastMode=" + this.RcFastMode + ", PTZadj=" + this.PTZadj + '}';
    }

    public PlaneInforXL(int i3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34) {
        this.AttitudeRoll = i3;
        this.AttitudePitch = i5;
        this.AttitudeYaw = i6;
        this.InsInitOk = i7;
        this.BaroInitOk = i8;
        this.MagInitOk = i9;
        this.GpsInitOk = i10;
        this.FlowInitOk = i11;
        this.InsCalib = i12;
        this.MagXYCalib = i13;
        this.MagZCalib = i14;
        this.CalibProgress = i15;
        this.BatVal = i16;
        this.LowBat = i17;
        this.WiFiReset = i18;
        this.CurrOver = i19;
        this.Armed = i20;
        this.FlyMode = i21;
        this.GoHomeStatu = i22;
        this.Photo = i23;
        this.Camera = i24;
        this.VideoOn = i25;
        this.Takeoff = i26;
        this.AutoLand = i27;
        this.LandFinish = i28;
        this.GpsNum = i29;
        this.GpsFine = i30;
        this.GpsQuality = i31;
        this.mode_gps = i32;
        this.RcFastMode = i33;
        this.PTZadj = i34;
    }
}

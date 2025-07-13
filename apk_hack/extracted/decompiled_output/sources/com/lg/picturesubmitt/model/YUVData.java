package com.lg.picturesubmitt.model;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class YUVData {
    public static final int I420 = 0;
    public static final int NV12 = 1;
    public static final int NV21 = 2;

    /* renamed from: h  reason: collision with root package name */
    int f888h;
    int type = 0;

    /* renamed from: u  reason: collision with root package name */
    private byte[] f889u;

    /* renamed from: v  reason: collision with root package name */
    private byte[] f890v;
    int w;

    /* renamed from: y  reason: collision with root package name */
    private byte[] f891y;
    private byte[] yuv;

    public static int getI420() {
        return 0;
    }

    public int getH() {
        return this.f888h;
    }

    public byte[] getU() {
        return this.f889u;
    }

    public byte[] getV() {
        return this.f890v;
    }

    public int getW() {
        return this.w;
    }

    public byte[] getY() {
        return this.f891y;
    }

    public byte[] getYuv() {
        return this.yuv;
    }

    public void setH(int i3) {
        this.f888h = i3;
    }

    public void setU(byte[] bArr) {
        this.f889u = bArr;
    }

    public void setV(byte[] bArr) {
        this.f890v = bArr;
    }

    public void setW(int i3) {
        this.w = i3;
    }

    public void setY(byte[] bArr) {
        this.f891y = bArr;
    }

    public void setYuv(byte[] bArr) {
        this.yuv = bArr;
    }
}

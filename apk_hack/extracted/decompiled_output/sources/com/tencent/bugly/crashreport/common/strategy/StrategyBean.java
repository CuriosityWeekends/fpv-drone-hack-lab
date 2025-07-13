package com.tencent.bugly.crashreport.common.strategy;

import a1.i;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ap;
import j1.n0;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new n0(6);

    /* renamed from: a  reason: collision with root package name */
    public static String f1182a = "https://android.bugly.qq.com/rqd/async";
    public static String b = "https://android.bugly.qq.com/rqd/async";
    public static String c;
    public long d;

    /* renamed from: e  reason: collision with root package name */
    public long f1183e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1184f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1185g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1186h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1187i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1188j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1189k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1190l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1191m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1192n;

    /* renamed from: o  reason: collision with root package name */
    public long f1193o;

    /* renamed from: p  reason: collision with root package name */
    public long f1194p;
    public String q;

    /* renamed from: r  reason: collision with root package name */
    public String f1195r;
    public String s;

    /* renamed from: t  reason: collision with root package name */
    public Map<String, String> f1196t;

    /* renamed from: u  reason: collision with root package name */
    public int f1197u;

    /* renamed from: v  reason: collision with root package name */
    public long f1198v;
    public long w;

    public StrategyBean() {
        this.d = -1L;
        this.f1183e = -1L;
        this.f1184f = true;
        this.f1185g = true;
        this.f1186h = true;
        this.f1187i = true;
        this.f1188j = false;
        this.f1189k = true;
        this.f1190l = true;
        this.f1191m = true;
        this.f1192n = true;
        this.f1194p = 30000L;
        this.q = f1182a;
        this.f1195r = b;
        this.f1197u = 10;
        this.f1198v = 300000L;
        this.w = -1L;
        this.f1183e = System.currentTimeMillis();
        StringBuilder l5 = i.l("S(@L@L@)");
        c = l5.toString();
        l5.setLength(0);
        l5.append("*^@K#K@!");
        this.s = l5.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f1183e);
        parcel.writeByte(this.f1184f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1185g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1186h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.q);
        parcel.writeString(this.f1195r);
        parcel.writeString(this.s);
        ap.b(parcel, this.f1196t);
        parcel.writeByte(this.f1187i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1188j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1191m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1192n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f1194p);
        parcel.writeByte(this.f1189k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1190l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f1193o);
        parcel.writeInt(this.f1197u);
        parcel.writeLong(this.f1198v);
        parcel.writeLong(this.w);
    }

    public StrategyBean(Parcel parcel) {
        this.d = -1L;
        this.f1183e = -1L;
        boolean z3 = true;
        this.f1184f = true;
        this.f1185g = true;
        this.f1186h = true;
        this.f1187i = true;
        this.f1188j = false;
        this.f1189k = true;
        this.f1190l = true;
        this.f1191m = true;
        this.f1192n = true;
        this.f1194p = 30000L;
        this.q = f1182a;
        this.f1195r = b;
        this.f1197u = 10;
        this.f1198v = 300000L;
        this.w = -1L;
        try {
            c = "S(@L@L@)";
            this.f1183e = parcel.readLong();
            this.f1184f = parcel.readByte() == 1;
            this.f1185g = parcel.readByte() == 1;
            this.f1186h = parcel.readByte() == 1;
            this.q = parcel.readString();
            this.f1195r = parcel.readString();
            this.s = parcel.readString();
            this.f1196t = ap.b(parcel);
            this.f1187i = parcel.readByte() == 1;
            this.f1188j = parcel.readByte() == 1;
            this.f1191m = parcel.readByte() == 1;
            this.f1192n = parcel.readByte() == 1;
            this.f1194p = parcel.readLong();
            this.f1189k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z3 = false;
            }
            this.f1190l = z3;
            this.f1193o = parcel.readLong();
            this.f1197u = parcel.readInt();
            this.f1198v = parcel.readLong();
            this.w = parcel.readLong();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}

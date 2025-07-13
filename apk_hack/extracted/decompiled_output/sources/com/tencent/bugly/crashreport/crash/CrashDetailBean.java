package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ap;
import j1.n0;
import java.util.Map;
import java.util.UUID;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new n0(7);
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public long Q;
    public boolean R;
    public Map<String, String> S;
    public Map<String, String> T;
    public int U;
    public int V;
    public Map<String, String> W;
    public Map<String, String> X;
    public byte[] Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public long f1199a;
    public String aa;
    public int b;
    public String c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public String f1200e;

    /* renamed from: f  reason: collision with root package name */
    public String f1201f;

    /* renamed from: g  reason: collision with root package name */
    public String f1202g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, PlugInBean> f1203h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, PlugInBean> f1204i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1205j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1206k;

    /* renamed from: l  reason: collision with root package name */
    public int f1207l;

    /* renamed from: m  reason: collision with root package name */
    public String f1208m;

    /* renamed from: n  reason: collision with root package name */
    public String f1209n;

    /* renamed from: o  reason: collision with root package name */
    public String f1210o;

    /* renamed from: p  reason: collision with root package name */
    public String f1211p;
    public String q;

    /* renamed from: r  reason: collision with root package name */
    public long f1212r;
    public String s;

    /* renamed from: t  reason: collision with root package name */
    public int f1213t;

    /* renamed from: u  reason: collision with root package name */
    public String f1214u;

    /* renamed from: v  reason: collision with root package name */
    public String f1215v;
    public String w;

    /* renamed from: x  reason: collision with root package name */
    public String f1216x;

    /* renamed from: y  reason: collision with root package name */
    public byte[] f1217y;

    /* renamed from: z  reason: collision with root package name */
    public Map<String, String> f1218z;

    public CrashDetailBean() {
        this.f1199a = -1L;
        this.b = 0;
        this.c = UUID.randomUUID().toString();
        this.d = false;
        this.f1200e = "";
        this.f1201f = "";
        this.f1202g = "";
        this.f1203h = null;
        this.f1204i = null;
        this.f1205j = false;
        this.f1206k = false;
        this.f1207l = 0;
        this.f1208m = "";
        this.f1209n = "";
        this.f1210o = "";
        this.f1211p = "";
        this.q = "";
        this.f1212r = -1L;
        this.s = null;
        this.f1213t = 0;
        this.f1214u = "";
        this.f1215v = "";
        this.w = null;
        this.f1216x = null;
        this.f1217y = null;
        this.f1218z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        int i3;
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 != null && this.f1212r - crashDetailBean2.f1212r <= 0) {
            if (i3 < 0) {
                return -1;
            }
            return 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f1200e);
        parcel.writeString(this.f1201f);
        parcel.writeString(this.f1202g);
        parcel.writeByte(this.f1205j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1206k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f1207l);
        parcel.writeString(this.f1208m);
        parcel.writeString(this.f1209n);
        parcel.writeString(this.f1210o);
        parcel.writeString(this.f1211p);
        parcel.writeString(this.q);
        parcel.writeLong(this.f1212r);
        parcel.writeString(this.s);
        parcel.writeInt(this.f1213t);
        parcel.writeString(this.f1214u);
        parcel.writeString(this.f1215v);
        parcel.writeString(this.w);
        ap.b(parcel, this.f1218z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.O);
        parcel.writeString(this.P);
        parcel.writeLong(this.Q);
        parcel.writeByte(this.R ? (byte) 1 : (byte) 0);
        ap.b(parcel, this.S);
        ap.a(parcel, this.f1203h);
        ap.a(parcel, this.f1204i);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        ap.b(parcel, this.W);
        ap.b(parcel, this.X);
        parcel.writeByteArray(this.Y);
        parcel.writeByteArray(this.f1217y);
        parcel.writeString(this.Z);
        parcel.writeString(this.aa);
        parcel.writeString(this.f1216x);
        parcel.writeLong(this.I);
        parcel.writeLong(this.J);
        parcel.writeLong(this.K);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f1199a = -1L;
        this.b = 0;
        this.c = UUID.randomUUID().toString();
        this.d = false;
        this.f1200e = "";
        this.f1201f = "";
        this.f1202g = "";
        this.f1203h = null;
        this.f1204i = null;
        this.f1205j = false;
        this.f1206k = false;
        this.f1207l = 0;
        this.f1208m = "";
        this.f1209n = "";
        this.f1210o = "";
        this.f1211p = "";
        this.q = "";
        this.f1212r = -1L;
        this.s = null;
        this.f1213t = 0;
        this.f1214u = "";
        this.f1215v = "";
        this.w = null;
        this.f1216x = null;
        this.f1217y = null;
        this.f1218z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readByte() == 1;
        this.f1200e = parcel.readString();
        this.f1201f = parcel.readString();
        this.f1202g = parcel.readString();
        this.f1205j = parcel.readByte() == 1;
        this.f1206k = parcel.readByte() == 1;
        this.f1207l = parcel.readInt();
        this.f1208m = parcel.readString();
        this.f1209n = parcel.readString();
        this.f1210o = parcel.readString();
        this.f1211p = parcel.readString();
        this.q = parcel.readString();
        this.f1212r = parcel.readLong();
        this.s = parcel.readString();
        this.f1213t = parcel.readInt();
        this.f1214u = parcel.readString();
        this.f1215v = parcel.readString();
        this.w = parcel.readString();
        this.f1218z = ap.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readLong();
        this.R = parcel.readByte() == 1;
        this.S = ap.b(parcel);
        this.f1203h = ap.a(parcel);
        this.f1204i = ap.a(parcel);
        this.U = parcel.readInt();
        this.V = parcel.readInt();
        this.W = ap.b(parcel);
        this.X = ap.b(parcel);
        this.Y = parcel.createByteArray();
        this.f1217y = parcel.createByteArray();
        this.Z = parcel.readString();
        this.aa = parcel.readString();
        this.f1216x = parcel.readString();
        this.I = parcel.readLong();
        this.J = parcel.readLong();
        this.K = parcel.readLong();
    }
}

package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ap;
import j1.n0;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new n0(4);

    /* renamed from: a  reason: collision with root package name */
    public long f1167a;
    public int b;
    public String c;
    public String d;

    /* renamed from: e  reason: collision with root package name */
    public long f1168e;

    /* renamed from: f  reason: collision with root package name */
    public long f1169f;

    /* renamed from: g  reason: collision with root package name */
    public long f1170g;

    /* renamed from: h  reason: collision with root package name */
    public long f1171h;

    /* renamed from: i  reason: collision with root package name */
    public long f1172i;

    /* renamed from: j  reason: collision with root package name */
    public String f1173j;

    /* renamed from: k  reason: collision with root package name */
    public long f1174k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1175l;

    /* renamed from: m  reason: collision with root package name */
    public String f1176m;

    /* renamed from: n  reason: collision with root package name */
    public String f1177n;

    /* renamed from: o  reason: collision with root package name */
    public int f1178o;

    /* renamed from: p  reason: collision with root package name */
    public int f1179p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public Map<String, String> f1180r;
    public Map<String, String> s;

    public UserInfoBean() {
        this.f1174k = 0L;
        this.f1175l = false;
        this.f1176m = "unknown";
        this.f1179p = -1;
        this.q = -1;
        this.f1180r = null;
        this.s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeLong(this.f1168e);
        parcel.writeLong(this.f1169f);
        parcel.writeLong(this.f1170g);
        parcel.writeLong(this.f1171h);
        parcel.writeLong(this.f1172i);
        parcel.writeString(this.f1173j);
        parcel.writeLong(this.f1174k);
        parcel.writeByte(this.f1175l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f1176m);
        parcel.writeInt(this.f1179p);
        parcel.writeInt(this.q);
        ap.b(parcel, this.f1180r);
        ap.b(parcel, this.s);
        parcel.writeString(this.f1177n);
        parcel.writeInt(this.f1178o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f1174k = 0L;
        this.f1175l = false;
        this.f1176m = "unknown";
        this.f1179p = -1;
        this.q = -1;
        this.f1180r = null;
        this.s = null;
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.f1168e = parcel.readLong();
        this.f1169f = parcel.readLong();
        this.f1170g = parcel.readLong();
        this.f1171h = parcel.readLong();
        this.f1172i = parcel.readLong();
        this.f1173j = parcel.readString();
        this.f1174k = parcel.readLong();
        this.f1175l = parcel.readByte() == 1;
        this.f1176m = parcel.readString();
        this.f1179p = parcel.readInt();
        this.q = parcel.readInt();
        this.f1180r = ap.b(parcel);
        this.s = ap.b(parcel);
        this.f1177n = parcel.readString();
        this.f1178o = parcel.readInt();
    }
}

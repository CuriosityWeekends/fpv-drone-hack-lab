package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import j1.n0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new n0(5);

    /* renamed from: a  reason: collision with root package name */
    public final String f1181a;
    public final String b;
    public final String c;

    public PlugInBean(String str, String str2, String str3) {
        this.f1181a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f1181a + " plV:" + this.b + " plUUID:" + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f1181a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public PlugInBean(Parcel parcel) {
        this.f1181a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}

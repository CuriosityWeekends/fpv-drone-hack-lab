package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new g(24);

    /* renamed from: a  reason: collision with root package name */
    public final String f378a;
    public final String b;
    public final Uri c;
    public final List d;

    /* renamed from: e  reason: collision with root package name */
    public final String f379e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f380f;

    public DownloadRequest(Parcel parcel) {
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.f378a = readString;
        this.b = parcel.readString();
        this.c = Uri.parse(parcel.readString());
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            arrayList.add(parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.d = Collections.unmodifiableList(arrayList);
        this.f379e = parcel.readString();
        this.f380f = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        if (!this.f378a.equals(downloadRequest.f378a) || !this.b.equals(downloadRequest.b) || !this.c.equals(downloadRequest.c) || !this.d.equals(downloadRequest.d) || !w.a(this.f379e, downloadRequest.f379e) || !Arrays.equals(this.f380f, downloadRequest.f380f)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i3;
        String str = this.b;
        int hashCode = this.f378a.hashCode();
        int hashCode2 = str.hashCode();
        int hashCode3 = this.c.hashCode();
        int hashCode4 = (this.d.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (str.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        String str2 = this.f379e;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        return Arrays.hashCode(this.f380f) + ((hashCode4 + i3) * 31);
    }

    public final String toString() {
        return this.b + ":" + this.f378a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f378a);
        parcel.writeString(this.b);
        parcel.writeString(this.c.toString());
        List list = this.d;
        parcel.writeInt(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            parcel.writeParcelable((Parcelable) list.get(i5), 0);
        }
        parcel.writeString(this.f379e);
        parcel.writeByteArray(this.f380f);
    }
}

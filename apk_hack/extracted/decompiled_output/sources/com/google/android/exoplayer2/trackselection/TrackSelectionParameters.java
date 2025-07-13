package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b2.g;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR = new g(2);

    /* renamed from: a  reason: collision with root package name */
    public final String f415a;
    public final String b;
    public final int c;
    public final boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final int f416e;

    public TrackSelectionParameters() {
        this.f415a = null;
        this.b = null;
        this.c = 0;
        this.d = false;
        this.f416e = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        if (TextUtils.equals(this.f415a, trackSelectionParameters.f415a) && TextUtils.equals(this.b, trackSelectionParameters.b) && this.c == trackSelectionParameters.c && this.d == trackSelectionParameters.d && this.f416e == trackSelectionParameters.f416e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = 0;
        String str = this.f415a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode + 31) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((((((i5 + i3) * 31) + this.c) * 31) + (this.d ? 1 : 0)) * 31) + this.f416e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f415a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        int i5 = w.f1960a;
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.f416e);
    }

    public TrackSelectionParameters(Parcel parcel) {
        this.f415a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        int i3 = w.f1960a;
        this.d = parcel.readInt() != 0;
        this.f416e = parcel.readInt();
    }
}

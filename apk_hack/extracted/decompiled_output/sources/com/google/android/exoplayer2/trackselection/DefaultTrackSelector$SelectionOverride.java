package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class DefaultTrackSelector$SelectionOverride implements Parcelable {
    public static final Parcelable.Creator<DefaultTrackSelector$SelectionOverride> CREATOR = new g(1);

    /* renamed from: a  reason: collision with root package name */
    public final int f414a;
    public final int[] b;
    public final int c;
    public final int d;

    public DefaultTrackSelector$SelectionOverride(Parcel parcel) {
        this.f414a = parcel.readInt();
        int[] iArr = new int[parcel.readByte()];
        this.b = iArr;
        parcel.readIntArray(iArr);
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultTrackSelector$SelectionOverride.class != obj.getClass()) {
            return false;
        }
        DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = (DefaultTrackSelector$SelectionOverride) obj;
        if (this.f414a == defaultTrackSelector$SelectionOverride.f414a && Arrays.equals(this.b, defaultTrackSelector$SelectionOverride.b) && this.c == defaultTrackSelector$SelectionOverride.c && this.d == defaultTrackSelector$SelectionOverride.d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.b) + (this.f414a * 31)) * 31) + this.c) * 31) + this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f414a);
        int[] iArr = this.b;
        parcel.writeInt(iArr.length);
        parcel.writeIntArray(iArr);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
}

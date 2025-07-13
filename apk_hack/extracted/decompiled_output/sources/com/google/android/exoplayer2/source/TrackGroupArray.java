package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import j1.n0;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class TrackGroupArray implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public final int f385a;
    public final TrackGroup[] b;
    public int c;
    public static final TrackGroupArray d = new TrackGroupArray(new TrackGroup[0]);
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new n0(0);

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.b = trackGroupArr;
        this.f385a = trackGroupArr.length;
    }

    public final int c(TrackGroup trackGroup) {
        for (int i3 = 0; i3 < this.f385a; i3++) {
            if (this.b[i3] == trackGroup) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        if (this.f385a == trackGroupArray.f385a && Arrays.equals(this.b, trackGroupArray.b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b);
        }
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i5 = this.f385a;
        parcel.writeInt(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            parcel.writeParcelable(this.b[i6], 0);
        }
    }

    public TrackGroupArray(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f385a = readInt;
        this.b = new TrackGroup[readInt];
        for (int i3 = 0; i3 < this.f385a; i3++) {
            this.b[i3] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }
}

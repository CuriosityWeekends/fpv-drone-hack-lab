package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new g(25);

    /* renamed from: a  reason: collision with root package name */
    public final int f382a;
    public final int b;
    public final int c;

    public StreamKey(Parcel parcel) {
        this.f382a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public final int compareTo(StreamKey streamKey) {
        StreamKey streamKey2 = streamKey;
        int i3 = this.f382a - streamKey2.f382a;
        if (i3 == 0) {
            int i5 = this.b - streamKey2.b;
            if (i5 == 0) {
                return this.c - streamKey2.c;
            }
            return i5;
        }
        return i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        if (this.f382a == streamKey.f382a && this.b == streamKey.b && this.c == streamKey.c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f382a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return this.f382a + "." + this.b + "." + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f382a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }
}

package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import com.google.android.exoplayer2.Format;
import g2.b;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new g(29);

    /* renamed from: a  reason: collision with root package name */
    public final int f384a;
    public final Format[] b;
    public int c;

    public TrackGroup(Format... formatArr) {
        b.h(formatArr.length > 0);
        this.b = formatArr;
        this.f384a = formatArr.length;
    }

    public final int c(Format format) {
        int i3 = 0;
        while (true) {
            Format[] formatArr = this.b;
            if (i3 < formatArr.length) {
                if (format == formatArr[i3]) {
                    return i3;
                }
                i3++;
            } else {
                return -1;
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (this.f384a == trackGroup.f384a && Arrays.equals(this.b, trackGroup.b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = 527 + Arrays.hashCode(this.b);
        }
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i5 = this.f384a;
        parcel.writeInt(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            parcel.writeParcelable(this.b[i6], 0);
        }
    }

    public TrackGroup(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f384a = readInt;
        this.b = new Format[readInt];
        for (int i3 = 0; i3 < this.f384a; i3++) {
            this.b[i3] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }
}

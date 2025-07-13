package com.google.android.exoplayer2.scheduler;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new g(27);

    /* renamed from: a  reason: collision with root package name */
    public final int f383a;

    public Requirements(int i3) {
        this.f383a = (i3 & 2) != 0 ? i3 | 1 : i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Requirements.class != obj.getClass()) {
            return false;
        }
        if (this.f383a == ((Requirements) obj).f383a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f383a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f383a);
    }
}

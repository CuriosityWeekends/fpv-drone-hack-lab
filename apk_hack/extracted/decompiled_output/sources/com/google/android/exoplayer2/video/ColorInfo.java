package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new g(26);

    /* renamed from: a  reason: collision with root package name */
    public final int f497a;
    public final int b;
    public final int c;
    public final byte[] d;

    /* renamed from: e  reason: collision with root package name */
    public int f498e;

    public ColorInfo(int i3, int i5, byte[] bArr, int i6) {
        this.f497a = i3;
        this.b = i5;
        this.c = i6;
        this.d = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ColorInfo.class != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.f497a == colorInfo.f497a && this.b == colorInfo.b && this.c == colorInfo.c && Arrays.equals(this.d, colorInfo.d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.f498e == 0) {
            this.f498e = Arrays.hashCode(this.d) + ((((((527 + this.f497a) * 31) + this.b) * 31) + this.c) * 31);
        }
        return this.f498e;
    }

    public final String toString() {
        boolean z3;
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(this.f497a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        if (this.d != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        sb.append(z3);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i5;
        parcel.writeInt(this.f497a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        byte[] bArr = this.d;
        if (bArr != null) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        int i6 = w.f1960a;
        parcel.writeInt(i5);
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    public ColorInfo(Parcel parcel) {
        this.f497a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        int i3 = w.f1960a;
        this.d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }
}

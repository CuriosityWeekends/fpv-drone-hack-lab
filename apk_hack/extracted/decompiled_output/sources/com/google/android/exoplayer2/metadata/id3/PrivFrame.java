package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new g(16);
    public final String b;
    public final byte[] c;

    public PrivFrame(byte[] bArr, String str) {
        super("PRIV");
        this.b = str;
        this.c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        if (w.a(this.b, privFrame.b) && Arrays.equals(this.c, privFrame.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        String str = this.b;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return Arrays.hashCode(this.c) + ((527 + i3) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f362a + ": owner=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.b);
        parcel.writeByteArray(this.c);
    }

    public PrivFrame(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.b = readString;
        this.c = parcel.createByteArray();
    }
}

package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new g(13);
    public final String b;
    public final String c;
    public final String d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f361e;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f361e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        if (w.a(this.b, geobFrame.b) && w.a(this.c, geobFrame.c) && w.a(this.d, geobFrame.d) && Arrays.equals(this.f361e, geobFrame.f361e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int i5;
        int i6 = 0;
        String str = this.b;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (527 + i3) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (i7 + i5) * 31;
        String str3 = this.d;
        if (str3 != null) {
            i6 = str3.hashCode();
        }
        return Arrays.hashCode(this.f361e) + ((i8 + i6) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f362a + ": mimeType=" + this.b + ", filename=" + this.c + ", description=" + this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeByteArray(this.f361e);
    }

    public GeobFrame(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.b = readString;
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.f361e = parcel.createByteArray();
    }
}

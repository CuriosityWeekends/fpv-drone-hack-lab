package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new g(8);
    public final String b;
    public final String c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f355e;

    public ApicFrame(String str, String str2, int i3, byte[] bArr) {
        super("APIC");
        this.b = str;
        this.c = str2;
        this.d = i3;
        this.f355e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        if (this.d == apicFrame.d && w.a(this.b, apicFrame.b) && w.a(this.c, apicFrame.c) && Arrays.equals(this.f355e, apicFrame.f355e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int i5 = (527 + this.d) * 31;
        int i6 = 0;
        String str = this.b;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i5 + i3) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i6 = str2.hashCode();
        }
        return Arrays.hashCode(this.f355e) + ((i7 + i6) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f362a + ": mimeType=" + this.b + ", description=" + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeByteArray(this.f355e);
    }

    public ApicFrame(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.b = readString;
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.f355e = parcel.createByteArray();
    }
}

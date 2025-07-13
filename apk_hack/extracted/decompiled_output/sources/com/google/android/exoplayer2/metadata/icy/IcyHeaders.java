package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g2.b;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new g(6);

    /* renamed from: a  reason: collision with root package name */
    public final int f351a;
    public final String b;
    public final String c;
    public final String d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f352e;

    /* renamed from: f  reason: collision with root package name */
    public final int f353f;

    public IcyHeaders(int i3, String str, String str2, String str3, boolean z3, int i5) {
        b.e(i5 == -1 || i5 > 0);
        this.f351a = i3;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f352e = z3;
        this.f353f = i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.metadata.icy.IcyHeaders c(java.util.Map r14) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.icy.IcyHeaders.c(java.util.Map):com.google.android.exoplayer2.metadata.icy.IcyHeaders");
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public final /* synthetic */ Format a() {
        return null;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public final /* synthetic */ byte[] b() {
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        if (this.f351a == icyHeaders.f351a && w.a(this.b, icyHeaders.b) && w.a(this.c, icyHeaders.c) && w.a(this.d, icyHeaders.d) && this.f352e == icyHeaders.f352e && this.f353f == icyHeaders.f353f) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int i5;
        int i6 = (527 + this.f351a) * 31;
        int i7 = 0;
        String str = this.b;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i8 = (i6 + i3) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i9 = (i8 + i5) * 31;
        String str3 = this.d;
        if (str3 != null) {
            i7 = str3.hashCode();
        }
        return ((((i9 + i7) * 31) + (this.f352e ? 1 : 0)) * 31) + this.f353f;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.c + "\", genre=\"" + this.b + "\", bitrate=" + this.f351a + ", metadataInterval=" + this.f353f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f351a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        int i5 = w.f1960a;
        parcel.writeInt(this.f352e ? 1 : 0);
        parcel.writeInt(this.f353f);
    }

    public IcyHeaders(Parcel parcel) {
        this.f351a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        int i3 = w.f1960a;
        this.f352e = parcel.readInt() != 0;
        this.f353f = parcel.readInt();
    }
}

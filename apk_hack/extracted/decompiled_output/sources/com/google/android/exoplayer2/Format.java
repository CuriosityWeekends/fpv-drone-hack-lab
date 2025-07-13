package com.google.android.exoplayer2;

import a1.i;
import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import g2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new g(28);
    public final String A;
    public final int B;
    public final Class C;
    public int D;

    /* renamed from: a  reason: collision with root package name */
    public final String f306a;
    public final String b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f307e;

    /* renamed from: f  reason: collision with root package name */
    public final String f308f;

    /* renamed from: g  reason: collision with root package name */
    public final Metadata f309g;

    /* renamed from: h  reason: collision with root package name */
    public final String f310h;

    /* renamed from: i  reason: collision with root package name */
    public final String f311i;

    /* renamed from: j  reason: collision with root package name */
    public final int f312j;

    /* renamed from: k  reason: collision with root package name */
    public final List f313k;

    /* renamed from: l  reason: collision with root package name */
    public final DrmInitData f314l;

    /* renamed from: m  reason: collision with root package name */
    public final long f315m;

    /* renamed from: n  reason: collision with root package name */
    public final int f316n;

    /* renamed from: o  reason: collision with root package name */
    public final int f317o;

    /* renamed from: p  reason: collision with root package name */
    public final float f318p;
    public final int q;

    /* renamed from: r  reason: collision with root package name */
    public final float f319r;
    public final int s;

    /* renamed from: t  reason: collision with root package name */
    public final byte[] f320t;

    /* renamed from: u  reason: collision with root package name */
    public final ColorInfo f321u;

    /* renamed from: v  reason: collision with root package name */
    public final int f322v;
    public final int w;

    /* renamed from: x  reason: collision with root package name */
    public final int f323x;

    /* renamed from: y  reason: collision with root package name */
    public final int f324y;

    /* renamed from: z  reason: collision with root package name */
    public final int f325z;

    public Format(String str, String str2, int i3, int i5, int i6, String str3, Metadata metadata, String str4, String str5, int i7, List list, DrmInitData drmInitData, long j2, int i8, int i9, float f4, int i10, float f5, byte[] bArr, int i11, ColorInfo colorInfo, int i12, int i13, int i14, int i15, int i16, String str6, int i17, Class cls) {
        this.f306a = str;
        this.b = str2;
        this.c = i3;
        this.d = i5;
        this.f307e = i6;
        this.f308f = str3;
        this.f309g = metadata;
        this.f310h = str4;
        this.f311i = str5;
        this.f312j = i7;
        this.f313k = list == null ? Collections.emptyList() : list;
        this.f314l = drmInitData;
        this.f315m = j2;
        this.f316n = i8;
        this.f317o = i9;
        this.f318p = f4;
        int i18 = i10;
        this.q = i18 == -1 ? 0 : i18;
        this.f319r = f5 == -1.0f ? 1.0f : f5;
        this.f320t = bArr;
        this.s = i11;
        this.f321u = colorInfo;
        this.f322v = i12;
        this.w = i13;
        this.f323x = i14;
        int i19 = i15;
        this.f324y = i19 == -1 ? 0 : i19;
        this.f325z = i16 != -1 ? i16 : 0;
        this.A = w.w(str6);
        this.B = i17;
        this.C = cls;
    }

    public static Format i(String str, String str2, String str3, String str4, String str5, Metadata metadata, int i3, int i5, int i6, List list, int i7, int i8, String str6) {
        return new Format(str, str2, i7, i8, i3, str5, metadata, str3, str4, -1, list, null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i5, i6, -1, -1, -1, str6, -1, null);
    }

    public static Format j(String str, String str2, int i3, int i5, int i6, int i7, int i8, int i9, int i10, List list, DrmInitData drmInitData, int i11, String str3, Metadata metadata) {
        return new Format(str, null, i11, 0, i3, null, metadata, null, str2, i5, list, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i6, i7, i8, i9, i10, str3, -1, null);
    }

    public static Format k(String str, String str2, int i3, int i5, int i6, int i7, int i8, List list, DrmInitData drmInitData, int i9, String str3) {
        return j(str, str2, i3, i5, i6, i7, i8, -1, -1, list, drmInitData, i9, str3, null);
    }

    public static Format l(String str, String str2, String str3, String str4, String str5, int i3, int i5, int i6, String str6) {
        return new Format(str, str2, i5, i6, i3, str5, null, str3, str4, -1, null, null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, str6, -1, null);
    }

    public static Format m(String str, String str2, int i3, List list, String str3, DrmInitData drmInitData) {
        return new Format(str, null, i3, 0, -1, null, null, null, str2, -1, list, drmInitData, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, str3, -1, null);
    }

    public static Format n(long j2, String str, String str2) {
        return new Format(str, null, 0, 0, -1, null, null, null, str2, -1, null, null, j2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format o(String str, String str2) {
        return new Format(str, null, 0, 0, -1, null, null, null, str2, -1, null, null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format p(String str, String str2, String str3, String str4, String str5, int i3, int i5, int i6, String str6, int i7) {
        return new Format(str, str2, i5, i6, i3, str5, null, str3, str4, -1, null, null, Long.MAX_VALUE, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, str6, i7, null);
    }

    public static Format q(String str, String str2, int i3, String str3, int i5, DrmInitData drmInitData, long j2, List list) {
        return new Format(str, null, i3, 0, -1, null, null, null, str2, -1, list, drmInitData, j2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, str3, i5, null);
    }

    public static Format r(String str, String str2, String str3, String str4, String str5, Metadata metadata, int i3, int i5, int i6, float f4, ArrayList arrayList, int i7, int i8) {
        return new Format(str, str2, i7, i8, i3, str5, metadata, str3, str4, -1, arrayList, null, Long.MAX_VALUE, i5, i6, f4, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format s(String str, String str2, String str3, int i3, int i5, int i6, List list, int i7, float f4, byte[] bArr, int i8, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, null, 0, 0, -1, str3, null, null, str2, i3, list, drmInitData, Long.MAX_VALUE, i5, i6, -1.0f, i7, f4, bArr, i8, colorInfo, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static String u(Format format) {
        int i3;
        if (format == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("id=");
        sb.append(format.f306a);
        sb.append(", mimeType=");
        sb.append(format.f311i);
        int i5 = format.f307e;
        if (i5 != -1) {
            sb.append(", bitrate=");
            sb.append(i5);
        }
        String str = format.f308f;
        if (str != null) {
            sb.append(", codecs=");
            sb.append(str);
        }
        int i6 = format.f316n;
        if (i6 != -1 && (i3 = format.f317o) != -1) {
            sb.append(", res=");
            sb.append(i6);
            sb.append("x");
            sb.append(i3);
        }
        float f4 = format.f318p;
        if (f4 != -1.0f) {
            sb.append(", fps=");
            sb.append(f4);
        }
        int i7 = format.f322v;
        if (i7 != -1) {
            sb.append(", channels=");
            sb.append(i7);
        }
        int i8 = format.w;
        if (i8 != -1) {
            sb.append(", sample_rate=");
            sb.append(i8);
        }
        String str2 = format.A;
        if (str2 != null) {
            sb.append(", language=");
            sb.append(str2);
        }
        String str3 = format.b;
        if (str3 != null) {
            sb.append(", label=");
            sb.append(str3);
        }
        return sb.toString();
    }

    public final Format c(DrmInitData drmInitData, Metadata metadata) {
        if (drmInitData == this.f314l && metadata == this.f309g) {
            return this;
        }
        return new Format(this.f306a, this.b, this.c, this.d, this.f307e, this.f308f, metadata, this.f310h, this.f311i, this.f312j, this.f313k, drmInitData, this.f315m, this.f316n, this.f317o, this.f318p, this.q, this.f319r, this.f320t, this.s, this.f321u, this.f322v, this.w, this.f323x, this.f324y, this.f325z, this.A, this.B, this.C);
    }

    public final Format d() {
        return new Format(this.f306a, this.b, this.c, this.d, this.f307e, this.f308f, this.f309g, this.f310h, this.f311i, this.f312j, this.f313k, this.f314l, this.f315m, this.f316n, this.f317o, this.f318p, this.q, this.f319r, this.f320t, this.s, this.f321u, this.f322v, this.w, this.f323x, this.f324y, this.f325z, this.A, this.B, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Format e(float f4) {
        return new Format(this.f306a, this.b, this.c, this.d, this.f307e, this.f308f, this.f309g, this.f310h, this.f311i, this.f312j, this.f313k, this.f314l, this.f315m, this.f316n, this.f317o, f4, this.q, this.f319r, this.f320t, this.s, this.f321u, this.f322v, this.w, this.f323x, this.f324y, this.f325z, this.A, this.B, this.C);
    }

    public final boolean equals(Object obj) {
        int i3;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i5 = this.D;
        if ((i5 == 0 || (i3 = format.D) == 0 || i5 == i3) && this.c == format.c && this.d == format.d && this.f307e == format.f307e && this.f312j == format.f312j && this.f315m == format.f315m && this.f316n == format.f316n && this.f317o == format.f317o && this.q == format.q && this.s == format.s && this.f322v == format.f322v && this.w == format.w && this.f323x == format.f323x && this.f324y == format.f324y && this.f325z == format.f325z && this.B == format.B && Float.compare(this.f318p, format.f318p) == 0 && Float.compare(this.f319r, format.f319r) == 0 && w.a(this.C, format.C) && w.a(this.f306a, format.f306a) && w.a(this.b, format.b) && w.a(this.f308f, format.f308f) && w.a(this.f310h, format.f310h) && w.a(this.f311i, format.f311i) && w.a(this.A, format.A) && Arrays.equals(this.f320t, format.f320t) && w.a(this.f309g, format.f309g) && w.a(this.f321u, format.f321u) && w.a(this.f314l, format.f314l) && t(format)) {
            return true;
        }
        return false;
    }

    public final Format f(int i3, int i5) {
        return new Format(this.f306a, this.b, this.c, this.d, this.f307e, this.f308f, this.f309g, this.f310h, this.f311i, this.f312j, this.f313k, this.f314l, this.f315m, this.f316n, this.f317o, this.f318p, this.q, this.f319r, this.f320t, this.s, this.f321u, this.f322v, this.w, this.f323x, i3, i5, this.A, this.B, this.C);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.exoplayer2.Format g(com.google.android.exoplayer2.Format r36) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.Format.g(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.Format");
    }

    public final Format h(long j2) {
        return new Format(this.f306a, this.b, this.c, this.d, this.f307e, this.f308f, this.f309g, this.f310h, this.f311i, this.f312j, this.f313k, this.f314l, j2, this.f316n, this.f317o, this.f318p, this.q, this.f319r, this.f320t, this.s, this.f321u, this.f322v, this.w, this.f323x, this.f324y, this.f325z, this.A, this.B, this.C);
    }

    public final int hashCode() {
        int hashCode;
        int i3;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        if (this.D == 0) {
            int i5 = 0;
            String str = this.f306a;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i6 = (527 + hashCode) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i3 = str2.hashCode();
            } else {
                i3 = 0;
            }
            int i7 = (((((((i6 + i3) * 31) + this.c) * 31) + this.d) * 31) + this.f307e) * 31;
            String str3 = this.f308f;
            if (str3 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str3.hashCode();
            }
            int i8 = (i7 + hashCode2) * 31;
            Metadata metadata = this.f309g;
            if (metadata == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = Arrays.hashCode(metadata.f330a);
            }
            int i9 = (i8 + hashCode3) * 31;
            String str4 = this.f310h;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i10 = (i9 + hashCode4) * 31;
            String str5 = this.f311i;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int floatToIntBits = Float.floatToIntBits(this.f318p);
            int floatToIntBits2 = (((((((((((((Float.floatToIntBits(this.f319r) + ((((floatToIntBits + ((((((((((i10 + hashCode5) * 31) + this.f312j) * 31) + ((int) this.f315m)) * 31) + this.f316n) * 31) + this.f317o) * 31)) * 31) + this.q) * 31)) * 31) + this.s) * 31) + this.f322v) * 31) + this.w) * 31) + this.f323x) * 31) + this.f324y) * 31) + this.f325z) * 31;
            String str6 = this.A;
            if (str6 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str6.hashCode();
            }
            int i11 = (((floatToIntBits2 + hashCode6) * 31) + this.B) * 31;
            Class cls = this.C;
            if (cls != null) {
                i5 = cls.hashCode();
            }
            this.D = i11 + i5;
        }
        return this.D;
    }

    public final boolean t(Format format) {
        List list = this.f313k;
        if (list.size() != format.f313k.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!Arrays.equals((byte[]) list.get(i3), (byte[]) format.f313k.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Format(");
        sb.append(this.f306a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.f310h);
        sb.append(", ");
        sb.append(this.f311i);
        sb.append(", ");
        sb.append(this.f308f);
        sb.append(", ");
        sb.append(this.f307e);
        sb.append(", ");
        sb.append(this.A);
        sb.append(", [");
        sb.append(this.f316n);
        sb.append(", ");
        sb.append(this.f317o);
        sb.append(", ");
        sb.append(this.f318p);
        sb.append("], [");
        sb.append(this.f322v);
        sb.append(", ");
        return i.j(sb, this.w, "])");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i5 = 1;
        parcel.writeString(this.f306a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.f307e);
        parcel.writeString(this.f308f);
        parcel.writeParcelable(this.f309g, 0);
        parcel.writeString(this.f310h);
        parcel.writeString(this.f311i);
        parcel.writeInt(this.f312j);
        List list = this.f313k;
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeByteArray((byte[]) list.get(i6));
        }
        parcel.writeParcelable(this.f314l, 0);
        parcel.writeLong(this.f315m);
        parcel.writeInt(this.f316n);
        parcel.writeInt(this.f317o);
        parcel.writeFloat(this.f318p);
        parcel.writeInt(this.q);
        parcel.writeFloat(this.f319r);
        byte[] bArr = this.f320t;
        if (bArr == null) {
            i5 = 0;
        }
        int i7 = w.f1960a;
        parcel.writeInt(i5);
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.s);
        parcel.writeParcelable(this.f321u, i3);
        parcel.writeInt(this.f322v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.f323x);
        parcel.writeInt(this.f324y);
        parcel.writeInt(this.f325z);
        parcel.writeString(this.A);
        parcel.writeInt(this.B);
    }

    public Format(Parcel parcel) {
        this.f306a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.f307e = parcel.readInt();
        this.f308f = parcel.readString();
        this.f309g = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        this.f310h = parcel.readString();
        this.f311i = parcel.readString();
        this.f312j = parcel.readInt();
        int readInt = parcel.readInt();
        this.f313k = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            this.f313k.add(parcel.createByteArray());
        }
        this.f314l = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.f315m = parcel.readLong();
        this.f316n = parcel.readInt();
        this.f317o = parcel.readInt();
        this.f318p = parcel.readFloat();
        this.q = parcel.readInt();
        this.f319r = parcel.readFloat();
        int i5 = w.f1960a;
        this.f320t = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.s = parcel.readInt();
        this.f321u = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.f322v = parcel.readInt();
        this.w = parcel.readInt();
        this.f323x = parcel.readInt();
        this.f324y = parcel.readInt();
        this.f325z = parcel.readInt();
        this.A = parcel.readString();
        this.B = parcel.readInt();
        this.C = null;
    }
}

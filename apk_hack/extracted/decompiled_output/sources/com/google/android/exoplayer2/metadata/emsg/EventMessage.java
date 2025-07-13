package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class EventMessage implements Metadata.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final String f342a;
    public final String b;
    public final long c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f343e;

    /* renamed from: f  reason: collision with root package name */
    public int f344f;

    /* renamed from: g  reason: collision with root package name */
    public static final Format f340g = Format.n(Long.MAX_VALUE, null, "application/id3");

    /* renamed from: h  reason: collision with root package name */
    public static final Format f341h = Format.n(Long.MAX_VALUE, null, "application/x-scte35");
    public static final Parcelable.Creator<EventMessage> CREATOR = new g(3);

    public EventMessage(String str, String str2, long j2, long j5, byte[] bArr) {
        this.f342a = str;
        this.b = str2;
        this.c = j2;
        this.d = j5;
        this.f343e = bArr;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public final Format a() {
        String str = this.f342a;
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals("urn:scte:scte35:2014:bin")) {
                    c = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals("https://aomedia.org/emsg/ID3")) {
                    c = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return f341h;
            case 1:
            case 2:
                return f340g;
            default:
                return null;
        }
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public final byte[] b() {
        if (a() != null) {
            return this.f343e;
        }
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
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        if (this.c == eventMessage.c && this.d == eventMessage.d && w.a(this.f342a, eventMessage.f342a) && w.a(this.b, eventMessage.b) && Arrays.equals(this.f343e, eventMessage.f343e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        if (this.f344f == 0) {
            int i5 = 0;
            String str = this.f342a;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i6 = (527 + i3) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            long j2 = this.c;
            long j5 = this.d;
            this.f344f = Arrays.hashCode(this.f343e) + ((((((i6 + i5) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31);
        }
        return this.f344f;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f342a + ", id=" + this.d + ", durationMs=" + this.c + ", value=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f342a);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeByteArray(this.f343e);
    }

    public EventMessage(Parcel parcel) {
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.f342a = readString;
        this.b = parcel.readString();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.f343e = parcel.createByteArray();
    }
}

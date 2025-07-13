package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new g(4);

    /* renamed from: a  reason: collision with root package name */
    public final int f345a;
    public final String b;
    public final String c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f346e;

    /* renamed from: f  reason: collision with root package name */
    public final int f347f;

    /* renamed from: g  reason: collision with root package name */
    public final int f348g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f349h;

    public PictureFrame(int i3, String str, String str2, int i5, int i6, int i7, int i8, byte[] bArr) {
        this.f345a = i3;
        this.b = str;
        this.c = str2;
        this.d = i5;
        this.f346e = i6;
        this.f347f = i7;
        this.f348g = i8;
        this.f349h = bArr;
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
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        if (this.f345a == pictureFrame.f345a && this.b.equals(pictureFrame.b) && this.c.equals(pictureFrame.c) && this.d == pictureFrame.d && this.f346e == pictureFrame.f346e && this.f347f == pictureFrame.f347f && this.f348g == pictureFrame.f348g && Arrays.equals(this.f349h, pictureFrame.f349h)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        return Arrays.hashCode(this.f349h) + ((((((((((hashCode2 + ((hashCode + ((527 + this.f345a) * 31)) * 31)) * 31) + this.d) * 31) + this.f346e) * 31) + this.f347f) * 31) + this.f348g) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.b + ", description=" + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f345a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.f346e);
        parcel.writeInt(this.f347f);
        parcel.writeInt(this.f348g);
        parcel.writeByteArray(this.f349h);
    }

    public PictureFrame(Parcel parcel) {
        this.f345a = parcel.readInt();
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.b = readString;
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.f346e = parcel.readInt();
        this.f347f = parcel.readInt();
        this.f348g = parcel.readInt();
        this.f349h = parcel.createByteArray();
    }
}

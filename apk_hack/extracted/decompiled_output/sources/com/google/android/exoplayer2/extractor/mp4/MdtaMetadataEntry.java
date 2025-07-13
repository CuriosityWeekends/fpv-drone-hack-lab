package com.google.android.exoplayer2.extractor.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g2.w;
import j1.n0;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new n0(3);

    /* renamed from: a  reason: collision with root package name */
    public final String f329a;
    public final byte[] b;
    public final int c;
    public final int d;

    public MdtaMetadataEntry(byte[] bArr, int i3, int i5, String str) {
        this.f329a = str;
        this.b = bArr;
        this.c = i3;
        this.d = i5;
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
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        if (this.f329a.equals(mdtaMetadataEntry.f329a) && Arrays.equals(this.b, mdtaMetadataEntry.b) && this.c == mdtaMetadataEntry.c && this.d == mdtaMetadataEntry.d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.b) + ((this.f329a.hashCode() + 527) * 31)) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "mdta: key=" + this.f329a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f329a);
        byte[] bArr = this.b;
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }

    public MdtaMetadataEntry(Parcel parcel) {
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.f329a = readString;
        byte[] bArr = new byte[parcel.readInt()];
        this.b = bArr;
        parcel.readByteArray(bArr);
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }
}

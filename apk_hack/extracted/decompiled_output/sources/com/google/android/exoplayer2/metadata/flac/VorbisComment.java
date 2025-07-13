package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new g(5);

    /* renamed from: a  reason: collision with root package name */
    public final String f350a;
    public final String b;

    public VorbisComment(String str, String str2) {
        this.f350a = str;
        this.b = str2;
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
        if (obj == null || VorbisComment.class != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        if (this.f350a.equals(vorbisComment.f350a) && this.b.equals(vorbisComment.b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + ((this.f350a.hashCode() + 527) * 31);
    }

    public final String toString() {
        return "VC: " + this.f350a + "=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f350a);
        parcel.writeString(this.b);
    }

    public VorbisComment(Parcel parcel) {
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.f350a = readString;
        this.b = parcel.readString();
    }
}

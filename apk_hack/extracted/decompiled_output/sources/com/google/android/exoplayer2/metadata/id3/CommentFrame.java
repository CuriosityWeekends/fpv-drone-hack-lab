package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new g(12);
    public final String b;
    public final String c;
    public final String d;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        if (w.a(this.c, commentFrame.c) && w.a(this.b, commentFrame.b) && w.a(this.d, commentFrame.d)) {
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
        return i8 + i6;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return this.f362a + ": language=" + this.b + ", description=" + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f362a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }

    public CommentFrame(Parcel parcel) {
        super("COMM");
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.b = readString;
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}

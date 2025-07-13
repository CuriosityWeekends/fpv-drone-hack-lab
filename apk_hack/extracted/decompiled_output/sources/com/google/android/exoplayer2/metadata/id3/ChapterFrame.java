package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new g(10);
    public final String b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final long f356e;

    /* renamed from: f  reason: collision with root package name */
    public final long f357f;

    /* renamed from: g  reason: collision with root package name */
    public final Id3Frame[] f358g;

    public ChapterFrame(String str, int i3, int i5, long j2, long j5, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.b = str;
        this.c = i3;
        this.d = i5;
        this.f356e = j2;
        this.f357f = j5;
        this.f358g = id3FrameArr;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        if (this.c == chapterFrame.c && this.d == chapterFrame.d && this.f356e == chapterFrame.f356e && this.f357f == chapterFrame.f357f && w.a(this.b, chapterFrame.b) && Arrays.equals(this.f358g, chapterFrame.f358g)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int i5 = (((((((527 + this.c) * 31) + this.d) * 31) + ((int) this.f356e)) * 31) + ((int) this.f357f)) * 31;
        String str = this.b;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i5 + i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.f356e);
        parcel.writeLong(this.f357f);
        Id3Frame[] id3FrameArr = this.f358g;
        parcel.writeInt(id3FrameArr.length);
        for (Id3Frame id3Frame : id3FrameArr) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterFrame(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.b = readString;
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.f356e = parcel.readLong();
        this.f357f = parcel.readLong();
        int readInt = parcel.readInt();
        this.f358g = new Id3Frame[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            this.f358g[i5] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}

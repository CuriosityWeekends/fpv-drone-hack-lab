package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new g(11);
    public final String b;
    public final boolean c;
    public final boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f359e;

    /* renamed from: f  reason: collision with root package name */
    public final Id3Frame[] f360f;

    public ChapterTocFrame(String str, boolean z3, boolean z5, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.b = str;
        this.c = z3;
        this.d = z5;
        this.f359e = strArr;
        this.f360f = id3FrameArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.c == chapterTocFrame.c && this.d == chapterTocFrame.d && w.a(this.b, chapterTocFrame.b) && Arrays.equals(this.f359e, chapterTocFrame.f359e) && Arrays.equals(this.f360f, chapterTocFrame.f360f)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int i5 = (((527 + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31;
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
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f359e);
        Id3Frame[] id3FrameArr = this.f360f;
        parcel.writeInt(id3FrameArr.length);
        for (Id3Frame id3Frame : id3FrameArr) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        String readString = parcel.readString();
        int i3 = w.f1960a;
        this.b = readString;
        this.c = parcel.readByte() != 0;
        this.d = parcel.readByte() != 0;
        this.f359e = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f360f = new Id3Frame[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            this.f360f[i5] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}

package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new g(15);
    public final int b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f363e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f364f;

    public MlltFrame(int i3, int i5, int[] iArr, int[] iArr2, int i6) {
        super("MLLT");
        this.b = i3;
        this.c = i5;
        this.d = i6;
        this.f363e = iArr;
        this.f364f = iArr2;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        if (this.b == mlltFrame.b && this.c == mlltFrame.c && this.d == mlltFrame.d && Arrays.equals(this.f363e, mlltFrame.f363e) && Arrays.equals(this.f364f, mlltFrame.f364f)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.f363e);
        return Arrays.hashCode(this.f364f) + ((hashCode + ((((((527 + this.b) * 31) + this.c) * 31) + this.d) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeIntArray(this.f363e);
        parcel.writeIntArray(this.f364f);
    }

    public MlltFrame(Parcel parcel) {
        super("MLLT");
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        int i3 = w.f1960a;
        this.f363e = createIntArray;
        this.f364f = parcel.createIntArray();
    }
}

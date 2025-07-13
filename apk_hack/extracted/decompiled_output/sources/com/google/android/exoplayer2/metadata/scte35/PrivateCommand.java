package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new g(19);

    /* renamed from: a  reason: collision with root package name */
    public final long f365a;
    public final long b;
    public final byte[] c;

    public PrivateCommand(long j2, byte[] bArr, long j5) {
        this.f365a = j5;
        this.b = j2;
        this.c = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f365a);
        parcel.writeLong(this.b);
        parcel.writeByteArray(this.c);
    }

    public PrivateCommand(Parcel parcel) {
        this.f365a = parcel.readLong();
        this.b = parcel.readLong();
        byte[] createByteArray = parcel.createByteArray();
        int i3 = w.f1960a;
        this.c = createByteArray;
    }
}

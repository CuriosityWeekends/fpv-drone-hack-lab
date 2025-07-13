package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import c0.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new g(23);

    /* renamed from: a  reason: collision with root package name */
    public final long f377a;
    public final long b;

    public TimeSignalCommand(long j2, long j5) {
        this.f377a = j2;
        this.b = j5;
    }

    public static long c(b bVar, long j2) {
        long n5 = bVar.n();
        if ((128 & n5) != 0) {
            return 8589934591L & ((((n5 & 1) << 32) | bVar.o()) + j2);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f377a);
        parcel.writeLong(this.b);
    }
}

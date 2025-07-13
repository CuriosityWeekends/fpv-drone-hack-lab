package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g1.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new g(20);

    /* renamed from: a  reason: collision with root package name */
    public final long f366a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f367e;

    /* renamed from: f  reason: collision with root package name */
    public final long f368f;

    /* renamed from: g  reason: collision with root package name */
    public final long f369g;

    /* renamed from: h  reason: collision with root package name */
    public final List f370h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f371i;

    /* renamed from: j  reason: collision with root package name */
    public final long f372j;

    /* renamed from: k  reason: collision with root package name */
    public final int f373k;

    /* renamed from: l  reason: collision with root package name */
    public final int f374l;

    /* renamed from: m  reason: collision with root package name */
    public final int f375m;

    public SpliceInsertCommand(long j2, boolean z3, boolean z5, boolean z6, boolean z7, long j5, long j6, List list, boolean z8, long j7, int i3, int i5, int i6) {
        this.f366a = j2;
        this.b = z3;
        this.c = z5;
        this.d = z6;
        this.f367e = z7;
        this.f368f = j5;
        this.f369g = j6;
        this.f370h = Collections.unmodifiableList(list);
        this.f371i = z8;
        this.f372j = j7;
        this.f373k = i3;
        this.f374l = i5;
        this.f375m = i6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f366a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f367e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f368f);
        parcel.writeLong(this.f369g);
        List list = this.f370h;
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) list.get(i5);
            parcel.writeInt(bVar.f1902a);
            parcel.writeLong(bVar.b);
            parcel.writeLong(bVar.c);
        }
        parcel.writeByte(this.f371i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f372j);
        parcel.writeInt(this.f373k);
        parcel.writeInt(this.f374l);
        parcel.writeInt(this.f375m);
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.f366a = parcel.readLong();
        this.b = parcel.readByte() == 1;
        this.c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        this.f367e = parcel.readByte() == 1;
        this.f368f = parcel.readLong();
        this.f369g = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(new b(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.f370h = Collections.unmodifiableList(arrayList);
        this.f371i = parcel.readByte() == 1;
        this.f372j = parcel.readLong();
        this.f373k = parcel.readInt();
        this.f374l = parcel.readInt();
        this.f375m = parcel.readInt();
    }
}

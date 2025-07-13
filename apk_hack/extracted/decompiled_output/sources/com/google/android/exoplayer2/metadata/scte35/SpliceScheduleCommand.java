package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import b2.g;
import g1.c;
import g1.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new g(22);

    /* renamed from: a  reason: collision with root package name */
    public final List f376a;

    public SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(new d(parcel));
        }
        this.f376a = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        List list = this.f376a;
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = (d) list.get(i5);
            parcel.writeLong(dVar.f1904a);
            parcel.writeByte(dVar.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(dVar.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(dVar.d ? (byte) 1 : (byte) 0);
            List list2 = dVar.f1906f;
            int size2 = list2.size();
            parcel.writeInt(size2);
            for (int i6 = 0; i6 < size2; i6++) {
                c cVar = (c) list2.get(i6);
                parcel.writeInt(cVar.f1903a);
                parcel.writeLong(cVar.b);
            }
            parcel.writeLong(dVar.f1905e);
            parcel.writeByte(dVar.f1907g ? (byte) 1 : (byte) 0);
            parcel.writeLong(dVar.f1908h);
            parcel.writeInt(dVar.f1909i);
            parcel.writeInt(dVar.f1910j);
            parcel.writeInt(dVar.f1911k);
        }
    }

    public SpliceScheduleCommand(ArrayList arrayList) {
        this.f376a = Collections.unmodifiableList(arrayList);
    }
}

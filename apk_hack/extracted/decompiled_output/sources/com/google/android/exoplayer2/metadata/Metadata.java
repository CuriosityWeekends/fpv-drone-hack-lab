package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Entry[] f330a;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Entry extends Parcelable {
        Format a();

        byte[] b();
    }

    public Metadata(Entry... entryArr) {
        this.f330a = entryArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Metadata.class == obj.getClass()) {
            return Arrays.equals(this.f330a, ((Metadata) obj).f330a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f330a);
    }

    public final String toString() {
        return "entries=" + Arrays.toString(this.f330a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        Entry[] entryArr = this.f330a;
        parcel.writeInt(entryArr.length);
        for (Entry entry : entryArr) {
            parcel.writeParcelable(entry, 0);
        }
    }

    public Metadata(ArrayList arrayList) {
        Entry[] entryArr = new Entry[arrayList.size()];
        this.f330a = entryArr;
        arrayList.toArray(entryArr);
    }

    public Metadata(Parcel parcel) {
        this.f330a = new Entry[parcel.readInt()];
        int i3 = 0;
        while (true) {
            Entry[] entryArr = this.f330a;
            if (i3 >= entryArr.length) {
                return;
            }
            entryArr[i3] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
            i3++;
        }
    }
}

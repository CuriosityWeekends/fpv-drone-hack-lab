package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import b2.g;
import com.google.android.exoplayer2.source.TrackGroupArray;
import g2.w;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class DefaultTrackSelector$Parameters extends TrackSelectionParameters {
    public static final DefaultTrackSelector$Parameters B = new DefaultTrackSelector$Parameters(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, new SparseArray(), new SparseBooleanArray());
    public static final Parcelable.Creator<DefaultTrackSelector$Parameters> CREATOR = new g(0);
    public final SparseBooleanArray A;

    /* renamed from: f  reason: collision with root package name */
    public final int f396f;

    /* renamed from: g  reason: collision with root package name */
    public final int f397g;

    /* renamed from: h  reason: collision with root package name */
    public final int f398h;

    /* renamed from: i  reason: collision with root package name */
    public final int f399i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f400j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f401k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f402l;

    /* renamed from: m  reason: collision with root package name */
    public final int f403m;

    /* renamed from: n  reason: collision with root package name */
    public final int f404n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f405o;

    /* renamed from: p  reason: collision with root package name */
    public final int f406p;
    public final int q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f407r;
    public final boolean s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f408t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f409u;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f410v;
    public final boolean w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f411x;

    /* renamed from: y  reason: collision with root package name */
    public final int f412y;

    /* renamed from: z  reason: collision with root package name */
    public final SparseArray f413z;

    public DefaultTrackSelector$Parameters(int i3, int i5, int i6, int i7, boolean z3, boolean z5, int i8, int i9, boolean z6, int i10, int i11, boolean z7, boolean z8, SparseArray sparseArray, SparseBooleanArray sparseBooleanArray) {
        this.f396f = i3;
        this.f397g = i5;
        this.f398h = i6;
        this.f399i = i7;
        this.f400j = z3;
        this.f401k = false;
        this.f402l = z5;
        this.f403m = i8;
        this.f404n = i9;
        this.f405o = z6;
        this.f406p = i10;
        this.q = i11;
        this.f407r = z7;
        this.s = false;
        this.f408t = false;
        this.f409u = false;
        this.f410v = false;
        this.w = false;
        this.f411x = z8;
        this.f412y = 0;
        this.f413z = sparseArray;
        this.A = sparseBooleanArray;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultTrackSelector$Parameters.class != obj.getClass()) {
            return false;
        }
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = (DefaultTrackSelector$Parameters) obj;
        if (super.equals(obj) && this.f396f == defaultTrackSelector$Parameters.f396f && this.f397g == defaultTrackSelector$Parameters.f397g && this.f398h == defaultTrackSelector$Parameters.f398h && this.f399i == defaultTrackSelector$Parameters.f399i && this.f400j == defaultTrackSelector$Parameters.f400j && this.f401k == defaultTrackSelector$Parameters.f401k && this.f402l == defaultTrackSelector$Parameters.f402l && this.f405o == defaultTrackSelector$Parameters.f405o && this.f403m == defaultTrackSelector$Parameters.f403m && this.f404n == defaultTrackSelector$Parameters.f404n && this.f406p == defaultTrackSelector$Parameters.f406p && this.q == defaultTrackSelector$Parameters.q && this.f407r == defaultTrackSelector$Parameters.f407r && this.s == defaultTrackSelector$Parameters.s && this.f408t == defaultTrackSelector$Parameters.f408t && this.f409u == defaultTrackSelector$Parameters.f409u && this.f410v == defaultTrackSelector$Parameters.f410v && this.w == defaultTrackSelector$Parameters.w && this.f411x == defaultTrackSelector$Parameters.f411x && this.f412y == defaultTrackSelector$Parameters.f412y) {
            SparseBooleanArray sparseBooleanArray = this.A;
            int size = sparseBooleanArray.size();
            SparseBooleanArray sparseBooleanArray2 = defaultTrackSelector$Parameters.A;
            if (sparseBooleanArray2.size() == size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i3)) < 0) {
                            break;
                        }
                        i3++;
                    } else {
                        SparseArray sparseArray = this.f413z;
                        int size2 = sparseArray.size();
                        SparseArray sparseArray2 = defaultTrackSelector$Parameters.f413z;
                        if (sparseArray2.size() == size2) {
                            for (int i5 = 0; i5 < size2; i5++) {
                                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i5));
                                if (indexOfKey >= 0) {
                                    Map map = (Map) sparseArray.valueAt(i5);
                                    Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                    if (map2.size() == map.size()) {
                                        for (Map.Entry entry : map.entrySet()) {
                                            TrackGroupArray trackGroupArray = (TrackGroupArray) entry.getKey();
                                            if (map2.containsKey(trackGroupArray)) {
                                                if (!w.a(entry.getValue(), map2.get(trackGroupArray))) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
    public final int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.f396f) * 31) + this.f397g) * 31) + this.f398h) * 31) + this.f399i) * 31) + (this.f400j ? 1 : 0)) * 31) + (this.f401k ? 1 : 0)) * 31) + (this.f402l ? 1 : 0)) * 31) + (this.f405o ? 1 : 0)) * 31) + this.f403m) * 31) + this.f404n) * 31) + this.f406p) * 31) + this.q) * 31) + (this.f407r ? 1 : 0)) * 31) + (this.s ? 1 : 0)) * 31) + (this.f408t ? 1 : 0)) * 31) + (this.f409u ? 1 : 0)) * 31) + (this.f410v ? 1 : 0)) * 31) + (this.w ? 1 : 0)) * 31) + (this.f411x ? 1 : 0)) * 31) + this.f412y;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f396f);
        parcel.writeInt(this.f397g);
        parcel.writeInt(this.f398h);
        parcel.writeInt(this.f399i);
        parcel.writeInt(this.f400j ? 1 : 0);
        parcel.writeInt(this.f401k ? 1 : 0);
        parcel.writeInt(this.f402l ? 1 : 0);
        parcel.writeInt(this.f403m);
        parcel.writeInt(this.f404n);
        parcel.writeInt(this.f405o ? 1 : 0);
        parcel.writeInt(this.f406p);
        parcel.writeInt(this.q);
        parcel.writeInt(this.f407r ? 1 : 0);
        parcel.writeInt(this.s ? 1 : 0);
        parcel.writeInt(this.f408t ? 1 : 0);
        parcel.writeInt(this.f409u ? 1 : 0);
        parcel.writeInt(this.f410v ? 1 : 0);
        parcel.writeInt(this.w ? 1 : 0);
        parcel.writeInt(this.f411x ? 1 : 0);
        parcel.writeInt(this.f412y);
        SparseArray sparseArray = this.f413z;
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            int keyAt = sparseArray.keyAt(i5);
            Map map = (Map) sparseArray.valueAt(i5);
            int size2 = map.size();
            parcel.writeInt(keyAt);
            parcel.writeInt(size2);
            for (Map.Entry entry : map.entrySet()) {
                parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                parcel.writeParcelable((Parcelable) entry.getValue(), 0);
            }
        }
        parcel.writeSparseBooleanArray(this.A);
    }

    public DefaultTrackSelector$Parameters(Parcel parcel) {
        super(parcel);
        this.f396f = parcel.readInt();
        this.f397g = parcel.readInt();
        this.f398h = parcel.readInt();
        this.f399i = parcel.readInt();
        this.f400j = parcel.readInt() != 0;
        this.f401k = parcel.readInt() != 0;
        this.f402l = parcel.readInt() != 0;
        this.f403m = parcel.readInt();
        this.f404n = parcel.readInt();
        this.f405o = parcel.readInt() != 0;
        this.f406p = parcel.readInt();
        this.q = parcel.readInt();
        this.f407r = parcel.readInt() != 0;
        this.s = parcel.readInt() != 0;
        this.f408t = parcel.readInt() != 0;
        this.f409u = parcel.readInt() != 0;
        this.f410v = parcel.readInt() != 0;
        this.w = parcel.readInt() != 0;
        this.f411x = parcel.readInt() != 0;
        this.f412y = parcel.readInt();
        int readInt = parcel.readInt();
        SparseArray sparseArray = new SparseArray(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            HashMap hashMap = new HashMap(readInt3);
            for (int i5 = 0; i5 < readInt3; i5++) {
                Parcelable readParcelable = parcel.readParcelable(TrackGroupArray.class.getClassLoader());
                readParcelable.getClass();
                hashMap.put((TrackGroupArray) readParcelable, (DefaultTrackSelector$SelectionOverride) parcel.readParcelable(DefaultTrackSelector$SelectionOverride.class.getClassLoader()));
            }
            sparseArray.put(readInt2, hashMap);
        }
        this.f413z = sparseArray;
        this.A = parcel.readSparseBooleanArray();
    }
}

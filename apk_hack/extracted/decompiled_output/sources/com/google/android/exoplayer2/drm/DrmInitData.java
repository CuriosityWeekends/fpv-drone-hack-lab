package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import g2.w;
import j0.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final SchemeData[] f326a;
    public int b;
    public final String c;

    public DrmInitData(String str, ArrayList arrayList) {
        this(str, false, (SchemeData[]) arrayList.toArray(new SchemeData[0]));
    }

    public final DrmInitData c(String str) {
        if (w.a(this.c, str)) {
            return this;
        }
        return new DrmInitData(str, false, this.f326a);
    }

    @Override // java.util.Comparator
    public final int compare(SchemeData schemeData, SchemeData schemeData2) {
        SchemeData schemeData3 = schemeData;
        SchemeData schemeData4 = schemeData2;
        UUID uuid = i.f2256a;
        if (uuid.equals(schemeData3.b)) {
            if (uuid.equals(schemeData4.b)) {
                return 0;
            }
            return 1;
        }
        return schemeData3.b.compareTo(schemeData4.b);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        if (w.a(this.c, drmInitData.c) && Arrays.equals(this.f326a, drmInitData.f326a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        if (this.b == 0) {
            String str = this.c;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            this.b = (hashCode * 31) + Arrays.hashCode(this.f326a);
        }
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.c);
        parcel.writeTypedArray(this.f326a, 0);
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(null, true, schemeDataArr);
    }

    public DrmInitData(String str, boolean z3, SchemeData... schemeDataArr) {
        this.c = str;
        schemeDataArr = z3 ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.f326a = schemeDataArr;
        int length = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public int f327a;
        public final UUID b;
        public final String c;
        public final String d;

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f328e;

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr) {
            uuid.getClass();
            this.b = uuid;
            this.c = str;
            str2.getClass();
            this.d = str2;
            this.f328e = bArr;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (!w.a(this.c, schemeData.c) || !w.a(this.d, schemeData.d) || !w.a(this.b, schemeData.b) || !Arrays.equals(this.f328e, schemeData.f328e)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int hashCode;
            if (this.f327a == 0) {
                int hashCode2 = this.b.hashCode() * 31;
                String str = this.c;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int hashCode3 = this.d.hashCode();
                this.f327a = Arrays.hashCode(this.f328e) + ((hashCode3 + ((hashCode2 + hashCode) * 31)) * 31);
            }
            return this.f327a;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            UUID uuid = this.b;
            parcel.writeLong(uuid.getMostSignificantBits());
            parcel.writeLong(uuid.getLeastSignificantBits());
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeByteArray(this.f328e);
        }

        public SchemeData(Parcel parcel) {
            this.b = new UUID(parcel.readLong(), parcel.readLong());
            this.c = parcel.readString();
            String readString = parcel.readString();
            int i3 = w.f1960a;
            this.d = readString;
            this.f328e = parcel.createByteArray();
        }
    }

    public DrmInitData(Parcel parcel) {
        this.c = parcel.readString();
        Object[] createTypedArray = parcel.createTypedArray(SchemeData.CREATOR);
        int i3 = w.f1960a;
        SchemeData[] schemeDataArr = (SchemeData[]) createTypedArray;
        this.f326a = schemeDataArr;
        int length = schemeDataArr.length;
    }
}

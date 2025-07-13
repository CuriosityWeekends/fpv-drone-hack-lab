package com.google.android.exoplayer2.source.hls;

import a1.i;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import j1.n0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new n0(1);

    /* renamed from: a  reason: collision with root package name */
    public final String f392a;
    public final String b;
    public final List c;

    public HlsTrackMetadataEntry(String str, String str2, List list) {
        this.f392a = str;
        this.b = str2;
        this.c = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public final /* synthetic */ Format a() {
        return null;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public final /* synthetic */ byte[] b() {
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HlsTrackMetadataEntry.class != obj.getClass()) {
            return false;
        }
        HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
        if (TextUtils.equals(this.f392a, hlsTrackMetadataEntry.f392a) && TextUtils.equals(this.b, hlsTrackMetadataEntry.b) && this.c.equals(hlsTrackMetadataEntry.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int i5 = 0;
        String str = this.f392a;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = i3 * 31;
        String str2 = this.b;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return this.c.hashCode() + ((i6 + i5) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("HlsTrackMetadataEntry");
        String str2 = this.f392a;
        if (str2 != null) {
            str = i.k(i.p(" [", str2, ", "), this.b, "]");
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f392a);
        parcel.writeString(this.b);
        List list = this.c;
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeParcelable((Parcelable) list.get(i5), 0);
        }
    }

    public HlsTrackMetadataEntry(Parcel parcel) {
        this.f392a = parcel.readString();
        this.b = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.c = Collections.unmodifiableList(arrayList);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new Object();

        /* renamed from: a  reason: collision with root package name */
        public final long f393a;
        public final String b;
        public final String c;
        public final String d;

        /* renamed from: e  reason: collision with root package name */
        public final String f394e;

        public VariantInfo(long j2, String str, String str2, String str3, String str4) {
            this.f393a = j2;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.f394e = str4;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VariantInfo.class != obj.getClass()) {
                return false;
            }
            VariantInfo variantInfo = (VariantInfo) obj;
            if (this.f393a == variantInfo.f393a && TextUtils.equals(this.b, variantInfo.b) && TextUtils.equals(this.c, variantInfo.c) && TextUtils.equals(this.d, variantInfo.d) && TextUtils.equals(this.f394e, variantInfo.f394e)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i3;
            int i5;
            int i6;
            long j2 = this.f393a;
            int i7 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            int i8 = 0;
            String str = this.b;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i9 = (i7 + i3) * 31;
            String str2 = this.c;
            if (str2 != null) {
                i5 = str2.hashCode();
            } else {
                i5 = 0;
            }
            int i10 = (i9 + i5) * 31;
            String str3 = this.d;
            if (str3 != null) {
                i6 = str3.hashCode();
            } else {
                i6 = 0;
            }
            int i11 = (i10 + i6) * 31;
            String str4 = this.f394e;
            if (str4 != null) {
                i8 = str4.hashCode();
            }
            return i11 + i8;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f393a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.f394e);
        }

        public VariantInfo(Parcel parcel) {
            this.f393a = parcel.readLong();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.f394e = parcel.readString();
        }
    }
}

package com.lg.picturesubmitt.model;

import a1.i;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PhotoInfo implements Parcelable {
    public static final Parcelable.Creator<PhotoInfo> CREATOR = new Parcelable.Creator<PhotoInfo>() { // from class: com.lg.picturesubmitt.model.PhotoInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoInfo createFromParcel(Parcel parcel) {
            return new PhotoInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoInfo[] newArray(int i3) {
            return new PhotoInfo[i3];
        }
    };
    public String name;
    public String path;
    public long value;

    public PhotoInfo(String str, String str2, long j2) {
        this.path = str;
        this.name = str2;
        this.value = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this.path.equalsIgnoreCase(((PhotoInfo) obj).path);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PhotoInfo{name='");
        sb.append(this.name);
        sb.append("', path='");
        return i.k(sb, this.path, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.name);
        parcel.writeString(this.path);
    }

    public PhotoInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.path = parcel.readString();
    }
}

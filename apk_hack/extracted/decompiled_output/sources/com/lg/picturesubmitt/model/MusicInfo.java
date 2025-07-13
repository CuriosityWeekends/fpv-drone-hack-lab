package com.lg.picturesubmitt.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MusicInfo implements Parcelable {
    public static final Parcelable.Creator<MusicInfo> CREATOR = new Parcelable.Creator<MusicInfo>() { // from class: com.lg.picturesubmitt.model.MusicInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicInfo createFromParcel(Parcel parcel) {
            return new MusicInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicInfo[] newArray(int i3) {
            return new MusicInfo[i3];
        }
    };
    public String name;
    public String path;
    public int value;

    public MusicInfo(String str, String str2, int i3) {
        this.path = str;
        this.name = str2;
        this.value = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this.path.equalsIgnoreCase(((MusicInfo) obj).path);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "MusicInfo{name='" + this.name + "', path='" + this.path + "', value=" + this.value + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.name);
        parcel.writeString(this.path);
        parcel.writeInt(this.value);
    }

    public MusicInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.path = parcel.readString();
        this.value = parcel.readInt();
    }
}

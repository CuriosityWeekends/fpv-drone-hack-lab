package pl.droidsonroids.gif;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GifAnimationMetaData implements Serializable, Parcelable {
    public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = new j(1);
    private static final long serialVersionUID = 5692363926580237325L;

    /* renamed from: a  reason: collision with root package name */
    public final int f3268a;
    public final int b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3269e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3270f;

    /* renamed from: g  reason: collision with root package name */
    public final long f3271g;

    public GifAnimationMetaData(Parcel parcel) {
        this.f3268a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.f3269e = parcel.readInt();
        this.f3271g = parcel.readLong();
        this.f3270f = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String num;
        int i3 = this.f3268a;
        if (i3 == 0) {
            num = "Infinity";
        } else {
            num = Integer.toString(i3);
        }
        Locale locale = Locale.ENGLISH;
        StringBuilder sb = new StringBuilder("GIF: size: ");
        sb.append(this.d);
        sb.append("x");
        sb.append(this.c);
        sb.append(", frames: ");
        int i5 = this.f3269e;
        sb.append(i5);
        sb.append(", loops: ");
        sb.append(num);
        sb.append(", duration: ");
        int i6 = this.b;
        sb.append(i6);
        String sb2 = sb.toString();
        if (i5 > 1 && i6 > 0) {
            return "Animated ".concat(sb2);
        }
        return sb2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f3268a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.f3269e);
        parcel.writeLong(this.f3271g);
        parcel.writeLong(this.f3270f);
    }
}

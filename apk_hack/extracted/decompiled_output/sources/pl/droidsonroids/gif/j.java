package pl.droidsonroids.gif;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3305a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f3305a) {
            case 0:
                return new GifViewSavedState(parcel);
            default:
                return new GifAnimationMetaData(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f3305a) {
            case 0:
                return new GifViewSavedState[i3];
            default:
                return new GifAnimationMetaData[i3];
        }
    }
}

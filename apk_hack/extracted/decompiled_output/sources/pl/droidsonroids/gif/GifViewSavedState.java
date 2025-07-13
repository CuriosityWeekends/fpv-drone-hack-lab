package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new j(0);

    /* renamed from: a  reason: collision with root package name */
    public final long[][] f3281a;

    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f3281a = new long[drawableArr.length];
        for (int i3 = 0; i3 < drawableArr.length; i3++) {
            Drawable drawable = drawableArr[i3];
            if (drawable instanceof c) {
                this.f3281a[i3] = ((c) drawable).f3285g.j();
            } else {
                this.f3281a[i3] = null;
            }
        }
    }

    public final void c(Drawable drawable, int i3) {
        long[] jArr = this.f3281a[i3];
        if (jArr != null && (drawable instanceof c)) {
            c cVar = (c) drawable;
            cVar.a(cVar.f3285g.s(jArr, cVar.f3284f));
        }
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        long[][] jArr = this.f3281a;
        parcel.writeInt(jArr.length);
        for (long[] jArr2 : jArr) {
            parcel.writeLongArray(jArr2);
        }
    }

    public GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f3281a = new long[parcel.readInt()];
        int i3 = 0;
        while (true) {
            long[][] jArr = this.f3281a;
            if (i3 >= jArr.length) {
                return;
            }
            jArr[i3] = parcel.createLongArray();
            i3++;
        }
    }

    public GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f3281a = r2;
        long[][] jArr2 = {jArr};
    }
}

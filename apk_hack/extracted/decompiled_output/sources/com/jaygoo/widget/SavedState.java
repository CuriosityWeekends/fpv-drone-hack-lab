package com.jaygoo.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import j1.n0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new n0(2);

    /* renamed from: a  reason: collision with root package name */
    public float f533a;
    public float b;
    public float c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public float f534e;

    /* renamed from: f  reason: collision with root package name */
    public float f535f;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f533a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeFloat(this.f534e);
        parcel.writeFloat(this.f535f);
    }
}

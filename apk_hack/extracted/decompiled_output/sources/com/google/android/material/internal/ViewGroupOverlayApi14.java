package com.google.android.material.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    public ViewGroupOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    public static ViewGroupOverlayApi14 createFrom(ViewGroup viewGroup) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.createFrom(viewGroup);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void add(@NonNull View view) {
        this.overlayViewGroup.add(view);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void remove(@NonNull View view) {
        this.overlayViewGroup.remove(view);
    }
}

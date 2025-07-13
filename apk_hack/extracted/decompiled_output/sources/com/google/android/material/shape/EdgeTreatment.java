package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f4, float f5, @NonNull ShapePath shapePath) {
        getEdgePath(f4, f4 / 2.0f, f5, shapePath);
    }

    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f4, 0.0f);
    }
}

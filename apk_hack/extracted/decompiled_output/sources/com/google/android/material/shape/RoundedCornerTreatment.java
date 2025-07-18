package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f4, float f5, float f6) {
        shapePath.reset(0.0f, f6 * f5, 180.0f, 180.0f - f4);
        float f7 = f6 * 2.0f * f5;
        shapePath.addArc(0.0f, 0.0f, f7, f7, 180.0f, f4);
    }

    @Deprecated
    public RoundedCornerTreatment(float f4) {
        this.radius = f4;
    }
}

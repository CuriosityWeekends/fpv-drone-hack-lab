package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f4, boolean z3) {
        this.size = f4;
        this.inside = z3;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        float f7;
        shapePath.lineTo(f5 - (this.size * f6), 0.0f);
        if (this.inside) {
            f7 = this.size;
        } else {
            f7 = -this.size;
        }
        shapePath.lineTo(f5, f7 * f6);
        shapePath.lineTo((this.size * f6) + f5, 0.0f);
        shapePath.lineTo(f4, 0.0f);
    }
}

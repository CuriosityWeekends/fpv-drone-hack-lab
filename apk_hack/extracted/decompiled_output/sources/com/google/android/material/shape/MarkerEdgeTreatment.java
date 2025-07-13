package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float f4) {
        this.radius = f4 - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        float sqrt = (float) ((Math.sqrt(2.0d) * this.radius) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(sqrt, 2.0d));
        shapePath.reset(f5 - sqrt, ((float) (-((Math.sqrt(2.0d) * this.radius) - this.radius))) + sqrt2);
        shapePath.lineTo(f5, (float) (-((Math.sqrt(2.0d) * this.radius) - this.radius)));
        shapePath.lineTo(f5 + sqrt, ((float) (-((Math.sqrt(2.0d) * this.radius) - this.radius))) + sqrt2);
    }
}

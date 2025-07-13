package com.google.android.material.bottomappbar;

import a1.i;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f4, float f5, float f6) {
        this.fabMargin = f4;
        this.roundedCornerRadius = f5;
        setCradleVerticalOffset(f6);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        boolean z3;
        float f7;
        float f8;
        float f9 = this.fabDiameter;
        if (f9 == 0.0f) {
            shapePath.lineTo(f4, 0.0f);
            return;
        }
        float f10 = ((this.fabMargin * 2.0f) + f9) / 2.0f;
        float f11 = f6 * this.roundedCornerRadius;
        float f12 = f5 + this.horizontalOffset;
        float b = i.b(1.0f, f6, f10, this.cradleVerticalOffset * f6);
        if (b / f10 >= 1.0f) {
            shapePath.lineTo(f4, 0.0f);
            return;
        }
        float f13 = this.fabCornerSize;
        float f14 = f13 * f6;
        if (f13 != -1.0f && Math.abs((f13 * 2.0f) - f9) >= 0.1f) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            f8 = ROUNDED_CORNER_FAB_OFFSET;
            f7 = 0.0f;
        } else {
            f7 = b;
            f8 = 0.0f;
        }
        float f15 = f10 + f11;
        float f16 = f7 + f11;
        float sqrt = (float) Math.sqrt((f15 * f15) - (f16 * f16));
        float f17 = f12 - sqrt;
        float f18 = f12 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f16));
        float f19 = (90.0f - degrees) + f8;
        shapePath.lineTo(f17, 0.0f);
        float f20 = f11 * 2.0f;
        shapePath.addArc(f17 - f11, 0.0f, f17 + f11, f20, 270.0f, degrees);
        if (z3) {
            shapePath.addArc(f12 - f10, (-f10) - f7, f12 + f10, f10 - f7, 180.0f - f19, (f19 * 2.0f) - 180.0f);
        } else {
            float f21 = this.fabMargin;
            float f22 = f14 * 2.0f;
            float f23 = f12 - f10;
            shapePath.addArc(f23, -(f14 + f21), f23 + f21 + f22, f21 + f14, 180.0f - f19, ((f19 * 2.0f) - 180.0f) / 2.0f);
            float f24 = f12 + f10;
            float f25 = this.fabMargin;
            shapePath.lineTo(f24 - ((f25 / 2.0f) + f14), f25 + f14);
            float f26 = this.fabMargin;
            shapePath.addArc(f24 - (f22 + f26), -(f14 + f26), f24, f26 + f14, 90.0f, f19 - 90.0f);
        }
        shapePath.addArc(f18 - f11, 0.0f, f18 + f11, f20, 270.0f - degrees, degrees);
        shapePath.lineTo(f4, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f4) {
        if (f4 >= 0.0f) {
            this.cradleVerticalOffset = f4;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCornerSize(float f4) {
        this.fabCornerSize = f4;
    }

    public void setFabCradleMargin(float f4) {
        this.fabMargin = f4;
    }

    public void setFabCradleRoundedCornerRadius(float f4) {
        this.roundedCornerRadius = f4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f4) {
        this.fabDiameter = f4;
    }

    public void setHorizontalOffset(float f4) {
        this.horizontalOffset = f4;
    }
}

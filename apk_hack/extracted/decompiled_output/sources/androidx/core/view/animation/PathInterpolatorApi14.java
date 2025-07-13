package androidx.core.view.animation;

import a1.i;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i3 = (int) (length / 0.002f);
        int i5 = i3 + 1;
        this.mX = new float[i5];
        this.mY = new float[i5];
        float[] fArr = new float[2];
        for (int i6 = 0; i6 < i5; i6++) {
            pathMeasure.getPosTan((i6 * length) / i3, fArr, null);
            this.mX[i6] = fArr[0];
            this.mY[i6] = fArr[1];
        }
    }

    private static Path createCubic(float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f4, f5, f6, f7, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f4, f5, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f4) {
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i3 = 0;
        while (length - i3 > 1) {
            int i5 = (i3 + length) / 2;
            if (f4 < this.mX[i5]) {
                length = i5;
            } else {
                i3 = i5;
            }
        }
        float[] fArr = this.mX;
        float f5 = fArr[length];
        float f6 = fArr[i3];
        float f7 = f5 - f6;
        if (f7 == 0.0f) {
            return this.mY[i3];
        }
        float[] fArr2 = this.mY;
        float f8 = fArr2[i3];
        return i.b(fArr2[length], f8, (f4 - f6) / f7, f8);
    }

    public PathInterpolatorApi14(float f4, float f5) {
        this(createQuad(f4, f5));
    }

    public PathInterpolatorApi14(float f4, float f5, float f6, float f7) {
        this(createCubic(f4, f5, f6, f7));
    }
}

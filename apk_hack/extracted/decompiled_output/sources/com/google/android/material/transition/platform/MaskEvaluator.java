package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.platform.MaterialContainerTransform;
@RequiresApi(21)
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class MaskEvaluator {
    private ShapeAppearanceModel currentShapeAppearanceModel;
    private final Path path = new Path();
    private final Path startPath = new Path();
    private final Path endPath = new Path();
    private final ShapeAppearancePathProvider pathProvider = ShapeAppearancePathProvider.getInstance();

    public void clip(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.path);
            return;
        }
        canvas.clipPath(this.startPath);
        canvas.clipPath(this.endPath, Region.Op.UNION);
    }

    public void evaluate(float f4, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel lerp = TransitionUtils.lerp(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f4);
        this.currentShapeAppearanceModel = lerp;
        this.pathProvider.calculatePath(lerp, 1.0f, rectF2, this.startPath);
        this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1.0f, rectF3, this.endPath);
        if (Build.VERSION.SDK_INT >= 23) {
            this.path.op(this.startPath, this.endPath, Path.Op.UNION);
        }
    }

    public ShapeAppearanceModel getCurrentShapeAppearanceModel() {
        return this.currentShapeAppearanceModel;
    }

    public Path getPath() {
        return this.path;
    }
}

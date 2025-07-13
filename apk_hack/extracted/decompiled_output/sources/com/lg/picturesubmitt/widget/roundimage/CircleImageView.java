package com.lg.picturesubmitt.widget.roundimage;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class CircleImageView extends AbsRoundImageView {
    public CircleImageView(Context context) {
        this(context, null, 0);
    }

    @Override // com.lg.picturesubmitt.widget.roundimage.AbsRoundImageView
    public final void b() {
        this.c.reset();
        int width = getWidth();
        int height = getHeight();
        float min = Math.min(width, height) * 0.5f;
        this.c.addCircle(width * 0.5f, height * 0.5f, min - (this.d * 0.5f), Path.Direction.CW);
    }

    @Override // com.lg.picturesubmitt.widget.roundimage.AbsRoundImageView
    public final void c() {
        this.b.reset();
        int width = getWidth();
        int height = getHeight();
        this.b.addCircle(width * 0.5f, height * 0.5f, Math.min(width, height) * 0.5f, Path.Direction.CW);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i3, int i5) {
        super.onMeasure(i3, i5);
        int max = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(max, max);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

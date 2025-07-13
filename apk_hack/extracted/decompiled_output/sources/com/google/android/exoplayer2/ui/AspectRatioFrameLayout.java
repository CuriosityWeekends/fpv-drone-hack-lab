package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b3.b;
import c2.a;
import c2.n;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    public static final /* synthetic */ int d = 0;

    /* renamed from: a  reason: collision with root package name */
    public final b f417a;
    public float b;
    public int c;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public int getResizeMode() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i5) {
        float f4;
        float f5;
        super.onMeasure(i3, i5);
        if (this.b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f6 = measuredWidth;
        float f7 = measuredHeight;
        float f8 = (this.b / (f6 / f7)) - 1.0f;
        float abs = Math.abs(f8);
        b bVar = this.f417a;
        if (abs <= 0.01f) {
            if (!bVar.b) {
                bVar.b = true;
                ((AspectRatioFrameLayout) bVar.c).post(bVar);
                return;
            }
            return;
        }
        int i6 = this.c;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 4) {
                        if (f8 > 0.0f) {
                            f4 = this.b;
                        } else {
                            f5 = this.b;
                        }
                    }
                } else {
                    f4 = this.b;
                }
                measuredWidth = (int) (f7 * f4);
            } else {
                f5 = this.b;
            }
            measuredHeight = (int) (f6 / f5);
        } else if (f8 > 0.0f) {
            f5 = this.b;
            measuredHeight = (int) (f6 / f5);
        } else {
            f4 = this.b;
            measuredWidth = (int) (f7 * f4);
        }
        if (!bVar.b) {
            bVar.b = true;
            ((AspectRatioFrameLayout) bVar.c).post(bVar);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY));
    }

    public void setAspectRatio(float f4) {
        if (this.b != f4) {
            this.b = f4;
            requestLayout();
        }
    }

    public void setResizeMode(int i3) {
        if (this.c != i3) {
            this.c = i3;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, n.AspectRatioFrameLayout, 0, 0);
            try {
                this.c = obtainStyledAttributes.getInt(n.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f417a = new b(this);
    }

    public void setAspectRatioListener(@Nullable a aVar) {
    }
}

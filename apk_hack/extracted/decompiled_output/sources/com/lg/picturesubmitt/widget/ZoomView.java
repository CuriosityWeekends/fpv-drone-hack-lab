package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ZoomView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public float f1001a;
    public float b;
    public int c;
    public boolean d;

    public ZoomView(Context context) {
        this(context, null);
    }

    public static float a(MotionEvent motionEvent) {
        float x3 = motionEvent.getX(0) - motionEvent.getX(1);
        float y3 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((y3 * y3) + (x3 * x3));
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 6) goto L11;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            if (r0 == 0) goto L80
            r2 = 0
            if (r0 == r1) goto L7d
            r3 = 2
            if (r0 == r3) goto L3b
            r4 = 5
            if (r0 == r4) goto L17
            r1 = 6
            if (r0 == r1) goto L7d
            goto L88
        L17:
            r5.c = r3
            float r0 = a(r6)
            r5.b = r0
            float r0 = r6.getX(r2)
            float r3 = r6.getX(r1)
            float r0 = r0 - r3
            double r3 = (double) r0
            float r0 = r6.getY(r2)
            float r1 = r6.getY(r1)
            float r0 = r0 - r1
            double r0 = (double) r0
            double r0 = java.lang.Math.atan2(r0, r3)
            java.lang.Math.toDegrees(r0)
            goto L88
        L3b:
            int r0 = r5.c
            if (r0 != r1) goto L40
            goto L88
        L40:
            if (r0 != r3) goto L88
            boolean r0 = r5.d
            if (r0 == 0) goto L88
            float r0 = r5.f1001a
            float r1 = a(r6)
            float r1 = r1 * r0
            float r0 = r5.b
            float r1 = r1 / r0
            r5.f1001a = r1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "缩放scale="
            r0.<init>(r1)
            float r1 = r5.f1001a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ZoomView"
            android.util.Log.d(r1, r0)
            float r0 = r5.f1001a
            r1 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L72
            r5.f1001a = r1
        L72:
            float r0 = r5.f1001a
            r5.setScaleX(r0)
            float r0 = r5.f1001a
            r5.setScaleY(r0)
            goto L88
        L7d:
            r5.c = r2
            goto L88
        L80:
            r5.c = r1
            r6.getRawX()
            r6.getRawY()
        L88:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lg.picturesubmitt.widget.ZoomView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCanScale(boolean z3) {
        this.d = z3;
        if (!z3) {
            setScaleX(1.0f);
            setScaleY(1.0f);
        }
    }

    public void setScaleValue(float f4) {
        if (f4 >= 1.0f || f4 <= 5.0f) {
            setScaleX(f4);
            setScaleY(f4);
        }
    }

    public ZoomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1001a = 1.0f;
        this.d = false;
        setClickable(true);
    }
}

package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (androidx.core.view.ViewCompat.getLayoutDirection(r6) == 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (androidx.core.view.ViewCompat.getLayoutDirection(r6) == 1) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        r0 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        r0 = 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int distance(android.view.View r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        /*
            r5 = this;
            int r0 = r5.mSide
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r2 = 1
            r3 = 3
            r4 = 5
            if (r0 != r1) goto L14
            int r6 = androidx.core.view.ViewCompat.getLayoutDirection(r6)
            if (r6 != r2) goto L12
        L10:
            r0 = 5
            goto L20
        L12:
            r0 = 3
            goto L20
        L14:
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r1) goto L20
            int r6 = androidx.core.view.ViewCompat.getLayoutDirection(r6)
            if (r6 != r2) goto L10
            goto L12
        L20:
            if (r0 == r3) goto L46
            if (r0 == r4) goto L3e
            r6 = 48
            if (r0 == r6) goto L36
            r6 = 80
            if (r0 == r6) goto L2e
            r6 = 0
            goto L4d
        L2e:
            int r8 = r8 - r12
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r6 = r6 + r8
            goto L4d
        L36:
            int r14 = r14 - r8
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r6 = r6 + r14
            goto L4d
        L3e:
            int r7 = r7 - r11
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r6 = r6 + r7
            goto L4d
        L46:
            int r13 = r13 - r7
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r6 = r6 + r13
        L4d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.SidePropagation.distance(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i3 = this.mSide;
        if (i3 != 3 && i3 != 5 && i3 != 8388611 && i3 != 8388613) {
            return viewGroup.getHeight();
        }
        return viewGroup.getWidth();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i3;
        int i5;
        int i6;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0L;
        }
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 != null && getViewVisibility(transitionValues3) != 0) {
            transitionValues3 = transitionValues2;
            i3 = 1;
        } else {
            i3 = -1;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = Math.round(viewGroup.getTranslationY()) + iArr[1];
        int width = viewGroup.getWidth() + round;
        int height = viewGroup.getHeight() + round2;
        if (epicenter != null) {
            i5 = epicenter.centerX();
            i6 = epicenter.centerY();
        } else {
            i5 = (round + width) / 2;
            i6 = (round2 + height) / 2;
        }
        float distance = distance(viewGroup, viewX, viewY, i5, i6, round, round2, width, height) / getMaxDistance(viewGroup);
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round((((float) (duration * i3)) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f4) {
        if (f4 != 0.0f) {
            this.mPropagationSpeed = f4;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public void setSide(int i3) {
        this.mSide = i3;
    }
}

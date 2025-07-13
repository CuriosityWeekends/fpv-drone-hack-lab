package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Chain {
    private static final boolean DEBUG = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i3) {
        int i5;
        ChainHead[] chainHeadArr;
        int i6;
        if (i3 == 0) {
            i5 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i6 = 0;
        } else {
            i5 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i6 = 2;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            ChainHead chainHead = chainHeadArr[i7];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i3, i6, chainHead);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r7 == 2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
        if (r7 == 2) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0249 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0397 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04bb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x04f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x038f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.solver.LinearSystem r38, int r39, int r40, androidx.constraintlayout.solver.widgets.ChainHead r41) {
        /*
            Method dump skipped, instructions count: 1300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}

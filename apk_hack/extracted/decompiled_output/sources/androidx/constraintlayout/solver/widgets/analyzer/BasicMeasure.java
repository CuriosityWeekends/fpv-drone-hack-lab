package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();
    private Measure mMeasure = new Measure();

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public enum MeasureType {
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean z3) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = z3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (measure.verticalBehavior == dimensionBehaviour2) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 && constraintWidget.mDimensionRatio > 0.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z6 && constraintWidget.mDimensionRatio > 0.0f) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z8 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.useCurrentDimensions = false;
        return measure2.measuredNeedsSolverPass;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer) {
        int size = constraintWidgetContainer.mChildren.size();
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i3);
            if (!(constraintWidget instanceof Guideline) && (!constraintWidget.horizontalRun.dimension.resolved || !constraintWidget.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    measure(measurer, constraintWidget, false);
                    Metrics metrics = constraintWidgetContainer.mMetrics;
                    if (metrics != null) {
                        metrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String str, int i3, int i5) {
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i3);
        constraintWidgetContainer.setHeight(i5);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        boolean z3;
        int i13;
        int i14;
        ConstraintWidgetContainer constraintWidgetContainer2;
        boolean z5;
        boolean z6;
        BasicMeasure basicMeasure;
        ConstraintWidgetContainer constraintWidgetContainer3;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z7;
        int i20;
        Metrics metrics;
        BasicMeasure basicMeasure2 = this;
        ConstraintWidgetContainer constraintWidgetContainer4 = constraintWidgetContainer;
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        int size = constraintWidgetContainer4.mChildren.size();
        int width = constraintWidgetContainer.getWidth();
        int height = constraintWidgetContainer.getHeight();
        boolean enabled = Optimizer.enabled(i3, 128);
        boolean z8 = enabled || Optimizer.enabled(i3, 64);
        if (z8) {
            for (int i21 = 0; i21 < size; i21++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer4.mChildren.get(i21);
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z9 = (horizontalDimensionBehaviour == dimensionBehaviour) && (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((constraintWidget.isInHorizontalChain() && z9) || ((constraintWidget.isInVerticalChain() && z9) || (constraintWidget instanceof VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                    z8 = false;
                    break;
                }
            }
        }
        if (z8 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        if (z8 && ((i7 == 1073741824 && i9 == 1073741824) || enabled)) {
            int min = Math.min(constraintWidgetContainer.getMaxWidth(), i8);
            int min2 = Math.min(constraintWidgetContainer.getMaxHeight(), i10);
            if (i7 == 1073741824 && constraintWidgetContainer.getWidth() != min) {
                constraintWidgetContainer4.setWidth(min);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i9 == 1073741824 && constraintWidgetContainer.getHeight() != min2) {
                constraintWidgetContainer4.setHeight(min2);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i7 == 1073741824 && i9 == 1073741824) {
                z3 = constraintWidgetContainer4.directMeasure(enabled);
                i13 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer4.directMeasureSetup(enabled);
                if (i7 == 1073741824) {
                    z7 = directMeasureSetup & constraintWidgetContainer4.directMeasureWithOrientation(enabled, 0);
                    i20 = 1;
                } else {
                    z7 = directMeasureSetup;
                    i20 = 0;
                }
                if (i9 == 1073741824) {
                    boolean directMeasureWithOrientation = constraintWidgetContainer4.directMeasureWithOrientation(enabled, 1) & z7;
                    i13 = i20 + 1;
                    z3 = directMeasureWithOrientation;
                } else {
                    i13 = i20;
                    z3 = z7;
                }
            }
            if (z3) {
                constraintWidgetContainer4.updateFromRuns(i7 == 1073741824, i9 == 1073741824);
            }
        } else {
            z3 = false;
            i13 = 0;
        }
        if (z3 && i13 == 2) {
            return 0L;
        }
        if (size > 0) {
            measureChildren(constraintWidgetContainer);
        }
        int optimizationLevel = constraintWidgetContainer.getOptimizationLevel();
        int size2 = basicMeasure2.mVariableDimensionsWidgets.size();
        if (size > 0) {
            basicMeasure2.solveLinearSystem(constraintWidgetContainer4, "First pass", width, height);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z10 = horizontalDimensionBehaviour2 == dimensionBehaviour2;
            boolean z11 = constraintWidgetContainer.getVerticalDimensionBehaviour() == dimensionBehaviour2;
            int max = Math.max(constraintWidgetContainer.getWidth(), basicMeasure2.constraintWidgetContainer.getMinWidth());
            int max2 = Math.max(constraintWidgetContainer.getHeight(), basicMeasure2.constraintWidgetContainer.getMinHeight());
            int i22 = 0;
            boolean z12 = false;
            while (i22 < size2) {
                ConstraintWidget constraintWidget2 = basicMeasure2.mVariableDimensionsWidgets.get(i22);
                if (constraintWidget2 instanceof VirtualLayout) {
                    int width2 = constraintWidget2.getWidth();
                    int height2 = constraintWidget2.getHeight();
                    i17 = optimizationLevel;
                    boolean measure = z12 | basicMeasure2.measure(measurer, constraintWidget2, true);
                    Metrics metrics2 = constraintWidgetContainer4.mMetrics;
                    i18 = width;
                    i19 = height;
                    if (metrics2 != null) {
                        metrics2.measuredMatchWidgets++;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z10 && constraintWidget2.getRight() > max) {
                            max = Math.max(max, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + constraintWidget2.getRight());
                        }
                        measure = true;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z11 && constraintWidget2.getBottom() > max2) {
                            max2 = Math.max(max2, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + constraintWidget2.getBottom());
                        }
                        measure = true;
                    }
                    z12 = measure | ((VirtualLayout) constraintWidget2).needSolverPass();
                } else {
                    i17 = optimizationLevel;
                    i18 = width;
                    i19 = height;
                }
                i22++;
                optimizationLevel = i17;
                width = i18;
                height = i19;
            }
            i14 = optimizationLevel;
            int i23 = width;
            int i24 = height;
            int i25 = 0;
            for (int i26 = 2; i25 < i26; i26 = 2) {
                int i27 = 0;
                while (i27 < size2) {
                    ConstraintWidget constraintWidget3 = basicMeasure2.mVariableDimensionsWidgets.get(i27);
                    if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.getVisibility() != 8 && ((!constraintWidget3.horizontalRun.dimension.resolved || !constraintWidget3.verticalRun.dimension.resolved) && !(constraintWidget3 instanceof VirtualLayout))) {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        z12 |= basicMeasure2.measure(measurer, constraintWidget3, true);
                        Metrics metrics3 = constraintWidgetContainer4.mMetrics;
                        if (metrics3 != null) {
                            metrics3.measuredMatchWidgets++;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z10 && constraintWidget3.getRight() > max) {
                                max = Math.max(max, constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + constraintWidget3.getRight());
                            }
                            z12 = true;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z11 && constraintWidget3.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + constraintWidget3.getBottom());
                            }
                            z12 = true;
                        }
                        if (constraintWidget3.hasBaseline() && baselineDistance != constraintWidget3.getBaselineDistance()) {
                            z12 = true;
                        }
                    }
                    i27++;
                    basicMeasure2 = this;
                    constraintWidgetContainer4 = constraintWidgetContainer;
                }
                if (z12) {
                    basicMeasure = this;
                    constraintWidgetContainer3 = constraintWidgetContainer;
                    i15 = i23;
                    i16 = i24;
                    basicMeasure.solveLinearSystem(constraintWidgetContainer3, "intermediate pass", i15, i16);
                    z12 = false;
                } else {
                    basicMeasure = this;
                    constraintWidgetContainer3 = constraintWidgetContainer;
                    i15 = i23;
                    i16 = i24;
                }
                i25++;
                basicMeasure2 = basicMeasure;
                constraintWidgetContainer4 = constraintWidgetContainer3;
                i23 = i15;
                i24 = i16;
            }
            constraintWidgetContainer2 = constraintWidgetContainer4;
            int i28 = i23;
            int i29 = i24;
            BasicMeasure basicMeasure3 = basicMeasure2;
            if (z12) {
                basicMeasure3.solveLinearSystem(constraintWidgetContainer2, "2nd pass", i28, i29);
                if (constraintWidgetContainer.getWidth() < max) {
                    constraintWidgetContainer2.setWidth(max);
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (constraintWidgetContainer.getHeight() < max2) {
                    constraintWidgetContainer2.setHeight(max2);
                    z6 = true;
                } else {
                    z6 = z5;
                }
                if (z6) {
                    basicMeasure3.solveLinearSystem(constraintWidgetContainer2, "3rd pass", i28, i29);
                }
            }
        } else {
            i14 = optimizationLevel;
            constraintWidgetContainer2 = constraintWidgetContainer4;
        }
        constraintWidgetContainer2.setOptimizationLevel(i14);
        return 0L;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i3);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour != dimensionBehaviour) {
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour2 != dimensionBehaviour2 && constraintWidget.getVerticalDimensionBehaviour() != dimensionBehaviour && constraintWidget.getVerticalDimensionBehaviour() != dimensionBehaviour2) {
                }
            }
            this.mVariableDimensionsWidgets.add(constraintWidget);
        }
        constraintWidgetContainer.invalidateGraph();
    }
}

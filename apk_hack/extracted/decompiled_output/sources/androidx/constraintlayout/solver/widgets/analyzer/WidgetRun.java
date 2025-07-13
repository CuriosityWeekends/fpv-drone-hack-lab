package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class WidgetRun implements Dependency {
    protected ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public int matchConstraintsType;
    RunGroup runGroup;
    ConstraintWidget widget;
    DimensionDependency dimension = new DimensionDependency(this);
    public int orientation = 0;
    boolean resolved = false;
    public DependencyNode start = new DependencyNode(this);
    public DependencyNode end = new DependencyNode(this);
    protected RunType mRunType = RunType.NONE;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    private void resolveDimension(int i3, int i5) {
        WidgetRun widgetRun;
        float f4;
        int i6;
        int i7 = this.matchConstraintsType;
        if (i7 != 0) {
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 == 3) {
                        ConstraintWidget constraintWidget = this.widget;
                        WidgetRun widgetRun2 = constraintWidget.horizontalRun;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun2.dimensionBehavior;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun2.matchConstraintsType == 3) {
                            VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                            if (verticalWidgetRun.dimensionBehavior == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                                return;
                            }
                        }
                        if (i3 == 0) {
                            widgetRun2 = constraintWidget.verticalRun;
                        }
                        if (widgetRun2.dimension.resolved) {
                            float dimensionRatio = constraintWidget.getDimensionRatio();
                            if (i3 == 1) {
                                i6 = (int) ((widgetRun2.dimension.value / dimensionRatio) + 0.5f);
                            } else {
                                i6 = (int) ((dimensionRatio * widgetRun2.dimension.value) + 0.5f);
                            }
                            this.dimension.resolve(i6);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintWidget parent = this.widget.getParent();
                if (parent != null) {
                    if (i3 == 0) {
                        widgetRun = parent.horizontalRun;
                    } else {
                        widgetRun = parent.verticalRun;
                    }
                    DimensionDependency dimensionDependency = widgetRun.dimension;
                    if (dimensionDependency.resolved) {
                        ConstraintWidget constraintWidget2 = this.widget;
                        if (i3 == 0) {
                            f4 = constraintWidget2.mMatchConstraintPercentWidth;
                        } else {
                            f4 = constraintWidget2.mMatchConstraintPercentHeight;
                        }
                        this.dimension.resolve(getLimitedDimension((int) ((dimensionDependency.value * f4) + 0.5f), i3));
                        return;
                    }
                    return;
                }
                return;
            }
            this.dimension.resolve(Math.min(getLimitedDimension(this.dimension.wrapValue, i3), i5));
            return;
        }
        this.dimension.resolve(getLimitedDimension(i5, i3));
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i3) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i3;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int i3, int i5) {
        int max;
        if (i5 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int i6 = constraintWidget.mMatchConstraintMaxWidth;
            max = Math.max(constraintWidget.mMatchConstraintMinWidth, i3);
            if (i6 > 0) {
                max = Math.min(i6, i3);
            }
            if (max == i3) {
                return i3;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i7 = constraintWidget2.mMatchConstraintMaxHeight;
            max = Math.max(constraintWidget2.mMatchConstraintMinHeight, i3);
            if (i7 > 0) {
                max = Math.min(i7, i3);
            }
            if (max == i3) {
                return i3;
            }
        }
        return max;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return null;
                        }
                        return constraintWidget.verticalRun.end;
                    }
                    return constraintWidget.verticalRun.baseline;
                }
                return constraintWidget.verticalRun.start;
            }
            return constraintWidget.horizontalRun.end;
        }
        return constraintWidget.horizontalRun.start;
    }

    public long getWrapDimension() {
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            return dimensionDependency.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int size = this.start.targets.size();
        int i3 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            if (this.start.targets.get(i5).run != this) {
                i3++;
            }
        }
        int size2 = this.end.targets.size();
        for (int i6 = 0; i6 < size2; i6++) {
            if (this.end.targets.get(i6).run != this) {
                i3++;
            }
        }
        if (i3 < 2) {
            return false;
        }
        return true;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    public abstract void reset();

    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    public void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i3) {
        float verticalBiasPercent;
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = constraintAnchor.getMargin() + target.value;
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i5 = margin2 - margin;
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i3, i5);
            }
            DimensionDependency dimensionDependency = this.dimension;
            if (!dimensionDependency.resolved) {
                return;
            }
            if (dimensionDependency.value == i5) {
                this.start.resolve(margin);
                this.end.resolve(margin2);
                return;
            }
            ConstraintWidget constraintWidget = this.widget;
            if (i3 == 0) {
                verticalBiasPercent = constraintWidget.getHorizontalBiasPercent();
            } else {
                verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
            }
            if (target == target2) {
                margin = target.value;
                margin2 = target2.value;
                verticalBiasPercent = 0.5f;
            }
            this.start.resolve((int) ((((margin2 - margin) - this.dimension.value) * verticalBiasPercent) + margin + 0.5f));
            this.end.resolve(this.start.value + this.dimension.value);
        }
    }

    public void updateRunEnd(Dependency dependency) {
    }

    public void updateRunStart(Dependency dependency) {
    }

    public long wrapSize(int i3) {
        int i5;
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            long j2 = dimensionDependency.value;
            if (isCenterConnection()) {
                i5 = this.start.margin - this.end.margin;
            } else if (i3 == 0) {
                i5 = this.start.margin;
            } else {
                return j2 - this.end.margin;
            }
            return j2 + i5;
        }
        return 0L;
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i3, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i3;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i3) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i3 == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int i5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }
}

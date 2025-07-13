package androidx.constraintlayout.solver.widgets.analyzer;

import a1.i;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    WidgetRun firstRun;
    int groupIndex;
    WidgetRun lastRun;
    public int position = 0;
    public boolean dual = false;
    ArrayList<WidgetRun> runs = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i3) {
        this.firstRun = null;
        this.lastRun = null;
        int i5 = index;
        this.groupIndex = i5;
        index = i5 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i3;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i3) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.widget.isTerminalWidget[i3]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.dependencies) {
            if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it = ((ChainRun) widgetRun).widgets.iterator();
                    while (it.hasNext()) {
                        defineTerminalWidget(it.next(), i3);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i3] = false;
                }
                defineTerminalWidget(dependencyNode2.run, i3);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).widgets.iterator();
                    while (it2.hasNext()) {
                        defineTerminalWidget(it2.next(), i3);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i3] = false;
                }
                defineTerminalWidget(dependencyNode.run, i3);
            }
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j2;
        }
        int size = dependencyNode.dependencies.size();
        long j5 = j2;
        for (int i3 = 0; i3 < size; i3++) {
            Dependency dependency = dependencyNode.dependencies.get(i3);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j5 = Math.min(j5, traverseEnd(dependencyNode2, dependencyNode2.margin + j2));
                }
            }
        }
        if (dependencyNode == widgetRun.end) {
            long wrapDimension = j2 - widgetRun.getWrapDimension();
            return Math.min(Math.min(j5, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.margin);
        }
        return j5;
    }

    private long traverseStart(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j2;
        }
        int size = dependencyNode.dependencies.size();
        long j5 = j2;
        for (int i3 = 0; i3 < size; i3++) {
            Dependency dependency = dependencyNode.dependencies.get(i3);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j5 = Math.max(j5, traverseStart(dependencyNode2, dependencyNode2.margin + j2));
                }
            }
        }
        if (dependencyNode == widgetRun.start) {
            long wrapDimension = j2 + widgetRun.getWrapDimension();
            return Math.max(Math.max(j5, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.margin);
        }
        return j5;
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i3) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        WidgetRun widgetRun3;
        DependencyNode dependencyNode;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun4 = this.firstRun;
        long j2 = 0;
        if (widgetRun4 instanceof ChainRun) {
            if (((ChainRun) widgetRun4).orientation != i3) {
                return 0L;
            }
        } else if (i3 == 0) {
            if (!(widgetRun4 instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun4 instanceof VerticalWidgetRun)) {
            return 0L;
        }
        if (i3 == 0) {
            widgetRun = constraintWidgetContainer.horizontalRun;
        } else {
            widgetRun = constraintWidgetContainer.verticalRun;
        }
        DependencyNode dependencyNode3 = widgetRun.start;
        if (i3 == 0) {
            widgetRun2 = constraintWidgetContainer.horizontalRun;
        } else {
            widgetRun2 = constraintWidgetContainer.verticalRun;
        }
        DependencyNode dependencyNode4 = widgetRun2.end;
        boolean contains = widgetRun4.start.targets.contains(dependencyNode3);
        boolean contains2 = this.firstRun.end.targets.contains(dependencyNode4);
        long wrapDimension = this.firstRun.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.firstRun.start, 0L);
            long traverseEnd = traverseEnd(this.firstRun.end, 0L);
            long j5 = traverseStart - wrapDimension;
            WidgetRun widgetRun5 = this.firstRun;
            int i5 = widgetRun5.end.margin;
            if (j5 >= (-i5)) {
                j5 += i5;
            }
            int i6 = widgetRun5.start.margin;
            long j6 = ((-traverseEnd) - wrapDimension) - i6;
            if (j6 >= i6) {
                j6 -= i6;
            }
            float biasPercent = widgetRun5.widget.getBiasPercent(i3);
            if (biasPercent > 0.0f) {
                j2 = (((float) j5) / (1.0f - biasPercent)) + (((float) j6) / biasPercent);
            }
            float f4 = (float) j2;
            long b = (f4 * biasPercent) + 0.5f + wrapDimension + i.b(1.0f, biasPercent, f4, 0.5f);
            WidgetRun widgetRun6 = this.firstRun;
            return (widgetRun6.start.margin + b) - widgetRun6.end.margin;
        } else if (contains) {
            return Math.max(traverseStart(this.firstRun.start, dependencyNode2.margin), this.firstRun.start.margin + wrapDimension);
        } else if (contains2) {
            return Math.max(-traverseEnd(this.firstRun.end, dependencyNode.margin), (-this.firstRun.end.margin) + wrapDimension);
        } else {
            return (this.firstRun.getWrapDimension() + widgetRun3.start.margin) - this.firstRun.end.margin;
        }
    }

    public void defineTerminalWidgets(boolean z3, boolean z5) {
        if (z3) {
            WidgetRun widgetRun = this.firstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z5) {
            WidgetRun widgetRun2 = this.firstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}

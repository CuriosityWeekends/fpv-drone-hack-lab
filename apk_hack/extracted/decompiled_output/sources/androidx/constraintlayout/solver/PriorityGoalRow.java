package androidx.constraintlayout.solver;

import a1.i;
import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class GoalVariableAccessor implements Comparable {
        PriorityGoalRow row;
        SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.row = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.variable.goalStrengthVector;
                float f4 = fArr[i3] + solverVariable.goalStrengthVector[i3];
                fArr[i3] = f4;
                if (Math.abs(f4) < 1.0E-4f) {
                    this.variable.goalStrengthVector[i3] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f4) {
            boolean z3 = true;
            if (this.variable.inGoal) {
                for (int i3 = 0; i3 < 9; i3++) {
                    float[] fArr = this.variable.goalStrengthVector;
                    float f5 = (solverVariable.goalStrengthVector[i3] * f4) + fArr[i3];
                    fArr[i3] = f5;
                    if (Math.abs(f5) < 1.0E-4f) {
                        this.variable.goalStrengthVector[i3] = 0.0f;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    PriorityGoalRow.this.removeGoal(this.variable);
                }
                return false;
            }
            for (int i5 = 0; i5 < 9; i5++) {
                float f6 = solverVariable.goalStrengthVector[i5];
                if (f6 != 0.0f) {
                    float f7 = f6 * f4;
                    if (Math.abs(f7) < 1.0E-4f) {
                        f7 = 0.0f;
                    }
                    this.variable.goalStrengthVector[i5] = f7;
                } else {
                    this.variable.goalStrengthVector[i5] = 0.0f;
                }
            }
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.variable.id - ((SolverVariable) obj).id;
        }

        public void init(SolverVariable solverVariable) {
            this.variable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i3 = 8; i3 >= 0; i3--) {
                float f4 = this.variable.goalStrengthVector[i3];
                if (f4 > 0.0f) {
                    return false;
                }
                if (f4 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i3 = 0; i3 < 9; i3++) {
                if (this.variable.goalStrengthVector[i3] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i3 = 8;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                float f4 = solverVariable.goalStrengthVector[i3];
                float f5 = this.variable.goalStrengthVector[i3];
                if (f5 == f4) {
                    i3--;
                } else if (f5 < f4) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.variable != null) {
                for (int i3 = 0; i3 < 9; i3++) {
                    StringBuilder l5 = i.l(str);
                    l5.append(this.variable.goalStrengthVector[i3]);
                    l5.append(" ");
                    str = l5.toString();
                }
            }
            StringBuilder o5 = i.o(str, "] ");
            o5.append(this.variable);
            return o5.toString();
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.TABLE_SIZE = 128;
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int i3;
        int i5 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i5 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i6 = this.numGoals;
        solverVariableArr3[i6] = solverVariable;
        int i7 = i6 + 1;
        this.numGoals = i7;
        if (i7 > 1 && solverVariableArr3[i6].id > solverVariable.id) {
            int i8 = 0;
            while (true) {
                i3 = this.numGoals;
                if (i8 >= i3) {
                    break;
                }
                this.sortArray[i8] = this.arrayGoals[i8];
                i8++;
            }
            Arrays.sort(this.sortArray, 0, i3, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.solver.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.id - solverVariable3.id;
                }
            });
            for (int i9 = 0; i9 < this.numGoals; i9++) {
                this.arrayGoals[i9] = this.sortArray[i9];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeGoal(SolverVariable solverVariable) {
        int i3 = 0;
        while (i3 < this.numGoals) {
            if (this.arrayGoals[i3] == solverVariable) {
                while (true) {
                    int i5 = this.numGoals;
                    if (i3 < i5 - 1) {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int i6 = i3 + 1;
                        solverVariableArr[i3] = solverVariableArr[i6];
                        i3 = i6;
                    } else {
                        this.numGoals = i5 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i3++;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.accessor.init(solverVariable);
        this.accessor.reset();
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i3 = -1;
        for (int i5 = 0; i5 < this.numGoals; i5++) {
            SolverVariable solverVariable = this.arrayGoals[i5];
            if (!zArr[solverVariable.id]) {
                this.accessor.init(solverVariable);
                if (i3 == -1) {
                    if (!this.accessor.isNegative()) {
                    }
                    i3 = i5;
                } else {
                    if (!this.accessor.isSmallerThan(this.arrayGoals[i3])) {
                    }
                    i3 = i5;
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        return this.arrayGoals[i3];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.constantValue + ") : ";
        for (int i3 = 0; i3 < this.numGoals; i3++) {
            this.accessor.init(this.arrayGoals[i3]);
            StringBuilder l5 = i.l(str);
            l5.append(this.accessor);
            l5.append(" ");
            str = l5.toString();
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(ArrayRow arrayRow, boolean z3) {
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i3 = 0; i3 < currentSize; i3++) {
            SolverVariable variable = arrayRowVariables.getVariable(i3);
            float variableValue = arrayRowVariables.getVariableValue(i3);
            this.accessor.init(variable);
            if (this.accessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.constantValue = (arrayRow.constantValue * variableValue) + this.constantValue;
        }
        removeGoal(solverVariable);
    }
}

package androidx.constraintlayout.solver;

import a1.i;
import androidx.constraintlayout.solver.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    int[] keys = new int[16];
    int[] nextKeys = new int[16];
    int[] variables = new int[16];
    float[] values = new float[16];
    int[] previous = new int[16];
    int[] next = new int[16];
    int mCount = 0;
    int head = -1;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i3) {
        int[] iArr;
        int i5 = solverVariable.id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i6 = iArr2[i5];
        if (i6 == -1) {
            iArr2[i5] = i3;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    break;
                }
                i6 = i7;
            }
            iArr[i6] = i3;
        }
        this.nextKeys[i3] = -1;
    }

    private void addVariable(int i3, SolverVariable solverVariable, float f4) {
        this.variables[i3] = solverVariable.id;
        this.values[i3] = f4;
        this.previous[i3] = -1;
        this.next[i3] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i3 = 0; i3 < this.HASH_SIZE; i3++) {
            if (this.keys[i3] != -1) {
                String str = hashCode() + " hash [" + i3 + "] => ";
                int i5 = this.keys[i3];
                boolean z3 = false;
                while (!z3) {
                    StringBuilder o5 = i.o(str, " ");
                    o5.append(this.variables[i5]);
                    str = o5.toString();
                    int i6 = this.nextKeys[i5];
                    if (i6 != -1) {
                        i5 = i6;
                    } else {
                        z3 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i3 = 0; i3 < this.SIZE; i3++) {
            if (this.variables[i3] == -1) {
                return i3;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i3 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i3);
        this.values = Arrays.copyOf(this.values, i3);
        this.previous = Arrays.copyOf(this.previous, i3);
        this.next = Arrays.copyOf(this.next, i3);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i3);
        for (int i5 = this.SIZE; i5 < i3; i5++) {
            this.variables[i5] = -1;
            this.nextKeys[i5] = -1;
        }
        this.SIZE = i3;
    }

    private void insertVariable(int i3, SolverVariable solverVariable, float f4) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f4);
        if (i3 != -1) {
            this.previous[findEmptySlot] = i3;
            int[] iArr = this.next;
            iArr[findEmptySlot] = iArr[i3];
            iArr[i3] = findEmptySlot;
        } else {
            this.previous[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[findEmptySlot] = this.head;
                this.head = findEmptySlot;
            } else {
                this.next[findEmptySlot] = -1;
            }
        }
        int i5 = this.next[findEmptySlot];
        if (i5 != -1) {
            this.previous[i5] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i3;
        int i5 = solverVariable.id;
        int i6 = i5 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i7 = iArr2[i6];
        if (i7 == -1) {
            return;
        }
        if (this.variables[i7] == i5) {
            int[] iArr3 = this.nextKeys;
            iArr2[i6] = iArr3[i7];
            iArr3[i7] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            i3 = iArr[i7];
            if (i3 == -1 || this.variables[i3] == i5) {
                break;
            }
            i7 = i3;
        }
        if (i3 != -1 && this.variables[i3] == i5) {
            iArr[i7] = iArr[i3];
            iArr[i3] = -1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f4, boolean z3) {
        float f5 = epsilon;
        if (f4 > (-f5) && f4 < f5) {
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            put(solverVariable, f4);
            return;
        }
        float[] fArr = this.values;
        float f6 = fArr[indexOf] + f4;
        fArr[indexOf] = f6;
        float f7 = epsilon;
        if (f6 > (-f7) && f6 < f7) {
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z3);
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        int i3 = this.mCount;
        for (int i5 = 0; i5 < i3; i5++) {
            SolverVariable variable = getVariable(i5);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i6 = 0; i6 < this.SIZE; i6++) {
            this.variables[i6] = -1;
            this.nextKeys[i6] = -1;
        }
        for (int i7 = 0; i7 < this.HASH_SIZE; i7++) {
            this.keys[i7] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        if (indexOf(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i3 = this.mCount;
        System.out.print("{ ");
        for (int i5 = 0; i5 < i3; i5++) {
            SolverVariable variable = getVariable(i5);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i5) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f4) {
        int i3 = this.mCount;
        int i5 = this.head;
        for (int i6 = 0; i6 < i3; i6++) {
            float[] fArr = this.values;
            fArr[i5] = fArr[i5] / f4;
            i5 = this.next[i5];
            if (i5 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i3) {
        int i5 = this.mCount;
        if (i5 == 0) {
            return null;
        }
        int i6 = this.head;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 == i3 && i6 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i6]];
            }
            i6 = this.next[i6];
            if (i6 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i3) {
        int i5 = this.mCount;
        int i6 = this.head;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 == i3) {
                return this.values[i6];
            }
            i6 = this.next[i6];
            if (i6 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount == 0) {
            return -1;
        }
        int i3 = solverVariable.id;
        int i5 = this.keys[i3 % this.HASH_SIZE];
        if (i5 == -1) {
            return -1;
        }
        if (this.variables[i5] == i3) {
            return i5;
        }
        do {
            i5 = this.nextKeys[i5];
            if (i5 == -1) {
                break;
            }
        } while (this.variables[i5] != i3);
        if (i5 == -1 || this.variables[i5] != i3) {
            return -1;
        }
        return i5;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i3 = this.mCount;
        int i5 = this.head;
        for (int i6 = 0; i6 < i3; i6++) {
            float[] fArr = this.values;
            fArr[i5] = fArr[i5] * (-1.0f);
            i5 = this.next[i5];
            if (i5 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f4) {
        float f5 = epsilon;
        if (f4 > (-f5) && f4 < f5) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f4);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.values[indexOf] = f4;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i3 = this.mCount;
        int i5 = this.head;
        int i6 = -1;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = this.variables[i5];
            int i9 = solverVariable.id;
            if (i8 == i9) {
                this.values[i5] = f4;
                return;
            }
            if (i8 < i9) {
                i6 = i5;
            }
            i5 = this.next[i5];
            if (i5 == -1) {
                break;
            }
        }
        insertVariable(i6, solverVariable, f4);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z3) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f4 = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] iArr = this.previous;
        int i3 = iArr[indexOf];
        if (i3 != -1) {
            int[] iArr2 = this.next;
            iArr2[i3] = iArr2[indexOf];
        }
        int i5 = this.next[indexOf];
        if (i5 != -1) {
            iArr[i5] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z3) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f4;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String h5;
        String h6;
        String str = hashCode() + " { ";
        int i3 = this.mCount;
        for (int i5 = 0; i5 < i3; i5++) {
            SolverVariable variable = getVariable(i5);
            if (variable != null) {
                String str2 = str + variable + " = " + getVariableValue(i5) + " ";
                int indexOf = indexOf(variable);
                String h7 = i.h(str2, "[p: ");
                if (this.previous[indexOf] != -1) {
                    StringBuilder l5 = i.l(h7);
                    l5.append(this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]]);
                    h5 = l5.toString();
                } else {
                    h5 = i.h(h7, "none");
                }
                String h8 = i.h(h5, ", n: ");
                if (this.next[indexOf] != -1) {
                    StringBuilder l6 = i.l(h8);
                    l6.append(this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]]);
                    h6 = l6.toString();
                } else {
                    h6 = i.h(h8, "none");
                }
                str = i.h(h6, "]");
            }
        }
        return i.h(str, " }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z3) {
        float f4 = get(arrayRow.variable);
        remove(arrayRow.variable, z3);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i3 = 0;
        int i5 = 0;
        while (i3 < currentSize) {
            int i6 = solverVariableValues.variables[i5];
            if (i6 != -1) {
                add(this.mCache.mIndexedVariables[i6], solverVariableValues.values[i5] * f4, z3);
                i3++;
            }
            i5++;
        }
        return f4;
    }
}

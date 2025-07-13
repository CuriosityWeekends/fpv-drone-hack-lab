package androidx.constraintlayout.solver;

import a1.i;
import androidx.constraintlayout.solver.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    int currentSize = 0;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private int mHead = -1;
    private int mLast = -1;
    private boolean mDidFillOnce = false;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f4, boolean z3) {
        float f5 = epsilon;
        if (f4 > (-f5) && f4 < f5) {
            return;
        }
        int i3 = this.mHead;
        if (i3 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f4;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                int i5 = this.mLast + 1;
                this.mLast = i5;
                int[] iArr = this.mArrayIndices;
                if (i5 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i6 = -1;
        for (int i7 = 0; i3 != -1 && i7 < this.currentSize; i7++) {
            int i8 = this.mArrayIndices[i3];
            int i9 = solverVariable.id;
            if (i8 == i9) {
                float[] fArr = this.mArrayValues;
                float f6 = fArr[i3] + f4;
                float f7 = epsilon;
                if (f6 > (-f7) && f6 < f7) {
                    f6 = 0.0f;
                }
                fArr[i3] = f6;
                if (f6 == 0.0f) {
                    if (i3 == this.mHead) {
                        this.mHead = this.mArrayNextIndices[i3];
                    } else {
                        int[] iArr2 = this.mArrayNextIndices;
                        iArr2[i6] = iArr2[i3];
                    }
                    if (z3) {
                        solverVariable.removeFromRow(this.mRow);
                    }
                    if (this.mDidFillOnce) {
                        this.mLast = i3;
                    }
                    solverVariable.usageInRowCount--;
                    this.currentSize--;
                    return;
                }
                return;
            }
            if (i8 < i9) {
                i6 = i3;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        int i10 = this.mLast;
        int i11 = i10 + 1;
        if (this.mDidFillOnce) {
            int[] iArr3 = this.mArrayIndices;
            if (iArr3[i10] != -1) {
                i10 = iArr3.length;
            }
        } else {
            i10 = i11;
        }
        int[] iArr4 = this.mArrayIndices;
        if (i10 >= iArr4.length && this.currentSize < iArr4.length) {
            int i12 = 0;
            while (true) {
                int[] iArr5 = this.mArrayIndices;
                if (i12 >= iArr5.length) {
                    break;
                } else if (iArr5[i12] == -1) {
                    i10 = i12;
                    break;
                } else {
                    i12++;
                }
            }
        }
        int[] iArr6 = this.mArrayIndices;
        if (i10 >= iArr6.length) {
            i10 = iArr6.length;
            int i13 = this.ROW_SIZE * 2;
            this.ROW_SIZE = i13;
            this.mDidFillOnce = false;
            this.mLast = i10 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i13);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[i10] = solverVariable.id;
        this.mArrayValues[i10] = f4;
        if (i6 != -1) {
            int[] iArr7 = this.mArrayNextIndices;
            iArr7[i10] = iArr7[i6];
            iArr7[i6] = i10;
        } else {
            this.mArrayNextIndices[i10] = this.mHead;
            this.mHead = i10;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        this.currentSize++;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int i14 = this.mLast;
        int[] iArr8 = this.mArrayIndices;
        if (i14 >= iArr8.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr8.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i3 = this.mHead;
        for (int i5 = 0; i3 != -1 && i5 < this.currentSize; i5++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i3]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i3 = this.mArrayNextIndices[i3];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i3 = this.mHead;
        if (i3 == -1) {
            return false;
        }
        for (int i5 = 0; i3 != -1 && i5 < this.currentSize; i5++) {
            if (this.mArrayIndices[i3] == solverVariable.id) {
                return true;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i3 = this.currentSize;
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
        int i3 = this.mHead;
        for (int i5 = 0; i3 != -1 && i5 < this.currentSize; i5++) {
            float[] fArr = this.mArrayValues;
            fArr[i3] = fArr[i3] / f4;
            i3 = this.mArrayNextIndices[i3];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i3 = this.mHead;
        for (int i5 = 0; i3 != -1 && i5 < this.currentSize; i5++) {
            if (this.mArrayIndices[i3] == solverVariable.id) {
                return this.mArrayValues[i3];
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i3) {
        return this.mArrayIndices[i3];
    }

    public final int getNextIndice(int i3) {
        return this.mArrayNextIndices[i3];
    }

    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.candidate;
        if (solverVariable == null) {
            int i3 = this.mHead;
            SolverVariable solverVariable2 = null;
            for (int i5 = 0; i3 != -1 && i5 < this.currentSize; i5++) {
                if (this.mArrayValues[i3] < 0.0f) {
                    SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i3]];
                    if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                        solverVariable2 = solverVariable3;
                    }
                }
                i3 = this.mArrayNextIndices[i3];
            }
            return solverVariable2;
        }
        return solverVariable;
    }

    public final float getValue(int i3) {
        return this.mArrayValues[i3];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i3) {
        int i5 = this.mHead;
        for (int i6 = 0; i5 != -1 && i6 < this.currentSize; i6++) {
            if (i6 == i3) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i5]];
            }
            i5 = this.mArrayNextIndices[i5];
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i3) {
        int i5 = this.mHead;
        for (int i6 = 0; i5 != -1 && i6 < this.currentSize; i6++) {
            if (i6 == i3) {
                return this.mArrayValues[i5];
            }
            i5 = this.mArrayNextIndices[i5];
        }
        return 0.0f;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        int i3 = this.mHead;
        for (int i5 = 0; i3 != -1 && i5 < this.currentSize; i5++) {
            if (this.mArrayValues[i3] > 0.0f) {
                return true;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i3 = this.mHead;
        if (i3 == -1) {
            return -1;
        }
        for (int i5 = 0; i3 != -1 && i5 < this.currentSize; i5++) {
            if (this.mArrayIndices[i3] == solverVariable.id) {
                return i3;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i3 = this.mHead;
        for (int i5 = 0; i3 != -1 && i5 < this.currentSize; i5++) {
            float[] fArr = this.mArrayValues;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.mArrayNextIndices[i3];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f4) {
        if (f4 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i3 = this.mHead;
        if (i3 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f4;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                int i5 = this.mLast + 1;
                this.mLast = i5;
                int[] iArr = this.mArrayIndices;
                if (i5 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i6 = -1;
        for (int i7 = 0; i3 != -1 && i7 < this.currentSize; i7++) {
            int i8 = this.mArrayIndices[i3];
            int i9 = solverVariable.id;
            if (i8 == i9) {
                this.mArrayValues[i3] = f4;
                return;
            }
            if (i8 < i9) {
                i6 = i3;
            }
            i3 = this.mArrayNextIndices[i3];
        }
        int i10 = this.mLast;
        int i11 = i10 + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[i10] != -1) {
                i10 = iArr2.length;
            }
        } else {
            i10 = i11;
        }
        int[] iArr3 = this.mArrayIndices;
        if (i10 >= iArr3.length && this.currentSize < iArr3.length) {
            int i12 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i12 >= iArr4.length) {
                    break;
                } else if (iArr4[i12] == -1) {
                    i10 = i12;
                    break;
                } else {
                    i12++;
                }
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (i10 >= iArr5.length) {
            i10 = iArr5.length;
            int i13 = this.ROW_SIZE * 2;
            this.ROW_SIZE = i13;
            this.mDidFillOnce = false;
            this.mLast = i10 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i13);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[i10] = solverVariable.id;
        this.mArrayValues[i10] = f4;
        if (i6 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[i10] = iArr6[i6];
            iArr6[i6] = i10;
        } else {
            this.mArrayNextIndices[i10] = this.mHead;
            this.mHead = i10;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i14 = this.currentSize + 1;
        this.currentSize = i14;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i14 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z3) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        int i3 = this.mHead;
        if (i3 == -1) {
            return 0.0f;
        }
        int i5 = 0;
        int i6 = -1;
        while (i3 != -1 && i5 < this.currentSize) {
            if (this.mArrayIndices[i3] == solverVariable.id) {
                if (i3 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i3];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i6] = iArr[i3];
                }
                if (z3) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[i3] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i3;
                }
                return this.mArrayValues[i3];
            }
            i5++;
            i6 = i3;
            i3 = this.mArrayNextIndices[i3];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int i3 = this.mHead;
        String str = "";
        for (int i5 = 0; i3 != -1 && i5 < this.currentSize; i5++) {
            StringBuilder l5 = i.l(i.h(str, " -> "));
            l5.append(this.mArrayValues[i3]);
            l5.append(" : ");
            StringBuilder l6 = i.l(l5.toString());
            l6.append(this.mCache.mIndexedVariables[this.mArrayIndices[i3]]);
            str = l6.toString();
            i3 = this.mArrayNextIndices[i3];
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z3) {
        float f4 = get(arrayRow.variable);
        remove(arrayRow.variable, z3);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i3 = 0; i3 < currentSize; i3++) {
            SolverVariable variable = arrayRowVariables.getVariable(i3);
            add(variable, arrayRowVariables.get(variable) * f4, z3);
        }
        return f4;
    }
}

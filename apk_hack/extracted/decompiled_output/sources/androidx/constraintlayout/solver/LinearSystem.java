package androidx.constraintlayout.solver;

import a1.i;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = true;
    private static int POOL_SIZE = 1000;
    static final boolean SIMPLIFY_SYNONYMS = false;
    private static final boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    ArrayRow[] mRows;
    private Row mTempGoal;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int TABLE_SIZE = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
    private int mPoolVariablesCount = 0;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z3);

        void updateFromRow(ArrayRow arrayRow, boolean z3);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.mCache.solverVariablePool.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        int i3 = this.mPoolVariablesCount;
        int i5 = POOL_SIZE;
        if (i3 >= i5) {
            int i6 = i5 * 2;
            POOL_SIZE = i6;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i6);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i7 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i7 + 1;
        solverVariableArr[i7] = acquire;
        return acquire;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        if (OPTIMIZED_ENGINE) {
            ArrayRow arrayRow2 = this.mRows[this.mNumRows];
            if (arrayRow2 != null) {
                this.mCache.optimizedArrayRowPool.release(arrayRow2);
            }
        } else {
            ArrayRow arrayRow3 = this.mRows[this.mNumRows];
            if (arrayRow3 != null) {
                this.mCache.arrayRowPool.release(arrayRow3);
            }
        }
        ArrayRow[] arrayRowArr = this.mRows;
        int i3 = this.mNumRows;
        arrayRowArr[i3] = arrayRow;
        SolverVariable solverVariable = arrayRow.variable;
        solverVariable.definitionId = i3;
        this.mNumRows = i3 + 1;
        solverVariable.updateReferencesWithNewDefinition(arrayRow);
    }

    private void addSingleError(ArrayRow arrayRow, int i3) {
        addSingleError(arrayRow, i3, 0);
    }

    private void computeValues() {
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            ArrayRow arrayRow = this.mRows[i3];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f4) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f4);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
        acquireSolverVariable.setName(str);
        int i3 = this.mVariablesID + 1;
        this.mVariablesID = i3;
        this.mNumColumns++;
        acquireSolverVariable.id = i3;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            StringBuilder l5 = i.l(str);
            l5.append(this.mRows[i3]);
            str = i.h(l5.toString(), "\n");
        }
        StringBuilder l6 = i.l(str);
        l6.append(this.mGoal);
        l6.append("\n");
        System.out.println(l6.toString());
    }

    private void displaySolverVariables() {
        StringBuilder sb = new StringBuilder("Display Rows (");
        sb.append(this.mNumRows);
        sb.append("x");
        System.out.println(i.j(sb, this.mNumColumns, ")\n"));
    }

    private int enforceBFS(Row row) {
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            ArrayRow arrayRow = this.mRows[i3];
            if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED) {
                float f4 = 0.0f;
                if (arrayRow.constantValue < 0.0f) {
                    boolean z3 = false;
                    int i5 = 0;
                    while (!z3) {
                        Metrics metrics = sMetrics;
                        if (metrics != null) {
                            metrics.bfs++;
                        }
                        i5++;
                        float f5 = Float.MAX_VALUE;
                        int i6 = 0;
                        int i7 = -1;
                        int i8 = -1;
                        int i9 = 0;
                        while (true) {
                            int i10 = 1;
                            if (i6 >= this.mNumRows) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.mRows[i6];
                            if (arrayRow2.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow2.isSimpleDefinition && arrayRow2.constantValue < f4) {
                                while (i10 < this.mNumColumns) {
                                    SolverVariable solverVariable = this.mCache.mIndexedVariables[i10];
                                    float f6 = arrayRow2.variables.get(solverVariable);
                                    if (f6 > f4) {
                                        for (int i11 = 0; i11 < 9; i11++) {
                                            float f7 = solverVariable.strengthVector[i11] / f6;
                                            if ((f7 < f5 && i11 == i9) || i11 > i9) {
                                                i9 = i11;
                                                f5 = f7;
                                                i7 = i6;
                                                i8 = i10;
                                            }
                                        }
                                    }
                                    i10++;
                                    f4 = 0.0f;
                                }
                            }
                            i6++;
                            f4 = 0.0f;
                        }
                        if (i7 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i7];
                            arrayRow3.variable.definitionId = -1;
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots++;
                            }
                            arrayRow3.pivot(this.mCache.mIndexedVariables[i8]);
                            SolverVariable solverVariable2 = arrayRow3.variable;
                            solverVariable2.definitionId = i7;
                            solverVariable2.updateReferencesWithNewDefinition(arrayRow3);
                        } else {
                            z3 = true;
                        }
                        if (i5 > this.mNumColumns / 2) {
                            z3 = true;
                        }
                        f4 = 0.0f;
                    }
                    return i5;
                }
            }
        }
        return 0;
    }

    private String getDisplaySize(int i3) {
        int i5 = i3 * 4;
        int i6 = i5 / 1024;
        int i7 = i6 / 1024;
        if (i7 > 0) {
            return "" + i7 + " Mb";
        } else if (i6 > 0) {
            return "" + i6 + " Kb";
        } else {
            return "" + i5 + " bytes";
        }
    }

    private String getDisplayStrength(int i3) {
        if (i3 == 1) {
            return "LOW";
        }
        if (i3 == 2) {
            return "MEDIUM";
        }
        if (i3 == 3) {
            return "HIGH";
        }
        if (i3 == 4) {
            return "HIGHEST";
        }
        if (i3 == 5) {
            return "EQUALITY";
        }
        if (i3 == 8) {
            return "FIXED";
        }
        if (i3 == 6) {
            return "BARRIER";
        }
        return "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i3 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i3;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i3);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i5 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i5];
        this.mMaxColumns = i5;
        this.mMaxRows = i5;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i5);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int optimize(Row row, boolean z3) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            this.mAlreadyTestedCandidates[i3] = false;
        }
        boolean z5 = false;
        int i5 = 0;
        while (!z5) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i5++;
            if (i5 >= this.mNumColumns * 2) {
                return i5;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i6 = pivotCandidate.id;
                if (zArr[i6]) {
                    return i5;
                }
                zArr[i6] = true;
            }
            if (pivotCandidate != null) {
                float f4 = Float.MAX_VALUE;
                int i7 = -1;
                for (int i8 = 0; i8 < this.mNumRows; i8++) {
                    ArrayRow arrayRow = this.mRows[i8];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                        float f5 = arrayRow.variables.get(pivotCandidate);
                        if (f5 < 0.0f) {
                            float f6 = (-arrayRow.constantValue) / f5;
                            if (f6 < f4) {
                                i7 = i8;
                                f4 = f6;
                            }
                        }
                    }
                }
                if (i7 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i7];
                    arrayRow2.variable.definitionId = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    SolverVariable solverVariable = arrayRow2.variable;
                    solverVariable.definitionId = i7;
                    solverVariable.updateReferencesWithNewDefinition(arrayRow2);
                }
            } else {
                z5 = true;
            }
        }
        return i5;
    }

    private void releaseRows() {
        int i3 = 0;
        if (OPTIMIZED_ENGINE) {
            while (true) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (i3 < arrayRowArr.length) {
                    ArrayRow arrayRow = arrayRowArr[i3];
                    if (arrayRow != null) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow);
                    }
                    this.mRows[i3] = null;
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (i3 < arrayRowArr2.length) {
                    ArrayRow arrayRow2 = arrayRowArr2[i3];
                    if (arrayRow2 != null) {
                        this.mCache.arrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i3] = null;
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f4, int i3) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d = f4;
        double d5 = i3;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d) * d5));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(d) * d5));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, float f4, SolverVariable solverVariable3, SolverVariable solverVariable4, int i5, int i6) {
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i3, f4, solverVariable3, solverVariable4, i5);
        if (i6 != 8) {
            createRow.addError(this, i6);
        }
        addConstraint(createRow);
    }

    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable pickPivot;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.isSimpleDefinition) {
                metrics.simpleconstraints++;
            }
        }
        boolean z3 = true;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z5 = false;
        if (!arrayRow.isSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable createExtraVariable = createExtraVariable();
                arrayRow.variable = createExtraVariable;
                addRow(arrayRow);
                this.mTempGoal.initFromRow(arrayRow);
                optimize(this.mTempGoal, true);
                if (createExtraVariable.definitionId == -1) {
                    if (arrayRow.variable == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                        Metrics metrics2 = sMetrics;
                        if (metrics2 != null) {
                            metrics2.pivots++;
                        }
                        arrayRow.pivot(pickPivot);
                    }
                    if (!arrayRow.isSimpleDefinition) {
                        arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                    }
                    this.mNumRows--;
                }
            } else {
                z3 = false;
            }
            if (!arrayRow.hasKeyVariable()) {
                return;
            }
            z5 = z3;
        }
        if (!z5) {
            addRow(arrayRow);
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, int i5) {
        if (i5 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i3);
            return null;
        }
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i3);
        if (i5 != 8) {
            createRow.addError(this, i5);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, boolean z3) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i3);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, int i5) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i3);
        if (i5 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i5);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, boolean z3) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i3);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i3, int i5) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i3);
        if (i5 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i5);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f4, int i3) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f4);
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    public final void cleanupRows() {
        int i3;
        int i5 = 0;
        while (i5 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (arrayRow.isSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.variable;
                solverVariable.computedValue = arrayRow.constantValue;
                solverVariable.removeFromRow(arrayRow);
                int i6 = i5;
                while (true) {
                    i3 = this.mNumRows;
                    if (i6 >= i3 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i7 = i6 + 1;
                    arrayRowArr[i6] = arrayRowArr[i7];
                    i6 = i7;
                }
                this.mRows[i3 - 1] = null;
                this.mNumRows = i3 - 1;
                i5--;
            }
            i5++;
        }
    }

    public SolverVariable createErrorVariable(int i3, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i5 = this.mVariablesID + 1;
        this.mVariablesID = i5;
        this.mNumColumns++;
        acquireSolverVariable.id = i5;
        acquireSolverVariable.strength = i3;
        this.mCache.mIndexedVariables[i5] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i3 = this.mVariablesID + 1;
        this.mVariablesID = i3;
        this.mNumColumns++;
        acquireSolverVariable.id = i3;
        this.mCache.mIndexedVariables[i3] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i3 = solverVariable.id;
            if (i3 == -1 || i3 > this.mVariablesID || this.mCache.mIndexedVariables[i3] == null) {
                if (i3 != -1) {
                    solverVariable.reset();
                }
                int i5 = this.mVariablesID + 1;
                this.mVariablesID = i5;
                this.mNumColumns++;
                solverVariable.id = i5;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[i5] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow acquire;
        if (OPTIMIZED_ENGINE) {
            acquire = this.mCache.optimizedArrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        } else {
            acquire = this.mCache.arrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i3 = this.mVariablesID + 1;
        this.mVariablesID = i3;
        this.mNumColumns++;
        acquireSolverVariable.id = i3;
        this.mCache.mIndexedVariables[i3] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i3 = 0; i3 < this.mVariablesID; i3++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i3];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i3 + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String h5 = i.h(str, "\n\n #  ");
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            StringBuilder l5 = i.l(h5);
            l5.append(this.mRows[i5].toReadableString());
            h5 = i.h(l5.toString(), "\n #  ");
        }
        if (this.mGoal != null) {
            StringBuilder o5 = i.o(h5, "Goal: ");
            o5.append(this.mGoal);
            o5.append("\n");
            h5 = o5.toString();
        }
        System.out.println(h5);
    }

    public void displaySystemInformations() {
        int i3 = 0;
        for (int i5 = 0; i5 < this.TABLE_SIZE; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow != null) {
                i3 += arrayRow.sizeInBytes();
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.mNumRows; i7++) {
            ArrayRow arrayRow2 = this.mRows[i7];
            if (arrayRow2 != null) {
                i6 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder("Linear System -> Table size: ");
        sb.append(this.TABLE_SIZE);
        sb.append(" (");
        int i8 = this.TABLE_SIZE;
        sb.append(getDisplaySize(i8 * i8));
        sb.append(") -- row sizes: ");
        sb.append(getDisplaySize(i3));
        sb.append(", actual size: ");
        sb.append(getDisplaySize(i6));
        sb.append(" rows: ");
        sb.append(this.mNumRows);
        sb.append("/");
        sb.append(this.mMaxRows);
        sb.append(" cols: ");
        sb.append(this.mNumColumns);
        sb.append("/");
        sb.append(this.mMaxColumns);
        sb.append(" 0 occupied cells, ");
        sb.append(getDisplaySize(0));
        printStream.println(sb.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            if (this.mRows[i3].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                StringBuilder l5 = i.l(str);
                l5.append(this.mRows[i3].toReadableString());
                str = i.h(l5.toString(), "\n");
            }
        }
        StringBuilder l6 = i.l(str);
        l6.append(this.mGoal);
        l6.append("\n");
        System.out.println(l6.toString());
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int i3 = 0;
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow != null) {
                i3 = arrayRow.sizeInBytes() + i3;
            }
        }
        return i3;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public ArrayRow getRow(int i3) {
        return this.mRows[i3];
    }

    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        if (solverVariable == null) {
            return createVariable(str, type);
        }
        return solverVariable;
    }

    public void minimize() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        if (metrics != null) {
            metrics.graphOptimizer++;
        }
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            if (!this.mRows[i3].isSimpleDefinition) {
                minimizeGoal(this.mGoal);
                return;
            }
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.fullySolved++;
        }
        computeValues();
    }

    public void minimizeGoal(Row row) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i3;
        if (arrayRow.isSimpleDefinition && (solverVariable = arrayRow.variable) != null) {
            int i5 = solverVariable.definitionId;
            if (i5 != -1) {
                while (true) {
                    i3 = this.mNumRows;
                    if (i5 >= i3 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i6 = i5 + 1;
                    arrayRowArr[i5] = arrayRowArr[i6];
                    i5 = i6;
                }
                this.mNumRows = i3 - 1;
            }
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        }
    }

    public void reset() {
        Cache cache;
        int i3 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i3 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i3];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i3++;
        }
        cache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.mVariables;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            this.mRows[i5].used = false;
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    public void addSingleError(ArrayRow arrayRow, int i3, int i5) {
        arrayRow.addSingleError(createErrorVariable(i5, null), i3);
    }

    public void addEquality(SolverVariable solverVariable, int i3) {
        int i5 = solverVariable.definitionId;
        if (i5 == -1) {
            solverVariable.setFinalValue(this, i3);
        } else if (i5 != -1) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = i3;
            } else if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = i3;
            } else {
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i3);
                addConstraint(createRow);
            }
        } else {
            ArrayRow createRow2 = createRow();
            createRow2.createRowDefinition(solverVariable, i3);
            addConstraint(createRow2);
        }
    }
}

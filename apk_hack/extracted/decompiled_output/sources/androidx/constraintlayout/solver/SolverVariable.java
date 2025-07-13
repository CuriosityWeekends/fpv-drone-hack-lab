package androidx.constraintlayout.solver;

import a1.i;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    float[] goalStrengthVector;
    public int id;
    public boolean inGoal;
    HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    public int usageInRowCount;

    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1  reason: invalid class name */
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inRows = null;
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            StringBuilder l5 = i.l(str);
            l5.append(uniqueErrorId);
            return l5.toString();
        }
        int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            StringBuilder sb = new StringBuilder(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                            int i5 = uniqueId + 1;
                            uniqueId = i5;
                            sb.append(i5);
                            return sb.toString();
                        }
                        throw new AssertionError(type.name());
                    }
                    StringBuilder sb2 = new StringBuilder("e");
                    int i6 = uniqueErrorId + 1;
                    uniqueErrorId = i6;
                    sb2.append(i6);
                    return sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder(ExifInterface.LATITUDE_SOUTH);
                int i7 = uniqueSlackId + 1;
                uniqueSlackId = i7;
                sb3.append(i7);
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder("C");
            int i8 = uniqueConstantId + 1;
            uniqueConstantId = i8;
            sb4.append(i8);
            return sb4.toString();
        }
        StringBuilder sb5 = new StringBuilder("U");
        int i9 = uniqueUnrestrictedId + 1;
        uniqueUnrestrictedId = i9;
        sb5.append(i9);
        return sb5.toString();
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i3 = 0;
        while (true) {
            int i5 = this.mClientEquationsCount;
            if (i3 < i5) {
                if (this.mClientEquations[i3] == arrayRow) {
                    return;
                }
                i3++;
            } else {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i5 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i6 = this.mClientEquationsCount;
                arrayRowArr2[i6] = arrayRow;
                this.mClientEquationsCount = i6 + 1;
                return;
            }
        }
    }

    public void clearStrengths() {
        for (int i3 = 0; i3 < 9; i3++) {
            this.strengthVector[i3] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i3 = this.mClientEquationsCount;
        int i5 = 0;
        while (i5 < i3) {
            if (this.mClientEquations[i5] == arrayRow) {
                while (i5 < i3 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i6 = i5 + 1;
                    arrayRowArr[i5] = arrayRowArr[i6];
                    i5 = i6;
                }
                this.mClientEquationsCount--;
                return;
            }
            i5++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        int i3 = this.mClientEquationsCount;
        for (int i5 = 0; i5 < i3; i5++) {
            this.mClientEquations[i5] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f4) {
        this.computedValue = f4;
        this.isFinalValue = true;
        int i3 = this.mClientEquationsCount;
        for (int i5 = 0; i5 < i3; i5++) {
            this.mClientEquations[i5].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String str = this + "[";
        boolean z3 = false;
        boolean z5 = true;
        for (int i3 = 0; i3 < this.strengthVector.length; i3++) {
            StringBuilder l5 = i.l(str);
            l5.append(this.strengthVector[i3]);
            String sb = l5.toString();
            float[] fArr = this.strengthVector;
            float f4 = fArr[i3];
            if (f4 > 0.0f) {
                z3 = false;
            } else if (f4 < 0.0f) {
                z3 = true;
            }
            if (f4 != 0.0f) {
                z5 = false;
            }
            if (i3 < fArr.length - 1) {
                str = i.h(sb, ", ");
            } else {
                str = i.h(sb, "] ");
            }
        }
        if (z3) {
            str = i.h(str, " (-)");
        }
        if (z5) {
            return i.h(str, " (*)");
        }
        return str;
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.id;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i3 = this.mClientEquationsCount;
        for (int i5 = 0; i5 < i3; i5++) {
            this.mClientEquations[i5].updateFromRow(arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inRows = null;
        this.mType = type;
    }
}

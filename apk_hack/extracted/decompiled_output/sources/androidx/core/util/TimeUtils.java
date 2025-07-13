package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class TimeUtils {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i3, int i5, boolean z3, int i6) {
        if (i3 > 99 || (z3 && i6 >= 3)) {
            return i5 + 3;
        }
        if (i3 > 9 || (z3 && i6 >= 2)) {
            return i5 + 2;
        }
        if (z3 || i3 > 0) {
            return i5 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j2, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j2, 0));
        }
    }

    private static int formatDurationLocked(long j2, int i3) {
        char c;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        boolean z5;
        int i10;
        boolean z6;
        int i11;
        boolean z7;
        int i12;
        int i13;
        boolean z8;
        boolean z9;
        boolean z10;
        int i14;
        long j5 = j2;
        if (sFormatStr.length < i3) {
            sFormatStr = new char[i3];
        }
        char[] cArr = sFormatStr;
        int i15 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
        if (i15 == 0) {
            int i16 = i3 - 1;
            while (i16 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i15 > 0) {
            c = '+';
        } else {
            j5 = -j5;
            c = '-';
        }
        int i17 = (int) (j5 % 1000);
        int floor = (int) Math.floor(j5 / 1000);
        if (floor > SECONDS_PER_DAY) {
            i5 = floor / SECONDS_PER_DAY;
            floor -= SECONDS_PER_DAY * i5;
        } else {
            i5 = 0;
        }
        if (floor > SECONDS_PER_HOUR) {
            i6 = floor / SECONDS_PER_HOUR;
            floor -= i6 * SECONDS_PER_HOUR;
        } else {
            i6 = 0;
        }
        if (floor > 60) {
            int i18 = floor / 60;
            i7 = floor - (i18 * 60);
            i8 = i18;
        } else {
            i7 = floor;
            i8 = 0;
        }
        if (i3 != 0) {
            int accumField = accumField(i5, 1, false, 0);
            if (accumField > 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            int accumField2 = accumField + accumField(i6, 1, z8, 2);
            if (accumField2 > 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            int accumField3 = accumField2 + accumField(i8, 1, z9, 2);
            if (accumField3 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            int accumField4 = accumField3 + accumField(i7, 1, z10, 2);
            if (accumField4 > 0) {
                i14 = 3;
            } else {
                i14 = 0;
            }
            i9 = 0;
            for (int accumField5 = accumField(i17, 2, true, i14) + 1 + accumField4; accumField5 < i3; accumField5++) {
                cArr[i9] = ' ';
                i9++;
            }
        } else {
            i9 = 0;
        }
        cArr[i9] = c;
        int i19 = i9 + 1;
        if (i3 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int printField = printField(cArr, i5, 'd', i19, false, 0);
        if (printField != i19) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z3) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int printField2 = printField(cArr, i6, 'h', printField, z5, i10);
        if (printField2 != i19) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z3) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        int printField3 = printField(cArr, i8, 'm', printField2, z6, i11);
        if (printField3 != i19) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z3) {
            i12 = 2;
        } else {
            i12 = 0;
        }
        int printField4 = printField(cArr, i7, 's', printField3, z7, i12);
        if (z3 && printField4 != i19) {
            i13 = 3;
        } else {
            i13 = 0;
        }
        int printField5 = printField(cArr, i17, 'm', printField4, true, i13);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i3, char c, int i5, boolean z3, int i6) {
        int i7;
        if (z3 || i3 > 0) {
            if ((z3 && i6 >= 3) || i3 > 99) {
                int i8 = i3 / 100;
                cArr[i5] = (char) (i8 + 48);
                i7 = i5 + 1;
                i3 -= i8 * 100;
            } else {
                i7 = i5;
            }
            if ((z3 && i6 >= 2) || i3 > 9 || i5 != i7) {
                int i9 = i3 / 10;
                cArr[i7] = (char) (i9 + 48);
                i7++;
                i3 -= i9 * 10;
            }
            cArr[i7] = (char) (i3 + 48);
            cArr[i7 + 1] = c;
            return i7 + 2;
        }
        return i5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j2, PrintWriter printWriter, int i3) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j2, i3)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j2, PrintWriter printWriter) {
        formatDuration(j2, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j2, long j5, PrintWriter printWriter) {
        if (j2 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j2 - j5, printWriter, 0);
        }
    }
}

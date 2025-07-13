package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z3) {
        if (!z3) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkArgumentInRange(int i3, int i5, int i6, @NonNull String str) {
        if (i3 >= i5) {
            if (i3 <= i6) {
                return i3;
            }
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i5 + ", " + i6 + "] (too high)");
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i5 + ", " + i6 + "] (too low)");
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i3, @Nullable String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i3, int i5) {
        if ((i3 & i5) == i3) {
            return i3;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i3) + ", but only 0x" + Integer.toHexString(i5) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t4) {
        t4.getClass();
        return t4;
    }

    public static void checkState(boolean z3, @Nullable String str) {
        if (!z3) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t4) {
        if (TextUtils.isEmpty(t4)) {
            throw new IllegalArgumentException();
        }
        return t4;
    }

    public static void checkArgument(boolean z3, @NonNull Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i3) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t4, @NonNull Object obj) {
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z3) {
        checkState(z3, null);
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t4, @NonNull Object obj) {
        if (TextUtils.isEmpty(t4)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t4;
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t4, @NonNull String str, @NonNull Object... objArr) {
        if (TextUtils.isEmpty(t4)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t4;
    }
}

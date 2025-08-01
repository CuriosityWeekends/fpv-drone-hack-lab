package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        boolean isAsynchronous;
        boolean isAsynchronous2;
        if (Build.VERSION.SDK_INT >= 22) {
            isAsynchronous2 = message.isAsynchronous();
            return isAsynchronous2;
        }
        if (sTryIsAsynchronous) {
            try {
                isAsynchronous = message.isAsynchronous();
                return isAsynchronous;
            } catch (NoSuchMethodError unused) {
                sTryIsAsynchronous = false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z3) {
        if (Build.VERSION.SDK_INT >= 22) {
            message.setAsynchronous(z3);
        } else if (sTrySetAsynchronous) {
            try {
                message.setAsynchronous(z3);
            } catch (NoSuchMethodError unused) {
                sTrySetAsynchronous = false;
            }
        }
    }
}

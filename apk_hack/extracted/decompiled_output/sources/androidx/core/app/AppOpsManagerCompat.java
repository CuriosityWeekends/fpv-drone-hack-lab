package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    private AppOpsManagerCompat() {
    }

    public static int noteOp(@NonNull Context context, @NonNull String str, int i3, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOp(str, i3, str2);
    }

    public static int noteOpNoThrow(@NonNull Context context, @NonNull String str, int i3, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOpNoThrow(str, i3, str2);
    }

    public static int noteProxyOp(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Object systemService;
        int noteProxyOp;
        if (Build.VERSION.SDK_INT >= 23) {
            systemService = context.getSystemService(AppOpsManager.class);
            noteProxyOp = ((AppOpsManager) systemService).noteProxyOp(str, str2);
            return noteProxyOp;
        }
        return 1;
    }

    public static int noteProxyOpNoThrow(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Object systemService;
        int noteProxyOpNoThrow;
        if (Build.VERSION.SDK_INT >= 23) {
            systemService = context.getSystemService(AppOpsManager.class);
            noteProxyOpNoThrow = ((AppOpsManager) systemService).noteProxyOpNoThrow(str, str2);
            return noteProxyOpNoThrow;
        }
        return 1;
    }

    @Nullable
    public static String permissionToOp(@NonNull String str) {
        String permissionToOp;
        if (Build.VERSION.SDK_INT >= 23) {
            permissionToOp = AppOpsManager.permissionToOp(str);
            return permissionToOp;
        }
        return null;
    }
}

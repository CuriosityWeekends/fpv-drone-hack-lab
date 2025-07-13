package androidx.core.view;

import android.os.Build;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class DragAndDropPermissionsCompat {
    private Object mDragAndDropPermissions;

    private DragAndDropPermissionsCompat(Object obj) {
        this.mDragAndDropPermissions = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
        r2 = r2.requestDragAndDropPermissions(r3);
     */
    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.core.view.DragAndDropPermissionsCompat request(android.app.Activity r2, android.view.DragEvent r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L12
            android.view.DragAndDropPermissions r2 = androidx.core.os.a.k(r2, r3)
            if (r2 == 0) goto L12
            androidx.core.view.DragAndDropPermissionsCompat r3 = new androidx.core.view.DragAndDropPermissionsCompat
            r3.<init>(r2)
            return r3
        L12:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.DragAndDropPermissionsCompat.request(android.app.Activity, android.view.DragEvent):androidx.core.view.DragAndDropPermissionsCompat");
    }

    public void release() {
        if (Build.VERSION.SDK_INT >= 24) {
            androidx.core.os.a.l(this.mDragAndDropPermissions).release();
        }
    }
}

package k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static final int f2489e;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2490a;
    public final ActivityManager b;
    public final b3.e c;
    public final float d;

    static {
        int i3;
        if (Build.VERSION.SDK_INT < 26) {
            i3 = 4;
        } else {
            i3 = 1;
        }
        f2489e = i3;
    }

    public g(Context context) {
        this.d = f2489e;
        this.f2490a = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.b = activityManager;
        this.c = new b3.e(12, context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT >= 26 && activityManager.isLowRamDevice()) {
            this.d = 0.0f;
        }
    }
}

package h3;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.bumptech.glide.d;
import com.bumptech.glide.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {
    public static b b;
    public static final int c = Build.VERSION.SDK_INT;

    /* renamed from: a  reason: collision with root package name */
    public d f2038a;

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, h3.b] */
    public static b f() {
        e.b = true;
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        ?? obj = new Object();
                        obj.f2038a = null;
                        b = obj;
                    }
                } finally {
                }
            }
        }
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.bumptech.glide.d, java.lang.Object] */
    public final void a() {
        if (this.f2038a != null) {
            return;
        }
        int i3 = c;
        if (i3 < 26) {
            this.f2038a = new k3.a(0);
            return;
        }
        if (j3.a.b == null) {
            synchronized (j3.a.class) {
                try {
                    if (j3.a.b == null) {
                        j3.a.b = new j3.a(0);
                    }
                } finally {
                }
            }
        }
        j3.a aVar = j3.a.b;
        if (i3 < 28) {
            aVar.getClass();
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str) && str.contains("HUAWEI")) {
                this.f2038a = new k3.a(1);
                return;
            }
            j3.b.o().getClass();
            if (!TextUtils.isEmpty(j3.b.n("ro.miui.ui.version.name"))) {
                this.f2038a = new k3.a(2);
                return;
            }
            j3.b.o().getClass();
            if (!TextUtils.isEmpty(j3.b.n("ro.vivo.os.name"))) {
                this.f2038a = new Object();
                return;
            } else if ("oppo".equalsIgnoreCase(str)) {
                this.f2038a = new k3.a(3);
                return;
            } else if ("samsung".equalsIgnoreCase(str)) {
                this.f2038a = new k3.a(6);
                return;
            } else {
                this.f2038a = new k3.a(0);
                return;
            }
        }
        aVar.getClass();
        String str2 = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str2) && str2.contains("HUAWEI")) {
            this.f2038a = new k3.a(4);
        } else {
            this.f2038a = new k3.a(5);
        }
    }

    public final void b(Activity activity) {
        if (this.f2038a == null) {
            activity.getWindow();
            a();
        }
        if (this.f2038a != null) {
            if (activity.getResources().getConfiguration().orientation == 1) {
                this.f2038a.d(activity);
            } else {
                this.f2038a.c(activity);
            }
        }
    }

    public final void c(Activity activity) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new a(this, activity, 0));
    }

    public final void d(Activity activity) {
        if (this.f2038a == null) {
            activity.getWindow();
            a();
        }
        d dVar = this.f2038a;
        if (dVar != null) {
            dVar.e(activity);
        }
    }

    public final void e(Activity activity) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new a(this, activity, 1));
    }
}

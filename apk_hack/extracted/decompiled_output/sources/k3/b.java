package k3;

import android.app.Activity;
import android.view.Window;
import com.bumptech.glide.d;
import com.bumptech.glide.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends d {
    public Class b;

    @Override // com.bumptech.glide.d
    public final void b(Activity activity) {
        super.b(activity);
        if (h(activity.getWindow())) {
            e.h(activity.getWindow());
        }
    }

    @Override // com.bumptech.glide.d
    public final void d(Activity activity) {
        b(activity);
    }

    @Override // com.bumptech.glide.d
    public final int f(Window window) {
        if (!h(window)) {
            return 0;
        }
        return e.c(window.getContext());
    }

    @Override // com.bumptech.glide.d
    public final boolean h(Window window) {
        if (window == null) {
            return false;
        }
        try {
            Class<?> loadClass = window.getContext().getClassLoader().loadClass("android.util.FtFeature");
            this.b = loadClass;
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(this.b, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }
}

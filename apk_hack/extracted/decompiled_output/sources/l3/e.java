package l3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import j0.s;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends d {

    /* renamed from: n  reason: collision with root package name */
    public static final int f2722n = h.small_id;

    /* renamed from: o  reason: collision with root package name */
    public static final int f2723o = h.full_id;

    /* renamed from: p  reason: collision with root package name */
    public static e f2724p;

    public static boolean b(Context context) {
        if (((ViewGroup) CommonUtil.scanForActivity(context).findViewById(16908290)).findViewById(f2723o) != null) {
            CommonUtil.hideNavKey(context);
            if (c().lastListener() != null) {
                c().lastListener().onBackFullscreen();
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, l3.d, l3.e] */
    public static synchronized e c() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f2724p == null) {
                    ?? dVar = new d();
                    dVar.b = new s(dVar, Looper.getMainLooper(), 1);
                    dVar.c = new Handler();
                    f2724p = dVar;
                }
                eVar = f2724p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }
}

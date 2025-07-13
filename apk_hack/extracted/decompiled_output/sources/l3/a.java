package l3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import j0.s;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends d {

    /* renamed from: n  reason: collision with root package name */
    public static final int f2707n = h.ad_small_id;

    /* renamed from: o  reason: collision with root package name */
    public static final int f2708o = h.ad_full_id;

    /* renamed from: p  reason: collision with root package name */
    public static a f2709p;

    public static boolean b(Context context) {
        if (((ViewGroup) CommonUtil.scanForActivity(context).findViewById(16908290)).findViewById(f2708o) != null) {
            CommonUtil.hideNavKey(context);
            if (c().lastListener() != null) {
                c().lastListener().onBackFullscreen();
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, l3.a, l3.d] */
    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f2709p == null) {
                    ?? dVar = new d();
                    dVar.b = new s(dVar, Looper.getMainLooper(), 1);
                    dVar.c = new Handler();
                    f2709p = dVar;
                }
                aVar = f2709p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }
}

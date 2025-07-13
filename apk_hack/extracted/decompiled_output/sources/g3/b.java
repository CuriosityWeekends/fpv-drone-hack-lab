package g3;

import android.content.Context;
import com.tencent.bugly.proguard.c0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f1971a = false;
    public static volatile long b;
    public static volatile Thread c;

    static {
        System.loadLibrary("opencv_api");
    }

    public static void a(Context context, a aVar) {
        if (b == 0 && !f1971a) {
            f1971a = true;
            new Thread(new c0(4, context, aVar, false)).start();
        }
    }
}

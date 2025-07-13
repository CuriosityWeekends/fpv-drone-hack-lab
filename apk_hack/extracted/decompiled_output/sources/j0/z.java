package j0;

import java.util.HashSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class z {

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet f2368a = new HashSet();
    public static String b = "goog.exo.core";

    public static synchronized void a(String str) {
        synchronized (z.class) {
            if (f2368a.add(str)) {
                b += ", " + str;
            }
        }
    }
}

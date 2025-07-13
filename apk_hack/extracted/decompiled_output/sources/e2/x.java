package e2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1755a = new HashMap();
    public Map b;

    public final synchronized Map a() {
        try {
            if (this.b == null) {
                this.b = Collections.unmodifiableMap(new HashMap(this.f1755a));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    public final synchronized void b(String str, String str2) {
        this.b = null;
        this.f1755a.put(str, str2);
    }
}

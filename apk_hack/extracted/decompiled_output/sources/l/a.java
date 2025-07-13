package l;

import com.tencent.bugly.proguard.l0;
import java.util.concurrent.ThreadFactory;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f2503a;
    public final boolean b;
    public int c;

    public a(String str, boolean z3) {
        this.f2503a = str;
        this.b = z3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final synchronized Thread newThread(Runnable runnable) {
        l0 l0Var;
        l0Var = new l0(this, runnable, "glide-" + this.f2503a + "-thread-" + this.c);
        this.c = this.c + 1;
        return l0Var;
    }
}

package m;

import java.util.ArrayDeque;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o {
    public static final ArrayDeque d;

    /* renamed from: a  reason: collision with root package name */
    public int f2747a;
    public int b;
    public Object c;

    static {
        char[] cArr = c0.n.f199a;
        d = new ArrayDeque(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static o a(Object obj) {
        o oVar;
        o oVar2;
        ArrayDeque arrayDeque = d;
        synchronized (arrayDeque) {
            oVar = (o) arrayDeque.poll();
            oVar2 = oVar;
        }
        if (oVar == null) {
            oVar2 = new Object();
        }
        oVar2.c = obj;
        oVar2.b = 0;
        oVar2.f2747a = 0;
        return oVar2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.b != oVar.b || this.f2747a != oVar.f2747a || !this.c.equals(oVar.c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.c.hashCode() + (((this.f2747a * 31) + this.b) * 31);
    }
}

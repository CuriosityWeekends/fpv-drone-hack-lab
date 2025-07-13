package j0;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements y0.w {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2205a;
    public boolean b;
    public Object c;
    public Object d;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r4 != Long.MAX_VALUE) goto L12;
     */
    @Override // y0.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(c0.b r11) {
        /*
            r10 = this;
            boolean r0 = r10.b
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 != 0) goto L2f
            java.lang.Object r0 = r10.c
            g2.u r0 = (g2.u) r0
            long r3 = r0.c()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L16
            return
        L16:
            java.lang.Object r0 = r10.d
            p0.u r0 = (p0.u) r0
            java.lang.Object r3 = r10.c
            g2.u r3 = (g2.u) r3
            long r3 = r3.c()
            r5 = 0
            java.lang.String r6 = "application/x-scte35"
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.n(r3, r5, r6)
            r0.d(r3)
            r0 = 1
            r10.b = r0
        L2f:
            int r7 = r11.a()
            java.lang.Object r0 = r10.d
            p0.u r0 = (p0.u) r0
            r0.b(r7, r11)
            java.lang.Object r11 = r10.d
            r3 = r11
            p0.u r3 = (p0.u) r3
            java.lang.Object r11 = r10.c
            g2.u r11 = (g2.u) r11
            long r4 = r11.c
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 == 0) goto L51
            long r0 = r11.c
            long r4 = r11.b
            long r1 = r0 + r4
        L4f:
            r4 = r1
            goto L5c
        L51:
            long r4 = r11.f1958a
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r11 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r11 == 0) goto L4f
        L5c:
            r9 = 0
            r6 = 1
            r8 = 0
            r3.c(r4, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.b.a(c0.b):void");
    }

    public void b() {
        this.b = false;
        this.c = null;
        this.d = null;
    }

    @Override // y0.w
    public void c(g2.u uVar, p0.k kVar, y0.c0 c0Var) {
        this.c = uVar;
        c0Var.a();
        c0Var.b();
        p0.u g5 = kVar.g(c0Var.d, 4);
        this.d = g5;
        c0Var.b();
        g5.d(Format.o(c0Var.f4054e, "application/x-scte35"));
    }

    public boolean d(y.c cVar) {
        boolean z3 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = ((Set) this.c).remove(cVar);
        if (!((ArrayList) this.d).remove(cVar) && !remove) {
            z3 = false;
        }
        if (z3) {
            cVar.clear();
        }
        return z3;
    }

    public void e() {
        Iterator it = c0.n.d((Set) this.c).iterator();
        while (it.hasNext()) {
            y.c cVar = (y.c) it.next();
            if (!cVar.i() && !cVar.e()) {
                cVar.clear();
                if (!this.b) {
                    cVar.g();
                } else {
                    ((ArrayList) this.d).add(cVar);
                }
            }
        }
    }

    public String toString() {
        switch (this.f2205a) {
            case 3:
                return super.toString() + "{numRequests=" + ((Set) this.c).size() + ", isPaused=" + this.b + "}";
            default:
                return super.toString();
        }
    }

    public b() {
        this.f2205a = 3;
        this.c = Collections.newSetFromMap(new WeakHashMap());
        this.d = new ArrayList();
    }

    public b(Context context, Handler handler, p0 p0Var) {
        this.f2205a = 0;
        this.c = context.getApplicationContext();
        this.d = new a(this, handler, p0Var);
    }
}

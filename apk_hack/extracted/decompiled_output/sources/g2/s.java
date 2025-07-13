package g2;

import android.os.SystemClock;
import j0.h0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s implements j {

    /* renamed from: a  reason: collision with root package name */
    public long f1955a;
    public long b;
    public boolean c;
    public Object d;

    /* renamed from: e  reason: collision with root package name */
    public Object f1956e;

    public s(int i3, long j2) {
        this.f1955a = j2;
        this.b = j2 + i3;
    }

    @Override // g2.j
    public h0 a() {
        return (h0) this.f1956e;
    }

    @Override // g2.j
    public void b(h0 h0Var) {
        if (this.c) {
            d(c());
        }
        this.f1956e = h0Var;
    }

    @Override // g2.j
    public long c() {
        long j2;
        long j5 = this.f1955a;
        if (this.c) {
            ((t) this.d).getClass();
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.b;
            h0 h0Var = (h0) this.f1956e;
            if (h0Var.f2255a == 1.0f) {
                j2 = j0.i.a(elapsedRealtime);
            } else {
                j2 = elapsedRealtime * h0Var.d;
            }
            return j5 + j2;
        }
        return j5;
    }

    public void d(long j2) {
        this.f1955a = j2;
        if (this.c) {
            ((t) this.d).getClass();
            this.b = SystemClock.elapsedRealtime();
        }
    }

    public void e() {
        if (!this.c) {
            ((t) this.d).getClass();
            this.b = SystemClock.elapsedRealtime();
            this.c = true;
        }
    }
}

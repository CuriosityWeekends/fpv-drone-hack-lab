package j0;

import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f2246a;
    public n0 c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f2247e;

    /* renamed from: f  reason: collision with root package name */
    public j1.j0 f2248f;

    /* renamed from: g  reason: collision with root package name */
    public Format[] f2249g;

    /* renamed from: h  reason: collision with root package name */
    public long f2250h;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2252j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2253k;
    public final b b = new b(1);

    /* renamed from: i  reason: collision with root package name */
    public long f2251i = Long.MIN_VALUE;

    public h(int i3) {
        this.f2246a = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j0.n d(java.lang.Exception r10, com.google.android.exoplayer2.Format r11) {
        /*
            r9 = this;
            r0 = 4
            if (r11 == 0) goto L1a
            boolean r1 = r9.f2253k
            if (r1 != 0) goto L1a
            r1 = 1
            r9.f2253k = r1
            r1 = 0
            int r2 = r9.u(r11)     // Catch: java.lang.Throwable -> L14 j0.n -> L18
            r2 = r2 & 7
            r9.f2253k = r1
            goto L1b
        L14:
            r10 = move-exception
            r9.f2253k = r1
            throw r10
        L18:
            r9.f2253k = r1
        L1a:
            r2 = 4
        L1b:
            int r6 = r9.d
            j0.n r1 = new j0.n
            if (r11 != 0) goto L23
            r8 = 4
            goto L24
        L23:
            r8 = r2
        L24:
            r4 = 1
            r3 = r1
            r5 = r10
            r7 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.h.d(java.lang.Exception, com.google.android.exoplayer2.Format):j0.n");
    }

    public g2.j e() {
        return null;
    }

    public final boolean g() {
        if (this.f2251i == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public abstract boolean h();

    public abstract boolean i();

    public abstract void j();

    public abstract void l(long j2, boolean z3);

    public abstract void p(Format[] formatArr, long j2);

    public final int q(b bVar, m0.d dVar, boolean z3) {
        int c = this.f2248f.c(bVar, dVar, z3);
        if (c == -4) {
            if (dVar.isEndOfStream()) {
                this.f2251i = Long.MIN_VALUE;
                if (this.f2252j) {
                    return -4;
                }
                return -3;
            }
            long j2 = dVar.c + this.f2250h;
            dVar.c = j2;
            this.f2251i = Math.max(this.f2251i, j2);
        } else if (c == -5) {
            Format format = (Format) bVar.d;
            long j5 = format.f315m;
            if (j5 != Long.MAX_VALUE) {
                bVar.d = format.h(j5 + this.f2250h);
            }
        }
        return c;
    }

    public abstract void r(long j2, long j5);

    public final void s() {
        boolean z3;
        if (this.f2247e == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        this.b.b();
        m();
    }

    public void t(float f4) {
    }

    public abstract int u(Format format);

    public int v() {
        return 0;
    }

    public void k(boolean z3) {
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
    }

    public void f(int i3, Object obj) {
    }
}

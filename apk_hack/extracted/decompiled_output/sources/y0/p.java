package y0;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p implements h {

    /* renamed from: a  reason: collision with root package name */
    public final String f4165a;
    public final c0.b b;
    public final g2.n c;
    public p0.u d;

    /* renamed from: e  reason: collision with root package name */
    public Format f4166e;

    /* renamed from: f  reason: collision with root package name */
    public String f4167f;

    /* renamed from: g  reason: collision with root package name */
    public int f4168g;

    /* renamed from: h  reason: collision with root package name */
    public int f4169h;

    /* renamed from: i  reason: collision with root package name */
    public int f4170i;

    /* renamed from: j  reason: collision with root package name */
    public int f4171j;

    /* renamed from: k  reason: collision with root package name */
    public long f4172k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4173l;

    /* renamed from: m  reason: collision with root package name */
    public int f4174m;

    /* renamed from: n  reason: collision with root package name */
    public int f4175n;

    /* renamed from: o  reason: collision with root package name */
    public int f4176o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4177p;
    public long q;

    /* renamed from: r  reason: collision with root package name */
    public int f4178r;
    public long s;

    /* renamed from: t  reason: collision with root package name */
    public int f4179t;

    public p(String str) {
        this.f4165a = str;
        c0.b bVar = new c0.b(1024);
        this.b = bVar;
        byte[] bArr = bVar.f187a;
        this.c = new g2.n(bArr, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0167, code lost:
        if (r25.f4173l == false) goto L102;
     */
    @Override // y0.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(c0.b r26) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.p.a(c0.b):void");
    }

    @Override // y0.h
    public final void b() {
        this.f4168g = 0;
        this.f4173l = false;
    }

    @Override // y0.h
    public final void c(int i3, long j2) {
        this.f4172k = j2;
    }

    @Override // y0.h
    public final void d(p0.k kVar, c0 c0Var) {
        c0Var.a();
        c0Var.b();
        this.d = kVar.g(c0Var.d, 1);
        c0Var.b();
        this.f4167f = c0Var.f4054e;
    }

    public final int f(g2.n nVar) {
        int b = nVar.b();
        Pair u5 = g2.b.u(nVar, true);
        this.f4178r = ((Integer) u5.first).intValue();
        this.f4179t = ((Integer) u5.second).intValue();
        return b - nVar.b();
    }

    @Override // y0.h
    public final void e() {
    }
}

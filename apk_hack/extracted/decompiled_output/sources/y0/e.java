package y0;

import com.google.android.exoplayer2.Format;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements h {

    /* renamed from: v  reason: collision with root package name */
    public static final byte[] f4061v = {73, 68, 51};

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4062a;
    public final String d;

    /* renamed from: e  reason: collision with root package name */
    public String f4063e;

    /* renamed from: f  reason: collision with root package name */
    public p0.u f4064f;

    /* renamed from: g  reason: collision with root package name */
    public p0.u f4065g;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4069k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4070l;

    /* renamed from: o  reason: collision with root package name */
    public int f4073o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4074p;

    /* renamed from: r  reason: collision with root package name */
    public int f4075r;
    public long s;

    /* renamed from: t  reason: collision with root package name */
    public p0.u f4076t;

    /* renamed from: u  reason: collision with root package name */
    public long f4077u;
    public final g2.n b = new g2.n(new byte[7], 7);
    public final c0.b c = new c0.b(Arrays.copyOf(f4061v, 10));

    /* renamed from: h  reason: collision with root package name */
    public int f4066h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f4067i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f4068j = 256;

    /* renamed from: m  reason: collision with root package name */
    public int f4071m = -1;

    /* renamed from: n  reason: collision with root package name */
    public int f4072n = -1;
    public long q = -9223372036854775807L;

    public e(String str, boolean z3) {
        this.f4062a = z3;
        this.d = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0245, code lost:
        r25.f4073o = (r7 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x024d, code lost:
        if ((r7 & 1) != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x024f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0251, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0252, code lost:
        r25.f4069k = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0256, code lost:
        if (r25.f4070l != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0258, code lost:
        r25.f4066h = 1;
        r25.f4067i = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x025e, code lost:
        r25.f4066h = 3;
        r25.f4067i = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0263, code lost:
        r26.y(r5);
     */
    @Override // y0.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(c0.b r26) {
        /*
            Method dump skipped, instructions count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.e.a(c0.b):void");
    }

    @Override // y0.h
    public final void b() {
        this.f4070l = false;
        this.f4066h = 0;
        this.f4067i = 0;
        this.f4068j = 256;
    }

    @Override // y0.h
    public final void c(int i3, long j2) {
        this.s = j2;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [p0.u, java.lang.Object] */
    @Override // y0.h
    public final void d(p0.k kVar, c0 c0Var) {
        c0Var.a();
        c0Var.b();
        this.f4063e = c0Var.f4054e;
        c0Var.b();
        this.f4064f = kVar.g(c0Var.d, 1);
        if (this.f4062a) {
            c0Var.a();
            c0Var.b();
            p0.u g5 = kVar.g(c0Var.d, 4);
            this.f4065g = g5;
            c0Var.b();
            g5.d(Format.o(c0Var.f4054e, "application/id3"));
            return;
        }
        this.f4065g = new Object();
    }

    @Override // y0.h
    public final void e() {
    }
}

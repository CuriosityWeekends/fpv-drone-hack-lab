package u0;

import com.google.android.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;
import p0.j;
import p0.k;
import p0.o;
import p0.p;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements j {

    /* renamed from: a  reason: collision with root package name */
    public final long f3730a;
    public final c0.b b;
    public final p c;
    public final o d;

    /* renamed from: e  reason: collision with root package name */
    public final b3.e f3731e;

    /* renamed from: f  reason: collision with root package name */
    public k f3732f;

    /* renamed from: g  reason: collision with root package name */
    public u f3733g;

    /* renamed from: h  reason: collision with root package name */
    public int f3734h;

    /* renamed from: i  reason: collision with root package name */
    public Metadata f3735i;

    /* renamed from: j  reason: collision with root package name */
    public e f3736j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3737k;

    /* renamed from: l  reason: collision with root package name */
    public long f3738l;

    /* renamed from: m  reason: collision with root package name */
    public long f3739m;

    /* renamed from: n  reason: collision with root package name */
    public long f3740n;

    /* renamed from: o  reason: collision with root package name */
    public int f3741o;

    public c() {
        this(-9223372036854775807L);
    }

    public final a a(p0.g gVar) {
        c0.b bVar = this.b;
        gVar.d(bVar.f187a, 0, 4, false);
        bVar.y(0);
        int c = bVar.c();
        p pVar = this.c;
        p.b(c, pVar);
        return new a(gVar.c, gVar.d, pVar.f3126f, pVar.c);
    }

    @Override // p0.j
    public final void b(k kVar) {
        this.f3732f = kVar;
        this.f3733g = kVar.g(0, 1);
        this.f3732f.c();
    }

    public final boolean c(p0.g gVar) {
        e eVar = this.f3736j;
        if (eVar != null) {
            long c = eVar.c();
            if (c != -1 && gVar.c() > c - 4) {
                return true;
            }
        }
        try {
            return !gVar.d(this.b.f187a, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        this.f3734h = 0;
        this.f3738l = -9223372036854775807L;
        this.f3739m = 0L;
        this.f3741o = 0;
    }

    public final boolean e(p0.g gVar, boolean z3) {
        int i3;
        int i5;
        int i6;
        int a5;
        if (z3) {
            i3 = 16384;
        } else {
            i3 = 131072;
        }
        gVar.f3111f = 0;
        if (gVar.d == 0) {
            Metadata F = this.f3731e.F(gVar, null);
            this.f3735i = F;
            if (F != null) {
                this.d.b(F);
            }
            i6 = (int) gVar.c();
            if (!z3) {
                gVar.h(i6);
            }
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (c(gVar)) {
                if (i7 <= 0) {
                    throw new EOFException();
                }
            } else {
                c0.b bVar = this.b;
                bVar.y(0);
                int c = bVar.c();
                if ((i5 != 0 && ((-128000) & c) != (i5 & (-128000))) || (a5 = p.a(c)) == -1) {
                    int i9 = i8 + 1;
                    if (i8 == i3) {
                        if (z3) {
                            return false;
                        }
                        throw new IOException("Searched too many bytes.");
                    }
                    if (z3) {
                        gVar.f3111f = 0;
                        gVar.a(i6 + i9, false);
                    } else {
                        gVar.h(1);
                    }
                    i8 = i9;
                    i5 = 0;
                    i7 = 0;
                } else {
                    i7++;
                    if (i7 == 1) {
                        p.b(c, this.c);
                        i5 = c;
                    } else if (i7 == 4) {
                        break;
                    }
                    gVar.a(a5 - 4, false);
                }
            }
        }
        if (z3) {
            gVar.h(i6 + i8);
        } else {
            gVar.f3111f = 0;
        }
        this.f3734h = i5;
        return true;
    }

    @Override // p0.j
    public final boolean f(p0.g gVar) {
        return e(gVar, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        if (r6 != 1231971951) goto L147;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0229  */
    /* JADX WARN: Type inference failed for: r2v27, types: [p0.n, u0.e] */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(p0.g r42, p0.m r43) {
        /*
            Method dump skipped, instructions count: 964
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.c.h(p0.g, p0.m):int");
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [p0.p, java.lang.Object] */
    public c(long j2) {
        this.f3730a = j2;
        this.b = new c0.b(10);
        this.c = new Object();
        this.d = new o();
        this.f3738l = -9223372036854775807L;
        this.f3731e = new b3.e(25);
    }
}

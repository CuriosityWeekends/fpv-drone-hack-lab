package j0;

import android.util.Log;
import com.google.android.exoplayer2.source.TrackGroupArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final j1.m f2207a;
    public final Object b;
    public final j1.j0[] c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2208e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f2209f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean[] f2210g;

    /* renamed from: h  reason: collision with root package name */
    public final h[] f2211h;

    /* renamed from: i  reason: collision with root package name */
    public final b2.l f2212i;

    /* renamed from: j  reason: collision with root package name */
    public final j1.p f2213j;

    /* renamed from: k  reason: collision with root package name */
    public c0 f2214k;

    /* renamed from: l  reason: collision with root package name */
    public TrackGroupArray f2215l;

    /* renamed from: m  reason: collision with root package name */
    public a2.l f2216m;

    /* renamed from: n  reason: collision with root package name */
    public long f2217n;

    public c0(h[] hVarArr, long j2, b2.l lVar, e2.m mVar, j1.p pVar, d0 d0Var, a2.l lVar2) {
        this.f2211h = hVarArr;
        this.f2217n = j2;
        this.f2212i = lVar;
        this.f2213j = pVar;
        j1.n nVar = d0Var.f2219a;
        this.b = nVar.f2454a;
        this.f2209f = d0Var;
        this.f2215l = TrackGroupArray.d;
        this.f2216m = lVar2;
        this.c = new j1.j0[hVarArr.length];
        this.f2210g = new boolean[hVarArr.length];
        j1.m a5 = pVar.a(nVar, mVar, d0Var.b);
        long j5 = d0Var.d;
        if (j5 != -9223372036854775807L && j5 != Long.MIN_VALUE) {
            a5 = new j1.d(a5, j5);
        }
        this.f2207a = a5;
    }

    public final long a(a2.l lVar, long j2, boolean z3, boolean[] zArr) {
        h[] hVarArr;
        Object[] objArr;
        boolean z5;
        int i3 = 0;
        while (true) {
            boolean z6 = true;
            if (i3 >= lVar.f81a) {
                break;
            }
            if (z3 || !lVar.c(this.f2216m, i3)) {
                z6 = false;
            }
            this.f2210g[i3] = z6;
            i3++;
        }
        int i5 = 0;
        while (true) {
            hVarArr = this.f2211h;
            int length = hVarArr.length;
            objArr = this.c;
            if (i5 >= length) {
                break;
            }
            if (hVarArr[i5].f2246a == 6) {
                objArr[i5] = null;
            }
            i5++;
        }
        b();
        this.f2216m = lVar;
        c();
        b2.o oVar = (b2.o) lVar.c;
        j1.j0[] j0VarArr = this.c;
        long z7 = this.f2207a.z((b2.n[]) oVar.b.clone(), this.f2210g, j0VarArr, zArr, j2);
        for (int i6 = 0; i6 < hVarArr.length; i6++) {
            if (hVarArr[i6].f2246a == 6 && this.f2216m.d(i6)) {
                objArr[i6] = new Object();
            }
        }
        this.f2208e = false;
        for (int i7 = 0; i7 < objArr.length; i7++) {
            if (objArr[i7] != null) {
                g2.b.h(lVar.d(i7));
                if (hVarArr[i7].f2246a != 6) {
                    this.f2208e = true;
                }
            } else {
                if (oVar.b[i7] == null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                g2.b.h(z5);
            }
        }
        return z7;
    }

    public final void b() {
        if (this.f2214k == null) {
            int i3 = 0;
            while (true) {
                a2.l lVar = this.f2216m;
                if (i3 < lVar.f81a) {
                    lVar.d(i3);
                    b2.n nVar = ((b2.o) this.f2216m.c).b[i3];
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public final void c() {
        if (this.f2214k == null) {
            int i3 = 0;
            while (true) {
                a2.l lVar = this.f2216m;
                if (i3 < lVar.f81a) {
                    boolean d = lVar.d(i3);
                    b2.n nVar = ((b2.o) this.f2216m.c).b[i3];
                    if (d && nVar != null) {
                        nVar.a();
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public final long d() {
        long j2;
        if (!this.d) {
            return this.f2209f.b;
        }
        if (this.f2208e) {
            j2 = this.f2207a.s();
        } else {
            j2 = Long.MIN_VALUE;
        }
        if (j2 == Long.MIN_VALUE) {
            return this.f2209f.f2220e;
        }
        return j2;
    }

    public final void e() {
        b();
        long j2 = this.f2209f.d;
        j1.p pVar = this.f2213j;
        j1.m mVar = this.f2207a;
        try {
            if (j2 != -9223372036854775807L && j2 != Long.MIN_VALUE) {
                pVar.c(((j1.d) mVar).f2376a);
            } else {
                pVar.c(mVar);
            }
        } catch (RuntimeException e5) {
            Log.e("MediaPeriodHolder", "Period release failed.", e5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:487:0x09df, code lost:
        if (r5 != 2) goto L594;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02b1 A[LOOP:8: B:65:0x0182->B:109:0x02b1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x02ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a2.l f(float r50) {
        /*
            Method dump skipped, instructions count: 2658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.c0.f(float):a2.l");
    }
}

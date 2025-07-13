package l1;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import e2.b0;
import e2.c0;
import e2.d0;
import e2.f0;
import e2.z;
import j1.i0;
import j1.j0;
import j1.k0;
import j1.l0;
import j1.u;
import j1.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.q;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements j0, l0, z, d0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f2653a;
    public final int[] b;
    public final Format[] c;
    public final boolean[] d;

    /* renamed from: e  reason: collision with root package name */
    public final h f2654e;

    /* renamed from: f  reason: collision with root package name */
    public final k0 f2655f;

    /* renamed from: g  reason: collision with root package name */
    public final u f2656g;

    /* renamed from: h  reason: collision with root package name */
    public final j3.a f2657h;

    /* renamed from: i  reason: collision with root package name */
    public final f0 f2658i = new f0("Loader:ChunkSampleStream");

    /* renamed from: j  reason: collision with root package name */
    public final i.k0 f2659j = new Object();

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f2660k;

    /* renamed from: l  reason: collision with root package name */
    public final List f2661l;

    /* renamed from: m  reason: collision with root package name */
    public final i0 f2662m;

    /* renamed from: n  reason: collision with root package name */
    public final i0[] f2663n;

    /* renamed from: o  reason: collision with root package name */
    public final c1.b f2664o;

    /* renamed from: p  reason: collision with root package name */
    public Format f2665p;
    public f q;

    /* renamed from: r  reason: collision with root package name */
    public long f2666r;
    public long s;

    /* renamed from: t  reason: collision with root package name */
    public int f2667t;

    /* renamed from: u  reason: collision with root package name */
    public long f2668u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2669v;

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, i.k0] */
    public g(int i3, int[] iArr, Format[] formatArr, h hVar, k0 k0Var, e2.m mVar, long j2, n0.b bVar, j3.a aVar, u uVar) {
        int length;
        this.f2653a = i3;
        this.b = iArr;
        this.c = formatArr;
        this.f2654e = hVar;
        this.f2655f = k0Var;
        this.f2656g = uVar;
        this.f2657h = aVar;
        ArrayList arrayList = new ArrayList();
        this.f2660k = arrayList;
        this.f2661l = Collections.unmodifiableList(arrayList);
        int i5 = 0;
        if (iArr == null) {
            length = 0;
        } else {
            length = iArr.length;
        }
        this.f2663n = new i0[length];
        this.d = new boolean[length];
        int i6 = length + 1;
        int[] iArr2 = new int[i6];
        i0[] i0VarArr = new i0[i6];
        i0 i0Var = new i0(mVar, bVar);
        this.f2662m = i0Var;
        iArr2[0] = i3;
        i0VarArr[0] = i0Var;
        while (i5 < length) {
            i0 i0Var2 = new i0(mVar, n0.b.f2912a);
            this.f2663n[i5] = i0Var2;
            int i7 = i5 + 1;
            i0VarArr[i7] = i0Var2;
            iArr2[i7] = iArr[i5];
            i5 = i7;
        }
        this.f2664o = new c1.b(14, iArr2, i0VarArr, false);
        this.f2666r = j2;
        this.s = j2;
    }

    @Override // j1.l0
    public final void A(long j2) {
        ArrayList arrayList;
        int size;
        int f4;
        f0 f0Var = this.f2658i;
        if (f0Var.c() || f0Var.b() || p() || (size = (arrayList = this.f2660k).size()) <= (f4 = this.f2654e.f(this.f2661l, j2))) {
            return;
        }
        while (true) {
            if (f4 < size) {
                if (!n(f4)) {
                    break;
                }
                f4++;
            } else {
                f4 = size;
                break;
            }
        }
        if (f4 == size) {
            return;
        }
        long j5 = m().f2640g;
        a h5 = h(f4);
        if (arrayList.isEmpty()) {
            this.f2666r = this.s;
        }
        this.f2669v = false;
        long j6 = h5.f2639f;
        u uVar = this.f2656g;
        uVar.r(new w(1, this.f2653a, null, 3, null, uVar.a(j6), uVar.a(j5)));
    }

    public final void B(long j2) {
        a aVar;
        boolean z3;
        boolean B;
        this.s = j2;
        if (p()) {
            this.f2666r = j2;
            return;
        }
        for (int i3 = 0; i3 < this.f2660k.size(); i3++) {
            aVar = (a) this.f2660k.get(i3);
            int i5 = (aVar.f2639f > j2 ? 1 : (aVar.f2639f == j2 ? 0 : -1));
            if (i5 == 0 && aVar.f2633j == -9223372036854775807L) {
                break;
            } else if (i5 > 0) {
                break;
            }
        }
        aVar = null;
        if (aVar != null) {
            i0 i0Var = this.f2662m;
            int i6 = aVar.f2636m[0];
            synchronized (i0Var) {
                i0Var.A();
                int i7 = i0Var.f2430p;
                if (i6 >= i7 && i6 <= i0Var.f2429o + i7) {
                    i0Var.f2431r = i6 - i7;
                    B = true;
                }
                B = false;
            }
            this.f2668u = 0L;
        } else {
            i0 i0Var2 = this.f2662m;
            if (j2 < i()) {
                z3 = true;
            } else {
                z3 = false;
            }
            B = i0Var2.B(j2, z3);
            this.f2668u = this.s;
        }
        if (B) {
            this.f2667t = v(this.f2662m.q(), 0);
            for (i0 i0Var3 : this.f2663n) {
                i0Var3.B(j2, true);
            }
            return;
        }
        this.f2666r = j2;
        this.f2669v = false;
        this.f2660k.clear();
        this.f2667t = 0;
        if (this.f2658i.c()) {
            b0 b0Var = (b0) this.f2658i.b;
            g2.b.i(b0Var);
            b0Var.a(false);
            return;
        }
        this.f2658i.c = null;
        this.f2662m.z(false);
        for (i0 i0Var4 : this.f2663n) {
            i0Var4.z(false);
        }
    }

    @Override // j1.j0
    public final void a() {
        f0 f0Var = this.f2658i;
        f0Var.a();
        b3.e eVar = this.f2662m.f2420f;
        if (eVar == null) {
            if (!f0Var.c()) {
                this.f2654e.a();
                return;
            }
            return;
        }
        e2.b bVar = (e2.b) eVar.b;
        bVar.getClass();
        throw bVar;
    }

    @Override // j1.j0
    public final int c(j0.b bVar, m0.d dVar, boolean z3) {
        if (p()) {
            return -3;
        }
        r();
        return this.f2662m.y(bVar, dVar, z3, this.f2669v, this.f2668u);
    }

    @Override // j1.l0
    public final boolean d() {
        return this.f2658i.c();
    }

    @Override // e2.d0
    public final void e() {
        i0[] i0VarArr;
        i0 i0Var = this.f2662m;
        i0Var.z(true);
        if (i0Var.f2420f != null) {
            i0Var.f2420f = null;
            i0Var.f2419e = null;
        }
        for (i0 i0Var2 : this.f2663n) {
            i0Var2.z(true);
            if (i0Var2.f2420f != null) {
                i0Var2.f2420f = null;
                i0Var2.f2419e = null;
            }
        }
        f fVar = this.q;
        if (fVar != null) {
            m1.b bVar = (m1.b) fVar;
            synchronized (bVar) {
                q qVar = (q) bVar.f2777m.remove(this);
                if (qVar != null) {
                    i0 i0Var3 = qVar.f2830a;
                    i0Var3.z(true);
                    if (i0Var3.f2420f != null) {
                        i0Var3.f2420f = null;
                        i0Var3.f2419e = null;
                    }
                }
            }
        }
    }

    @Override // e2.z
    public final void f(c0 c0Var, long j2, long j5, boolean z3) {
        b bVar = (b) c0Var;
        e2.l lVar = bVar.f2637a;
        Uri uri = bVar.f2641h.c;
        this.f2656g.d(bVar.b, this.f2653a, bVar.c, bVar.d, bVar.f2638e, bVar.f2639f, bVar.f2640g);
        if (!z3) {
            this.f2662m.z(false);
            for (i0 i0Var : this.f2663n) {
                i0Var.z(false);
            }
            this.f2655f.e(this);
        }
    }

    @Override // j1.j0
    public final int g(long j2) {
        int e5;
        if (p()) {
            return 0;
        }
        boolean z3 = this.f2669v;
        i0 i0Var = this.f2662m;
        if (z3 && j2 > i0Var.o()) {
            e5 = i0Var.f();
        } else {
            e5 = i0Var.e(j2);
        }
        r();
        return e5;
    }

    public final a h(int i3) {
        ArrayList arrayList = this.f2660k;
        a aVar = (a) arrayList.get(i3);
        g2.w.z(arrayList, i3, arrayList.size());
        this.f2667t = Math.max(this.f2667t, arrayList.size());
        int i5 = 0;
        this.f2662m.l(aVar.f2636m[0]);
        while (true) {
            i0[] i0VarArr = this.f2663n;
            if (i5 < i0VarArr.length) {
                i0 i0Var = i0VarArr[i5];
                i5++;
                i0Var.l(aVar.f2636m[i5]);
            } else {
                return aVar;
            }
        }
    }

    @Override // j1.l0
    public final long i() {
        if (p()) {
            return this.f2666r;
        }
        if (this.f2669v) {
            return Long.MIN_VALUE;
        }
        return m().f2640g;
    }

    @Override // j1.j0
    public final boolean isReady() {
        if (!p() && this.f2662m.u(this.f2669v)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    @Override // e2.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e2.a0 k(e2.c0 r30, long r31, long r33, java.io.IOException r35, int r36) {
        /*
            r29 = this;
            r0 = r29
            r7 = r30
            l1.b r7 = (l1.b) r7
            e2.k0 r1 = r7.f2641h
            long r1 = r1.b
            boolean r8 = r7 instanceof l1.a
            java.util.ArrayList r9 = r0.f2660k
            int r3 = r9.size()
            r10 = 1
            int r11 = r3 + (-1)
            r3 = 0
            r12 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L27
            if (r8 == 0) goto L27
            boolean r1 = r0.n(r11)
            if (r1 != 0) goto L25
            goto L27
        L25:
            r13 = 0
            goto L28
        L27:
            r13 = 1
        L28:
            j3.a r14 = r0.f2657h
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r13 == 0) goto L3a
            r14.getClass()
            long r1 = j3.a.k(r35)
            r5 = r1
            goto L3b
        L3a:
            r5 = r15
        L3b:
            l1.h r1 = r0.f2654e
            r2 = r7
            r3 = r13
            r4 = r35
            boolean r1 = r1.c(r2, r3, r4, r5)
            if (r1 == 0) goto L6b
            if (r13 == 0) goto L64
            e2.a0 r1 = e2.f0.d
            if (r8 == 0) goto L6c
            l1.a r2 = r0.h(r11)
            if (r2 != r7) goto L55
            r2 = 1
            goto L56
        L55:
            r2 = 0
        L56:
            g2.b.h(r2)
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L6c
            long r2 = r0.s
            r0.f2666r = r2
            goto L6c
        L64:
            java.lang.String r1 = "ChunkSampleStream"
            java.lang.String r2 = "Ignoring attempt to cancel non-cancelable load."
            android.util.Log.w(r1, r2)
        L6b:
            r1 = 0
        L6c:
            if (r1 != 0) goto L86
            r14.getClass()
            r2 = r35
            r1 = r36
            long r3 = j3.a.m(r1, r2)
            int r1 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r1 == 0) goto L83
            e2.a0 r1 = new e2.a0
            r1.<init>(r12, r3)
            goto L88
        L83:
            e2.a0 r1 = e2.f0.f1685e
            goto L88
        L86:
            r2 = r35
        L88:
            boolean r3 = r1.a()
            r3 = r3 ^ r10
            e2.k0 r4 = r7.f2641h
            android.net.Uri r4 = r4.c
            long r4 = r7.f2639f
            long r8 = r7.f2640g
            j1.u r6 = r0.f2656g
            int r10 = r7.b
            int r11 = r0.f2653a
            com.google.android.exoplayer2.Format r12 = r7.c
            int r13 = r7.d
            java.lang.Object r7 = r7.f2638e
            r17 = r6
            r18 = r10
            r19 = r11
            r20 = r12
            r21 = r13
            r22 = r7
            r23 = r4
            r25 = r8
            r27 = r35
            r28 = r3
            r17.i(r18, r19, r20, r21, r22, r23, r25, r27, r28)
            if (r3 == 0) goto Lbf
            j1.k0 r2 = r0.f2655f
            r2.e(r0)
        Lbf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.g.k(e2.c0, long, long, java.io.IOException, int):e2.a0");
    }

    @Override // e2.z
    public final void l(c0 c0Var, long j2, long j5) {
        b bVar = (b) c0Var;
        this.f2654e.d(bVar);
        e2.l lVar = bVar.f2637a;
        Uri uri = bVar.f2641h.c;
        this.f2656g.f(bVar.b, this.f2653a, bVar.c, bVar.d, bVar.f2638e, bVar.f2639f, bVar.f2640g);
        this.f2655f.e(this);
    }

    public final a m() {
        ArrayList arrayList = this.f2660k;
        return (a) arrayList.get(arrayList.size() - 1);
    }

    public final boolean n(int i3) {
        int q;
        a aVar = (a) this.f2660k.get(i3);
        if (this.f2662m.q() > aVar.f2636m[0]) {
            return true;
        }
        int i5 = 0;
        do {
            i0[] i0VarArr = this.f2663n;
            if (i5 >= i0VarArr.length) {
                return false;
            }
            q = i0VarArr[i5].q();
            i5++;
        } while (q <= aVar.f2636m[i5]);
        return true;
    }

    public final boolean p() {
        if (this.f2666r != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    public final void r() {
        int v5 = v(this.f2662m.q(), this.f2667t - 1);
        while (true) {
            int i3 = this.f2667t;
            if (i3 <= v5) {
                this.f2667t = i3 + 1;
                a aVar = (a) this.f2660k.get(i3);
                Format format = aVar.c;
                if (!format.equals(this.f2665p)) {
                    this.f2656g.b(this.f2653a, format, aVar.d, aVar.f2638e, aVar.f2639f);
                }
                this.f2665p = format;
            } else {
                return;
            }
        }
    }

    @Override // j1.l0
    public final long s() {
        if (this.f2669v) {
            return Long.MIN_VALUE;
        }
        if (p()) {
            return this.f2666r;
        }
        long j2 = this.s;
        a m5 = m();
        if (!m5.d()) {
            ArrayList arrayList = this.f2660k;
            if (arrayList.size() > 1) {
                m5 = (a) arrayList.get(arrayList.size() - 2);
            } else {
                m5 = null;
            }
        }
        if (m5 != null) {
            j2 = Math.max(j2, m5.f2640g);
        }
        return Math.max(j2, this.f2662m.o());
    }

    public final void u(long j2, boolean z3) {
        long j5;
        if (p()) {
            return;
        }
        i0 i0Var = this.f2662m;
        int i3 = i0Var.f2430p;
        i0Var.i(j2, z3, true);
        i0 i0Var2 = this.f2662m;
        int i5 = i0Var2.f2430p;
        if (i5 > i3) {
            synchronized (i0Var2) {
                if (i0Var2.f2429o == 0) {
                    j5 = Long.MIN_VALUE;
                } else {
                    j5 = i0Var2.f2426l[i0Var2.q];
                }
            }
            int i6 = 0;
            while (true) {
                i0[] i0VarArr = this.f2663n;
                if (i6 >= i0VarArr.length) {
                    break;
                }
                i0VarArr[i6].i(j5, z3, this.d[i6]);
                i6++;
            }
        }
        int min = Math.min(v(i5, 0), this.f2667t);
        if (min > 0) {
            g2.w.z(this.f2660k, 0, min);
            this.f2667t -= min;
        }
    }

    public final int v(int i3, int i5) {
        ArrayList arrayList;
        do {
            i5++;
            arrayList = this.f2660k;
            if (i5 >= arrayList.size()) {
                return arrayList.size() - 1;
            }
        } while (((a) arrayList.get(i5)).f2636m[0] <= i3);
        return i5 - 1;
    }

    public final void x(f fVar) {
        i0[] i0VarArr;
        this.q = fVar;
        i0 i0Var = this.f2662m;
        i0Var.j();
        if (i0Var.f2420f != null) {
            i0Var.f2420f = null;
            i0Var.f2419e = null;
        }
        for (i0 i0Var2 : this.f2663n) {
            i0Var2.j();
            if (i0Var2.f2420f != null) {
                i0Var2.f2420f = null;
                i0Var2.f2419e = null;
            }
        }
        this.f2658i.d(this);
    }

    @Override // j1.l0
    public final boolean y(long j2) {
        long j5;
        List list;
        if (!this.f2669v) {
            f0 f0Var = this.f2658i;
            if (!f0Var.c() && !f0Var.b()) {
                boolean p5 = p();
                if (p5) {
                    list = Collections.emptyList();
                    j5 = this.f2666r;
                } else {
                    j5 = m().f2640g;
                    list = this.f2661l;
                }
                this.f2654e.e(j2, j5, list, this.f2659j);
                i.k0 k0Var = this.f2659j;
                boolean z3 = k0Var.f2107a;
                b bVar = (b) k0Var.b;
                k0Var.b = null;
                k0Var.f2107a = false;
                if (z3) {
                    this.f2666r = -9223372036854775807L;
                    this.f2669v = true;
                    return true;
                } else if (bVar == null) {
                    return false;
                } else {
                    boolean z5 = bVar instanceof a;
                    c1.b bVar2 = this.f2664o;
                    if (z5) {
                        a aVar = (a) bVar;
                        if (p5) {
                            long j6 = this.f2666r;
                            if (aVar.f2639f == j6) {
                                j6 = 0;
                            }
                            this.f2668u = j6;
                            this.f2666r = -9223372036854775807L;
                        }
                        aVar.f2635l = bVar2;
                        i0[] i0VarArr = (i0[]) bVar2.c;
                        int[] iArr = new int[i0VarArr.length];
                        for (int i3 = 0; i3 < i0VarArr.length; i3++) {
                            i0 i0Var = i0VarArr[i3];
                            if (i0Var != null) {
                                iArr[i3] = i0Var.f2430p + i0Var.f2429o;
                            }
                        }
                        aVar.f2636m = iArr;
                        this.f2660k.add(aVar);
                    } else if (bVar instanceof j) {
                        ((j) bVar).f2677j = bVar2;
                    }
                    f0Var.e(bVar, this, this.f2657h.l(bVar.b));
                    this.f2656g.l(bVar.f2637a, bVar.b, this.f2653a, bVar.c, bVar.d, bVar.f2638e, bVar.f2639f, bVar.f2640g);
                    return true;
                }
            }
        }
        return false;
    }
}

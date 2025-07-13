package j1;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d0 implements m, p0.k, e2.z, e2.d0, h0 {
    public static final Map M;
    public static final Format N;
    public boolean A;
    public boolean B;
    public int C;
    public boolean F;
    public long G;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f2378a;
    public final e2.i b;
    public final n0.b c;
    public final j3.a d;

    /* renamed from: e  reason: collision with root package name */
    public final u f2379e;

    /* renamed from: f  reason: collision with root package name */
    public final e0 f2380f;

    /* renamed from: g  reason: collision with root package name */
    public final e2.m f2381g;

    /* renamed from: i  reason: collision with root package name */
    public final long f2383i;

    /* renamed from: k  reason: collision with root package name */
    public final c1.b f2385k;

    /* renamed from: p  reason: collision with root package name */
    public l f2390p;
    public p0.r q;

    /* renamed from: r  reason: collision with root package name */
    public IcyHeaders f2391r;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2393u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2394v;
    public a0 w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f2395x;

    /* renamed from: z  reason: collision with root package name */
    public boolean f2397z;

    /* renamed from: h  reason: collision with root package name */
    public final String f2382h = null;

    /* renamed from: j  reason: collision with root package name */
    public final e2.f0 f2384j = new e2.f0("Loader:ProgressiveMediaPeriod");

    /* renamed from: l  reason: collision with root package name */
    public final g2.d f2386l = new Object();

    /* renamed from: m  reason: collision with root package name */
    public final y f2387m = new Runnable(this) { // from class: j1.y
        public final /* synthetic */ d0 b;

        {
            this.b = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z3;
            int i3;
            boolean z5;
            Metadata metadata;
            int i5;
            d0 d0Var = this.b;
            int i6 = 0;
            int i7 = 1;
            switch (r2) {
                case 0:
                    p0.r rVar = d0Var.q;
                    if (!d0Var.L && !d0Var.f2394v && d0Var.f2393u && rVar != null) {
                        for (i0 i0Var : d0Var.s) {
                            if (i0Var.s() == null) {
                                return;
                            }
                        }
                        d0Var.f2386l.a();
                        int length = d0Var.s.length;
                        TrackGroup[] trackGroupArr = new TrackGroup[length];
                        boolean[] zArr = new boolean[length];
                        d0Var.D = rVar.i();
                        int i8 = 0;
                        while (i8 < length) {
                            Format s = d0Var.s[i8].s();
                            String str = s.f311i;
                            boolean g5 = g2.k.g(str);
                            if (!g5 && !g2.k.h(str)) {
                                z5 = false;
                            } else {
                                z5 = true;
                            }
                            zArr[i8] = z5;
                            d0Var.f2395x = z5 | d0Var.f2395x;
                            IcyHeaders icyHeaders = d0Var.f2391r;
                            if (icyHeaders != null) {
                                if (g5 || d0Var.f2392t[i8].b) {
                                    Metadata metadata2 = s.f309g;
                                    if (metadata2 == null) {
                                        Metadata.Entry[] entryArr = new Metadata.Entry[i7];
                                        entryArr[i6] = icyHeaders;
                                        metadata = new Metadata(entryArr);
                                    } else {
                                        Metadata.Entry[] entryArr2 = new Metadata.Entry[i7];
                                        entryArr2[i6] = icyHeaders;
                                        int i9 = g2.w.f1960a;
                                        Metadata.Entry[] entryArr3 = metadata2.f330a;
                                        Object[] copyOf = Arrays.copyOf(entryArr3, entryArr3.length + i7);
                                        System.arraycopy(entryArr2, i6, copyOf, entryArr3.length, i7);
                                        metadata = new Metadata((Metadata.Entry[]) copyOf);
                                    }
                                    s = s.c(s.f314l, metadata);
                                }
                                if (g5 && s.f307e == -1 && (i5 = icyHeaders.f351a) != -1) {
                                    s = new Format(s.f306a, s.b, s.c, s.d, i5, s.f308f, s.f309g, s.f310h, s.f311i, s.f312j, s.f313k, s.f314l, s.f315m, s.f316n, s.f317o, s.f318p, s.q, s.f319r, s.f320t, s.s, s.f321u, s.f322v, s.w, s.f323x, s.f324y, s.f325z, s.A, s.B, s.C);
                                }
                            }
                            i7 = 1;
                            trackGroupArr[i8] = new TrackGroup(s);
                            i8++;
                            i6 = 0;
                        }
                        if (d0Var.E == -1 && rVar.i() == -9223372036854775807L) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        d0Var.F = z3;
                        if (z3) {
                            i3 = 7;
                        } else {
                            i3 = 1;
                        }
                        d0Var.f2396y = i3;
                        d0Var.w = new a0(rVar, new TrackGroupArray(trackGroupArr), zArr);
                        d0Var.f2394v = true;
                        d0Var.f2380f.r(d0Var.D, rVar.e(), d0Var.F);
                        l lVar = d0Var.f2390p;
                        lVar.getClass();
                        lVar.c(d0Var);
                        return;
                    }
                    return;
                default:
                    if (!d0Var.L) {
                        l lVar2 = d0Var.f2390p;
                        lVar2.getClass();
                        lVar2.e(d0Var);
                        return;
                    }
                    return;
            }
        }
    };

    /* renamed from: n  reason: collision with root package name */
    public final y f2388n = new Runnable(this) { // from class: j1.y
        public final /* synthetic */ d0 b;

        {
            this.b = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z3;
            int i3;
            boolean z5;
            Metadata metadata;
            int i5;
            d0 d0Var = this.b;
            int i6 = 0;
            int i7 = 1;
            switch (r2) {
                case 0:
                    p0.r rVar = d0Var.q;
                    if (!d0Var.L && !d0Var.f2394v && d0Var.f2393u && rVar != null) {
                        for (i0 i0Var : d0Var.s) {
                            if (i0Var.s() == null) {
                                return;
                            }
                        }
                        d0Var.f2386l.a();
                        int length = d0Var.s.length;
                        TrackGroup[] trackGroupArr = new TrackGroup[length];
                        boolean[] zArr = new boolean[length];
                        d0Var.D = rVar.i();
                        int i8 = 0;
                        while (i8 < length) {
                            Format s = d0Var.s[i8].s();
                            String str = s.f311i;
                            boolean g5 = g2.k.g(str);
                            if (!g5 && !g2.k.h(str)) {
                                z5 = false;
                            } else {
                                z5 = true;
                            }
                            zArr[i8] = z5;
                            d0Var.f2395x = z5 | d0Var.f2395x;
                            IcyHeaders icyHeaders = d0Var.f2391r;
                            if (icyHeaders != null) {
                                if (g5 || d0Var.f2392t[i8].b) {
                                    Metadata metadata2 = s.f309g;
                                    if (metadata2 == null) {
                                        Metadata.Entry[] entryArr = new Metadata.Entry[i7];
                                        entryArr[i6] = icyHeaders;
                                        metadata = new Metadata(entryArr);
                                    } else {
                                        Metadata.Entry[] entryArr2 = new Metadata.Entry[i7];
                                        entryArr2[i6] = icyHeaders;
                                        int i9 = g2.w.f1960a;
                                        Metadata.Entry[] entryArr3 = metadata2.f330a;
                                        Object[] copyOf = Arrays.copyOf(entryArr3, entryArr3.length + i7);
                                        System.arraycopy(entryArr2, i6, copyOf, entryArr3.length, i7);
                                        metadata = new Metadata((Metadata.Entry[]) copyOf);
                                    }
                                    s = s.c(s.f314l, metadata);
                                }
                                if (g5 && s.f307e == -1 && (i5 = icyHeaders.f351a) != -1) {
                                    s = new Format(s.f306a, s.b, s.c, s.d, i5, s.f308f, s.f309g, s.f310h, s.f311i, s.f312j, s.f313k, s.f314l, s.f315m, s.f316n, s.f317o, s.f318p, s.q, s.f319r, s.f320t, s.s, s.f321u, s.f322v, s.w, s.f323x, s.f324y, s.f325z, s.A, s.B, s.C);
                                }
                            }
                            i7 = 1;
                            trackGroupArr[i8] = new TrackGroup(s);
                            i8++;
                            i6 = 0;
                        }
                        if (d0Var.E == -1 && rVar.i() == -9223372036854775807L) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        d0Var.F = z3;
                        if (z3) {
                            i3 = 7;
                        } else {
                            i3 = 1;
                        }
                        d0Var.f2396y = i3;
                        d0Var.w = new a0(rVar, new TrackGroupArray(trackGroupArr), zArr);
                        d0Var.f2394v = true;
                        d0Var.f2380f.r(d0Var.D, rVar.e(), d0Var.F);
                        l lVar = d0Var.f2390p;
                        lVar.getClass();
                        lVar.c(d0Var);
                        return;
                    }
                    return;
                default:
                    if (!d0Var.L) {
                        l lVar2 = d0Var.f2390p;
                        lVar2.getClass();
                        lVar2.e(d0Var);
                        return;
                    }
                    return;
            }
        }
    };

    /* renamed from: o  reason: collision with root package name */
    public final Handler f2389o = new Handler();

    /* renamed from: t  reason: collision with root package name */
    public c0[] f2392t = new c0[0];
    public i0[] s = new i0[0];
    public long H = -9223372036854775807L;
    public long E = -1;
    public long D = -9223372036854775807L;

    /* renamed from: y  reason: collision with root package name */
    public int f2396y = 1;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        M = Collections.unmodifiableMap(hashMap);
        N = Format.n(Long.MAX_VALUE, "icy", "application/x-icy");
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, g2.d] */
    /* JADX WARN: Type inference failed for: r1v6, types: [j1.y] */
    /* JADX WARN: Type inference failed for: r1v7, types: [j1.y] */
    public d0(Uri uri, e2.i iVar, p0.j[] jVarArr, n0.b bVar, j3.a aVar, u uVar, e0 e0Var, e2.m mVar, int i3) {
        this.f2378a = uri;
        this.b = iVar;
        this.c = bVar;
        this.d = aVar;
        this.f2379e = uVar;
        this.f2380f = e0Var;
        this.f2381g = mVar;
        this.f2383i = i3;
        this.f2385k = new c1.b(jVarArr);
        uVar.n();
    }

    public final void B() {
        z zVar = new z(this, this.f2378a, this.b, this.f2385k, this, this.f2386l);
        if (this.f2394v) {
            a0 a0Var = this.w;
            a0Var.getClass();
            g2.b.h(p());
            long j2 = this.D;
            if (j2 != -9223372036854775807L && this.H > j2) {
                this.K = true;
                this.H = -9223372036854775807L;
                return;
            }
            long j5 = ((p0.r) a0Var.f2371a).g(this.H).f3128a.b;
            long j6 = this.H;
            zVar.f2472f.f3114a = j5;
            zVar.f2475i = j6;
            zVar.f2474h = true;
            zVar.f2479m = false;
            this.H = -9223372036854775807L;
        }
        this.J = m();
        this.f2384j.e(zVar, this, this.d.l(this.f2396y));
        this.f2379e.l(zVar.f2476j, 1, -1, null, 0, null, zVar.f2475i, this.D);
    }

    public final boolean C() {
        if (!this.A && !p()) {
            return false;
        }
        return true;
    }

    @Override // p0.k
    public final void a(p0.r rVar) {
        if (this.f2391r != null) {
            rVar = new p0.n(-9223372036854775807L);
        }
        this.q = rVar;
        this.f2389o.post(this.f2387m);
    }

    @Override // j1.m
    public final long b(long j2, j0.o0 o0Var) {
        a0 a0Var = this.w;
        a0Var.getClass();
        p0.r rVar = (p0.r) a0Var.f2371a;
        if (!rVar.e()) {
            return 0L;
        }
        p0.q g5 = rVar.g(j2);
        return g2.w.A(j2, o0Var, g5.f3128a.f3129a, g5.b.f3129a);
    }

    @Override // p0.k
    public final void c() {
        this.f2393u = true;
        this.f2389o.post(this.f2387m);
    }

    @Override // j1.l0
    public final boolean d() {
        boolean z3;
        if (this.f2384j.c()) {
            g2.d dVar = this.f2386l;
            synchronized (dVar) {
                z3 = dVar.f1918a;
            }
            if (z3) {
                return true;
            }
        }
        return false;
    }

    @Override // e2.d0
    public final void e() {
        i0[] i0VarArr;
        for (i0 i0Var : this.s) {
            i0Var.z(true);
            if (i0Var.f2420f != null) {
                i0Var.f2420f = null;
                i0Var.f2419e = null;
            }
        }
        c1.b bVar = this.f2385k;
        if (((p0.j) bVar.c) != null) {
            bVar.c = null;
        }
    }

    @Override // e2.z
    public final void f(e2.c0 c0Var, long j2, long j5, boolean z3) {
        z zVar = (z) c0Var;
        e2.l lVar = zVar.f2476j;
        Uri uri = zVar.b.c;
        this.f2379e.d(1, -1, null, 0, null, zVar.f2475i, this.D);
        if (!z3) {
            if (this.E == -1) {
                this.E = zVar.f2477k;
            }
            for (i0 i0Var : this.s) {
                i0Var.z(false);
            }
            if (this.C > 0) {
                l lVar2 = this.f2390p;
                lVar2.getClass();
                lVar2.e(this);
            }
        }
    }

    @Override // p0.k
    public final p0.u g(int i3, int i5) {
        return x(new c0(i3, false));
    }

    @Override // j1.h0
    public final void h() {
        this.f2389o.post(this.f2387m);
    }

    @Override // j1.l0
    public final long i() {
        if (this.C == 0) {
            return Long.MIN_VALUE;
        }
        return s();
    }

    @Override // j1.m
    public final long j() {
        if (!this.B) {
            this.f2379e.q();
            this.B = true;
        }
        if (this.A) {
            if (this.K || m() > this.J) {
                this.A = false;
                return this.G;
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    @Override // e2.z
    public final e2.a0 k(e2.c0 c0Var, long j2, long j5, IOException iOException, int i3) {
        int i5;
        e2.a0 a0Var;
        p0.r rVar;
        z zVar = (z) c0Var;
        if (this.E == -1) {
            this.E = zVar.f2477k;
        }
        this.d.getClass();
        long m5 = j3.a.m(i3, iOException);
        if (m5 == -9223372036854775807L) {
            a0Var = e2.f0.f1685e;
        } else {
            int m6 = m();
            if (m6 > this.J) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (this.E == -1 && ((rVar = this.q) == null || rVar.i() == -9223372036854775807L)) {
                if (this.f2394v && !C()) {
                    this.I = true;
                    a0Var = e2.f0.d;
                } else {
                    this.A = this.f2394v;
                    this.G = 0L;
                    this.J = 0;
                    for (i0 i0Var : this.s) {
                        i0Var.z(false);
                    }
                    zVar.f2472f.f3114a = 0L;
                    zVar.f2475i = 0L;
                    zVar.f2474h = true;
                    zVar.f2479m = false;
                }
            } else {
                this.J = m6;
            }
            a0Var = new e2.a0(i5, m5);
        }
        e2.l lVar = zVar.f2476j;
        Uri uri = zVar.b.c;
        this.f2379e.i(1, -1, null, 0, null, zVar.f2475i, this.D, iOException, !a0Var.a());
        return a0Var;
    }

    @Override // e2.z
    public final void l(e2.c0 c0Var, long j2, long j5) {
        p0.r rVar;
        long j6;
        z zVar = (z) c0Var;
        if (this.D == -9223372036854775807L && (rVar = this.q) != null) {
            boolean e5 = rVar.e();
            long n5 = n();
            if (n5 == Long.MIN_VALUE) {
                j6 = 0;
            } else {
                j6 = n5 + 10000;
            }
            this.D = j6;
            this.f2380f.r(j6, e5, this.F);
        }
        e2.l lVar = zVar.f2476j;
        Uri uri = zVar.b.c;
        this.f2379e.f(1, -1, null, 0, null, zVar.f2475i, this.D);
        if (this.E == -1) {
            this.E = zVar.f2477k;
        }
        this.K = true;
        l lVar2 = this.f2390p;
        lVar2.getClass();
        lVar2.e(this);
    }

    public final int m() {
        i0[] i0VarArr;
        int i3 = 0;
        for (i0 i0Var : this.s) {
            i3 += i0Var.f2430p + i0Var.f2429o;
        }
        return i3;
    }

    public final long n() {
        long j2 = Long.MIN_VALUE;
        for (i0 i0Var : this.s) {
            j2 = Math.max(j2, i0Var.o());
        }
        return j2;
    }

    @Override // j1.m
    public final TrackGroupArray o() {
        a0 a0Var = this.w;
        a0Var.getClass();
        return (TrackGroupArray) a0Var.b;
    }

    public final boolean p() {
        if (this.H != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    @Override // j1.m
    public final void q(l lVar, long j2) {
        this.f2390p = lVar;
        g2.d dVar = this.f2386l;
        synchronized (dVar) {
            if (!dVar.f1918a) {
                dVar.f1918a = true;
                dVar.notifyAll();
            }
        }
        B();
    }

    public final void r(int i3) {
        a0 a0Var = this.w;
        a0Var.getClass();
        boolean[] zArr = (boolean[]) a0Var.f2372e;
        if (!zArr[i3]) {
            Format format = ((TrackGroupArray) a0Var.b).b[i3].b[0];
            this.f2379e.b(g2.k.e(format.f311i), format, 0, null, this.G);
            zArr[i3] = true;
        }
    }

    @Override // j1.l0
    public final long s() {
        long j2;
        boolean z3;
        a0 a0Var = this.w;
        a0Var.getClass();
        boolean[] zArr = (boolean[]) a0Var.c;
        if (this.K) {
            return Long.MIN_VALUE;
        }
        if (p()) {
            return this.H;
        }
        if (this.f2395x) {
            int length = this.s.length;
            j2 = Long.MAX_VALUE;
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i3]) {
                    i0 i0Var = this.s[i3];
                    synchronized (i0Var) {
                        z3 = i0Var.f2433u;
                    }
                    if (!z3) {
                        j2 = Math.min(j2, this.s[i3].o());
                    }
                }
            }
        } else {
            j2 = Long.MAX_VALUE;
        }
        if (j2 == Long.MAX_VALUE) {
            j2 = n();
        }
        if (j2 == Long.MIN_VALUE) {
            return this.G;
        }
        return j2;
    }

    @Override // j1.m
    public final void t() {
        int l5 = this.d.l(this.f2396y);
        e2.f0 f0Var = this.f2384j;
        IOException iOException = (IOException) f0Var.c;
        if (iOException == null) {
            e2.b0 b0Var = (e2.b0) f0Var.b;
            if (b0Var != null) {
                if (l5 == Integer.MIN_VALUE) {
                    l5 = b0Var.f1673a;
                }
                IOException iOException2 = b0Var.f1674e;
                if (iOException2 != null && b0Var.f1675f > l5) {
                    throw iOException2;
                }
            }
            if (this.K && !this.f2394v) {
                throw new IOException("Loading finished before preparation is complete.");
            }
            return;
        }
        throw iOException;
    }

    @Override // j1.m
    public final void u(long j2, boolean z3) {
        if (p()) {
            return;
        }
        a0 a0Var = this.w;
        a0Var.getClass();
        int length = this.s.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.s[i3].i(j2, z3, ((boolean[]) a0Var.d)[i3]);
        }
    }

    public final void v(int i3) {
        a0 a0Var = this.w;
        a0Var.getClass();
        if (this.I && ((boolean[]) a0Var.c)[i3] && !this.s[i3].u(false)) {
            this.H = 0L;
            this.I = false;
            this.A = true;
            this.G = 0L;
            this.J = 0;
            for (i0 i0Var : this.s) {
                i0Var.z(false);
            }
            l lVar = this.f2390p;
            lVar.getClass();
            lVar.e(this);
        }
    }

    @Override // j1.m
    public final long w(long j2) {
        a0 a0Var = this.w;
        a0Var.getClass();
        if (!((p0.r) a0Var.f2371a).e()) {
            j2 = 0;
        }
        this.A = false;
        this.G = j2;
        if (p()) {
            this.H = j2;
            return j2;
        }
        if (this.f2396y != 7) {
            int length = this.s.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (this.s[i3].B(j2, false) || (!((boolean[]) a0Var.c)[i3] && this.f2395x)) {
                }
            }
            return j2;
        }
        this.I = false;
        this.H = j2;
        this.K = false;
        e2.f0 f0Var = this.f2384j;
        if (f0Var.c()) {
            e2.b0 b0Var = (e2.b0) f0Var.b;
            g2.b.i(b0Var);
            b0Var.a(false);
        } else {
            f0Var.c = null;
            for (i0 i0Var : this.s) {
                i0Var.z(false);
            }
        }
        return j2;
    }

    public final i0 x(c0 c0Var) {
        int length = this.s.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (c0Var.equals(this.f2392t[i3])) {
                return this.s[i3];
            }
        }
        i0 i0Var = new i0(this.f2381g, this.c);
        i0Var.d = this;
        int i5 = length + 1;
        c0[] c0VarArr = (c0[]) Arrays.copyOf(this.f2392t, i5);
        c0VarArr[length] = c0Var;
        int i6 = g2.w.f1960a;
        this.f2392t = c0VarArr;
        i0[] i0VarArr = (i0[]) Arrays.copyOf(this.s, i5);
        i0VarArr[length] = i0Var;
        this.s = i0VarArr;
        return i0Var;
    }

    @Override // j1.l0
    public final boolean y(long j2) {
        boolean z3 = false;
        if (!this.K) {
            e2.f0 f0Var = this.f2384j;
            if (!f0Var.b() && !this.I && (!this.f2394v || this.C != 0)) {
                g2.d dVar = this.f2386l;
                synchronized (dVar) {
                    if (!dVar.f1918a) {
                        dVar.f1918a = true;
                        dVar.notifyAll();
                        z3 = true;
                    }
                }
                if (!f0Var.c()) {
                    B();
                    return true;
                }
                return z3;
            }
        }
        return false;
    }

    @Override // j1.m
    public final long z(b2.n[] nVarArr, boolean[] zArr, j0[] j0VarArr, boolean[] zArr2, long j2) {
        boolean[] zArr3;
        boolean z3;
        b2.n nVar;
        boolean z5;
        boolean z6;
        a0 a0Var = this.w;
        a0Var.getClass();
        int i3 = this.C;
        int i5 = 0;
        while (true) {
            int length = nVarArr.length;
            zArr3 = (boolean[]) a0Var.d;
            if (i5 >= length) {
                break;
            }
            j0 j0Var = j0VarArr[i5];
            if (j0Var != null && (nVarArr[i5] == null || !zArr[i5])) {
                int i6 = ((b0) j0Var).f2373a;
                g2.b.h(zArr3[i6]);
                this.C--;
                zArr3[i6] = false;
                j0VarArr[i5] = null;
            }
            i5++;
        }
        if (!this.f2397z ? j2 != 0 : i3 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        for (int i7 = 0; i7 < nVarArr.length; i7++) {
            if (j0VarArr[i7] == null && (nVar = nVarArr[i7]) != null) {
                b2.d dVar = (b2.d) nVar;
                int[] iArr = dVar.c;
                if (iArr.length == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                g2.b.h(z5);
                if (iArr[0] == 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                g2.b.h(z6);
                int c = ((TrackGroupArray) a0Var.b).c(dVar.f139a);
                g2.b.h(!zArr3[c]);
                this.C++;
                zArr3[c] = true;
                j0VarArr[i7] = new b0(this, c);
                zArr2[i7] = true;
                if (!z3) {
                    i0 i0Var = this.s[c];
                    if (!i0Var.B(j2, true) && i0Var.q() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
            }
        }
        if (this.C == 0) {
            this.I = false;
            this.A = false;
            e2.f0 f0Var = this.f2384j;
            if (f0Var.c()) {
                for (i0 i0Var2 : this.s) {
                    i0Var2.j();
                }
                e2.b0 b0Var = (e2.b0) f0Var.b;
                g2.b.i(b0Var);
                b0Var.a(false);
            } else {
                for (i0 i0Var3 : this.s) {
                    i0Var3.z(false);
                }
            }
        } else if (z3) {
            j2 = w(j2);
            for (int i8 = 0; i8 < j0VarArr.length; i8++) {
                if (j0VarArr[i8] != null) {
                    zArr2[i8] = true;
                }
            }
        }
        this.f2397z = true;
        return j2;
    }

    @Override // j1.l0
    public final void A(long j2) {
    }
}

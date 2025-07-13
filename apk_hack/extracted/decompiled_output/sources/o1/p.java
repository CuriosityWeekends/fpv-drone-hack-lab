package o1;

import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import e2.a0;
import e2.b0;
import e2.c0;
import e2.d0;
import e2.f0;
import e2.z;
import g2.w;
import j1.h0;
import j1.l0;
import j1.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p implements z, d0, l0, p0.k, h0 {
    public static final Set V = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 4)));
    public boolean A;
    public int B;
    public Format C;
    public Format D;
    public boolean E;
    public TrackGroupArray F;
    public Set G;
    public int[] H;
    public int I;
    public boolean J;
    public boolean[] K;
    public boolean[] L;
    public long M;
    public long N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public long S;
    public DrmInitData T;
    public int U;

    /* renamed from: a  reason: collision with root package name */
    public final int f3024a;
    public final j b;
    public final f c;
    public final e2.m d;

    /* renamed from: e  reason: collision with root package name */
    public final Format f3025e;

    /* renamed from: f  reason: collision with root package name */
    public final n0.b f3026f;

    /* renamed from: g  reason: collision with root package name */
    public final j3.a f3027g;

    /* renamed from: h  reason: collision with root package name */
    public final f0 f3028h = new f0("Loader:HlsSampleStreamWrapper");

    /* renamed from: i  reason: collision with root package name */
    public final u f3029i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3030j;

    /* renamed from: k  reason: collision with root package name */
    public final j0.b f3031k;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f3032l;

    /* renamed from: m  reason: collision with root package name */
    public final List f3033m;

    /* renamed from: n  reason: collision with root package name */
    public final m f3034n;

    /* renamed from: o  reason: collision with root package name */
    public final m f3035o;

    /* renamed from: p  reason: collision with root package name */
    public final Handler f3036p;
    public final ArrayList q;

    /* renamed from: r  reason: collision with root package name */
    public final Map f3037r;
    public o[] s;

    /* renamed from: t  reason: collision with root package name */
    public int[] f3038t;

    /* renamed from: u  reason: collision with root package name */
    public final HashSet f3039u;

    /* renamed from: v  reason: collision with root package name */
    public final SparseIntArray f3040v;
    public n w;

    /* renamed from: x  reason: collision with root package name */
    public int f3041x;

    /* renamed from: y  reason: collision with root package name */
    public int f3042y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3043z;

    /* JADX WARN: Type inference failed for: r1v12, types: [o1.m] */
    /* JADX WARN: Type inference failed for: r1v13, types: [o1.m] */
    public p(int i3, j jVar, f fVar, Map map, e2.m mVar, long j2, Format format, n0.b bVar, j3.a aVar, u uVar, int i5) {
        this.f3024a = i3;
        this.b = jVar;
        this.c = fVar;
        this.f3037r = map;
        this.d = mVar;
        this.f3025e = format;
        this.f3026f = bVar;
        this.f3027g = aVar;
        this.f3029i = uVar;
        this.f3030j = i5;
        j0.b bVar2 = new j0.b(2);
        bVar2.c = null;
        bVar2.b = false;
        bVar2.d = null;
        this.f3031k = bVar2;
        this.f3038t = new int[0];
        Set set = V;
        this.f3039u = new HashSet(set.size());
        this.f3040v = new SparseIntArray(set.size());
        this.s = new o[0];
        this.L = new boolean[0];
        this.K = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.f3032l = arrayList;
        this.f3033m = Collections.unmodifiableList(arrayList);
        this.q = new ArrayList();
        this.f3034n = new Runnable(this) { // from class: o1.m
            public final /* synthetic */ p b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (r2) {
                    case 0:
                        this.b.C();
                        return;
                    default:
                        p pVar = this.b;
                        pVar.f3043z = true;
                        pVar.C();
                        return;
                }
            }
        };
        this.f3035o = new Runnable(this) { // from class: o1.m
            public final /* synthetic */ p b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (r2) {
                    case 0:
                        this.b.C();
                        return;
                    default:
                        p pVar = this.b;
                        pVar.f3043z = true;
                        pVar.C();
                        return;
                }
            }
        };
        this.f3036p = new Handler();
        this.M = j2;
        this.N = j2;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [p0.i, java.lang.Object] */
    public static p0.i n(int i3, int i5) {
        Log.w("HlsSampleStreamWrapper", "Unmapped track with id " + i3 + " of type " + i5);
        return new Object();
    }

    public static Format r(Format format, Format format2, boolean z3) {
        int i3;
        int i5;
        Metadata metadata;
        if (format == null) {
            return format2;
        }
        if (z3) {
            i3 = format.f307e;
        } else {
            i3 = -1;
        }
        int i6 = format.f322v;
        if (i6 != -1) {
            i5 = i6;
        } else {
            i5 = format2.f322v;
        }
        String l5 = w.l(g2.k.e(format2.f311i), format.f308f);
        String b = g2.k.b(l5);
        if (b == null) {
            b = format2.f311i;
        }
        String str = b;
        Metadata metadata2 = format.f309g;
        Metadata metadata3 = format2.f309g;
        if (metadata3 != null) {
            if (metadata2 != null) {
                Metadata.Entry[] entryArr = metadata2.f330a;
                if (entryArr.length != 0) {
                    Metadata.Entry[] entryArr2 = metadata3.f330a;
                    Object[] copyOf = Arrays.copyOf(entryArr2, entryArr2.length + entryArr.length);
                    System.arraycopy(entryArr, 0, copyOf, entryArr2.length, entryArr.length);
                    metadata3 = new Metadata((Metadata.Entry[]) copyOf);
                }
            }
            metadata = metadata3;
        } else {
            metadata = metadata2;
        }
        return new Format(format.f306a, format.b, format.c, format2.d, i3, l5, metadata, format2.f310h, str, format2.f312j, format2.f313k, format2.f314l, format2.f315m, format.f316n, format.f317o, format2.f318p, format2.q, format2.f319r, format2.f320t, format2.s, format2.f321u, i5, format2.w, format2.f323x, format2.f324y, format2.f325z, format.A, format2.B, format2.C);
    }

    public static int x(int i3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 == 3) {
            return 1;
        }
        return 0;
    }

    public final boolean B() {
        if (this.N != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0077, code lost:
        r15.H[r4] = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C() {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.p.C():void");
    }

    public final void D() {
        this.f3028h.a();
        f fVar = this.c;
        j1.b bVar = fVar.f2970m;
        if (bVar == null) {
            Uri uri = fVar.f2971n;
            if (uri != null && fVar.f2974r) {
                p1.a aVar = (p1.a) fVar.f2964g.d.get(uri);
                aVar.b.a();
                IOException iOException = aVar.f3140j;
                if (iOException != null) {
                    throw iOException;
                }
                return;
            }
            return;
        }
        throw bVar;
    }

    public final void E(TrackGroup[] trackGroupArr, int... iArr) {
        this.F = p(trackGroupArr);
        this.G = new HashSet();
        for (int i3 : iArr) {
            this.G.add(this.F.b[i3]);
        }
        this.I = 0;
        Handler handler = this.f3036p;
        j jVar = this.b;
        jVar.getClass();
        handler.post(new c2.b(5, jVar));
        this.A = true;
    }

    public final void F() {
        for (o oVar : this.s) {
            oVar.z(this.O);
        }
        this.O = false;
    }

    public final boolean G(long j2, boolean z3) {
        this.M = j2;
        if (B()) {
            this.N = j2;
            return true;
        }
        if (this.f3043z && !z3) {
            int length = this.s.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (this.s[i3].B(j2, false) || (!this.L[i3] && this.J)) {
                }
            }
            return false;
        }
        this.N = j2;
        this.Q = false;
        this.f3032l.clear();
        f0 f0Var = this.f3028h;
        if (f0Var.c()) {
            b0 b0Var = (b0) f0Var.b;
            g2.b.i(b0Var);
            b0Var.a(false);
        } else {
            f0Var.c = null;
            F();
        }
        return true;
    }

    @Override // p0.k
    public final void c() {
        this.R = true;
        this.f3036p.post(this.f3035o);
    }

    @Override // j1.l0
    public final boolean d() {
        return this.f3028h.c();
    }

    @Override // e2.d0
    public final void e() {
        o[] oVarArr;
        for (o oVar : this.s) {
            oVar.z(true);
            if (oVar.f2420f != null) {
                oVar.f2420f = null;
                oVar.f2419e = null;
            }
        }
    }

    @Override // e2.z
    public final void f(c0 c0Var, long j2, long j5, boolean z3) {
        l1.b bVar = (l1.b) c0Var;
        e2.l lVar = bVar.f2637a;
        Uri uri = bVar.f2641h.c;
        this.f3029i.d(bVar.b, this.f3024a, bVar.c, bVar.d, bVar.f2638e, bVar.f2639f, bVar.f2640g);
        if (!z3) {
            F();
            if (this.B > 0) {
                this.b.e(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [p0.i] */
    @Override // p0.k
    public final p0.u g(int i3, int i5) {
        o oVar;
        Integer valueOf = Integer.valueOf(i5);
        Set set = V;
        boolean contains = set.contains(valueOf);
        HashSet hashSet = this.f3039u;
        SparseIntArray sparseIntArray = this.f3040v;
        boolean z3 = false;
        o oVar2 = null;
        if (contains) {
            g2.b.e(set.contains(Integer.valueOf(i5)));
            int i6 = sparseIntArray.get(i5, -1);
            if (i6 != -1) {
                if (hashSet.add(Integer.valueOf(i5))) {
                    this.f3038t[i6] = i3;
                }
                if (this.f3038t[i6] == i3) {
                    oVar = this.s[i6];
                } else {
                    oVar = n(i3, i5);
                }
                oVar2 = oVar;
            }
        } else {
            int i7 = 0;
            while (true) {
                o[] oVarArr = this.s;
                if (i7 >= oVarArr.length) {
                    break;
                } else if (this.f3038t[i7] == i3) {
                    oVar2 = oVarArr[i7];
                    break;
                } else {
                    i7++;
                }
            }
        }
        if (oVar2 == null) {
            if (this.R) {
                return n(i3, i5);
            }
            int length = this.s.length;
            z3 = (i5 == 1 || i5 == 2) ? true : true;
            oVar2 = new o(this.d, this.f3026f, this.f3037r);
            if (z3) {
                oVar2.F = this.T;
                oVar2.A = true;
            }
            long j2 = this.S;
            if (oVar2.C != j2) {
                oVar2.C = j2;
                oVar2.A = true;
            }
            oVar2.f2437z = this.U;
            oVar2.d = this;
            int i8 = length + 1;
            int[] copyOf = Arrays.copyOf(this.f3038t, i8);
            this.f3038t = copyOf;
            copyOf[length] = i3;
            o[] oVarArr2 = this.s;
            int i9 = w.f1960a;
            Object[] copyOf2 = Arrays.copyOf(oVarArr2, oVarArr2.length + 1);
            copyOf2[oVarArr2.length] = oVar2;
            this.s = (o[]) copyOf2;
            boolean[] copyOf3 = Arrays.copyOf(this.L, i8);
            this.L = copyOf3;
            copyOf3[length] = z3;
            this.J |= z3;
            hashSet.add(Integer.valueOf(i5));
            sparseIntArray.append(i5, length);
            if (x(i5) > x(this.f3041x)) {
                this.f3042y = length;
                this.f3041x = i5;
            }
            this.K = Arrays.copyOf(this.K, i8);
        }
        if (i5 == 4) {
            if (this.w == null) {
                this.w = new n(oVar2, this.f3030j);
            }
            return this.w;
        }
        return oVar2;
    }

    @Override // j1.h0
    public final void h() {
        this.f3036p.post(this.f3034n);
    }

    @Override // j1.l0
    public final long i() {
        if (B()) {
            return this.N;
        }
        if (this.Q) {
            return Long.MIN_VALUE;
        }
        return v().f2640g;
    }

    @Override // e2.z
    public final a0 k(c0 c0Var, long j2, long j5, IOException iOException, int i3) {
        boolean z3;
        a0 a0Var;
        l1.b bVar = (l1.b) c0Var;
        long j6 = bVar.f2641h.b;
        boolean z5 = bVar instanceof i;
        j3.a aVar = this.f3027g;
        aVar.getClass();
        long k5 = j3.a.k(iOException);
        boolean z6 = false;
        if (k5 != -9223372036854775807L) {
            f fVar = this.c;
            b2.d dVar = (b2.d) fVar.f2973p;
            z3 = dVar.h(dVar.i(fVar.f2965h.c(bVar.c)), k5);
        } else {
            z3 = false;
        }
        if (z3) {
            if (z5 && j6 == 0) {
                ArrayList arrayList = this.f3032l;
                if (((i) arrayList.remove(arrayList.size() - 1)) == bVar) {
                    z6 = true;
                }
                g2.b.h(z6);
                if (arrayList.isEmpty()) {
                    this.N = this.M;
                }
            }
            a0Var = f0.d;
        } else {
            aVar.getClass();
            long m5 = j3.a.m(i3, iOException);
            if (m5 != -9223372036854775807L) {
                a0Var = new a0(0, m5);
            } else {
                a0Var = f0.f1685e;
            }
        }
        Uri uri = bVar.f2641h.c;
        this.f3029i.i(bVar.b, this.f3024a, bVar.c, bVar.d, bVar.f2638e, bVar.f2639f, bVar.f2640g, iOException, !a0Var.a());
        if (z3) {
            if (!this.A) {
                y(this.M);
            } else {
                this.b.e(this);
            }
        }
        return a0Var;
    }

    @Override // e2.z
    public final void l(c0 c0Var, long j2, long j5) {
        l1.b bVar = (l1.b) c0Var;
        f fVar = this.c;
        fVar.getClass();
        if (bVar instanceof d) {
            d dVar = (d) bVar;
            fVar.f2969l = dVar.f2957i;
            Uri uri = dVar.f2637a.f1694a;
            byte[] bArr = dVar.f2959k;
            bArr.getClass();
            b3.e eVar = fVar.f2967j;
            eVar.getClass();
            uri.getClass();
            byte[] bArr2 = (byte[]) ((c) eVar.b).put(uri, bArr);
        }
        e2.l lVar = bVar.f2637a;
        Uri uri2 = bVar.f2641h.c;
        this.f3029i.f(bVar.b, this.f3024a, bVar.c, bVar.d, bVar.f2638e, bVar.f2639f, bVar.f2640g);
        if (!this.A) {
            y(this.M);
        } else {
            this.b.e(this);
        }
    }

    public final void m() {
        g2.b.h(this.A);
        this.F.getClass();
        this.G.getClass();
    }

    public final TrackGroupArray p(TrackGroup[] trackGroupArr) {
        for (int i3 = 0; i3 < trackGroupArr.length; i3++) {
            TrackGroup trackGroup = trackGroupArr[i3];
            Format[] formatArr = new Format[trackGroup.f384a];
            for (int i5 = 0; i5 < trackGroup.f384a; i5++) {
                Format format = trackGroup.b[i5];
                if (format.f314l != null) {
                    this.f3026f.getClass();
                    format = format.d();
                }
                formatArr[i5] = format;
            }
            trackGroupArr[i3] = new TrackGroup(formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    @Override // j1.l0
    public final long s() {
        if (this.Q) {
            return Long.MIN_VALUE;
        }
        if (B()) {
            return this.N;
        }
        long j2 = this.M;
        i v5 = v();
        if (!v5.G) {
            ArrayList arrayList = this.f3032l;
            if (arrayList.size() > 1) {
                v5 = (i) arrayList.get(arrayList.size() - 2);
            } else {
                v5 = null;
            }
        }
        if (v5 != null) {
            j2 = Math.max(j2, v5.f2640g);
        }
        if (this.f3043z) {
            for (o oVar : this.s) {
                j2 = Math.max(j2, oVar.o());
            }
        }
        return j2;
    }

    public final i v() {
        ArrayList arrayList = this.f3032l;
        return (i) arrayList.get(arrayList.size() - 1);
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [java.io.IOException, j1.b] */
    @Override // j1.l0
    public final boolean y(long j2) {
        long max;
        long j5;
        List list;
        boolean z3;
        i iVar;
        int c;
        long j6;
        int i3;
        boolean z5;
        int i5;
        int i6;
        p1.g gVar;
        long j7;
        j0.b bVar;
        int i7;
        Uri uri;
        Uri uri2;
        Uri y3;
        byte[] bArr;
        byte[] bArr2;
        boolean z6;
        byte[] bArr3;
        a aVar;
        int i8;
        f fVar;
        e2.i iVar2;
        e2.l lVar;
        boolean z7;
        f1.b bVar2;
        c0.b bVar3;
        p0.j jVar;
        boolean z8;
        boolean z9;
        p0.j jVar2;
        boolean z10;
        byte[] bArr4;
        String str;
        if (!this.Q) {
            f0 f0Var = this.f3028h;
            if (!f0Var.c() && !f0Var.b()) {
                if (B()) {
                    list = Collections.emptyList();
                    j5 = this.N;
                } else {
                    i v5 = v();
                    if (v5.G) {
                        max = v5.f2640g;
                    } else {
                        max = Math.max(this.M, v5.f2639f);
                    }
                    j5 = max;
                    list = this.f3033m;
                }
                long j8 = j5;
                if (!this.A && list.isEmpty()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                f fVar2 = this.c;
                fVar2.getClass();
                if (list.isEmpty()) {
                    iVar = null;
                } else {
                    iVar = (i) list.get(list.size() - 1);
                }
                if (iVar == null) {
                    c = -1;
                } else {
                    c = fVar2.f2965h.c(iVar.c);
                }
                long j9 = j8 - j2;
                long j10 = fVar2.q;
                if (j10 != -9223372036854775807L) {
                    j6 = j10 - j2;
                } else {
                    j6 = -9223372036854775807L;
                }
                if (iVar != null && !fVar2.f2972o) {
                    i3 = c;
                    long j11 = iVar.f2640g - iVar.f2639f;
                    j9 = Math.max(0L, j9 - j11);
                    if (j6 != -9223372036854775807L) {
                        j6 = Math.max(0L, j6 - j11);
                    }
                } else {
                    i3 = c;
                }
                fVar2.a(iVar, j8);
                fVar2.f2973p.d(j9, j6);
                b2.d dVar = (b2.d) fVar2.f2973p;
                int i9 = dVar.c[dVar.c()];
                int i10 = i3;
                if (i10 != i9) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Uri[] uriArr = fVar2.f2962e;
                Uri uri3 = uriArr[i9];
                p1.b bVar4 = fVar2.f2964g;
                boolean c5 = bVar4.c(uri3);
                j0.b bVar5 = this.f3031k;
                if (!c5) {
                    bVar5.d = uri3;
                    fVar2.f2974r &= uri3.equals(fVar2.f2971n);
                    fVar2.f2971n = uri3;
                    bVar = bVar5;
                } else {
                    p1.g b = bVar4.b(uri3, true);
                    b.getClass();
                    fVar2.f2972o = b.c;
                    boolean z11 = b.f3182l;
                    i iVar3 = iVar;
                    long j12 = b.f3176f;
                    if (z11) {
                        i5 = i9;
                        i6 = i10;
                        gVar = b;
                        j7 = -9223372036854775807L;
                    } else {
                        i5 = i9;
                        i6 = i10;
                        gVar = b;
                        j7 = (b.f3186p + j12) - bVar4.f3154o;
                    }
                    fVar2.q = j7;
                    long j13 = j12 - bVar4.f3154o;
                    p1.g gVar2 = gVar;
                    bVar = bVar5;
                    int i11 = i6;
                    long b5 = fVar2.b(iVar3, z5, gVar2, j13, j8);
                    if (b5 < gVar2.f3179i && iVar3 != null && z5) {
                        uri = uriArr[i11];
                        p1.g b6 = bVar4.b(uri, true);
                        b6.getClass();
                        j13 = b6.f3176f - bVar4.f3154o;
                        gVar2 = b6;
                        b5 = iVar3.c();
                        i7 = i11;
                    } else {
                        i7 = i5;
                        uri = uri3;
                    }
                    long j14 = gVar2.f3179i;
                    if (b5 < j14) {
                        fVar2.f2970m = new IOException();
                    } else {
                        int i12 = (int) (b5 - j14);
                        List list2 = gVar2.f3185o;
                        int size = list2.size();
                        if (i12 >= size) {
                            if (gVar2.f3182l) {
                                if (!z3 && size != 0) {
                                    i12 = size - 1;
                                } else {
                                    bVar.b = true;
                                }
                            } else {
                                bVar.d = uri;
                                fVar2.f2974r &= uri.equals(fVar2.f2971n);
                                fVar2.f2971n = uri;
                            }
                        }
                        fVar2.f2974r = false;
                        fVar2.f2971n = null;
                        p1.f fVar3 = (p1.f) list2.get(i12);
                        p1.f fVar4 = fVar3.b;
                        String str2 = gVar2.f3187a;
                        if (fVar4 != null && (str = fVar4.f3170g) != null) {
                            uri2 = g2.b.y(str2, str);
                        } else {
                            uri2 = null;
                        }
                        d c6 = fVar2.c(uri2, i7);
                        bVar.c = c6;
                        if (c6 == null) {
                            String str3 = fVar3.f3170g;
                            if (str3 == null) {
                                y3 = null;
                            } else {
                                y3 = g2.b.y(str2, str3);
                            }
                            d c7 = fVar2.c(y3, i7);
                            bVar.c = c7;
                            if (c7 == null) {
                                Format format = fVar2.f2963f[i7];
                                int b7 = fVar2.f2973p.b();
                                Object f4 = fVar2.f2973p.f();
                                boolean z12 = fVar2.f2968k;
                                b3.e eVar = fVar2.f2967j;
                                if (y3 == null) {
                                    eVar.getClass();
                                    bArr = null;
                                } else {
                                    bArr = (byte[]) ((c) eVar.b).get(y3);
                                }
                                if (uri2 == null) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = (byte[]) ((c) eVar.b).get(uri2);
                                }
                                p0.m mVar = i.H;
                                p1.f fVar5 = (p1.f) list2.get(i12);
                                Uri y4 = g2.b.y(str2, fVar5.f3167a);
                                long j15 = fVar5.f3173j;
                                Uri uri4 = uri;
                                long j16 = fVar5.f3172i;
                                e2.l lVar2 = new e2.l(y4, j16, j16, j15, null, 0);
                                if (bArr != null) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (z6) {
                                    String str4 = fVar5.f3171h;
                                    str4.getClass();
                                    bArr3 = i.f(str4);
                                } else {
                                    bArr3 = null;
                                }
                                e2.i iVar4 = fVar2.b;
                                if (bArr != null) {
                                    bArr3.getClass();
                                    aVar = new a(iVar4, bArr, bArr3);
                                } else {
                                    aVar = iVar4;
                                }
                                p1.f fVar6 = fVar5.b;
                                if (fVar6 != null) {
                                    if (bArr2 != null) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    if (z10) {
                                        String str5 = fVar6.f3171h;
                                        str5.getClass();
                                        bArr4 = i.f(str5);
                                    } else {
                                        bArr4 = null;
                                    }
                                    Uri y5 = g2.b.y(str2, fVar6.f3167a);
                                    fVar = fVar2;
                                    long j17 = fVar6.f3173j;
                                    i8 = i12;
                                    boolean z13 = z10;
                                    long j18 = fVar6.f3172i;
                                    e2.l lVar3 = new e2.l(y5, j18, j18, j17, null, 0);
                                    if (bArr2 != null) {
                                        bArr4.getClass();
                                        iVar2 = new a(iVar4, bArr2, bArr4);
                                    } else {
                                        iVar2 = iVar4;
                                    }
                                    z7 = z13;
                                    lVar = lVar3;
                                } else {
                                    i8 = i12;
                                    fVar = fVar2;
                                    iVar2 = null;
                                    lVar = null;
                                    z7 = false;
                                }
                                long j19 = j13 + fVar5.f3168e;
                                long j20 = j19 + fVar5.c;
                                int i13 = gVar2.f3178h + fVar5.d;
                                if (iVar3 != null) {
                                    if (uri4.equals(iVar3.f2979l) && iVar3.G) {
                                        z9 = false;
                                    } else {
                                        z9 = true;
                                    }
                                    if (iVar3.B && iVar3.f2978k == i13 && !z9) {
                                        jVar2 = iVar3.A;
                                    } else {
                                        jVar2 = null;
                                    }
                                    f1.b bVar6 = iVar3.w;
                                    z8 = z9;
                                    bVar3 = iVar3.f2988x;
                                    jVar = jVar2;
                                    bVar2 = bVar6;
                                } else {
                                    bVar2 = new f1.b(null);
                                    bVar3 = new c0.b(10);
                                    jVar = null;
                                    z8 = false;
                                }
                                long j21 = j14 + i8;
                                f fVar7 = fVar;
                                SparseArray sparseArray = fVar7.d.f3044a;
                                g2.u uVar = (g2.u) sparseArray.get(i13);
                                if (uVar == null) {
                                    uVar = new g2.u(Long.MAX_VALUE);
                                    sparseArray.put(i13, uVar);
                                }
                                bVar.c = new i(fVar7.f2961a, aVar, lVar2, format, z6, iVar2, lVar, z7, uri4, fVar7.f2966i, b7, f4, j19, j20, j21, i13, fVar5.f3174k, z12, uVar, fVar5.f3169f, jVar, bVar2, bVar3, z8);
                            }
                        }
                    }
                }
                boolean z14 = bVar.b;
                l1.b bVar7 = (l1.b) bVar.c;
                Uri uri5 = (Uri) bVar.d;
                bVar.c = null;
                bVar.b = false;
                bVar.d = null;
                if (z14) {
                    this.N = -9223372036854775807L;
                    this.Q = true;
                    return true;
                } else if (bVar7 == null) {
                    if (uri5 != null) {
                        ((p1.a) this.b.b.d.get(uri5)).b();
                        return false;
                    }
                    return false;
                } else {
                    if (bVar7 instanceof i) {
                        this.N = -9223372036854775807L;
                        i iVar5 = (i) bVar7;
                        iVar5.C = this;
                        int i14 = iVar5.f2977j;
                        this.U = i14;
                        for (o oVar : this.s) {
                            oVar.f2437z = i14;
                        }
                        if (iVar5.s) {
                            for (o oVar2 : this.s) {
                                oVar2.D = true;
                            }
                        }
                        this.f3032l.add(iVar5);
                        this.C = iVar5.c;
                    }
                    f0Var.e(bVar7, this, this.f3027g.l(bVar7.b));
                    this.f3029i.l(bVar7.f2637a, bVar7.b, this.f3024a, bVar7.c, bVar7.d, bVar7.f2638e, bVar7.f2639f, bVar7.f2640g);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // j1.l0
    public final void A(long j2) {
    }

    @Override // p0.k
    public final void a(p0.r rVar) {
    }
}

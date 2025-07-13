package m1;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import e2.g0;
import e2.m0;
import g2.w;
import j0.o0;
import j1.i0;
import j1.j0;
import j1.k0;
import j1.l0;
import j1.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements j1.m, k0, l1.f {
    public static final Pattern w = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: a  reason: collision with root package name */
    public final int f2768a;
    public final k b;
    public final m0 c;
    public final n0.b d;

    /* renamed from: e  reason: collision with root package name */
    public final j3.a f2769e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2770f;

    /* renamed from: g  reason: collision with root package name */
    public final g0 f2771g;

    /* renamed from: h  reason: collision with root package name */
    public final e2.m f2772h;

    /* renamed from: i  reason: collision with root package name */
    public final TrackGroupArray f2773i;

    /* renamed from: j  reason: collision with root package name */
    public final a[] f2774j;

    /* renamed from: k  reason: collision with root package name */
    public final j3.a f2775k;

    /* renamed from: l  reason: collision with root package name */
    public final r f2776l;

    /* renamed from: n  reason: collision with root package name */
    public final u f2778n;

    /* renamed from: o  reason: collision with root package name */
    public j1.l f2779o;

    /* renamed from: r  reason: collision with root package name */
    public b3.e f2781r;
    public n1.b s;

    /* renamed from: t  reason: collision with root package name */
    public int f2782t;

    /* renamed from: u  reason: collision with root package name */
    public List f2783u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2784v;

    /* renamed from: p  reason: collision with root package name */
    public l1.g[] f2780p = new l1.g[0];
    public o[] q = new o[0];

    /* renamed from: m  reason: collision with root package name */
    public final IdentityHashMap f2777m = new IdentityHashMap();

    public b(int i3, n1.b bVar, int i5, k kVar, m0 m0Var, n0.b bVar2, j3.a aVar, u uVar, long j2, g0 g0Var, e2.m mVar, j3.a aVar2, e eVar) {
        int i6;
        int i7;
        int i8;
        Format[] formatArr;
        boolean z3;
        n1.e eVar2;
        int i9;
        boolean z5 = true;
        this.f2768a = i3;
        this.s = bVar;
        this.f2782t = i5;
        this.b = kVar;
        this.c = m0Var;
        this.d = bVar2;
        this.f2769e = aVar;
        this.f2778n = uVar;
        this.f2770f = j2;
        this.f2771g = g0Var;
        this.f2772h = mVar;
        this.f2775k = aVar2;
        this.f2776l = new r(bVar, eVar, mVar);
        l1.g[] gVarArr = this.f2780p;
        aVar2.getClass();
        this.f2781r = new b3.e(10, gVarArr);
        n1.g a5 = bVar.a(i5);
        List list = a5.d;
        this.f2783u = list;
        List list2 = a5.c;
        int size = list2.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i10 = 0; i10 < size; i10++) {
            sparseIntArray.put(((n1.a) list2.get(i10)).f2914a, i10);
        }
        int[][] iArr = new int[size];
        boolean[] zArr = new boolean[size];
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            if (!zArr[i11]) {
                zArr[i11] = z5;
                List list3 = ((n1.a) list2.get(i11)).f2915e;
                int i13 = 0;
                while (true) {
                    if (i13 >= list3.size()) {
                        z3 = true;
                        eVar2 = null;
                        break;
                    }
                    n1.e eVar3 = (n1.e) list3.get(i13);
                    if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(eVar3.f2927a)) {
                        eVar2 = eVar3;
                        z3 = true;
                        break;
                    }
                    i13++;
                }
                if (eVar2 == null) {
                    i9 = i12 + 1;
                    iArr[i12] = new int[]{i11};
                } else {
                    int i14 = w.f1960a;
                    String[] split = eVar2.b.split(",", -1);
                    int length = split.length + 1;
                    int[] iArr2 = new int[length];
                    iArr2[0] = i11;
                    int length2 = split.length;
                    int i15 = 0;
                    int i16 = 1;
                    while (i15 < length2) {
                        String[] strArr = split;
                        int i17 = sparseIntArray.get(Integer.parseInt(split[i15]), -1);
                        if (i17 != -1) {
                            zArr[i17] = z3;
                            iArr2[i16] = i17;
                            i16++;
                        }
                        i15++;
                        split = strArr;
                    }
                    i9 = i12 + 1;
                    iArr[i12] = i16 < length ? Arrays.copyOf(iArr2, i16) : iArr2;
                }
                i12 = i9;
            }
            i11++;
            z5 = true;
        }
        iArr = i12 < size ? (int[][]) Arrays.copyOf(iArr, i12) : iArr;
        int length3 = iArr.length;
        boolean[] zArr2 = new boolean[length3];
        Format[][] formatArr2 = new Format[length3];
        int i18 = 0;
        int i19 = 0;
        while (i18 < length3) {
            int[] iArr3 = iArr[i18];
            int length4 = iArr3.length;
            int i20 = 0;
            while (true) {
                if (i20 >= length4) {
                    break;
                }
                List list4 = ((n1.a) list2.get(iArr3[i20])).c;
                for (int i21 = 0; i21 < list4.size(); i21++) {
                    if (!((n1.l) list4.get(i21)).d.isEmpty()) {
                        zArr2[i18] = true;
                        i19++;
                        break;
                    }
                }
                i20++;
            }
            int[] iArr4 = iArr[i18];
            int length5 = iArr4.length;
            int i22 = 0;
            while (true) {
                if (i22 < length5) {
                    int i23 = iArr4[i22];
                    n1.a aVar3 = (n1.a) list2.get(i23);
                    List list5 = ((n1.a) list2.get(i23)).d;
                    int i24 = 0;
                    while (i24 < list5.size()) {
                        n1.e eVar4 = (n1.e) list5.get(i24);
                        int[] iArr5 = iArr4;
                        int i25 = length5;
                        if ("urn:scte:dash:cc:cea-608:2015".equals(eVar4.f2927a)) {
                            String str = eVar4.b;
                            if (str != null) {
                                int i26 = w.f1960a;
                                String[] split2 = str.split(";", -1);
                                formatArr = new Format[split2.length];
                                int i27 = 0;
                                while (true) {
                                    if (i27 >= split2.length) {
                                        break;
                                    }
                                    Matcher matcher = w.matcher(split2[i27]);
                                    if (!matcher.matches()) {
                                        formatArr = new Format[]{a(aVar3.f2914a, -1, null)};
                                        break;
                                    }
                                    formatArr[i27] = a(aVar3.f2914a, Integer.parseInt(matcher.group(1)), matcher.group(2));
                                    i27++;
                                    split2 = split2;
                                    aVar3 = aVar3;
                                }
                            } else {
                                formatArr = new Format[]{a(aVar3.f2914a, -1, null)};
                            }
                            i8 = 1;
                        } else {
                            i24++;
                            iArr4 = iArr5;
                            length5 = i25;
                        }
                    }
                    i22++;
                    iArr4 = iArr4;
                } else {
                    i8 = 1;
                    formatArr = new Format[0];
                    break;
                }
            }
            formatArr2[i18] = formatArr;
            if (formatArr.length != 0) {
                i19 += i8;
            }
            i18 += i8;
        }
        int size2 = list.size() + i19 + length3;
        TrackGroup[] trackGroupArr = new TrackGroup[size2];
        a[] aVarArr = new a[size2];
        int i28 = 0;
        int i29 = 0;
        while (i29 < length3) {
            int[] iArr6 = iArr[i29];
            ArrayList arrayList = new ArrayList();
            int length6 = iArr6.length;
            int i30 = 0;
            while (i30 < length6) {
                arrayList.addAll(((n1.a) list2.get(iArr6[i30])).c);
                i30++;
                length3 = length3;
            }
            int i31 = length3;
            int size3 = arrayList.size();
            Format[] formatArr3 = new Format[size3];
            int i32 = 0;
            while (i32 < size3) {
                int i33 = size3;
                Format format = ((n1.l) arrayList.get(i32)).f2937a;
                int[][] iArr7 = iArr;
                if (format.f314l != null) {
                    bVar2.getClass();
                    format = format.d();
                }
                formatArr3[i32] = format;
                i32++;
                size3 = i33;
                iArr = iArr7;
            }
            int[][] iArr8 = iArr;
            n1.a aVar4 = (n1.a) list2.get(iArr6[0]);
            int i34 = i28 + 1;
            if (zArr2[i29]) {
                i6 = i28 + 2;
            } else {
                i6 = i34;
                i34 = -1;
            }
            if (formatArr2[i29].length != 0) {
                i7 = i6;
                i6++;
            } else {
                i7 = -1;
            }
            trackGroupArr[i28] = new TrackGroup(formatArr3);
            aVarArr[i28] = new a(aVar4.b, 0, iArr6, i28, i34, i7, -1);
            if (i34 != -1) {
                trackGroupArr[i34] = new TrackGroup(Format.o(aVar4.f2914a + ":emsg", "application/x-emsg"));
                aVarArr[i34] = new a(4, 1, iArr6, i28, -1, -1, -1);
            }
            if (i7 != -1) {
                trackGroupArr[i7] = new TrackGroup(formatArr2[i29]);
                aVarArr[i7] = new a(3, 1, iArr6, i28, -1, -1, -1);
            }
            i29++;
            length3 = i31;
            iArr = iArr8;
            i28 = i6;
        }
        int i35 = 1;
        int i36 = 0;
        while (i36 < list.size()) {
            Format[] formatArr4 = new Format[i35];
            formatArr4[0] = Format.o(((n1.f) list.get(i36)).a(), "application/x-emsg");
            trackGroupArr[i28] = new TrackGroup(formatArr4);
            aVarArr[i28] = new a(4, 2, new int[0], -1, -1, -1, i36);
            i35 = 1;
            i36++;
            i28++;
        }
        Pair create = Pair.create(new TrackGroupArray(trackGroupArr), aVarArr);
        this.f2773i = (TrackGroupArray) create.first;
        this.f2774j = (a[]) create.second;
        uVar.n();
    }

    public static Format a(int i3, int i5, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append(":cea608");
        if (i5 != -1) {
            str2 = a1.i.e(i5, ":");
        } else {
            str2 = "";
        }
        sb.append(str2);
        return Format.q(sb.toString(), "application/cea-608", 0, str, i5, null, Long.MAX_VALUE, null);
    }

    @Override // j1.l0
    public final void A(long j2) {
        this.f2781r.A(j2);
    }

    @Override // j1.m
    public final long b(long j2, o0 o0Var) {
        l1.g[] gVarArr;
        for (l1.g gVar : this.f2780p) {
            if (gVar.f2653a == 2) {
                return gVar.f2654e.b(j2, o0Var);
            }
        }
        return j2;
    }

    @Override // j1.l0
    public final boolean d() {
        return this.f2781r.d();
    }

    @Override // j1.k0
    public final void e(l0 l0Var) {
        l1.g gVar = (l1.g) l0Var;
        this.f2779o.e(this);
    }

    public final int f(int i3, int[] iArr) {
        int i5 = iArr[i3];
        if (i5 == -1) {
            return -1;
        }
        a[] aVarArr = this.f2774j;
        int i6 = aVarArr[i5].f2765e;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            int i8 = iArr[i7];
            if (i8 == i6 && aVarArr[i8].c == 0) {
                return i7;
            }
        }
        return -1;
    }

    @Override // j1.l0
    public final long i() {
        return this.f2781r.i();
    }

    @Override // j1.m
    public final long j() {
        if (!this.f2784v) {
            this.f2778n.q();
            this.f2784v = true;
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    @Override // j1.m
    public final TrackGroupArray o() {
        return this.f2773i;
    }

    @Override // j1.m
    public final void q(j1.l lVar, long j2) {
        this.f2779o = lVar;
        lVar.c(this);
    }

    @Override // j1.l0
    public final long s() {
        return this.f2781r.s();
    }

    @Override // j1.m
    public final void t() {
        this.f2771g.a();
    }

    @Override // j1.m
    public final void u(long j2, boolean z3) {
        for (l1.g gVar : this.f2780p) {
            gVar.u(j2, z3);
        }
    }

    @Override // j1.m
    public final long w(long j2) {
        o[] oVarArr;
        long j5;
        for (l1.g gVar : this.f2780p) {
            gVar.B(j2);
        }
        for (o oVar : this.q) {
            int b = w.b(oVar.c, j2, true, false);
            oVar.f2827g = b;
            if (oVar.d && b == oVar.c.length) {
                j5 = j2;
            } else {
                j5 = -9223372036854775807L;
            }
            oVar.f2828h = j5;
        }
        return j2;
    }

    @Override // j1.l0
    public final boolean y(long j2) {
        return this.f2781r.y(j2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j1.m
    public final long z(b2.n[] nVarArr, boolean[] zArr, j0[] j0VarArr, boolean[] zArr2, long j2) {
        int i3;
        boolean z3;
        int[] iArr;
        int i5;
        j0[] j0VarArr2;
        int[] iArr2;
        boolean z5;
        TrackGroup trackGroup;
        int i6;
        boolean z6;
        TrackGroup trackGroup2;
        int i7;
        q qVar;
        boolean z7;
        b2.n[] nVarArr2 = nVarArr;
        j0[] j0VarArr3 = j0VarArr;
        int[] iArr3 = new int[nVarArr2.length];
        int i8 = 0;
        while (true) {
            i3 = -1;
            if (i8 >= nVarArr2.length) {
                break;
            }
            b2.n nVar = nVarArr2[i8];
            if (nVar != null) {
                iArr3[i8] = this.f2773i.c(((b2.d) nVar).f139a);
            } else {
                iArr3[i8] = -1;
            }
            i8++;
        }
        for (int i9 = 0; i9 < nVarArr2.length; i9++) {
            if (nVarArr2[i9] == null || !zArr[i9]) {
                j0 j0Var = j0VarArr3[i9];
                if (j0Var instanceof l1.g) {
                    ((l1.g) j0Var).x(this);
                } else if (j0Var instanceof l1.e) {
                    l1.e eVar = (l1.e) j0Var;
                    l1.g gVar = eVar.f2652e;
                    boolean[] zArr3 = gVar.d;
                    int i10 = eVar.c;
                    g2.b.h(zArr3[i10]);
                    gVar.d[i10] = false;
                }
                j0VarArr3[i9] = null;
            }
        }
        int i11 = 0;
        while (true) {
            z3 = true;
            if (i11 >= nVarArr2.length) {
                break;
            }
            j0 j0Var2 = j0VarArr3[i11];
            if ((j0Var2 instanceof j1.g) || (j0Var2 instanceof l1.e)) {
                int f4 = f(i11, iArr3);
                if (f4 == -1) {
                    z7 = j0VarArr3[i11] instanceof j1.g;
                } else {
                    j0 j0Var3 = j0VarArr3[i11];
                    z7 = ((j0Var3 instanceof l1.e) && ((l1.e) j0Var3).f2651a == j0VarArr3[f4]) ? false : false;
                }
                if (!z7) {
                    j0 j0Var4 = j0VarArr3[i11];
                    if (j0Var4 instanceof l1.e) {
                        l1.e eVar2 = (l1.e) j0Var4;
                        l1.g gVar2 = eVar2.f2652e;
                        boolean[] zArr4 = gVar2.d;
                        int i12 = eVar2.c;
                        g2.b.h(zArr4[i12]);
                        gVar2.d[i12] = false;
                    }
                    j0VarArr3[i11] = null;
                }
            }
            i11++;
        }
        int i13 = 0;
        while (i13 < nVarArr2.length) {
            b2.n nVar2 = nVarArr2[i13];
            if (nVar2 == null) {
                i5 = i13;
                j0VarArr2 = j0VarArr3;
                iArr2 = iArr3;
            } else {
                j0 j0Var5 = j0VarArr3[i13];
                if (j0Var5 == null) {
                    zArr2[i13] = z3;
                    a aVar = this.f2774j[iArr3[i13]];
                    int i14 = aVar.c;
                    if (i14 == 0) {
                        int i15 = aVar.f2766f;
                        if (i15 != i3) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            trackGroup = this.f2773i.b[i15];
                            i6 = 1;
                        } else {
                            trackGroup = null;
                            i6 = 0;
                        }
                        int i16 = aVar.f2767g;
                        if (i16 != i3) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            trackGroup2 = this.f2773i.b[i16];
                            i6 += trackGroup2.f384a;
                        } else {
                            trackGroup2 = null;
                        }
                        Format[] formatArr = new Format[i6];
                        int[] iArr4 = new int[i6];
                        if (z5) {
                            formatArr[0] = trackGroup.b[0];
                            iArr4[0] = 4;
                            i7 = 1;
                        } else {
                            i7 = 0;
                        }
                        ArrayList arrayList = new ArrayList();
                        if (z6) {
                            for (int i17 = 0; i17 < trackGroup2.f384a; i17++) {
                                Format format = trackGroup2.b[i17];
                                formatArr[i7] = format;
                                iArr4[i7] = 3;
                                arrayList.add(format);
                                i7++;
                            }
                        }
                        if (this.s.c && z5) {
                            r rVar = this.f2776l;
                            qVar = new q(rVar, rVar.f2831a);
                        } else {
                            qVar = null;
                        }
                        k kVar = this.b;
                        g0 g0Var = this.f2771g;
                        n1.b bVar = this.s;
                        int i18 = i13;
                        int i19 = this.f2782t;
                        int[] iArr5 = aVar.f2764a;
                        int i20 = aVar.b;
                        iArr2 = iArr3;
                        long j5 = this.f2770f;
                        m0 m0Var = this.c;
                        e2.i createDataSource = kVar.f2811a.createDataSource();
                        if (m0Var != null) {
                            createDataSource.addTransferListener(m0Var);
                        }
                        q qVar2 = qVar;
                        i5 = i18;
                        l1.g gVar3 = new l1.g(aVar.b, iArr4, formatArr, new n(g0Var, bVar, i19, iArr5, nVar2, i20, createDataSource, j5, z5, arrayList, qVar), this, this.f2772h, j2, this.d, this.f2769e, this.f2778n);
                        synchronized (this) {
                            this.f2777m.put(gVar3, qVar2);
                        }
                        j0VarArr2 = j0VarArr;
                        j0VarArr2[i5] = gVar3;
                    } else {
                        i5 = i13;
                        j0VarArr2 = j0VarArr3;
                        iArr2 = iArr3;
                        if (i14 == 2) {
                            j0VarArr2[i5] = new o((n1.f) this.f2783u.get(aVar.d), ((b2.d) nVar2).f139a.b[0], this.s.c);
                        }
                    }
                } else {
                    i5 = i13;
                    j0VarArr2 = j0VarArr3;
                    iArr2 = iArr3;
                    if (j0Var5 instanceof l1.g) {
                        ((n) ((l1.g) j0Var5).f2654e).f2818h = nVar2;
                    }
                }
            }
            i13 = i5 + 1;
            j0VarArr3 = j0VarArr2;
            iArr3 = iArr2;
            z3 = true;
            i3 = -1;
            nVarArr2 = nVarArr;
        }
        j0[] j0VarArr4 = j0VarArr3;
        int[] iArr6 = iArr3;
        int i21 = 0;
        while (i21 < nVarArr.length) {
            if (j0VarArr4[i21] == 0 && nVarArr[i21] != null) {
                a aVar2 = this.f2774j[iArr6[i21]];
                if (aVar2.c == 1) {
                    iArr = iArr6;
                    int f5 = f(i21, iArr);
                    if (f5 == -1) {
                        j0VarArr4[i21] = new Object();
                    } else {
                        l1.g gVar4 = (l1.g) j0VarArr4[f5];
                        int i22 = aVar2.b;
                        int i23 = 0;
                        while (true) {
                            i0[] i0VarArr = gVar4.f2663n;
                            if (i23 < i0VarArr.length) {
                                if (gVar4.b[i23] == i22) {
                                    boolean[] zArr5 = gVar4.d;
                                    g2.b.h(!zArr5[i23]);
                                    zArr5[i23] = true;
                                    i0VarArr[i23].B(j2, true);
                                    j0VarArr4[i21] = new l1.e(gVar4, gVar4, i0VarArr[i23], i23);
                                    break;
                                }
                                i23++;
                            } else {
                                throw new IllegalStateException();
                            }
                        }
                    }
                    i21++;
                    iArr6 = iArr;
                }
            }
            iArr = iArr6;
            i21++;
            iArr6 = iArr;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object[] objArr : j0VarArr4) {
            if (objArr instanceof l1.g) {
                arrayList2.add((l1.g) objArr);
            } else if (objArr instanceof o) {
                arrayList3.add((o) objArr);
            }
        }
        l1.g[] gVarArr = new l1.g[arrayList2.size()];
        this.f2780p = gVarArr;
        arrayList2.toArray(gVarArr);
        o[] oVarArr = new o[arrayList3.size()];
        this.q = oVarArr;
        arrayList3.toArray(oVarArr);
        j3.a aVar3 = this.f2775k;
        l1.g[] gVarArr2 = this.f2780p;
        aVar3.getClass();
        this.f2781r = new b3.e(10, gVarArr2);
        return j2;
    }
}

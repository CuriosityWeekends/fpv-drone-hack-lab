package p1;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import e2.a0;
import e2.c0;
import e2.f0;
import e2.i0;
import e2.k0;
import e2.l;
import e2.z;
import j1.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import m1.k;
import o1.p;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements z {

    /* renamed from: p  reason: collision with root package name */
    public static final a1.f f3142p = new a1.f(4);

    /* renamed from: a  reason: collision with root package name */
    public final k f3143a;
    public final j3.b b;
    public final j3.a c;

    /* renamed from: f  reason: collision with root package name */
    public i f3145f;

    /* renamed from: g  reason: collision with root package name */
    public u f3146g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f3147h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f3148i;

    /* renamed from: j  reason: collision with root package name */
    public j f3149j;

    /* renamed from: k  reason: collision with root package name */
    public e f3150k;

    /* renamed from: l  reason: collision with root package name */
    public Uri f3151l;

    /* renamed from: m  reason: collision with root package name */
    public g f3152m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3153n;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f3144e = new ArrayList();
    public final HashMap d = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    public long f3154o = -9223372036854775807L;

    public b(k kVar, j3.a aVar, j3.b bVar) {
        this.f3143a = kVar;
        this.b = bVar;
        this.c = aVar;
    }

    public static boolean a(b bVar, Uri uri, long j2) {
        o1.f fVar;
        ArrayList arrayList;
        int i3;
        int i5;
        boolean z3;
        ArrayList arrayList2 = bVar.f3144e;
        int size = arrayList2.size();
        int i6 = 0;
        boolean z5 = false;
        while (i6 < size) {
            o1.j jVar = (o1.j) arrayList2.get(i6);
            p[] pVarArr = jVar.f3004r;
            int length = pVarArr.length;
            int i7 = 0;
            boolean z6 = true;
            while (i7 < length) {
                p pVar = pVarArr[i7];
                int i8 = 0;
                while (true) {
                    fVar = pVar.c;
                    Uri[] uriArr = fVar.f2962e;
                    arrayList = arrayList2;
                    i3 = size;
                    if (i8 < uriArr.length) {
                        if (uriArr[i8].equals(uri)) {
                            break;
                        }
                        i8++;
                        arrayList2 = arrayList;
                        size = i3;
                    } else {
                        i8 = -1;
                        break;
                    }
                }
                if (i8 != -1 && (i5 = ((b2.d) fVar.f2973p).i(i8)) != -1) {
                    fVar.f2974r |= uri.equals(fVar.f2971n);
                    if (j2 != -9223372036854775807L && !((b2.d) fVar.f2973p).h(i5, j2)) {
                        z3 = false;
                        z6 &= z3;
                        i7++;
                        arrayList2 = arrayList;
                        size = i3;
                    }
                }
                z3 = true;
                z6 &= z3;
                i7++;
                arrayList2 = arrayList;
                size = i3;
            }
            jVar.f3002o.e(jVar);
            z5 |= !z6;
            i6++;
            arrayList2 = arrayList2;
            size = size;
        }
        return z5;
    }

    public final g b(Uri uri, boolean z3) {
        HashMap hashMap = this.d;
        g gVar = ((a) hashMap.get(uri)).d;
        if (gVar != null && z3 && !uri.equals(this.f3151l)) {
            List list = this.f3150k.f3160e;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                } else if (uri.equals(((d) list.get(i3)).f3156a)) {
                    g gVar2 = this.f3152m;
                    if (gVar2 == null || !gVar2.f3182l) {
                        this.f3151l = uri;
                        ((a) hashMap.get(uri)).b();
                    }
                } else {
                    i3++;
                }
            }
        }
        return gVar;
    }

    public final boolean c(Uri uri) {
        int i3;
        a aVar = (a) this.d.get(uri);
        if (aVar.d == null) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long max = Math.max(30000L, j0.i.b(aVar.d.f3186p));
        g gVar = aVar.d;
        if (!gVar.f3182l && (i3 = gVar.d) != 2 && i3 != 1 && aVar.f3135e + max <= elapsedRealtime) {
            return false;
        }
        return true;
    }

    @Override // e2.z
    public final void f(c0 c0Var, long j2, long j5, boolean z3) {
        i0 i0Var = (i0) c0Var;
        u uVar = this.f3146g;
        l lVar = i0Var.f1688a;
        Uri uri = i0Var.c.c;
        uVar.d(4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // e2.z
    public final a0 k(c0 c0Var, long j2, long j5, IOException iOException, int i3) {
        boolean z3;
        i0 i0Var = (i0) c0Var;
        int i5 = i0Var.b;
        this.c.getClass();
        long m5 = j3.a.m(i3, iOException);
        if (m5 == -9223372036854775807L) {
            z3 = true;
        } else {
            z3 = false;
        }
        u uVar = this.f3146g;
        k0 k0Var = i0Var.c;
        Uri uri = k0Var.c;
        uVar.j(4, j2, j5, k0Var.b, iOException, z3);
        if (z3) {
            return f0.f1685e;
        }
        return new a0(0, m5);
    }

    @Override // e2.z
    public final void l(c0 c0Var, long j2, long j5) {
        e eVar;
        i0 i0Var = (i0) c0Var;
        h hVar = (h) i0Var.f1689e;
        boolean z3 = hVar instanceof g;
        if (z3) {
            String str = hVar.f3187a;
            e eVar2 = e.f3159l;
            eVar = new e("", Collections.emptyList(), Collections.singletonList(new d(Uri.parse(str), Format.l("0", null, "application/x-mpegURL", null, null, -1, 0, 0, null), null, null, null, null)), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
        } else {
            eVar = (e) hVar;
        }
        this.f3150k = eVar;
        this.b.getClass();
        this.f3145f = new i(eVar);
        this.f3151l = ((d) eVar.f3160e.get(0)).f3156a;
        List list = eVar.d;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Uri uri = (Uri) list.get(i3);
            this.d.put(uri, new a(this, uri));
        }
        a aVar = (a) this.d.get(this.f3151l);
        if (z3) {
            aVar.c((g) hVar, j5);
        } else {
            aVar.b();
        }
        u uVar = this.f3146g;
        k0 k0Var = i0Var.c;
        Uri uri2 = k0Var.c;
        uVar.g(4, j2, j5, k0Var.b);
    }
}

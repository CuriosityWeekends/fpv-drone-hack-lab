package o1;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import e2.m0;
import g2.w;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final h f2961a;
    public final e2.i b;
    public final e2.i c;
    public final q d;

    /* renamed from: e  reason: collision with root package name */
    public final Uri[] f2962e;

    /* renamed from: f  reason: collision with root package name */
    public final Format[] f2963f;

    /* renamed from: g  reason: collision with root package name */
    public final p1.b f2964g;

    /* renamed from: h  reason: collision with root package name */
    public final TrackGroup f2965h;

    /* renamed from: i  reason: collision with root package name */
    public final List f2966i;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2968k;

    /* renamed from: m  reason: collision with root package name */
    public j1.b f2970m;

    /* renamed from: n  reason: collision with root package name */
    public Uri f2971n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2972o;

    /* renamed from: p  reason: collision with root package name */
    public b2.n f2973p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2974r;

    /* renamed from: j  reason: collision with root package name */
    public final b3.e f2967j = new b3.e(23);

    /* renamed from: l  reason: collision with root package name */
    public byte[] f2969l = w.f1962f;
    public long q = -9223372036854775807L;

    /* JADX WARN: Type inference failed for: r3v1, types: [o1.e, b2.d, b2.n] */
    public f(h hVar, p1.b bVar, Uri[] uriArr, Format[] formatArr, m1.k kVar, m0 m0Var, q qVar, List list) {
        this.f2961a = hVar;
        this.f2964g = bVar;
        this.f2962e = uriArr;
        this.f2963f = formatArr;
        this.d = qVar;
        this.f2966i = list;
        e2.i createDataSource = kVar.f2811a.createDataSource();
        this.b = createDataSource;
        if (m0Var != null) {
            createDataSource.addTransferListener(m0Var);
        }
        this.c = kVar.f2811a.createDataSource();
        this.f2965h = new TrackGroup(formatArr);
        int[] iArr = new int[uriArr.length];
        for (int i3 = 0; i3 < uriArr.length; i3++) {
            iArr[i3] = i3;
        }
        TrackGroup trackGroup = this.f2965h;
        ?? dVar = new b2.d(trackGroup, iArr);
        dVar.f2960g = dVar.j(trackGroup.b[0]);
        this.f2973p = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final l1.l[] a(i iVar, long j2) {
        int c;
        boolean z3;
        if (iVar == null) {
            c = -1;
        } else {
            c = this.f2965h.c(iVar.c);
        }
        int length = ((b2.d) this.f2973p).c.length;
        l1.l[] lVarArr = new l1.l[length];
        boolean z5 = false;
        int i3 = 0;
        while (i3 < length) {
            int i5 = ((b2.d) this.f2973p).c[i3];
            Uri uri = this.f2962e[i5];
            p1.b bVar = this.f2964g;
            boolean c5 = bVar.c(uri);
            j3.b bVar2 = l1.l.f2681a0;
            if (!c5) {
                lVarArr[i3] = bVar2;
            } else {
                p1.g b = bVar.b(uri, z5);
                b.getClass();
                long j5 = b.f3176f - bVar.f3154o;
                if (i5 != c) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (b(iVar, z3, b, j5, j2) < b.f3179i) {
                    lVarArr[i3] = bVar2;
                } else {
                    b.f3185o.size();
                    lVarArr[i3] = new Object();
                }
            }
            i3++;
            z5 = false;
        }
        return lVarArr;
    }

    public final long b(i iVar, boolean z3, p1.g gVar, long j2, long j5) {
        boolean z5;
        if (iVar != null && !z3) {
            return iVar.c();
        }
        long j6 = gVar.f3186p + j2;
        if (iVar != null && !this.f2972o) {
            j5 = iVar.f2639f;
        }
        boolean z6 = gVar.f3182l;
        List list = gVar.f3185o;
        long j7 = gVar.f3179i;
        if (!z6 && j5 >= j6) {
            return j7 + list.size();
        }
        Long valueOf = Long.valueOf(j5 - j2);
        if (this.f2964g.f3153n && iVar != null) {
            z5 = false;
        } else {
            z5 = true;
        }
        return w.c(list, valueOf, z5) + j7;
    }

    /* JADX WARN: Type inference failed for: r13v1, types: [l1.b, o1.d] */
    public final d c(Uri uri, int i3) {
        if (uri == null) {
            return null;
        }
        b3.e eVar = this.f2967j;
        byte[] bArr = (byte[]) ((c) eVar.b).remove(uri);
        if (bArr != null) {
            byte[] bArr2 = (byte[]) ((c) eVar.b).put(uri, bArr);
            return null;
        }
        e2.l lVar = new e2.l(uri, 0L, 0L, -1L, null, 1);
        Format format = this.f2963f[i3];
        int b = this.f2973p.b();
        Object f4 = this.f2973p.f();
        byte[] bArr3 = this.f2969l;
        ?? bVar = new l1.b(this.c, lVar, 3, format, b, f4, -9223372036854775807L, -9223372036854775807L);
        bVar.f2957i = bArr3;
        return bVar;
    }
}

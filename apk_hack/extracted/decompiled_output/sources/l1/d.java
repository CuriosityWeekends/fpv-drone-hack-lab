package l1;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import p0.r;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements p0.k {

    /* renamed from: a  reason: collision with root package name */
    public final p0.j f2645a;
    public final int b;
    public final Format c;
    public final SparseArray d = new SparseArray();

    /* renamed from: e  reason: collision with root package name */
    public boolean f2646e;

    /* renamed from: f  reason: collision with root package name */
    public c1.b f2647f;

    /* renamed from: g  reason: collision with root package name */
    public long f2648g;

    /* renamed from: h  reason: collision with root package name */
    public r f2649h;

    /* renamed from: i  reason: collision with root package name */
    public Format[] f2650i;

    public d(p0.j jVar, int i3, Format format) {
        this.f2645a = jVar;
        this.b = i3;
        this.c = format;
    }

    @Override // p0.k
    public final void a(r rVar) {
        this.f2649h = rVar;
    }

    public final void b(c1.b bVar, long j2, long j5) {
        this.f2647f = bVar;
        this.f2648g = j5;
        boolean z3 = this.f2646e;
        p0.j jVar = this.f2645a;
        if (!z3) {
            jVar.b(this);
            if (j2 != -9223372036854775807L) {
                jVar.d(0L, j2);
            }
            this.f2646e = true;
            return;
        }
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        jVar.d(0L, j2);
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.d;
            if (i3 < sparseArray.size()) {
                c cVar = (c) sparseArray.valueAt(i3);
                if (bVar == null) {
                    cVar.f2643e = cVar.c;
                } else {
                    cVar.f2644f = j5;
                    u B = bVar.B(cVar.f2642a);
                    cVar.f2643e = B;
                    Format format = cVar.d;
                    if (format != null) {
                        B.d(format);
                    }
                }
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // p0.k
    public final void c() {
        SparseArray sparseArray = this.d;
        Format[] formatArr = new Format[sparseArray.size()];
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            formatArr[i3] = ((c) sparseArray.valueAt(i3)).d;
        }
        this.f2650i = formatArr;
    }

    @Override // p0.k
    public final u g(int i3, int i5) {
        boolean z3;
        Format format;
        SparseArray sparseArray = this.d;
        c cVar = (c) sparseArray.get(i3);
        if (cVar == null) {
            if (this.f2650i == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            g2.b.h(z3);
            if (i5 == this.b) {
                format = this.c;
            } else {
                format = null;
            }
            cVar = new c(i3, i5, format);
            c1.b bVar = this.f2647f;
            long j2 = this.f2648g;
            if (bVar == null) {
                cVar.f2643e = cVar.c;
            } else {
                cVar.f2644f = j2;
                u B = bVar.B(i5);
                cVar.f2643e = B;
                Format format2 = cVar.d;
                if (format2 != null) {
                    B.d(format2);
                }
            }
            sparseArray.put(i3, cVar);
        }
        return cVar;
    }
}

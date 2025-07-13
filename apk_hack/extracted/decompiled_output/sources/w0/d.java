package w0;

import j0.f0;
import java.util.Arrays;
import p0.k;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements p0.j {

    /* renamed from: a  reason: collision with root package name */
    public k f3913a;
    public i b;
    public boolean c;

    public final boolean a(p0.g gVar) {
        boolean z3;
        boolean equals;
        f fVar = new f();
        if (fVar.a(gVar, true) && (fVar.f3916a & 2) == 2) {
            int min = Math.min(fVar.f3917e, 8);
            c0.b bVar = new c0.b(min);
            gVar.d(bVar.f187a, 0, min, false);
            bVar.y(0);
            if (bVar.a() >= 5 && bVar.n() == 127 && bVar.o() == 1179402563) {
                this.b = new i();
            } else {
                bVar.y(0);
                try {
                    z3 = com.bumptech.glide.e.i(1, bVar, true);
                } catch (f0 unused) {
                    z3 = false;
                }
                if (z3) {
                    this.b = new i();
                } else {
                    bVar.y(0);
                    if (bVar.a() < 8) {
                        equals = false;
                    } else {
                        byte[] bArr = new byte[8];
                        bVar.b(bArr, 0, 8);
                        equals = Arrays.equals(bArr, h.f3920o);
                    }
                    if (equals) {
                        this.b = new i();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // p0.j
    public final void b(k kVar) {
        this.f3913a = kVar;
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        i iVar = this.b;
        if (iVar != null) {
            e eVar = iVar.f3922a;
            f fVar = eVar.f3914a;
            fVar.f3916a = 0;
            fVar.b = 0L;
            fVar.c = 0;
            fVar.d = 0;
            fVar.f3917e = 0;
            eVar.b.u();
            eVar.c = -1;
            eVar.f3915e = false;
            if (j2 == 0) {
                iVar.d(!iVar.f3930l);
            } else if (iVar.f3926h != 0) {
                long j6 = (iVar.f3927i * j5) / 1000000;
                iVar.f3923e = j6;
                iVar.d.c(j6);
                iVar.f3926h = 2;
            }
        }
    }

    @Override // p0.j
    public final boolean f(p0.g gVar) {
        try {
            return a(gVar);
        } catch (f0 unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v4, types: [w0.g, java.lang.Object] */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(p0.g r21, p0.m r22) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.d.h(p0.g, p0.m):int");
    }
}

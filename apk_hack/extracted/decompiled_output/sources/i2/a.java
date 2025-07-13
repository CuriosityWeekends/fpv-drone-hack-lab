package i2;

import com.google.android.exoplayer2.Format;
import d2.f;
import g2.w;
import j0.h;
import java.nio.ByteBuffer;
import m0.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends h {

    /* renamed from: l  reason: collision with root package name */
    public final d f2176l;

    /* renamed from: m  reason: collision with root package name */
    public final c0.b f2177m;

    /* renamed from: n  reason: collision with root package name */
    public long f2178n;

    /* renamed from: o  reason: collision with root package name */
    public f f2179o;

    /* renamed from: p  reason: collision with root package name */
    public long f2180p;

    public a() {
        super(5);
        this.f2176l = new d(1);
        this.f2177m = new c0.b();
    }

    @Override // j0.h
    public final void f(int i3, Object obj) {
        if (i3 == 7) {
            this.f2179o = (f) obj;
        }
    }

    @Override // j0.h
    public final boolean h() {
        return g();
    }

    @Override // j0.h
    public final boolean i() {
        return true;
    }

    @Override // j0.h
    public final void j() {
        w();
    }

    @Override // j0.h
    public final void l(long j2, boolean z3) {
        w();
    }

    @Override // j0.h
    public final void p(Format[] formatArr, long j2) {
        this.f2178n = j2;
    }

    @Override // j0.h
    public final void r(long j2, long j5) {
        float[] fArr;
        while (!g() && this.f2180p < 100000 + j2) {
            d dVar = this.f2176l;
            dVar.clear();
            j0.b bVar = this.b;
            bVar.b();
            if (q(bVar, dVar, false) == -4 && !dVar.isEndOfStream()) {
                dVar.d();
                this.f2180p = dVar.c;
                if (this.f2179o != null) {
                    ByteBuffer byteBuffer = dVar.b;
                    int i3 = w.f1960a;
                    if (byteBuffer.remaining() != 16) {
                        fArr = null;
                    } else {
                        byte[] array = byteBuffer.array();
                        int limit = byteBuffer.limit();
                        c0.b bVar2 = this.f2177m;
                        bVar2.w(array, limit);
                        bVar2.y(byteBuffer.arrayOffset() + 4);
                        float[] fArr2 = new float[3];
                        for (int i5 = 0; i5 < 3; i5++) {
                            fArr2[i5] = Float.intBitsToFloat(bVar2.e());
                        }
                        fArr = fArr2;
                    }
                    if (fArr != null) {
                        ((d2.c) this.f2179o.d.d).a(this.f2180p - this.f2178n, fArr);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // j0.h
    public final int u(Format format) {
        if ("application/x-camera-motion".equals(format.f311i)) {
            return 4;
        }
        return 0;
    }

    public final void w() {
        this.f2180p = 0L;
        f fVar = this.f2179o;
        if (fVar != null) {
            fVar.f1617e.b();
            e.c cVar = fVar.d;
            ((d2.c) cVar.d).b();
            cVar.f1650a = false;
            fVar.b.set(true);
        }
    }
}

package x0;

import c0.b;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import p0.g;
import p0.j;
import p0.k;
import p0.m;
import p0.n;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public final Format f3955a;
    public u c;

    /* renamed from: e  reason: collision with root package name */
    public int f3956e;

    /* renamed from: f  reason: collision with root package name */
    public long f3957f;

    /* renamed from: g  reason: collision with root package name */
    public int f3958g;

    /* renamed from: h  reason: collision with root package name */
    public int f3959h;
    public final b b = new b(9);
    public int d = 0;

    public a(Format format) {
        this.f3955a = format;
    }

    @Override // p0.j
    public final void b(k kVar) {
        kVar.a(new n(-9223372036854775807L));
        this.c = kVar.g(0, 3);
        kVar.c();
        this.c.d(this.f3955a);
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        this.d = 0;
    }

    @Override // p0.j
    public final boolean f(g gVar) {
        b bVar = this.b;
        bVar.u();
        gVar.d(bVar.f187a, 0, 8, false);
        if (bVar.c() != 1380139777) {
            return false;
        }
        return true;
    }

    @Override // p0.j
    public final int h(g gVar, m mVar) {
        while (true) {
            int i3 = this.d;
            b bVar = this.b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        while (this.f3958g > 0) {
                            bVar.u();
                            gVar.g(bVar.f187a, 0, 3, false);
                            this.c.b(3, bVar);
                            this.f3959h += 3;
                            this.f3958g--;
                        }
                        int i5 = this.f3959h;
                        if (i5 > 0) {
                            this.c.c(this.f3957f, 1, i5, 0, null);
                        }
                        this.d = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                }
                bVar.u();
                int i6 = this.f3956e;
                if (i6 == 0) {
                    if (!gVar.g(bVar.f187a, 0, 5, true)) {
                        break;
                    }
                    this.f3957f = (bVar.o() * 1000) / 45;
                    this.f3958g = bVar.n();
                    this.f3959h = 0;
                    this.d = 2;
                } else if (i6 == 1) {
                    if (!gVar.g(bVar.f187a, 0, 9, true)) {
                        break;
                    }
                    this.f3957f = bVar.h();
                    this.f3958g = bVar.n();
                    this.f3959h = 0;
                    this.d = 2;
                } else {
                    throw new IOException("Unsupported version number: " + this.f3956e);
                }
            } else {
                bVar.u();
                if (!gVar.g(bVar.f187a, 0, 8, true)) {
                    return -1;
                }
                if (bVar.c() == 1380139777) {
                    this.f3956e = bVar.n();
                    this.d = 1;
                } else {
                    throw new IOException("Input not RawCC");
                }
            }
        }
        this.d = 0;
        return -1;
    }
}

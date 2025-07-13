package j1;

import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final e2.m f2411a;
    public final int b;
    public final c0.b c;
    public g2.s d;

    /* renamed from: e  reason: collision with root package name */
    public g2.s f2412e;

    /* renamed from: f  reason: collision with root package name */
    public g2.s f2413f;

    /* renamed from: g  reason: collision with root package name */
    public long f2414g;

    public f0(e2.m mVar) {
        this.f2411a = mVar;
        int i3 = mVar.b;
        this.b = i3;
        this.c = new c0.b(32);
        g2.s sVar = new g2.s(i3, 0L);
        this.d = sVar;
        this.f2412e = sVar;
        this.f2413f = sVar;
    }

    public final void a(g2.s sVar) {
        if (!sVar.c) {
            return;
        }
        g2.s sVar2 = this.f2413f;
        int i3 = (((int) (sVar2.f1955a - sVar.f1955a)) / this.b) + (sVar2.c ? 1 : 0);
        e2.a[] aVarArr = new e2.a[i3];
        int i5 = 0;
        while (i5 < i3) {
            aVarArr[i5] = (e2.a) sVar.d;
            sVar.d = null;
            sVar.f1956e = null;
            i5++;
            sVar = (g2.s) sVar.f1956e;
        }
        this.f2411a.a(aVarArr);
    }

    public final void b(long j2) {
        g2.s sVar;
        if (j2 == -1) {
            return;
        }
        while (true) {
            sVar = this.d;
            if (j2 < sVar.b) {
                break;
            }
            e2.m mVar = this.f2411a;
            e2.a aVar = (e2.a) sVar.d;
            synchronized (mVar) {
                e2.a[] aVarArr = mVar.c;
                aVarArr[0] = aVar;
                mVar.a(aVarArr);
            }
            g2.s sVar2 = this.d;
            sVar2.d = null;
            sVar2.f1956e = null;
            this.d = (g2.s) sVar2.f1956e;
        }
        if (this.f2412e.f1955a < sVar.f1955a) {
            this.f2412e = sVar;
        }
    }

    public final int c(int i3) {
        e2.a aVar;
        g2.s sVar = this.f2413f;
        if (!sVar.c) {
            e2.m mVar = this.f2411a;
            synchronized (mVar) {
                try {
                    mVar.f1702e++;
                    int i5 = mVar.f1703f;
                    if (i5 > 0) {
                        e2.a[] aVarArr = mVar.f1704g;
                        int i6 = i5 - 1;
                        mVar.f1703f = i6;
                        aVar = aVarArr[i6];
                        aVarArr[i6] = null;
                    } else {
                        aVar = new e2.a(new byte[mVar.b], 0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            g2.s sVar2 = new g2.s(this.b, this.f2413f.b);
            sVar.d = aVar;
            sVar.f1956e = sVar2;
            sVar.c = true;
        }
        return Math.min(i3, (int) (this.f2413f.b - this.f2414g));
    }

    public final void d(long j2, int i3, ByteBuffer byteBuffer) {
        while (true) {
            g2.s sVar = this.f2412e;
            if (j2 < sVar.b) {
                break;
            }
            this.f2412e = (g2.s) sVar.f1956e;
        }
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.f2412e.b - j2));
            g2.s sVar2 = this.f2412e;
            e2.a aVar = (e2.a) sVar2.d;
            byteBuffer.put(aVar.f1671a, ((int) (j2 - sVar2.f1955a)) + aVar.b, min);
            i3 -= min;
            j2 += min;
            g2.s sVar3 = this.f2412e;
            if (j2 == sVar3.b) {
                this.f2412e = (g2.s) sVar3.f1956e;
            }
        }
    }

    public final void e(byte[] bArr, int i3, long j2) {
        while (true) {
            g2.s sVar = this.f2412e;
            if (j2 < sVar.b) {
                break;
            }
            this.f2412e = (g2.s) sVar.f1956e;
        }
        int i5 = i3;
        while (i5 > 0) {
            int min = Math.min(i5, (int) (this.f2412e.b - j2));
            g2.s sVar2 = this.f2412e;
            e2.a aVar = (e2.a) sVar2.d;
            System.arraycopy(aVar.f1671a, ((int) (j2 - sVar2.f1955a)) + aVar.b, bArr, i3 - i5, min);
            i5 -= min;
            j2 += min;
            g2.s sVar3 = this.f2412e;
            if (j2 == sVar3.b) {
                this.f2412e = (g2.s) sVar3.f1956e;
            }
        }
    }
}

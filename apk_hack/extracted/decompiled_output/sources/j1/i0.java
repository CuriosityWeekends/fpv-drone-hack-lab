package j1;

import android.media.MediaCodec;
import android.os.Looper;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class i0 implements p0.u {
    public boolean A;
    public Format B;
    public long C;
    public boolean D;

    /* renamed from: a  reason: collision with root package name */
    public final f0 f2418a;
    public final n0.b c;
    public h0 d;

    /* renamed from: e  reason: collision with root package name */
    public Format f2419e;

    /* renamed from: f  reason: collision with root package name */
    public b3.e f2420f;

    /* renamed from: o  reason: collision with root package name */
    public int f2429o;

    /* renamed from: p  reason: collision with root package name */
    public int f2430p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public int f2431r;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2433u;

    /* renamed from: x  reason: collision with root package name */
    public Format f2435x;

    /* renamed from: y  reason: collision with root package name */
    public Format f2436y;

    /* renamed from: z  reason: collision with root package name */
    public int f2437z;
    public final g0 b = new Object();

    /* renamed from: g  reason: collision with root package name */
    public int f2421g = 1000;

    /* renamed from: h  reason: collision with root package name */
    public int[] f2422h = new int[1000];

    /* renamed from: i  reason: collision with root package name */
    public long[] f2423i = new long[1000];

    /* renamed from: l  reason: collision with root package name */
    public long[] f2426l = new long[1000];

    /* renamed from: k  reason: collision with root package name */
    public int[] f2425k = new int[1000];

    /* renamed from: j  reason: collision with root package name */
    public int[] f2424j = new int[1000];

    /* renamed from: m  reason: collision with root package name */
    public p0.t[] f2427m = new p0.t[1000];

    /* renamed from: n  reason: collision with root package name */
    public Format[] f2428n = new Format[1000];
    public long s = Long.MIN_VALUE;

    /* renamed from: t  reason: collision with root package name */
    public long f2432t = Long.MIN_VALUE;
    public boolean w = true;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2434v = true;

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, j1.g0] */
    public i0(e2.m mVar, n0.b bVar) {
        this.f2418a = new f0(mVar);
        this.c = bVar;
    }

    public final synchronized void A() {
        this.f2431r = 0;
        f0 f0Var = this.f2418a;
        f0Var.f2412e = f0Var.d;
    }

    public final synchronized boolean B(long j2, boolean z3) {
        A();
        int r5 = r(this.f2431r);
        if (t() && j2 >= this.f2426l[r5] && (j2 <= this.f2432t || z3)) {
            int m5 = m(r5, this.f2429o - this.f2431r, j2, true);
            if (m5 == -1) {
                return false;
            }
            this.f2431r += m5;
            return true;
        }
        return false;
    }

    @Override // p0.u
    public final int a(p0.g gVar, int i3, boolean z3) {
        f0 f0Var = this.f2418a;
        int c = f0Var.c(i3);
        g2.s sVar = f0Var.f2413f;
        e2.a aVar = (e2.a) sVar.d;
        int e5 = gVar.e(aVar.f1671a, ((int) (f0Var.f2414g - sVar.f1955a)) + aVar.b, c);
        if (e5 == -1) {
            if (z3) {
                return -1;
            }
            throw new EOFException();
        }
        long j2 = f0Var.f2414g + e5;
        f0Var.f2414g = j2;
        g2.s sVar2 = f0Var.f2413f;
        if (j2 == sVar2.b) {
            f0Var.f2413f = (g2.s) sVar2.f1956e;
            return e5;
        }
        return e5;
    }

    @Override // p0.u
    public final void b(int i3, c0.b bVar) {
        while (true) {
            f0 f0Var = this.f2418a;
            if (i3 > 0) {
                int c = f0Var.c(i3);
                g2.s sVar = f0Var.f2413f;
                e2.a aVar = (e2.a) sVar.d;
                bVar.b(aVar.f1671a, ((int) (f0Var.f2414g - sVar.f1955a)) + aVar.b, c);
                i3 -= c;
                long j2 = f0Var.f2414g + c;
                f0Var.f2414g = j2;
                g2.s sVar2 = f0Var.f2413f;
                if (j2 == sVar2.b) {
                    f0Var.f2413f = (g2.s) sVar2.f1956e;
                }
            } else {
                f0Var.getClass();
                return;
            }
        }
    }

    @Override // p0.u
    public final void c(long j2, int i3, int i5, int i6, p0.t tVar) {
        boolean z3;
        if (this.A) {
            d(this.B);
        }
        long j5 = j2 + this.C;
        if (this.D) {
            if ((i3 & 1) != 0) {
                synchronized (this) {
                    z3 = true;
                    if (this.f2429o == 0) {
                        if (j5 <= this.s) {
                            z3 = false;
                        }
                    } else if (Math.max(this.s, p(this.f2431r)) >= j5) {
                        z3 = false;
                    } else {
                        int i7 = this.f2429o;
                        int r5 = r(i7 - 1);
                        while (i7 > this.f2431r && this.f2426l[r5] >= j5) {
                            i7--;
                            r5--;
                            if (r5 == -1) {
                                r5 = this.f2421g - 1;
                            }
                        }
                        k(this.f2430p + i7);
                    }
                }
                if (z3) {
                    this.D = false;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        g(j5, i3, (this.f2418a.f2414g - i5) - i6, i5, tVar);
    }

    @Override // p0.u
    public final void d(Format format) {
        Format n5 = n(format);
        boolean z3 = false;
        this.A = false;
        this.B = format;
        synchronized (this) {
            if (n5 == null) {
                this.w = true;
            } else {
                this.w = false;
                Format format2 = this.f2435x;
                int i3 = g2.w.f1960a;
                if (!n5.equals(format2)) {
                    if (n5.equals(this.f2436y)) {
                        this.f2435x = this.f2436y;
                    } else {
                        this.f2435x = n5;
                    }
                    z3 = true;
                }
            }
        }
        h0 h0Var = this.d;
        if (h0Var != null && z3) {
            h0Var.h();
        }
    }

    public final synchronized int e(long j2) {
        int r5 = r(this.f2431r);
        if (t() && j2 >= this.f2426l[r5]) {
            int m5 = m(r5, this.f2429o - this.f2431r, j2, true);
            if (m5 == -1) {
                return 0;
            }
            this.f2431r += m5;
            return m5;
        }
        return 0;
    }

    public final synchronized int f() {
        int i3;
        int i5 = this.f2429o;
        i3 = i5 - this.f2431r;
        this.f2431r = i5;
        return i3;
    }

    public final synchronized void g(long j2, int i3, long j5, int i5, p0.t tVar) {
        boolean z3;
        try {
            if (this.f2434v) {
                if ((i3 & 1) == 0) {
                    return;
                }
                this.f2434v = false;
            }
            g2.b.h(!this.w);
            if ((536870912 & i3) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f2433u = z3;
            this.f2432t = Math.max(this.f2432t, j2);
            int r5 = r(this.f2429o);
            this.f2426l[r5] = j2;
            long[] jArr = this.f2423i;
            jArr[r5] = j5;
            this.f2424j[r5] = i5;
            this.f2425k[r5] = i3;
            this.f2427m[r5] = tVar;
            Format[] formatArr = this.f2428n;
            Format format = this.f2435x;
            formatArr[r5] = format;
            this.f2422h[r5] = this.f2437z;
            this.f2436y = format;
            int i6 = this.f2429o + 1;
            this.f2429o = i6;
            int i7 = this.f2421g;
            if (i6 == i7) {
                int i8 = i7 + 1000;
                int[] iArr = new int[i8];
                long[] jArr2 = new long[i8];
                long[] jArr3 = new long[i8];
                int[] iArr2 = new int[i8];
                int[] iArr3 = new int[i8];
                p0.t[] tVarArr = new p0.t[i8];
                Format[] formatArr2 = new Format[i8];
                int i9 = this.q;
                int i10 = i7 - i9;
                System.arraycopy(jArr, i9, jArr2, 0, i10);
                System.arraycopy(this.f2426l, this.q, jArr3, 0, i10);
                System.arraycopy(this.f2425k, this.q, iArr2, 0, i10);
                System.arraycopy(this.f2424j, this.q, iArr3, 0, i10);
                System.arraycopy(this.f2427m, this.q, tVarArr, 0, i10);
                System.arraycopy(this.f2428n, this.q, formatArr2, 0, i10);
                System.arraycopy(this.f2422h, this.q, iArr, 0, i10);
                int i11 = this.q;
                System.arraycopy(this.f2423i, 0, jArr2, i10, i11);
                System.arraycopy(this.f2426l, 0, jArr3, i10, i11);
                System.arraycopy(this.f2425k, 0, iArr2, i10, i11);
                System.arraycopy(this.f2424j, 0, iArr3, i10, i11);
                System.arraycopy(this.f2427m, 0, tVarArr, i10, i11);
                System.arraycopy(this.f2428n, 0, formatArr2, i10, i11);
                System.arraycopy(this.f2422h, 0, iArr, i10, i11);
                this.f2423i = jArr2;
                this.f2426l = jArr3;
                this.f2425k = iArr2;
                this.f2424j = iArr3;
                this.f2427m = tVarArr;
                this.f2428n = formatArr2;
                this.f2422h = iArr;
                this.q = 0;
                this.f2421g = i8;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final long h(int i3) {
        int i5;
        this.s = Math.max(this.s, p(i3));
        int i6 = this.f2429o - i3;
        this.f2429o = i6;
        this.f2430p += i3;
        int i7 = this.q + i3;
        this.q = i7;
        int i8 = this.f2421g;
        if (i7 >= i8) {
            this.q = i7 - i8;
        }
        int i9 = this.f2431r - i3;
        this.f2431r = i9;
        if (i9 < 0) {
            this.f2431r = 0;
        }
        if (i6 == 0) {
            int i10 = this.q;
            if (i10 != 0) {
                i8 = i10;
            }
            return this.f2423i[i8 - 1] + this.f2424j[i5];
        }
        return this.f2423i[this.q];
    }

    public final void i(long j2, boolean z3, boolean z5) {
        long j5;
        int i3;
        f0 f0Var = this.f2418a;
        synchronized (this) {
            try {
                int i5 = this.f2429o;
                j5 = -1;
                if (i5 != 0) {
                    long[] jArr = this.f2426l;
                    int i6 = this.q;
                    if (j2 >= jArr[i6]) {
                        if (z5 && (i3 = this.f2431r) != i5) {
                            i5 = i3 + 1;
                        }
                        int m5 = m(i6, i5, j2, z3);
                        if (m5 != -1) {
                            j5 = h(m5);
                        }
                    }
                }
            } finally {
            }
        }
        f0Var.b(j5);
    }

    public final void j() {
        long h5;
        f0 f0Var = this.f2418a;
        synchronized (this) {
            int i3 = this.f2429o;
            if (i3 == 0) {
                h5 = -1;
            } else {
                h5 = h(i3);
            }
        }
        f0Var.b(h5);
    }

    public final long k(int i3) {
        boolean z3;
        int i5 = this.f2430p;
        int i6 = this.f2429o;
        int i7 = (i5 + i6) - i3;
        boolean z5 = false;
        if (i7 >= 0 && i7 <= i6 - this.f2431r) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        int i8 = this.f2429o - i7;
        this.f2429o = i8;
        this.f2432t = Math.max(this.s, p(i8));
        if (i7 == 0 && this.f2433u) {
            z5 = true;
        }
        this.f2433u = z5;
        int i9 = this.f2429o;
        if (i9 != 0) {
            int r5 = r(i9 - 1);
            return this.f2423i[r5] + this.f2424j[r5];
        }
        return 0L;
    }

    public final void l(int i3) {
        long k5 = k(i3);
        f0 f0Var = this.f2418a;
        f0Var.f2414g = k5;
        int i5 = f0Var.b;
        if (k5 != 0) {
            g2.s sVar = f0Var.d;
            if (k5 != sVar.f1955a) {
                while (f0Var.f2414g > sVar.b) {
                    sVar = (g2.s) sVar.f1956e;
                }
                g2.s sVar2 = (g2.s) sVar.f1956e;
                f0Var.a(sVar2);
                long j2 = sVar.b;
                g2.s sVar3 = new g2.s(i5, j2);
                sVar.f1956e = sVar3;
                if (f0Var.f2414g == j2) {
                    sVar = sVar3;
                }
                f0Var.f2413f = sVar;
                if (f0Var.f2412e == sVar2) {
                    f0Var.f2412e = sVar3;
                    return;
                }
                return;
            }
        }
        f0Var.a(f0Var.d);
        g2.s sVar4 = new g2.s(i5, f0Var.f2414g);
        f0Var.d = sVar4;
        f0Var.f2412e = sVar4;
        f0Var.f2413f = sVar4;
    }

    public final int m(int i3, int i5, long j2, boolean z3) {
        int i6 = -1;
        for (int i7 = 0; i7 < i5 && this.f2426l[i3] <= j2; i7++) {
            if (!z3 || (this.f2425k[i3] & 1) != 0) {
                i6 = i7;
            }
            i3++;
            if (i3 == this.f2421g) {
                i3 = 0;
            }
        }
        return i6;
    }

    public Format n(Format format) {
        long j2 = this.C;
        if (j2 != 0) {
            long j5 = format.f315m;
            if (j5 != Long.MAX_VALUE) {
                return format.h(j5 + j2);
            }
            return format;
        }
        return format;
    }

    public final synchronized long o() {
        return this.f2432t;
    }

    public final long p(int i3) {
        long j2 = Long.MIN_VALUE;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int r5 = r(i3 - 1);
        for (int i5 = 0; i5 < i3; i5++) {
            j2 = Math.max(j2, this.f2426l[r5]);
            if ((this.f2425k[r5] & 1) != 0) {
                break;
            }
            r5--;
            if (r5 == -1) {
                r5 = this.f2421g - 1;
            }
        }
        return j2;
    }

    public final int q() {
        return this.f2430p + this.f2431r;
    }

    public final int r(int i3) {
        int i5 = this.q + i3;
        int i6 = this.f2421g;
        if (i5 >= i6) {
            return i5 - i6;
        }
        return i5;
    }

    public final synchronized Format s() {
        Format format;
        if (this.w) {
            format = null;
        } else {
            format = this.f2435x;
        }
        return format;
    }

    public final boolean t() {
        if (this.f2431r != this.f2429o) {
            return true;
        }
        return false;
    }

    public final synchronized boolean u(boolean z3) {
        Format format;
        boolean z5 = true;
        if (!t()) {
            if (!z3 && !this.f2433u && ((format = this.f2435x) == null || format == this.f2419e)) {
                z5 = false;
            }
            return z5;
        }
        int r5 = r(this.f2431r);
        if (this.f2428n[r5] != this.f2419e) {
            return true;
        }
        return v(r5);
    }

    public final boolean v(int i3) {
        b3.e eVar;
        if (this.c == n0.b.f2912a || (eVar = this.f2420f) == null) {
            return true;
        }
        if ((this.f2425k[i3] & BasicMeasure.EXACTLY) == 0) {
            eVar.getClass();
        }
        return false;
    }

    public final void w(Format format, j0.b bVar) {
        boolean z3;
        DrmInitData drmInitData;
        bVar.d = format;
        Format format2 = this.f2419e;
        if (format2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        b3.e eVar = null;
        if (z3) {
            drmInitData = null;
        } else {
            drmInitData = format2.f314l;
        }
        this.f2419e = format;
        n0.b bVar2 = n0.b.f2912a;
        n0.b bVar3 = this.c;
        if (bVar3 == bVar2) {
            return;
        }
        DrmInitData drmInitData2 = format.f314l;
        bVar.b = true;
        bVar.c = this.f2420f;
        if (!z3 && g2.w.a(drmInitData, drmInitData2)) {
            return;
        }
        Looper.myLooper().getClass();
        if (drmInitData2 != null) {
            bVar3.getClass();
            eVar = new b3.e(21, new IOException(new Exception()));
        } else {
            g2.k.e(format.f311i);
            bVar3.getClass();
        }
        this.f2420f = eVar;
        bVar.c = eVar;
    }

    public final synchronized int x() {
        int i3;
        try {
            int r5 = r(this.f2431r);
            if (t()) {
                i3 = this.f2422h[r5];
            } else {
                i3 = this.f2437z;
            }
        } catch (Throwable th) {
            throw th;
        }
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int y(j0.b bVar, m0.d dVar, boolean z3, boolean z5, long j2) {
        boolean t4;
        int i3;
        int i5;
        boolean z6;
        int i6;
        char c;
        g0 g0Var = this.b;
        synchronized (this) {
            int i7 = -1;
            while (true) {
                try {
                    t4 = t();
                    if (t4) {
                        i7 = r(this.f2431r);
                        if (this.f2426l[i7] < j2) {
                            String str = this.f2428n[i7].f311i;
                            ArrayList arrayList = g2.k.f1933a;
                            if (str != null) {
                                switch (str.hashCode()) {
                                    case -432837260:
                                        if (str.equals("audio/mpeg-L1")) {
                                            c = 0;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -432837259:
                                        if (str.equals("audio/mpeg-L2")) {
                                            c = 1;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -53558318:
                                        if (str.equals("audio/mp4a-latm")) {
                                            c = 2;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1504831518:
                                        if (str.equals("audio/mpeg")) {
                                            c = 3;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        c = 65535;
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                        this.f2431r++;
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i3 = -3;
            if (!t4) {
                if (!z5 && !this.f2433u) {
                    Format format = this.f2435x;
                    if (format != null && (z3 || format != this.f2419e)) {
                        w(format, bVar);
                        i3 = -5;
                    }
                }
                dVar.setFlags(4);
                i3 = -4;
            } else {
                if (!z3 && this.f2428n[i7] == this.f2419e) {
                    if (v(i7)) {
                        dVar.setFlags(this.f2425k[i7]);
                        long j5 = this.f2426l[i7];
                        dVar.c = j5;
                        if (j5 < j2) {
                            dVar.addFlag(Integer.MIN_VALUE);
                        }
                        if (dVar.b != null || dVar.f2763e != 0) {
                            g0Var.f2415a = this.f2424j[i7];
                            g0Var.b = this.f2423i[i7];
                            g0Var.c = this.f2427m[i7];
                            this.f2431r++;
                        }
                        i3 = -4;
                    }
                }
                w(this.f2428n[i7], bVar);
                i3 = -5;
            }
        }
        if (i3 != -4 || dVar.isEndOfStream() || (dVar.b == null && dVar.f2763e == 0)) {
            return i3;
        }
        f0 f0Var = this.f2418a;
        g0 g0Var2 = this.b;
        f0Var.getClass();
        boolean flag = dVar.getFlag(BasicMeasure.EXACTLY);
        c0.b bVar2 = f0Var.c;
        if (flag) {
            long j6 = g0Var2.b;
            bVar2.v(1);
            f0Var.e(bVar2.f187a, 1, j6);
            long j7 = j6 + 1;
            byte b = bVar2.f187a[0];
            if ((b & 128) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            int i8 = b & Byte.MAX_VALUE;
            a0 a0Var = dVar.f2762a;
            byte[] bArr = (byte[]) a0Var.f2371a;
            if (bArr == null) {
                a0Var.f2371a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            f0Var.e((byte[]) a0Var.f2371a, i8, j7);
            long j8 = j7 + i8;
            if (z6) {
                bVar2.v(2);
                f0Var.e(bVar2.f187a, 2, j8);
                j8 += 2;
                i6 = bVar2.s();
            } else {
                i6 = 1;
            }
            int[] iArr = (int[]) a0Var.b;
            if (iArr == null || iArr.length < i6) {
                iArr = new int[i6];
            }
            int[] iArr2 = (int[]) a0Var.c;
            if (iArr2 == null || iArr2.length < i6) {
                iArr2 = new int[i6];
            }
            if (z6) {
                int i9 = i6 * 6;
                bVar2.v(i9);
                f0Var.e(bVar2.f187a, i9, j8);
                i5 = i3;
                j8 += i9;
                bVar2.y(0);
                for (int i10 = 0; i10 < i6; i10++) {
                    iArr[i10] = bVar2.s();
                    iArr2[i10] = bVar2.q();
                }
            } else {
                i5 = i3;
                iArr[0] = 0;
                iArr2[0] = g0Var2.f2415a - ((int) (j8 - g0Var2.b));
            }
            p0.t tVar = g0Var2.c;
            byte[] bArr2 = tVar.b;
            byte[] bArr3 = (byte[]) a0Var.f2371a;
            a0Var.b = iArr;
            a0Var.c = iArr2;
            a0Var.f2371a = bArr3;
            MediaCodec.CryptoInfo cryptoInfo = (MediaCodec.CryptoInfo) a0Var.d;
            cryptoInfo.numSubSamples = i6;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = tVar.f3130a;
            if (g2.w.f1960a >= 24) {
                c1.b bVar3 = (c1.b) a0Var.f2372e;
                ((MediaCodec.CryptoInfo.Pattern) bVar3.c).set(tVar.c, tVar.d);
                ((MediaCodec.CryptoInfo) bVar3.b).setPattern((MediaCodec.CryptoInfo.Pattern) bVar3.c);
            }
            long j9 = g0Var2.b;
            int i11 = (int) (j8 - j9);
            g0Var2.b = j9 + i11;
            g0Var2.f2415a -= i11;
        } else {
            i5 = i3;
        }
        if (dVar.hasSupplementalData()) {
            bVar2.v(4);
            f0Var.e(bVar2.f187a, 4, g0Var2.b);
            int q = bVar2.q();
            g0Var2.b += 4;
            g0Var2.f2415a -= 4;
            dVar.c(q);
            f0Var.d(g0Var2.b, q, dVar.b);
            g0Var2.b += q;
            int i12 = g0Var2.f2415a - q;
            g0Var2.f2415a = i12;
            ByteBuffer byteBuffer = dVar.d;
            if (byteBuffer != null && byteBuffer.capacity() >= i12) {
                dVar.d.clear();
            } else {
                dVar.d = ByteBuffer.allocate(i12);
            }
            f0Var.d(g0Var2.b, g0Var2.f2415a, dVar.d);
            return i5;
        }
        dVar.c(g0Var2.f2415a);
        f0Var.d(g0Var2.b, g0Var2.f2415a, dVar.b);
        return i5;
    }

    public final void z(boolean z3) {
        f0 f0Var = this.f2418a;
        f0Var.a(f0Var.d);
        g2.s sVar = new g2.s(f0Var.b, 0L);
        f0Var.d = sVar;
        f0Var.f2412e = sVar;
        f0Var.f2413f = sVar;
        f0Var.f2414g = 0L;
        f0Var.f2411a.c();
        this.f2429o = 0;
        this.f2430p = 0;
        this.q = 0;
        this.f2431r = 0;
        this.f2434v = true;
        this.s = Long.MIN_VALUE;
        this.f2432t = Long.MIN_VALUE;
        this.f2433u = false;
        this.f2436y = null;
        if (z3) {
            this.B = null;
            this.f2435x = null;
            this.w = true;
        }
    }
}

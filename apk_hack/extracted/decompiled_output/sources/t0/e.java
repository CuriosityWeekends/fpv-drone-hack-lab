package t0;

import a1.m;
import android.util.SparseArray;
import g2.w;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import p0.g;
import p0.j;
import p0.k;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements j {

    /* renamed from: b0  reason: collision with root package name */
    public static final byte[] f3601b0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* renamed from: c0  reason: collision with root package name */
    public static final byte[] f3602c0 = w.r("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: d0  reason: collision with root package name */
    public static final byte[] f3603d0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* renamed from: e0  reason: collision with root package name */
    public static final UUID f3604e0 = new UUID(72057594037932032L, -9223371306706625679L);
    public long A;
    public long B;
    public m C;
    public m D;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public long I;
    public int J;
    public int K;
    public int[] L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public byte Y;
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public final b f3605a;

    /* renamed from: a0  reason: collision with root package name */
    public k f3606a0;
    public final f b;
    public final SparseArray c;
    public final boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final c0.b f3607e;

    /* renamed from: f  reason: collision with root package name */
    public final c0.b f3608f;

    /* renamed from: g  reason: collision with root package name */
    public final c0.b f3609g;

    /* renamed from: h  reason: collision with root package name */
    public final c0.b f3610h;

    /* renamed from: i  reason: collision with root package name */
    public final c0.b f3611i;

    /* renamed from: j  reason: collision with root package name */
    public final c0.b f3612j;

    /* renamed from: k  reason: collision with root package name */
    public final c0.b f3613k;

    /* renamed from: l  reason: collision with root package name */
    public final c0.b f3614l;

    /* renamed from: m  reason: collision with root package name */
    public final c0.b f3615m;

    /* renamed from: n  reason: collision with root package name */
    public final c0.b f3616n;

    /* renamed from: o  reason: collision with root package name */
    public ByteBuffer f3617o;

    /* renamed from: p  reason: collision with root package name */
    public long f3618p;
    public long q;

    /* renamed from: r  reason: collision with root package name */
    public long f3619r;
    public long s;

    /* renamed from: t  reason: collision with root package name */
    public long f3620t;

    /* renamed from: u  reason: collision with root package name */
    public c f3621u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f3622v;
    public int w;

    /* renamed from: x  reason: collision with root package name */
    public long f3623x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f3624y;

    /* renamed from: z  reason: collision with root package name */
    public long f3625z;

    public e(int i3) {
        b bVar = new b();
        this.q = -1L;
        this.f3619r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.f3620t = -9223372036854775807L;
        this.f3625z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.f3605a = bVar;
        bVar.d = new b3.e(28, this);
        this.d = (i3 & 1) == 0;
        this.b = new f();
        this.c = new SparseArray();
        this.f3609g = new c0.b(4);
        this.f3610h = new c0.b(ByteBuffer.allocate(4).putInt(-1).array());
        this.f3611i = new c0.b(4);
        this.f3607e = new c0.b(g2.b.d);
        this.f3608f = new c0.b(4);
        this.f3612j = new c0.b();
        this.f3613k = new c0.b();
        this.f3614l = new c0.b(8);
        this.f3615m = new c0.b();
        this.f3616n = new c0.b();
    }

    public static byte[] c(long j2, long j5, String str) {
        boolean z3;
        if (j2 != -9223372036854775807L) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        int i3 = (int) (j2 / 3600000000L);
        long j6 = j2 - ((i3 * 3600) * 1000000);
        int i5 = (int) (j6 / 60000000);
        long j7 = j6 - ((i5 * 60) * 1000000);
        int i6 = (int) (j7 / 1000000);
        return w.r(String.format(Locale.US, str, Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf((int) ((j7 - (i6 * 1000000)) / j5))));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(t0.c r17, long r18, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.e.a(t0.c, long, int, int, int):void");
    }

    @Override // p0.j
    public final void b(k kVar) {
        this.f3606a0 = kVar;
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        this.B = -9223372036854775807L;
        this.G = 0;
        b bVar = this.f3605a;
        bVar.f3574e = 0;
        bVar.b.clear();
        f fVar = bVar.c;
        fVar.b = 0;
        fVar.c = 0;
        f fVar2 = this.b;
        fVar2.b = 0;
        fVar2.c = 0;
        g();
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.c;
            if (i3 < sparseArray.size()) {
                d dVar = ((c) sparseArray.valueAt(i3)).R;
                if (dVar != null) {
                    dVar.b = false;
                    dVar.c = 0;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    public final void e(g gVar, int i3) {
        c0.b bVar = this.f3609g;
        if (bVar.c >= i3) {
            return;
        }
        byte[] bArr = bVar.f187a;
        if (bArr.length < i3) {
            bVar.w(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i3)), bVar.c);
        }
        byte[] bArr2 = bVar.f187a;
        int i5 = bVar.c;
        gVar.g(bArr2, i5, i3 - i5, false);
        bVar.x(i3);
    }

    @Override // p0.j
    public final boolean f(g gVar) {
        long h5;
        int i3;
        m mVar = new m(4);
        long j2 = gVar.c;
        long j5 = 1024;
        int i5 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
        if (i5 != 0 && j2 <= 1024) {
            j5 = j2;
        }
        int i6 = (int) j5;
        c0.b bVar = (c0.b) mVar.b;
        gVar.d(bVar.f187a, 0, 4, false);
        mVar.f39a = 4;
        for (long o5 = bVar.o(); o5 != 440786851; o5 = ((o5 << 8) & (-256)) | (bVar.f187a[0] & 255)) {
            int i7 = mVar.f39a + 1;
            mVar.f39a = i7;
            if (i7 == i6) {
                return false;
            }
            gVar.d(bVar.f187a, 0, 1, false);
        }
        long h6 = mVar.h(gVar);
        long j6 = mVar.f39a;
        if (h6 == Long.MIN_VALUE) {
            return false;
        }
        if (i5 != 0 && j6 + h6 >= j2) {
            return false;
        }
        while (true) {
            int i8 = (mVar.f39a > (j6 + h6) ? 1 : (mVar.f39a == (j6 + h6) ? 0 : -1));
            if (i8 < 0) {
                if (mVar.h(gVar) == Long.MIN_VALUE || (mVar.h(gVar)) < 0 || h5 > 2147483647L) {
                    return false;
                }
                if (i3 != 0) {
                    int i9 = (int) h5;
                    gVar.a(i9, false);
                    mVar.f39a += i9;
                }
            } else if (i8 != 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public final void g() {
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = 0;
        this.Y = (byte) 0;
        this.Z = false;
        this.f3612j.u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:397:0x09dd, code lost:
        if (r2.h() == r9.getLeastSignificantBits()) goto L544;
     */
    /* JADX WARN: Code restructure failed: missing block: B:535:0x0d3d, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x0d3e, code lost:
        r20 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0427 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x074b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x076b  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0783  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x079b  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x07e0  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x07fd  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x082e  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x08da  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0983  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x099a  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0a10  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0a32  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0a34  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0a3c  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0a5f  */
    /* JADX WARN: Removed duplicated region for block: B:717:0x0645 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v170 */
    /* JADX WARN: Type inference failed for: r2v64, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v66 */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(p0.g r59, p0.m r60) {
        /*
            Method dump skipped, instructions count: 4800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.e.h(p0.g, p0.m):int");
    }

    public final long i(long j2) {
        long j5 = this.f3619r;
        if (j5 != -9223372036854775807L) {
            return w.B(j2, j5, 1000L);
        }
        throw new IOException("Can't scale timecode prior to timecodeScale being set.");
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0205  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(p0.g r18, t0.c r19, int r20) {
        /*
            Method dump skipped, instructions count: 687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.e.j(p0.g, t0.c, int):int");
    }

    public final void k(g gVar, byte[] bArr, int i3) {
        int length = bArr.length + i3;
        c0.b bVar = this.f3613k;
        byte[] bArr2 = bVar.f187a;
        if (bArr2.length < length) {
            bVar.f187a = Arrays.copyOf(bArr, length + i3);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        gVar.g(bVar.f187a, bArr.length, i3, false);
        bVar.v(length);
    }
}

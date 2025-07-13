package l0;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import j0.h0;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class u {
    public long A;
    public float B;
    public f[] C;
    public ByteBuffer[] D;
    public ByteBuffer E;
    public ByteBuffer F;
    public byte[] G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public p N;
    public boolean O;
    public long P;

    /* renamed from: a  reason: collision with root package name */
    public final c f2577a;
    public final i.b b;
    public final r c;
    public final b0 d;

    /* renamed from: e  reason: collision with root package name */
    public final f[] f2578e;

    /* renamed from: f  reason: collision with root package name */
    public final f[] f2579f;

    /* renamed from: g  reason: collision with root package name */
    public final ConditionVariable f2580g;

    /* renamed from: h  reason: collision with root package name */
    public final o f2581h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayDeque f2582i;

    /* renamed from: j  reason: collision with root package name */
    public b3.e f2583j;

    /* renamed from: k  reason: collision with root package name */
    public s f2584k;

    /* renamed from: l  reason: collision with root package name */
    public s f2585l;

    /* renamed from: m  reason: collision with root package name */
    public AudioTrack f2586m;

    /* renamed from: n  reason: collision with root package name */
    public b f2587n;

    /* renamed from: o  reason: collision with root package name */
    public h0 f2588o;

    /* renamed from: p  reason: collision with root package name */
    public h0 f2589p;
    public long q;

    /* renamed from: r  reason: collision with root package name */
    public long f2590r;
    public ByteBuffer s;

    /* renamed from: t  reason: collision with root package name */
    public int f2591t;

    /* renamed from: u  reason: collision with root package name */
    public long f2592u;

    /* renamed from: v  reason: collision with root package name */
    public long f2593v;
    public long w;

    /* renamed from: x  reason: collision with root package name */
    public long f2594x;

    /* renamed from: y  reason: collision with root package name */
    public int f2595y;

    /* renamed from: z  reason: collision with root package name */
    public int f2596z;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v13, types: [l0.p, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3, types: [l0.q, l0.r] */
    /* JADX WARN: Type inference failed for: r8v2, types: [l0.b0, l0.q] */
    public u(c cVar, f[] fVarArr) {
        i.b bVar = new i.b(fVarArr);
        this.f2577a = cVar;
        this.b = bVar;
        this.f2580g = new ConditionVariable(true);
        this.f2581h = new o(new b3.e(13, this));
        ?? qVar = new q();
        this.c = qVar;
        ?? qVar2 = new q();
        qVar2.f2529m = g2.w.f1962f;
        this.d = qVar2;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new q(), qVar, qVar2);
        Collections.addAll(arrayList, (f[]) bVar.b);
        this.f2578e = (f[]) arrayList.toArray(new f[0]);
        this.f2579f = new f[]{new q()};
        this.B = 1.0f;
        this.f2596z = 0;
        this.f2587n = b.b;
        this.M = 0;
        this.N = new Object();
        this.f2589p = h0.f2254e;
        this.I = -1;
        this.C = new f[0];
        this.D = new ByteBuffer[0];
        this.f2582i = new ArrayDeque();
    }

    public final void a(h0 h0Var, long j2) {
        h0 h0Var2;
        if (this.f2585l.f2574j) {
            i.b bVar = this.b;
            bVar.getClass();
            ((y) bVar.c).f2609j = h0Var.c;
            a0 a0Var = (a0) bVar.d;
            a0Var.getClass();
            int i3 = g2.w.f1960a;
            float max = Math.max(0.1f, Math.min(h0Var.f2255a, 8.0f));
            if (a0Var.c != max) {
                a0Var.c = max;
                a0Var.f2516i = true;
            }
            float max2 = Math.max(0.1f, Math.min(h0Var.b, 8.0f));
            if (a0Var.d != max2) {
                a0Var.d = max2;
                a0Var.f2516i = true;
            }
            h0Var2 = new h0(max, max2, h0Var.c);
        } else {
            h0Var2 = h0.f2254e;
        }
        this.f2582i.add(new t(h0Var2, Math.max(0L, j2), (f() * 1000000) / this.f2585l.f2569e));
        f[] fVarArr = this.f2585l.f2575k;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (f fVar : fVarArr) {
            if (fVar.isActive()) {
                arrayList.add(fVar);
            } else {
                fVar.flush();
            }
        }
        int size = arrayList.size();
        this.C = (f[]) arrayList.toArray(new f[size]);
        this.D = new ByteBuffer[size];
        while (true) {
            f[] fVarArr2 = this.C;
            if (i5 < fVarArr2.length) {
                f fVar2 = fVarArr2[i5];
                fVar2.flush();
                this.D[i5] = fVar2.a();
                i5++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(int r20, int r21, int r22, int r23, int[] r24, int r25) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.u.b(int, int, int, int, int[], int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0034 -> B:9:0x0014). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r9 = this;
            int r0 = r9.I
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L16
            l0.s r0 = r9.f2585l
            boolean r0 = r0.f2573i
            if (r0 == 0) goto Lf
            r0 = 0
            goto L12
        Lf:
            l0.f[] r0 = r9.C
            int r0 = r0.length
        L12:
            r9.I = r0
        L14:
            r0 = 1
            goto L17
        L16:
            r0 = 0
        L17:
            int r4 = r9.I
            l0.f[] r5 = r9.C
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L3a
            r4 = r5[r4]
            if (r0 == 0) goto L2a
            r4.b()
        L2a:
            r9.k(r7)
            boolean r0 = r4.d()
            if (r0 != 0) goto L34
            return r2
        L34:
            int r0 = r9.I
            int r0 = r0 + r1
            r9.I = r0
            goto L14
        L3a:
            java.nio.ByteBuffer r0 = r9.F
            if (r0 == 0) goto L46
            r9.n(r0, r7)
            java.nio.ByteBuffer r0 = r9.F
            if (r0 == 0) goto L46
            return r2
        L46:
            r9.I = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.u.c():boolean");
    }

    public final void d() {
        if (i()) {
            this.f2592u = 0L;
            this.f2593v = 0L;
            this.w = 0L;
            this.f2594x = 0L;
            this.f2595y = 0;
            h0 h0Var = this.f2588o;
            ArrayDeque arrayDeque = this.f2582i;
            if (h0Var != null) {
                this.f2589p = h0Var;
                this.f2588o = null;
            } else if (!arrayDeque.isEmpty()) {
                this.f2589p = ((t) arrayDeque.getLast()).f2576a;
            }
            arrayDeque.clear();
            this.q = 0L;
            this.f2590r = 0L;
            this.d.f2531o = 0L;
            int i3 = 0;
            while (true) {
                f[] fVarArr = this.C;
                if (i3 >= fVarArr.length) {
                    break;
                }
                f fVar = fVarArr[i3];
                fVar.flush();
                this.D[i3] = fVar.a();
                i3++;
            }
            this.E = null;
            this.F = null;
            this.K = false;
            this.J = false;
            this.I = -1;
            this.s = null;
            this.f2591t = 0;
            this.f2596z = 0;
            o oVar = this.f2581h;
            AudioTrack audioTrack = oVar.c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 3) {
                this.f2586m.pause();
            }
            AudioTrack audioTrack2 = this.f2586m;
            this.f2586m = null;
            s sVar = this.f2584k;
            if (sVar != null) {
                this.f2585l = sVar;
                this.f2584k = null;
            }
            oVar.f2549j = 0L;
            oVar.f2558u = 0;
            oVar.f2557t = 0;
            oVar.f2550k = 0L;
            oVar.c = null;
            oVar.f2545f = null;
            this.f2580g.close();
            new f2.p(this, audioTrack2).start();
        }
    }

    public final long e() {
        s sVar = this.f2585l;
        if (sVar.f2568a) {
            return this.f2592u / sVar.b;
        }
        return this.f2593v;
    }

    public final long f() {
        s sVar = this.f2585l;
        if (sVar.f2568a) {
            return this.w / sVar.d;
        }
        return this.f2594x;
    }

    /* JADX WARN: Removed duplicated region for block: B:189:0x0409 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(java.nio.ByteBuffer r32, long r33) {
        /*
            Method dump skipped, instructions count: 1286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.u.g(java.nio.ByteBuffer, long):boolean");
    }

    public final boolean h() {
        if (i() && this.f2581h.b(f())) {
            return true;
        }
        return false;
    }

    public final boolean i() {
        if (this.f2586m != null) {
            return true;
        }
        return false;
    }

    public final void j() {
        if (!this.K) {
            this.K = true;
            long f4 = f();
            o oVar = this.f2581h;
            oVar.f2560x = oVar.a();
            oVar.f2559v = SystemClock.elapsedRealtime() * 1000;
            oVar.f2561y = f4;
            this.f2586m.stop();
            this.f2591t = 0;
        }
    }

    public final void k(long j2) {
        ByteBuffer byteBuffer;
        int length = this.C.length;
        int i3 = length;
        while (i3 >= 0) {
            if (i3 > 0) {
                byteBuffer = this.D[i3 - 1];
            } else {
                byteBuffer = this.E;
                if (byteBuffer == null) {
                    byteBuffer = f.f2535a;
                }
            }
            if (i3 == length) {
                n(byteBuffer, j2);
            } else {
                f fVar = this.C[i3];
                fVar.e(byteBuffer);
                ByteBuffer a5 = fVar.a();
                this.D[i3] = a5;
                if (a5.hasRemaining()) {
                    i3++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i3--;
        }
    }

    public final void l() {
        d();
        for (f fVar : this.f2578e) {
            fVar.reset();
        }
        for (f fVar2 : this.f2579f) {
            fVar2.reset();
        }
        this.M = 0;
        this.L = false;
    }

    public final boolean m(int i3, int i5) {
        if (g2.w.v(i5)) {
            if (i5 != 4 || g2.w.f1960a >= 21) {
                return true;
            }
            return false;
        }
        c cVar = this.f2577a;
        if (cVar != null && Arrays.binarySearch(cVar.f2532a, i5) >= 0 && (i3 == -1 || i3 <= cVar.b)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00df, code lost:
        if (r11 < r10) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(java.nio.ByteBuffer r9, long r10) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.u.n(java.nio.ByteBuffer, long):void");
    }
}

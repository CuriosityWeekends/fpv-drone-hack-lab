package l0;

import android.app.UiModeManager;
import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import j0.h0;
import j0.p0;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class w extends a1.c implements g2.j {
    public long A0;
    public boolean B0;
    public boolean C0;
    public long D0;
    public int E0;

    /* renamed from: q0  reason: collision with root package name */
    public final Context f2598q0;

    /* renamed from: r0  reason: collision with root package name */
    public final c1.b f2599r0;

    /* renamed from: s0  reason: collision with root package name */
    public final u f2600s0;

    /* renamed from: t0  reason: collision with root package name */
    public final long[] f2601t0;

    /* renamed from: u0  reason: collision with root package name */
    public int f2602u0;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f2603v0;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f2604w0;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f2605x0;

    /* renamed from: y0  reason: collision with root package name */
    public MediaFormat f2606y0;

    /* renamed from: z0  reason: collision with root package name */
    public Format f2607z0;

    public w(Context context, n0.b bVar, Handler handler, p0 p0Var, u uVar) {
        super(1, bVar, 44100.0f);
        this.f2598q0 = context.getApplicationContext();
        this.f2600s0 = uVar;
        this.D0 = -9223372036854775807L;
        this.f2601t0 = new long[10];
        this.f2599r0 = new c1.b(13, handler, p0Var, false);
        uVar.f2583j = new b3.e(14, this);
    }

    @Override // a1.c
    public final float F(float f4, Format[] formatArr) {
        int i3 = -1;
        for (Format format : formatArr) {
            int i5 = format.w;
            if (i5 != -1) {
                i3 = Math.max(i3, i5);
            }
        }
        if (i3 == -1) {
            return -1.0f;
        }
        return f4 * i3;
    }

    @Override // a1.c
    public final List G(a1.d dVar, Format format, boolean z3) {
        a1.a aVar;
        String str = format.f311i;
        if (str == null) {
            return Collections.emptyList();
        }
        if (a0(format.f322v, str) != 0) {
            dVar.getClass();
            List d = a1.o.d("audio/raw", false, false);
            a1.a aVar2 = null;
            if (d.isEmpty()) {
                aVar = null;
            } else {
                aVar = (a1.a) d.get(0);
            }
            if (aVar != null) {
                aVar2 = new a1.a(aVar.f1a, null, null, null, true, false, false);
            }
            if (aVar2 != null) {
                return Collections.singletonList(aVar2);
            }
        }
        dVar.getClass();
        ArrayList arrayList = new ArrayList(a1.o.d(str, z3, false));
        Collections.sort(arrayList, new a1.h(new a1.g(0, format)));
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            arrayList2.addAll(a1.o.d("audio/eac3", z3, false));
            arrayList = arrayList2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // a1.c
    public final void L(long j2, long j5, String str) {
        c1.b bVar = this.f2599r0;
        Handler handler = (Handler) bVar.b;
        if (handler != null) {
            handler.post(new h2.r(bVar, str, j2, j5, 1));
        }
    }

    @Override // a1.c
    public final void M(j0.b bVar) {
        super.M(bVar);
        Format format = (Format) bVar.d;
        this.f2607z0 = format;
        c1.b bVar2 = this.f2599r0;
        Handler handler = (Handler) bVar2.b;
        if (handler != null) {
            handler.post(new d2.h(7, bVar2, format));
        }
    }

    @Override // a1.c
    public final void N(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i3;
        int i5;
        int[] iArr;
        int i6;
        MediaFormat mediaFormat2 = this.f2606y0;
        if (mediaFormat2 != null) {
            i5 = a0(mediaFormat2.getInteger("channel-count"), mediaFormat2.getString(IMediaFormat.KEY_MIME));
            mediaFormat = mediaFormat2;
        } else {
            if (mediaFormat.containsKey("v-bits-per-sample")) {
                i3 = g2.w.n(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                Format format = this.f2607z0;
                if ("audio/raw".equals(format.f311i)) {
                    i3 = format.f323x;
                } else {
                    i3 = 2;
                }
            }
            i5 = i3;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.f2604w0 && integer == 6 && (i6 = this.f2607z0.f322v) < 6) {
            iArr = new int[i6];
            for (int i7 = 0; i7 < this.f2607z0.f322v; i7++) {
                iArr[i7] = i7;
            }
        } else {
            iArr = null;
        }
        int[] iArr2 = iArr;
        try {
            u uVar = this.f2600s0;
            Format format2 = this.f2607z0;
            uVar.b(i5, integer, integer2, format2.f324y, iArr2, format2.f325z);
        } catch (j e5) {
            throw d(e5, this.f2607z0);
        }
    }

    @Override // a1.c
    public final void O(long j2) {
        while (true) {
            int i3 = this.E0;
            if (i3 != 0) {
                long[] jArr = this.f2601t0;
                if (j2 >= jArr[0]) {
                    u uVar = this.f2600s0;
                    if (uVar.f2596z == 1) {
                        uVar.f2596z = 2;
                    }
                    int i5 = i3 - 1;
                    this.E0 = i5;
                    System.arraycopy(jArr, 1, jArr, 0, i5);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // a1.c
    public final void P(m0.d dVar) {
        if (this.B0 && !dVar.isDecodeOnly()) {
            if (Math.abs(dVar.c - this.A0) > 500000) {
                this.A0 = dVar.c;
            }
            this.B0 = false;
        }
        this.D0 = Math.max(dVar.c, this.D0);
    }

    @Override // a1.c
    public final boolean R(long j2, long j5, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i3, int i5, long j6, boolean z3, boolean z5, Format format) {
        if (this.f2605x0 && j6 == 0 && (i5 & 4) != 0) {
            long j7 = this.D0;
            if (j7 != -9223372036854775807L) {
                j6 = j7;
            }
        }
        if (this.f2603v0 && (i5 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i3, false);
            return true;
        }
        u uVar = this.f2600s0;
        if (z3) {
            mediaCodec.releaseOutputBuffer(i3, false);
            this.f25o0.getClass();
            if (uVar.f2596z == 1) {
                uVar.f2596z = 2;
            }
            return true;
        }
        try {
            if (!uVar.g(byteBuffer, j6)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i3, false);
            this.f25o0.getClass();
            return true;
        } catch (k | l e5) {
            throw d(e5, this.f2607z0);
        }
    }

    @Override // a1.c
    public final void U() {
        try {
            u uVar = this.f2600s0;
            if (!uVar.J && uVar.i() && uVar.c()) {
                uVar.j();
                uVar.J = true;
            }
        } catch (l e5) {
            throw d(e5, this.f2607z0);
        }
    }

    @Override // a1.c
    public final int X(a1.d dVar, Format format) {
        int i3;
        boolean z3;
        int i5;
        int i6;
        a1.a aVar;
        String str = format.f311i;
        if (!g2.k.g(str)) {
            return 0;
        }
        if (g2.w.f1960a >= 21) {
            i3 = 32;
        } else {
            i3 = 0;
        }
        if (format.f314l != null && !n0.c.class.equals(format.C)) {
            z3 = false;
        } else {
            z3 = true;
        }
        int i7 = format.f322v;
        if (z3 && a0(i7, str) != 0) {
            dVar.getClass();
            List d = a1.o.d("audio/raw", false, false);
            a1.a aVar2 = null;
            if (d.isEmpty()) {
                aVar = null;
            } else {
                aVar = (a1.a) d.get(0);
            }
            if (aVar != null) {
                aVar2 = new a1.a(aVar.f1a, null, null, null, true, false, false);
            }
            if (aVar2 != null) {
                return 12 | i3;
            }
        }
        boolean equals = "audio/raw".equals(str);
        u uVar = this.f2600s0;
        if ((equals && !uVar.m(i7, format.f323x)) || !uVar.m(i7, 2)) {
            return 1;
        }
        List G = G(dVar, format, false);
        if (G.isEmpty()) {
            return 1;
        }
        if (!z3) {
            return 2;
        }
        a1.a aVar3 = (a1.a) G.get(0);
        boolean b = aVar3.b(format);
        if (b && aVar3.c(format)) {
            i5 = 16;
        } else {
            i5 = 8;
        }
        if (b) {
            i6 = 4;
        } else {
            i6 = 3;
        }
        return i5 | i6 | i3;
    }

    public final int Z(a1.a aVar, Format format) {
        int i3;
        UiModeManager uiModeManager;
        if ("OMX.google.raw.decoder".equals(aVar.f1a) && (i3 = g2.w.f1960a) < 24 && (i3 != 23 || (uiModeManager = (UiModeManager) this.f2598q0.getApplicationContext().getSystemService("uimode")) == null || uiModeManager.getCurrentModeType() != 4)) {
            return -1;
        }
        return format.f312j;
    }

    @Override // g2.j
    public final h0 a() {
        u uVar = this.f2600s0;
        h0 h0Var = uVar.f2588o;
        if (h0Var == null) {
            ArrayDeque arrayDeque = uVar.f2582i;
            if (!arrayDeque.isEmpty()) {
                return ((t) arrayDeque.getLast()).f2576a;
            }
            return uVar.f2589p;
        }
        return h0Var;
    }

    public final int a0(int i3, String str) {
        int i5 = 7;
        char c = 65535;
        boolean equals = "audio/eac3-joc".equals(str);
        u uVar = this.f2600s0;
        if (equals) {
            if (!uVar.m(-1, 18)) {
                str = "audio/eac3";
            } else {
                ArrayList arrayList = g2.k.f1933a;
                return 18;
            }
        }
        ArrayList arrayList2 = g2.k.f1933a;
        str.getClass();
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c = 0;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c = 1;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c = 2;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c = 3;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c = 4;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c = 5;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c = 6;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i5 = 18;
                break;
            case 1:
                break;
            case 2:
                i5 = 5;
                break;
            case 3:
                i5 = 17;
                break;
            case 4:
                i5 = 6;
                break;
            case 5:
                i5 = 9;
                break;
            case 6:
                i5 = 8;
                break;
            case 7:
                i5 = 14;
                break;
            default:
                i5 = 0;
                break;
        }
        if (!uVar.m(i3, i5)) {
            return 0;
        }
        return i5;
    }

    @Override // g2.j
    public final void b(h0 h0Var) {
        u uVar = this.f2600s0;
        s sVar = uVar.f2585l;
        if (sVar != null && !sVar.f2574j) {
            uVar.f2589p = h0.f2254e;
            return;
        }
        h0 h0Var2 = uVar.f2588o;
        if (h0Var2 == null) {
            ArrayDeque arrayDeque = uVar.f2582i;
            if (!arrayDeque.isEmpty()) {
                h0Var2 = ((t) arrayDeque.getLast()).f2576a;
            } else {
                h0Var2 = uVar.f2589p;
            }
        }
        if (!h0Var.equals(h0Var2)) {
            if (uVar.i()) {
                uVar.f2588o = h0Var;
            } else {
                uVar.f2589p = h0Var;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02f2 A[ADDED_TO_REGION, EDGE_INSN: B:171:0x02f2->B:135:0x02f2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0237 A[Catch: Exception -> 0x0250, TRY_LEAVE, TryCatch #0 {Exception -> 0x0250, blocks: (B:91:0x020c, B:94:0x0216, B:96:0x0237), top: B:165:0x020c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b0() {
        /*
            Method dump skipped, instructions count: 940
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.w.b0():void");
    }

    @Override // g2.j
    public final long c() {
        if (this.f2247e == 2) {
            b0();
        }
        return this.A0;
    }

    @Override // j0.h
    public final void f(int i3, Object obj) {
        u uVar = this.f2600s0;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 5) {
                    p pVar = (p) obj;
                    if (!uVar.N.equals(pVar)) {
                        pVar.getClass();
                        if (uVar.f2586m != null) {
                            uVar.N.getClass();
                        }
                        uVar.N = pVar;
                        return;
                    }
                    return;
                }
                return;
            }
            b bVar = (b) obj;
            if (!uVar.f2587n.equals(bVar)) {
                uVar.f2587n = bVar;
                if (!uVar.O) {
                    uVar.d();
                    uVar.M = 0;
                    return;
                }
                return;
            }
            return;
        }
        float floatValue = ((Float) obj).floatValue();
        if (uVar.B != floatValue) {
            uVar.B = floatValue;
            if (uVar.i()) {
                if (g2.w.f1960a >= 21) {
                    uVar.f2586m.setVolume(uVar.B);
                    return;
                }
                AudioTrack audioTrack = uVar.f2586m;
                float f4 = uVar.B;
                audioTrack.setStereoVolume(f4, f4);
            }
        }
    }

    @Override // a1.c, j0.h
    public final boolean h() {
        if (this.f17k0) {
            u uVar = this.f2600s0;
            if (!uVar.i() || (uVar.J && !uVar.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // a1.c, j0.h
    public final boolean i() {
        if (!this.f2600s0.h() && !super.i()) {
            return false;
        }
        return true;
    }

    @Override // a1.c, j0.h
    public final void j() {
        c1.b bVar = this.f2599r0;
        try {
            this.D0 = -9223372036854775807L;
            this.E0 = 0;
            this.f2600s0.d();
            try {
                super.j();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.j();
                throw th;
            } finally {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, m0.c] */
    @Override // j0.h
    public final void k(boolean z3) {
        if (this.f20m != null && !this.f30v) {
            this.f30v = true;
        }
        ?? obj = new Object();
        this.f25o0 = obj;
        c1.b bVar = this.f2599r0;
        Handler handler = (Handler) bVar.b;
        if (handler != null) {
            handler.post(new g(bVar, obj, 0));
        }
        int i3 = this.c.f2275a;
        boolean z5 = false;
        u uVar = this.f2600s0;
        if (i3 != 0) {
            uVar.getClass();
            if (g2.w.f1960a >= 21) {
                z5 = true;
            }
            g2.b.h(z5);
            if (!uVar.O || uVar.M != i3) {
                uVar.O = true;
                uVar.M = i3;
                uVar.d();
            }
        } else if (uVar.O) {
            uVar.O = false;
            uVar.M = 0;
            uVar.d();
        }
    }

    @Override // j0.h
    public final void l(long j2, boolean z3) {
        this.f16j0 = false;
        this.f17k0 = false;
        this.f23n0 = false;
        if (C()) {
            J();
        }
        this.s.b();
        this.f2600s0.d();
        this.A0 = j2;
        this.B0 = true;
        this.C0 = true;
        this.D0 = -9223372036854775807L;
        this.E0 = 0;
    }

    @Override // a1.c, j0.h
    public final void m() {
        u uVar = this.f2600s0;
        try {
            T();
            this.f33z = null;
            if (this.f20m != null && this.f30v) {
                this.f30v = false;
            }
        } finally {
            uVar.l();
        }
    }

    @Override // j0.h
    public final void n() {
        u uVar = this.f2600s0;
        uVar.L = true;
        if (uVar.i()) {
            n nVar = uVar.f2581h.f2545f;
            nVar.getClass();
            nVar.a();
            uVar.f2586m.play();
        }
    }

    @Override // j0.h
    public final void o() {
        b0();
        u uVar = this.f2600s0;
        uVar.L = false;
        if (uVar.i()) {
            o oVar = uVar.f2581h;
            oVar.f2549j = 0L;
            oVar.f2558u = 0;
            oVar.f2557t = 0;
            oVar.f2550k = 0L;
            if (oVar.f2559v == -9223372036854775807L) {
                n nVar = oVar.f2545f;
                nVar.getClass();
                nVar.a();
                uVar.f2586m.pause();
            }
        }
    }

    @Override // j0.h
    public final void p(Format[] formatArr, long j2) {
        if (this.D0 != -9223372036854775807L) {
            int i3 = this.E0;
            long[] jArr = this.f2601t0;
            if (i3 == jArr.length) {
                Log.w("MediaCodecAudioRenderer", "Too many stream changes, so dropping change at " + jArr[this.E0 - 1]);
            } else {
                this.E0 = i3 + 1;
            }
            jArr[this.E0 - 1] = this.D0;
        }
    }

    @Override // a1.c
    public final int w(a1.a aVar, Format format, Format format2) {
        if (Z(aVar, format2) <= this.f2602u0 && format.f324y == 0 && format.f325z == 0 && format2.f324y == 0 && format2.f325z == 0) {
            if (aVar.d(format, format2, true)) {
                return 3;
            }
            String str = format.f311i;
            if (g2.w.a(str, format2.f311i) && format.f322v == format2.f322v && format.w == format2.w && format.f323x == format2.f323x && format.t(format2) && !"audio/opus".equals(str)) {
                return 1;
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f9, code lost:
        if ("AXON 7 mini".equals(r9) == false) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0122  */
    @Override // a1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(a1.a r9, android.media.MediaCodec r10, com.google.android.exoplayer2.Format r11, android.media.MediaCrypto r12, float r13) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.w.x(a1.a, android.media.MediaCodec, com.google.android.exoplayer2.Format, android.media.MediaCrypto, float):void");
    }

    @Override // j0.h
    public final g2.j e() {
        return this;
    }
}

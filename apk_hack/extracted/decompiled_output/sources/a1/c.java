package a1;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.android.exoplayer2.Format;
import g2.w;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class c extends j0.h {

    /* renamed from: p0  reason: collision with root package name */
    public static final byte[] f7p0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public final long A;
    public float B;
    public MediaCodec C;
    public Format D;
    public float E;
    public ArrayDeque F;
    public b G;
    public a H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public ByteBuffer[] S;
    public ByteBuffer[] T;
    public long U;
    public int V;
    public int W;
    public ByteBuffer X;
    public boolean Y;
    public boolean Z;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f8b0;

    /* renamed from: c0  reason: collision with root package name */
    public int f9c0;

    /* renamed from: d0  reason: collision with root package name */
    public int f10d0;

    /* renamed from: e0  reason: collision with root package name */
    public int f11e0;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f12f0;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f13g0;

    /* renamed from: h0  reason: collision with root package name */
    public long f14h0;

    /* renamed from: i0  reason: collision with root package name */
    public long f15i0;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f16j0;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f17k0;

    /* renamed from: l  reason: collision with root package name */
    public final d f18l;

    /* renamed from: l0  reason: collision with root package name */
    public boolean f19l0;

    /* renamed from: m  reason: collision with root package name */
    public final n0.b f20m;

    /* renamed from: m0  reason: collision with root package name */
    public boolean f21m0;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f22n;

    /* renamed from: n0  reason: collision with root package name */
    public boolean f23n0;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f24o;

    /* renamed from: o0  reason: collision with root package name */
    public m0.c f25o0;

    /* renamed from: p  reason: collision with root package name */
    public final float f26p;
    public final m0.d q;

    /* renamed from: r  reason: collision with root package name */
    public final m0.d f27r;
    public final d2.c s;

    /* renamed from: t  reason: collision with root package name */
    public final ArrayList f28t;

    /* renamed from: u  reason: collision with root package name */
    public final MediaCodec.BufferInfo f29u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f30v;
    public Format w;

    /* renamed from: x  reason: collision with root package name */
    public Format f31x;

    /* renamed from: y  reason: collision with root package name */
    public b3.e f32y;

    /* renamed from: z  reason: collision with root package name */
    public b3.e f33z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i3, n0.b bVar, float f4) {
        super(i3);
        d dVar = d.f34a;
        this.f18l = dVar;
        this.f20m = bVar;
        this.f22n = false;
        this.f24o = false;
        this.f26p = f4;
        this.q = new m0.d(0);
        this.f27r = new m0.d(0);
        this.s = new d2.c();
        this.f28t = new ArrayList();
        this.f29u = new MediaCodec.BufferInfo();
        this.f9c0 = 0;
        this.f10d0 = 0;
        this.f11e0 = 0;
        this.E = -1.0f;
        this.B = 1.0f;
        this.A = -9223372036854775807L;
    }

    public final boolean A(long j2, long j5) {
        boolean z3;
        boolean z5;
        MediaCodec.BufferInfo bufferInfo;
        boolean R;
        boolean z6;
        int dequeueOutputBuffer;
        ByteBuffer byteBuffer;
        boolean z7;
        boolean z8;
        if (this.W >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        MediaCodec.BufferInfo bufferInfo2 = this.f29u;
        if (!z3) {
            if (this.N && this.f13g0) {
                try {
                    dequeueOutputBuffer = this.C.dequeueOutputBuffer(bufferInfo2, 0L);
                } catch (IllegalStateException unused) {
                    Q();
                    if (this.f17k0) {
                        T();
                    }
                    return false;
                }
            } else {
                dequeueOutputBuffer = this.C.dequeueOutputBuffer(bufferInfo2, 0L);
            }
            if (dequeueOutputBuffer < 0) {
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.C.getOutputFormat();
                    if (this.I != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                        this.Q = true;
                    } else {
                        if (this.O) {
                            outputFormat.setInteger("channel-count", 1);
                        }
                        N(this.C, outputFormat);
                    }
                    return true;
                } else if (dequeueOutputBuffer == -3) {
                    if (w.f1960a < 21) {
                        this.T = this.C.getOutputBuffers();
                    }
                    return true;
                } else {
                    if (this.R && (this.f16j0 || this.f10d0 == 2)) {
                        Q();
                    }
                    return false;
                }
            } else if (this.Q) {
                this.Q = false;
                this.C.releaseOutputBuffer(dequeueOutputBuffer, false);
                return true;
            } else if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                Q();
                return false;
            } else {
                this.W = dequeueOutputBuffer;
                if (w.f1960a >= 21) {
                    byteBuffer = this.C.getOutputBuffer(dequeueOutputBuffer);
                } else {
                    byteBuffer = this.T[dequeueOutputBuffer];
                }
                this.X = byteBuffer;
                if (byteBuffer != null) {
                    byteBuffer.position(bufferInfo2.offset);
                    this.X.limit(bufferInfo2.offset + bufferInfo2.size);
                }
                long j6 = bufferInfo2.presentationTimeUs;
                ArrayList arrayList = this.f28t;
                int size = arrayList.size();
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        if (((Long) arrayList.get(i3)).longValue() == j6) {
                            arrayList.remove(i3);
                            z7 = true;
                            break;
                        }
                        i3++;
                    } else {
                        z7 = false;
                        break;
                    }
                }
                this.Y = z7;
                long j7 = this.f15i0;
                long j8 = bufferInfo2.presentationTimeUs;
                if (j7 == j8) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                this.Z = z8;
                Format format = (Format) this.s.e(j8);
                if (format != null) {
                    this.f31x = format;
                }
            }
        }
        if (this.N && this.f13g0) {
            try {
                z5 = true;
                R = R(j2, j5, this.C, this.X, this.W, bufferInfo2.flags, bufferInfo2.presentationTimeUs, this.Y, this.Z, this.f31x);
                bufferInfo = bufferInfo2;
            } catch (IllegalStateException unused2) {
                Q();
                if (this.f17k0) {
                    T();
                }
                return false;
            }
        } else {
            z5 = true;
            bufferInfo = bufferInfo2;
            R = R(j2, j5, this.C, this.X, this.W, bufferInfo2.flags, bufferInfo2.presentationTimeUs, this.Y, this.Z, this.f31x);
        }
        if (R) {
            O(bufferInfo.presentationTimeUs);
            if ((bufferInfo.flags & 4) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.W = -1;
            this.X = null;
            if (!z6) {
                return z5;
            }
            Q();
            return false;
        }
        return false;
    }

    public final boolean B() {
        ByteBuffer byteBuffer;
        MediaCodec mediaCodec = this.C;
        if (mediaCodec == null || this.f10d0 == 2 || this.f16j0) {
            return false;
        }
        int i3 = this.V;
        m0.d dVar = this.q;
        if (i3 < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.V = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            if (w.f1960a >= 21) {
                byteBuffer = this.C.getInputBuffer(dequeueInputBuffer);
            } else {
                byteBuffer = this.S[dequeueInputBuffer];
            }
            dVar.b = byteBuffer;
            dVar.clear();
        }
        if (this.f10d0 == 1) {
            if (!this.R) {
                this.f13g0 = true;
                this.C.queueInputBuffer(this.V, 0, 0, 0L, 4);
                V();
            }
            this.f10d0 = 2;
            return false;
        } else if (this.P) {
            this.P = false;
            dVar.b.put(f7p0);
            this.C.queueInputBuffer(this.V, 0, 38, 0L, 0);
            V();
            this.f12f0 = true;
            return true;
        } else {
            j0.b bVar = this.b;
            bVar.b();
            if (this.f9c0 == 1) {
                for (int i5 = 0; i5 < this.D.f313k.size(); i5++) {
                    dVar.b.put((byte[]) this.D.f313k.get(i5));
                }
                this.f9c0 = 2;
            }
            int position = dVar.b.position();
            int q = q(bVar, dVar, false);
            if (g()) {
                this.f15i0 = this.f14h0;
            }
            if (q == -3) {
                return false;
            }
            if (q == -5) {
                if (this.f9c0 == 2) {
                    dVar.clear();
                    this.f9c0 = 1;
                }
                M(bVar);
                return true;
            } else if (dVar.isEndOfStream()) {
                if (this.f9c0 == 2) {
                    dVar.clear();
                    this.f9c0 = 1;
                }
                this.f16j0 = true;
                if (!this.f12f0) {
                    Q();
                    return false;
                }
                try {
                    if (!this.R) {
                        this.f13g0 = true;
                        this.C.queueInputBuffer(this.V, 0, 0, 0L, 4);
                        V();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e5) {
                    throw d(e5, this.w);
                }
            } else if (this.f19l0 && !dVar.isKeyFrame()) {
                dVar.clear();
                if (this.f9c0 == 2) {
                    this.f9c0 = 1;
                }
                return true;
            } else {
                this.f19l0 = false;
                boolean flag = dVar.getFlag(BasicMeasure.EXACTLY);
                b3.e eVar = this.f32y;
                if (eVar != null && (flag || !this.f22n)) {
                    throw d((e2.b) eVar.b, this.w);
                }
                if (this.K && !flag) {
                    ByteBuffer byteBuffer2 = dVar.b;
                    int position2 = byteBuffer2.position();
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        int i8 = i6 + 1;
                        if (i8 < position2) {
                            int i9 = byteBuffer2.get(i6) & 255;
                            if (i7 == 3) {
                                if (i9 == 1 && (byteBuffer2.get(i8) & 31) == 7) {
                                    ByteBuffer duplicate = byteBuffer2.duplicate();
                                    duplicate.position(i6 - 3);
                                    duplicate.limit(position2);
                                    byteBuffer2.position(0);
                                    byteBuffer2.put(duplicate);
                                    break;
                                }
                            } else if (i9 == 0) {
                                i7++;
                            }
                            if (i9 != 0) {
                                i7 = 0;
                            }
                            i6 = i8;
                        } else {
                            byteBuffer2.clear();
                            break;
                        }
                    }
                    if (dVar.b.position() == 0) {
                        return true;
                    }
                    this.K = false;
                }
                try {
                    long j2 = dVar.c;
                    if (dVar.isDecodeOnly()) {
                        this.f28t.add(Long.valueOf(j2));
                    }
                    if (this.f21m0) {
                        this.s.a(j2, this.w);
                        this.f21m0 = false;
                    }
                    this.f14h0 = Math.max(this.f14h0, j2);
                    dVar.d();
                    if (dVar.hasSupplementalData()) {
                        H(dVar);
                    }
                    P(dVar);
                    if (flag) {
                        MediaCodec.CryptoInfo cryptoInfo = (MediaCodec.CryptoInfo) dVar.f2762a.d;
                        if (position != 0) {
                            if (cryptoInfo.numBytesOfClearData == null) {
                                cryptoInfo.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = cryptoInfo.numBytesOfClearData;
                            iArr[0] = iArr[0] + position;
                        }
                        this.C.queueSecureInputBuffer(this.V, 0, cryptoInfo, j2, 0);
                    } else {
                        this.C.queueInputBuffer(this.V, 0, dVar.b.limit(), j2, 0);
                    }
                    V();
                    this.f12f0 = true;
                    this.f9c0 = 0;
                    this.f25o0.getClass();
                    return true;
                } catch (MediaCodec.CryptoException e6) {
                    throw d(e6, this.w);
                }
            }
        }
    }

    public boolean C() {
        MediaCodec mediaCodec = this.C;
        if (mediaCodec == null) {
            return false;
        }
        if (this.f11e0 != 3 && !this.L && (!this.M || !this.f13g0)) {
            mediaCodec.flush();
            V();
            this.W = -1;
            this.X = null;
            this.U = -9223372036854775807L;
            this.f13g0 = false;
            this.f12f0 = false;
            this.f19l0 = true;
            this.P = false;
            this.Q = false;
            this.Y = false;
            this.Z = false;
            this.f28t.clear();
            this.f14h0 = -9223372036854775807L;
            this.f15i0 = -9223372036854775807L;
            this.f10d0 = 0;
            this.f11e0 = 0;
            this.f9c0 = this.f8b0 ? 1 : 0;
            return false;
        }
        T();
        return true;
    }

    public final List D(boolean z3) {
        Format format = this.w;
        d dVar = this.f18l;
        List G = G(dVar, format, z3);
        if (G.isEmpty() && z3) {
            G = G(dVar, this.w, false);
            if (!G.isEmpty()) {
                Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + this.w.f311i + ", but no secure decoder available. Trying to proceed with " + G + ".");
            }
        }
        return G;
    }

    public boolean E() {
        return false;
    }

    public abstract float F(float f4, Format[] formatArr);

    public abstract List G(d dVar, Format format, boolean z3);

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0175, code lost:
        if ("stvm8".equals(r4) == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0185, code lost:
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r8) == false) goto L111;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0129 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(a1.a r18, android.media.MediaCrypto r19) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.c.I(a1.a, android.media.MediaCrypto):void");
    }

    public final void J() {
        if (this.C == null && this.w != null) {
            b3.e eVar = this.f33z;
            this.f32y = eVar;
            if (eVar != null) {
                if (((e2.b) eVar.b) != null) {
                    if (n0.c.f2913a) {
                        eVar.getClass();
                        throw d((e2.b) this.f32y.b, this.w);
                    }
                } else {
                    return;
                }
            }
            try {
                K(null, false);
            } catch (b e5) {
                throw d(e5, this.w);
            }
        }
    }

    public final void K(MediaCrypto mediaCrypto, boolean z3) {
        String str;
        String str2;
        if (this.F == null) {
            try {
                List D = D(z3);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.F = arrayDeque;
                if (this.f24o) {
                    arrayDeque.addAll(D);
                } else if (!D.isEmpty()) {
                    this.F.add(D.get(0));
                }
                this.G = null;
            } catch (k e5) {
                throw new b(this.w, e5, z3, -49998);
            }
        }
        if (!this.F.isEmpty()) {
            while (this.C == null) {
                a aVar = (a) this.F.peekFirst();
                if (!W(aVar)) {
                    return;
                }
                try {
                    I(aVar, mediaCrypto);
                } catch (Exception e6) {
                    Log.w("MediaCodecRenderer", "Failed to initialize decoder: " + aVar, e6);
                    this.F.removeFirst();
                    Format format = this.w;
                    String str3 = "Decoder init failed: " + aVar.f1a + ", " + format;
                    String str4 = format.f311i;
                    if (w.f1960a >= 21) {
                        if (e6 instanceof MediaCodec.CodecException) {
                            str2 = ((MediaCodec.CodecException) e6).getDiagnosticInfo();
                        } else {
                            str2 = null;
                        }
                        str = str2;
                    } else {
                        str = null;
                    }
                    b bVar = new b(str3, e6, str4, z3, aVar, str);
                    b bVar2 = this.G;
                    if (bVar2 == null) {
                        this.G = bVar;
                    } else {
                        this.G = new b(bVar2.getMessage(), bVar2.getCause(), bVar2.f6a, bVar2.b, bVar2.c, bVar2.d);
                    }
                    if (this.F.isEmpty()) {
                        throw this.G;
                    }
                }
            }
            this.F = null;
            return;
        }
        throw new b(this.w, null, z3, -49999);
    }

    public abstract void L(long j2, long j5, String str);

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d0, code lost:
        if (r1.f317o == r6.f317o) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M(j0.b r6) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.c.M(j0.b):void");
    }

    public abstract void N(MediaCodec mediaCodec, MediaFormat mediaFormat);

    public abstract void O(long j2);

    public abstract void P(m0.d dVar);

    public final void Q() {
        int i3 = this.f11e0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f17k0 = true;
                    U();
                    return;
                }
                T();
                J();
                return;
            }
            this.f33z.getClass();
            T();
            J();
        } else if (C()) {
            J();
        }
    }

    public abstract boolean R(long j2, long j5, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i3, int i5, long j6, boolean z3, boolean z5, Format format);

    public final boolean S(boolean z3) {
        j0.b bVar = this.b;
        bVar.b();
        m0.d dVar = this.f27r;
        dVar.clear();
        int q = q(bVar, dVar, z3);
        if (q == -5) {
            M(bVar);
            return true;
        } else if (q == -4 && dVar.isEndOfStream()) {
            this.f16j0 = true;
            Q();
            return false;
        } else {
            return false;
        }
    }

    public void T() {
        this.F = null;
        this.H = null;
        this.D = null;
        V();
        this.W = -1;
        this.X = null;
        if (w.f1960a < 21) {
            this.S = null;
            this.T = null;
        }
        this.U = -9223372036854775807L;
        this.f28t.clear();
        this.f14h0 = -9223372036854775807L;
        this.f15i0 = -9223372036854775807L;
        try {
            MediaCodec mediaCodec = this.C;
            if (mediaCodec != null) {
                this.f25o0.getClass();
                mediaCodec.stop();
                this.C.release();
            }
            this.C = null;
            this.f32y = null;
        } catch (Throwable th) {
            this.C = null;
            this.f32y = null;
            throw th;
        }
    }

    public final void V() {
        this.V = -1;
        this.q.b = null;
    }

    public boolean W(a aVar) {
        return true;
    }

    public abstract int X(d dVar, Format format);

    public final void Y() {
        if (w.f1960a < 23) {
            return;
        }
        float F = F(this.B, this.f2249g);
        float f4 = this.E;
        if (f4 != F) {
            if (F == -1.0f) {
                y();
            } else if (f4 != -1.0f || F > this.f26p) {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", F);
                this.C.setParameters(bundle);
                this.E = F;
            }
        }
    }

    @Override // j0.h
    public boolean h() {
        return this.f17k0;
    }

    @Override // j0.h
    public boolean i() {
        boolean isReady;
        boolean z3;
        if (this.w == null) {
            return false;
        }
        if (g()) {
            isReady = this.f2252j;
        } else {
            isReady = this.f2248f.isReady();
        }
        if (!isReady) {
            if (this.W >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3 && (this.U == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.U)) {
                return false;
            }
        }
        return true;
    }

    @Override // j0.h
    public void j() {
        this.w = null;
        if (this.f33z == null && this.f32y == null) {
            C();
        } else {
            m();
        }
    }

    @Override // j0.h
    public abstract void m();

    @Override // j0.h
    public final void r(long j2, long j5) {
        if (this.f23n0) {
            this.f23n0 = false;
            Q();
        }
        try {
            if (this.f17k0) {
                U();
            } else if (this.w == null && !S(true)) {
            } else {
                J();
                if (this.C != null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    g2.b.b("drainAndFeed");
                    while (A(j2, j5)) {
                    }
                    while (B()) {
                        long j6 = this.A;
                        if (j6 != -9223372036854775807L && SystemClock.elapsedRealtime() - elapsedRealtime >= j6) {
                            break;
                        }
                    }
                    g2.b.m();
                } else {
                    this.f25o0.getClass();
                    this.f2248f.g(j2 - this.f2250h);
                    S(false);
                }
                synchronized (this.f25o0) {
                }
            }
        } catch (IllegalStateException e5) {
            if (w.f1960a < 21 || !(e5 instanceof MediaCodec.CodecException)) {
                StackTraceElement[] stackTrace = e5.getStackTrace();
                if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
                    throw e5;
                }
            }
            throw d(e5, this.w);
        }
    }

    @Override // j0.h
    public final void t(float f4) {
        this.B = f4;
        if (this.C != null && this.f11e0 != 3 && this.f2247e != 0) {
            Y();
        }
    }

    @Override // j0.h
    public final int u(Format format) {
        try {
            return X(this.f18l, format);
        } catch (k e5) {
            throw d(e5, format);
        }
    }

    @Override // j0.h
    public final int v() {
        return 8;
    }

    public abstract int w(a aVar, Format format, Format format2);

    public abstract void x(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f4);

    public final void y() {
        if (this.f12f0) {
            this.f10d0 = 1;
            this.f11e0 = 3;
            return;
        }
        T();
        J();
    }

    public final void z() {
        if (w.f1960a < 23) {
            y();
        } else if (this.f12f0) {
            this.f10d0 = 1;
            this.f11e0 = 2;
        } else {
            this.f33z.getClass();
            T();
            J();
        }
    }

    public void H(m0.d dVar) {
    }

    public void U() {
    }
}

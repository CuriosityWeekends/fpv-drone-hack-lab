package h2;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.DummySurface;
import g2.w;
import j0.p0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends a1.c {
    public static final int[] d1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: e1  reason: collision with root package name */
    public static boolean f1993e1;

    /* renamed from: f1  reason: collision with root package name */
    public static boolean f1994f1;
    public boolean A0;
    public Surface B0;
    public DummySurface C0;
    public int D0;
    public boolean E0;
    public long F0;
    public long G0;
    public long H0;
    public int I0;
    public int J0;
    public int K0;
    public long L0;
    public int M0;
    public float N0;
    public int O0;
    public int P0;
    public int Q0;
    public float R0;
    public int S0;
    public int T0;
    public int U0;
    public float V0;
    public boolean W0;
    public int X0;
    public f Y0;
    public long Z0;

    /* renamed from: a1  reason: collision with root package name */
    public long f1995a1;

    /* renamed from: b1  reason: collision with root package name */
    public int f1996b1;

    /* renamed from: c1  reason: collision with root package name */
    public d2.f f1997c1;

    /* renamed from: q0  reason: collision with root package name */
    public final Context f1998q0;

    /* renamed from: r0  reason: collision with root package name */
    public final m f1999r0;

    /* renamed from: s0  reason: collision with root package name */
    public final c1.b f2000s0;

    /* renamed from: t0  reason: collision with root package name */
    public final long f2001t0;

    /* renamed from: u0  reason: collision with root package name */
    public final int f2002u0;

    /* renamed from: v0  reason: collision with root package name */
    public final boolean f2003v0;

    /* renamed from: w0  reason: collision with root package name */
    public final long[] f2004w0;

    /* renamed from: x0  reason: collision with root package name */
    public final long[] f2005x0;

    /* renamed from: y0  reason: collision with root package name */
    public d f2006y0;

    /* renamed from: z0  reason: collision with root package name */
    public boolean f2007z0;

    public g(Context context, n0.b bVar, Handler handler, p0 p0Var) {
        super(2, bVar, 30.0f);
        this.f2001t0 = 5000L;
        this.f2002u0 = 50;
        Context applicationContext = context.getApplicationContext();
        this.f1998q0 = applicationContext;
        this.f1999r0 = new m(applicationContext);
        this.f2000s0 = new c1.b(6, handler, p0Var, false);
        this.f2003v0 = "NVIDIA".equals(w.c);
        this.f2004w0 = new long[10];
        this.f2005x0 = new long[10];
        this.f1995a1 = -9223372036854775807L;
        this.Z0 = -9223372036854775807L;
        this.G0 = -9223372036854775807L;
        this.O0 = -1;
        this.P0 = -1;
        this.R0 = -1.0f;
        this.N0 = -1.0f;
        this.D0 = 1;
        this.S0 = -1;
        this.T0 = -1;
        this.V0 = -1.0f;
        this.U0 = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:424:0x0656 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a0(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 2400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.g.a0(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b0(a1.a aVar, String str, int i3, int i5) {
        char c;
        int i6;
        int i7 = 4;
        if (i3 == -1 || i5 == -1) {
            return -1;
        }
        str.getClass();
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
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
            case 2:
            case 4:
                i6 = i3 * i5;
                i7 = 2;
                break;
            case 1:
            case 5:
                i6 = i3 * i5;
                break;
            case 3:
                String str2 = w.d;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(w.c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && aVar.f3f)))) {
                    return -1;
                }
                i6 = w.e(i5, 16) * w.e(i3, 16) * 256;
                i7 = 2;
                break;
                break;
            default:
                return -1;
        }
        return (i6 * 3) / (i7 * 2);
    }

    public static List c0(a1.d dVar, Format format, boolean z3, boolean z5) {
        Pair c;
        String str = format.f311i;
        if (str == null) {
            return Collections.emptyList();
        }
        dVar.getClass();
        ArrayList arrayList = new ArrayList(a1.o.d(str, z3, z5));
        Collections.sort(arrayList, new a1.h(new a1.g(0, format)));
        if ("video/dolby-vision".equals(str) && (c = a1.o.c(format)) != null) {
            int intValue = ((Integer) c.first).intValue();
            if (intValue != 16 && intValue != 256) {
                if (intValue == 512) {
                    arrayList.addAll(a1.o.d("video/avc", z3, z5));
                }
            } else {
                arrayList.addAll(a1.o.d("video/hevc", z3, z5));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static int d0(a1.a aVar, Format format) {
        if (format.f312j != -1) {
            List list = format.f313k;
            int size = list.size();
            int i3 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                i3 += ((byte[]) list.get(i5)).length;
            }
            return format.f312j + i3;
        }
        return b0(aVar, format.f311i, format.f316n, format.f317o);
    }

    @Override // a1.c
    public final boolean C() {
        try {
            return super.C();
        } finally {
            this.K0 = 0;
        }
    }

    @Override // a1.c
    public final boolean E() {
        if (this.W0 && w.f1960a < 23) {
            return true;
        }
        return false;
    }

    @Override // a1.c
    public final float F(float f4, Format[] formatArr) {
        float f5 = -1.0f;
        for (Format format : formatArr) {
            float f6 = format.f318p;
            if (f6 != -1.0f) {
                f5 = Math.max(f5, f6);
            }
        }
        if (f5 == -1.0f) {
            return -1.0f;
        }
        return f5 * f4;
    }

    @Override // a1.c
    public final List G(a1.d dVar, Format format, boolean z3) {
        return c0(dVar, format, z3, this.W0);
    }

    @Override // a1.c
    public final void H(m0.d dVar) {
        if (!this.A0) {
            return;
        }
        ByteBuffer byteBuffer = dVar.d;
        byteBuffer.getClass();
        if (byteBuffer.remaining() >= 7) {
            byte b = byteBuffer.get();
            short s = byteBuffer.getShort();
            short s5 = byteBuffer.getShort();
            byte b5 = byteBuffer.get();
            byte b6 = byteBuffer.get();
            byteBuffer.position(0);
            if (b == -75 && s == 60 && s5 == 1 && b5 == 4 && b6 == 0) {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                byteBuffer.position(0);
                MediaCodec mediaCodec = this.C;
                Bundle bundle = new Bundle();
                bundle.putByteArray("hdr10-plus-info", bArr);
                mediaCodec.setParameters(bundle);
            }
        }
    }

    @Override // a1.c
    public final void L(long j2, long j5, String str) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        c1.b bVar = this.f2000s0;
        Handler handler = (Handler) bVar.b;
        if (handler != null) {
            handler.post(new r(bVar, str, j2, j5, 0));
        }
        this.f2007z0 = a0(str);
        a1.a aVar = this.H;
        aVar.getClass();
        boolean z3 = false;
        if (w.f1960a >= 29 && "video/x-vnd.on2.vp9".equals(aVar.b)) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = aVar.d;
            if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
            }
            int length = codecProfileLevelArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (codecProfileLevelArr[i3].profile == 16384) {
                    z3 = true;
                    break;
                } else {
                    i3++;
                }
            }
        }
        this.A0 = z3;
    }

    @Override // a1.c
    public final void M(j0.b bVar) {
        super.M(bVar);
        Format format = (Format) bVar.d;
        c1.b bVar2 = this.f2000s0;
        Handler handler = (Handler) bVar2.b;
        if (handler != null) {
            handler.post(new d2.h(4, bVar2, format));
        }
        this.N0 = format.f319r;
        this.M0 = format.q;
    }

    @Override // a1.c
    public final void N(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z3;
        int integer;
        int integer2;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        if (z3) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        h0(mediaCodec, integer, integer2);
    }

    @Override // a1.c
    public final void O(long j2) {
        if (!this.W0) {
            this.K0--;
        }
        while (true) {
            int i3 = this.f1996b1;
            if (i3 != 0) {
                long[] jArr = this.f2005x0;
                if (j2 >= jArr[0]) {
                    long[] jArr2 = this.f2004w0;
                    this.f1995a1 = jArr2[0];
                    int i5 = i3 - 1;
                    this.f1996b1 = i5;
                    System.arraycopy(jArr2, 1, jArr2, 0, i5);
                    System.arraycopy(jArr, 1, jArr, 0, this.f1996b1);
                    Z();
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
        if (!this.W0) {
            this.K0++;
        }
        this.Z0 = Math.max(dVar.c, this.Z0);
        if (w.f1960a < 23 && this.W0) {
            long j2 = dVar.c;
            Format format = (Format) this.s.e(j2);
            if (format != null) {
                this.f31x = format;
            }
            if (format != null) {
                h0(this.C, format.f316n, format.f317o);
            }
            f0();
            if (!this.E0) {
                this.E0 = true;
                Surface surface = this.B0;
                c1.b bVar = this.f2000s0;
                Handler handler = (Handler) bVar.b;
                if (handler != null) {
                    handler.post(new d2.h(3, bVar, surface));
                }
            }
            O(j2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0178 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a4 A[ADDED_TO_REGION] */
    @Override // a1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean R(long r29, long r31, android.media.MediaCodec r33, java.nio.ByteBuffer r34, int r35, int r36, long r37, boolean r39, boolean r40, com.google.android.exoplayer2.Format r41) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.g.R(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean, boolean, com.google.android.exoplayer2.Format):boolean");
    }

    @Override // a1.c
    public final void T() {
        try {
            super.T();
        } finally {
            this.K0 = 0;
        }
    }

    @Override // a1.c
    public final boolean W(a1.a aVar) {
        if (this.B0 == null && !k0(aVar)) {
            return false;
        }
        return true;
    }

    @Override // a1.c
    public final int X(a1.d dVar, Format format) {
        boolean z3;
        int i3;
        int i5;
        int i6 = 0;
        if (!g2.k.h(format.f311i)) {
            return 0;
        }
        DrmInitData drmInitData = format.f314l;
        if (drmInitData != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        List c02 = c0(dVar, format, z3, false);
        if (z3 && c02.isEmpty()) {
            c02 = c0(dVar, format, false, false);
        }
        if (c02.isEmpty()) {
            return 1;
        }
        if (drmInitData != null && !n0.c.class.equals(format.C)) {
            return 2;
        }
        a1.a aVar = (a1.a) c02.get(0);
        boolean b = aVar.b(format);
        if (aVar.c(format)) {
            i3 = 16;
        } else {
            i3 = 8;
        }
        if (b) {
            List c03 = c0(dVar, format, z3, true);
            if (!c03.isEmpty()) {
                a1.a aVar2 = (a1.a) c03.get(0);
                if (aVar2.b(format) && aVar2.c(format)) {
                    i6 = 32;
                }
            }
        }
        if (b) {
            i5 = 4;
        } else {
            i5 = 3;
        }
        return i5 | i3 | i6;
    }

    public final void Z() {
        MediaCodec mediaCodec;
        this.E0 = false;
        if (w.f1960a >= 23 && this.W0 && (mediaCodec = this.C) != null) {
            this.Y0 = new f(this, mediaCodec);
        }
    }

    public final void e0() {
        if (this.I0 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final long j2 = elapsedRealtime - this.H0;
            final int i3 = this.I0;
            final c1.b bVar = this.f2000s0;
            Handler handler = (Handler) bVar.b;
            if (handler != null) {
                handler.post(new Runnable() { // from class: h2.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        c1.b bVar2 = c1.b.this;
                        bVar2.getClass();
                        int i5 = w.f1960a;
                        ((s) bVar2.c).onDroppedFrames(i3, j2);
                    }
                });
            }
            this.I0 = 0;
            this.H0 = elapsedRealtime;
        }
    }

    @Override // j0.h
    public final void f(int i3, Object obj) {
        long j2;
        if (i3 == 1) {
            Surface surface = (Surface) obj;
            DummySurface dummySurface = surface;
            if (surface == null) {
                DummySurface dummySurface2 = this.C0;
                if (dummySurface2 != null) {
                    dummySurface = dummySurface2;
                } else {
                    a1.a aVar = this.H;
                    dummySurface = surface;
                    if (aVar != null) {
                        dummySurface = surface;
                        if (k0(aVar)) {
                            DummySurface e5 = DummySurface.e(this.f1998q0, aVar.f3f);
                            this.C0 = e5;
                            dummySurface = e5;
                        }
                    }
                }
            }
            Surface surface2 = this.B0;
            c1.b bVar = this.f2000s0;
            if (surface2 != dummySurface) {
                this.B0 = dummySurface;
                int i5 = this.f2247e;
                MediaCodec mediaCodec = this.C;
                if (mediaCodec != null) {
                    if (w.f1960a >= 23 && dummySurface != null && !this.f2007z0) {
                        mediaCodec.setOutputSurface(dummySurface);
                    } else {
                        T();
                        J();
                    }
                }
                if (dummySurface != null && dummySurface != this.C0) {
                    int i6 = this.S0;
                    if (i6 != -1 || this.T0 != -1) {
                        int i7 = this.T0;
                        int i8 = this.U0;
                        float f4 = this.V0;
                        Handler handler = (Handler) bVar.b;
                        if (handler != null) {
                            handler.post(new o(bVar, i6, i7, i8, f4));
                        }
                    }
                    Z();
                    if (i5 == 2) {
                        long j5 = this.f2001t0;
                        if (j5 > 0) {
                            j2 = SystemClock.elapsedRealtime() + j5;
                        } else {
                            j2 = -9223372036854775807L;
                        }
                        this.G0 = j2;
                        return;
                    }
                    return;
                }
                this.S0 = -1;
                this.T0 = -1;
                this.V0 = -1.0f;
                this.U0 = -1;
                Z();
            } else if (dummySurface != null && dummySurface != this.C0) {
                int i9 = this.S0;
                if (i9 != -1 || this.T0 != -1) {
                    int i10 = this.T0;
                    int i11 = this.U0;
                    float f5 = this.V0;
                    Handler handler2 = (Handler) bVar.b;
                    if (handler2 != null) {
                        handler2.post(new o(bVar, i9, i10, i11, f5));
                    }
                }
                if (this.E0) {
                    Surface surface3 = this.B0;
                    Handler handler3 = (Handler) bVar.b;
                    if (handler3 != null) {
                        handler3.post(new d2.h(3, bVar, surface3));
                    }
                }
            }
        } else if (i3 == 4) {
            int intValue = ((Integer) obj).intValue();
            this.D0 = intValue;
            MediaCodec mediaCodec2 = this.C;
            if (mediaCodec2 != null) {
                mediaCodec2.setVideoScalingMode(intValue);
            }
        } else if (i3 == 6) {
            this.f1997c1 = (d2.f) obj;
        }
    }

    public final void f0() {
        int i3 = this.O0;
        if (i3 != -1 || this.P0 != -1) {
            if (this.S0 != i3 || this.T0 != this.P0 || this.U0 != this.Q0 || this.V0 != this.R0) {
                int i5 = this.P0;
                int i6 = this.Q0;
                float f4 = this.R0;
                c1.b bVar = this.f2000s0;
                Handler handler = (Handler) bVar.b;
                if (handler != null) {
                    handler.post(new o(bVar, i3, i5, i6, f4));
                }
                this.S0 = this.O0;
                this.T0 = this.P0;
                this.U0 = this.Q0;
                this.V0 = this.R0;
            }
        }
    }

    public final void g0(long j2, long j5, Format format) {
        d2.f fVar;
        float f4;
        int i3;
        int i5;
        int i6;
        ArrayList arrayList;
        int c;
        d2.f fVar2 = this.f1997c1;
        if (fVar2 != null) {
            fVar2.f1617e.a(j5, Long.valueOf(j2));
            byte[] bArr = format.f320t;
            int i7 = format.s;
            byte[] bArr2 = fVar2.f1625m;
            int i8 = fVar2.f1624l;
            fVar2.f1625m = bArr;
            if (i7 == -1) {
                i7 = fVar2.f1623k;
            }
            fVar2.f1624l = i7;
            if (i8 != i7 || !Arrays.equals(bArr2, fVar2.f1625m)) {
                byte[] bArr3 = fVar2.f1625m;
                i2.c cVar = null;
                if (bArr3 != null) {
                    int i9 = fVar2.f1624l;
                    c0.b bVar = new c0.b(bArr3);
                    try {
                        bVar.z(4);
                        c = bVar.c();
                        bVar.y(0);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                    if (c == 1886547818) {
                        bVar.z(8);
                        int i10 = bVar.b;
                        int i11 = bVar.c;
                        while (i10 < i11) {
                            int c5 = bVar.c() + i10;
                            if (c5 <= i10 || c5 > i11) {
                                break;
                            }
                            int c6 = bVar.c();
                            if (c6 != 2037673328 && c6 != 1836279920) {
                                bVar.y(c5);
                                i10 = c5;
                            }
                            bVar.x(c5);
                            arrayList = com.bumptech.glide.c.h(bVar);
                            break;
                        }
                        arrayList = null;
                    } else {
                        arrayList = com.bumptech.glide.c.h(bVar);
                    }
                    if (arrayList != null) {
                        int size = arrayList.size();
                        if (size != 1) {
                            if (size == 2) {
                                cVar = new i2.c((i2.b) arrayList.get(0), (i2.b) arrayList.get(1), i9);
                            }
                        } else {
                            i2.b bVar2 = (i2.b) arrayList.get(0);
                            cVar = new i2.c(bVar2, bVar2, i9);
                        }
                    }
                }
                if (cVar != null && d2.d.a(cVar)) {
                    fVar = fVar2;
                } else {
                    int i12 = fVar2.f1624l;
                    float radians = (float) Math.toRadians(180.0f);
                    float radians2 = (float) Math.toRadians(360.0f);
                    float f5 = radians / 36;
                    float f6 = radians2 / 72;
                    float[] fArr = new float[15984];
                    float[] fArr2 = new float[10656];
                    int i13 = 0;
                    int i14 = 0;
                    int i15 = 0;
                    for (int i16 = 36; i13 < i16; i16 = 36) {
                        float f7 = radians / 2.0f;
                        float f8 = (i13 * f5) - f7;
                        int i17 = i13 + 1;
                        float f9 = (i17 * f5) - f7;
                        int i18 = 0;
                        while (i18 < 73) {
                            float f10 = f9;
                            float f11 = f8;
                            int i19 = i14;
                            int i20 = i15;
                            int i21 = 0;
                            while (i21 < 2) {
                                if (i21 == 0) {
                                    f4 = f11;
                                } else {
                                    f4 = f10;
                                }
                                float f12 = i18 * f6;
                                float f13 = f6;
                                d2.f fVar3 = fVar2;
                                float f14 = radians;
                                double d = 50.0f;
                                int i22 = i12;
                                double d5 = (3.1415927f + f12) - (radians2 / 2.0f);
                                float f15 = f5;
                                double d6 = f4;
                                int i23 = i13;
                                fArr[i19] = -((float) (Math.cos(d6) * Math.sin(d5) * d));
                                int i24 = i18;
                                int i25 = i20;
                                fArr[i19 + 1] = (float) (Math.sin(d6) * d);
                                int i26 = i19 + 3;
                                fArr[i19 + 2] = (float) (Math.cos(d6) * Math.cos(d5) * d);
                                fArr2[i25] = f12 / radians2;
                                int i27 = i25 + 2;
                                fArr2[i25 + 1] = ((i23 + i21) * f15) / f14;
                                if (i24 != 0 || i21 != 0) {
                                    i3 = i24;
                                    i5 = 1;
                                    i6 = 3;
                                    if (i3 != 72 || i21 != 1) {
                                        i19 = i26;
                                        i20 = i27;
                                        i21 += i5;
                                        i18 = i3;
                                        f6 = f13;
                                        fVar2 = fVar3;
                                        radians = f14;
                                        f5 = f15;
                                        i13 = i23;
                                        i12 = i22;
                                    }
                                } else {
                                    i3 = i24;
                                    i5 = 1;
                                    i6 = 3;
                                }
                                System.arraycopy(fArr, i19, fArr, i26, i6);
                                i19 += 6;
                                System.arraycopy(fArr2, i25, fArr2, i27, 2);
                                i20 = i25 + 4;
                                i21 += i5;
                                i18 = i3;
                                f6 = f13;
                                fVar2 = fVar3;
                                radians = f14;
                                f5 = f15;
                                i13 = i23;
                                i12 = i22;
                            }
                            i18++;
                            i14 = i19;
                            i15 = i20;
                            f9 = f10;
                            f8 = f11;
                            fVar2 = fVar2;
                            radians = radians;
                            i12 = i12;
                        }
                        i13 = i17;
                    }
                    int i28 = i12;
                    i2.b bVar3 = new i2.b(new d2.c(0, fArr, fArr2, 1));
                    cVar = new i2.c(bVar3, bVar3, i28);
                    fVar = fVar2;
                }
                fVar.f1618f.a(j5, cVar);
            }
        }
    }

    public final void h0(MediaCodec mediaCodec, int i3, int i5) {
        this.O0 = i3;
        this.P0 = i5;
        float f4 = this.N0;
        this.R0 = f4;
        if (w.f1960a >= 21) {
            int i6 = this.M0;
            if (i6 == 90 || i6 == 270) {
                this.O0 = i5;
                this.P0 = i3;
                this.R0 = 1.0f / f4;
            }
        } else {
            this.Q0 = this.M0;
        }
        mediaCodec.setVideoScalingMode(this.D0);
    }

    @Override // a1.c, j0.h
    public final boolean i() {
        DummySurface dummySurface;
        if (super.i() && (this.E0 || (((dummySurface = this.C0) != null && this.B0 == dummySurface) || this.C == null || this.W0))) {
            this.G0 = -9223372036854775807L;
            return true;
        } else if (this.G0 == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.G0) {
                return true;
            }
            this.G0 = -9223372036854775807L;
            return false;
        }
    }

    public final void i0(MediaCodec mediaCodec, int i3) {
        f0();
        g2.b.b("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i3, true);
        g2.b.m();
        this.L0 = SystemClock.elapsedRealtime() * 1000;
        this.f25o0.getClass();
        this.J0 = 0;
        if (!this.E0) {
            this.E0 = true;
            Surface surface = this.B0;
            c1.b bVar = this.f2000s0;
            Handler handler = (Handler) bVar.b;
            if (handler != null) {
                handler.post(new d2.h(3, bVar, surface));
            }
        }
    }

    @Override // a1.c, j0.h
    public final void j() {
        c1.b bVar = this.f2000s0;
        this.Z0 = -9223372036854775807L;
        this.f1995a1 = -9223372036854775807L;
        this.f1996b1 = 0;
        this.S0 = -1;
        this.T0 = -1;
        this.V0 = -1.0f;
        this.U0 = -1;
        Z();
        m mVar = this.f1999r0;
        if (mVar.f2022a != null) {
            k kVar = mVar.c;
            if (kVar != null) {
                kVar.f2019a.unregisterDisplayListener(kVar);
            }
            mVar.b.b.sendEmptyMessage(2);
        }
        this.Y0 = null;
        try {
            super.j();
            m0.c cVar = this.f25o0;
            bVar.getClass();
            synchronized (cVar) {
            }
            Handler handler = (Handler) bVar.b;
            if (handler != null) {
                handler.post(new q(bVar, cVar, 0));
            }
        } catch (Throwable th) {
            bVar.o(this.f25o0);
            throw th;
        }
    }

    public final void j0(MediaCodec mediaCodec, int i3, long j2) {
        f0();
        g2.b.b("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i3, j2);
        g2.b.m();
        this.L0 = SystemClock.elapsedRealtime() * 1000;
        this.f25o0.getClass();
        this.J0 = 0;
        if (!this.E0) {
            this.E0 = true;
            Surface surface = this.B0;
            c1.b bVar = this.f2000s0;
            Handler handler = (Handler) bVar.b;
            if (handler != null) {
                handler.post(new d2.h(3, bVar, surface));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, m0.c] */
    @Override // j0.h
    public final void k(boolean z3) {
        boolean z5;
        if (this.f20m != null && !this.f30v) {
            this.f30v = true;
        }
        this.f25o0 = new Object();
        int i3 = this.X0;
        int i5 = this.c.f2275a;
        this.X0 = i5;
        if (i5 != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.W0 = z5;
        if (i5 != i3) {
            T();
        }
        m0.c cVar = this.f25o0;
        c1.b bVar = this.f2000s0;
        Handler handler = (Handler) bVar.b;
        if (handler != null) {
            handler.post(new q(bVar, cVar, 1));
        }
        m mVar = this.f1999r0;
        mVar.f2027i = false;
        if (mVar.f2022a != null) {
            mVar.b.b.sendEmptyMessage(1);
            k kVar = mVar.c;
            if (kVar != null) {
                kVar.f2019a.registerDisplayListener(kVar, null);
            }
            mVar.a();
        }
    }

    public final boolean k0(a1.a aVar) {
        if (w.f1960a >= 23 && !this.W0 && !a0(aVar.f1a) && (!aVar.f3f || DummySurface.d(this.f1998q0))) {
            return true;
        }
        return false;
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
        Z();
        long j5 = -9223372036854775807L;
        this.F0 = -9223372036854775807L;
        this.J0 = 0;
        this.Z0 = -9223372036854775807L;
        int i3 = this.f1996b1;
        if (i3 != 0) {
            this.f1995a1 = this.f2004w0[i3 - 1];
            this.f1996b1 = 0;
        }
        if (z3) {
            long j6 = this.f2001t0;
            if (j6 > 0) {
                j5 = SystemClock.elapsedRealtime() + j6;
            }
            this.G0 = j5;
            return;
        }
        this.G0 = -9223372036854775807L;
    }

    public final void l0(MediaCodec mediaCodec, int i3) {
        g2.b.b("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i3, false);
        g2.b.m();
        this.f25o0.getClass();
    }

    @Override // a1.c, j0.h
    public final void m() {
        try {
            T();
            this.f33z = null;
            if (this.f20m != null && this.f30v) {
                this.f30v = false;
            }
        } finally {
            DummySurface dummySurface = this.C0;
            if (dummySurface != null) {
                if (this.B0 == dummySurface) {
                    this.B0 = null;
                }
                dummySurface.release();
                this.C0 = null;
            }
        }
    }

    public final void m0(int i3) {
        m0.c cVar = this.f25o0;
        cVar.getClass();
        this.I0 += i3;
        int i5 = this.J0 + i3;
        this.J0 = i5;
        cVar.f2761a = Math.max(i5, cVar.f2761a);
        int i6 = this.f2002u0;
        if (i6 > 0 && this.I0 >= i6) {
            e0();
        }
    }

    @Override // j0.h
    public final void n() {
        this.I0 = 0;
        this.H0 = SystemClock.elapsedRealtime();
        this.L0 = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // j0.h
    public final void o() {
        this.G0 = -9223372036854775807L;
        e0();
    }

    @Override // j0.h
    public final void p(Format[] formatArr, long j2) {
        if (this.f1995a1 == -9223372036854775807L) {
            this.f1995a1 = j2;
            return;
        }
        int i3 = this.f1996b1;
        long[] jArr = this.f2004w0;
        if (i3 == jArr.length) {
            Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + jArr[this.f1996b1 - 1]);
        } else {
            this.f1996b1 = i3 + 1;
        }
        int i5 = this.f1996b1 - 1;
        jArr[i5] = j2;
        this.f2005x0[i5] = this.Z0;
    }

    @Override // a1.c
    public final int w(a1.a aVar, Format format, Format format2) {
        if (aVar.d(format, format2, true)) {
            int i3 = format2.f316n;
            d dVar = this.f2006y0;
            if (i3 <= dVar.f1991a && format2.f317o <= dVar.b && d0(aVar, format2) <= this.f2006y0.c) {
                if (format.t(format2)) {
                    return 3;
                }
                return 2;
            }
            return 0;
        }
        return 0;
    }

    @Override // a1.c
    public final void x(a1.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto, float f4) {
        String str;
        int i3;
        int i5;
        int i6;
        d dVar;
        boolean z3;
        int i7;
        int i8;
        String str2;
        Point point;
        int i9;
        int i10;
        int i11;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        Point point2;
        int i12;
        boolean z5;
        boolean z6;
        Pair c;
        int b02;
        String str3 = aVar.c;
        Format[] formatArr = this.f2249g;
        int i13 = format.f316n;
        int d02 = d0(aVar, format);
        int length = formatArr.length;
        float f5 = format.f318p;
        int i14 = format.f317o;
        String str4 = format.f311i;
        int i15 = format.f316n;
        if (length == 1) {
            if (d02 != -1 && (b02 = b0(aVar, str4, i15, i14)) != -1) {
                d02 = Math.min((int) (d02 * 1.5f), b02);
            }
            dVar = new d(i13, i14, d02);
            str = str3;
            i3 = i14;
            i5 = i15;
        } else {
            int length2 = formatArr.length;
            int i16 = i14;
            int i17 = 0;
            boolean z7 = false;
            while (i17 < length2) {
                Format format2 = formatArr[i17];
                Format[] formatArr2 = formatArr;
                if (aVar.d(format, format2, false)) {
                    int i18 = format2.f316n;
                    i12 = length2;
                    int i19 = format2.f317o;
                    if (i18 != -1 && i19 != -1) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    z7 |= z5;
                    int max = Math.max(i13, i18);
                    i16 = Math.max(i16, i19);
                    d02 = Math.max(d02, d0(aVar, format2));
                    i13 = max;
                } else {
                    i12 = length2;
                }
                i17++;
                formatArr = formatArr2;
                length2 = i12;
            }
            int i20 = i16;
            if (z7) {
                String str5 = "MediaCodecVideoRenderer";
                Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i13 + "x" + i20);
                if (i14 > i15) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    i7 = i14;
                } else {
                    i7 = i15;
                }
                if (z3) {
                    i8 = i15;
                } else {
                    i8 = i14;
                }
                i3 = i14;
                float f6 = i8 / i7;
                int[] iArr = d1;
                str = str3;
                i5 = i15;
                int i21 = 0;
                while (i21 < 9) {
                    int i22 = iArr[i21];
                    int[] iArr2 = iArr;
                    int i23 = (int) (i22 * f6);
                    if (i22 <= i7 || i23 <= i8) {
                        break;
                    }
                    float f7 = f6;
                    int i24 = i8;
                    if (w.f1960a >= 21) {
                        if (z3) {
                            i11 = i23;
                        } else {
                            i11 = i22;
                        }
                        if (!z3) {
                            i22 = i23;
                        }
                        MediaCodecInfo.CodecCapabilities codecCapabilities = aVar.d;
                        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                            i9 = i7;
                            point2 = null;
                        } else {
                            int widthAlignment = videoCapabilities.getWidthAlignment();
                            int heightAlignment = videoCapabilities.getHeightAlignment();
                            i9 = i7;
                            point2 = new Point(w.e(i11, widthAlignment) * widthAlignment, w.e(i22, heightAlignment) * heightAlignment);
                        }
                        str2 = str5;
                        Point point3 = point2;
                        if (aVar.e(point2.x, point2.y, f5)) {
                            point = point3;
                            break;
                        }
                        i21++;
                        iArr = iArr2;
                        f6 = f7;
                        i8 = i24;
                        i7 = i9;
                        str5 = str2;
                    } else {
                        str2 = str5;
                        i9 = i7;
                        try {
                            int e5 = w.e(i22, 16) * 16;
                            int e6 = w.e(i23, 16) * 16;
                            if (e5 * e6 <= a1.o.g()) {
                                if (z3) {
                                    i10 = e6;
                                } else {
                                    i10 = e5;
                                }
                                if (!z3) {
                                    e5 = e6;
                                }
                                point = new Point(i10, e5);
                            } else {
                                i21++;
                                iArr = iArr2;
                                f6 = f7;
                                i8 = i24;
                                i7 = i9;
                                str5 = str2;
                            }
                        } catch (a1.k unused) {
                        }
                    }
                }
                str2 = str5;
                point = null;
                if (point != null) {
                    i13 = Math.max(i13, point.x);
                    i6 = Math.max(i20, point.y);
                    d02 = Math.max(d02, b0(aVar, str4, i13, i6));
                    Log.w(str2, "Codec max resolution adjusted to: " + i13 + "x" + i6);
                    dVar = new d(i13, i6, d02);
                }
            } else {
                str = str3;
                i3 = i14;
                i5 = i15;
            }
            i6 = i20;
            dVar = new d(i13, i6, d02);
        }
        this.f2006y0 = dVar;
        int i25 = this.X0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        mediaFormat.setInteger("width", i5);
        mediaFormat.setInteger("height", i3);
        com.bumptech.glide.c.k(mediaFormat, format.f313k);
        if (f5 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f5);
        }
        com.bumptech.glide.c.g(mediaFormat, "rotation-degrees", format.q);
        ColorInfo colorInfo = format.f321u;
        if (colorInfo != null) {
            com.bumptech.glide.c.g(mediaFormat, "color-transfer", colorInfo.c);
            com.bumptech.glide.c.g(mediaFormat, "color-standard", colorInfo.f497a);
            com.bumptech.glide.c.g(mediaFormat, "color-range", colorInfo.b);
            byte[] bArr = colorInfo.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(str4) && (c = a1.o.c(format)) != null) {
            com.bumptech.glide.c.g(mediaFormat, "profile", ((Integer) c.first).intValue());
        }
        mediaFormat.setInteger("max-width", dVar.f1991a);
        mediaFormat.setInteger("max-height", dVar.b);
        com.bumptech.glide.c.g(mediaFormat, "max-input-size", dVar.c);
        int i26 = w.f1960a;
        if (i26 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f4 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f4);
            }
        }
        if (this.f2003v0) {
            z6 = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z6 = true;
        }
        if (i25 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z6);
            mediaFormat.setInteger("audio-session-id", i25);
        }
        if (this.B0 == null) {
            g2.b.h(k0(aVar));
            if (this.C0 == null) {
                this.C0 = DummySurface.e(this.f1998q0, aVar.f3f);
            }
            this.B0 = this.C0;
        }
        mediaCodec.configure(mediaFormat, this.B0, mediaCrypto, 0);
        if (i26 >= 23 && this.W0) {
            this.Y0 = new f(this, mediaCodec);
        }
    }
}

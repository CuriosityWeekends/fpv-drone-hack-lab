package o1;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import g2.u;
import g2.w;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i extends l1.k {
    public static final p0.m H = new Object();
    public static final AtomicInteger I = new AtomicInteger();
    public p0.j A;
    public boolean B;
    public p C;
    public int D;
    public boolean E;
    public volatile boolean F;
    public boolean G;

    /* renamed from: j  reason: collision with root package name */
    public final int f2977j;

    /* renamed from: k  reason: collision with root package name */
    public final int f2978k;

    /* renamed from: l  reason: collision with root package name */
    public final Uri f2979l;

    /* renamed from: m  reason: collision with root package name */
    public final e2.i f2980m;

    /* renamed from: n  reason: collision with root package name */
    public final e2.l f2981n;

    /* renamed from: o  reason: collision with root package name */
    public final p0.j f2982o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f2983p;
    public final boolean q;

    /* renamed from: r  reason: collision with root package name */
    public final u f2984r;
    public final boolean s;

    /* renamed from: t  reason: collision with root package name */
    public final h f2985t;

    /* renamed from: u  reason: collision with root package name */
    public final List f2986u;

    /* renamed from: v  reason: collision with root package name */
    public final DrmInitData f2987v;
    public final f1.b w;

    /* renamed from: x  reason: collision with root package name */
    public final c0.b f2988x;

    /* renamed from: y  reason: collision with root package name */
    public final boolean f2989y;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f2990z;

    public i(h hVar, e2.i iVar, e2.l lVar, Format format, boolean z3, e2.i iVar2, e2.l lVar2, boolean z5, Uri uri, List list, int i3, Object obj, long j2, long j5, long j6, int i5, boolean z6, boolean z7, u uVar, DrmInitData drmInitData, p0.j jVar, f1.b bVar, c0.b bVar2, boolean z8) {
        super(iVar, lVar, format, i3, obj, j2, j5, j6);
        this.f2989y = z3;
        this.f2978k = i5;
        this.f2981n = lVar2;
        this.f2980m = iVar2;
        this.E = lVar2 != null;
        this.f2990z = z5;
        this.f2979l = uri;
        this.f2983p = z7;
        this.f2984r = uVar;
        this.q = z6;
        this.f2985t = hVar;
        this.f2986u = list;
        this.f2987v = drmInitData;
        this.f2982o = jVar;
        this.w = bVar;
        this.f2988x = bVar2;
        this.s = z8;
        this.f2977j = I.getAndIncrement();
    }

    public static byte[] f(String str) {
        int i3;
        if (w.E(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        if (byteArray.length > 16) {
            i3 = byteArray.length - 16;
        } else {
            i3 = 0;
        }
        System.arraycopy(byteArray, i3, bArr, (16 - byteArray.length) + i3, byteArray.length - i3);
        return bArr;
    }

    @Override // e2.c0
    public final void a() {
        p0.j jVar;
        this.C.getClass();
        if (this.A == null && (jVar = this.f2982o) != null) {
            this.A = jVar;
            this.B = true;
            this.E = false;
        }
        if (this.E) {
            e2.i iVar = this.f2980m;
            iVar.getClass();
            e2.l lVar = this.f2981n;
            lVar.getClass();
            e(iVar, lVar, this.f2990z);
            this.D = 0;
            this.E = false;
        }
        if (!this.F) {
            if (!this.q) {
                if (!this.f2983p) {
                    u uVar = this.f2984r;
                    synchronized (uVar) {
                        while (uVar.c == -9223372036854775807L) {
                            uVar.wait();
                        }
                    }
                } else {
                    u uVar2 = this.f2984r;
                    if (uVar2.f1958a == Long.MAX_VALUE) {
                        uVar2.d(this.f2639f);
                    }
                }
                e(this.f2641h, this.f2637a, this.f2989y);
            }
            this.G = true;
        }
    }

    @Override // e2.c0
    public final void b() {
        this.F = true;
    }

    @Override // l1.k
    public final boolean d() {
        throw null;
    }

    public final void e(e2.i iVar, e2.l lVar, boolean z3) {
        e2.l b;
        boolean z5;
        boolean z6;
        int i3 = 0;
        if (z3) {
            if (this.D != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            z5 = z6;
            b = lVar;
        } else {
            b = lVar.b(this.D);
            z5 = false;
        }
        try {
            p0.g g5 = g(iVar, b);
            if (z5) {
                g5.h(this.D);
            }
            while (i3 == 0 && !this.F) {
                i3 = this.A.h(g5, H);
            }
            this.D = (int) (g5.d - lVar.f1695e);
        } finally {
            w.f(iVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0299  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p0.g g(e2.i r18, e2.l r19) {
        /*
            Method dump skipped, instructions count: 749
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.i.g(e2.i, e2.l):p0.g");
    }
}

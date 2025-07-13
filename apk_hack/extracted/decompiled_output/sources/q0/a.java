package q0;

import a1.i;
import com.google.android.exoplayer2.Format;
import g2.w;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import p0.g;
import p0.j;
import p0.k;
import p0.m;
import p0.n;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements j {

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f3312n;
    public static final int q;
    public boolean b;
    public long c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f3316e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3317f;

    /* renamed from: h  reason: collision with root package name */
    public long f3319h;

    /* renamed from: i  reason: collision with root package name */
    public k f3320i;

    /* renamed from: j  reason: collision with root package name */
    public u f3321j;

    /* renamed from: k  reason: collision with root package name */
    public n f3322k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3323l;

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f3311m = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: o  reason: collision with root package name */
    public static final byte[] f3313o = w.r("#!AMR\n");

    /* renamed from: p  reason: collision with root package name */
    public static final byte[] f3314p = w.r("#!AMR-WB\n");

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3315a = new byte[1];

    /* renamed from: g  reason: collision with root package name */
    public int f3318g = -1;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f3312n = iArr;
        q = iArr[8];
    }

    public final int a(g gVar) {
        String str;
        boolean z3;
        gVar.f3111f = 0;
        byte[] bArr = this.f3315a;
        gVar.d(bArr, 0, 1, false);
        byte b = bArr[0];
        if ((b & 131) <= 0) {
            int i3 = (b >> 3) & 15;
            if (i3 >= 0 && i3 <= 15 && (((z3 = this.b) && (i3 < 10 || i3 > 13)) || (!z3 && (i3 < 12 || i3 > 14)))) {
                if (z3) {
                    return f3312n[i3];
                }
                return f3311m[i3];
            }
            StringBuilder sb = new StringBuilder("Illegal AMR ");
            if (this.b) {
                str = "WB";
            } else {
                str = "NB";
            }
            sb.append(str);
            sb.append(" frame type ");
            sb.append(i3);
            throw new IOException(sb.toString());
        }
        throw new IOException(i.e(b, "Invalid padding bits for frame header "));
    }

    @Override // p0.j
    public final void b(k kVar) {
        this.f3320i = kVar;
        this.f3321j = kVar.g(0, 1);
        kVar.c();
    }

    public final boolean c(g gVar) {
        gVar.f3111f = 0;
        byte[] bArr = f3313o;
        byte[] bArr2 = new byte[bArr.length];
        gVar.d(bArr2, 0, bArr.length, false);
        if (Arrays.equals(bArr2, bArr)) {
            this.b = false;
            gVar.h(bArr.length);
            return true;
        }
        gVar.f3111f = 0;
        byte[] bArr3 = f3314p;
        byte[] bArr4 = new byte[bArr3.length];
        gVar.d(bArr4, 0, bArr3.length, false);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.b = true;
        gVar.h(bArr3.length);
        return true;
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        this.c = 0L;
        this.d = 0;
        this.f3316e = 0;
        if (j2 != 0) {
            n nVar = this.f3322k;
            if (nVar instanceof u0.a) {
                u0.a aVar = (u0.a) nVar;
                this.f3319h = (Math.max(0L, j2 - aVar.b) * 8000000) / aVar.f3727e;
                return;
            }
        }
        this.f3319h = 0L;
    }

    @Override // p0.j
    public final boolean f(g gVar) {
        return c(gVar);
    }

    @Override // p0.j
    public final int h(g gVar, m mVar) {
        String str;
        int i3;
        if (gVar.d == 0 && !c(gVar)) {
            throw new IOException("Could not find AMR header.");
        }
        if (!this.f3323l) {
            this.f3323l = true;
            boolean z3 = this.b;
            if (z3) {
                str = "audio/amr-wb";
            } else {
                str = "audio/3gpp";
            }
            String str2 = str;
            if (z3) {
                i3 = 16000;
            } else {
                i3 = 8000;
            }
            this.f3321j.d(Format.k(null, str2, -1, q, 1, i3, -1, null, null, 0, null));
        }
        int i5 = -1;
        if (this.f3316e == 0) {
            try {
                int a5 = a(gVar);
                this.d = a5;
                this.f3316e = a5;
                if (this.f3318g == -1) {
                    this.f3318g = a5;
                }
            } catch (EOFException unused) {
            }
        }
        int a6 = this.f3321j.a(gVar, this.f3316e, true);
        if (a6 != -1) {
            int i6 = this.f3316e - a6;
            this.f3316e = i6;
            i5 = 0;
            if (i6 <= 0) {
                this.f3321j.c(this.c + this.f3319h, 1, this.d, 0, null);
                this.c += 20000;
            }
        }
        if (!this.f3317f) {
            n nVar = new n(-9223372036854775807L);
            this.f3322k = nVar;
            this.f3320i.a(nVar);
            this.f3317f = true;
        }
        return i5;
    }
}

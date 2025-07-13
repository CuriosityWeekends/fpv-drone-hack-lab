package w0;

import g2.w;
import p0.r;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements g {

    /* renamed from: a  reason: collision with root package name */
    public final f f3902a = new f();
    public final long b;
    public final long c;
    public final i d;

    /* renamed from: e  reason: collision with root package name */
    public int f3903e;

    /* renamed from: f  reason: collision with root package name */
    public long f3904f;

    /* renamed from: g  reason: collision with root package name */
    public long f3905g;

    /* renamed from: h  reason: collision with root package name */
    public long f3906h;

    /* renamed from: i  reason: collision with root package name */
    public long f3907i;

    /* renamed from: j  reason: collision with root package name */
    public long f3908j;

    /* renamed from: k  reason: collision with root package name */
    public long f3909k;

    /* renamed from: l  reason: collision with root package name */
    public long f3910l;

    public b(i iVar, long j2, long j5, long j6, long j7, boolean z3) {
        boolean z5;
        if (j2 >= 0 && j5 > j2) {
            z5 = true;
        } else {
            z5 = false;
        }
        g2.b.e(z5);
        this.d = iVar;
        this.b = j2;
        this.c = j5;
        if (j6 != j5 - j2 && !z3) {
            this.f3903e = 0;
            return;
        }
        this.f3904f = j7;
        this.f3903e = 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b4  */
    @Override // w0.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(p0.g r23) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.b.a(p0.g):long");
    }

    @Override // w0.g
    public final r b() {
        if (this.f3904f != 0) {
            return new a(this);
        }
        return null;
    }

    @Override // w0.g
    public final void c(long j2) {
        this.f3906h = w.i(j2, 0L, this.f3904f - 1);
        this.f3903e = 2;
        this.f3907i = this.b;
        this.f3908j = this.c;
        this.f3909k = 0L;
        this.f3910l = this.f3904f;
    }

    public final boolean d(p0.g gVar, long j2) {
        int i3;
        long min = Math.min(j2 + 3, this.c);
        int i5 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            long j5 = gVar.d;
            int i6 = 0;
            if (i5 + j5 > min && (i5 = (int) (min - j5)) < 4) {
                return false;
            }
            gVar.d(bArr, 0, i5, false);
            while (true) {
                i3 = i5 - 3;
                if (i6 < i3) {
                    if (bArr[i6] == 79 && bArr[i6 + 1] == 103 && bArr[i6 + 2] == 103 && bArr[i6 + 3] == 83) {
                        gVar.h(i6);
                        return true;
                    }
                    i6++;
                }
            }
            gVar.h(i3);
        }
    }
}

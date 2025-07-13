package z0;

import com.google.android.exoplayer2.Format;
import java.io.IOException;
import p0.k;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final k f4277a;
    public final u b;
    public final e c;
    public final Format d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4278e;

    /* renamed from: f  reason: collision with root package name */
    public long f4279f;

    /* renamed from: g  reason: collision with root package name */
    public int f4280g;

    /* renamed from: h  reason: collision with root package name */
    public long f4281h;

    public c(k kVar, u uVar, e eVar, String str, int i3) {
        this.f4277a = kVar;
        this.b = uVar;
        this.c = eVar;
        int i5 = (eVar.b * eVar.f4285e) / 8;
        int i6 = eVar.d;
        if (i6 == i5) {
            int max = Math.max(i5, (eVar.c * i5) / 10);
            this.f4278e = max;
            int i7 = eVar.c;
            this.d = Format.k(null, str, i5 * i7 * 8, max, eVar.b, i7, i3, null, null, 0, null);
            return;
        }
        throw new IOException("Expected block size: " + i5 + "; got: " + i6);
    }

    @Override // z0.b
    public final void a(int i3, long j2) {
        this.f4277a.a(new f(this.c, 1, i3, j2));
        this.b.d(this.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:4:0x0007). Please submit an issue!!! */
    @Override // z0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(p0.g r13, long r14) {
        /*
            r12 = this;
            r0 = 0
            r2 = 1
            int r3 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r3 != 0) goto L9
        L7:
            r0 = 1
            goto La
        L9:
            r0 = 0
        La:
            if (r0 != 0) goto L29
            int r1 = r12.f4280g
            int r3 = r12.f4278e
            if (r1 >= r3) goto L29
            int r3 = r3 - r1
            long r3 = (long) r3
            long r3 = java.lang.Math.min(r3, r14)
            int r1 = (int) r3
            p0.u r3 = r12.b
            int r1 = r3.a(r13, r1, r2)
            r3 = -1
            if (r1 != r3) goto L23
            goto L7
        L23:
            int r3 = r12.f4280g
            int r3 = r3 + r1
            r12.f4280g = r3
            goto La
        L29:
            z0.e r13 = r12.c
            int r14 = r13.d
            int r15 = r12.f4280g
            int r15 = r15 / r14
            if (r15 <= 0) goto L57
            long r1 = r12.f4279f
            long r3 = r12.f4281h
            int r13 = r13.c
            long r7 = (long) r13
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = g2.w.B(r3, r5, r7)
            long r6 = r1 + r3
            int r9 = r15 * r14
            int r13 = r12.f4280g
            int r13 = r13 - r9
            r11 = 0
            p0.u r5 = r12.b
            r8 = 1
            r10 = r13
            r5.c(r6, r8, r9, r10, r11)
            long r1 = r12.f4281h
            long r14 = (long) r15
            long r1 = r1 + r14
            r12.f4281h = r1
            r12.f4280g = r13
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.c.b(p0.g, long):boolean");
    }

    @Override // z0.b
    public final void c(long j2) {
        this.f4279f = j2;
        this.f4280g = 0;
        this.f4281h = 0L;
    }
}

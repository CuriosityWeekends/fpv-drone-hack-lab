package s0;

import a1.i;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends j.a {
    public final c0.b b;
    public final c0.b c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3473e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3474f;

    /* renamed from: g  reason: collision with root package name */
    public int f3475g;

    public d(u uVar) {
        super(uVar);
        this.b = new c0.b(g2.b.d);
        this.c = new c0.b(4);
    }

    public final boolean D(c0.b bVar) {
        int n5 = bVar.n();
        int i3 = (n5 >> 4) & 15;
        int i5 = n5 & 15;
        if (i5 == 7) {
            this.f3475g = i3;
            if (i3 != 5) {
                return true;
            }
            return false;
        }
        throw new IOException(i.e(i5, "Video format not supported: "));
    }

    public final boolean E(c0.b bVar, long j2) {
        int i3;
        int n5 = bVar.n();
        byte[] bArr = bVar.f187a;
        int i5 = bVar.b;
        int i6 = (bArr[i5 + 1] & 255) << 8;
        bVar.b = i5 + 3;
        long j5 = (((bArr[i5 + 2] & 255) | i6 | (((bArr[i5] & 255) << 24) >> 8)) * 1000) + j2;
        u uVar = (u) this.f2183a;
        if (n5 == 0 && !this.f3473e) {
            byte[] bArr2 = new byte[bVar.a()];
            c0.b bVar2 = new c0.b(bArr2);
            bVar.b(bArr2, 0, bVar.a());
            h2.a a5 = h2.a.a(bVar2);
            this.d = a5.b;
            uVar.d(Format.s(null, "video/avc", null, -1, a5.c, a5.d, a5.f1986a, -1, a5.f1987e, null, -1, null, null));
            this.f3473e = true;
            return false;
        } else if (n5 != 1 || !this.f3473e) {
            return false;
        } else {
            if (this.f3475g == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (!this.f3474f && i3 == 0) {
                return false;
            }
            c0.b bVar3 = this.c;
            byte[] bArr3 = bVar3.f187a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i7 = 4 - this.d;
            int i8 = 0;
            while (bVar.a() > 0) {
                bVar.b(bVar3.f187a, i7, this.d);
                bVar3.y(0);
                int q = bVar3.q();
                c0.b bVar4 = this.b;
                bVar4.y(0);
                uVar.b(4, bVar4);
                uVar.b(q, bVar);
                i8 = i8 + 4 + q;
            }
            ((u) this.f2183a).c(j5, i3, i8, 0, null);
            this.f3474f = true;
            return true;
        }
    }
}

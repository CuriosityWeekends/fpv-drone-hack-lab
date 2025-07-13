package w0;

import java.io.EOFException;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public int f3916a;
    public long b;
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f3917e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f3918f = new int[255];

    /* renamed from: g  reason: collision with root package name */
    public final c0.b f3919g = new c0.b(255);

    public final boolean a(p0.g gVar, boolean z3) {
        int i3;
        c0.b bVar = this.f3919g;
        bVar.u();
        this.f3916a = 0;
        this.b = 0L;
        this.c = 0;
        this.d = 0;
        this.f3917e = 0;
        long j2 = gVar.c;
        if ((j2 != -1 && j2 - gVar.c() < 27) || !gVar.d(bVar.f187a, 0, 27, true)) {
            if (z3) {
                return false;
            }
            throw new EOFException();
        } else if (bVar.o() != 1332176723) {
            if (z3) {
                return false;
            }
            throw new IOException("expected OggS capture pattern at begin of page");
        } else if (bVar.n() != 0) {
            if (z3) {
                return false;
            }
            throw new IOException("unsupported bit stream revision");
        } else {
            this.f3916a = bVar.n();
            byte[] bArr = bVar.f187a;
            bVar.b = bVar.b + 8;
            this.b = ((bArr[i3 + 2] & 255) << 16) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48) | ((bArr[i3 + 7] & 255) << 56);
            bVar.f();
            bVar.f();
            bVar.f();
            int n5 = bVar.n();
            this.c = n5;
            this.d = n5 + 27;
            bVar.u();
            gVar.d(bVar.f187a, 0, this.c, false);
            for (int i5 = 0; i5 < this.c; i5++) {
                int n6 = bVar.n();
                this.f3918f[i5] = n6;
                this.f3917e += n6;
            }
            return true;
        }
    }
}

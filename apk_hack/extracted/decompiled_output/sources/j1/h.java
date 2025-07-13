package j1;

import android.net.Uri;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements e2.i {

    /* renamed from: a  reason: collision with root package name */
    public final e2.i f2416a;
    public final int b;
    public final z c;
    public final byte[] d;

    /* renamed from: e  reason: collision with root package name */
    public int f2417e;

    public h(e2.i iVar, int i3, z zVar) {
        boolean z3;
        if (i3 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        this.f2416a = iVar;
        this.b = i3;
        this.c = zVar;
        this.d = new byte[1];
        this.f2417e = i3;
    }

    @Override // e2.i
    public final void addTransferListener(e2.m0 m0Var) {
        this.f2416a.addTransferListener(m0Var);
    }

    @Override // e2.i
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // e2.i
    public final Map getResponseHeaders() {
        return this.f2416a.getResponseHeaders();
    }

    @Override // e2.i
    public final Uri getUri() {
        return this.f2416a.getUri();
    }

    @Override // e2.i
    public final long open(e2.l lVar) {
        throw new UnsupportedOperationException();
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        long max;
        int i6 = this.f2417e;
        e2.i iVar = this.f2416a;
        if (i6 == 0) {
            byte[] bArr2 = this.d;
            int i7 = 0;
            if (iVar.read(bArr2, 0, 1) != -1) {
                int i8 = (bArr2[0] & 255) << 4;
                if (i8 != 0) {
                    byte[] bArr3 = new byte[i8];
                    int i9 = i8;
                    while (i9 > 0) {
                        int read = iVar.read(bArr3, i7, i9);
                        if (read != -1) {
                            i7 += read;
                            i9 -= read;
                        }
                    }
                    while (i8 > 0 && bArr3[i8 - 1] == 0) {
                        i8--;
                    }
                    if (i8 > 0) {
                        c0.b bVar = new c0.b(bArr3, i8);
                        z zVar = this.c;
                        if (!zVar.f2479m) {
                            max = zVar.f2475i;
                        } else {
                            max = Math.max(zVar.f2480n.n(), zVar.f2475i);
                        }
                        long j2 = max;
                        int a5 = bVar.a();
                        i0 i0Var = zVar.f2478l;
                        i0Var.getClass();
                        i0Var.b(a5, bVar);
                        i0Var.c(j2, 1, a5, 0, null);
                        zVar.f2479m = true;
                    }
                }
                this.f2417e = this.b;
            }
            return -1;
        }
        int read2 = iVar.read(bArr, i3, Math.min(this.f2417e, i5));
        if (read2 != -1) {
            this.f2417e -= read2;
        }
        return read2;
    }
}

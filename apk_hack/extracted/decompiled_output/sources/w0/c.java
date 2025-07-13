package w0;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends i {

    /* renamed from: n  reason: collision with root package name */
    public g2.i f3911n;

    /* renamed from: o  reason: collision with root package name */
    public c0.j f3912o;

    @Override // w0.i
    public final long b(c0.b bVar) {
        byte[] bArr = bVar.f187a;
        if (bArr[0] == -1) {
            int i3 = (bArr[2] & 255) >> 4;
            if (i3 == 6 || i3 == 7) {
                bVar.z(4);
                bVar.t();
            }
            int j2 = com.bumptech.glide.c.j(i3, bVar);
            bVar.y(0);
            return j2;
        }
        return -1L;
    }

    @Override // w0.i
    public final boolean c(c0.b bVar, long j2, c1.b bVar2) {
        byte[] bArr = bVar.f187a;
        if (this.f3911n == null) {
            this.f3911n = new g2.i(bArr, 17);
            bVar2.b = this.f3911n.d(Arrays.copyOfRange(bArr, 9, bVar.c), null);
            return true;
        }
        byte b = bArr[0];
        if ((b & Byte.MAX_VALUE) == 3) {
            this.f3912o = new c0.j(this);
            c1.b k5 = com.bumptech.glide.d.k(bVar);
            g2.i iVar = this.f3911n;
            this.f3911n = new g2.i(iVar.f1924a, iVar.b, iVar.c, iVar.d, iVar.f1925e, iVar.f1927g, iVar.f1928h, iVar.f1930j, k5, iVar.f1932l);
            return true;
        } else if (b == -1) {
            c0.j jVar = this.f3912o;
            if (jVar != null) {
                jVar.f195a = j2;
                bVar2.c = jVar;
            }
            return false;
        } else {
            return true;
        }
    }

    @Override // w0.i
    public final void d(boolean z3) {
        super.d(z3);
        if (z3) {
            this.f3911n = null;
            this.f3912o = null;
        }
    }
}

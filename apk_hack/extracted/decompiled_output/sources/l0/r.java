package l0;

import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r extends q {

    /* renamed from: i  reason: collision with root package name */
    public int[] f2566i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f2567j;

    @Override // l0.f
    public final void e(ByteBuffer byteBuffer) {
        int[] iArr = this.f2567j;
        iArr.getClass();
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer j2 = j(((limit - position) / this.b.d) * this.c.d);
        while (position < limit) {
            for (int i3 : iArr) {
                j2.putShort(byteBuffer.getShort((i3 * 2) + position));
            }
            position += this.b.d;
        }
        byteBuffer.position(limit);
        j2.flip();
    }

    @Override // l0.q
    public final d f(d dVar) {
        boolean z3;
        boolean z5;
        int[] iArr = this.f2566i;
        if (iArr == null) {
            return d.f2533e;
        }
        if (dVar.c == 2) {
            int length = iArr.length;
            int i3 = dVar.b;
            if (i3 != length) {
                z3 = true;
            } else {
                z3 = false;
            }
            for (int i5 = 0; i5 < iArr.length; i5++) {
                int i6 = iArr[i5];
                if (i6 < i3) {
                    if (i6 != i5) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z3 |= z5;
                } else {
                    throw new e(dVar);
                }
            }
            if (z3) {
                return new d(dVar.f2534a, iArr.length, 2);
            }
            return d.f2533e;
        }
        throw new e(dVar);
    }

    @Override // l0.q
    public final void g() {
        this.f2567j = this.f2566i;
    }

    @Override // l0.q
    public final void i() {
        this.f2567j = null;
        this.f2566i = null;
    }
}

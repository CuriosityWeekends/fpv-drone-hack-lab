package l0;

import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class v extends q {

    /* renamed from: i  reason: collision with root package name */
    public static final int f2597i = Float.floatToIntBits(Float.NaN);

    @Override // l0.f
    public final void e(ByteBuffer byteBuffer) {
        boolean z3;
        g2.b.h(g2.w.u(this.b.c));
        if (this.b.c == 805306368) {
            z3 = true;
        } else {
            z3 = false;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - position;
        if (!z3) {
            i3 = (i3 / 3) * 4;
        }
        ByteBuffer j2 = j(i3);
        int i5 = f2597i;
        if (z3) {
            while (position < limit) {
                int floatToIntBits = Float.floatToIntBits((float) (((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24)) * 4.656612875245797E-10d));
                if (floatToIntBits == i5) {
                    floatToIntBits = Float.floatToIntBits(0.0f);
                }
                j2.putInt(floatToIntBits);
                position += 4;
            }
        } else {
            while (position < limit) {
                int floatToIntBits2 = Float.floatToIntBits((float) ((((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24)) * 4.656612875245797E-10d));
                if (floatToIntBits2 == i5) {
                    floatToIntBits2 = Float.floatToIntBits(0.0f);
                }
                j2.putInt(floatToIntBits2);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        j2.flip();
    }

    @Override // l0.q
    public final d f(d dVar) {
        if (g2.w.u(dVar.c)) {
            if (g2.w.u(dVar.c)) {
                return new d(dVar.f2534a, dVar.b, 4);
            }
            return d.f2533e;
        }
        throw new e(dVar);
    }
}

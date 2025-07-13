package p0;

import com.google.android.exoplayer2.Format;
import java.io.EOFException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements u {
    @Override // p0.u
    public final int a(g gVar, int i3, boolean z3) {
        int min = Math.min(gVar.f3112g, i3);
        gVar.i(min);
        if (min == 0) {
            byte[] bArr = gVar.f3109a;
            min = gVar.f(bArr, 0, true, Math.min(i3, bArr.length), 0);
        }
        if (min != -1) {
            gVar.d += min;
        }
        if (min == -1) {
            if (z3) {
                return -1;
            }
            throw new EOFException();
        }
        return min;
    }

    @Override // p0.u
    public final void b(int i3, c0.b bVar) {
        bVar.z(i3);
    }

    @Override // p0.u
    public final void d(Format format) {
    }

    @Override // p0.u
    public final void c(long j2, int i3, int i5, int i6, t tVar) {
    }
}

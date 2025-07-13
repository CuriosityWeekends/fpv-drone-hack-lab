package t0;

import java.util.ArrayDeque;
import p0.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3573a = new byte[8];
    public final ArrayDeque b = new ArrayDeque();
    public final f c = new f();
    public b3.e d;

    /* renamed from: e  reason: collision with root package name */
    public int f3574e;

    /* renamed from: f  reason: collision with root package name */
    public int f3575f;

    /* renamed from: g  reason: collision with root package name */
    public long f3576g;

    public final long a(g gVar, int i3) {
        byte[] bArr = this.f3573a;
        gVar.g(bArr, 0, i3, false);
        long j2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            j2 = (j2 << 8) | (bArr[i5] & 255);
        }
        return j2;
    }
}

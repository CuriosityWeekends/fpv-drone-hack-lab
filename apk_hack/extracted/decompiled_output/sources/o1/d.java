package o1;

import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends l1.b {

    /* renamed from: i  reason: collision with root package name */
    public byte[] f2957i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f2958j;

    /* renamed from: k  reason: collision with root package name */
    public byte[] f2959k;

    @Override // e2.c0
    public final void a() {
        try {
            this.f2641h.open(this.f2637a);
            int i3 = 0;
            int i5 = 0;
            while (i3 != -1 && !this.f2958j) {
                byte[] bArr = this.f2957i;
                if (bArr == null) {
                    this.f2957i = new byte[16384];
                } else if (bArr.length < i5 + 16384) {
                    this.f2957i = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                i3 = this.f2641h.read(this.f2957i, i5, 16384);
                if (i3 != -1) {
                    i5 += i3;
                }
            }
            if (!this.f2958j) {
                this.f2959k = Arrays.copyOf(this.f2957i, i5);
            }
            w.f(this.f2641h);
        } catch (Throwable th) {
            w.f(this.f2641h);
            throw th;
        }
    }

    @Override // e2.c0
    public final void b() {
        this.f2958j = true;
    }
}

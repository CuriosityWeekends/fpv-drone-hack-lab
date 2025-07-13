package e2;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m {
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f1702e;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1701a = true;
    public final int b = 65536;

    /* renamed from: f  reason: collision with root package name */
    public int f1703f = 0;

    /* renamed from: g  reason: collision with root package name */
    public a[] f1704g = new a[100];
    public final a[] c = new a[1];

    public final synchronized void a(a[] aVarArr) {
        try {
            int i3 = this.f1703f;
            int length = aVarArr.length + i3;
            a[] aVarArr2 = this.f1704g;
            if (length >= aVarArr2.length) {
                this.f1704g = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i3 + aVarArr.length));
            }
            for (a aVar : aVarArr) {
                a[] aVarArr3 = this.f1704g;
                int i5 = this.f1703f;
                this.f1703f = i5 + 1;
                aVarArr3[i5] = aVar;
            }
            this.f1702e -= aVarArr.length;
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(int i3) {
        boolean z3;
        if (i3 < this.d) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.d = i3;
        if (z3) {
            c();
        }
    }

    public final synchronized void c() {
        int max = Math.max(0, g2.w.e(this.d, this.b) - this.f1702e);
        int i3 = this.f1703f;
        if (max >= i3) {
            return;
        }
        Arrays.fill(this.f1704g, max, i3, (Object) null);
        this.f1703f = max;
    }
}

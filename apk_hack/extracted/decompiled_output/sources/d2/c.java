package d2;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f1604a;
    public int b;
    public Object c;
    public Object d;

    public c() {
        this.c = new long[10];
        this.d = new Object[10];
    }

    public synchronized void a(long j2, Object obj) {
        int i3 = this.b;
        if (i3 > 0) {
            if (j2 <= ((long[]) this.c)[((this.f1604a + i3) - 1) % ((Object[]) this.d).length]) {
                b();
            }
        }
        c();
        int i5 = this.f1604a;
        int i6 = this.b;
        Object[] objArr = (Object[]) this.d;
        int length = (i5 + i6) % objArr.length;
        ((long[]) this.c)[length] = j2;
        objArr[length] = obj;
        this.b = i6 + 1;
    }

    public synchronized void b() {
        this.f1604a = 0;
        this.b = 0;
        Arrays.fill((Object[]) this.d, (Object) null);
    }

    public void c() {
        int length = ((Object[]) this.d).length;
        if (this.b < length) {
            return;
        }
        int i3 = length * 2;
        long[] jArr = new long[i3];
        Object[] objArr = new Object[i3];
        int i5 = this.f1604a;
        int i6 = length - i5;
        System.arraycopy((long[]) this.c, i5, jArr, 0, i6);
        System.arraycopy((Object[]) this.d, this.f1604a, objArr, 0, i6);
        int i7 = this.f1604a;
        if (i7 > 0) {
            System.arraycopy((long[]) this.c, 0, jArr, i6, i7);
            System.arraycopy((Object[]) this.d, 0, objArr, i6, this.f1604a);
        }
        this.c = jArr;
        this.d = objArr;
        this.f1604a = 0;
    }

    public Object d(long j2, boolean z3) {
        long j5 = Long.MAX_VALUE;
        Object obj = null;
        while (true) {
            int i3 = this.b;
            if (i3 <= 0) {
                break;
            }
            int i5 = this.f1604a;
            long j6 = j2 - ((long[]) this.c)[i5];
            if (j6 < 0 && (z3 || (-j6) >= j5)) {
                break;
            }
            Object[] objArr = (Object[]) this.d;
            obj = objArr[i5];
            objArr[i5] = null;
            this.f1604a = (i5 + 1) % objArr.length;
            this.b = i3 - 1;
            j5 = j6;
        }
        return obj;
    }

    public synchronized Object e(long j2) {
        return d(j2, true);
    }

    public c(int i3, float[] fArr, float[] fArr2, int i5) {
        this.f1604a = i3;
        g2.b.e(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
        this.c = fArr;
        this.d = fArr2;
        this.b = i5;
    }

    public c(c cVar) {
        float[] fArr = (float[]) cVar.c;
        this.f1604a = fArr.length / 3;
        this.c = g2.b.l(fArr);
        this.d = g2.b.l((float[]) cVar.d);
        int i3 = cVar.b;
        if (i3 == 1) {
            this.b = 5;
        } else if (i3 != 2) {
            this.b = 4;
        } else {
            this.b = 6;
        }
    }
}

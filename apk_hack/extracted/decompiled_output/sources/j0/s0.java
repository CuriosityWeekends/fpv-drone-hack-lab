package j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    public Object f2305a;
    public Object b;
    public int c;
    public long d;

    /* renamed from: e  reason: collision with root package name */
    public long f2306e;

    /* renamed from: f  reason: collision with root package name */
    public k1.b f2307f = k1.b.f2501e;

    public final int a(long j2) {
        long[] jArr;
        k1.b bVar = this.f2307f;
        long j5 = this.d;
        bVar.getClass();
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        if (j5 != -9223372036854775807L && j2 >= j5) {
            return -1;
        }
        int i3 = 0;
        while (true) {
            jArr = bVar.b;
            if (i3 >= jArr.length) {
                break;
            }
            long j6 = jArr[i3];
            if (j6 == Long.MIN_VALUE) {
                break;
            } else if (j2 < j6) {
                bVar.c[i3].getClass();
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= jArr.length) {
            return -1;
        }
        return i3;
    }

    public final int b(long j2) {
        k1.b bVar = this.f2307f;
        long[] jArr = bVar.b;
        int length = jArr.length - 1;
        while (length >= 0 && j2 != Long.MIN_VALUE) {
            long j5 = jArr[length];
            if (j5 == Long.MIN_VALUE) {
                long j6 = bVar.d;
                if (j6 != -9223372036854775807L && j2 >= j6) {
                    break;
                }
                length--;
            } else if (j2 >= j5) {
                break;
            } else {
                length--;
            }
        }
        if (length >= 0) {
            bVar.c[length].getClass();
            return length;
        }
        return -1;
    }
}

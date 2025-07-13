package r0;

import p0.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final p0.a f3370a;
    public final e b;
    public p0.b c;
    public final int d;

    public b(p0.c cVar, e eVar, long j2, long j5, long j6, long j7, long j8, int i3) {
        this.b = eVar;
        this.d = i3;
        this.f3370a = new p0.a(cVar, j2, j5, j6, j7, j8);
    }

    public static int a(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e0, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e3, code lost:
        if (r9 != r5) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e5, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e7, code lost:
        r1.f3114a = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ea, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(p0.g r31, p0.m r32) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.b.b(p0.g, p0.m):int");
    }

    public final void c(long j2) {
        p0.b bVar = this.c;
        if (bVar != null && bVar.f3100a == j2) {
            return;
        }
        p0.a aVar = this.f3370a;
        this.c = new p0.b(j2, aVar.f3096a.f(j2), aVar.d, aVar.f3097e, aVar.f3098f, aVar.f3099g);
    }
}

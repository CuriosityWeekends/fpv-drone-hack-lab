package u1;

import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends s1.c {

    /* renamed from: n  reason: collision with root package name */
    public final j f3746n;

    public a(List list) {
        byte[] bArr = (byte[]) list.get(0);
        int length = bArr.length;
        this.f3746n = new j(((bArr[0] & 255) << 8) | (bArr[1] & 255), (bArr[3] & 255) | ((bArr[2] & 255) << 8));
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0271, code lost:
        if ((r4.b + 1) == r2.f3774g.getHeight()) goto L104;
     */
    @Override // s1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s1.e e(byte[] r30, int r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 1048
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.a.e(byte[], int, boolean):s1.e");
    }
}

package v0;

import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final u f3803a;
    public p d;

    /* renamed from: e  reason: collision with root package name */
    public h f3804e;

    /* renamed from: f  reason: collision with root package name */
    public int f3805f;

    /* renamed from: g  reason: collision with root package name */
    public int f3806g;

    /* renamed from: h  reason: collision with root package name */
    public int f3807h;

    /* renamed from: i  reason: collision with root package name */
    public int f3808i;
    public final r b = new Object();
    public final c0.b c = new c0.b();

    /* renamed from: j  reason: collision with root package name */
    public final c0.b f3809j = new c0.b(1);

    /* renamed from: k  reason: collision with root package name */
    public final c0.b f3810k = new c0.b();

    /* JADX WARN: Type inference failed for: r2v1, types: [v0.r, java.lang.Object] */
    public j(u uVar) {
        this.f3803a = uVar;
    }

    public final q a() {
        r rVar = this.b;
        int i3 = rVar.f3859a.f3801a;
        q qVar = rVar.f3869n;
        if (qVar == null) {
            q[] qVarArr = this.d.f3856k;
            if (qVarArr == null) {
                qVar = null;
            } else {
                qVar = qVarArr[i3];
            }
        }
        if (qVar == null || !qVar.f3857a) {
            return null;
        }
        return qVar;
    }

    public final void b(p pVar, h hVar) {
        pVar.getClass();
        this.d = pVar;
        hVar.getClass();
        this.f3804e = hVar;
        this.f3803a.d(pVar.f3851f);
        e();
    }

    public final boolean c() {
        this.f3805f++;
        int i3 = this.f3806g + 1;
        this.f3806g = i3;
        int[] iArr = this.b.f3862g;
        int i5 = this.f3807h;
        if (i3 != iArr[i5]) {
            return true;
        }
        this.f3807h = i5 + 1;
        this.f3806g = 0;
        return false;
    }

    public final int d(int i3, int i5) {
        c0.b bVar;
        boolean z3;
        boolean z5;
        int i6;
        q a5 = a();
        if (a5 == null) {
            return 0;
        }
        r rVar = this.b;
        int i7 = a5.d;
        if (i7 != 0) {
            bVar = rVar.f3871p;
        } else {
            byte[] bArr = a5.f3858e;
            int length = bArr.length;
            c0.b bVar2 = this.f3810k;
            bVar2.w(bArr, length);
            i7 = bArr.length;
            bVar = bVar2;
        }
        int i8 = this.f3805f;
        if (rVar.f3867l && rVar.f3868m[i8]) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 && i5 == 0) {
            z5 = false;
        } else {
            z5 = true;
        }
        c0.b bVar3 = this.f3809j;
        byte[] bArr2 = bVar3.f187a;
        if (z5) {
            i6 = 128;
        } else {
            i6 = 0;
        }
        bArr2[0] = (byte) (i6 | i7);
        bVar3.y(0);
        u uVar = this.f3803a;
        uVar.b(1, bVar3);
        uVar.b(i7, bVar);
        if (!z5) {
            return i7 + 1;
        }
        c0.b bVar4 = this.c;
        if (!z3) {
            bVar4.v(8);
            byte[] bArr3 = bVar4.f187a;
            bArr3[0] = 0;
            bArr3[1] = 1;
            bArr3[2] = (byte) 0;
            bArr3[3] = (byte) (i5 & 255);
            bArr3[4] = (byte) ((i3 >> 24) & 255);
            bArr3[5] = (byte) ((i3 >> 16) & 255);
            bArr3[6] = (byte) ((i3 >> 8) & 255);
            bArr3[7] = (byte) (i3 & 255);
            uVar.b(8, bVar4);
            return i7 + 9;
        }
        c0.b bVar5 = rVar.f3871p;
        int s = bVar5.s();
        bVar5.z(-2);
        int i9 = (s * 6) + 2;
        if (i5 != 0) {
            bVar4.v(i9);
            bVar4.b(bVar5.f187a, 0, i9);
            bVar5.z(i9);
            byte[] bArr4 = bVar4.f187a;
            int i10 = (((bArr4[2] & 255) << 8) | (bArr4[3] & 255)) + i5;
            bArr4[2] = (byte) ((i10 >> 8) & 255);
            bArr4[3] = (byte) (i10 & 255);
        } else {
            bVar4 = bVar5;
        }
        uVar.b(i9, bVar4);
        return i7 + 1 + i9;
    }

    public final void e() {
        r rVar = this.b;
        rVar.d = 0;
        rVar.f3872r = 0L;
        rVar.f3867l = false;
        rVar.q = false;
        rVar.f3869n = null;
        this.f3805f = 0;
        this.f3807h = 0;
        this.f3806g = 0;
        this.f3808i = 0;
    }
}

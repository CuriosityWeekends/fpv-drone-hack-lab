package r0;

import g2.i;
import g2.u;
import g2.w;
import p0.e;
import p0.g;
import p0.m;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3369a;
    public int b;
    public final Object c;
    public Object d;

    public a() {
        this.f3369a = 1;
        Object[] objArr = new Object[5];
        this.c = objArr;
        this.d = objArr;
    }

    private final /* synthetic */ void c() {
    }

    public void a(Object obj) {
        int i3 = this.b;
        if (i3 == 4) {
            Object[] objArr = new Object[5];
            ((Object[]) this.d)[4] = objArr;
            this.d = objArr;
            i3 = 0;
        }
        ((Object[]) this.d)[i3] = obj;
        this.b = i3 + 1;
    }

    public long b(g gVar) {
        long j2;
        long j5;
        m mVar;
        i iVar;
        boolean a5;
        while (true) {
            long c = gVar.c();
            j2 = gVar.c;
            j5 = j2 - 6;
            mVar = (m) this.d;
            iVar = (i) this.c;
            if (c >= j5) {
                break;
            }
            long c5 = gVar.c();
            byte[] bArr = new byte[2];
            gVar.d(bArr, 0, 2, false);
            int i3 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
            int i5 = this.b;
            if (i3 != i5) {
                gVar.f3111f = 0;
                gVar.a((int) (c5 - gVar.d), false);
                a5 = false;
            } else {
                c0.b bVar = new c0.b(16);
                System.arraycopy(bArr, 0, bVar.f187a, 0, 2);
                bVar.x(j4.b.r(gVar, bVar.f187a, 2, 14));
                gVar.f3111f = 0;
                gVar.a((int) (c5 - gVar.d), false);
                a5 = com.bumptech.glide.c.a(bVar, iVar, i5, mVar);
            }
            if (a5) {
                break;
            }
            gVar.a(1, false);
        }
        if (gVar.c() >= j5) {
            gVar.a((int) (j2 - gVar.c()), false);
            return iVar.f1930j;
        }
        return mVar.f3114a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    @Override // p0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p0.d g(p0.g r21, long r22) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.a.g(p0.g, long):p0.d");
    }

    @Override // p0.e
    public void j() {
        switch (this.f3369a) {
            case 0:
                return;
            default:
                byte[] bArr = w.f1962f;
                c0.b bVar = (c0.b) this.d;
                bVar.getClass();
                bVar.w(bArr, bArr.length);
                return;
        }
    }

    public a(i iVar, int i3) {
        this.f3369a = 0;
        this.c = iVar;
        this.b = i3;
        this.d = new Object();
    }

    public a(int i3, u uVar) {
        this.f3369a = 2;
        this.b = i3;
        this.c = uVar;
        this.d = new c0.b();
    }
}

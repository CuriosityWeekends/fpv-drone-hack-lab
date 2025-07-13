package s0;

import androidx.recyclerview.widget.ItemTouchHelper;
import p0.g;
import p0.j;
import p0.k;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final c0.b f3460a = new c0.b(4);
    public final c0.b b = new c0.b(9);
    public final c0.b c = new c0.b(11);
    public final c0.b d = new c0.b();

    /* renamed from: e  reason: collision with root package name */
    public final c f3461e;

    /* renamed from: f  reason: collision with root package name */
    public k f3462f;

    /* renamed from: g  reason: collision with root package name */
    public int f3463g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3464h;

    /* renamed from: i  reason: collision with root package name */
    public long f3465i;

    /* renamed from: j  reason: collision with root package name */
    public int f3466j;

    /* renamed from: k  reason: collision with root package name */
    public int f3467k;

    /* renamed from: l  reason: collision with root package name */
    public int f3468l;

    /* renamed from: m  reason: collision with root package name */
    public long f3469m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3470n;

    /* renamed from: o  reason: collision with root package name */
    public a f3471o;

    /* renamed from: p  reason: collision with root package name */
    public d f3472p;

    /* JADX WARN: Type inference failed for: r0v4, types: [s0.c, j.a] */
    public b() {
        ?? aVar = new j.a(new Object());
        aVar.b = -9223372036854775807L;
        this.f3461e = aVar;
        this.f3463g = 1;
    }

    public final c0.b a(g gVar) {
        int i3 = this.f3468l;
        c0.b bVar = this.d;
        byte[] bArr = bVar.f187a;
        if (i3 > bArr.length) {
            bVar.w(new byte[Math.max(bArr.length * 2, i3)], 0);
        } else {
            bVar.y(0);
        }
        bVar.x(this.f3468l);
        gVar.g(bVar.f187a, 0, this.f3468l, false);
        return bVar;
    }

    @Override // p0.j
    public final void b(k kVar) {
        this.f3462f = kVar;
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        this.f3463g = 1;
        this.f3464h = false;
        this.f3466j = 0;
    }

    @Override // p0.j
    public final boolean f(g gVar) {
        c0.b bVar = this.f3460a;
        gVar.d(bVar.f187a, 0, 3, false);
        bVar.y(0);
        if (bVar.p() != 4607062) {
            return false;
        }
        gVar.d(bVar.f187a, 0, 2, false);
        bVar.y(0);
        if ((bVar.s() & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        gVar.d(bVar.f187a, 0, 4, false);
        bVar.y(0);
        int c = bVar.c();
        gVar.f3111f = 0;
        gVar.a(c, false);
        gVar.d(bVar.f187a, 0, 4, false);
        bVar.y(0);
        if (bVar.c() != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v7, types: [s0.a, j.a] */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(p0.g r17, p0.m r18) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.b.h(p0.g, p0.m):int");
    }
}

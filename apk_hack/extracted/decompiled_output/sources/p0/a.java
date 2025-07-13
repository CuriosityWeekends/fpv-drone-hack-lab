package p0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements r {

    /* renamed from: a  reason: collision with root package name */
    public final c f3096a;
    public final long b;
    public final long c = 0;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3097e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3098f;

    /* renamed from: g  reason: collision with root package name */
    public final long f3099g;

    public a(c cVar, long j2, long j5, long j6, long j7, long j8) {
        this.f3096a = cVar;
        this.b = j2;
        this.d = j5;
        this.f3097e = j6;
        this.f3098f = j7;
        this.f3099g = j8;
    }

    @Override // p0.r
    public final boolean e() {
        return true;
    }

    @Override // p0.r
    public final q g(long j2) {
        s sVar = new s(j2, b.a(this.f3096a.f(j2), this.c, this.d, this.f3097e, this.f3098f, this.f3099g));
        return new q(sVar, sVar);
    }

    @Override // p0.r
    public final long i() {
        return this.b;
    }
}

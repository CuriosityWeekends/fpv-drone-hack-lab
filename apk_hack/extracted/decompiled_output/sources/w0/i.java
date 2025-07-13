package w0;

import p0.k;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public final e f3922a = new e();
    public u b;
    public k c;
    public g d;

    /* renamed from: e  reason: collision with root package name */
    public long f3923e;

    /* renamed from: f  reason: collision with root package name */
    public long f3924f;

    /* renamed from: g  reason: collision with root package name */
    public long f3925g;

    /* renamed from: h  reason: collision with root package name */
    public int f3926h;

    /* renamed from: i  reason: collision with root package name */
    public int f3927i;

    /* renamed from: j  reason: collision with root package name */
    public c1.b f3928j;

    /* renamed from: k  reason: collision with root package name */
    public long f3929k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3930l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3931m;

    public void a(long j2) {
        this.f3925g = j2;
    }

    public abstract long b(c0.b bVar);

    public abstract boolean c(c0.b bVar, long j2, c1.b bVar2);

    public void d(boolean z3) {
        if (z3) {
            this.f3928j = new c1.b(20, false);
            this.f3924f = 0L;
            this.f3926h = 0;
        } else {
            this.f3926h = 1;
        }
        this.f3923e = -1L;
        this.f3925g = 0L;
    }
}

package j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k implements b0 {

    /* renamed from: a  reason: collision with root package name */
    public final e2.m f2257a;
    public final long b;
    public final long c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2258e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2259f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2260g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f2261h;

    /* renamed from: i  reason: collision with root package name */
    public final long f2262i;

    /* renamed from: j  reason: collision with root package name */
    public int f2263j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2264k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2265l;

    public k() {
        e2.m mVar = new e2.m();
        a("bufferForPlaybackMs", "0", 2500, 0);
        a("bufferForPlaybackAfterRebufferMs", "0", 5000, 0);
        a("minBufferAudioMs", "bufferForPlaybackMs", 15000, 2500);
        a("minBufferVideoMs", "bufferForPlaybackMs", 50000, 2500);
        a("minBufferAudioMs", "bufferForPlaybackAfterRebufferMs", 15000, 5000);
        a("minBufferVideoMs", "bufferForPlaybackAfterRebufferMs", 50000, 5000);
        a("maxBufferMs", "minBufferAudioMs", 50000, 15000);
        a("maxBufferMs", "minBufferVideoMs", 50000, 50000);
        a("backBufferDurationMs", "0", 0, 0);
        this.f2257a = mVar;
        this.b = i.a(15000);
        long j2 = 50000;
        this.c = i.a(j2);
        this.d = i.a(j2);
        this.f2258e = i.a(2500);
        this.f2259f = i.a(5000);
        this.f2260g = -1;
        this.f2261h = true;
        this.f2262i = i.a(0);
    }

    public static void a(String str, String str2, int i3, int i5) {
        boolean z3;
        if (i3 >= i5) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.d(str + " cannot be less than " + str2, z3);
    }

    public final void b(boolean z3) {
        this.f2263j = 0;
        this.f2264k = false;
        if (z3) {
            e2.m mVar = this.f2257a;
            synchronized (mVar) {
                if (mVar.f1701a) {
                    mVar.b(0);
                }
            }
        }
    }
}

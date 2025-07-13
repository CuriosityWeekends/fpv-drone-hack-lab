package p;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m {
    public static final m b = new m(2);
    public static final m c = new m(0);
    public static final m d;

    /* renamed from: e  reason: collision with root package name */
    public static final m f3068e;

    /* renamed from: f  reason: collision with root package name */
    public static final m f3069f;

    /* renamed from: g  reason: collision with root package name */
    public static final g.g f3070g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f3071h;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3072a;

    static {
        m mVar = new m(1);
        d = mVar;
        f3068e = new m(3);
        f3069f = mVar;
        f3070g = g.g.a(mVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        f3071h = true;
    }

    public /* synthetic */ m(int i3) {
        this.f3072a = i3;
    }

    public final int a(int i3, int i5, int i6, int i7) {
        switch (this.f3072a) {
            case 0:
                if (b(i3, i5, i6, i7) == 1.0f) {
                    return 2;
                }
                return b.a(i3, i5, i6, i7);
            case 1:
                return 2;
            case 2:
                if (f3071h) {
                    return 2;
                }
                return 1;
            default:
                return 2;
        }
    }

    public final float b(int i3, int i5, int i6, int i7) {
        switch (this.f3072a) {
            case 0:
                return Math.min(1.0f, b.b(i3, i5, i6, i7));
            case 1:
                return Math.max(i6 / i3, i7 / i5);
            case 2:
                if (f3071h) {
                    return Math.min(i6 / i3, i7 / i5);
                }
                int max = Math.max(i5 / i7, i3 / i6);
                if (max == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(max);
            default:
                return 1.0f;
        }
    }
}

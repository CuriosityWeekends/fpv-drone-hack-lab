package f3;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m implements Runnable {
    public final float b;
    public final float c;

    /* renamed from: e  reason: collision with root package name */
    public final float f1869e;

    /* renamed from: f  reason: collision with root package name */
    public final float f1870f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f1871g;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1868a = 0;
    public final long d = System.currentTimeMillis();

    public m(i0.i iVar, float f4, float f5, float f6, float f7) {
        this.f1871g = iVar;
        this.b = f6;
        this.c = f7;
        this.f1869e = f4;
        this.f1870f = f5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1868a) {
            case 0:
                o oVar = (o) this.f1871g;
                float interpolation = oVar.f1874a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.d)) * 1.0f) / oVar.b));
                float f4 = this.f1870f;
                float f5 = this.f1869e;
                oVar.B.E(a1.i.b(f4, f5, interpolation, f5) / oVar.d(), this.b, this.c);
                if (interpolation < 1.0f) {
                    oVar.f1878h.postOnAnimation(this);
                    return;
                }
                return;
            default:
                i0.i iVar = (i0.i) this.f1871g;
                float interpolation2 = iVar.f2158a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.d)) * 1.0f) / iVar.b));
                float f6 = this.f1870f;
                float f7 = this.f1869e;
                iVar.w.E(a1.i.b(f6, f7, interpolation2, f7) / iVar.d(), this.b, this.c);
                if (interpolation2 < 1.0f) {
                    iVar.f2162h.postOnAnimation(this);
                    return;
                }
                return;
        }
    }

    public m(o oVar, float f4, float f5, float f6, float f7) {
        this.f1871g = oVar;
        this.b = f6;
        this.c = f7;
        this.f1869e = f4;
        this.f1870f = f5;
    }
}

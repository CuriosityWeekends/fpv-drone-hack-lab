package h2;

import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2035a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f2036e;

    public /* synthetic */ r(Object obj, String str, long j2, long j5, int i3) {
        this.f2035a = i3;
        this.f2036e = obj;
        this.b = str;
        this.c = j2;
        this.d = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f2036e;
        int i3 = this.f2035a;
        c1.b bVar = (c1.b) obj;
        bVar.getClass();
        switch (i3) {
            case 0:
                int i5 = w.f1960a;
                ((s) bVar.c).onVideoDecoderInitialized(this.b, this.c, this.d);
                return;
            default:
                int i6 = w.f1960a;
                ((l0.i) bVar.c).onAudioDecoderInitialized(this.b, this.c, this.d);
                return;
        }
    }
}

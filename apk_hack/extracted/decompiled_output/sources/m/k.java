package m;

import android.content.Context;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2744a;
    public final Context b;

    public /* synthetic */ k(Context context, int i3) {
        this.f2744a = i3;
        this.b = context;
    }

    @Override // m.r
    public final q n(y yVar) {
        switch (this.f2744a) {
            case 0:
                return new m(this.b, 0);
            case 1:
                return new m(this.b, 1);
            default:
                return new m(this.b, 2);
        }
    }
}

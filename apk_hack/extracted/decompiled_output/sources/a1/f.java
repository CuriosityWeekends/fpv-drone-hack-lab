package a1;

import g2.w;
import j0.j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class f implements n, j0.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f35a;

    public /* synthetic */ f(int i3) {
        this.f35a = i3;
    }

    @Override // j0.g
    public void a(j0 j0Var) {
        j0Var.onPositionDiscontinuity(1);
    }

    @Override // a1.n
    public int b(Object obj) {
        a aVar = (a) obj;
        switch (this.f35a) {
            case 0:
                String str = aVar.f1a;
                if (!str.startsWith("OMX.google") && !str.startsWith("c2.android")) {
                    if (w.f1960a < 26 && str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                        return -1;
                    }
                    return 0;
                }
                return 1;
            default:
                return aVar.f1a.startsWith("OMX.google") ? 1 : 0;
        }
    }

    public boolean c(int i3, int i5, int i6, int i7, int i8) {
        switch (this.f35a) {
            case 2:
                return false;
            default:
                return (i5 == 67 && i6 == 79 && i7 == 77 && (i8 == 77 || i3 == 2)) || (i5 == 77 && i6 == 76 && i7 == 76 && (i8 == 84 || i3 == 2));
        }
    }
}

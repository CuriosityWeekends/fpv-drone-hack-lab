package m;

import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c0 implements q {
    public static final c0 b = new c0(0);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2732a;

    public /* synthetic */ c0(int i3) {
        this.f2732a = i3;
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, g.h hVar) {
        switch (this.f2732a) {
            case 0:
                return new p(new b0.b(obj), new d(1, obj));
            case 1:
                File file = (File) obj;
                return new p(new b0.b(file), new d(0, file));
            default:
                return null;
        }
    }

    @Override // m.q
    public final boolean b(Object obj) {
        switch (this.f2732a) {
            case 0:
                return true;
            case 1:
                File file = (File) obj;
                return true;
            default:
                return false;
        }
    }
}

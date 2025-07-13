package m;

import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2731a;
    public final Object b;

    public /* synthetic */ c(int i3, Object obj) {
        this.f2731a = i3;
        this.b = obj;
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, g.h hVar) {
        switch (this.f2731a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return new p(new b0.b(bArr), new l(1, bArr, (b0) this.b));
            case 1:
                return new p(new b0.b(obj), new h.b(1, obj.toString(), (b0) this.b));
            default:
                File file = (File) obj;
                return new p(new b0.b(file), new h.b(2, file, (b0) this.b));
        }
    }

    @Override // m.q
    public final boolean b(Object obj) {
        switch (this.f2731a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return true;
            case 1:
                return obj.toString().startsWith("data:image");
            default:
                File file = (File) obj;
                return true;
        }
    }
}

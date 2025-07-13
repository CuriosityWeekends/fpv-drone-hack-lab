package p;

import android.graphics.Bitmap;
import i.g0;
import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class z implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3095a = 0;
    public final Object b;

    public z(byte[] bArr) {
        c0.g.c(bArr, "Argument must not be null");
        this.b = bArr;
    }

    @Override // i.g0
    public final Class a() {
        switch (this.f3095a) {
            case 0:
                return Bitmap.class;
            case 1:
                return byte[].class;
            default:
                return this.b.getClass();
        }
    }

    @Override // i.g0
    public final Object get() {
        switch (this.f3095a) {
            case 0:
                return (Bitmap) this.b;
            case 1:
                return (byte[]) this.b;
            default:
                return this.b;
        }
    }

    @Override // i.g0
    public final int getSize() {
        switch (this.f3095a) {
            case 0:
                return c0.n.c((Bitmap) this.b);
            case 1:
                return ((byte[]) this.b).length;
            default:
                return 1;
        }
    }

    @Override // i.g0
    public final void recycle() {
        int i3 = this.f3095a;
    }

    public z(File file) {
        c0.g.c(file, "Argument must not be null");
        this.b = file;
    }

    public z(Bitmap bitmap) {
        this.b = bitmap;
    }

    private final void b() {
    }

    private final void c() {
    }

    private final void d() {
    }
}

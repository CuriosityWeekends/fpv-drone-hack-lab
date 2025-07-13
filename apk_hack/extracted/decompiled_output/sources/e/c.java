package e;

import android.opengl.Matrix;
import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1650a;
    public final Object b;
    public final Object c;
    public final Object d;

    public c() {
        this.b = new float[16];
        this.c = new float[16];
        this.d = new d2.c();
    }

    public static void b(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f4 = fArr2[10];
        float f5 = fArr2[8];
        float sqrt = (float) Math.sqrt((f5 * f5) + (f4 * f4));
        float f6 = fArr2[10] / sqrt;
        fArr[0] = f6;
        float f7 = fArr2[8];
        fArr[2] = f7 / sqrt;
        fArr[8] = (-f7) / sqrt;
        fArr[10] = f6;
    }

    public void a() {
        e.a((e) this.d, this, false);
    }

    public File c() {
        File file;
        synchronized (((e) this.d)) {
            try {
                d dVar = (d) this.b;
                if (dVar.f1653f == this) {
                    if (!dVar.f1652e) {
                        ((boolean[]) this.c)[0] = true;
                    }
                    file = dVar.d[0];
                    ((e) this.d).f1655a.mkdirs();
                } else {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public c(e eVar, d dVar) {
        this.d = eVar;
        this.b = dVar;
        this.c = dVar.f1652e ? null : new boolean[eVar.f1658g];
    }
}

package s3;

import android.graphics.Bitmap;
import android.view.View;
import java.io.File;
import n3.d;
import n3.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface c {
    Bitmap a();

    void b(d dVar, boolean z3);

    void c(File file, boolean z3, e eVar);

    void d();

    View getRenderView();

    void setGLEffectFilter(b bVar);

    void setGLMVPMatrix(float[] fArr);

    void setGLRenderer(r3.a aVar);

    void setRenderMode(int i3);
}

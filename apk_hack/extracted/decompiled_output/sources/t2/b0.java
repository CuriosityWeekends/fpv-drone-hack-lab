package t2;

import com.lg.picturesubmitt.MyApplication;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b0 implements g3.a, v.e, v.d, k4.b {
    @Override // v.e
    public void a(v.f fVar) {
        fVar.onStart();
    }

    @Override // k4.b
    public Object apply(Object obj) {
        List<v3.a> list = (List) obj;
        if (list.isEmpty()) {
            return p4.h.f3243a;
        }
        for (v3.a aVar : list) {
            if (!aVar.b) {
                return h4.b.f(Boolean.FALSE);
            }
        }
        return h4.b.f(Boolean.TRUE);
    }

    @Override // g3.a
    public void i() {
        MyApplication.f541h = true;
    }

    @Override // v.e
    public void b(v.f fVar) {
    }
}

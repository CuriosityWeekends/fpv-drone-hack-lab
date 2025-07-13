package b4;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends Property {
    @Override // android.util.Property
    public final Object get(Object obj) {
        View view = (View) obj;
        return new PointF(view.getTranslationX(), view.getTranslationY());
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        View view = (View) obj;
        PointF pointF = (PointF) obj2;
        view.setTranslationX(pointF.x);
        view.setTranslationY(pointF.y);
    }
}

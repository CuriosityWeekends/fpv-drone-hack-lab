package y2;

import com.lxj.easyadapter.MultiItemTypeAdapter;
import java.io.Serializable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiItemTypeAdapter f4261a;

    public d(MultiItemTypeAdapter multiItemTypeAdapter) {
        this.f4261a = multiItemTypeAdapter;
    }

    public final String toString() {
        w4.a.f3950a.getClass();
        String obj = d.class.getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        j4.b.b(obj, "renderLambdaToString(this)");
        return obj;
    }
}

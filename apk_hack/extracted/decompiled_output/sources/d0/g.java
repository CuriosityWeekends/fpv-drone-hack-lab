package d0;

import androidx.core.util.Pools;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final j3.b f1598a = new j3.b(2);

    public static d a(int i3, c cVar) {
        return new d(new Pools.SynchronizedPool(i3), cVar, f1598a);
    }
}

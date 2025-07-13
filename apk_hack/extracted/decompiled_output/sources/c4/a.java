package c4;

import a4.f;
import android.util.Property;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends Property {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f230a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        super(Integer.class, null);
        this.f230a = fVar;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        return this.f230a.a(obj);
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        this.f230a.b(((Integer) obj2).intValue(), obj);
    }
}

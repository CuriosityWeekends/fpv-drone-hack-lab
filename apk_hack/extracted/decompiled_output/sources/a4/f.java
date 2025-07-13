package a4;

import android.graphics.drawable.ColorDrawable;
import android.util.Property;
import android.widget.TextView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f extends Property {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f109a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i3) {
        super(Integer.class, null);
        this.f109a = i3;
    }

    public final Integer a(Object obj) {
        switch (this.f109a) {
            case 0:
                TextView textView = (TextView) obj;
                return 0;
            default:
                return Integer.valueOf(((ColorDrawable) obj).getColor());
        }
    }

    public final void b(int i3, Object obj) {
        switch (this.f109a) {
            case 0:
                ((TextView) obj).setTextColor(i3);
                return;
            default:
                ((ColorDrawable) obj).setColor(i3);
                return;
        }
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f109a) {
            case 0:
                TextView textView = (TextView) obj;
                return 0;
            default:
                return Integer.valueOf(((ColorDrawable) obj).getColor());
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        b(((Integer) obj2).intValue(), obj);
    }
}

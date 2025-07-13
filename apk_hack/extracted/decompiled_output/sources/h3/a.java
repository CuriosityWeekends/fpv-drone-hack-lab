package h3;

import android.app.Activity;
import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2037a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ b c;

    public /* synthetic */ a(b bVar, Activity activity, int i3) {
        this.f2037a = i3;
        this.c = bVar;
        this.b = activity;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.f2037a) {
            case 0:
                this.c.b(this.b);
                return;
            default:
                this.c.d(this.b);
                return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        int i3 = this.f2037a;
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }
}

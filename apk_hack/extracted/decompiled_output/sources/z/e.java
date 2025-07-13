package z;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import y.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f4264a;

    public e(f fVar) {
        this.f4264a = new WeakReference(fVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        int i3;
        if (Log.isLoggable("ViewTarget", 2)) {
            Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
        }
        f fVar = (f) this.f4264a.get();
        if (fVar != null) {
            ArrayList arrayList = fVar.b;
            if (!arrayList.isEmpty()) {
                View view = fVar.f4265a;
                int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i5 = 0;
                if (layoutParams != null) {
                    i3 = layoutParams.width;
                } else {
                    i3 = 0;
                }
                int a5 = fVar.a(view.getWidth(), i3, paddingRight);
                int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 != null) {
                    i5 = layoutParams2.height;
                }
                int a6 = fVar.a(view.getHeight(), i5, paddingBottom);
                if (a5 > 0 || a5 == Integer.MIN_VALUE) {
                    if (a6 > 0 || a6 == Integer.MIN_VALUE) {
                        Iterator it = new ArrayList(arrayList).iterator();
                        while (it.hasNext()) {
                            ((g) ((c) it.next())).m(a5, a6);
                        }
                        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeOnPreDrawListener(fVar.c);
                        }
                        fVar.c = null;
                        arrayList.clear();
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}

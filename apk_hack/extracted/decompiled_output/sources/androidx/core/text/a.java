package androidx.core.text;

import android.graphics.Rect;
import android.view.DisplayCutout;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ DisplayCutout g(Rect rect, ArrayList arrayList) {
        return new DisplayCutout(rect, arrayList);
    }

    public static /* synthetic */ DisplayCutout h(Rect rect, List list) {
        return new DisplayCutout(rect, list);
    }

    public static /* bridge */ /* synthetic */ DisplayCutout j(Object obj) {
        return (DisplayCutout) obj;
    }

    public static /* bridge */ /* synthetic */ View.OnUnhandledKeyEventListener k(Object obj) {
        return (View.OnUnhandledKeyEventListener) obj;
    }

    public static /* synthetic */ void q() {
    }
}

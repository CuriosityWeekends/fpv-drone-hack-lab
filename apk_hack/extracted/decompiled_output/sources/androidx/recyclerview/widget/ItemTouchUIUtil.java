package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f4, float f5, int i3, boolean z3);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f4, float f5, int i3, boolean z3);

    void onSelected(View view);
}

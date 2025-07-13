package z;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import c0.g;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f {
    public static Integer d;

    /* renamed from: a  reason: collision with root package name */
    public final View f4265a;
    public final ArrayList b = new ArrayList();
    public e c;

    public f(View view) {
        this.f4265a = view;
    }

    public final int a(int i3, int i5, int i6) {
        int i7 = i5 - i6;
        if (i7 > 0) {
            return i7;
        }
        int i8 = i3 - i6;
        if (i8 > 0) {
            return i8;
        }
        View view = this.f4265a;
        if (!view.isLayoutRequested() && i5 == -2) {
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            Context context = view.getContext();
            if (d == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                g.c(windowManager, "Argument must not be null");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                d = Integer.valueOf(Math.max(point.x, point.y));
            }
            return d.intValue();
        }
        return 0;
    }
}

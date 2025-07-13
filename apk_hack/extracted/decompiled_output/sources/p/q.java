package p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static final p f3082a = new j3.a(7);

    public static c a(j.b bVar, Drawable drawable, int i3, int i5) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z3 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            if (i3 == Integer.MIN_VALUE && current.getIntrinsicWidth() <= 0) {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                }
            } else if (i5 == Integer.MIN_VALUE && current.getIntrinsicHeight() <= 0) {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
            } else {
                if (current.getIntrinsicWidth() > 0) {
                    i3 = current.getIntrinsicWidth();
                }
                if (current.getIntrinsicHeight() > 0) {
                    i5 = current.getIntrinsicHeight();
                }
                Lock lock = y.b;
                lock.lock();
                Bitmap d = bVar.d(i3, i5, Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(d);
                    current.setBounds(0, 0, i3, i5);
                    current.draw(canvas);
                    canvas.setBitmap(null);
                    lock.unlock();
                    bitmap = d;
                    z3 = true;
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }
            bitmap = null;
            z3 = true;
        } else {
            bitmap = null;
        }
        if (!z3) {
            bVar = f3082a;
        }
        return c.b(bitmap, bVar);
    }
}

package p;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h extends d {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(g.e.f1896a);

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // p.d
    public final Bitmap c(j.b bVar, Bitmap bitmap, int i3, int i5) {
        Paint paint = y.f3094a;
        if (bitmap.getWidth() <= i3 && bitmap.getHeight() <= i5) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
                return bitmap;
            }
            return bitmap;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return y.b(bVar, bitmap, i3, i5);
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // g.e
    public final int hashCode() {
        return -670243078;
    }
}

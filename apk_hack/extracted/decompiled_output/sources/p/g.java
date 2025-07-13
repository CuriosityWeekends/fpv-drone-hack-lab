package p;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends d {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(g.e.f1896a);

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // p.d
    public final Bitmap c(j.b bVar, Bitmap bitmap, int i3, int i5) {
        float width;
        float height;
        Bitmap.Config config;
        Paint paint = y.f3094a;
        if (bitmap.getWidth() != i3 || bitmap.getHeight() != i5) {
            Matrix matrix = new Matrix();
            float f4 = 0.0f;
            if (bitmap.getWidth() * i5 > bitmap.getHeight() * i3) {
                width = i5 / bitmap.getHeight();
                f4 = (i3 - (bitmap.getWidth() * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = i3 / bitmap.getWidth();
                height = (i5 - (bitmap.getHeight() * width)) * 0.5f;
            }
            matrix.setScale(width, width);
            matrix.postTranslate((int) (f4 + 0.5f), (int) (height + 0.5f));
            if (bitmap.getConfig() != null) {
                config = bitmap.getConfig();
            } else {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap d = bVar.d(i3, i5, config);
            d.setHasAlpha(bitmap.hasAlpha());
            y.a(bitmap, d, matrix);
            return d;
        }
        return bitmap;
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        return obj instanceof g;
    }

    @Override // g.e
    public final int hashCode() {
        return -599754482;
    }
}

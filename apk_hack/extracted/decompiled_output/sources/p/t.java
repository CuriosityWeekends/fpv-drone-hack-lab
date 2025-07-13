package p;

import android.graphics.Bitmap;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class t extends d {
    public static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(g.e.f1896a);

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // p.d
    public final Bitmap c(j.b bVar, Bitmap bitmap, int i3, int i5) {
        return y.b(bVar, bitmap, i3, i5);
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        return obj instanceof t;
    }

    @Override // g.e
    public final int hashCode() {
        return 1572326941;
    }
}

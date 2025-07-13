package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public static final List f3307a = Arrays.asList("raw", "drawable", "mipmap");

    public static void a(Drawable drawable, int i3) {
        if (drawable instanceof c) {
            ((c) drawable).f3285g.v(i3);
        }
    }

    public static k b(ImageView imageView, AttributeSet attributeSet, int i3) {
        if (attributeSet != null && !imageView.isInEditMode()) {
            k kVar = new k(imageView, attributeSet, i3);
            int i5 = kVar.b;
            if (i5 >= 0) {
                a(imageView.getDrawable(), i5);
                a(imageView.getBackground(), i5);
            }
            return kVar;
        }
        return new k();
    }

    public static boolean c(ImageView imageView, Uri uri) {
        if (uri != null) {
            try {
                imageView.setImageDrawable(new c(imageView.getContext().getContentResolver(), uri));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean d(ImageView imageView, boolean z3, int i3) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!f3307a.contains(resources.getResourceTypeName(i3))) {
                    return false;
                }
                c cVar = new c(resources, i3);
                if (z3) {
                    imageView.setImageDrawable(cVar);
                    return true;
                }
                imageView.setBackground(cVar);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }
}

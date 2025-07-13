package pl.droidsonroids.gif;

import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends l {
    public final int c;
    public final int d;

    public k(ImageView imageView, AttributeSet attributeSet, int i3) {
        super(imageView, attributeSet, i3);
        this.c = a(imageView, attributeSet, true);
        this.d = a(imageView, attributeSet, false);
    }

    public static int a(ImageView imageView, AttributeSet attributeSet, boolean z3) {
        String str;
        if (z3) {
            str = "src";
        } else {
            str = "background";
        }
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", str, 0);
        if (attributeResourceValue > 0) {
            if (m.f3307a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !m.d(imageView, z3, attributeResourceValue)) {
                return attributeResourceValue;
            }
        }
        return 0;
    }

    public k() {
        this.c = 0;
        this.d = 0;
    }
}

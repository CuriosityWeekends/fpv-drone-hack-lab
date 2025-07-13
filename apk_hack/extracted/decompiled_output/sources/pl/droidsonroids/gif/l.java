package pl.droidsonroids.gif;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3306a;
    public final int b;

    public l(View view, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, q.GifView, i3, 0);
        this.f3306a = obtainStyledAttributes.getBoolean(q.GifView_freezesAnimation, false);
        this.b = obtainStyledAttributes.getInt(q.GifView_loopCount, -1);
        obtainStyledAttributes.recycle();
    }

    public l() {
        this.f3306a = false;
        this.b = -1;
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    public TintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i3) {
        Drawable drawable = super.getDrawable(i3);
        Context context = this.mContextRef.get();
        if (drawable != null && context != null) {
            ResourceManagerInternal.get().tintDrawableUsingColorFilter(context, i3, drawable);
        }
        return drawable;
    }
}

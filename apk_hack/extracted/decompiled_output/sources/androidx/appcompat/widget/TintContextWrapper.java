package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TintContextWrapper extends ContextWrapper {
    private static final Object CACHE_LOCK = new Object();
    private static ArrayList<WeakReference<TintContextWrapper>> sCache;
    private final Resources mResources;
    private final Resources.Theme mTheme;

    private TintContextWrapper(@NonNull Context context) {
        super(context);
        if (VectorEnabledTintResources.shouldBeUsed()) {
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
            this.mResources = vectorEnabledTintResources;
            Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
            this.mTheme = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.mResources = new TintResources(this, context.getResources());
        this.mTheme = null;
    }

    private static boolean shouldWrap(@NonNull Context context) {
        if (!(context instanceof TintContextWrapper) && !(context.getResources() instanceof TintResources) && !(context.getResources() instanceof VectorEnabledTintResources)) {
            return VectorEnabledTintResources.shouldBeUsed();
        }
        return false;
    }

    public static Context wrap(@NonNull Context context) {
        TintContextWrapper tintContextWrapper;
        if (shouldWrap(context)) {
            synchronized (CACHE_LOCK) {
                try {
                    ArrayList<WeakReference<TintContextWrapper>> arrayList = sCache;
                    if (arrayList == null) {
                        sCache = new ArrayList<>();
                    } else {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            WeakReference<TintContextWrapper> weakReference = sCache.get(size);
                            if (weakReference == null || weakReference.get() == null) {
                                sCache.remove(size);
                            }
                        }
                        for (int size2 = sCache.size() - 1; size2 >= 0; size2--) {
                            WeakReference<TintContextWrapper> weakReference2 = sCache.get(size2);
                            if (weakReference2 != null) {
                                tintContextWrapper = weakReference2.get();
                            } else {
                                tintContextWrapper = null;
                            }
                            if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                                return tintContextWrapper;
                            }
                        }
                    }
                    TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                    sCache.add(new WeakReference<>(tintContextWrapper2));
                    return tintContextWrapper2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.mTheme;
        if (theme == null) {
            return super.getTheme();
        }
        return theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        Resources.Theme theme = this.mTheme;
        if (theme == null) {
            super.setTheme(i3);
        } else {
            theme.applyStyle(i3, true);
        }
    }
}

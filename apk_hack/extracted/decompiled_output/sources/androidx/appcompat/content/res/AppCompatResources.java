package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;
@SuppressLint({"RestrictedAPI"})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class AppCompatResources {
    private static final String LOG_TAG = "AppCompatResources";
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    private static final Object sColorStateCacheLock = new Object();

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ColorStateListCacheEntry {
        final Configuration configuration;
        final ColorStateList value;

        public ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
            this.value = colorStateList;
            this.configuration = configuration;
        }
    }

    private AppCompatResources() {
    }

    private static void addColorStateListToCache(@NonNull Context context, @ColorRes int i3, @NonNull ColorStateList colorStateList) {
        synchronized (sColorStateCacheLock) {
            try {
                WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
                SparseArray<ColorStateListCacheEntry> sparseArray = weakHashMap.get(context);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    weakHashMap.put(context, sparseArray);
                }
                sparseArray.append(i3, new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private static ColorStateList getCachedColorStateList(@NonNull Context context, @ColorRes int i3) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (sColorStateCacheLock) {
            try {
                SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(context);
                if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i3)) != null) {
                    if (colorStateListCacheEntry.configuration.equals(context.getResources().getConfiguration())) {
                        return colorStateListCacheEntry.value;
                    }
                    sparseArray.remove(i3);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int i3) {
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT >= 23) {
            colorStateList = context.getColorStateList(i3);
            return colorStateList;
        }
        ColorStateList cachedColorStateList = getCachedColorStateList(context, i3);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList inflateColorStateList = inflateColorStateList(context, i3);
        if (inflateColorStateList != null) {
            addColorStateListToCache(context, i3, inflateColorStateList);
            return inflateColorStateList;
        }
        return ContextCompat.getColorStateList(context, i3);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int i3) {
        return ResourceManagerInternal.get().getDrawable(context, i3);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = TL_TYPED_VALUE;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Context context, int i3) {
        if (isColorInt(context, i3)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i3), context.getTheme());
        } catch (Exception e5) {
            Log.e(LOG_TAG, "Failed to inflate ColorStateList, leaving it to the framework", e5);
            return null;
        }
    }

    private static boolean isColorInt(@NonNull Context context, @ColorRes int i3) {
        Resources resources = context.getResources();
        TypedValue typedValue = getTypedValue();
        resources.getValue(i3, typedValue, true);
        int i5 = typedValue.type;
        if (i5 >= 28 && i5 <= 31) {
            return true;
        }
        return false;
    }
}

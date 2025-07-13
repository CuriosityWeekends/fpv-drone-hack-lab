package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ResourcesCompat {
    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static abstract class FontCallback {
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(final int i3, @Nullable Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrievalFailed(i3);
                }
            });
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(final Typeface typeface, @Nullable Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i3);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class ThemeCompat {

        @RequiresApi(23)
        /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
        public static class ImplApi23 {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = new Object();

            private ImplApi23() {
            }

            public static void rebase(@NonNull Resources.Theme theme) {
                synchronized (sRebaseMethodLock) {
                    if (!sRebaseMethodFetched) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            sRebaseMethod = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e5) {
                            Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e5);
                        }
                        sRebaseMethodFetched = true;
                    }
                    Method method = sRebaseMethod;
                    if (method != null) {
                        try {
                            method.invoke(theme, null);
                        } catch (IllegalAccessException | InvocationTargetException e6) {
                            Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e6);
                            sRebaseMethod = null;
                        }
                    }
                }
            }
        }

        @RequiresApi(29)
        /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
        public static class ImplApi29 {
            private ImplApi29() {
            }

            public static void rebase(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme theme) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                ImplApi29.rebase(theme);
            } else if (i3 >= 23) {
                ImplApi23.rebase(theme);
            }
        }
    }

    private ResourcesCompat() {
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context context, @FontRes int i3) {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i3, new TypedValue(), 0, null, null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i3, @Nullable Resources.Theme theme) {
        int color;
        if (Build.VERSION.SDK_INT >= 23) {
            color = resources.getColor(i3, theme);
            return color;
        }
        return resources.getColor(i3);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i3, @Nullable Resources.Theme theme) {
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT >= 23) {
            colorStateList = resources.getColorStateList(i3, theme);
            return colorStateList;
        }
        return resources.getColorStateList(i3);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i3, @Nullable Resources.Theme theme) {
        return resources.getDrawable(i3, theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i3, int i5, @Nullable Resources.Theme theme) {
        return resources.getDrawableForDensity(i3, i5, theme);
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i3) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i3, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i3) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i3) {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i3, new TypedValue(), 0, null, null, false, false);
    }

    private static Typeface loadFont(@NonNull Context context, int i3, TypedValue typedValue, int i5, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z3, boolean z5) {
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i3, i5, fontCallback, handler, z3, z5);
        if (loadFont == null && fontCallback == null && !z5) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i3) + " could not be retrieved.");
        }
        return loadFont;
    }

    public static void getFont(@NonNull Context context, @FontRes int i3, @NonNull FontCallback fontCallback, @Nullable Handler handler) {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i3, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface loadFont(@androidx.annotation.NonNull android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback r20, @androidx.annotation.Nullable android.os.Handler r21, boolean r22, boolean r23) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L97
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = 0
            r14 = -3
            if (r1 != 0) goto L26
            if (r9 == 0) goto L25
            r9.callbackFailAsync(r14, r10)
        L25:
            return r13
        L26:
            android.graphics.Typeface r1 = androidx.core.graphics.TypefaceCompat.findFromCache(r0, r4, r5)
            if (r1 == 0) goto L32
            if (r9 == 0) goto L31
            r9.callbackSuccessAsync(r1, r10)
        L31:
            return r1
        L32:
            if (r23 == 0) goto L35
            return r13
        L35:
            java.lang.String r1 = r12.toLowerCase()     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
            if (r1 == 0) goto L6d
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r2 = androidx.core.content.res.FontResourcesParserCompat.parse(r1, r0)     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
            if (r2 != 0) goto L5b
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
            if (r9 == 0) goto L5a
            r9.callbackFailAsync(r14, r10)     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
            goto L5a
        L56:
            r0 = move-exception
            goto L7e
        L58:
            r0 = move-exception
            goto L88
        L5a:
            return r13
        L5b:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
            return r0
        L6d:
            r1 = r15
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFontFile(r15, r0, r4, r12, r5)     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
            if (r9 == 0) goto L7d
            if (r0 == 0) goto L7a
            r9.callbackSuccessAsync(r0, r10)     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
            goto L7d
        L7a:
            r9.callbackFailAsync(r14, r10)     // Catch: java.io.IOException -> L56 org.xmlpull.v1.XmlPullParserException -> L58
        L7d:
            return r0
        L7e:
            java.lang.String r1 = "Failed to read xml resource "
            java.lang.String r1 = r1.concat(r12)
            android.util.Log.e(r11, r1, r0)
            goto L91
        L88:
            java.lang.String r1 = "Failed to parse xml resource "
            java.lang.String r1 = r1.concat(r12)
            android.util.Log.e(r11, r1, r0)
        L91:
            if (r9 == 0) goto L96
            r9.callbackFailAsync(r14, r10)
        L96:
            return r13
        L97:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Resource \""
            r3.<init>(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i3, TypedValue typedValue, int i5, @Nullable FontCallback fontCallback) {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i3, typedValue, i5, fontCallback, null, true, false);
    }
}

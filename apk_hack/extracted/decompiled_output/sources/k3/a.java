package k3;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.bumptech.glide.d;
import com.bumptech.glide.e;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends d {
    public final /* synthetic */ int b;

    public /* synthetic */ a(int i3) {
        this.b = i3;
    }

    @Override // com.bumptech.glide.d
    public void b(Activity activity) {
        switch (this.b) {
            case 1:
                e(activity);
                if (h(activity.getWindow())) {
                    e.h(activity.getWindow());
                    return;
                }
                return;
            case 2:
                e(activity);
                if (h(activity.getWindow())) {
                    e.h(activity.getWindow());
                    return;
                }
                return;
            case 3:
                super.b(activity);
                if (h(activity.getWindow())) {
                    e.h(activity.getWindow());
                    return;
                }
                return;
            case 4:
                super.b(activity);
                if (h(activity.getWindow())) {
                    WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                    attributes.layoutInDisplayCutoutMode = 2;
                    activity.getWindow().setAttributes(attributes);
                    return;
                }
                return;
            case 5:
                super.b(activity);
                if (h(activity.getWindow())) {
                    WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                    attributes2.layoutInDisplayCutoutMode = 1;
                    activity.getWindow().setAttributes(attributes2);
                    e.h(activity.getWindow());
                    return;
                }
                return;
            case 6:
                super.b(activity);
                if (h(activity.getWindow())) {
                    Window window = activity.getWindow();
                    WindowManager.LayoutParams attributes3 = window.getAttributes();
                    try {
                        Field field = attributes3.getClass().getField("layoutInDisplayCutoutMode");
                        field.setAccessible(true);
                        field.setInt(attributes3, 1);
                        window.setAttributes(attributes3);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    e.h(activity.getWindow());
                    return;
                }
                return;
            default:
                super.b(activity);
                return;
        }
    }

    @Override // com.bumptech.glide.d
    public void d(Activity activity) {
        switch (this.b) {
            case 3:
                b(activity);
                return;
            case 6:
                b(activity);
                return;
            default:
                super.d(activity);
                return;
        }
    }

    @Override // com.bumptech.glide.d
    public void e(Activity activity) {
        Window window;
        switch (this.b) {
            case 1:
                super.e(activity);
                if (h(activity.getWindow()) && (window = activity.getWindow()) != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    try {
                        Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                        cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
                        return;
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                        Log.e("test", "hw add notch screen flag api error");
                        return;
                    } catch (Exception unused2) {
                        Log.e("test", "other Exception");
                        return;
                    }
                }
                return;
            case 2:
                super.e(activity);
                if (Build.VERSION.SDK_INT >= 26 && h(activity.getWindow())) {
                    try {
                        Method method = Window.class.getMethod("addExtraFlags", Integer.TYPE);
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        method.invoke(activity.getWindow(), 1792);
                        return;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        return;
                    }
                }
                return;
            case 3:
            default:
                super.e(activity);
                return;
            case 4:
                super.e(activity);
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.layoutInDisplayCutoutMode = 1;
                activity.getWindow().setAttributes(attributes2);
                return;
            case 5:
                super.e(activity);
                WindowManager.LayoutParams attributes3 = activity.getWindow().getAttributes();
                attributes3.layoutInDisplayCutoutMode = 1;
                activity.getWindow().setAttributes(attributes3);
                return;
            case 6:
                super.e(activity);
                if (h(activity.getWindow())) {
                    Window window2 = activity.getWindow();
                    WindowManager.LayoutParams attributes4 = window2.getAttributes();
                    try {
                        Field field = attributes4.getClass().getField("layoutInDisplayCutoutMode");
                        field.setAccessible(true);
                        field.setInt(attributes4, 1);
                        window2.setAttributes(attributes4);
                        return;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return;
                    }
                }
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        r5 = r5.getDisplayCutout();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
        r5 = r5.getDisplayCutout();
     */
    @Override // com.bumptech.glide.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(android.view.Window r5) {
        /*
            r4 = this;
            int r0 = r4.b
            switch(r0) {
                case 0: goto Ldf;
                case 1: goto La8;
                case 2: goto L63;
                case 3: goto L52;
                case 4: goto L34;
                case 5: goto L16;
                default: goto L5;
            }
        L5:
            boolean r0 = r4.h(r5)
            if (r0 != 0) goto Ld
            r5 = 0
            goto L15
        Ld:
            android.content.Context r5 = r5.getContext()
            int r5 = com.bumptech.glide.e.c(r5)
        L15:
            return r5
        L16:
            android.view.View r5 = r5.getDecorView()
            android.view.WindowInsets r5 = h2.e.e(r5)
            r0 = 0
            if (r5 != 0) goto L22
            goto L33
        L22:
            android.view.DisplayCutout r5 = androidx.core.text.a.i(r5)
            if (r5 == 0) goto L33
            java.util.List r1 = androidx.core.text.a.p(r5)
            if (r1 != 0) goto L2f
            goto L33
        L2f:
            int r0 = androidx.core.text.a.C(r5)
        L33:
            return r0
        L34:
            android.view.View r5 = r5.getDecorView()
            android.view.WindowInsets r5 = h2.e.e(r5)
            r0 = 0
            if (r5 != 0) goto L40
            goto L51
        L40:
            android.view.DisplayCutout r5 = androidx.core.text.a.i(r5)
            if (r5 == 0) goto L51
            java.util.List r1 = androidx.core.text.a.p(r5)
            if (r1 != 0) goto L4d
            goto L51
        L4d:
            int r0 = androidx.core.text.a.C(r5)
        L51:
            return r0
        L52:
            boolean r0 = r4.h(r5)
            if (r0 != 0) goto L5a
            r5 = 0
            goto L62
        L5a:
            android.content.Context r5 = r5.getContext()
            int r5 = com.bumptech.glide.e.c(r5)
        L62:
            return r5
        L63:
            boolean r0 = r4.h(r5)
            r1 = 0
            if (r0 != 0) goto L6b
            goto La7
        L6b:
            if (r5 != 0) goto L6e
            goto La7
        L6e:
            android.content.Context r0 = r5.getContext()
            android.content.Context r5 = r5.getContext()
            android.content.ContentResolver r5 = r5.getContentResolver()
            java.lang.String r2 = "force_black"
            int r5 = android.provider.Settings.Global.getInt(r5, r2, r1)
            r1 = 1
            if (r5 != r1) goto L89
            int r5 = com.bumptech.glide.e.c(r0)
        L87:
            r1 = r5
            goto La7
        L89:
            android.content.res.Resources r5 = r0.getResources()
            java.lang.String r1 = "android"
            java.lang.String r2 = "notch_height"
            java.lang.String r3 = "dimen"
            int r5 = r5.getIdentifier(r2, r3, r1)
            if (r5 <= 0) goto La2
            android.content.res.Resources r0 = r0.getResources()
            int r5 = r0.getDimensionPixelSize(r5)
            goto L87
        La2:
            int r5 = com.bumptech.glide.e.c(r0)
            goto L87
        La7:
            return r1
        La8:
            boolean r0 = r4.h(r5)
            r1 = 0
            if (r0 != 0) goto Lb0
            goto Lde
        Lb0:
            int[] r0 = new int[]{r1, r1}
            r1 = 1
            android.content.Context r5 = r5.getContext()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld6 java.lang.NoSuchMethodException -> Ld9 java.lang.ClassNotFoundException -> Ldc
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld6 java.lang.NoSuchMethodException -> Ld9 java.lang.ClassNotFoundException -> Ldc
            java.lang.String r2 = "com.huawei.android.util.HwNotchSizeUtil"
            java.lang.Class r5 = r5.loadClass(r2)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld6 java.lang.NoSuchMethodException -> Ld9 java.lang.ClassNotFoundException -> Ldc
            java.lang.String r2 = "getNotchSize"
            r3 = 0
            java.lang.reflect.Method r2 = r5.getMethod(r2, r3)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld6 java.lang.NoSuchMethodException -> Ld9 java.lang.ClassNotFoundException -> Ldc
            java.lang.Object r5 = r2.invoke(r5, r3)     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld6 java.lang.NoSuchMethodException -> Ld9 java.lang.ClassNotFoundException -> Ldc
            int[] r5 = (int[]) r5     // Catch: java.lang.Throwable -> Ld3 java.lang.Exception -> Ld6 java.lang.NoSuchMethodException -> Ld9 java.lang.ClassNotFoundException -> Ldc
            r1 = r5[r1]
            goto Lde
        Ld3:
            r1 = r0[r1]
            goto Lde
        Ld6:
            r1 = r0[r1]
            goto Lde
        Ld9:
            r1 = r0[r1]
            goto Lde
        Ldc:
            r1 = r0[r1]
        Lde:
            return r1
        Ldf:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.a.f(android.view.Window):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        r7 = r7.getDisplayCutout();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        r7 = r7.getDisplayCutout();
     */
    @Override // com.bumptech.glide.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(android.view.Window r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            int r3 = r6.b
            switch(r3) {
                case 0: goto Lbb;
                case 1: goto L89;
                case 2: goto L75;
                case 3: goto L63;
                case 4: goto L49;
                case 5: goto L2f;
                default: goto L8;
            }
        L8:
            if (r7 != 0) goto Lb
            goto L2e
        Lb:
            android.content.Context r7 = r7.getContext()     // Catch: java.lang.Exception -> L2e
            android.content.res.Resources r7 = r7.getResources()     // Catch: java.lang.Exception -> L2e
            java.lang.String r3 = "config_mainBuiltInDisplayCutout"
            java.lang.String r4 = "string"
            java.lang.String r5 = "android"
            int r3 = r7.getIdentifier(r3, r4, r5)     // Catch: java.lang.Exception -> L2e
            if (r3 <= 0) goto L23
            java.lang.String r0 = r7.getString(r3)     // Catch: java.lang.Exception -> L2e
        L23:
            if (r0 == 0) goto L2c
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L2e
            if (r7 != 0) goto L2c
            goto L2d
        L2c:
            r1 = 0
        L2d:
            r2 = r1
        L2e:
            return r2
        L2f:
            android.view.View r7 = r7.getDecorView()
            android.view.WindowInsets r7 = h2.e.e(r7)
            if (r7 != 0) goto L3b
        L39:
            r1 = 0
            goto L48
        L3b:
            android.view.DisplayCutout r7 = androidx.core.text.a.i(r7)
            if (r7 == 0) goto L39
            java.util.List r7 = androidx.core.text.a.p(r7)
            if (r7 != 0) goto L48
            goto L39
        L48:
            return r1
        L49:
            android.view.View r7 = r7.getDecorView()
            android.view.WindowInsets r7 = h2.e.e(r7)
            if (r7 != 0) goto L55
        L53:
            r1 = 0
            goto L62
        L55:
            android.view.DisplayCutout r7 = androidx.core.text.a.i(r7)
            if (r7 == 0) goto L53
            java.util.List r7 = androidx.core.text.a.p(r7)
            if (r7 != 0) goto L62
            goto L53
        L62:
            return r1
        L63:
            if (r7 != 0) goto L66
            goto L74
        L66:
            android.content.Context r7 = r7.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            java.lang.String r0 = "com.oppo.feature.screen.heteromorphism"
            boolean r2 = r7.hasSystemFeature(r0)
        L74:
            return r2
        L75:
            j3.b r7 = j3.b.o()
            r7.getClass()
            java.lang.String r7 = "ro.miui.notch"
            java.lang.String r7 = j3.b.n(r7)
            java.lang.String r0 = "1"
            boolean r7 = r0.equals(r7)
            return r7
        L89:
            java.lang.String r1 = "a"
            android.content.Context r7 = r7.getContext()     // Catch: java.lang.Exception -> Laa java.lang.NoSuchMethodException -> Lb0 java.lang.ClassNotFoundException -> Lb6 java.lang.Throwable -> Lbb
            java.lang.ClassLoader r7 = r7.getClassLoader()     // Catch: java.lang.Exception -> Laa java.lang.NoSuchMethodException -> Lb0 java.lang.ClassNotFoundException -> Lb6 java.lang.Throwable -> Lbb
            java.lang.String r3 = "com.huawei.android.util.HwNotchSizeUtil"
            java.lang.Class r7 = r7.loadClass(r3)     // Catch: java.lang.Exception -> Laa java.lang.NoSuchMethodException -> Lb0 java.lang.ClassNotFoundException -> Lb6 java.lang.Throwable -> Lbb
            java.lang.String r3 = "hasNotchInScreen"
            java.lang.reflect.Method r3 = r7.getMethod(r3, r0)     // Catch: java.lang.Exception -> Laa java.lang.NoSuchMethodException -> Lb0 java.lang.ClassNotFoundException -> Lb6 java.lang.Throwable -> Lbb
            java.lang.Object r7 = r3.invoke(r7, r0)     // Catch: java.lang.Exception -> Laa java.lang.NoSuchMethodException -> Lb0 java.lang.ClassNotFoundException -> Lb6 java.lang.Throwable -> Lbb
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Exception -> Laa java.lang.NoSuchMethodException -> Lb0 java.lang.ClassNotFoundException -> Lb6 java.lang.Throwable -> Lbb
            boolean r2 = r7.booleanValue()     // Catch: java.lang.Exception -> Laa java.lang.NoSuchMethodException -> Lb0 java.lang.ClassNotFoundException -> Lb6 java.lang.Throwable -> Lbb
            goto Lbb
        Laa:
            java.lang.String r7 = "hasNotchInScreen Exception"
            android.util.Log.d(r1, r7)     // Catch: java.lang.Throwable -> Lbb
            goto Lbb
        Lb0:
            java.lang.String r7 = "hasNotchInScreen NoSuchMethodException"
            android.util.Log.d(r1, r7)     // Catch: java.lang.Throwable -> Lbb
            goto Lbb
        Lb6:
            java.lang.String r7 = "hasNotchInScreen ClassNotFoundException"
            android.util.Log.d(r1, r7)     // Catch: java.lang.Throwable -> Lbb
        Lbb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.a.h(android.view.Window):boolean");
    }
}

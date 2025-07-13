package com.lxj.xpopup.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1096a = {"huawei"};
    public static final String[] b = {"vivo"};
    public static final String[] c = {"xiaomi"};
    public static final String[] d = {"oppo"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f1097e = {"leeco", "letv"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f1098f = {"360", "qiku"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f1099g = {"zte"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f1100h = {"oneplus"};

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f1101i = {"nubia"};

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f1102j = {"coolpad", "yulong"};

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f1103k = {"lg", "lge"};

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f1104l = {"google"};

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f1105m = {"samsung"};

    /* renamed from: n  reason: collision with root package name */
    public static final String[] f1106n = {"meizu"};

    /* renamed from: o  reason: collision with root package name */
    public static final String[] f1107o = {"lenovo"};

    /* renamed from: p  reason: collision with root package name */
    public static final String[] f1108p = {"smartisan"};
    public static final String[] q = {"htc"};

    /* renamed from: r  reason: collision with root package name */
    public static final String[] f1109r = {"sony"};
    public static final String[] s = {"gionee", "amigo"};

    /* renamed from: t  reason: collision with root package name */
    public static final String[] f1110t = {"motorola"};

    /* renamed from: u  reason: collision with root package name */
    public static a f1111u = null;

    /* renamed from: v  reason: collision with root package name */
    public static final String[] f1112v = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static int w;

    /* renamed from: x  reason: collision with root package name */
    public static int f1113x;

    public static void a(final ViewGroup viewGroup, final int i3, final int i5, final int i6, final int i7, final Runnable runnable) {
        viewGroup.post(new Runnable() { // from class: com.lxj.xpopup.util.f
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup viewGroup2 = viewGroup;
                ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                View childAt = viewGroup2.getChildAt(0);
                if (childAt != null) {
                    ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                    int measuredWidth = viewGroup2.getMeasuredWidth();
                    int i8 = i3;
                    int i9 = i6;
                    if (i8 > 0) {
                        if (measuredWidth > i8) {
                            layoutParams.width = Math.min(measuredWidth, i8);
                        }
                        if (layoutParams2.width == -1) {
                            int min = Math.min(measuredWidth, i8);
                            layoutParams2.width = min;
                            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                                layoutParams2.width = (min - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
                            }
                        }
                        if (i9 > 0) {
                            layoutParams.width = Math.min(i9, i8);
                            layoutParams2.width = Math.min(i9, i8);
                        }
                    } else if (i9 > 0) {
                        layoutParams.width = i9;
                        layoutParams2.width = i9;
                    }
                    int i10 = i5;
                    int i11 = i7;
                    if (i10 > 0) {
                        int measuredHeight = viewGroup2.getMeasuredHeight();
                        if (measuredHeight > i10) {
                            layoutParams.height = Math.min(measuredHeight, i10);
                        }
                        if (i11 > 0) {
                            layoutParams.height = Math.min(i11, i10);
                            layoutParams2.height = Math.min(i11, i10);
                        }
                    } else if (i11 > 0) {
                        layoutParams.height = i11;
                        layoutParams2.height = i11;
                    }
                    childAt.setLayoutParams(layoutParams2);
                    viewGroup2.setLayoutParams(layoutParams);
                    viewGroup2.post(new c2.b(1, runnable));
                }
            }
        });
    }

    public static BitmapDrawable b(Context context, int i3, int i5) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, d(context, 1.5f), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(i5);
        canvas.drawRect(0.0f, 0.0f, createBitmap.getWidth(), createBitmap.getHeight(), paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), createBitmap);
        bitmapDrawable.setGravity(80);
        return bitmapDrawable;
    }

    public static GradientDrawable c(int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(15.0f);
        return gradientDrawable;
    }

    public static int d(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void e(ArrayList arrayList, ViewGroup viewGroup) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof EditText) && childAt.getVisibility() == 0) {
                arrayList.add((EditText) childAt);
            } else if (childAt instanceof ViewGroup) {
                e(arrayList, (ViewGroup) childAt);
            }
        }
    }

    public static int f(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static int g(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int h(Window window) {
        View decorView;
        if (window == null || (decorView = window.getDecorView()) == null) {
            return 0;
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= i(window)) {
            w = abs;
            return 0;
        }
        return abs - w;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:38|(2:39|40)|(6:42|43|44|(1:46)|48|(3:50|(1:52)(1:54)|53)(2:55|(1:57)(2:58|(1:60)(2:61|(1:63)(2:64|(1:66)(2:67|(1:69)(2:70|(1:72)(2:73|(1:75)(2:76|(1:78)(3:79|(1:81)(2:83|(1:85)(2:86|(1:88)(2:89|(1:91)(2:92|(1:94)(2:95|(1:97)(2:98|(1:100)(2:101|(1:103)(2:104|(1:106)(2:107|(1:109)(2:110|(1:112)(1:113)))))))))))|82))))))))))|116|43|44|(0)|48|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0244, code lost:
        if (android.provider.Settings.Global.getInt(r9.getContext().getContentResolver(), "navigationbar_hide_bar_enabled") == 0) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0006, code lost:
        r1 = (android.view.ViewGroup) r9.getDecorView();
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0256 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #0 {all -> 0x0074, blocks: (B:31:0x0067, B:33:0x006f), top: B:132:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int i(android.view.Window r9) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.util.b.i(android.view.Window):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #2 {all -> 0x00c4, blocks: (B:44:0x00b7, B:46:0x00bf), top: B:57:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String j(java.lang.String r9) {
        /*
            r0 = 1
            r1 = 0
            r2 = 2
            java.lang.String r3 = "getprop "
            boolean r4 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r5 = ""
            if (r4 != 0) goto La9
            r4 = 0
            java.lang.Runtime r6 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            java.lang.String r3 = r3.concat(r9)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            java.lang.Process r3 = r6.exec(r3)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            r3 = 1024(0x400, float:1.435E-42)
            r6.<init>(r7, r3)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L44
            java.lang.String r3 = r6.readLine()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            if (r3 == 0) goto L36
            r6.close()     // Catch: java.io.IOException -> L34
            goto L52
        L34:
            goto L52
        L36:
            r6.close()     // Catch: java.io.IOException -> L3a
            goto L51
        L3a:
            goto L51
        L3c:
            r9 = move-exception
            r4 = r6
            goto L46
        L3f:
            r4 = r6
            goto L4c
        L42:
            r9 = move-exception
            goto L46
        L44:
            goto L4c
        L46:
            if (r4 == 0) goto L4b
            r4.close()     // Catch: java.io.IOException -> L4b
        L4b:
            throw r9
        L4c:
            if (r4 == 0) goto L51
            r4.close()     // Catch: java.io.IOException -> L3a
        L51:
            r3 = r5
        L52:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L5a
        L58:
            r5 = r3
            goto La9
        L5a:
            java.util.Properties r3 = new java.util.Properties     // Catch: java.lang.Exception -> L77
            r3.<init>()     // Catch: java.lang.Exception -> L77
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L77
            java.io.File r6 = new java.io.File     // Catch: java.lang.Exception -> L77
            java.io.File r7 = android.os.Environment.getRootDirectory()     // Catch: java.lang.Exception -> L77
            java.lang.String r8 = "build.prop"
            r6.<init>(r7, r8)     // Catch: java.lang.Exception -> L77
            r4.<init>(r6)     // Catch: java.lang.Exception -> L77
            r3.load(r4)     // Catch: java.lang.Exception -> L77
            java.lang.String r3 = r3.getProperty(r9, r5)     // Catch: java.lang.Exception -> L77
            goto L79
        L77:
            r3 = r5
        L79:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L80
            goto L58
        L80:
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            if (r4 >= r6) goto L58
            java.lang.String r3 = "android.os.SystemProperties"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> La8
            java.lang.String r4 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> La8
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r1] = r7     // Catch: java.lang.Exception -> La8
            r6[r0] = r7     // Catch: java.lang.Exception -> La8
            java.lang.reflect.Method r4 = r3.getMethod(r4, r6)     // Catch: java.lang.Exception -> La8
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> La8
            r2[r1] = r9     // Catch: java.lang.Exception -> La8
            r2[r0] = r5     // Catch: java.lang.Exception -> La8
            java.lang.Object r9 = r4.invoke(r3, r2)     // Catch: java.lang.Exception -> La8
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Exception -> La8
            r5 = r9
            goto La9
        La8:
        La9:
            boolean r9 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r0 = "unknown"
            if (r9 != 0) goto Lb7
            boolean r9 = r5.equals(r0)
            if (r9 == 0) goto Lc5
        Lb7:
            java.lang.String r9 = android.os.Build.DISPLAY     // Catch: java.lang.Throwable -> Lc4
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Lc4
            if (r1 != 0) goto Lc5
            java.lang.String r5 = r9.toLowerCase()     // Catch: java.lang.Throwable -> Lc4
            goto Lc5
        Lc4:
        Lc5:
            boolean r9 = android.text.TextUtils.isEmpty(r5)
            if (r9 == 0) goto Lcc
            return r0
        Lcc:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.util.b.j(java.lang.String):java.lang.String");
    }

    public static int k(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static boolean l(float f4, float f5, Rect rect) {
        if (f4 >= rect.left && f4 <= rect.right && f5 >= rect.top && f5 <= rect.bottom) {
            return true;
        }
        return false;
    }

    public static boolean m(Context context) {
        Locale locale;
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = context.getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = context.getResources().getConfiguration().locale;
        }
        if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
            return true;
        }
        return false;
    }

    public static boolean n(String str, String[] strArr, String str2) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static void o(View view, boolean z3) {
        int i3;
        if (view != null) {
            if (z3) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }
}

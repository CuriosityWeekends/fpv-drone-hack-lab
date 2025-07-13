package com.bumptech.glide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class e implements e3.a {

    /* renamed from: a  reason: collision with root package name */
    public static int f241a = -1;
    public static boolean b = false;
    public static Class c = null;
    public static volatile boolean d = true;

    public static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static Drawable b(Context context, Context context2, int i3, Resources.Theme theme) {
        Context context3;
        try {
            if (d) {
                if (theme != null) {
                    context3 = new ContextThemeWrapper(context2, theme);
                } else {
                    context3 = context2;
                }
                return AppCompatResources.getDrawable(context3, i3);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e5) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i3);
            }
            throw e5;
        } catch (NoClassDefFoundError unused2) {
            d = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return ResourcesCompat.getDrawable(context2.getResources(), i3, theme);
    }

    public static int c(Context context) {
        int i3 = f241a;
        if (i3 != -1) {
            return i3;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            f241a = context.getResources().getDimensionPixelSize(identifier);
        }
        if (f241a < 0) {
            int i5 = 0;
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                i5 = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Exception unused) {
            } catch (Throwable th) {
                f241a = 0;
                throw th;
            }
            f241a = i5;
        }
        if (f241a < 0) {
            f241a = (int) ((25.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return f241a;
    }

    public static int d(int i3) {
        int i5 = 0;
        while (i3 > 0) {
            i5++;
            i3 >>>= 1;
        }
        return i5;
    }

    public static b3.e f(c0.b bVar, boolean z3, boolean z5) {
        if (z3) {
            i(3, bVar, false);
        }
        bVar.k((int) bVar.f());
        long f4 = bVar.f();
        String[] strArr = new String[(int) f4];
        for (int i3 = 0; i3 < f4; i3++) {
            strArr[i3] = bVar.k((int) bVar.f());
        }
        if (z5 && (bVar.n() & 1) == 0) {
            throw new IOException("framing bit expected to be set");
        }
        return new b3.e(26, strArr);
    }

    public static void g(Window window) {
        int i3;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 1024;
        window.setAttributes(attributes);
        if (!b) {
            i3 = 1542;
        } else {
            i3 = 1028;
        }
        window.getDecorView().setSystemUiVisibility(i3 | 4096);
    }

    public static void h(Window window) {
        ViewGroup viewGroup;
        int f4;
        View decorView = window.getDecorView();
        if (decorView == null) {
            viewGroup = null;
        } else {
            viewGroup = (ViewGroup) decorView.findViewWithTag("notch_container");
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup.getChildCount() == 0) {
            View view = new View(window.getContext());
            h3.b f5 = h3.b.f();
            if (f5.f2038a == null) {
                f5.a();
            }
            d dVar = f5.f2038a;
            if (dVar == null) {
                f4 = 0;
            } else {
                f4 = dVar.f(window);
            }
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, f4));
            view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            viewGroup.addView(view);
        }
        viewGroup.setVisibility(0);
    }

    public static boolean i(int i3, c0.b bVar, boolean z3) {
        if (bVar.a() < 7) {
            if (z3) {
                return false;
            }
            throw new IOException("too short header: " + bVar.a());
        } else if (bVar.n() != i3) {
            if (z3) {
                return false;
            }
            throw new IOException("expected header type " + Integer.toHexString(i3));
        } else if (bVar.n() == 118 && bVar.n() == 111 && bVar.n() == 114 && bVar.n() == 98 && bVar.n() == 105 && bVar.n() == 115) {
            return true;
        } else {
            if (z3) {
                return false;
            }
            throw new IOException("expected characters 'vorbis'");
        }
    }

    public abstract void e(int i3);
}

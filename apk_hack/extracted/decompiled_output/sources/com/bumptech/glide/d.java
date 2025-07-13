package com.bumptech.glide;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class d implements l1.l {

    /* renamed from: a  reason: collision with root package name */
    public static Class f240a;

    public static final p4.m a(View view) {
        j4.b.d(view, "$this$clicks");
        return new p4.m(view);
    }

    public static boolean g(Uri uri) {
        if (uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public static void i(Throwable th) {
        if (th == null) {
            th = r4.d.a("onError called with a null Throwable.");
        } else if (!(th instanceof j4.d) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof j4.c)) {
            th = new IllegalStateException("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | " + th, th);
        }
        th.printStackTrace();
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static long j(c0.b bVar, int i3, int i5) {
        bVar.y(i3);
        if (bVar.a() < 5) {
            return -9223372036854775807L;
        }
        int c = bVar.c();
        if ((8388608 & c) != 0 || ((2096896 & c) >> 8) != i5 || (c & 32) == 0 || bVar.n() < 7 || bVar.a() < 7 || (bVar.n() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        bVar.b(bArr, 0, 6);
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((bArr[4] & 255) >> 7);
    }

    public static c1.b k(c0.b bVar) {
        bVar.z(1);
        int p5 = bVar.p();
        long j2 = bVar.b + p5;
        int i3 = p5 / 18;
        long[] jArr = new long[i3];
        long[] jArr2 = new long[i3];
        int i5 = 0;
        while (true) {
            if (i5 >= i3) {
                break;
            }
            long h5 = bVar.h();
            if (h5 == -1) {
                jArr = Arrays.copyOf(jArr, i5);
                jArr2 = Arrays.copyOf(jArr2, i5);
                break;
            }
            jArr[i5] = h5;
            jArr2[i5] = bVar.h();
            bVar.z(2);
            i5++;
        }
        bVar.z((int) (j2 - bVar.b));
        return new c1.b(5, jArr, jArr2, false);
    }

    public static String l(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return simpleDateFormat.format(simpleDateFormat.parse(simpleDateFormat.format(valueOf)));
            } catch (ParseException e5) {
                e5.printStackTrace();
                return null;
            }
        } catch (NumberFormatException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public void b(Activity activity) {
        e.g(activity.getWindow());
    }

    public void c(Activity activity) {
        ViewGroup viewGroup;
        e.g(activity.getWindow());
        if (h(activity.getWindow())) {
            View decorView = activity.getWindow().getDecorView();
            if (decorView == null) {
                viewGroup = null;
            } else {
                viewGroup = (ViewGroup) decorView.findViewWithTag("notch_container");
            }
            if (viewGroup != null) {
                viewGroup.getChildCount();
                viewGroup.setVisibility(8);
            }
        }
    }

    public void d(Activity activity) {
        b(activity);
    }

    public void e(Activity activity) {
        e.g(activity.getWindow());
        f(activity.getWindow());
    }

    public abstract int f(Window window);

    public abstract boolean h(Window window);
}

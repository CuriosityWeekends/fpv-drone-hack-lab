package a1;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import j0.j0;
import j0.t0;
import j0.u0;
import java.util.HashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class i {
    public static /* synthetic */ String A(int i3) {
        switch (i3) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String B(int i3) {
        switch (i3) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static void a(j0 j0Var, u0 u0Var, int i3) {
        Object obj;
        if (u0Var.n() == 1) {
            obj = u0Var.m(0, new t0(), 0L).c;
        } else {
            obj = null;
        }
        j0Var.onTimelineChanged(u0Var, obj, i3);
    }

    public static float b(float f4, float f5, float f6, float f7) {
        return ((f4 - f5) * f6) + f7;
    }

    public static int c(int i3, int i5, int i6, int i7) {
        return ((i3 - i5) / i6) + i7;
    }

    public static int d(int i3, int i5, int i6, int i7, int i8) {
        return i8 - (((i3 - i5) * i6) / i7);
    }

    public static String e(int i3, String str) {
        return str + i3;
    }

    public static String f(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String g(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String h(String str, String str2) {
        return str + str2;
    }

    public static String i(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String j(StringBuilder sb, int i3, String str) {
        sb.append(i3);
        sb.append(str);
        return sb.toString();
    }

    public static String k(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder l(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder m(String str, int i3, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i3);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder n(String str, int i3, String str2, int i5, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i3);
        sb.append(str2);
        sb.append(i5);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder o(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder p(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void q(int i3, HashMap hashMap, String str, int i5, String str2) {
        hashMap.put(str, Integer.valueOf(i3));
        hashMap.put(str2, Integer.valueOf(i5));
    }

    public static void r(String str, int i3, String str2) {
        Log.w(str2, str + i3);
    }

    public static void s(String str, int i3, String str2, int i5, String str3) {
        Log.d(str3, str + i3 + str2 + i5);
    }

    public static void t(String str, String str2, String str3) {
        Log.w(str3, str + str2);
    }

    public static void u(StringBuilder sb, int i3, String str) {
        sb.append(i3);
        Log.d(str, sb.toString());
    }

    public static int v(int i3, int i5, int i6, int i7) {
        return ((i3 - i5) * i6) + i7;
    }

    public static String w(String str, String str2) {
        return str + str2;
    }

    public static void x(String str, int i3, String str2) {
        Log.d(str2, str + i3);
    }

    public static int y(int i3, int i5, int i6, int i7) {
        return i7 - ((i3 - i5) / i6);
    }

    public static /* synthetic */ String z(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? "null" : "MEMORY_CACHE" : "RESOURCE_DISK_CACHE" : "DATA_DISK_CACHE" : "REMOTE" : "LOCAL";
    }
}

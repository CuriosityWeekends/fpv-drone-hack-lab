package c0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f199a = "0123456789abcdef".toCharArray();
    public static final char[] b = new char[64];
    public static volatile Handler c;

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static int b(int i3, int i5, Bitmap.Config config) {
        int i6 = i3 * i5;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i7 = m.f198a[config.ordinal()];
        int i8 = 1;
        if (i7 != 1) {
            i8 = 2;
            if (i7 != 2 && i7 != 3) {
                i8 = 4;
                if (i7 == 4) {
                    i8 = 8;
                }
            }
        }
        return i6 * i8;
    }

    public static int c(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static ArrayList d(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Handler e() {
        if (c == null) {
            synchronized (n.class) {
                try {
                    if (c == null) {
                        c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static int f(int i3, int i5) {
        return (i5 * 31) + i3;
    }

    public static int g(int i3, Object obj) {
        int hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return f(hashCode, i3);
    }

    public static boolean h(int i3, int i5) {
        if ((i3 <= 0 && i3 != Integer.MIN_VALUE) || (i5 <= 0 && i5 != Integer.MIN_VALUE)) {
            return false;
        }
        return true;
    }
}

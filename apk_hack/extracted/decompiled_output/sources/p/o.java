package p;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o {

    /* renamed from: f  reason: collision with root package name */
    public static final g.g f3073f = g.g.a(g.a.c, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");

    /* renamed from: g  reason: collision with root package name */
    public static final g.g f3074g = g.g.a(g.i.f1899a, "com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* renamed from: h  reason: collision with root package name */
    public static final g.g f3075h;

    /* renamed from: i  reason: collision with root package name */
    public static final g.g f3076i;

    /* renamed from: j  reason: collision with root package name */
    public static final Set f3077j;

    /* renamed from: k  reason: collision with root package name */
    public static final j3.b f3078k;

    /* renamed from: l  reason: collision with root package name */
    public static final ArrayDeque f3079l;

    /* renamed from: a  reason: collision with root package name */
    public final j.b f3080a;
    public final DisplayMetrics b;
    public final j.g c;
    public final List d;

    /* renamed from: e  reason: collision with root package name */
    public final u f3081e = u.a();

    static {
        m mVar = m.b;
        Boolean bool = Boolean.FALSE;
        f3075h = g.g.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        f3076i = g.g.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        f3077j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f3078k = new j3.b(19);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = c0.n.f199a;
        f3079l = new ArrayDeque(0);
    }

    public o(ArrayList arrayList, DisplayMetrics displayMetrics, j.b bVar, j.g gVar) {
        this.d = arrayList;
        c0.g.c(displayMetrics, "Argument must not be null");
        this.b = displayMetrics;
        c0.g.c(bVar, "Argument must not be null");
        this.f3080a = bVar;
        c0.g.c(gVar, "Argument must not be null");
        this.c = gVar;
    }

    public static Bitmap c(i.b bVar, BitmapFactory.Options options, n nVar, j.b bVar2) {
        if (!options.inJustDecodeBounds) {
            nVar.m();
            bVar.p();
        }
        int i3 = options.outWidth;
        int i5 = options.outHeight;
        String str = options.outMimeType;
        Lock lock = y.b;
        lock.lock();
        try {
            try {
                Bitmap d = bVar.d(options);
                lock.unlock();
                return d;
            } catch (IllegalArgumentException e5) {
                StringBuilder n5 = a1.i.n("Exception decoding bitmap, outWidth: ", i3, ", outHeight: ", i5, ", outMimeType: ");
                n5.append(str);
                n5.append(", inBitmap: ");
                n5.append(d(options.inBitmap));
                IOException iOException = new IOException(n5.toString(), e5);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOException);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        bVar2.e(bitmap);
                        options.inBitmap = null;
                        Bitmap c = c(bVar, options, nVar, bVar2);
                        y.b.unlock();
                        return c;
                    } catch (IOException unused) {
                        throw iOException;
                    }
                }
                throw iOException;
            }
        } catch (Throwable th) {
            y.b.unlock();
            throw th;
        }
    }

    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void e(BitmapFactory.Options options) {
        f(options);
        ArrayDeque arrayDeque = f3079l;
        synchronized (arrayDeque) {
            arrayDeque.offer(options);
        }
    }

    public static void f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final c a(i.b bVar, int i3, int i5, g.h hVar, n nVar) {
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        boolean z3;
        byte[] bArr = (byte[]) this.c.d(byte[].class, 65536);
        synchronized (o.class) {
            ArrayDeque arrayDeque = f3079l;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                f(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        g.a aVar = (g.a) hVar.c(f3073f);
        g.i iVar = (g.i) hVar.c(f3074g);
        m mVar = (m) hVar.c(m.f3070g);
        boolean booleanValue = ((Boolean) hVar.c(f3075h)).booleanValue();
        g.g gVar = f3076i;
        if (hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue()) {
            z3 = true;
        } else {
            z3 = false;
        }
        try {
            return c.b(b(bVar, options2, mVar, aVar, iVar, z3, i3, i5, booleanValue, nVar), this.f3080a);
        } finally {
            e(options2);
            this.c.h(bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0357 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(i.b r38, android.graphics.BitmapFactory.Options r39, p.m r40, g.a r41, g.i r42, boolean r43, int r44, int r45, boolean r46, p.n r47) {
        /*
            Method dump skipped, instructions count: 1466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.o.b(i.b, android.graphics.BitmapFactory$Options, p.m, g.a, g.i, boolean, int, int, boolean, p.n):android.graphics.Bitmap");
    }
}

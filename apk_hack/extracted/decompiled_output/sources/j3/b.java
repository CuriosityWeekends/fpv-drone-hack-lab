package j3;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.d;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.lg.picturesubmitt.MyApplication;
import d0.c;
import d0.f;
import e2.e;
import e2.h;
import e2.h0;
import e2.i;
import g.k;
import g2.w;
import i.f0;
import i.g0;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import l1.l;
import p.c0;
import p.d0;
import p.n;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements f, h, g.f, c, k.a, l, l2.l, h0, k4.a, n, d0, s3.b, k, g3.a {
    public static Method b;
    public static b c;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2482a;

    public /* synthetic */ b(int i3) {
        this.f2482a = i3;
    }

    public static String n(String str) {
        try {
            Method method = b;
            Object obj = null;
            if (method != null) {
                obj = method.invoke(null, str);
            }
            String str2 = (String) obj;
            if (str2 != null) {
                return str2.trim();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static b o() {
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = new b();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    @Override // k4.a
    public void accept(Object obj) {
        switch (this.f2482a) {
            case 16:
                return;
            default:
                Throwable th = (Throwable) obj;
                String str = "The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + th;
                if (th == null) {
                    th = new NullPointerException();
                }
                d.i(new RuntimeException(str, th));
                return;
        }
    }

    @Override // p.d0
    public void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        switch (this.f2482a) {
            case 20:
                mediaMetadataRetriever.setDataSource(new c0((ByteBuffer) obj));
                return;
            default:
                mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
                return;
        }
    }

    @Override // e2.h
    public i createDataSource() {
        switch (this.f2482a) {
            case 3:
                return new e(false);
            default:
                return new o0.a();
        }
    }

    @Override // k.a
    public File d(g.e eVar) {
        return null;
    }

    @Override // e2.h0
    public Object f(Uri uri, e2.k kVar) {
        return Long.valueOf(w.y(new BufferedReader(new InputStreamReader(kVar)).readLine()));
    }

    @Override // d0.c
    public Object g() {
        return new f0();
    }

    @Override // g.k
    public int h(g.h hVar) {
        return 1;
    }

    @Override // g3.a
    public void i() {
        MyApplication.f541h = true;
    }

    @Override // g.b
    public boolean k(Object obj, File file, g.h hVar) {
        try {
            c0.c.b(((GifDrawable) ((g0) obj).get()).f267a.f3551a.f3557a.d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e5) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e5);
            }
            return false;
        }
    }

    public String toString() {
        switch (this.f2482a) {
            case 16:
                return "EmptyConsumer";
            default:
                return super.toString();
        }
    }

    @Override // l2.l
    public Object x() {
        switch (this.f2482a) {
            case 11:
                return new TreeMap();
            case 12:
                return new l2.k();
            case 13:
                return new LinkedHashSet();
            default:
                return new ArrayList();
        }
    }

    public b() {
        Class<?> cls;
        this.f2482a = 0;
        Method method = null;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException e5) {
            Log.e("b", e5.getMessage());
            try {
                cls = ClassLoader.getSystemClassLoader().loadClass("android.os.SystemProperties");
            } catch (ClassNotFoundException e6) {
                Log.e("b", e6.getMessage());
                cls = null;
            }
        }
        if (cls != null) {
            try {
                method = cls.getMethod("get", String.class);
            } catch (Exception e7) {
                Log.e("b", e7.getMessage());
            }
        }
        b = method;
    }

    private final void j(Object obj) {
    }

    @Override // d0.f
    public void a(Object obj) {
    }

    @Override // p.n
    public void m() {
    }

    @Override // k.a
    public void e(g.e eVar, i.b bVar) {
    }

    @Override // p.n
    public void l(Bitmap bitmap, j.b bVar) {
    }

    @Override // g.f
    public void c(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }
}

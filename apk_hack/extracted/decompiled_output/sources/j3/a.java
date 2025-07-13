package j3;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.lg.picturesubmitt.MyApplication;
import d0.c;
import e2.e0;
import e2.g0;
import e2.w;
import j0.f0;
import j0.j;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import k.h;
import l2.l;
import m.a0;
import m.f;
import m.q;
import m.r;
import m.y;
import p.d0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class a implements g0, j.b, j, c, l, k4.b, r, d0, p0.c, g3.a {
    public static a b;
    public static a c;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2481a;

    public /* synthetic */ a(int i3) {
        this.f2481a = i3;
    }

    public static long k(IOException iOException) {
        if (!(iOException instanceof w)) {
            return -9223372036854775807L;
        }
        int i3 = ((w) iOException).f1754a;
        if (i3 != 404 && i3 != 410 && i3 != 416) {
            return -9223372036854775807L;
        }
        return 60000L;
    }

    public static long m(int i3, IOException iOException) {
        if (!(iOException instanceof f0) && !(iOException instanceof FileNotFoundException) && !(iOException instanceof e0)) {
            return Math.min((i3 - 1) * 1000, 5000);
        }
        return -9223372036854775807L;
    }

    @Override // p.d0
    public void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    @Override // j.b
    public Bitmap c(int i3, int i5, Bitmap.Config config) {
        return Bitmap.createBitmap(i3, i5, config);
    }

    @Override // j.b
    public Bitmap d(int i3, int i5, Bitmap.Config config) {
        return Bitmap.createBitmap(i3, i5, config);
    }

    @Override // j.b
    public void e(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // d0.c
    public Object g() {
        try {
            return new h(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // g3.a
    public void i() {
        MyApplication.f541h = true;
    }

    public int l(int i3) {
        if (i3 == 7) {
            return 6;
        }
        return 3;
    }

    @Override // m.r
    public q n(y yVar) {
        return new a0(yVar.c(f.class, InputStream.class), 1);
    }

    public String toString() {
        switch (this.f2481a) {
            case 16:
                return "EmptyAction";
            case 17:
                return "IdentityFunction";
            default:
                return super.toString();
        }
    }

    @Override // l2.l
    public Object x() {
        switch (this.f2481a) {
            case 11:
                return new ConcurrentHashMap();
            case 12:
                return new LinkedHashMap();
            case 13:
                return new TreeSet();
            case 14:
                return new ArrayDeque();
            default:
                return new ConcurrentSkipListMap();
        }
    }

    @Override // e2.g0
    public void a() {
    }

    @Override // k4.b
    public Object apply(Object obj) {
        return obj;
    }

    @Override // p0.c
    public long f(long j2) {
        return j2;
    }

    @Override // j.b
    public void h(int i3) {
    }

    @Override // j.b
    public void j() {
    }
}

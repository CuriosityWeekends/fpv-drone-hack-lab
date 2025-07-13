package j;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import c0.n;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements b {

    /* renamed from: j  reason: collision with root package name */
    public static final Bitmap.Config f2190j = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    public final i f2191a;
    public final Set b;
    public final j3.b c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public long f2192e;

    /* renamed from: f  reason: collision with root package name */
    public int f2193f;

    /* renamed from: g  reason: collision with root package name */
    public int f2194g;

    /* renamed from: h  reason: collision with root package name */
    public int f2195h;

    /* renamed from: i  reason: collision with root package name */
    public int f2196i;

    public h(long j2) {
        Bitmap.Config config;
        m mVar = new m();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i3 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i3 >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.d = j2;
        this.f2191a = mVar;
        this.b = unmodifiableSet;
        this.c = new j3.b(7);
    }

    public final void a() {
        Log.v("LruBitmapPool", "Hits=" + this.f2193f + ", misses=" + this.f2194g + ", puts=" + this.f2195h + ", evictions=" + this.f2196i + ", currentSize=" + this.f2192e + ", maxSize=" + this.d + "\nStrategy=" + this.f2191a);
    }

    public final synchronized Bitmap b(int i3, int i5, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3;
        Bitmap b;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                config2 = Bitmap.Config.HARDWARE;
                if (config == config2) {
                    throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
                }
            }
            i iVar = this.f2191a;
            if (config != null) {
                config3 = config;
            } else {
                config3 = f2190j;
            }
            b = ((m) iVar).b(i3, i5, config3);
            if (b == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder("Missing bitmap=");
                    ((m) this.f2191a).getClass();
                    sb.append(m.c(n.b(i3, i5, config), config));
                    Log.d("LruBitmapPool", sb.toString());
                }
                this.f2194g++;
            } else {
                this.f2193f++;
                long j2 = this.f2192e;
                ((m) this.f2191a).getClass();
                this.f2192e = j2 - n.c(b);
                this.c.getClass();
                b.setHasAlpha(true);
                b.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Get bitmap=");
                ((m) this.f2191a).getClass();
                sb2.append(m.c(n.b(i3, i5, config), config));
                Log.v("LruBitmapPool", sb2.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    @Override // j.b
    public final Bitmap c(int i3, int i5, Bitmap.Config config) {
        Bitmap b = b(i3, i5, config);
        if (b == null) {
            if (config == null) {
                config = f2190j;
            }
            return Bitmap.createBitmap(i3, i5, config);
        }
        return b;
    }

    @Override // j.b
    public final Bitmap d(int i3, int i5, Bitmap.Config config) {
        Bitmap b = b(i3, i5, config);
        if (b != null) {
            b.eraseColor(0);
            return b;
        }
        if (config == null) {
            config = f2190j;
        }
        return Bitmap.createBitmap(i3, i5, config);
    }

    @Override // j.b
    public final synchronized void e(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable()) {
                        ((m) this.f2191a).getClass();
                        if (n.c(bitmap) <= this.d && this.b.contains(bitmap.getConfig())) {
                            ((m) this.f2191a).getClass();
                            int c = n.c(bitmap);
                            ((m) this.f2191a).e(bitmap);
                            this.c.getClass();
                            this.f2195h++;
                            this.f2192e += c;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                StringBuilder sb = new StringBuilder("Put bitmap in pool=");
                                ((m) this.f2191a).getClass();
                                sb.append(m.c(n.c(bitmap), bitmap.getConfig()));
                                Log.v("LruBitmapPool", sb.toString());
                            }
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                a();
                            }
                            f(this.d);
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder("Reject bitmap from pool, bitmap: ");
                        ((m) this.f2191a).getClass();
                        sb2.append(m.c(n.c(bitmap), bitmap.getConfig()));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.b.contains(bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb2.toString());
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void f(long j2) {
        while (this.f2192e > j2) {
            try {
                m mVar = (m) this.f2191a;
                Bitmap bitmap = (Bitmap) mVar.b.x();
                if (bitmap != null) {
                    mVar.a(Integer.valueOf(n.c(bitmap)), bitmap);
                }
                if (bitmap == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        a();
                    }
                    this.f2192e = 0L;
                    return;
                }
                this.c.getClass();
                long j5 = this.f2192e;
                ((m) this.f2191a).getClass();
                this.f2192e = j5 - n.c(bitmap);
                this.f2196i++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    ((m) this.f2191a).getClass();
                    sb.append(m.c(n.c(bitmap), bitmap.getConfig()));
                    Log.d("LruBitmapPool", sb.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    a();
                }
                bitmap.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j.b
    public final void h(int i3) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            a1.i.x("trimMemory, level=", i3, "LruBitmapPool");
        }
        if (i3 < 40 && (Build.VERSION.SDK_INT < 23 || i3 < 20)) {
            if (i3 >= 20 || i3 == 15) {
                f(this.d / 2);
                return;
            }
            return;
        }
        j();
    }

    @Override // j.b
    public final void j() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        f(0L);
    }
}

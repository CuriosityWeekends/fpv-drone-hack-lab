package f;

import android.graphics.Bitmap;
import j.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int[] f1783a;
    public final c1.b c;
    public ByteBuffer d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f1784e;

    /* renamed from: f  reason: collision with root package name */
    public short[] f1785f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f1786g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f1787h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f1788i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f1789j;

    /* renamed from: k  reason: collision with root package name */
    public int f1790k;

    /* renamed from: l  reason: collision with root package name */
    public b f1791l;

    /* renamed from: m  reason: collision with root package name */
    public Bitmap f1792m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f1793n;

    /* renamed from: o  reason: collision with root package name */
    public int f1794o;

    /* renamed from: p  reason: collision with root package name */
    public final int f1795p;
    public final int q;

    /* renamed from: r  reason: collision with root package name */
    public final int f1796r;
    public Boolean s;
    public final int[] b = new int[256];

    /* renamed from: t  reason: collision with root package name */
    public Bitmap.Config f1797t = Bitmap.Config.ARGB_8888;

    public d(c1.b bVar, b bVar2, ByteBuffer byteBuffer, int i3) {
        byte[] bArr;
        int[] iArr;
        this.c = bVar;
        this.f1791l = new b();
        synchronized (this) {
            try {
                if (i3 > 0) {
                    int highestOneBit = Integer.highestOneBit(i3);
                    this.f1794o = 0;
                    this.f1791l = bVar2;
                    this.f1790k = -1;
                    ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                    this.d = asReadOnlyBuffer;
                    asReadOnlyBuffer.position(0);
                    this.d.order(ByteOrder.LITTLE_ENDIAN);
                    this.f1793n = false;
                    Iterator it = bVar2.f1775e.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((a) it.next()).f1769g == 3) {
                            this.f1793n = true;
                            break;
                        }
                    }
                    this.f1795p = highestOneBit;
                    int i5 = bVar2.f1776f;
                    this.f1796r = i5 / highestOneBit;
                    int i6 = bVar2.f1777g;
                    this.q = i6 / highestOneBit;
                    int i7 = i5 * i6;
                    g gVar = (g) this.c.c;
                    if (gVar == null) {
                        bArr = new byte[i7];
                    } else {
                        bArr = (byte[]) gVar.d(byte[].class, i7);
                    }
                    this.f1788i = bArr;
                    c1.b bVar3 = this.c;
                    int i8 = this.f1796r * this.q;
                    g gVar2 = (g) bVar3.c;
                    if (gVar2 == null) {
                        iArr = new int[i8];
                    } else {
                        iArr = (int[]) gVar2.d(int[].class, i8);
                    }
                    this.f1789j = iArr;
                } else {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap a() {
        Bitmap.Config config;
        Boolean bool = this.s;
        if (bool != null && !bool.booleanValue()) {
            config = this.f1797t;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap c = ((j.b) this.c.b).c(this.f1796r, this.q, config);
        c.setHasAlpha(true);
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0051 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:15:0x0040, B:20:0x004a, B:22:0x0051, B:24:0x005b, B:26:0x0066, B:25:0x005e, B:27:0x0068, B:29:0x0079, B:31:0x0085, B:35:0x008e, B:37:0x0092, B:39:0x009a, B:40:0x00ad, B:43:0x00b1, B:45:0x00b5, B:47:0x00c7, B:49:0x00cb, B:50:0x00cf, B:34:0x008a, B:53:0x00d5, B:55:0x00dd, B:11:0x0017, B:13:0x001f, B:14:0x003e), top: B:60:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:15:0x0040, B:20:0x004a, B:22:0x0051, B:24:0x005b, B:26:0x0066, B:25:0x005e, B:27:0x0068, B:29:0x0079, B:31:0x0085, B:35:0x008e, B:37:0x0092, B:39:0x009a, B:40:0x00ad, B:43:0x00b1, B:45:0x00b5, B:47:0x00c7, B:49:0x00cb, B:50:0x00cf, B:34:0x008a, B:53:0x00d5, B:55:0x00dd, B:11:0x0017, B:13:0x001f, B:14:0x003e), top: B:60:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008a A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:15:0x0040, B:20:0x004a, B:22:0x0051, B:24:0x005b, B:26:0x0066, B:25:0x005e, B:27:0x0068, B:29:0x0079, B:31:0x0085, B:35:0x008e, B:37:0x0092, B:39:0x009a, B:40:0x00ad, B:43:0x00b1, B:45:0x00b5, B:47:0x00c7, B:49:0x00cb, B:50:0x00cf, B:34:0x008a, B:53:0x00d5, B:55:0x00dd, B:11:0x0017, B:13:0x001f, B:14:0x003e), top: B:60:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:15:0x0040, B:20:0x004a, B:22:0x0051, B:24:0x005b, B:26:0x0066, B:25:0x005e, B:27:0x0068, B:29:0x0079, B:31:0x0085, B:35:0x008e, B:37:0x0092, B:39:0x009a, B:40:0x00ad, B:43:0x00b1, B:45:0x00b5, B:47:0x00c7, B:49:0x00cb, B:50:0x00cf, B:34:0x008a, B:53:0x00d5, B:55:0x00dd, B:11:0x0017, B:13:0x001f, B:14:0x003e), top: B:60:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1 A[Catch: all -> 0x0014, TRY_ENTER, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:15:0x0040, B:20:0x004a, B:22:0x0051, B:24:0x005b, B:26:0x0066, B:25:0x005e, B:27:0x0068, B:29:0x0079, B:31:0x0085, B:35:0x008e, B:37:0x0092, B:39:0x009a, B:40:0x00ad, B:43:0x00b1, B:45:0x00b5, B:47:0x00c7, B:49:0x00cb, B:50:0x00cf, B:34:0x008a, B:53:0x00d5, B:55:0x00dd, B:11:0x0017, B:13:0x001f, B:14:0x003e), top: B:60:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dd A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0007, B:6:0x000f, B:15:0x0040, B:20:0x004a, B:22:0x0051, B:24:0x005b, B:26:0x0066, B:25:0x005e, B:27:0x0068, B:29:0x0079, B:31:0x0085, B:35:0x008e, B:37:0x0092, B:39:0x009a, B:40:0x00ad, B:43:0x00b1, B:45:0x00b5, B:47:0x00c7, B:49:0x00cb, B:50:0x00cf, B:34:0x008a, B:53:0x00d5, B:55:0x00dd, B:11:0x0017, B:13:0x001f, B:14:0x003e), top: B:60:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized android.graphics.Bitmap b() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.d.b():android.graphics.Bitmap");
    }

    public final void c(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config != config3 && config != (config2 = Bitmap.Config.RGB_565)) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
        }
        this.f1797t = config;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
        if (r3.f1780j == r34.f1770h) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap d(f.a r34, f.a r35) {
        /*
            Method dump skipped, instructions count: 1079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.d.d(f.a, f.a):android.graphics.Bitmap");
    }
}

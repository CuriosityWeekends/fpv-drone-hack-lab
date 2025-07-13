package t;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import g.j;
import i.g0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements j {

    /* renamed from: f  reason: collision with root package name */
    public static final j3.a f3547f = new j3.a(24);

    /* renamed from: g  reason: collision with root package name */
    public static final k.c f3548g = new k.c(1);

    /* renamed from: a  reason: collision with root package name */
    public final Context f3549a;
    public final List b;
    public final k.c c;
    public final j3.a d;

    /* renamed from: e  reason: collision with root package name */
    public final c1.b f3550e;

    public a(Context context, ArrayList arrayList, j.b bVar, j.g gVar) {
        j3.a aVar = f3547f;
        this.f3549a = context.getApplicationContext();
        this.b = arrayList;
        this.d = aVar;
        this.f3550e = new c1.b(19, bVar, gVar, false);
        this.c = f3548g;
    }

    public static int d(f.b bVar, int i3, int i5) {
        int highestOneBit;
        int min = Math.min(bVar.f1777g / i5, bVar.f1776f / i3);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        int max = Math.max(1, highestOneBit);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            StringBuilder n5 = a1.i.n("Downsampling GIF, sampleSize: ", max, ", target dimens: [", i3, "x");
            n5.append(i5);
            n5.append("], actual dimens: [");
            n5.append(bVar.f1776f);
            n5.append("x");
            n5.append(bVar.f1777g);
            n5.append("]");
            Log.v("BufferGifDecoder", n5.toString());
        }
        return max;
    }

    @Override // g.j
    public final g0 a(Object obj, int i3, int i5, g.h hVar) {
        f.c cVar;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        k.c cVar2 = this.c;
        synchronized (cVar2) {
            try {
                f.c cVar3 = (f.c) cVar2.f2486a.poll();
                if (cVar3 == null) {
                    cVar3 = new f.c();
                }
                cVar = cVar3;
                cVar.b = null;
                Arrays.fill(cVar.f1782a, (byte) 0);
                cVar.c = new f.b();
                cVar.d = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                cVar.b = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                cVar.b.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            return c(byteBuffer, i3, i5, cVar, hVar);
        } finally {
            this.c.c(cVar);
        }
    }

    @Override // g.j
    public final boolean b(Object obj, g.h hVar) {
        ImageHeaderParser$ImageType imageHeaderParser$ImageType;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (((Boolean) hVar.c(h.b)).booleanValue()) {
            return false;
        }
        if (byteBuffer == null) {
            imageHeaderParser$ImageType = ImageHeaderParser$ImageType.UNKNOWN;
        } else {
            List list = this.b;
            int size = list.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    ImageHeaderParser$ImageType a5 = ((g.d) list.get(i3)).a(byteBuffer);
                    if (a5 != ImageHeaderParser$ImageType.UNKNOWN) {
                        imageHeaderParser$ImageType = a5;
                        break;
                    }
                    i3++;
                } else {
                    imageHeaderParser$ImageType = ImageHeaderParser$ImageType.UNKNOWN;
                    break;
                }
            }
        }
        if (imageHeaderParser$ImageType != ImageHeaderParser$ImageType.GIF) {
            return false;
        }
        return true;
    }

    public final r.a c(ByteBuffer byteBuffer, int i3, int i5, f.c cVar, g.h hVar) {
        Bitmap.Config config;
        int i6 = c0.h.b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int i7 = 2;
        try {
            f.b b = cVar.b();
            if (b.c > 0 && b.b == 0) {
                if (hVar.c(h.f3570a) == g.a.b) {
                    try {
                        config = Bitmap.Config.RGB_565;
                    } catch (Throwable th) {
                        th = th;
                        if (Log.isLoggable("BufferGifDecoder", i7)) {
                            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + c0.h.a(elapsedRealtimeNanos));
                        }
                        throw th;
                    }
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                int d = d(b, i3, i5);
                j3.a aVar = this.d;
                c1.b bVar = this.f3550e;
                aVar.getClass();
                f.d dVar = new f.d(bVar, b, byteBuffer, d);
                dVar.c(config);
                dVar.f1790k = (dVar.f1790k + 1) % dVar.f1791l.c;
                Bitmap b5 = dVar.b();
                if (b5 == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + c0.h.a(elapsedRealtimeNanos));
                    }
                    return null;
                }
                r.a aVar2 = new r.a(new GifDrawable(new b(new g(com.bumptech.glide.b.b(this.f3549a), dVar, i3, i5, b5))), 1);
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + c0.h.a(elapsedRealtimeNanos));
                }
                return aVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + c0.h.a(elapsedRealtimeNanos));
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            i7 = 2;
        }
    }
}

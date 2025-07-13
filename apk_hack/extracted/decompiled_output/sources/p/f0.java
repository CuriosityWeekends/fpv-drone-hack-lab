package p;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import i.g0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f0 implements g.j {
    public static final g.g d = new g.g("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new i(2));

    /* renamed from: e  reason: collision with root package name */
    public static final g.g f3063e = new g.g("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new i(3));

    /* renamed from: f  reason: collision with root package name */
    public static final j3.a f3064f = new j3.a(21);

    /* renamed from: a  reason: collision with root package name */
    public final d0 f3065a;
    public final j.b b;
    public final j3.a c = f3064f;

    public f0(j.b bVar, d0 d0Var) {
        this.b = bVar;
        this.f3065a = d0Var;
    }

    public static Bitmap c(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i3, int i5, int i6, m mVar) {
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 27 && i5 != Integer.MIN_VALUE && i6 != Integer.MIN_VALUE && mVar != m.f3068e) {
            try {
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    parseInt2 = parseInt;
                    parseInt = parseInt2;
                }
                float b = mVar.b(parseInt, parseInt2, i5, i6);
                bitmap = mediaMetadataRetriever.getScaledFrameAtTime(j2, i3, Math.round(parseInt * b), Math.round(b * parseInt2));
            } catch (Throwable th) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
                }
            }
        }
        if (bitmap == null) {
            bitmap = mediaMetadataRetriever.getFrameAtTime(j2, i3);
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new RuntimeException("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
    }

    @Override // g.j
    public final g0 a(Object obj, int i3, int i5, g.h hVar) {
        long longValue = ((Long) hVar.c(d)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) hVar.c(f3063e);
        if (num == null) {
            num = 2;
        }
        m mVar = (m) hVar.c(m.f3070g);
        if (mVar == null) {
            mVar = m.f3069f;
        }
        m mVar2 = mVar;
        this.c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.f3065a.b(mediaMetadataRetriever, obj);
            Bitmap c = c(mediaMetadataRetriever, longValue, num.intValue(), i3, i5, mVar2);
            mediaMetadataRetriever.release();
            return c.b(c, this.b);
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    @Override // g.j
    public final boolean b(Object obj, g.h hVar) {
        return true;
    }
}

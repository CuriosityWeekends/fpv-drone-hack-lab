package com.bumptech.glide;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.media.MediaFormat;
import android.media.SoundPool;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p.w;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static Context f239a;
    public static SoundPool b;

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
        if (r12 == r19.f1926f) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0093, code lost:
        if ((r18.n() * 1000) == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a2, code lost:
        if (r6 == r1) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(c0.b r18, g2.i r19, int r20, p0.m r21) {
        /*
            Method dump skipped, instructions count: 194
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.a(c0.b, g2.i, int, p0.m):boolean");
    }

    public static void b(long j2, c0.b bVar, u[] uVarArr) {
        int i3;
        int i5;
        boolean z3;
        while (true) {
            boolean z5 = true;
            if (bVar.a() > 1) {
                int i6 = 0;
                while (true) {
                    if (bVar.a() == 0) {
                        i3 = -1;
                        break;
                    }
                    int n5 = bVar.n();
                    i6 += n5;
                    if (n5 != 255) {
                        i3 = i6;
                        break;
                    }
                }
                int i7 = 0;
                while (true) {
                    if (bVar.a() == 0) {
                        i7 = -1;
                        break;
                    }
                    int n6 = bVar.n();
                    i7 += n6;
                    if (n6 != 255) {
                        break;
                    }
                }
                int i8 = bVar.b + i7;
                if (i7 != -1 && i7 <= bVar.a()) {
                    if (i3 == 4 && i7 >= 8) {
                        int n7 = bVar.n();
                        int s = bVar.s();
                        if (s == 49) {
                            i5 = bVar.c();
                        } else {
                            i5 = 0;
                        }
                        int n8 = bVar.n();
                        if (s == 47) {
                            bVar.z(1);
                        }
                        if (n7 == 181 && ((s == 49 || s == 47) && n8 == 3)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (s == 49) {
                            if (i5 != 1195456820) {
                                z5 = false;
                            }
                            z3 &= z5;
                        }
                        if (z3) {
                            c(j2, bVar, uVarArr);
                        }
                    }
                } else {
                    Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    i8 = bVar.c;
                }
                bVar.y(i8);
            } else {
                return;
            }
        }
    }

    public static void c(long j2, c0.b bVar, u[] uVarArr) {
        int n5 = bVar.n();
        if ((n5 & 64) != 0) {
            bVar.z(1);
            int i3 = (n5 & 31) * 3;
            int i5 = bVar.b;
            for (u uVar : uVarArr) {
                bVar.y(i5);
                uVar.b(i3, bVar);
                uVar.c(j2, 1, i3, 0, null);
            }
        }
    }

    public static byte[] d(Image image) {
        int i3;
        int v5;
        int format = image.getFormat();
        if (format != 17 && format != 35 && format != 842094169) {
            throw new RuntimeException("can't convert Image to byte array, format " + image.getFormat());
        }
        Rect cropRect = image.getCropRect();
        int format2 = image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i5 = width * height;
        byte[] bArr = new byte[(ImageFormat.getBitsPerPixel(format2) * i5) / 8];
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        Log.d("yocn", "get data from " + planes.length + " planes");
        int i6 = 0;
        int i7 = 0;
        while (i6 < planes.length) {
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        i7 = (int) (i5 * 1.25d);
                    }
                } else {
                    i7 = i5;
                }
            } else {
                i7 = 0;
            }
            ByteBuffer buffer = planes[i6].getBuffer();
            int rowStride = planes[i6].getRowStride();
            int pixelStride = planes[i6].getPixelStride();
            Log.v("", "pixelStride " + pixelStride);
            Log.v("", "rowStride " + rowStride);
            Log.v("", "width " + width);
            Log.v("", "height " + height);
            Log.v("", "buffer size " + buffer.remaining());
            if (i6 == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            int i8 = width >> i3;
            int i9 = height >> i3;
            int i10 = width;
            int i11 = height;
            buffer.position(((cropRect.left >> i3) * pixelStride) + ((cropRect.top >> i3) * rowStride));
            for (int i12 = 0; i12 < i9; i12++) {
                if (pixelStride == 1) {
                    buffer.get(bArr, i7, i8);
                    i7 += i8;
                    v5 = i8;
                } else {
                    v5 = a1.i.v(i8, 1, pixelStride, 1);
                    buffer.get(bArr2, 0, v5);
                    for (int i13 = 0; i13 < i8; i13++) {
                        bArr[i7] = bArr2[i13 * pixelStride];
                        i7++;
                    }
                }
                if (i12 < i9 - 1) {
                    buffer.position((buffer.position() + rowStride) - v5);
                }
            }
            Log.v("", "Finished reading data from plane " + i6);
            i6++;
            width = i10;
            height = i11;
        }
        return bArr;
    }

    public static int e(j.g gVar, InputStream inputStream, List list) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new w(inputStream, gVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                int b5 = ((g.d) list.get(i3)).b(inputStream, gVar);
                if (b5 != -1) {
                    return b5;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType f(j.g gVar, InputStream inputStream, List list) {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new w(inputStream, gVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                ImageHeaderParser$ImageType c = ((g.d) list.get(i3)).c(inputStream);
                inputStream.reset();
                if (c != ImageHeaderParser$ImageType.UNKNOWN) {
                    return c;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static void g(MediaFormat mediaFormat, String str, int i3) {
        if (i3 != -1) {
            mediaFormat.setInteger(str, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList h(c0.b r28) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.h(c0.b):java.util.ArrayList");
    }

    public static void i(Context context, int i3) {
        if (b == null) {
            b = new SoundPool.Builder().setMaxStreams(3).build();
        }
        SoundPool soundPool = b;
        soundPool.setOnLoadCompleteListener(new w2.b(soundPool.load(context, i3, 1)));
    }

    public static int j(int i3, c0.b bVar) {
        switch (i3) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i3 - 2);
            case 6:
                return bVar.n() + 1;
            case 7:
                return bVar.s() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i3 - 8);
            default:
                return -1;
        }
    }

    public static void k(MediaFormat mediaFormat, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            mediaFormat.setByteBuffer(a1.i.e(i3, "csd-"), ByteBuffer.wrap((byte[]) list.get(i3)));
        }
    }

    public static void l(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (!(th instanceof LinkageError)) {
                    return;
                }
                throw ((LinkageError) th);
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}

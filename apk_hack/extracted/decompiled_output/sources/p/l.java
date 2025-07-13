package p;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l implements g.d {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3067a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static ImageHeaderParser$ImageType d(k kVar) {
        try {
            int m5 = kVar.m();
            if (m5 == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int g5 = (m5 << 8) | kVar.g();
            if (g5 == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int g6 = (g5 << 8) | kVar.g();
            if (g6 == -1991225785) {
                kVar.skip(21L);
                try {
                    if (kVar.g() >= 3) {
                        return ImageHeaderParser$ImageType.PNG_A;
                    }
                    return ImageHeaderParser$ImageType.PNG;
                } catch (j unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            } else if (g6 != 1380533830) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            } else {
                kVar.skip(4L);
                if (((kVar.m() << 16) | kVar.m()) != 1464156752) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int m6 = (kVar.m() << 16) | kVar.m();
                if ((m6 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int i3 = m6 & 255;
                if (i3 == 88) {
                    kVar.skip(4L);
                    if ((kVar.g() & 16) != 0) {
                        return ImageHeaderParser$ImageType.WEBP_A;
                    }
                    return ImageHeaderParser$ImageType.WEBP;
                } else if (i3 == 76) {
                    kVar.skip(4L);
                    if ((kVar.g() & 8) != 0) {
                        return ImageHeaderParser$ImageType.WEBP_A;
                    }
                    return ImageHeaderParser$ImageType.WEBP;
                } else {
                    return ImageHeaderParser$ImageType.WEBP;
                }
            }
        } catch (j unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public static int e(b3.e eVar) {
        short g5;
        int m5;
        long j2;
        long skip;
        do {
            short g6 = eVar.g();
            if (g6 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    a1.i.x("Unknown segmentId=", g6, "DfltImageHeaderParser");
                }
                return -1;
            }
            g5 = eVar.g();
            if (g5 == 218) {
                return -1;
            }
            if (g5 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            m5 = eVar.m() - 2;
            if (g5 != 225) {
                j2 = m5;
                skip = eVar.skip(j2);
            } else {
                return m5;
            }
        } while (skip == j2);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder n5 = a1.i.n("Unable to skip enough data, type: ", g5, ", wanted to skip: ", m5, ", but actually skipped: ");
            n5.append(skip);
            Log.d("DfltImageHeaderParser", n5.toString());
        }
        return -1;
    }

    public static int f(b3.e eVar, byte[] bArr, int i3) {
        boolean z3;
        ByteOrder byteOrder;
        int i5;
        String str;
        int i6;
        int G = eVar.G(bArr, i3);
        if (G != i3) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                a1.i.s("Unable to read exif segment data, length: ", i3, ", actually read: ", G, "DfltImageHeaderParser");
            }
            return -1;
        }
        short s = 1;
        int i7 = 0;
        byte[] bArr2 = f3067a;
        if (bArr != null && i3 > bArr2.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            int i8 = 0;
            while (true) {
                if (i8 >= bArr2.length) {
                    break;
                } else if (bArr[i8] != bArr2[i8]) {
                    z3 = false;
                    break;
                } else {
                    i8++;
                }
            }
        }
        if (z3) {
            i iVar = new i(bArr, i3);
            short d = iVar.d(6);
            if (d != 18761) {
                if (d != 19789) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        a1.i.x("Unknown endianness = ", d, "DfltImageHeaderParser");
                    }
                    byteOrder = ByteOrder.BIG_ENDIAN;
                } else {
                    byteOrder = ByteOrder.BIG_ENDIAN;
                }
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            ByteBuffer byteBuffer = iVar.b;
            byteBuffer.order(byteOrder);
            if (byteBuffer.remaining() - 10 >= 4) {
                i5 = byteBuffer.getInt(10);
            } else {
                i5 = -1;
            }
            short d5 = iVar.d(i5 + 6);
            while (i7 < d5) {
                int i9 = (i7 * 12) + i5 + 8;
                short d6 = iVar.d(i9);
                if (d6 == 274) {
                    short d7 = iVar.d(i9 + 2);
                    if (d7 >= s && d7 <= 12) {
                        int i10 = i9 + 4;
                        if (byteBuffer.remaining() - i10 >= 4) {
                            i6 = byteBuffer.getInt(i10);
                        } else {
                            i6 = -1;
                        }
                        if (i6 < 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Negative tiff component count");
                            }
                        } else {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder n5 = a1.i.n("Got tagIndex=", i7, " tagType=", d6, " formatCode=");
                                n5.append((int) d7);
                                n5.append(" componentCount=");
                                n5.append(i6);
                                Log.d("DfltImageHeaderParser", n5.toString());
                            }
                            int i11 = i6 + b[d7];
                            if (i11 > 4) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    str = "Got byte count > 4, not orientation, continuing, formatCode=";
                                    a1.i.x(str, d7, "DfltImageHeaderParser");
                                }
                            } else {
                                int i12 = i9 + 8;
                                if (i12 >= 0 && i12 <= byteBuffer.remaining()) {
                                    if (i11 >= 0 && i11 + i12 <= byteBuffer.remaining()) {
                                        return iVar.d(i12);
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        a1.i.x("Illegal number of bytes for TI tag data tagType=", d6, "DfltImageHeaderParser");
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    a1.i.s("Illegal tagValueOffset=", i12, " tagType=", d6, "DfltImageHeaderParser");
                                }
                            }
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        str = "Got invalid format code = ";
                        a1.i.x(str, d7, "DfltImageHeaderParser");
                    }
                }
                i7++;
                s = 1;
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    @Override // g.d
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        c0.g.c(byteBuffer, "Argument must not be null");
        return d(new i(byteBuffer, 0));
    }

    @Override // g.d
    public final int b(InputStream inputStream, j.g gVar) {
        c0.g.c(inputStream, "Argument must not be null");
        b3.e eVar = new b3.e(24, inputStream);
        c0.g.c(gVar, "Argument must not be null");
        int i3 = -1;
        try {
            int m5 = eVar.m();
            if ((m5 & 65496) != 65496 && m5 != 19789 && m5 != 18761) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + m5);
                }
            } else {
                int e5 = e(eVar);
                if (e5 == -1) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    }
                } else {
                    byte[] bArr = (byte[]) gVar.d(byte[].class, e5);
                    int f4 = f(eVar, bArr, e5);
                    gVar.h(bArr);
                    i3 = f4;
                }
            }
        } catch (j unused) {
        }
        return i3;
    }

    @Override // g.d
    public final ImageHeaderParser$ImageType c(InputStream inputStream) {
        c0.g.c(inputStream, "Argument must not be null");
        return d(new b3.e(24, inputStream));
    }
}

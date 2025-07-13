package g2;

import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f1913a = {0, 0, 0, 1};
    public static final int[] b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    public static final int[] c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    public static final byte[] d = {0, 0, 0, 1};

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f1914e = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: f  reason: collision with root package name */
    public static final Object f1915f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static int[] f1916g = new int[10];

    public static void a(int i3, int i5, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("GlUtil", GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        }
        GLES20.glAttachShader(i5, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        f();
    }

    public static void b(String str) {
        if (w.f1960a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static byte[] c(int i3, int i5, int i6) {
        return new byte[]{(byte) (((i3 << 3) & 248) | ((i5 >> 1) & 7)), (byte) (((i5 << 7) & 128) | ((i6 << 3) & 120))};
    }

    public static void d(String str, boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(str));
    }

    public static void e(boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void f() {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                Log.e("GlUtil", "glError " + GLU.gluErrorString(glGetError));
            } else {
                return;
            }
        }
    }

    public static void g(int i3, int i5) {
        if (i3 >= 0 && i3 < i5) {
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void h(boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalStateException();
    }

    public static void i(Object obj) {
        if (obj != null) {
            return;
        }
        throw new IllegalStateException();
    }

    public static void j(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int k(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        f();
        a(35633, glCreateProgram, str);
        a(35632, glCreateProgram, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("GlUtil", "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        }
        f();
        return glCreateProgram;
    }

    public static FloatBuffer l(float[] fArr) {
        return (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).flip();
    }

    public static void m() {
        if (w.f1960a >= 18) {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0079, code lost:
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int n(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.b.n(byte[], int, int, boolean[]):int");
    }

    public static int o(n nVar) {
        boolean z3;
        int g5 = nVar.g(4);
        if (g5 == 15) {
            return nVar.g(24);
        }
        if (g5 < 13) {
            z3 = true;
        } else {
            z3 = false;
        }
        e(z3);
        return b[g5];
    }

    public static String p(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            if (xmlPullParser.getAttributeName(i3).equals(str)) {
                return xmlPullParser.getAttributeValue(i3);
            }
        }
        return null;
    }

    public static int[] q(String str) {
        int i3;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i5 = indexOf4 + 2;
        if (i5 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i5) == '/') {
            i3 = str.indexOf(47, indexOf4 + 3);
            if (i3 == -1 || i3 > indexOf2) {
                i3 = indexOf2;
            }
        } else {
            i3 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i3;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static boolean r(XmlPullParser xmlPullParser, String str) {
        if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean s(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() == 2) {
            return true;
        }
        return false;
    }

    public static boolean t(XmlPullParser xmlPullParser, String str) {
        if (s(xmlPullParser) && xmlPullParser.getName().equals(str)) {
            return true;
        }
        return false;
    }

    public static Pair u(n nVar, boolean z3) {
        int g5 = nVar.g(5);
        if (g5 == 31) {
            g5 = nVar.g(6) + 32;
        }
        int o5 = o(nVar);
        int g6 = nVar.g(4);
        if (g5 == 5 || g5 == 29) {
            o5 = o(nVar);
            int g7 = nVar.g(5);
            if (g7 == 31) {
                g7 = nVar.g(6) + 32;
            }
            g5 = g7;
            if (g5 == 22) {
                g6 = nVar.g(4);
            }
        }
        boolean z5 = true;
        if (z3) {
            if (g5 != 1 && g5 != 2 && g5 != 3 && g5 != 4 && g5 != 6 && g5 != 7 && g5 != 17) {
                switch (g5) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new IOException(a1.i.e(g5, "Unsupported audio object type: "));
                }
            }
            nVar.o(1);
            if (nVar.f()) {
                nVar.o(14);
            }
            boolean f4 = nVar.f();
            if (g6 != 0) {
                if (g5 == 6 || g5 == 20) {
                    nVar.o(3);
                }
                if (f4) {
                    if (g5 == 22) {
                        nVar.o(16);
                    }
                    if (g5 == 17 || g5 == 19 || g5 == 20 || g5 == 23) {
                        nVar.o(3);
                    }
                    nVar.o(1);
                }
                switch (g5) {
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        int g8 = nVar.g(2);
                        if (g8 == 2 || g8 == 3) {
                            throw new IOException(a1.i.e(g8, "Unsupported epConfig: "));
                        }
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
        int i3 = c[g6];
        if (i3 == -1) {
            z5 = false;
        }
        e(z5);
        return Pair.create(Integer.valueOf(o5), Integer.valueOf(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static g2.m v(byte[] r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.b.v(byte[], int, int):g2.m");
    }

    public static String w(StringBuilder sb, int i3, int i5) {
        int i6;
        int i7;
        int i8;
        if (i3 >= i5) {
            return sb.toString();
        }
        if (sb.charAt(i3) == '/') {
            i3++;
        }
        int i9 = i3;
        int i10 = i9;
        while (i9 <= i5) {
            if (i9 == i5) {
                i6 = i9;
            } else if (sb.charAt(i9) == '/') {
                i6 = i9 + 1;
            } else {
                i9++;
            }
            int i11 = i10 + 1;
            if (i9 == i11 && sb.charAt(i10) == '.') {
                sb.delete(i10, i6);
                i5 -= i6 - i10;
            } else {
                if (i9 == i10 + 2 && sb.charAt(i10) == '.' && sb.charAt(i11) == '.') {
                    i7 = sb.lastIndexOf("/", i10 - 2) + 1;
                    if (i7 > i3) {
                        i8 = i7;
                    } else {
                        i8 = i3;
                    }
                    sb.delete(i8, i6);
                    i5 -= i6 - i8;
                } else {
                    i7 = i9 + 1;
                }
                i10 = i7;
            }
            i9 = i10;
        }
        return sb.toString();
    }

    public static String x(String str, String str2) {
        int i3;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] q = q(str2);
        if (q[0] != -1) {
            sb.append(str2);
            w(sb, q[1], q[2]);
            return sb.toString();
        }
        int[] q3 = q(str);
        if (q[3] == 0) {
            sb.append((CharSequence) str, 0, q3[3]);
            sb.append(str2);
            return sb.toString();
        } else if (q[2] == 0) {
            sb.append((CharSequence) str, 0, q3[2]);
            sb.append(str2);
            return sb.toString();
        } else {
            int i5 = q[1];
            if (i5 != 0) {
                int i6 = q3[0] + 1;
                sb.append((CharSequence) str, 0, i6);
                sb.append(str2);
                return w(sb, q[1] + i6, i6 + q[2]);
            } else if (str2.charAt(i5) == '/') {
                sb.append((CharSequence) str, 0, q3[1]);
                sb.append(str2);
                int i7 = q3[1];
                return w(sb, i7, q[2] + i7);
            } else {
                int i8 = q3[0] + 2;
                int i9 = q3[1];
                if (i8 < i9 && i9 == q3[2]) {
                    sb.append((CharSequence) str, 0, i9);
                    sb.append('/');
                    sb.append(str2);
                    int i10 = q3[1];
                    return w(sb, i10, q[2] + i10 + 1);
                }
                int lastIndexOf = str.lastIndexOf(47, q3[2] - 1);
                if (lastIndexOf == -1) {
                    i3 = q3[1];
                } else {
                    i3 = lastIndexOf + 1;
                }
                sb.append((CharSequence) str, 0, i3);
                sb.append(str2);
                return w(sb, q3[1], i3 + q[2]);
            }
        }
    }

    public static Uri y(String str, String str2) {
        return Uri.parse(x(str, str2));
    }

    public static int z(byte[] bArr, int i3) {
        int i5;
        synchronized (f1915f) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < i3) {
                while (true) {
                    if (i6 < i3 - 2) {
                        try {
                            if (bArr[i6] == 0 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 3) {
                                break;
                            }
                            i6++;
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else {
                        i6 = i3;
                        break;
                    }
                }
                if (i6 < i3) {
                    int[] iArr = f1916g;
                    if (iArr.length <= i7) {
                        f1916g = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f1916g[i7] = i6;
                    i6 += 3;
                    i7++;
                }
            }
            i5 = i3 - i7;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i7; i10++) {
                int i11 = f1916g[i10] - i9;
                System.arraycopy(bArr, i9, bArr, i8, i11);
                int i12 = i8 + i11;
                int i13 = i12 + 1;
                bArr[i12] = 0;
                i8 = i12 + 2;
                bArr[i13] = 0;
                i9 += i11 + 3;
            }
            System.arraycopy(bArr, i9, bArr, i8, i5 - i8);
        }
        return i5;
    }
}

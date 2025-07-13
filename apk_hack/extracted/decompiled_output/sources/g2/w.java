package g2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import j0.o0;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1960a;
    public static final String b;
    public static final String c;
    public static final String d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f1961e;

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f1962f;

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f1963g;

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f1964h;

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f1965i;

    /* renamed from: j  reason: collision with root package name */
    public static HashMap f1966j;

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f1967k;

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f1968l;

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f1969m;

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f1970n;

    static {
        int i3 = Build.VERSION.SDK_INT;
        f1960a = i3;
        String str = Build.DEVICE;
        b = str;
        String str2 = Build.MANUFACTURER;
        c = str2;
        String str3 = Build.MODEL;
        d = str3;
        f1961e = str + ", " + str3 + ", " + str2 + ", " + i3;
        f1962f = new byte[0];
        f1963g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f1964h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f1965i = Pattern.compile("%([A-Fa-f0-9]{2})");
        f1967k = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f1968l = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f1969m = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f1970n = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, SubsamplingScaleImageView.ORIENTATION_180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 253, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 243};
    }

    public static long A(long j2, o0 o0Var, long j5, long j6) {
        boolean z3;
        if (o0.c.equals(o0Var)) {
            return j2;
        }
        long j7 = o0Var.f2277a;
        long j8 = j2 - j7;
        if (((j7 ^ j2) & (j2 ^ j8)) < 0) {
            j8 = Long.MIN_VALUE;
        }
        long j9 = o0Var.b;
        long j10 = j2 + j9;
        if (((j9 ^ j10) & (j2 ^ j10)) < 0) {
            j10 = Long.MAX_VALUE;
        }
        boolean z5 = false;
        if (j8 <= j5 && j5 <= j10) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (j8 <= j6 && j6 <= j10) {
            z5 = true;
        }
        if (z3 && z5) {
            if (Math.abs(j5 - j2) <= Math.abs(j6 - j2)) {
                return j5;
            }
            return j6;
        } else if (z3) {
            return j5;
        } else {
            if (z5) {
                return j6;
            }
            return j8;
        }
    }

    public static long B(long j2, long j5, long j6) {
        int i3 = (j6 > j5 ? 1 : (j6 == j5 ? 0 : -1));
        if (i3 >= 0 && j6 % j5 == 0) {
            return j2 / (j6 / j5);
        }
        if (i3 < 0 && j5 % j6 == 0) {
            return (j5 / j6) * j2;
        }
        return (long) (j2 * (j5 / j6));
    }

    public static void C(long[] jArr, long j2) {
        int i3 = 0;
        int i5 = (j2 > 1000000L ? 1 : (j2 == 1000000L ? 0 : -1));
        if (i5 >= 0 && j2 % 1000000 == 0) {
            long j5 = j2 / 1000000;
            while (i3 < jArr.length) {
                jArr[i3] = jArr[i3] / j5;
                i3++;
            }
        } else if (i5 < 0 && 1000000 % j2 == 0) {
            long j6 = 1000000 / j2;
            while (i3 < jArr.length) {
                jArr[i3] = jArr[i3] * j6;
                i3++;
            }
        } else {
            double d5 = 1000000 / j2;
            while (i3 < jArr.length) {
                jArr[i3] = (long) (jArr[i3] * d5);
                i3++;
            }
        }
    }

    public static String[] D(String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        return str.trim().split("(\\s*,\\s*)", -1);
    }

    public static String E(String str) {
        if (str != null) {
            return str.toLowerCase(Locale.US);
        }
        return str;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static int b(long[] jArr, long j2, boolean z3, boolean z5) {
        int i3;
        int i5;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i5 = ~binarySearch;
        } else {
            while (true) {
                i3 = binarySearch + 1;
                if (i3 >= jArr.length || jArr[i3] != j2) {
                    break;
                }
                binarySearch = i3;
            }
            if (z3) {
                i5 = binarySearch;
            } else {
                i5 = i3;
            }
        }
        if (z5) {
            return Math.min(jArr.length - 1, i5);
        }
        return i5;
    }

    public static int c(List list, Long l5, boolean z3) {
        int i3;
        int binarySearch = Collections.binarySearch(list, l5);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
        } else {
            while (true) {
                int i5 = binarySearch - 1;
                if (i5 < 0 || ((Comparable) list.get(i5)).compareTo(l5) != 0) {
                    break;
                }
                binarySearch = i5;
            }
            i3 = binarySearch;
        }
        if (z3) {
            return Math.max(0, i3);
        }
        return i3;
    }

    public static int d(long[] jArr, long j2, boolean z3) {
        int i3;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
        } else {
            while (true) {
                int i5 = binarySearch - 1;
                if (i5 < 0 || jArr[i5] != j2) {
                    break;
                }
                binarySearch = i5;
            }
            i3 = binarySearch;
        }
        if (z3) {
            return Math.max(0, i3);
        }
        return i3;
    }

    public static int e(int i3, int i5) {
        return ((i3 + i5) - 1) / i5;
    }

    public static void f(e2.i iVar) {
        if (iVar != null) {
            try {
                iVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int h(int i3, int i5, int i6) {
        return Math.max(i5, Math.min(i3, i6));
    }

    public static long i(long j2, long j5, long j6) {
        return Math.max(j5, Math.min(j2, j6));
    }

    public static boolean j(String str, Object[] objArr) {
        for (Object obj : objArr) {
            if (a(obj, str)) {
                return true;
            }
        }
        return false;
    }

    public static String k(byte[] bArr, int i3, int i5) {
        return new String(bArr, i3, i5, Charset.forName("UTF-8"));
    }

    public static String l(int i3, String str) {
        String[] D = D(str);
        if (D.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : D) {
            if (i3 == k.e(k.b(str2))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() <= 0) {
            return null;
        }
        return sb.toString();
    }

    public static int m(Context context) {
        ConnectivityManager connectivityManager;
        int i3 = 0;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i3 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type == 6) {
                            return 5;
                        }
                        if (type != 9) {
                            return 8;
                        }
                        return 7;
                    }
                }
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        return 3;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 4;
                    case 13:
                        return 5;
                    case 16:
                    case 19:
                    default:
                        return 6;
                    case 18:
                        return 2;
                    case 20:
                        return 9;
                }
            }
        } catch (SecurityException unused) {
        }
        return i3;
    }

    public static int n(int i3) {
        if (i3 != 8) {
            if (i3 != 16) {
                if (i3 != 24) {
                    if (i3 != 32) {
                        return 0;
                    }
                    return 805306368;
                }
                return 536870912;
            }
            return 2;
        }
        return 3;
    }

    public static int o(int i3, int i5) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 268435456) {
                        if (i3 != 536870912) {
                            if (i3 != 805306368) {
                                throw new IllegalArgumentException();
                            }
                        } else {
                            return i5 * 3;
                        }
                    }
                }
                return i5 * 4;
            }
            return i5;
        }
        return i5 * 2;
    }

    public static String p(StringBuilder sb, Formatter formatter, long j2) {
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        long j5 = (j2 + 500) / 1000;
        long j6 = j5 % 60;
        long j7 = (j5 / 60) % 60;
        long j8 = j5 / 3600;
        sb.setLength(0);
        if (j8 > 0) {
            return formatter.format("%d:%02d:%02d", Long.valueOf(j8), Long.valueOf(j7), Long.valueOf(j6)).toString();
        }
        return formatter.format("%02d:%02d", Long.valueOf(j7), Long.valueOf(j6)).toString();
    }

    public static String q(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "?";
        }
        return a1.i.k(a1.i.p("ExoSourceManager/", str, " (Linux;Android "), Build.VERSION.RELEASE, ") ExoPlayerLib/2.11.3");
    }

    public static byte[] r(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static int s(String str) {
        String E = E(str);
        if (E.endsWith(".mpd")) {
            return 0;
        }
        if (E.endsWith(".m3u8")) {
            return 2;
        }
        if (E.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?")) {
            return 1;
        }
        return 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean t(c0.b r4, c0.b r5, java.util.zip.Inflater r6) {
        /*
            int r0 = r4.a()
            r1 = 0
            if (r0 > 0) goto L8
            return r1
        L8:
            byte[] r0 = r5.f187a
            int r2 = r0.length
            int r3 = r4.a()
            if (r2 >= r3) goto L19
            int r0 = r4.a()
            int r0 = r0 * 2
            byte[] r0 = new byte[r0]
        L19:
            if (r6 != 0) goto L20
            java.util.zip.Inflater r6 = new java.util.zip.Inflater
            r6.<init>()
        L20:
            byte[] r2 = r4.f187a
            int r3 = r4.b
            int r4 = r4.a()
            r6.setInput(r2, r3, r4)
            r4 = 0
        L2c:
            int r2 = r0.length     // Catch: java.lang.Throwable -> L41 java.util.zip.DataFormatException -> L63
            int r2 = r2 - r4
            int r2 = r6.inflate(r0, r4, r2)     // Catch: java.lang.Throwable -> L41 java.util.zip.DataFormatException -> L63
            int r4 = r4 + r2
            boolean r2 = r6.finished()     // Catch: java.lang.Throwable -> L41 java.util.zip.DataFormatException -> L63
            if (r2 == 0) goto L43
            r5.w(r0, r4)     // Catch: java.lang.Throwable -> L41 java.util.zip.DataFormatException -> L63
            r6.reset()
            r4 = 1
            return r4
        L41:
            r4 = move-exception
            goto L5f
        L43:
            boolean r2 = r6.needsDictionary()     // Catch: java.lang.Throwable -> L41 java.util.zip.DataFormatException -> L63
            if (r2 != 0) goto L5b
            boolean r2 = r6.needsInput()     // Catch: java.lang.Throwable -> L41 java.util.zip.DataFormatException -> L63
            if (r2 == 0) goto L50
            goto L5b
        L50:
            int r2 = r0.length     // Catch: java.lang.Throwable -> L41 java.util.zip.DataFormatException -> L63
            if (r4 != r2) goto L2c
            int r2 = r0.length     // Catch: java.lang.Throwable -> L41 java.util.zip.DataFormatException -> L63
            int r2 = r2 * 2
            byte[] r0 = java.util.Arrays.copyOf(r0, r2)     // Catch: java.lang.Throwable -> L41 java.util.zip.DataFormatException -> L63
            goto L2c
        L5b:
            r6.reset()
            return r1
        L5f:
            r6.reset()
            throw r4
        L63:
            r6.reset()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.w.t(c0.b, c0.b, java.util.zip.Inflater):boolean");
    }

    public static boolean u(int i3) {
        if (i3 != 536870912 && i3 != 805306368) {
            return false;
        }
        return true;
    }

    public static boolean v(int i3) {
        if (i3 != 3 && i3 != 2 && i3 != 268435456 && i3 != 536870912 && i3 != 805306368 && i3 != 4) {
            return false;
        }
        return true;
    }

    public static String w(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !"und".equals(replace)) {
            str = replace;
        }
        String E = E(str);
        int i3 = 0;
        String str2 = E.split("-", 2)[0];
        if (f1966j == null) {
            String[] iSOLanguages = Locale.getISOLanguages();
            int length = iSOLanguages.length;
            String[] strArr = f1967k;
            HashMap hashMap = new HashMap(length + strArr.length);
            for (String str3 : iSOLanguages) {
                try {
                    String iSO3Language = new Locale(str3).getISO3Language();
                    if (!TextUtils.isEmpty(iSO3Language)) {
                        hashMap.put(iSO3Language, str3);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            for (int i5 = 0; i5 < strArr.length; i5 += 2) {
                hashMap.put(strArr[i5], strArr[i5 + 1]);
            }
            f1966j = hashMap;
        }
        String str4 = (String) f1966j.get(str2);
        if (str4 != null) {
            StringBuilder l5 = a1.i.l(str4);
            l5.append(E.substring(str2.length()));
            E = l5.toString();
            str2 = str4;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return E;
        }
        while (true) {
            String[] strArr2 = f1968l;
            if (i3 < strArr2.length) {
                if (E.startsWith(strArr2[i3])) {
                    return strArr2[i3 + 1] + E.substring(strArr2[i3].length());
                }
                i3 += 2;
            } else {
                return E;
            }
        }
    }

    public static Object[] x(Object[] objArr, int i3) {
        boolean z3;
        if (i3 <= objArr.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        b.e(z3);
        return Arrays.copyOf(objArr, i3);
    }

    public static long y(String str) {
        Matcher matcher = f1963g.matcher(str);
        if (matcher.matches()) {
            int i3 = 0;
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                i3 = Integer.parseInt(matcher.group(13)) + (Integer.parseInt(matcher.group(12)) * 60);
                if ("-".equals(matcher.group(11))) {
                    i3 *= -1;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            if (i3 != 0) {
                return timeInMillis - (i3 * 60000);
            }
            return timeInMillis;
        }
        throw new IOException(a1.i.w("Invalid date/time format: ", str));
    }

    public static void z(List list, int i3, int i5) {
        if (i3 >= 0 && i5 <= list.size() && i3 <= i5) {
            if (i3 != i5) {
                list.subList(i3, i5).clear();
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }
}

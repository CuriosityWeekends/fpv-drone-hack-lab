package a1;

import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.video.ColorInfo;
import g2.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class o {
    public static final SparseIntArray c;
    public static final SparseIntArray d;

    /* renamed from: e  reason: collision with root package name */
    public static final SparseIntArray f41e;

    /* renamed from: f  reason: collision with root package name */
    public static final SparseIntArray f42f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap f43g;

    /* renamed from: h  reason: collision with root package name */
    public static final HashMap f44h;

    /* renamed from: i  reason: collision with root package name */
    public static final HashMap f45i;

    /* renamed from: j  reason: collision with root package name */
    public static final SparseIntArray f46j;

    /* renamed from: k  reason: collision with root package name */
    public static final SparseIntArray f47k;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f40a = Pattern.compile("^\\D?(\\d+)$");
    public static final HashMap b = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    public static int f48l = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        c = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        sparseIntArray.put(110, 16);
        sparseIntArray.put(122, 32);
        sparseIntArray.put(IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 64);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        d = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        f41e = sparseIntArray3;
        sparseIntArray3.put(0, 1);
        sparseIntArray3.put(1, 2);
        sparseIntArray3.put(2, 4);
        sparseIntArray3.put(3, 8);
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        f42f = sparseIntArray4;
        sparseIntArray4.put(10, 1);
        sparseIntArray4.put(11, 2);
        sparseIntArray4.put(20, 4);
        sparseIntArray4.put(21, 8);
        sparseIntArray4.put(30, 16);
        sparseIntArray4.put(31, 32);
        sparseIntArray4.put(40, 64);
        sparseIntArray4.put(41, 128);
        sparseIntArray4.put(50, 256);
        sparseIntArray4.put(51, 512);
        sparseIntArray4.put(60, 2048);
        sparseIntArray4.put(61, 4096);
        sparseIntArray4.put(62, 8192);
        HashMap hashMap = new HashMap();
        f43g = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        i.q(4096, hashMap, "L123", 16384, "L150");
        i.q(65536, hashMap, "L153", 262144, "L156");
        i.q(1048576, hashMap, "L180", 4194304, "L183");
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        i.q(8192, hashMap, "H123", 32768, "H150");
        i.q(131072, hashMap, "H153", 524288, "H156");
        i.q(2097152, hashMap, "H180", 8388608, "H183");
        hashMap.put("H186", 33554432);
        HashMap hashMap2 = new HashMap();
        f44h = hashMap2;
        hashMap2.put("00", 1);
        hashMap2.put("01", 2);
        hashMap2.put("02", 4);
        hashMap2.put("03", 8);
        hashMap2.put("04", 16);
        hashMap2.put("05", 32);
        hashMap2.put("06", 64);
        hashMap2.put("07", 128);
        hashMap2.put("08", 256);
        hashMap2.put("09", 512);
        HashMap hashMap3 = new HashMap();
        f45i = hashMap3;
        hashMap3.put("01", 1);
        hashMap3.put("02", 2);
        hashMap3.put("03", 4);
        hashMap3.put("04", 8);
        hashMap3.put("05", 16);
        hashMap3.put("06", 32);
        hashMap3.put("07", 64);
        hashMap3.put("08", 128);
        hashMap3.put("09", 256);
        SparseIntArray sparseIntArray5 = new SparseIntArray();
        f46j = sparseIntArray5;
        sparseIntArray5.put(0, 1);
        sparseIntArray5.put(1, 2);
        sparseIntArray5.put(2, 4);
        sparseIntArray5.put(3, 8);
        sparseIntArray5.put(4, 16);
        sparseIntArray5.put(5, 32);
        sparseIntArray5.put(6, 64);
        sparseIntArray5.put(7, 128);
        sparseIntArray5.put(8, 256);
        sparseIntArray5.put(9, 512);
        sparseIntArray5.put(10, 1024);
        sparseIntArray5.put(11, 2048);
        sparseIntArray5.put(12, 4096);
        sparseIntArray5.put(13, 8192);
        sparseIntArray5.put(14, 16384);
        sparseIntArray5.put(15, 32768);
        sparseIntArray5.put(16, 65536);
        sparseIntArray5.put(17, 131072);
        sparseIntArray5.put(18, 262144);
        sparseIntArray5.put(19, 524288);
        sparseIntArray5.put(20, 1048576);
        sparseIntArray5.put(21, 2097152);
        sparseIntArray5.put(22, 4194304);
        sparseIntArray5.put(23, 8388608);
        SparseIntArray sparseIntArray6 = new SparseIntArray();
        f47k = sparseIntArray6;
        sparseIntArray6.put(1, 1);
        sparseIntArray6.put(2, 2);
        sparseIntArray6.put(3, 3);
        sparseIntArray6.put(4, 4);
        sparseIntArray6.put(5, 5);
        sparseIntArray6.put(6, 6);
        sparseIntArray6.put(17, 17);
        sparseIntArray6.put(20, 20);
        sparseIntArray6.put(23, 23);
        sparseIntArray6.put(29, 29);
        sparseIntArray6.put(39, 39);
        sparseIntArray6.put(42, 42);
    }

    public static void a(String str, ArrayList arrayList) {
        if ("audio/raw".equals(str)) {
            if (w.f1960a < 26 && w.b.equals("R9") && arrayList.size() == 1 && ((a) arrayList.get(0)).f1a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayList.add(new a("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, false, false));
            }
            Collections.sort(arrayList, new h(new f(0)));
        }
        int i3 = w.f1960a;
        if (i3 < 21 && arrayList.size() > 1) {
            String str2 = ((a) arrayList.get(0)).f1a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                Collections.sort(arrayList, new h(new f(1)));
            }
        }
        if (i3 < 30 && arrayList.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((a) arrayList.get(0)).f1a)) {
            arrayList.add(arrayList.remove(0));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x01b1, code lost:
        if (r2.startsWith("t0") == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
        if (r0.startsWith("HM") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e1, code lost:
        if ("SO-02E".equals(r2) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x010f, code lost:
        if ("C1605".equals(r0) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0171, code lost:
        if ("SCV31".equals(r0) == false) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.media.MediaCodecInfo r5, java.lang.String r6, boolean r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.o.b(android.media.MediaCodecInfo, java.lang.String, boolean, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Pair c(Format format) {
        char c5;
        int i3;
        int parseInt;
        int parseInt2;
        int i5 = 1;
        String str = format.f308f;
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        boolean equals = "video/dolby-vision".equals(format.f311i);
        Pattern pattern = f40a;
        String str2 = format.f308f;
        if (equals) {
            if (split.length < 3) {
                i.t("Ignoring malformed Dolby Vision codec string: ", str2, "MediaCodecUtil");
                return null;
            }
            Matcher matcher = pattern.matcher(split[1]);
            if (!matcher.matches()) {
                i.t("Ignoring malformed Dolby Vision codec string: ", str2, "MediaCodecUtil");
                return null;
            }
            String group = matcher.group(1);
            Integer num = (Integer) f44h.get(group);
            if (num == null) {
                i.t("Unknown Dolby Vision profile string: ", group, "MediaCodecUtil");
                return null;
            }
            String str3 = split[2];
            Integer num2 = (Integer) f45i.get(str3);
            if (num2 == null) {
                i.t("Unknown Dolby Vision level string: ", str3, "MediaCodecUtil");
                return null;
            }
            return new Pair(num, num2);
        }
        String str4 = split[0];
        str4.getClass();
        switch (str4.hashCode()) {
            case 3004662:
                if (str4.equals("av01")) {
                    c5 = 0;
                    break;
                }
                c5 = 65535;
                break;
            case 3006243:
                if (str4.equals("avc1")) {
                    c5 = 1;
                    break;
                }
                c5 = 65535;
                break;
            case 3006244:
                if (str4.equals("avc2")) {
                    c5 = 2;
                    break;
                }
                c5 = 65535;
                break;
            case 3199032:
                if (str4.equals("hev1")) {
                    c5 = 3;
                    break;
                }
                c5 = 65535;
                break;
            case 3214780:
                if (str4.equals("hvc1")) {
                    c5 = 4;
                    break;
                }
                c5 = 65535;
                break;
            case 3356560:
                if (str4.equals("mp4a")) {
                    c5 = 5;
                    break;
                }
                c5 = 65535;
                break;
            case 3624515:
                if (str4.equals("vp09")) {
                    c5 = 6;
                    break;
                }
                c5 = 65535;
                break;
            default:
                c5 = 65535;
                break;
        }
        switch (c5) {
            case 0:
                if (split.length < 4) {
                    i.t("Ignoring malformed AV1 codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
                try {
                    int parseInt3 = Integer.parseInt(split[1]);
                    int parseInt4 = Integer.parseInt(split[2].substring(0, 2));
                    int parseInt5 = Integer.parseInt(split[3]);
                    if (parseInt3 != 0) {
                        i.r("Unknown AV1 profile: ", parseInt3, "MediaCodecUtil");
                        return null;
                    } else if (parseInt5 != 8 && parseInt5 != 10) {
                        i.r("Unknown AV1 bit depth: ", parseInt5, "MediaCodecUtil");
                        return null;
                    } else {
                        if (parseInt5 != 8) {
                            ColorInfo colorInfo = format.f321u;
                            if (colorInfo != null && (colorInfo.d != null || (i3 = colorInfo.c) == 7 || i3 == 6)) {
                                i5 = 4096;
                            } else {
                                i5 = 2;
                            }
                        }
                        int i6 = f46j.get(parseInt4, -1);
                        if (i6 == -1) {
                            i.r("Unknown AV1 level: ", parseInt4, "MediaCodecUtil");
                            return null;
                        }
                        return new Pair(Integer.valueOf(i5), Integer.valueOf(i6));
                    }
                } catch (NumberFormatException unused) {
                    i.t("Ignoring malformed AV1 codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
            case 1:
            case 2:
                if (split.length < 2) {
                    i.t("Ignoring malformed AVC codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
                try {
                    if (split[1].length() == 6) {
                        parseInt = Integer.parseInt(split[1].substring(0, 2), 16);
                        parseInt2 = Integer.parseInt(split[1].substring(4), 16);
                    } else if (split.length >= 3) {
                        parseInt = Integer.parseInt(split[1]);
                        parseInt2 = Integer.parseInt(split[2]);
                    } else {
                        Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str2);
                        return null;
                    }
                    int i7 = c.get(parseInt, -1);
                    if (i7 == -1) {
                        i.r("Unknown AVC profile: ", parseInt, "MediaCodecUtil");
                        return null;
                    }
                    int i8 = d.get(parseInt2, -1);
                    if (i8 == -1) {
                        i.r("Unknown AVC level: ", parseInt2, "MediaCodecUtil");
                        return null;
                    }
                    return new Pair(Integer.valueOf(i7), Integer.valueOf(i8));
                } catch (NumberFormatException unused2) {
                    i.t("Ignoring malformed AVC codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
            case 3:
            case 4:
                if (split.length < 4) {
                    i.t("Ignoring malformed HEVC codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
                Matcher matcher2 = pattern.matcher(split[1]);
                if (!matcher2.matches()) {
                    i.t("Ignoring malformed HEVC codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
                String group2 = matcher2.group(1);
                if (!"1".equals(group2)) {
                    if (ExifInterface.GPS_MEASUREMENT_2D.equals(group2)) {
                        i5 = 2;
                    } else {
                        i.t("Unknown HEVC profile string: ", group2, "MediaCodecUtil");
                        return null;
                    }
                }
                String str5 = split[3];
                Integer num3 = (Integer) f43g.get(str5);
                if (num3 == null) {
                    i.t("Unknown HEVC level string: ", str5, "MediaCodecUtil");
                    return null;
                }
                return new Pair(Integer.valueOf(i5), num3);
            case 5:
                if (split.length != 3) {
                    i.t("Ignoring malformed MP4A codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
                try {
                    if (!"audio/mp4a-latm".equals(g2.k.c(Integer.parseInt(split[1], 16)))) {
                        return null;
                    }
                    int i9 = f47k.get(Integer.parseInt(split[2]), -1);
                    if (i9 == -1) {
                        return null;
                    }
                    return new Pair(Integer.valueOf(i9), 0);
                } catch (NumberFormatException unused3) {
                    i.t("Ignoring malformed MP4A codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
            case 6:
                if (split.length < 3) {
                    i.t("Ignoring malformed VP9 codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
                try {
                    int parseInt6 = Integer.parseInt(split[1]);
                    int parseInt7 = Integer.parseInt(split[2]);
                    int i10 = f41e.get(parseInt6, -1);
                    if (i10 == -1) {
                        i.r("Unknown VP9 profile: ", parseInt6, "MediaCodecUtil");
                        return null;
                    }
                    int i11 = f42f.get(parseInt7, -1);
                    if (i11 == -1) {
                        i.r("Unknown VP9 level: ", parseInt7, "MediaCodecUtil");
                        return null;
                    }
                    return new Pair(Integer.valueOf(i10), Integer.valueOf(i11));
                } catch (NumberFormatException unused4) {
                    i.t("Ignoring malformed VP9 codec string: ", str2, "MediaCodecUtil");
                    return null;
                }
            default:
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [a1.l] */
    /* JADX WARN: Type inference failed for: r6v2, types: [a1.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r8v3, types: [a1.l, java.lang.Object] */
    public static synchronized List d(String str, boolean z3, boolean z5) {
        ?? r6;
        int i3;
        synchronized (o.class) {
            try {
                j jVar = new j(str, z3, z5);
                HashMap hashMap = b;
                List list = (List) hashMap.get(jVar);
                if (list != null) {
                    return list;
                }
                int i5 = w.f1960a;
                if (i5 >= 21) {
                    ?? obj = new Object();
                    if (!z3 && !z5) {
                        i3 = 0;
                        obj.f39a = i3;
                        r6 = obj;
                    }
                    i3 = 1;
                    obj.f39a = i3;
                    r6 = obj;
                } else {
                    r6 = new Object();
                }
                ArrayList e5 = e(jVar, r6);
                if (z3 && e5.isEmpty() && 21 <= i5 && i5 <= 23) {
                    e5 = e(jVar, new Object());
                    if (!e5.isEmpty()) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((a) e5.get(0)).f1a);
                    }
                }
                a(str, e5);
                List unmodifiableList = Collections.unmodifiableList(e5);
                hashMap.put(jVar, unmodifiableList);
                return unmodifiableList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ArrayList e(j jVar, l lVar) {
        String str;
        String str2;
        int i3;
        boolean z3;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean e5;
        boolean c5;
        boolean z5;
        boolean z6;
        String str3;
        j jVar2 = jVar;
        l lVar2 = lVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str4 = jVar2.f38a;
            int d5 = lVar.d();
            boolean f4 = lVar.f();
            int i5 = 0;
            while (i5 < d5) {
                MediaCodecInfo a5 = lVar2.a(i5);
                String name = a5.getName();
                String b5 = b(a5, name, f4, str4);
                if (b5 != null) {
                    try {
                        capabilitiesForType = a5.getCapabilitiesForType(b5);
                        e5 = lVar2.e("tunneled-playback", b5, capabilitiesForType);
                        c5 = lVar2.c("tunneled-playback", capabilitiesForType);
                        z5 = jVar2.c;
                    } catch (Exception e6) {
                        e = e6;
                        str = b5;
                        str2 = name;
                        i3 = i5;
                        z3 = f4;
                    }
                    if ((z5 || !c5) && (!z5 || e5)) {
                        boolean e7 = lVar2.e("secure-playback", b5, capabilitiesForType);
                        boolean c6 = lVar2.c("secure-playback", capabilitiesForType);
                        boolean z7 = jVar2.b;
                        if ((z7 || !c6) && (!z7 || e7)) {
                            int i6 = w.f1960a;
                            if (i6 >= 29) {
                                a5.isHardwareAccelerated();
                            } else {
                                f(a5);
                            }
                            f(a5);
                            if (i6 >= 29) {
                                a5.isVendor();
                            } else {
                                String E = w.E(a5.getName());
                                if (!E.startsWith("omx.google.") && !E.startsWith("c2.android.")) {
                                    E.startsWith("c2.google.");
                                }
                            }
                            if (i6 <= 22) {
                                String str5 = w.d;
                                if (("ODROID-XU3".equals(str5) || "Nexus 10".equals(str5)) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                                    z6 = true;
                                    if ((!f4 && z7 == e7) || (!f4 && !z7)) {
                                        try {
                                            str = b5;
                                            str3 = name;
                                            i3 = i5;
                                            z3 = f4;
                                        } catch (Exception e8) {
                                            e = e8;
                                            str = b5;
                                            str3 = name;
                                            i3 = i5;
                                            z3 = f4;
                                        }
                                        try {
                                            arrayList.add(new a(name, str4, b5, capabilitiesForType, false, z6, false));
                                        } catch (Exception e9) {
                                            e = e9;
                                            str2 = str3;
                                            if (w.f1960a > 23) {
                                            }
                                            Log.e("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                            throw e;
                                        }
                                    } else {
                                        str = b5;
                                        i3 = i5;
                                        z3 = f4;
                                        if (!z3 && e7) {
                                            StringBuilder sb = new StringBuilder();
                                            try {
                                                sb.append(name);
                                                sb.append(".secure");
                                                str2 = name;
                                                try {
                                                    arrayList.add(new a(sb.toString(), str4, str, capabilitiesForType, false, z6, true));
                                                    return arrayList;
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    if (w.f1960a > 23 && !arrayList.isEmpty()) {
                                                        Log.e("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                                        i5 = i3 + 1;
                                                        jVar2 = jVar;
                                                        lVar2 = lVar;
                                                        f4 = z3;
                                                    } else {
                                                        Log.e("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                        throw e;
                                                    }
                                                }
                                            } catch (Exception e11) {
                                                e = e11;
                                                str2 = name;
                                            }
                                        }
                                    }
                                    i5 = i3 + 1;
                                    jVar2 = jVar;
                                    lVar2 = lVar;
                                    f4 = z3;
                                }
                            }
                            z6 = false;
                            if (!f4) {
                            }
                            str = b5;
                            i3 = i5;
                            z3 = f4;
                            if (!z3) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(name);
                                sb2.append(".secure");
                                str2 = name;
                                arrayList.add(new a(sb2.toString(), str4, str, capabilitiesForType, false, z6, true));
                                return arrayList;
                            }
                            continue;
                            i5 = i3 + 1;
                            jVar2 = jVar;
                            lVar2 = lVar;
                            f4 = z3;
                        }
                    }
                }
                i3 = i5;
                z3 = f4;
                i5 = i3 + 1;
                jVar2 = jVar;
                lVar2 = lVar;
                f4 = z3;
            }
            return arrayList;
        } catch (Exception e12) {
            throw new Exception("Failed to query underlying media codecs", e12);
        }
    }

    public static boolean f(MediaCodecInfo mediaCodecInfo) {
        boolean isSoftwareOnly;
        if (w.f1960a >= 29) {
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            return isSoftwareOnly;
        }
        String E = w.E(mediaCodecInfo.getName());
        if (E.startsWith("arc.")) {
            return false;
        }
        if (!E.startsWith("omx.google.") && !E.startsWith("omx.ffmpeg.") && ((!E.startsWith("omx.sec.") || !E.contains(".sw.")) && !E.equals("omx.qcom.video.decoder.hevcswvdec") && !E.startsWith("c2.android.") && !E.startsWith("c2.google.") && (E.startsWith("omx.") || E.startsWith("c2.")))) {
            return false;
        }
        return true;
    }

    public static int g() {
        a aVar;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i3;
        int i5;
        if (f48l == -1) {
            int i6 = 0;
            List d5 = d("video/avc", false, false);
            if (d5.isEmpty()) {
                aVar = null;
            } else {
                aVar = (a) d5.get(0);
            }
            if (aVar != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = aVar.d;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int i7 = 0;
                while (i6 < length) {
                    int i8 = codecProfileLevelArr[i6].level;
                    if (i8 != 1 && i8 != 2) {
                        switch (i8) {
                            case 8:
                            case 16:
                            case 32:
                                i5 = 101376;
                                continue;
                            case 64:
                                i5 = 202752;
                                continue;
                            case 128:
                            case 256:
                                i5 = 414720;
                                continue;
                            case 512:
                                i5 = 921600;
                                continue;
                            case 1024:
                                i5 = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i5 = 2097152;
                                continue;
                            case 8192:
                                i5 = 2228224;
                                continue;
                            case 16384:
                                i5 = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                i5 = 9437184;
                                continue;
                            default:
                                i5 = -1;
                                continue;
                        }
                    } else {
                        i5 = 25344;
                    }
                    i7 = Math.max(i5, i7);
                    i6++;
                }
                if (w.f1960a >= 21) {
                    i3 = 345600;
                } else {
                    i3 = 172800;
                }
                i6 = Math.max(i7, i3);
            }
            f48l = i6;
        }
        return f48l;
    }
}

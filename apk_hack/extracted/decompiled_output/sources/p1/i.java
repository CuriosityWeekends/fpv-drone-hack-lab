package p1;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import e2.h0;
import g2.k;
import g2.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v0.o;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements h0 {

    /* renamed from: a  reason: collision with root package name */
    public final e f3207a;
    public static final Pattern b = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern c = Pattern.compile("VIDEO=\"(.+?)\"");
    public static final Pattern d = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f3188e = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f3189f = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f3190g = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f3191h = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f3192i = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f3193j = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f3194k = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f3195l = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f3196m = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: n  reason: collision with root package name */
    public static final Pattern f3197n = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f3198o = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f3199p = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern q = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f3200r = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern s = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* renamed from: t  reason: collision with root package name */
    public static final Pattern f3201t = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* renamed from: u  reason: collision with root package name */
    public static final Pattern f3202u = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");

    /* renamed from: v  reason: collision with root package name */
    public static final Pattern f3203v = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern w = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");

    /* renamed from: x  reason: collision with root package name */
    public static final Pattern f3204x = Pattern.compile("URI=\"(.+?)\"");

    /* renamed from: y  reason: collision with root package name */
    public static final Pattern f3205y = Pattern.compile("IV=([^,.*]+)");

    /* renamed from: z  reason: collision with root package name */
    public static final Pattern f3206z = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern A = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern B = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern C = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern D = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern E = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern F = a("AUTOSELECT");
    public static final Pattern G = a("DEFAULT");
    public static final Pattern H = a("FORCED");
    public static final Pattern I = Pattern.compile("VALUE=\"(.+?)\"");
    public static final Pattern J = Pattern.compile("IMPORT=\"(.+?)\"");
    public static final Pattern K = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public i(e eVar) {
        this.f3207a = eVar;
    }

    public static Pattern a(String str) {
        return Pattern.compile(str.concat("=(NO|YES)"));
    }

    public static DrmInitData.SchemeData b(String str, String str2, HashMap hashMap) {
        String g5 = g(str, w, "1", hashMap);
        boolean equals = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2);
        Pattern pattern = f3204x;
        if (equals) {
            String h5 = h(str, pattern, hashMap);
            return new DrmInitData.SchemeData(j0.i.c, null, "video/mp4", Base64.decode(h5.substring(h5.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(j0.i.c, null, "hls", w.r(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(g5)) {
                return null;
            }
            String h6 = h(str, pattern, hashMap);
            byte[] decode = Base64.decode(h6.substring(h6.indexOf(44)), 0);
            UUID uuid = j0.i.d;
            return new DrmInitData.SchemeData(uuid, null, "video/mp4", o.a(uuid, null, decode));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    public static e c(i.b bVar, String str) {
        ArrayList arrayList;
        Pattern pattern;
        Uri y3;
        Format format;
        int i3;
        int i5;
        char c5;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int parseInt;
        String str2;
        Format format2;
        int i6;
        d dVar;
        String str3;
        String str4;
        String str5;
        int i7;
        int i8;
        d dVar2;
        String str6;
        int i9;
        int i10;
        float f4;
        String str7;
        HashSet hashSet;
        boolean z3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        boolean z5;
        int i11;
        int i12;
        float f5;
        String str8;
        String str9 = str;
        int i13 = 1;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            boolean i14 = bVar.i();
            Pattern pattern2 = B;
            if (i14) {
                String o5 = bVar.o();
                if (o5.startsWith("#EXT")) {
                    arrayList15.add(o5);
                }
                if (o5.startsWith("#EXT-X-DEFINE")) {
                    hashMap2.put(h(o5, pattern2, hashMap2), h(o5, I, hashMap2));
                } else if (o5.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    z6 = true;
                } else if (o5.startsWith("#EXT-X-MEDIA")) {
                    arrayList13.add(o5);
                } else {
                    if (o5.startsWith("#EXT-X-SESSION-KEY")) {
                        DrmInitData.SchemeData b5 = b(o5, g(o5, f3203v, "identity", hashMap2), hashMap2);
                        if (b5 != null) {
                            String h5 = h(o5, f3202u, hashMap2);
                            if (!"SAMPLE-AES-CENC".equals(h5) && !"SAMPLE-AES-CTR".equals(h5)) {
                                str8 = "cbcs";
                            } else {
                                str8 = "cenc";
                            }
                            z5 = z6;
                            DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[i13];
                            schemeDataArr[0] = b5;
                            arrayList14.add(new DrmInitData(str8, i13, schemeDataArr));
                        } else {
                            z5 = z6;
                        }
                    } else {
                        z5 = z6;
                        if (o5.startsWith("#EXT-X-STREAM-INF")) {
                            z7 |= o5.contains("CLOSED-CAPTIONS=NONE");
                            int parseInt2 = Integer.parseInt(h(o5, f3190g, Collections.emptyMap()));
                            Matcher matcher = b.matcher(o5);
                            if (matcher.find()) {
                                Integer.parseInt(matcher.group(i13));
                            }
                            String g5 = g(o5, f3192i, null, hashMap2);
                            String g6 = g(o5, f3193j, null, hashMap2);
                            if (g6 != null) {
                                String[] split = g6.split("x");
                                int parseInt3 = Integer.parseInt(split[0]);
                                int parseInt4 = Integer.parseInt(split[i13]);
                                if (parseInt3 <= 0 || parseInt4 <= 0) {
                                    parseInt4 = -1;
                                    parseInt3 = -1;
                                }
                                i12 = parseInt4;
                                i11 = parseInt3;
                            } else {
                                i11 = -1;
                                i12 = -1;
                            }
                            String g7 = g(o5, f3194k, null, hashMap2);
                            if (g7 != null) {
                                f5 = Float.parseFloat(g7);
                            } else {
                                f5 = -1.0f;
                            }
                            String g8 = g(o5, c, null, hashMap2);
                            String g9 = g(o5, d, null, hashMap2);
                            arrayList5 = arrayList14;
                            String g10 = g(o5, f3188e, null, hashMap2);
                            arrayList4 = arrayList12;
                            String g11 = g(o5, f3189f, null, hashMap2);
                            if (bVar.i()) {
                                Uri y4 = g2.b.y(str9, i(bVar.o(), hashMap2));
                                arrayList8.add(new d(y4, Format.r(Integer.toString(arrayList8.size()), null, "application/x-mpegURL", null, g5, null, parseInt2, i11, i12, f5, null, 0, 0), g8, g9, g10, g11));
                                ArrayList arrayList16 = (ArrayList) hashMap.get(y4);
                                if (arrayList16 == null) {
                                    arrayList16 = new ArrayList();
                                    hashMap.put(y4, arrayList16);
                                }
                                arrayList7 = arrayList10;
                                arrayList6 = arrayList11;
                                arrayList16.add(new HlsTrackMetadataEntry.VariantInfo(parseInt2, g8, g9, g10, g11));
                                z6 = z5;
                                arrayList10 = arrayList7;
                                arrayList11 = arrayList6;
                                arrayList14 = arrayList5;
                                arrayList12 = arrayList4;
                                i13 = 1;
                            } else {
                                throw new IOException("#EXT-X-STREAM-INF tag must be followed by another line");
                            }
                        }
                    }
                    arrayList7 = arrayList10;
                    arrayList6 = arrayList11;
                    arrayList4 = arrayList12;
                    arrayList5 = arrayList14;
                    z6 = z5;
                    arrayList10 = arrayList7;
                    arrayList11 = arrayList6;
                    arrayList14 = arrayList5;
                    arrayList12 = arrayList4;
                    i13 = 1;
                }
                arrayList7 = arrayList10;
                arrayList6 = arrayList11;
                arrayList4 = arrayList12;
                arrayList5 = arrayList14;
                z5 = z6;
                z6 = z5;
                arrayList10 = arrayList7;
                arrayList11 = arrayList6;
                arrayList14 = arrayList5;
                arrayList12 = arrayList4;
                i13 = 1;
            } else {
                ArrayList arrayList17 = arrayList10;
                ArrayList arrayList18 = arrayList11;
                ArrayList arrayList19 = arrayList12;
                ArrayList arrayList20 = arrayList14;
                boolean z8 = z6;
                ArrayList arrayList21 = new ArrayList();
                HashSet hashSet2 = new HashSet();
                int i15 = 0;
                while (i15 < arrayList8.size()) {
                    d dVar3 = (d) arrayList8.get(i15);
                    if (hashSet2.add(dVar3.f3156a)) {
                        Format format3 = dVar3.b;
                        if (format3.f309g == null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        g2.b.h(z3);
                        Object obj = hashMap.get(dVar3.f3156a);
                        obj.getClass();
                        hashSet = hashSet2;
                        arrayList21.add(new d(dVar3.f3156a, format3.c(format3.f314l, new Metadata(new HlsTrackMetadataEntry(null, null, (List) obj))), dVar3.c, dVar3.d, dVar3.f3157e, dVar3.f3158f));
                    } else {
                        hashSet = hashSet2;
                    }
                    i15++;
                    hashSet2 = hashSet;
                }
                int i16 = 0;
                Format format4 = null;
                ArrayList arrayList22 = null;
                while (i16 < arrayList13.size()) {
                    String str10 = (String) arrayList13.get(i16);
                    String h6 = h(str10, C, hashMap2);
                    String h7 = h(str10, pattern2, hashMap2);
                    String g12 = g(str10, f3204x, null, hashMap2);
                    if (g12 == null) {
                        pattern = pattern2;
                        y3 = null;
                    } else {
                        pattern = pattern2;
                        y3 = g2.b.y(str9, g12);
                    }
                    String g13 = g(str10, A, null, hashMap2);
                    boolean e5 = e(str10, G);
                    if (e(str10, H)) {
                        e5 |= true;
                    }
                    if (e(str10, F)) {
                        e5 |= true;
                    }
                    ArrayList arrayList23 = arrayList13;
                    String g14 = g(str10, D, null, hashMap2);
                    if (TextUtils.isEmpty(g14)) {
                        format = format4;
                        i5 = 0;
                    } else {
                        int i17 = w.f1960a;
                        format = format4;
                        String[] split2 = g14.split(",", -1);
                        if (w.j("public.accessibility.describes-video", split2)) {
                            i3 = 512;
                        } else {
                            i3 = 0;
                        }
                        if (w.j("public.accessibility.transcribes-spoken-dialog", split2)) {
                            i3 |= 4096;
                        }
                        if (w.j("public.accessibility.describes-music-and-sound", split2)) {
                            i3 |= 1024;
                        }
                        if (w.j("public.easy-to-read", split2)) {
                            i5 = i3 | 8192;
                        } else {
                            i5 = i3;
                        }
                    }
                    String str11 = h6 + ":" + h7;
                    ArrayList arrayList24 = arrayList21;
                    ArrayList arrayList25 = arrayList15;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(h6, h7, Collections.emptyList()));
                    String h8 = h(str10, f3206z, hashMap2);
                    switch (h8.hashCode()) {
                        case -959297733:
                            if (h8.equals("SUBTITLES")) {
                                c5 = 0;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case -333210994:
                            if (h8.equals("CLOSED-CAPTIONS")) {
                                c5 = 1;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 62628790:
                            if (h8.equals("AUDIO")) {
                                c5 = 2;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 81665115:
                            if (h8.equals("VIDEO")) {
                                c5 = 3;
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
                            arrayList2 = arrayList17;
                            Format p5 = Format.p(str11, h7, "application/x-mpegURL", "text/vtt", null, -1, e5 ? 1 : 0, i5, g13, -1);
                            arrayList3 = arrayList18;
                            arrayList3.add(new c(y3, p5.c(p5.f314l, metadata), h7));
                            format2 = format;
                            break;
                        case 1:
                            arrayList2 = arrayList17;
                            String h9 = h(str10, E, hashMap2);
                            if (h9.startsWith("CC")) {
                                parseInt = Integer.parseInt(h9.substring(2));
                                str2 = "application/cea-608";
                            } else {
                                parseInt = Integer.parseInt(h9.substring(7));
                                str2 = "application/cea-708";
                            }
                            int i18 = parseInt;
                            String str12 = str2;
                            if (arrayList22 == null) {
                                arrayList22 = new ArrayList();
                            }
                            arrayList22.add(Format.p(str11, h7, null, str12, null, -1, e5 ? 1 : 0, i5, g13, i18));
                            format2 = format;
                            arrayList3 = arrayList18;
                            break;
                        case 2:
                            int i19 = 0;
                            while (true) {
                                if (i19 < arrayList8.size()) {
                                    d dVar4 = (d) arrayList8.get(i19);
                                    if (h6.equals(dVar4.d)) {
                                        dVar = dVar4;
                                        i6 = 1;
                                    } else {
                                        i19++;
                                    }
                                } else {
                                    i6 = 1;
                                    dVar = null;
                                }
                            }
                            if (dVar != null) {
                                str3 = w.l(i6, dVar.b.f308f);
                            } else {
                                str3 = null;
                            }
                            if (str3 != null) {
                                str4 = k.b(str3);
                            } else {
                                str4 = null;
                            }
                            String g15 = g(str10, f3191h, null, hashMap2);
                            if (g15 != null) {
                                int i20 = w.f1960a;
                                int parseInt5 = Integer.parseInt(g15.split("/", 2)[0]);
                                if ("audio/eac3".equals(str4) && g15.endsWith("/JOC")) {
                                    str4 = "audio/eac3-joc";
                                }
                                str5 = str4;
                                i7 = parseInt5;
                            } else {
                                str5 = str4;
                                i7 = -1;
                            }
                            format2 = Format.i(str11, h7, "application/x-mpegURL", str5, str3, null, -1, i7, -1, null, e5 ? 1 : 0, i5, g13);
                            if (y3 == null) {
                                arrayList2 = arrayList17;
                                arrayList3 = arrayList18;
                                i8 = 1;
                                continue;
                                i16 += i8;
                                str9 = str;
                                arrayList17 = arrayList2;
                                arrayList18 = arrayList3;
                                arrayList13 = arrayList23;
                                arrayList21 = arrayList24;
                                arrayList15 = arrayList25;
                                format4 = format2;
                                pattern2 = pattern;
                            } else {
                                arrayList2 = arrayList17;
                                arrayList2.add(new c(y3, format2.c(format2.f314l, metadata), h7));
                                arrayList3 = arrayList18;
                                format2 = format;
                                break;
                            }
                            break;
                        case 3:
                            int i21 = 0;
                            while (true) {
                                if (i21 < arrayList8.size()) {
                                    dVar2 = (d) arrayList8.get(i21);
                                    if (!h6.equals(dVar2.c)) {
                                        i21++;
                                    }
                                } else {
                                    dVar2 = null;
                                }
                            }
                            if (dVar2 != null) {
                                Format format5 = dVar2.b;
                                String l5 = w.l(2, format5.f308f);
                                int i22 = format5.f316n;
                                int i23 = format5.f317o;
                                f4 = format5.f318p;
                                str6 = l5;
                                i9 = i22;
                                i10 = i23;
                            } else {
                                str6 = null;
                                i9 = -1;
                                i10 = -1;
                                f4 = -1.0f;
                            }
                            if (str6 != null) {
                                str7 = k.b(str6);
                            } else {
                                str7 = null;
                            }
                            Format r5 = Format.r(str11, h7, "application/x-mpegURL", str7, str6, null, -1, i9, i10, f4, null, e5 ? 1 : 0, i5);
                            Format c6 = r5.c(r5.f314l, metadata);
                            if (y3 != null) {
                                arrayList9.add(new c(y3, c6, h7));
                            }
                        default:
                            arrayList2 = arrayList17;
                            arrayList3 = arrayList18;
                            format2 = format;
                            break;
                    }
                    i8 = 1;
                    i16 += i8;
                    str9 = str;
                    arrayList17 = arrayList2;
                    arrayList18 = arrayList3;
                    arrayList13 = arrayList23;
                    arrayList21 = arrayList24;
                    arrayList15 = arrayList25;
                    format4 = format2;
                    pattern2 = pattern;
                }
                ArrayList arrayList26 = arrayList21;
                Format format6 = format4;
                ArrayList arrayList27 = arrayList15;
                ArrayList arrayList28 = arrayList17;
                ArrayList arrayList29 = arrayList18;
                if (z7) {
                    arrayList = Collections.emptyList();
                } else {
                    arrayList = arrayList22;
                }
                return new e(str, arrayList27, arrayList26, arrayList9, arrayList28, arrayList29, arrayList19, format6, arrayList, z8, hashMap2, arrayList20);
            }
        }
    }

    public static g d(e eVar, i.b bVar, String str) {
        boolean z3;
        long j2;
        long j5;
        TreeMap treeMap;
        ArrayList arrayList;
        long j6;
        boolean z5;
        String str2;
        String hexString;
        long j7;
        TreeMap treeMap2;
        ArrayList arrayList2;
        long j8;
        String str3;
        DrmInitData drmInitData;
        e eVar2 = eVar;
        boolean z6 = eVar2.c;
        HashMap hashMap = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        TreeMap treeMap3 = new TreeMap();
        long j9 = -9223372036854775807L;
        String str4 = null;
        boolean z7 = z6;
        long j10 = -9223372036854775807L;
        String str5 = null;
        DrmInitData drmInitData2 = null;
        String str6 = null;
        String str7 = null;
        DrmInitData drmInitData3 = null;
        f fVar = null;
        int i3 = 0;
        int i5 = 0;
        boolean z8 = false;
        long j11 = 0;
        int i6 = 0;
        long j12 = 0;
        int i7 = 1;
        boolean z9 = false;
        long j13 = 0;
        boolean z10 = false;
        long j14 = -1;
        long j15 = 0;
        long j16 = 0;
        while (true) {
            long j17 = 0;
            while (bVar.i()) {
                String o5 = bVar.o();
                if (o5.startsWith("#EXT")) {
                    arrayList4.add(o5);
                }
                if (o5.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String h5 = h(o5, f3197n, hashMap);
                    if ("VOD".equals(h5)) {
                        i3 = 1;
                    } else if ("EVENT".equals(h5)) {
                        i3 = 2;
                    }
                } else if (o5.startsWith("#EXT-X-START")) {
                    j9 = (long) (Double.parseDouble(h(o5, f3200r, Collections.emptyMap())) * 1000000.0d);
                } else {
                    boolean startsWith = o5.startsWith("#EXT-X-MAP");
                    Pattern pattern = f3204x;
                    if (startsWith) {
                        String h6 = h(o5, pattern, hashMap);
                        String g5 = g(o5, f3201t, str4, hashMap);
                        if (g5 != null) {
                            String[] split = g5.split("@");
                            long parseLong = Long.parseLong(split[0]);
                            if (split.length > 1) {
                                j2 = Long.parseLong(split[1]);
                            } else {
                                j2 = j13;
                            }
                            j5 = parseLong;
                        } else {
                            j2 = j13;
                            j5 = j14;
                        }
                        if (str6 != null && str7 == null) {
                            throw new IOException("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                        }
                        fVar = new f(h6, null, 0L, -1, -9223372036854775807L, null, str6, str7, j2, j5, false);
                        str4 = null;
                        j13 = 0;
                        j14 = -1;
                    } else {
                        if (o5.startsWith("#EXT-X-TARGETDURATION")) {
                            j10 = Integer.parseInt(h(o5, f3195l, Collections.emptyMap())) * 1000000;
                        } else if (o5.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                            j16 = Long.parseLong(h(o5, f3198o, Collections.emptyMap()));
                            j12 = j16;
                        } else if (o5.startsWith("#EXT-X-VERSION")) {
                            i7 = Integer.parseInt(h(o5, f3196m, Collections.emptyMap()));
                        } else {
                            if (o5.startsWith("#EXT-X-DEFINE")) {
                                String g6 = g(o5, J, null, hashMap);
                                if (g6 != null) {
                                    String str8 = (String) eVar2.f3165j.get(g6);
                                    if (str8 != null) {
                                        hashMap.put(g6, str8);
                                    }
                                } else {
                                    hashMap.put(h(o5, B, hashMap), h(o5, I, hashMap));
                                }
                                treeMap = treeMap3;
                                arrayList = arrayList4;
                                j6 = j9;
                                z5 = z8;
                            } else if (o5.startsWith("#EXTINF")) {
                                Map emptyMap = Collections.emptyMap();
                                g(o5, q, "", hashMap);
                                j17 = (long) (Double.parseDouble(h(o5, f3199p, emptyMap)) * 1000000.0d);
                            } else {
                                if (o5.startsWith("#EXT-X-KEY")) {
                                    String h7 = h(o5, f3202u, hashMap);
                                    String g7 = g(o5, f3203v, "identity", hashMap);
                                    if ("NONE".equals(h7)) {
                                        treeMap3.clear();
                                        z5 = z8;
                                        str6 = null;
                                        str7 = null;
                                    } else {
                                        z5 = z8;
                                        String g8 = g(o5, f3205y, null, hashMap);
                                        if ("identity".equals(g7)) {
                                            if ("AES-128".equals(h7)) {
                                                str7 = g8;
                                                str6 = h(o5, pattern, hashMap);
                                            }
                                        } else {
                                            if (str5 == null) {
                                                if (!"SAMPLE-AES-CENC".equals(h7) && !"SAMPLE-AES-CTR".equals(h7)) {
                                                    str2 = "cbcs";
                                                } else {
                                                    str2 = "cenc";
                                                }
                                                str5 = str2;
                                            }
                                            DrmInitData.SchemeData b5 = b(o5, g7, hashMap);
                                            if (b5 != null) {
                                                treeMap3.put(g7, b5);
                                                str7 = g8;
                                                str6 = null;
                                            }
                                        }
                                        str7 = g8;
                                        str6 = null;
                                    }
                                    drmInitData3 = null;
                                } else {
                                    z5 = z8;
                                    if (o5.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] split2 = h(o5, s, hashMap).split("@");
                                        j14 = Long.parseLong(split2[0]);
                                        if (split2.length > 1) {
                                            j13 = Long.parseLong(split2[1]);
                                        }
                                    } else if (o5.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i6 = Integer.parseInt(o5.substring(o5.indexOf(58) + 1));
                                        eVar2 = eVar;
                                        str4 = null;
                                        z8 = true;
                                    } else if (o5.equals("#EXT-X-DISCONTINUITY")) {
                                        i5++;
                                    } else {
                                        if (o5.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                            if (j11 == 0) {
                                                j11 = j0.i.a(w.y(o5.substring(o5.indexOf(58) + 1))) - j15;
                                            }
                                        } else if (o5.equals("#EXT-X-GAP")) {
                                            eVar2 = eVar;
                                            z8 = z5;
                                            str4 = null;
                                            z10 = true;
                                        } else if (o5.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                            eVar2 = eVar;
                                            z8 = z5;
                                            str4 = null;
                                            z7 = true;
                                        } else if (o5.equals("#EXT-X-ENDLIST")) {
                                            eVar2 = eVar;
                                            z8 = z5;
                                            str4 = null;
                                            z9 = true;
                                        } else if (!o5.startsWith("#")) {
                                            if (str6 == null) {
                                                hexString = null;
                                            } else if (str7 != null) {
                                                hexString = str7;
                                            } else {
                                                hexString = Long.toHexString(j16);
                                            }
                                            j16++;
                                            int i8 = (j14 > (-1L) ? 1 : (j14 == (-1L) ? 0 : -1));
                                            if (i8 == 0) {
                                                j7 = 0;
                                            } else {
                                                j7 = j13;
                                            }
                                            if (drmInitData3 == null && !treeMap3.isEmpty()) {
                                                DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap3.values().toArray(new DrmInitData.SchemeData[0]);
                                                DrmInitData drmInitData4 = new DrmInitData(str5, true, schemeDataArr);
                                                if (drmInitData2 == null) {
                                                    DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
                                                    treeMap2 = treeMap3;
                                                    drmInitData = drmInitData4;
                                                    int i9 = 0;
                                                    while (i9 < schemeDataArr.length) {
                                                        DrmInitData.SchemeData schemeData = schemeDataArr[i9];
                                                        schemeDataArr2[i9] = new DrmInitData.SchemeData(schemeData.b, schemeData.c, schemeData.d, null);
                                                        i9++;
                                                        schemeDataArr = schemeDataArr;
                                                        j9 = j9;
                                                        arrayList4 = arrayList4;
                                                    }
                                                    arrayList2 = arrayList4;
                                                    j8 = j9;
                                                    str3 = null;
                                                    drmInitData2 = new DrmInitData(str5, true, schemeDataArr2);
                                                } else {
                                                    treeMap2 = treeMap3;
                                                    arrayList2 = arrayList4;
                                                    j8 = j9;
                                                    drmInitData = drmInitData4;
                                                    str3 = null;
                                                }
                                                drmInitData3 = drmInitData;
                                            } else {
                                                treeMap2 = treeMap3;
                                                arrayList2 = arrayList4;
                                                j8 = j9;
                                                str3 = null;
                                            }
                                            arrayList3.add(new f(i(o5, hashMap), fVar, j17, i5, j15, drmInitData3, str6, hexString, j7, j14, z10));
                                            j15 += j17;
                                            if (i8 != 0) {
                                                j7 += j14;
                                            }
                                            j13 = j7;
                                            eVar2 = eVar;
                                            str4 = str3;
                                            z8 = z5;
                                            treeMap3 = treeMap2;
                                            j9 = j8;
                                            arrayList4 = arrayList2;
                                            z10 = false;
                                            j14 = -1;
                                        }
                                        treeMap = treeMap3;
                                        arrayList = arrayList4;
                                        j6 = j9;
                                    }
                                }
                                eVar2 = eVar;
                                z8 = z5;
                            }
                            eVar2 = eVar;
                            str4 = null;
                            z8 = z5;
                            treeMap3 = treeMap;
                            j9 = j6;
                            arrayList4 = arrayList;
                        }
                        str4 = null;
                    }
                }
            }
            ArrayList arrayList5 = arrayList4;
            long j18 = j9;
            boolean z11 = z8;
            if (j11 != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            return new g(i3, str, arrayList5, j18, j11, z11, i6, j12, i7, j10, z7, z9, z3, drmInitData2, arrayList3);
        }
    }

    public static boolean e(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).equals("YES");
        }
        return false;
    }

    public static String g(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
        }
        if (!map.isEmpty() && str2 != null) {
            return i(str2, map);
        }
        return str2;
    }

    public static String h(String str, Pattern pattern, Map map) {
        String g5 = g(str, pattern, null, map);
        if (g5 != null) {
            return g5;
        }
        throw new IOException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static String i(String str, Map map) {
        Matcher matcher = K.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x009f, code lost:
        g2.w.g(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00fb, code lost:
        return r7;
     */
    @Override // e2.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(android.net.Uri r7, e2.k r8) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.i.f(android.net.Uri, e2.k):java.lang.Object");
    }
}

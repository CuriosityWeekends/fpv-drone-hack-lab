package n1;

import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import e2.h0;
import g2.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends DefaultHandler implements h0 {
    public static final Pattern b = Pattern.compile("(\\d+)(?:/(\\d+))?");
    public static final Pattern c = Pattern.compile("CC([1-4])=.*");
    public static final Pattern d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: a  reason: collision with root package name */
    public final XmlPullParserFactory f2926a;

    public d() {
        try {
            this.f2926a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e5) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e5);
        }
    }

    public static long a(ArrayList arrayList, long j2, long j5, int i3, long j6) {
        int i5;
        if (i3 >= 0) {
            i5 = i3 + 1;
        } else {
            int i6 = w.f1960a;
            i5 = (int) ((((j6 - j2) + j5) - 1) / j5);
        }
        for (int i7 = 0; i7 < i5; i7++) {
            arrayList.add(new p(j2, j5));
            j2 += j5;
        }
        return j2;
    }

    public static void b(XmlPullParser xmlPullParser) {
        if (!g2.b.s(xmlPullParser)) {
            return;
        }
        int i3 = 1;
        while (i3 != 0) {
            xmlPullParser.next();
            if (g2.b.s(xmlPullParser)) {
                i3++;
            } else if (xmlPullParser.getEventType() == 3) {
                i3--;
            }
        }
    }

    public static boolean c(String str) {
        if (!"text".equals(g2.k.d(str)) && !"application/ttml+xml".equals(str) && !"application/x-mp4-vtt".equals(str) && !"application/cea-708".equals(str) && !"application/cea-608".equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int d(XmlPullParser xmlPullParser) {
        char c5;
        int i3 = 2;
        int i5 = -1;
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue == null) {
            attributeValue = null;
        }
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(attributeValue)) {
            i5 = l(xmlPullParser, "value", -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(attributeValue) || "urn:dolby:dash:audio_channel_configuration:2011".equals(attributeValue)) {
            String E = w.E(xmlPullParser.getAttributeValue(null, "value"));
            if (E != null) {
                switch (E.hashCode()) {
                    case 1596796:
                        if (E.equals("4000")) {
                            c5 = 0;
                            break;
                        }
                        c5 = 65535;
                        break;
                    case 2937391:
                        if (E.equals("a000")) {
                            c5 = 1;
                            break;
                        }
                        c5 = 65535;
                        break;
                    case 3094035:
                        if (E.equals("f801")) {
                            c5 = 2;
                            break;
                        }
                        c5 = 65535;
                        break;
                    case 3133436:
                        if (E.equals("fa01")) {
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
                        i3 = 1;
                        break;
                    case 2:
                        i3 = 6;
                        break;
                    case 3:
                        i3 = 8;
                        break;
                }
                i5 = i3;
            }
            i3 = -1;
            i5 = i3;
        }
        do {
            xmlPullParser.next();
        } while (!g2.b.r(xmlPullParser, "AudioChannelConfiguration"));
        return i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair e(org.xmlpull.v1.XmlPullParser r13) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.d.e(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    public static int g(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if (!"text".equals(attributeValue)) {
            return -1;
        }
        return 3;
    }

    public static int h(String str) {
        if (str == null) {
            return 0;
        }
        char c5 = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c5 = 2;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c5 = 3;
                    break;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    c5 = 4;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c5 = 5;
                    break;
                }
                break;
            case 3530173:
                if (str.equals("sign")) {
                    c5 = 6;
                    break;
                }
                break;
            case 552573414:
                if (str.equals("caption")) {
                    c5 = 7;
                    break;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c5 = '\b';
                    break;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c5 = '\t';
                    break;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c5 = '\n';
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 3:
                return 2;
            case 4:
                return 16;
            case 5:
                return 1;
            case 6:
                return 256;
            case 7:
                return 64;
            case '\b':
                return 8;
            case '\t':
                return 32;
            case '\n':
                return 4;
            default:
                return 0;
        }
    }

    public static e i(XmlPullParser xmlPullParser, String str) {
        String str2 = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue == null) {
            attributeValue = "";
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue2 == null) {
            attributeValue2 = null;
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "id");
        if (attributeValue3 != null) {
            str2 = attributeValue3;
        }
        do {
            xmlPullParser.next();
        } while (!g2.b.r(xmlPullParser, str));
        return new e(attributeValue, attributeValue2, str2);
    }

    public static long j(XmlPullParser xmlPullParser, String str, long j2) {
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j2;
        }
        Matcher matcher = w.f1964h.matcher(attributeValue);
        if (matcher.matches()) {
            boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
            String group = matcher.group(3);
            double d10 = 0.0d;
            if (group != null) {
                d5 = Double.parseDouble(group) * 3.1556908E7d;
            } else {
                d5 = 0.0d;
            }
            String group2 = matcher.group(5);
            if (group2 != null) {
                d6 = Double.parseDouble(group2) * 2629739.0d;
            } else {
                d6 = 0.0d;
            }
            double d11 = d5 + d6;
            String group3 = matcher.group(7);
            if (group3 != null) {
                d7 = Double.parseDouble(group3) * 86400.0d;
            } else {
                d7 = 0.0d;
            }
            double d12 = d11 + d7;
            String group4 = matcher.group(10);
            if (group4 != null) {
                d8 = Double.parseDouble(group4) * 3600.0d;
            } else {
                d8 = 0.0d;
            }
            double d13 = d12 + d8;
            String group5 = matcher.group(12);
            if (group5 != null) {
                d9 = Double.parseDouble(group5) * 60.0d;
            } else {
                d9 = 0.0d;
            }
            double d14 = d13 + d9;
            String group6 = matcher.group(14);
            if (group6 != null) {
                d10 = Double.parseDouble(group6);
            }
            long j5 = (long) ((d14 + d10) * 1000.0d);
            if (isEmpty) {
                return -j5;
            }
            return j5;
        }
        return (long) (Double.parseDouble(attributeValue) * 3600.0d * 1000.0d);
    }

    public static float k(XmlPullParser xmlPullParser, float f4) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = b.matcher(attributeValue);
            if (matcher.matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                String group = matcher.group(2);
                if (!TextUtils.isEmpty(group)) {
                    return parseInt / Integer.parseInt(group);
                }
                return parseInt;
            }
            return f4;
        }
        return f4;
    }

    public static int l(XmlPullParser xmlPullParser, String str, int i3) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Integer.parseInt(attributeValue);
        }
        return i3;
    }

    public static long m(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            return Long.parseLong(attributeValue);
        }
        return j2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0819  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x081c  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x084b  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x086b  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0891 A[LOOP:7: B:133:0x045d->B:351:0x0891, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0ace A[LOOP:3: B:76:0x0274->B:419:0x0ace, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0de8  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0df9  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x095d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:533:0x0574 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static n1.b n(org.xmlpull.v1.XmlPullParser r146, java.lang.String r147) {
        /*
            Method dump skipped, instructions count: 3656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.d.n(org.xmlpull.v1.XmlPullParser, java.lang.String):n1.b");
    }

    public static i o(XmlPullParser xmlPullParser, String str, String str2) {
        long j2;
        long j5;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j2 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j5 = (Long.parseLong(split[1]) - j2) + 1;
                return new i(j2, j5, attributeValue);
            }
        } else {
            j2 = 0;
        }
        j5 = -1;
        return new i(j2, j5, attributeValue);
    }

    public static q p(XmlPullParser xmlPullParser, q qVar) {
        long j2;
        long j5;
        long j6;
        long j7;
        long j8;
        if (qVar != null) {
            j2 = qVar.b;
        } else {
            j2 = 1;
        }
        long m5 = m(xmlPullParser, "timescale", j2);
        long j9 = 0;
        if (qVar != null) {
            j5 = qVar.c;
        } else {
            j5 = 0;
        }
        long m6 = m(xmlPullParser, "presentationTimeOffset", j5);
        if (qVar != null) {
            j6 = qVar.d;
        } else {
            j6 = 0;
        }
        if (qVar != null) {
            j9 = qVar.f2946e;
        }
        i iVar = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            long parseLong = Long.parseLong(split[0]);
            j7 = (Long.parseLong(split[1]) - parseLong) + 1;
            j8 = parseLong;
        } else {
            j7 = j9;
            j8 = j6;
        }
        if (qVar != null) {
            iVar = qVar.f2947a;
        }
        do {
            xmlPullParser.next();
            if (g2.b.t(xmlPullParser, "Initialization")) {
                iVar = o(xmlPullParser, "sourceURL", "range");
            } else {
                b(xmlPullParser);
            }
        } while (!g2.b.r(xmlPullParser, "SegmentBase"));
        return new q(iVar, m5, m6, j8, j7);
    }

    public static n q(XmlPullParser xmlPullParser, n nVar, long j2) {
        long j5;
        long j6;
        long j7;
        long j8 = 1;
        if (nVar != null) {
            j5 = nVar.b;
        } else {
            j5 = 1;
        }
        long m5 = m(xmlPullParser, "timescale", j5);
        if (nVar != null) {
            j6 = nVar.c;
        } else {
            j6 = 0;
        }
        long m6 = m(xmlPullParser, "presentationTimeOffset", j6);
        if (nVar != null) {
            j7 = nVar.f2939e;
        } else {
            j7 = -9223372036854775807L;
        }
        long m7 = m(xmlPullParser, "duration", j7);
        if (nVar != null) {
            j8 = nVar.d;
        }
        long m8 = m(xmlPullParser, "startNumber", j8);
        List list = null;
        i iVar = null;
        List list2 = null;
        do {
            xmlPullParser.next();
            if (g2.b.t(xmlPullParser, "Initialization")) {
                iVar = o(xmlPullParser, "sourceURL", "range");
            } else if (g2.b.t(xmlPullParser, "SegmentTimeline")) {
                list2 = s(xmlPullParser, m5, j2);
            } else if (g2.b.t(xmlPullParser, "SegmentURL")) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(o(xmlPullParser, "media", "mediaRange"));
            } else {
                b(xmlPullParser);
            }
        } while (!g2.b.r(xmlPullParser, "SegmentList"));
        if (nVar != null) {
            if (iVar == null) {
                iVar = nVar.f2947a;
            }
            if (list2 == null) {
                list2 = nVar.f2940f;
            }
            if (list == null) {
                list = nVar.f2941g;
            }
        }
        return new n(iVar, m5, m6, m8, m7, list2, list);
    }

    public static o r(XmlPullParser xmlPullParser, o oVar, List list, long j2) {
        long j5;
        long j6;
        long j7;
        long j8;
        a2.l lVar;
        a2.l lVar2;
        long j9 = 1;
        if (oVar != null) {
            j5 = oVar.b;
        } else {
            j5 = 1;
        }
        long m5 = m(xmlPullParser, "timescale", j5);
        if (oVar != null) {
            j6 = oVar.c;
        } else {
            j6 = 0;
        }
        long m6 = m(xmlPullParser, "presentationTimeOffset", j6);
        if (oVar != null) {
            j7 = oVar.f2939e;
        } else {
            j7 = -9223372036854775807L;
        }
        long m7 = m(xmlPullParser, "duration", j7);
        if (oVar != null) {
            j9 = oVar.d;
        }
        long m8 = m(xmlPullParser, "startNumber", j9);
        int i3 = 0;
        while (true) {
            if (i3 < list.size()) {
                e eVar = (e) list.get(i3);
                if ("http://dashif.org/guidelines/last-segment-number".equalsIgnoreCase(eVar.f2927a)) {
                    j8 = Long.parseLong(eVar.b);
                    break;
                }
                i3++;
            } else {
                j8 = -1;
                break;
            }
        }
        long j10 = j8;
        i iVar = null;
        if (oVar != null) {
            lVar = oVar.f2943h;
        } else {
            lVar = null;
        }
        a2.l u5 = u(xmlPullParser, "media", lVar);
        if (oVar != null) {
            lVar2 = oVar.f2942g;
        } else {
            lVar2 = null;
        }
        a2.l u6 = u(xmlPullParser, "initialization", lVar2);
        List list2 = null;
        do {
            xmlPullParser.next();
            if (g2.b.t(xmlPullParser, "Initialization")) {
                iVar = o(xmlPullParser, "sourceURL", "range");
            } else if (g2.b.t(xmlPullParser, "SegmentTimeline")) {
                list2 = s(xmlPullParser, m5, j2);
            } else {
                b(xmlPullParser);
            }
        } while (!g2.b.r(xmlPullParser, "SegmentTemplate"));
        if (oVar != null) {
            if (iVar == null) {
                iVar = oVar.f2947a;
            }
            if (list2 == null) {
                list2 = oVar.f2940f;
            }
        }
        return new o(iVar, m5, m6, m8, j10, m7, list2, u6, u5);
    }

    public static ArrayList s(XmlPullParser xmlPullParser, long j2, long j5) {
        ArrayList arrayList = new ArrayList();
        long j6 = 0;
        long j7 = -9223372036854775807L;
        boolean z3 = false;
        int i3 = 0;
        do {
            xmlPullParser.next();
            if (g2.b.t(xmlPullParser, ExifInterface.LATITUDE_SOUTH)) {
                long m5 = m(xmlPullParser, "t", -9223372036854775807L);
                if (z3) {
                    j6 = a(arrayList, j6, j7, i3, m5);
                }
                if (m5 == -9223372036854775807L) {
                    m5 = j6;
                }
                j7 = m(xmlPullParser, "d", -9223372036854775807L);
                i3 = l(xmlPullParser, "r", 0);
                j6 = m5;
                z3 = true;
            } else {
                b(xmlPullParser);
            }
        } while (!g2.b.r(xmlPullParser, "SegmentTimeline"));
        if (z3) {
            a(arrayList, j6, j7, i3, w.B(j5, j2, 1000L));
        }
        return arrayList;
    }

    public static String t(XmlPullParser xmlPullParser, String str) {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                b(xmlPullParser);
            }
        } while (!g2.b.r(xmlPullParser, str));
        return str2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static a2.l u(XmlPullParser xmlPullParser, String str, a2.l lVar) {
        String str2;
        char c5;
        int i3 = -1;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue != null) {
            String[] strArr = new String[5];
            int[] iArr = new int[4];
            String[] strArr2 = new String[4];
            strArr[0] = "";
            int i5 = 0;
            int i6 = 0;
            while (i5 < attributeValue.length()) {
                int indexOf = attributeValue.indexOf("$", i5);
                if (indexOf == i3) {
                    strArr[i6] = strArr[i6] + attributeValue.substring(i5);
                    i5 = attributeValue.length();
                } else if (indexOf != i5) {
                    strArr[i6] = strArr[i6] + attributeValue.substring(i5, indexOf);
                    i5 = indexOf;
                } else if (attributeValue.startsWith("$$", i5)) {
                    strArr[i6] = a1.i.k(new StringBuilder(), strArr[i6], "$");
                    i5 += 2;
                } else {
                    int i7 = i5 + 1;
                    int indexOf2 = attributeValue.indexOf("$", i7);
                    String substring = attributeValue.substring(i7, indexOf2);
                    if (substring.equals("RepresentationID")) {
                        iArr[i6] = 1;
                    } else {
                        int indexOf3 = substring.indexOf("%0");
                        if (indexOf3 != i3) {
                            str2 = substring.substring(indexOf3);
                            if (!str2.endsWith("d") && !str2.endsWith("x")) {
                                str2 = str2.concat("d");
                            }
                            substring = substring.substring(0, indexOf3);
                        } else {
                            str2 = "%01d";
                        }
                        substring.getClass();
                        switch (substring.hashCode()) {
                            case -1950496919:
                                if (substring.equals("Number")) {
                                    c5 = 0;
                                    break;
                                }
                                c5 = 65535;
                                break;
                            case 2606829:
                                if (substring.equals("Time")) {
                                    c5 = 1;
                                    break;
                                }
                                c5 = 65535;
                                break;
                            case 38199441:
                                if (substring.equals("Bandwidth")) {
                                    c5 = 2;
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
                                iArr[i6] = 2;
                                break;
                            case 1:
                                iArr[i6] = 4;
                                break;
                            case 2:
                                iArr[i6] = 3;
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid template: ".concat(attributeValue));
                        }
                        strArr2[i6] = str2;
                    }
                    i6++;
                    strArr[i6] = "";
                    i5 = indexOf2 + 1;
                }
                i3 = -1;
            }
            return new a2.l(strArr, iArr, strArr2, i6);
        }
        return lVar;
    }

    @Override // e2.h0
    public final Object f(Uri uri, e2.k kVar) {
        try {
            XmlPullParser newPullParser = this.f2926a.newPullParser();
            newPullParser.setInput(kVar, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return n(newPullParser, uri.toString());
            }
            throw new IOException("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e5) {
            throw new IOException(e5);
        }
    }
}

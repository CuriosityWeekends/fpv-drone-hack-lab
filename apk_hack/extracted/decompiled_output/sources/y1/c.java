package y1;

import a1.i;
import android.text.Layout;
import android.util.Log;
import g2.w;
import j1.a0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import s1.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends s1.c {

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f4226o = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f4227p = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern q = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f4228r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    public static final Pattern s = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: t  reason: collision with root package name */
    public static final Pattern f4229t = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: u  reason: collision with root package name */
    public static final a f4230u = new a(1, 30.0f, 1);

    /* renamed from: v  reason: collision with root package name */
    public static final h0.a f4231v = new h0.a(15);

    /* renamed from: n  reason: collision with root package name */
    public final XmlPullParserFactory f4232n;

    public c() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f4232n = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e5) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e5);
        }
    }

    public static f i(f fVar) {
        if (fVar == null) {
            return new f();
        }
        return fVar;
    }

    public static boolean j(String str) {
        if (!str.equals("tt") && !str.equals("head") && !str.equals("body") && !str.equals("div") && !str.equals("p") && !str.equals("span") && !str.equals("br") && !str.equals("style") && !str.equals("styling") && !str.equals("layout") && !str.equals("region") && !str.equals("metadata") && !str.equals("image") && !str.equals("data") && !str.equals("information")) {
            return false;
        }
        return true;
    }

    public static h0.a k(XmlPullParser xmlPullParser, h0.a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f4229t.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt != 0 && parseInt2 != 0) {
                return new h0.a(parseInt2);
            }
            throw new Exception("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return aVar;
        }
    }

    public static void l(String str, f fVar) {
        Matcher matcher;
        char c = 65535;
        int i3 = w.f1960a;
        String[] split = str.split("\\s+", -1);
        int length = split.length;
        Pattern pattern = q;
        if (length == 1) {
            matcher = pattern.matcher(str);
        } else if (split.length == 2) {
            matcher = pattern.matcher(split[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new Exception(i.j(new StringBuilder("Invalid number of entries for fontSize: "), split.length, "."));
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            group.getClass();
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    fVar.f4254j = 3;
                    break;
                case 1:
                    fVar.f4254j = 2;
                    break;
                case 2:
                    fVar.f4254j = 1;
                    break;
                default:
                    throw new Exception(i.i("Invalid unit for fontSize: '", group, "'."));
            }
            fVar.f4255k = Float.valueOf(matcher.group(1)).floatValue();
            return;
        }
        throw new Exception(i.i("Invalid expression for fontSize: '", str, "'."));
    }

    public static a m(XmlPullParser xmlPullParser) {
        int i3;
        float f4;
        int i5;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i3 = Integer.parseInt(attributeValue);
        } else {
            i3 = 30;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i6 = w.f1960a;
            String[] split = attributeValue2.split(" ", -1);
            if (split.length == 2) {
                f4 = Integer.parseInt(split[0]) / Integer.parseInt(split[1]);
            } else {
                throw new Exception("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f4 = 1.0f;
        }
        a aVar = f4230u;
        int i7 = aVar.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i7 = Integer.parseInt(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i5 = Integer.parseInt(attributeValue4);
        } else {
            i5 = aVar.c;
        }
        return new a(i7, i3 * f4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void n(org.xmlpull.v1.XmlPullParser r18, java.util.HashMap r19, h0.a r20, y1.b r21, java.util.HashMap r22, java.util.HashMap r23) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.c.n(org.xmlpull.v1.XmlPullParser, java.util.HashMap, h0.a, y1.b, java.util.HashMap, java.util.HashMap):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static d o(XmlPullParser xmlPullParser, d dVar, HashMap hashMap, a aVar) {
        long j2;
        long j5;
        char c;
        String[] split;
        int attributeCount = xmlPullParser.getAttributeCount();
        f p5 = p(xmlPullParser, null);
        String[] strArr = null;
        String str = null;
        String str2 = "";
        long j6 = -9223372036854775807L;
        long j7 = -9223372036854775807L;
        long j8 = -9223372036854775807L;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            attributeName.getClass();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    if (hashMap.containsKey(attributeValue)) {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j8 = q(attributeValue, aVar);
                    break;
                case 2:
                    j7 = q(attributeValue, aVar);
                    break;
                case 3:
                    j6 = q(attributeValue, aVar);
                    break;
                case 4:
                    String trim = attributeValue.trim();
                    if (trim.isEmpty()) {
                        split = new String[0];
                    } else {
                        int i5 = w.f1960a;
                        split = trim.split("\\s+", -1);
                    }
                    if (split.length > 0) {
                        strArr = split;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (dVar != null) {
            long j9 = dVar.d;
            j2 = -9223372036854775807L;
            if (j9 != -9223372036854775807L) {
                if (j6 != -9223372036854775807L) {
                    j6 += j9;
                }
                if (j7 != -9223372036854775807L) {
                    j7 += j9;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        long j10 = j6;
        if (j7 == j2) {
            if (j8 != j2) {
                j5 = j10 + j8;
            } else if (dVar != null) {
                long j11 = dVar.f4234e;
                if (j11 != j2) {
                    j5 = j11;
                }
            }
            return new d(xmlPullParser.getName(), null, j10, j5, p5, strArr, str2, str);
        }
        j5 = j7;
        return new d(xmlPullParser.getName(), null, j10, j5, p5, strArr, str2, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static f p(XmlPullParser xmlPullParser, f fVar) {
        char c;
        String str;
        char c5;
        char c6;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            String attributeName = xmlPullParser.getAttributeName(i3);
            attributeName.getClass();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    fVar = i(fVar);
                    fVar.f4253i = "italic".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    continue;
                case 1:
                    fVar = i(fVar);
                    fVar.f4248a = attributeValue;
                    continue;
                case 2:
                    String E = w.E(attributeValue);
                    E.getClass();
                    switch (E.hashCode()) {
                        case -1364013995:
                            if (E.equals("center")) {
                                c5 = 0;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 100571:
                            if (E.equals("end")) {
                                c5 = 1;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 3317767:
                            if (E.equals("left")) {
                                c5 = 2;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 108511772:
                            if (E.equals("right")) {
                                c5 = 3;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 109757538:
                            if (E.equals("start")) {
                                c5 = 4;
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
                            fVar = i(fVar);
                            fVar.f4257m = Layout.Alignment.ALIGN_CENTER;
                            continue;
                        case 1:
                            fVar = i(fVar);
                            fVar.f4257m = Layout.Alignment.ALIGN_OPPOSITE;
                            continue;
                        case 2:
                            fVar = i(fVar);
                            fVar.f4257m = Layout.Alignment.ALIGN_NORMAL;
                            continue;
                        case 3:
                            fVar = i(fVar);
                            fVar.f4257m = Layout.Alignment.ALIGN_OPPOSITE;
                            continue;
                        case 4:
                            fVar = i(fVar);
                            fVar.f4257m = Layout.Alignment.ALIGN_NORMAL;
                            continue;
                            continue;
                    }
                    break;
                case 3:
                    String E2 = w.E(attributeValue);
                    E2.getClass();
                    switch (E2.hashCode()) {
                        case -1461280213:
                            if (E2.equals("nounderline")) {
                                c6 = 0;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case -1026963764:
                            if (E2.equals("underline")) {
                                c6 = 1;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 913457136:
                            if (E2.equals("nolinethrough")) {
                                c6 = 2;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 1679736913:
                            if (E2.equals("linethrough")) {
                                c6 = 3;
                                break;
                            }
                            c6 = 65535;
                            break;
                        default:
                            c6 = 65535;
                            break;
                    }
                    switch (c6) {
                        case 0:
                            fVar = i(fVar);
                            fVar.f4251g = 0;
                            continue;
                        case 1:
                            fVar = i(fVar);
                            fVar.f4251g = 1;
                            continue;
                        case 2:
                            fVar = i(fVar);
                            fVar.f4250f = 0;
                            continue;
                        case 3:
                            fVar = i(fVar);
                            fVar.f4250f = 1;
                            continue;
                            continue;
                    }
                    break;
                case 4:
                    fVar = i(fVar);
                    fVar.f4252h = "bold".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    continue;
                case 5:
                    if ("style".equals(xmlPullParser.getName())) {
                        fVar = i(fVar);
                        fVar.f4256l = attributeValue;
                    } else {
                        continue;
                    }
                case 6:
                    fVar = i(fVar);
                    try {
                        fVar.b = g2.c.a(attributeValue, false);
                        fVar.c = true;
                        continue;
                    } catch (IllegalArgumentException unused) {
                        str = "Failed parsing color value: ";
                        break;
                    }
                case 7:
                    try {
                        fVar = i(fVar);
                        l(attributeValue, fVar);
                        continue;
                    } catch (g unused2) {
                        str = "Failed parsing fontSize value: ";
                        break;
                    }
                case '\b':
                    fVar = i(fVar);
                    try {
                        fVar.d = g2.c.a(attributeValue, false);
                        fVar.f4249e = true;
                        continue;
                    } catch (IllegalArgumentException unused3) {
                        str = "Failed parsing background value: ";
                        break;
                    }
                default:
            }
            i.t(str, attributeValue, "TtmlDecoder");
        }
        return fVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a0, code lost:
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long q(java.lang.String r13, y1.a r14) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.c.q(java.lang.String, y1.a):long");
    }

    public static b r(XmlPullParser xmlPullParser) {
        String p5 = g2.b.p(xmlPullParser, "extent");
        if (p5 == null) {
            return null;
        }
        Matcher matcher = s.matcher(p5);
        if (!matcher.matches()) {
            Log.w("TtmlDecoder", "Ignoring non-pixel tts extent: ".concat(p5));
            return null;
        }
        try {
            return new b(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } catch (NumberFormatException unused) {
            Log.w("TtmlDecoder", "Ignoring malformed tts extent: ".concat(p5));
            return null;
        }
    }

    @Override // s1.c
    public final s1.e e(byte[] bArr, int i3, boolean z3) {
        h0.a aVar;
        a aVar2;
        try {
            XmlPullParser newPullParser = this.f4232n.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new e(null, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f));
            b bVar = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i3), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            int eventType = newPullParser.getEventType();
            a aVar3 = f4230u;
            h0.a aVar4 = f4231v;
            a0 a0Var = null;
            h0.a aVar5 = aVar4;
            int i5 = 0;
            while (eventType != 1) {
                d dVar = (d) arrayDeque.peek();
                if (i5 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            aVar3 = m(newPullParser);
                            aVar5 = k(newPullParser, aVar4);
                            bVar = r(newPullParser);
                        }
                        h0.a aVar6 = aVar5;
                        b bVar2 = bVar;
                        a aVar7 = aVar3;
                        if (!j(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i5++;
                            aVar5 = aVar6;
                            aVar3 = aVar7;
                        } else {
                            if ("head".equals(name)) {
                                aVar = aVar6;
                                aVar2 = aVar7;
                                n(newPullParser, hashMap, aVar6, bVar2, hashMap2, hashMap3);
                            } else {
                                aVar = aVar6;
                                aVar2 = aVar7;
                                try {
                                    d o5 = o(newPullParser, dVar, hashMap2, aVar2);
                                    arrayDeque.push(o5);
                                    if (dVar != null) {
                                        if (dVar.f4241l == null) {
                                            dVar.f4241l = new ArrayList();
                                        }
                                        dVar.f4241l.add(o5);
                                    }
                                } catch (g e5) {
                                    Log.w("TtmlDecoder", "Suppressing parser error", e5);
                                    i5++;
                                }
                            }
                            aVar5 = aVar;
                            aVar3 = aVar2;
                        }
                        bVar = bVar2;
                    } else if (eventType == 4) {
                        d a5 = d.a(newPullParser.getText());
                        if (dVar.f4241l == null) {
                            dVar.f4241l = new ArrayList();
                        }
                        dVar.f4241l.add(a5);
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            a0Var = new a0((d) arrayDeque.peek(), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i5++;
                } else if (eventType == 3) {
                    i5--;
                }
                newPullParser.next();
                eventType = newPullParser.getEventType();
            }
            return a0Var;
        } catch (IOException e6) {
            throw new IllegalStateException("Unexpected error when reading input.", e6);
        } catch (XmlPullParserException e7) {
            throw new Exception("Unable to decode source", e7);
        }
    }
}

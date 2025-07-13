package a2;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import g2.w;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {
    public static final Pattern b = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    public static final Pattern c = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f75a = new StringBuilder();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(String str, g gVar, SpannableStringBuilder spannableStringBuilder, List list, ArrayList arrayList) {
        char c5;
        int i3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        int i16 = gVar.b;
        int length = spannableStringBuilder.length();
        String str2 = gVar.f73a;
        str2.getClass();
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c5 = 0;
                    break;
                }
                c5 = 65535;
                break;
            case 98:
                if (str2.equals("b")) {
                    c5 = 1;
                    break;
                }
                c5 = 65535;
                break;
            case 99:
                if (str2.equals("c")) {
                    c5 = 2;
                    break;
                }
                c5 = 65535;
                break;
            case 105:
                if (str2.equals("i")) {
                    c5 = 3;
                    break;
                }
                c5 = 65535;
                break;
            case 117:
                if (str2.equals("u")) {
                    c5 = 4;
                    break;
                }
                c5 = 65535;
                break;
            case 118:
                if (str2.equals("v")) {
                    c5 = 5;
                    break;
                }
                c5 = 65535;
                break;
            case 3314158:
                if (str2.equals("lang")) {
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
            case 2:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i16, length, 33);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i16, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i16, length, 33);
                break;
            default:
                return;
        }
        arrayList.clear();
        int size = list.size();
        int i17 = 0;
        while (i17 < size) {
            d dVar = (d) list.get(i17);
            if (dVar.f53a.isEmpty() && dVar.b.isEmpty() && dVar.c.isEmpty() && dVar.d.isEmpty()) {
                i14 = TextUtils.isEmpty(str2);
            } else {
                int a5 = d.a(dVar.d, gVar.c, d.a(dVar.b, str2, d.a(dVar.f53a, str, i15, BasicMeasure.EXACTLY), 2), 4);
                if (a5 != -1 && Arrays.asList(gVar.d).containsAll(dVar.c)) {
                    i14 = (dVar.c.size() * 4) + a5;
                } else {
                    i14 = 0;
                }
            }
            if (i14 > 0) {
                arrayList.add(new h(i14, dVar));
            }
            i17++;
            i15 = 0;
        }
        Collections.sort(arrayList);
        int size2 = arrayList.size();
        int i18 = 0;
        while (i18 < size2) {
            d dVar2 = ((h) arrayList.get(i18)).b;
            if (dVar2 != null) {
                int i19 = dVar2.f61l;
                if (i19 == -1 && dVar2.f62m == -1) {
                    i7 = -1;
                    i6 = -1;
                } else {
                    if (i19 == 1) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (dVar2.f62m == 1) {
                        i5 = 2;
                    } else {
                        i5 = 0;
                    }
                    i6 = i3 | i5;
                    i7 = -1;
                }
                if (i6 != i7) {
                    int i20 = dVar2.f61l;
                    if (i20 == i7 && dVar2.f62m == i7) {
                        i13 = -1;
                        i9 = 1;
                    } else {
                        i9 = 1;
                        if (i20 == 1) {
                            i11 = 1;
                        } else {
                            i11 = 0;
                        }
                        if (dVar2.f62m == 1) {
                            i12 = 2;
                        } else {
                            i12 = 0;
                        }
                        i13 = i11 | i12;
                    }
                    StyleSpan styleSpan = new StyleSpan(i13);
                    i8 = 33;
                    spannableStringBuilder.setSpan(styleSpan, i16, length, 33);
                } else {
                    i8 = 33;
                    i9 = 1;
                }
                if (dVar2.f59j == i9) {
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), i16, length, i8);
                }
                if (dVar2.f60k == i9) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i16, length, i8);
                }
                if (dVar2.f56g) {
                    if (dVar2.f56g) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar2.f55f), i16, length, 33);
                    } else {
                        throw new IllegalStateException("Font color not defined");
                    }
                }
                if (dVar2.f58i) {
                    if (dVar2.f58i) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar2.f57h), i16, length, 33);
                    } else {
                        throw new IllegalStateException("Background color not defined.");
                    }
                }
                if (dVar2.f54e != null) {
                    spannableStringBuilder.setSpan(new TypefaceSpan(dVar2.f54e), i16, length, 33);
                }
                int i21 = dVar2.f63n;
                if (i21 != 1) {
                    if (i21 != 2) {
                        if (i21 == 3) {
                            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.0f), i16, length, 33);
                        }
                    } else {
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.0f), i16, length, 33);
                    }
                    i10 = 1;
                    i18 += i10;
                } else {
                    i10 = 1;
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) 0.0f, true), i16, length, 33);
                    i18 += i10;
                }
            }
            i10 = 1;
            i18 += i10;
        }
    }

    public static boolean b(String str, Matcher matcher, c0.b bVar, e eVar, StringBuilder sb, List list) {
        try {
            eVar.f64a = k.c(matcher.group(1));
            eVar.b = k.c(matcher.group(2));
            c(matcher.group(3), eVar);
            sb.setLength(0);
            String d = bVar.d();
            while (!TextUtils.isEmpty(d)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(d.trim());
                d = bVar.d();
            }
            d(str, sb.toString(), eVar, list);
            return true;
        } catch (NumberFormatException unused) {
            Log.w("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void c(String str, e eVar) {
        char c5;
        int i3;
        char c6;
        int i5;
        char c7;
        int i6;
        Matcher matcher = c.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    int indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        String substring = group2.substring(indexOf + 1);
                        substring.getClass();
                        switch (substring.hashCode()) {
                            case -1364013995:
                                if (substring.equals("center")) {
                                    c5 = 0;
                                    break;
                                }
                                c5 = 65535;
                                break;
                            case -1074341483:
                                if (substring.equals("middle")) {
                                    c5 = 1;
                                    break;
                                }
                                c5 = 65535;
                                break;
                            case 100571:
                                if (substring.equals("end")) {
                                    c5 = 2;
                                    break;
                                }
                                c5 = 65535;
                                break;
                            case 109757538:
                                if (substring.equals("start")) {
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
                            case 1:
                                i3 = 1;
                                break;
                            case 2:
                                i3 = 2;
                                break;
                            case 3:
                                i3 = 0;
                                break;
                            default:
                                Log.w("WebvttCueParser", "Invalid anchor value: ".concat(substring));
                                i3 = Integer.MIN_VALUE;
                                break;
                        }
                        eVar.f67g = i3;
                        group2 = group2.substring(0, indexOf);
                    }
                    if (group2.endsWith("%")) {
                        eVar.f65e = k.b(group2);
                        eVar.f66f = 0;
                    } else {
                        int parseInt = Integer.parseInt(group2);
                        if (parseInt < 0) {
                            parseInt--;
                        }
                        eVar.f65e = parseInt;
                        eVar.f66f = 1;
                    }
                } else if ("align".equals(group)) {
                    group2.getClass();
                    switch (group2.hashCode()) {
                        case -1364013995:
                            if (group2.equals("center")) {
                                c6 = 0;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case -1074341483:
                            if (group2.equals("middle")) {
                                c6 = 1;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 100571:
                            if (group2.equals("end")) {
                                c6 = 2;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 3317767:
                            if (group2.equals("left")) {
                                c6 = 3;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 108511772:
                            if (group2.equals("right")) {
                                c6 = 4;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 109757538:
                            if (group2.equals("start")) {
                                c6 = 5;
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
                        case 1:
                            i5 = 2;
                            break;
                        case 2:
                            i5 = 3;
                            break;
                        case 3:
                            i5 = 4;
                            break;
                        case 4:
                            i5 = 5;
                            break;
                        case 5:
                            i5 = 1;
                            break;
                        default:
                            Log.w("WebvttCueParser", "Invalid alignment value: ".concat(group2));
                            i5 = 2;
                            break;
                    }
                    eVar.d = i5;
                } else if ("position".equals(group)) {
                    int indexOf2 = group2.indexOf(44);
                    if (indexOf2 != -1) {
                        String substring2 = group2.substring(indexOf2 + 1);
                        substring2.getClass();
                        switch (substring2.hashCode()) {
                            case -1364013995:
                                if (substring2.equals("center")) {
                                    c7 = 0;
                                    break;
                                }
                                c7 = 65535;
                                break;
                            case -1074341483:
                                if (substring2.equals("middle")) {
                                    c7 = 1;
                                    break;
                                }
                                c7 = 65535;
                                break;
                            case 100571:
                                if (substring2.equals("end")) {
                                    c7 = 2;
                                    break;
                                }
                                c7 = 65535;
                                break;
                            case 109757538:
                                if (substring2.equals("start")) {
                                    c7 = 3;
                                    break;
                                }
                                c7 = 65535;
                                break;
                            default:
                                c7 = 65535;
                                break;
                        }
                        switch (c7) {
                            case 0:
                            case 1:
                                i6 = 1;
                                break;
                            case 2:
                                i6 = 2;
                                break;
                            case 3:
                                i6 = 0;
                                break;
                            default:
                                Log.w("WebvttCueParser", "Invalid anchor value: ".concat(substring2));
                                i6 = Integer.MIN_VALUE;
                                break;
                        }
                        eVar.f69i = i6;
                        group2 = group2.substring(0, indexOf2);
                    }
                    eVar.f68h = k.b(group2);
                } else if ("size".equals(group)) {
                    eVar.f70j = k.b(group2);
                } else {
                    Log.w("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException unused) {
                Log.w("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public static void d(String str, String str2, e eVar, List list) {
        char c5;
        boolean z3;
        boolean z5;
        int i3;
        char c6;
        char c7;
        String[] strArr;
        boolean z6;
        int i5 = -1;
        int i6 = 2;
        int i7 = 1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        while (true) {
            String str3 = "";
            if (i8 < str2.length()) {
                char charAt = str2.charAt(i8);
                if (charAt != '&') {
                    if (charAt != '<') {
                        spannableStringBuilder.append(charAt);
                        i8 += i7;
                    } else {
                        int i9 = i8 + 1;
                        if (i9 < str2.length()) {
                            if (str2.charAt(i9) == '/') {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            int indexOf = str2.indexOf(62, i9);
                            if (indexOf == i5) {
                                i9 = str2.length();
                            } else {
                                i9 = indexOf + i7;
                            }
                            int i10 = i9 - 2;
                            if (str2.charAt(i10) == '/') {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z3) {
                                i3 = 2;
                            } else {
                                i3 = 1;
                            }
                            int i11 = i8 + i3;
                            if (!z5) {
                                i10 = i9 - 1;
                            }
                            String substring = str2.substring(i11, i10);
                            if (!substring.trim().isEmpty()) {
                                String trim = substring.trim();
                                g2.b.e(trim.isEmpty() ^ i7);
                                int i12 = w.f1960a;
                                String str4 = trim.split("[ \\.]", i6)[0];
                                str4.getClass();
                                switch (str4.hashCode()) {
                                    case 98:
                                        if (str4.equals("b")) {
                                            c6 = 0;
                                            break;
                                        }
                                        c6 = 65535;
                                        break;
                                    case 99:
                                        if (str4.equals("c")) {
                                            c6 = 1;
                                            break;
                                        }
                                        c6 = 65535;
                                        break;
                                    case 105:
                                        if (str4.equals("i")) {
                                            c6 = 2;
                                            break;
                                        }
                                        c6 = 65535;
                                        break;
                                    case 117:
                                        if (str4.equals("u")) {
                                            c6 = 3;
                                            break;
                                        }
                                        c6 = 65535;
                                        break;
                                    case 118:
                                        if (str4.equals("v")) {
                                            c6 = 4;
                                            break;
                                        }
                                        c6 = 65535;
                                        break;
                                    case 3314158:
                                        if (str4.equals("lang")) {
                                            c6 = 5;
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
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                        if (z3) {
                                            while (!arrayDeque.isEmpty()) {
                                                g gVar = (g) arrayDeque.pop();
                                                a(str, gVar, spannableStringBuilder, list, arrayList);
                                                if (gVar.f73a.equals(str4)) {
                                                    break;
                                                }
                                            }
                                            break;
                                        } else if (!z5) {
                                            int length = spannableStringBuilder.length();
                                            String trim2 = substring.trim();
                                            g2.b.e(trim2.isEmpty() ^ i7);
                                            int indexOf2 = trim2.indexOf(" ");
                                            if (indexOf2 == -1) {
                                                c7 = 0;
                                            } else {
                                                str3 = trim2.substring(indexOf2).trim();
                                                c7 = 0;
                                                trim2 = trim2.substring(0, indexOf2);
                                            }
                                            String[] split = trim2.split("\\.", -1);
                                            String str5 = split[c7];
                                            if (split.length > i7) {
                                                int length2 = split.length;
                                                if (length2 <= split.length) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                                g2.b.e(z6);
                                                strArr = (String[]) Arrays.copyOfRange(split, i7, length2);
                                            } else {
                                                strArr = g.f72e;
                                            }
                                            arrayDeque.push(new g(str5, length, str3, strArr));
                                            break;
                                        }
                                        break;
                                }
                            }
                            i8 = i9;
                            i5 = -1;
                        }
                        i8 = i9;
                    }
                } else {
                    i8 += i7;
                    int indexOf3 = str2.indexOf(59, i8);
                    int indexOf4 = str2.indexOf(32, i8);
                    if (indexOf3 == -1) {
                        indexOf3 = indexOf4;
                    } else if (indexOf4 != -1) {
                        indexOf3 = Math.min(indexOf3, indexOf4);
                    }
                    if (indexOf3 != -1) {
                        String substring2 = str2.substring(i8, indexOf3);
                        substring2.getClass();
                        switch (substring2.hashCode()) {
                            case 3309:
                                if (substring2.equals("gt")) {
                                    c5 = 0;
                                    break;
                                }
                                c5 = 65535;
                                break;
                            case 3464:
                                if (substring2.equals("lt")) {
                                    c5 = 1;
                                    break;
                                }
                                c5 = 65535;
                                break;
                            case 96708:
                                if (substring2.equals("amp")) {
                                    c5 = 2;
                                    break;
                                }
                                c5 = 65535;
                                break;
                            case 3374865:
                                if (substring2.equals("nbsp")) {
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
                                spannableStringBuilder.append('>');
                                break;
                            case 1:
                                spannableStringBuilder.append('<');
                                break;
                            case 2:
                                spannableStringBuilder.append('&');
                                break;
                            case 3:
                                spannableStringBuilder.append(' ');
                                break;
                            default:
                                Log.w("WebvttCueParser", "ignoring unsupported entity: '&" + substring2 + ";'");
                                break;
                        }
                        if (indexOf3 == indexOf4) {
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        i8 = indexOf3 + 1;
                    } else {
                        spannableStringBuilder.append(charAt);
                    }
                }
                i5 = -1;
                i6 = 2;
                i7 = 1;
            } else {
                while (!arrayDeque.isEmpty()) {
                    a(str, (g) arrayDeque.pop(), spannableStringBuilder, list, arrayList);
                }
                a(str, new g("", 0, "", new String[0]), spannableStringBuilder, list, arrayList);
                eVar.c = spannableStringBuilder;
                return;
            }
        }
    }
}

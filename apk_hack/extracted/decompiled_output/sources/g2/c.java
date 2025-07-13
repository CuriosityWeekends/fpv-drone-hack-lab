package g2;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f1917a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    public static final Pattern b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    public static final Pattern c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    public static final HashMap d;

    static {
        HashMap hashMap = new HashMap();
        d = hashMap;
        a1.i.q(-984833, hashMap, "aliceblue", -332841, "antiquewhite");
        hashMap.put("aqua", -16711681);
        hashMap.put("aquamarine", -8388652);
        a1.i.q(-983041, hashMap, "azure", -657956, "beige");
        a1.i.q(-6972, hashMap, "bisque", ViewCompat.MEASURED_STATE_MASK, "black");
        a1.i.q(-5171, hashMap, "blanchedalmond", -16776961, "blue");
        a1.i.q(-7722014, hashMap, "blueviolet", -5952982, "brown");
        a1.i.q(-2180985, hashMap, "burlywood", -10510688, "cadetblue");
        a1.i.q(-8388864, hashMap, "chartreuse", -2987746, "chocolate");
        a1.i.q(-32944, hashMap, "coral", -10185235, "cornflowerblue");
        a1.i.q(-1828, hashMap, "cornsilk", -2354116, "crimson");
        hashMap.put("cyan", -16711681);
        hashMap.put("darkblue", -16777077);
        a1.i.q(-16741493, hashMap, "darkcyan", -4684277, "darkgoldenrod");
        hashMap.put("darkgray", -5658199);
        hashMap.put("darkgreen", -16751616);
        hashMap.put("darkgrey", -5658199);
        hashMap.put("darkkhaki", -4343957);
        a1.i.q(-7667573, hashMap, "darkmagenta", -11179217, "darkolivegreen");
        a1.i.q(-29696, hashMap, "darkorange", -6737204, "darkorchid");
        a1.i.q(-7667712, hashMap, "darkred", -1468806, "darksalmon");
        a1.i.q(-7357297, hashMap, "darkseagreen", -12042869, "darkslateblue");
        hashMap.put("darkslategray", -13676721);
        hashMap.put("darkslategrey", -13676721);
        hashMap.put("darkturquoise", -16724271);
        hashMap.put("darkviolet", -7077677);
        a1.i.q(-60269, hashMap, "deeppink", -16728065, "deepskyblue");
        hashMap.put("dimgray", -9868951);
        hashMap.put("dimgrey", -9868951);
        hashMap.put("dodgerblue", -14774017);
        hashMap.put("firebrick", -5103070);
        a1.i.q(-1296, hashMap, "floralwhite", -14513374, "forestgreen");
        hashMap.put("fuchsia", -65281);
        hashMap.put("gainsboro", -2302756);
        a1.i.q(-460545, hashMap, "ghostwhite", -10496, "gold");
        hashMap.put("goldenrod", -2448096);
        hashMap.put("gray", -8355712);
        a1.i.q(-16744448, hashMap, "green", -5374161, "greenyellow");
        hashMap.put("grey", -8355712);
        hashMap.put("honeydew", -983056);
        a1.i.q(-38476, hashMap, "hotpink", -3318692, "indianred");
        a1.i.q(-11861886, hashMap, "indigo", -16, "ivory");
        a1.i.q(-989556, hashMap, "khaki", -1644806, "lavender");
        a1.i.q(-3851, hashMap, "lavenderblush", -8586240, "lawngreen");
        a1.i.q(-1331, hashMap, "lemonchiffon", -5383962, "lightblue");
        a1.i.q(-1015680, hashMap, "lightcoral", -2031617, "lightcyan");
        hashMap.put("lightgoldenrodyellow", -329006);
        hashMap.put("lightgray", -2894893);
        hashMap.put("lightgreen", -7278960);
        hashMap.put("lightgrey", -2894893);
        a1.i.q(-18751, hashMap, "lightpink", -24454, "lightsalmon");
        a1.i.q(-14634326, hashMap, "lightseagreen", -7876870, "lightskyblue");
        hashMap.put("lightslategray", -8943463);
        hashMap.put("lightslategrey", -8943463);
        hashMap.put("lightsteelblue", -5192482);
        hashMap.put("lightyellow", -32);
        a1.i.q(-16711936, hashMap, "lime", -13447886, "limegreen");
        hashMap.put("linen", -331546);
        hashMap.put("magenta", -65281);
        a1.i.q(-8388608, hashMap, "maroon", -10039894, "mediumaquamarine");
        a1.i.q(-16777011, hashMap, "mediumblue", -4565549, "mediumorchid");
        a1.i.q(-7114533, hashMap, "mediumpurple", -12799119, "mediumseagreen");
        a1.i.q(-8689426, hashMap, "mediumslateblue", -16713062, "mediumspringgreen");
        a1.i.q(-12004916, hashMap, "mediumturquoise", -3730043, "mediumvioletred");
        a1.i.q(-15132304, hashMap, "midnightblue", -655366, "mintcream");
        a1.i.q(-6943, hashMap, "mistyrose", -6987, "moccasin");
        a1.i.q(-8531, hashMap, "navajowhite", -16777088, "navy");
        a1.i.q(-133658, hashMap, "oldlace", -8355840, "olive");
        a1.i.q(-9728477, hashMap, "olivedrab", -23296, "orange");
        a1.i.q(-47872, hashMap, "orangered", -2461482, "orchid");
        a1.i.q(-1120086, hashMap, "palegoldenrod", -6751336, "palegreen");
        a1.i.q(-5247250, hashMap, "paleturquoise", -2396013, "palevioletred");
        a1.i.q(-4139, hashMap, "papayawhip", -9543, "peachpuff");
        a1.i.q(-3308225, hashMap, "peru", -16181, "pink");
        a1.i.q(-2252579, hashMap, "plum", -5185306, "powderblue");
        a1.i.q(-8388480, hashMap, "purple", -10079335, "rebeccapurple");
        a1.i.q(SupportMenu.CATEGORY_MASK, hashMap, "red", -4419697, "rosybrown");
        a1.i.q(-12490271, hashMap, "royalblue", -7650029, "saddlebrown");
        a1.i.q(-360334, hashMap, "salmon", -744352, "sandybrown");
        a1.i.q(-13726889, hashMap, "seagreen", -2578, "seashell");
        a1.i.q(-6270419, hashMap, "sienna", -4144960, "silver");
        a1.i.q(-7876885, hashMap, "skyblue", -9807155, "slateblue");
        hashMap.put("slategray", -9404272);
        hashMap.put("slategrey", -9404272);
        hashMap.put("snow", -1286);
        hashMap.put("springgreen", -16711809);
        a1.i.q(-12156236, hashMap, "steelblue", -2968436, "tan");
        a1.i.q(-16744320, hashMap, "teal", -2572328, "thistle");
        a1.i.q(-40121, hashMap, "tomato", 0, "transparent");
        a1.i.q(-12525360, hashMap, "turquoise", -1146130, "violet");
        a1.i.q(-663885, hashMap, "wheat", -1, "white");
        a1.i.q(-657931, hashMap, "whitesmoke", InputDeviceCompat.SOURCE_ANY, "yellow");
        hashMap.put("yellowgreen", -6632142);
    }

    public static int a(String str, boolean z3) {
        Pattern pattern;
        int parseInt;
        b.e(!TextUtils.isEmpty(str));
        String replace = str.replace(" ", "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return parseLong | ViewCompat.MEASURED_STATE_MASK;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            if (z3) {
                pattern = c;
            } else {
                pattern = b;
            }
            Matcher matcher = pattern.matcher(replace);
            if (matcher.matches()) {
                if (z3) {
                    parseInt = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                return Integer.parseInt(matcher.group(3), 10) | (parseInt << 24) | (Integer.parseInt(matcher.group(1), 10) << 16) | (Integer.parseInt(matcher.group(2), 10) << 8);
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f1917a.matcher(replace);
            if (matcher2.matches()) {
                return Integer.parseInt(matcher2.group(3), 10) | (Integer.parseInt(matcher2.group(1), 10) << 16) | ViewCompat.MEASURED_STATE_MASK | (Integer.parseInt(matcher2.group(2), 10) << 8);
            }
        } else {
            Integer num = (Integer) d.get(w.E(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}

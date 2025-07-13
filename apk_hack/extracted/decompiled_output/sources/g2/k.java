package g2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static final ArrayList f1933a = new ArrayList();

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : w.D(str)) {
            String b = b(str2);
            if (b != null && g(b)) {
                return b;
            }
        }
        return null;
    }

    public static String b(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String E = w.E(str.trim());
        if (!E.startsWith("avc1") && !E.startsWith("avc3")) {
            if (!E.startsWith("hev1") && !E.startsWith("hvc1")) {
                if (!E.startsWith("dvav") && !E.startsWith("dva1") && !E.startsWith("dvhe") && !E.startsWith("dvh1")) {
                    if (E.startsWith("av01")) {
                        return "video/av01";
                    }
                    if (!E.startsWith("vp9") && !E.startsWith("vp09")) {
                        if (!E.startsWith("vp8") && !E.startsWith("vp08")) {
                            if (E.startsWith("mp4a")) {
                                if (E.startsWith("mp4a.")) {
                                    String substring = E.substring(5);
                                    if (substring.length() >= 2) {
                                        try {
                                            String substring2 = substring.substring(0, 2);
                                            if (substring2 != null) {
                                                substring2 = substring2.toUpperCase(Locale.US);
                                            }
                                            str2 = c(Integer.parseInt(substring2, 16));
                                        } catch (NumberFormatException unused) {
                                        }
                                    }
                                }
                                if (str2 == null) {
                                    return "audio/mp4a-latm";
                                }
                                return str2;
                            } else if (!E.startsWith("ac-3") && !E.startsWith("dac3")) {
                                if (!E.startsWith("ec-3") && !E.startsWith("dec3")) {
                                    if (E.startsWith("ec+3")) {
                                        return "audio/eac3-joc";
                                    }
                                    if (!E.startsWith("ac-4") && !E.startsWith("dac4")) {
                                        if (!E.startsWith("dtsc") && !E.startsWith("dtse")) {
                                            if (!E.startsWith("dtsh") && !E.startsWith("dtsl")) {
                                                if (E.startsWith("opus")) {
                                                    return "audio/opus";
                                                }
                                                if (E.startsWith("vorbis")) {
                                                    return "audio/vorbis";
                                                }
                                                if (E.startsWith("flac")) {
                                                    return "audio/flac";
                                                }
                                                ArrayList arrayList = f1933a;
                                                if (arrayList.size() <= 0) {
                                                    return null;
                                                }
                                                com.bumptech.glide.i.a(arrayList.get(0));
                                                throw null;
                                            }
                                            return "audio/vnd.dts.hd";
                                        }
                                        return "audio/vnd.dts";
                                    }
                                    return "audio/ac4";
                                }
                                return "audio/eac3";
                            } else {
                                return "audio/ac3";
                            }
                        }
                        return "video/x-vnd.on2.vp8";
                    }
                    return "video/x-vnd.on2.vp9";
                }
                return "video/dolby-vision";
            }
            return "video/hevc";
        }
        return "video/avc";
    }

    public static String c(int i3) {
        if (i3 != 32) {
            if (i3 != 33) {
                if (i3 != 35) {
                    if (i3 != 64) {
                        if (i3 != 163) {
                            if (i3 != 177) {
                                if (i3 != 165) {
                                    if (i3 != 166) {
                                        switch (i3) {
                                            case 96:
                                            case 97:
                                            case 98:
                                            case 99:
                                            case 100:
                                            case 101:
                                                return "video/mpeg2";
                                            case 102:
                                            case 103:
                                            case 104:
                                                return "audio/mp4a-latm";
                                            case 105:
                                            case 107:
                                                return "audio/mpeg";
                                            case 106:
                                                return "video/mpeg";
                                            default:
                                                switch (i3) {
                                                    case 169:
                                                    case 172:
                                                        return "audio/vnd.dts";
                                                    case 170:
                                                    case 171:
                                                        return "audio/vnd.dts.hd";
                                                    case 173:
                                                        return "audio/opus";
                                                    case 174:
                                                        return "audio/ac4";
                                                    default:
                                                        return null;
                                                }
                                        }
                                    }
                                    return "audio/eac3";
                                }
                                return "audio/ac3";
                            }
                            return "video/x-vnd.on2.vp9";
                        }
                        return "video/wvc1";
                    }
                    return "audio/mp4a-latm";
                }
                return "video/hevc";
            }
            return "video/avc";
        }
        return "video/mp4v-es";
    }

    public static String d(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (g(str)) {
            return 1;
        }
        if (h(str)) {
            return 2;
        }
        if (!"text".equals(d(str)) && !"application/cea-608".equals(str) && !"application/cea-708".equals(str) && !"application/x-mp4-cea-608".equals(str) && !"application/x-subrip".equals(str) && !"application/ttml+xml".equals(str) && !"application/x-quicktime-tx3g".equals(str) && !"application/x-mp4-vtt".equals(str) && !"application/x-rawcc".equals(str) && !"application/vobsub".equals(str) && !"application/pgs".equals(str) && !"application/dvbsubs".equals(str)) {
            if (!"application/id3".equals(str) && !"application/x-emsg".equals(str) && !"application/x-scte35".equals(str)) {
                if ("application/x-camera-motion".equals(str)) {
                    return 5;
                }
                ArrayList arrayList = f1933a;
                if (arrayList.size() <= 0) {
                    return -1;
                }
                com.bumptech.glide.i.a(arrayList.get(0));
                throw null;
            }
            return 4;
        }
        return 3;
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : w.D(str)) {
            String b = b(str2);
            if (b != null && h(b)) {
                return b;
            }
        }
        return null;
    }

    public static boolean g(String str) {
        return "audio".equals(d(str));
    }

    public static boolean h(String str) {
        return "video".equals(d(str));
    }
}

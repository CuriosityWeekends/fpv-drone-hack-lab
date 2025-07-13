package b1;

import a1.i;
import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f125a = new Object();

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, b1.b] */
    public final b a(Format format) {
        String str = format.f311i;
        if (str != null) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1348231605:
                    if (str.equals("application/x-icy")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1248341703:
                    if (str.equals("application/id3")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1154383568:
                    if (str.equals("application/x-emsg")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1652648887:
                    if (str.equals("application/x-scte35")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new e1.a();
                case 1:
                    return new f1.b(null);
                case 2:
                    return new Object();
                case 3:
                    return new g1.a();
            }
        }
        throw new IllegalArgumentException(i.w("Attempted to create decoder for unsupported MIME type: ", str));
    }

    public final boolean b(Format format) {
        String str = format.f311i;
        if (!"application/id3".equals(str) && !"application/x-emsg".equals(str) && !"application/x-scte35".equals(str) && !"application/x-icy".equals(str)) {
            return false;
        }
        return true;
    }
}

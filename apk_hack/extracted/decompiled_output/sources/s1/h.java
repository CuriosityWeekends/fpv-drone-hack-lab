package s1;

import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f3503a = new Object();

    public final f a(Format format) {
        String str = format.f311i;
        if (str != null) {
            int i3 = format.B;
            List list = format.f313k;
            char c = 65535;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals("application/dvbsubs")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1248334819:
                    if (str.equals("application/pgs")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        c = 3;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        c = 4;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        c = 5;
                        break;
                    }
                    break;
                case 930165504:
                    if (str.equals("application/x-mp4-cea-608")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals("application/cea-608")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1566016562:
                    if (str.equals("application/cea-708")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new u1.a(list);
                case 1:
                    return new v1.b();
                case 2:
                    return new a2.b();
                case 3:
                    return new a2.j();
                case 4:
                    return new z1.a(list);
                case 5:
                    return new w1.a(list);
                case 6:
                case 7:
                    return new t1.c(str, i3);
                case '\b':
                    return new t1.f(i3);
                case '\t':
                    return new x1.a();
                case '\n':
                    return new y1.c();
            }
        }
        throw new IllegalArgumentException(a1.i.w("Attempted to create decoder for unsupported MIME type: ", str));
    }
}

package pl.droidsonroids.gif;

import java.io.IOException;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GifIOException extends IOException {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 13038402904505L;

    /* renamed from: a  reason: collision with root package name */
    public final d f3272a;
    public final String b;

    public GifIOException(int i3, String str) {
        d dVar;
        d[] values = d.values();
        int length = values.length;
        int i5 = 0;
        while (true) {
            if (i5 < length) {
                dVar = values[i5];
                if (dVar.b == i3) {
                    break;
                }
                i5++;
            } else {
                dVar = d.UNKNOWN;
                dVar.b = i3;
                break;
            }
        }
        this.f3272a = dVar;
        this.b = str;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        d dVar = this.f3272a;
        String str = this.b;
        if (str == null) {
            dVar.getClass();
            Locale locale = Locale.ENGLISH;
            StringBuilder m5 = a1.i.m("GifError ", dVar.b, ": ");
            m5.append(dVar.f3298a);
            return m5.toString();
        }
        StringBuilder sb = new StringBuilder();
        dVar.getClass();
        Locale locale2 = Locale.ENGLISH;
        StringBuilder m6 = a1.i.m("GifError ", dVar.b, ": ");
        m6.append(dVar.f3298a);
        sb.append(m6.toString());
        sb.append(": ");
        sb.append(str);
        return sb.toString();
    }
}

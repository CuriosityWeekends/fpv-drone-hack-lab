package j0;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final int f2274a;
    public final int b;
    public final Format c;
    public final int d;

    public n(int i3, Throwable th) {
        this(i3, th, -1, null, 4);
    }

    public n(int i3, Throwable th, int i5, Format format, int i6) {
        super(th);
        this.f2274a = i3;
        this.b = i5;
        this.c = format;
        this.d = i6;
        SystemClock.elapsedRealtime();
    }
}

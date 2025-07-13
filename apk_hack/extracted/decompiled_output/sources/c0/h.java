package c0;

import android.os.SystemClock;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final double f193a = 1.0d / Math.pow(10.0d, 6.0d);
    public static final /* synthetic */ int b = 0;

    public static double a(long j2) {
        return (SystemClock.elapsedRealtimeNanos() - j2) * f193a;
    }
}

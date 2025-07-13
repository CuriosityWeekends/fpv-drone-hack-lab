package p;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class u {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f3083g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f3084h;

    /* renamed from: i  reason: collision with root package name */
    public static final File f3085i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile u f3086j;

    /* renamed from: k  reason: collision with root package name */
    public static volatile int f3087k;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3088a;
    public final int b;
    public final int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3089e = true;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f3090f = new AtomicBoolean(false);

    static {
        boolean z3;
        int i3 = Build.VERSION.SDK_INT;
        boolean z5 = false;
        if (i3 < 29) {
            z3 = true;
        } else {
            z3 = false;
        }
        f3083g = z3;
        if (i3 >= 26) {
            z5 = true;
        }
        f3084h = z5;
        f3085i = new File("/proc/self/fd");
        f3087k = -1;
    }

    public u() {
        boolean contains;
        if (Build.VERSION.SDK_INT == 26) {
            for (String str : Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play")) {
                if (Build.MODEL.startsWith(str)) {
                    break;
                }
            }
        }
        if (Build.VERSION.SDK_INT != 27) {
            contains = false;
        } else {
            contains = Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
        }
        boolean z3 = contains ? false : true;
        this.f3088a = z3;
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = 20000;
            this.c = 0;
            return;
        }
        this.b = 700;
        this.c = 128;
    }

    public static u a() {
        if (f3086j == null) {
            synchronized (u.class) {
                try {
                    if (f3086j == null) {
                        f3086j = new u();
                    }
                } finally {
                }
            }
        }
        return f3086j;
    }

    public final boolean b(int i3, int i5, boolean z3, boolean z5) {
        boolean z6;
        int i6;
        boolean z7;
        if (!z3) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        } else if (!this.f3088a) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        } else if (!f3084h) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        } else if (f3083g && !this.f3090f.get()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        } else if (z5) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        } else {
            int i7 = this.c;
            if (i3 < i7) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
                }
                return false;
            } else if (i5 < i7) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
                }
                return false;
            } else {
                synchronized (this) {
                    try {
                        int i8 = this.d + 1;
                        this.d = i8;
                        if (i8 >= 50) {
                            this.d = 0;
                            int length = f3085i.list().length;
                            if (f3087k != -1) {
                                i6 = f3087k;
                            } else {
                                i6 = this.b;
                            }
                            long j2 = i6;
                            if (length < j2) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            this.f3089e = z7;
                            if (!z7 && Log.isLoggable("Downsampler", 5)) {
                                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + j2);
                            }
                        }
                        z6 = this.f3089e;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z6) {
                    return true;
                }
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                }
                return false;
            }
        }
    }
}

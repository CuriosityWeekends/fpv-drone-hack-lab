package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.Build;
import android.system.Os;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
final class GifInfoHandle {
    public static final /* synthetic */ int b = 0;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f3275a;

    static {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (com.bumptech.glide.c.f239a == null) {
                try {
                    com.bumptech.glide.c.f239a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null);
                } catch (Exception e5) {
                    throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e5);
                }
            }
            new i.b(13).j(com.bumptech.glide.c.f239a);
        }
    }

    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) {
        int extractNativeFileDescriptor;
        try {
            FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();
            long startOffset = assetFileDescriptor.getStartOffset();
            if (Build.VERSION.SDK_INT > 27) {
                extractNativeFileDescriptor = createTempNativeFileDescriptor();
                Os.dup2(fileDescriptor, extractNativeFileDescriptor);
            } else {
                extractNativeFileDescriptor = extractNativeFileDescriptor(fileDescriptor, false);
            }
            this.f3275a = openNativeFileDescriptor(extractNativeFileDescriptor, startOffset);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    private static native void bindSurface(long j2, Surface surface, long[] jArr);

    public static native int createTempNativeFileDescriptor();

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z3);

    private static native void free(long j2);

    private static native int getCurrentFrameIndex(long j2);

    private static native int getCurrentLoop(long j2);

    private static native int getCurrentPosition(long j2);

    private static native int getDuration(long j2);

    private static native int getHeight(long j2);

    private static native int getLoopCount(long j2);

    private static native int getNativeErrorCode(long j2);

    private static native int getNumberOfFrames(long j2);

    private static native long[] getSavedState(long j2);

    private static native int getWidth(long j2);

    private static native boolean isOpaque(long j2);

    public static native long openFile(String str);

    public static native long openNativeFileDescriptor(int i3, long j2);

    private static native void postUnbindSurface(long j2);

    private static native long renderFrame(long j2, Bitmap bitmap);

    private static native boolean reset(long j2);

    private static native long restoreRemainder(long j2);

    private static native int restoreSavedState(long j2, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j2);

    private static native void seekToTime(long j2, int i3, Bitmap bitmap);

    private static native void setLoopCount(long j2, char c);

    private static native void setOptions(long j2, char c, boolean z3);

    private static native void setSpeedFactor(long j2, float f4);

    public final void a(Surface surface, long[] jArr) {
        bindSurface(this.f3275a, surface, jArr);
    }

    public final synchronized int b() {
        return getCurrentFrameIndex(this.f3275a);
    }

    public final synchronized int c() {
        return getCurrentLoop(this.f3275a);
    }

    public final synchronized int d() {
        return getCurrentPosition(this.f3275a);
    }

    public final synchronized int e() {
        return getDuration(this.f3275a);
    }

    public final synchronized int f() {
        return getHeight(this.f3275a);
    }

    public final void finalize() {
        try {
            o();
        } finally {
            super.finalize();
        }
    }

    public final synchronized int g() {
        return getLoopCount(this.f3275a);
    }

    public final synchronized int h() {
        return getNativeErrorCode(this.f3275a);
    }

    public final synchronized int i() {
        return getNumberOfFrames(this.f3275a);
    }

    public final synchronized long[] j() {
        return getSavedState(this.f3275a);
    }

    public final synchronized int k() {
        return getWidth(this.f3275a);
    }

    public final synchronized boolean l() {
        return isOpaque(this.f3275a);
    }

    public final synchronized boolean m() {
        boolean z3;
        if (this.f3275a == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        return z3;
    }

    public final synchronized void n() {
        postUnbindSurface(this.f3275a);
    }

    public final synchronized void o() {
        free(this.f3275a);
        this.f3275a = 0L;
    }

    public final synchronized long p(Bitmap bitmap) {
        return renderFrame(this.f3275a, bitmap);
    }

    public final synchronized boolean q() {
        return reset(this.f3275a);
    }

    public final synchronized long r() {
        return restoreRemainder(this.f3275a);
    }

    public final synchronized int s(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f3275a, jArr, bitmap);
    }

    public final synchronized void t() {
        saveRemainder(this.f3275a);
    }

    public final synchronized void u(Bitmap bitmap, int i3) {
        seekToTime(this.f3275a, i3, bitmap);
    }

    public final void v(int i3) {
        if (i3 >= 0 && i3 <= 65535) {
            synchronized (this) {
                setLoopCount(this.f3275a, (char) i3);
            }
            return;
        }
        throw new IllegalArgumentException("Loop count of range <0, 65535>");
    }

    public final void w(boolean z3) {
        setOptions(this.f3275a, (char) 1, z3);
    }

    public final void x(float f4) {
        if (f4 > 0.0f && !Float.isNaN(f4)) {
            if (f4 < 4.656613E-10f) {
                f4 = 4.656613E-10f;
            }
            synchronized (this) {
                setSpeedFactor(this.f3275a, f4);
            }
            return;
        }
        throw new IllegalArgumentException("Speed factor is not positive");
    }
}

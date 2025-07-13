package net.butterflytv.rtmp_client;

import e2.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class RtmpClient {

    /* renamed from: a  reason: collision with root package name */
    public long f2949a;

    static {
        System.loadLibrary("rtmp-jni");
    }

    private native long nativeAlloc();

    private native void nativeClose(long j2);

    private native int nativeOpen(String str, boolean z3, long j2, int i3, int i5);

    private native int nativeRead(byte[] bArr, int i3, int i5, long j2);

    public final void a() {
        nativeClose(this.f2949a);
        this.f2949a = 0L;
    }

    public final void b(String str) {
        long nativeAlloc = nativeAlloc();
        this.f2949a = nativeAlloc;
        if (nativeAlloc != 0) {
            int nativeOpen = nativeOpen(str, false, nativeAlloc, 10000, 10000);
            if (nativeOpen == 0) {
                return;
            }
            this.f2949a = 0L;
            throw new b(nativeOpen);
        }
        throw new b(-2);
    }

    public final int c(byte[] bArr, int i3, int i5) {
        int nativeRead = nativeRead(bArr, i3, i5, this.f2949a);
        if (nativeRead < 0 && nativeRead != -1) {
            throw new b(nativeRead);
        }
        return nativeRead;
    }
}

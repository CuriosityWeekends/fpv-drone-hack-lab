package edu.cmu.pocketsphinx;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class Decoder {

    /* renamed from: a  reason: collision with root package name */
    public transient long f1764a;
    public transient boolean b;

    public final void finalize() {
        synchronized (this) {
            try {
                long j2 = this.f1764a;
                if (j2 != 0) {
                    if (this.b) {
                        this.b = false;
                        PocketSphinxJNI.delete_Decoder(j2);
                    }
                    this.f1764a = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

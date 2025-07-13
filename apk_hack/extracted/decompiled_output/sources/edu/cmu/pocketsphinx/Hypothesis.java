package edu.cmu.pocketsphinx;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class Hypothesis {

    /* renamed from: a  reason: collision with root package name */
    public transient long f1765a;
    public transient boolean b;

    public final void finalize() {
        synchronized (this) {
            try {
                long j2 = this.f1765a;
                if (j2 != 0) {
                    if (this.b) {
                        this.b = false;
                        PocketSphinxJNI.delete_Hypothesis(j2);
                    }
                    this.f1765a = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

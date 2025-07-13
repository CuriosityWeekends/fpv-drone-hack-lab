package edu.cmu.pocketsphinx;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class Config {

    /* renamed from: a  reason: collision with root package name */
    public transient long f1763a;
    public transient boolean b = true;

    public Config(long j2) {
        this.f1763a = j2;
    }

    public final void finalize() {
        synchronized (this) {
            try {
                long j2 = this.f1763a;
                if (j2 != 0) {
                    if (this.b) {
                        this.b = false;
                        SphinxBaseJNI.delete_Config(j2);
                    }
                    this.f1763a = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

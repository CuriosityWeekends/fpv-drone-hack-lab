package g2;

import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public long f1958a;
    public long b;
    public volatile long c = -9223372036854775807L;

    public u(long j2) {
        d(j2);
    }

    public final long a(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            this.c = j2;
        } else {
            long j5 = this.f1958a;
            if (j5 != Long.MAX_VALUE) {
                this.b = j5 - j2;
            }
            synchronized (this) {
                this.c = j2;
                notifyAll();
            }
        }
        return j2 + this.b;
    }

    public final long b(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            long j5 = (this.c * 90000) / 1000000;
            long j6 = (IjkMediaMeta.AV_CH_WIDE_RIGHT + j5) / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            long j7 = ((j6 - 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j2;
            long j8 = (j6 * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j2;
            if (Math.abs(j7 - j5) < Math.abs(j8 - j5)) {
                j2 = j7;
            } else {
                j2 = j8;
            }
        }
        return a((j2 * 1000000) / 90000);
    }

    public final long c() {
        if (this.f1958a == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.b;
    }

    public final synchronized void d(long j2) {
        boolean z3;
        if (this.c == -9223372036854775807L) {
            z3 = true;
        } else {
            z3 = false;
        }
        b.h(z3);
        this.f1958a = j2;
    }
}

package l1;

import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class k extends b {

    /* renamed from: i  reason: collision with root package name */
    public final long f2680i;

    public k(e2.i iVar, e2.l lVar, Format format, int i3, Object obj, long j2, long j5, long j6) {
        super(iVar, lVar, 1, format, i3, obj, j2, j5);
        format.getClass();
        this.f2680i = j6;
    }

    public long c() {
        long j2 = this.f2680i;
        if (j2 == -1) {
            return -1L;
        }
        return 1 + j2;
    }

    public abstract boolean d();
}

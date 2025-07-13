package j0;

import java.util.UUID;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final UUID f2256a = new UUID(0, 0);
    public static final UUID b = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID c;
    public static final UUID d;

    static {
        new UUID(-2129748144642739255L, 8654423357094679310L);
        c = new UUID(-1301668207276963122L, -6645017420763422227L);
        d = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j2) {
        if (j2 != -9223372036854775807L && j2 != Long.MIN_VALUE) {
            return j2 * 1000;
        }
        return j2;
    }

    public static long b(long j2) {
        if (j2 != -9223372036854775807L && j2 != Long.MIN_VALUE) {
            return j2 / 1000;
        }
        return j2;
    }
}

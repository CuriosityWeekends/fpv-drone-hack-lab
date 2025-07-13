package f2;

import java.util.TreeSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f1832a;
    public final String b;
    public final TreeSet c = new TreeSet();
    public m d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1833e;

    public i(int i3, String str, m mVar) {
        this.f1832a = i3;
        this.b = str;
        this.d = mVar;
    }

    public final long a(long j2, long j5) {
        r b = b(j2);
        boolean z3 = !b.d;
        long j6 = b.c;
        if (z3) {
            if (j6 == -1) {
                j6 = Long.MAX_VALUE;
            }
            return -Math.min(j6, j5);
        }
        long j7 = j2 + j5;
        long j8 = b.b + j6;
        if (j8 < j7) {
            for (r rVar : this.c.tailSet(b, false)) {
                long j9 = rVar.b;
                if (j9 > j8) {
                    break;
                }
                j8 = Math.max(j8, j9 + rVar.c);
                if (j8 >= j7) {
                    break;
                }
            }
        }
        return Math.min(j8 - j2, j5);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [f2.g, f2.r] */
    /* JADX WARN: Type inference failed for: r0v6, types: [f2.g, f2.r] */
    public final r b(long j2) {
        g gVar = new g(this.b, j2, -1L, -9223372036854775807L, null);
        TreeSet treeSet = this.c;
        r rVar = (r) treeSet.floor(gVar);
        if (rVar != null && rVar.b + rVar.c > j2) {
            return rVar;
        }
        r rVar2 = (r) treeSet.ceiling(gVar);
        if (rVar2 == null) {
            return new g(this.b, j2, -1L, -9223372036854775807L, null);
        }
        return new g(this.b, j2, rVar2.b - j2, -9223372036854775807L, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f1832a == iVar.f1832a && this.b.equals(iVar.b) && this.c.equals(iVar.c) && this.d.equals(iVar.d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return this.d.hashCode() + ((hashCode + (this.f1832a * 31)) * 31);
    }
}

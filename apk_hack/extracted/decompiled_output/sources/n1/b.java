package n1;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f2916a;
    public final long b;
    public final boolean c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2917e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2918f;

    /* renamed from: g  reason: collision with root package name */
    public final long f2919g;

    /* renamed from: h  reason: collision with root package name */
    public final com.lxj.xpopup.util.a f2920h;

    /* renamed from: i  reason: collision with root package name */
    public final Uri f2921i;

    /* renamed from: j  reason: collision with root package name */
    public final List f2922j;

    public b(long j2, long j5, long j6, boolean z3, long j7, long j8, long j9, long j10, h hVar, com.lxj.xpopup.util.a aVar, Uri uri, ArrayList arrayList) {
        this.f2916a = j2;
        this.b = j5;
        this.c = z3;
        this.d = j7;
        this.f2917e = j8;
        this.f2918f = j9;
        this.f2919g = j10;
        this.f2920h = aVar;
        this.f2921i = uri;
        this.f2922j = arrayList;
    }

    public final g a(int i3) {
        return (g) this.f2922j.get(i3);
    }

    public final long b(int i3) {
        List list = this.f2922j;
        if (i3 == list.size() - 1) {
            long j2 = this.b;
            if (j2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return j2 - ((g) list.get(i3)).b;
        }
        return ((g) list.get(i3 + 1)).b - ((g) list.get(i3)).b;
    }

    public final long c(int i3) {
        return j0.i.a(b(i3));
    }
}

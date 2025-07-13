package l1;

import com.google.android.exoplayer2.Format;
import p0.t;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements u {

    /* renamed from: a  reason: collision with root package name */
    public final int f2642a;
    public final Format b;
    public final p0.i c = new Object();
    public Format d;

    /* renamed from: e  reason: collision with root package name */
    public u f2643e;

    /* renamed from: f  reason: collision with root package name */
    public long f2644f;

    /* JADX WARN: Type inference failed for: r1v1, types: [p0.i, java.lang.Object] */
    public c(int i3, int i5, Format format) {
        this.f2642a = i5;
        this.b = format;
    }

    @Override // p0.u
    public final int a(p0.g gVar, int i3, boolean z3) {
        return this.f2643e.a(gVar, i3, z3);
    }

    @Override // p0.u
    public final void b(int i3, c0.b bVar) {
        this.f2643e.b(i3, bVar);
    }

    @Override // p0.u
    public final void c(long j2, int i3, int i5, int i6, t tVar) {
        long j5 = this.f2644f;
        if (j5 != -9223372036854775807L && j2 >= j5) {
            this.f2643e = this.c;
        }
        this.f2643e.c(j2, i3, i5, i6, tVar);
    }

    @Override // p0.u
    public final void d(Format format) {
        Format format2 = this.b;
        if (format2 != null) {
            format = format.g(format2);
        }
        this.d = format;
        this.f2643e.d(format);
    }
}

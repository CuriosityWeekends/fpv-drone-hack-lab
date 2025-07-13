package m1;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import g2.w;
import j0.f0;
import j1.i0;
import java.nio.charset.Charset;
import p0.t;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q implements u {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f2830a;
    public final j0.b b = new j0.b(1);
    public final b1.d c = new m0.d(1);
    public final /* synthetic */ r d;

    /* JADX WARN: Type inference failed for: r2v3, types: [b1.d, m0.d] */
    public q(r rVar, e2.m mVar) {
        this.d = rVar;
        this.f2830a = new i0(mVar, n0.b.f2912a);
    }

    @Override // p0.u
    public final int a(p0.g gVar, int i3, boolean z3) {
        return this.f2830a.a(gVar, i3, z3);
    }

    @Override // p0.u
    public final void b(int i3, c0.b bVar) {
        this.f2830a.b(i3, bVar);
    }

    @Override // p0.u
    public final void c(long j2, int i3, int i5, int i6, t tVar) {
        long h5;
        long j5;
        this.f2830a.c(j2, i3, i5, i6, tVar);
        while (this.f2830a.u(false)) {
            b1.d dVar = this.c;
            dVar.clear();
            if (this.f2830a.y(this.b, this.c, false, false, 0L) == -4) {
                dVar.d();
            } else {
                dVar = null;
            }
            if (dVar != null) {
                long j6 = dVar.c;
                EventMessage eventMessage = (EventMessage) this.d.c.a(dVar).f330a[0];
                String str = eventMessage.f342a;
                String str2 = eventMessage.b;
                if ("urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || ExifInterface.GPS_MEASUREMENT_2D.equals(str2) || ExifInterface.GPS_MEASUREMENT_3D.equals(str2))) {
                    try {
                        j5 = w.y(new String(eventMessage.f343e, Charset.forName("UTF-8")));
                    } catch (f0 unused) {
                        j5 = -9223372036854775807L;
                    }
                    if (j5 != -9223372036854775807L) {
                        p pVar = new p(j6, j5);
                        Handler handler = this.d.d;
                        handler.sendMessage(handler.obtainMessage(1, pVar));
                    }
                }
            }
        }
        i0 i0Var = this.f2830a;
        j1.f0 f0Var = i0Var.f2418a;
        synchronized (i0Var) {
            int i7 = i0Var.f2431r;
            if (i7 == 0) {
                h5 = -1;
            } else {
                h5 = i0Var.h(i7);
            }
        }
        f0Var.b(h5);
    }

    @Override // p0.u
    public final void d(Format format) {
        this.f2830a.d(format);
    }
}

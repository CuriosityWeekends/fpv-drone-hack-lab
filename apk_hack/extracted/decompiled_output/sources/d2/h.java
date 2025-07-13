package d2;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import e2.n;
import e2.p;
import e2.q;
import g2.w;
import h2.s;
import j0.k0;
import j0.m0;
import j0.q0;
import j0.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1626a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ h(int i3, Object obj, Object obj2) {
        this.f1626a = i3;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k0.a aVar;
        switch (this.f1626a) {
            case 0:
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) this.b;
                SurfaceTexture surfaceTexture = sphericalGLSurfaceView.f491g;
                Surface surface = sphericalGLSurfaceView.f492h;
                SurfaceTexture surfaceTexture2 = (SurfaceTexture) this.c;
                sphericalGLSurfaceView.f491g = surfaceTexture2;
                Surface surface2 = new Surface(surfaceTexture2);
                sphericalGLSurfaceView.f492h = surface2;
                k0 k0Var = sphericalGLSurfaceView.f493i;
                if (k0Var != null) {
                    ((q0) k0Var).J(surface2);
                }
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                    return;
                }
                return;
            case 1:
                ((p) this.b).getClass();
                p.c((q) this.c);
                return;
            case 2:
                g2.h hVar = (g2.h) this.b;
                if (!hVar.c) {
                    n nVar = (n) this.c;
                    nVar.getClass();
                    k0.c cVar = (k0.c) hVar.b;
                    ArrayList arrayList = cVar.c.f2494a;
                    if (arrayList.isEmpty()) {
                        aVar = null;
                    } else {
                        aVar = (k0.a) arrayList.get(arrayList.size() - 1);
                    }
                    k0.d d = cVar.d(aVar);
                    Iterator it = cVar.f2499a.iterator();
                    while (it.hasNext()) {
                        ((k0.e) it.next()).onBandwidthEstimate(d, nVar.f1705a, nVar.b, nVar.c);
                    }
                    return;
                }
                return;
            case 3:
                c1.b bVar = (c1.b) this.b;
                bVar.getClass();
                int i3 = w.f1960a;
                ((s) bVar.c).onRenderedFirstFrame((Surface) this.c);
                return;
            case 4:
                c1.b bVar2 = (c1.b) this.b;
                bVar2.getClass();
                int i5 = w.f1960a;
                ((s) bVar2.c).onVideoInputFormatChanged((Format) this.c);
                return;
            case 5:
                Iterator it2 = ((CopyOnWriteArrayList) this.b).iterator();
                while (it2.hasNext()) {
                    j0.f fVar = (j0.f) it2.next();
                    if (!fVar.b) {
                        ((j0.g) this.c).a(fVar.f2234a);
                    }
                }
                return;
            case 6:
                m0 m0Var = (m0) this.c;
                ((y) this.b).getClass();
                try {
                    synchronized (m0Var) {
                    }
                    m0Var.f2270a.f(m0Var.c, m0Var.d);
                    m0Var.a(true);
                    return;
                } catch (j0.n e5) {
                    Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e5);
                    throw new RuntimeException(e5);
                }
            default:
                c1.b bVar3 = (c1.b) this.b;
                bVar3.getClass();
                int i6 = w.f1960a;
                ((l0.i) bVar3.c).onAudioInputFormatChanged((Format) this.c);
                return;
        }
    }
}

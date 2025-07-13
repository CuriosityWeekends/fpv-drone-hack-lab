package k0;

import android.os.SystemClock;
import android.view.Surface;
import b2.o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import h2.n;
import h2.s;
import j0.h0;
import j0.j0;
import j0.l0;
import j0.s0;
import j0.t0;
import j0.u0;
import j1.v;
import j1.w;
import j1.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import l0.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements j0, b1.e, i, s, x, n {
    public l0 d;

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArraySet f2499a = new CopyOnWriteArraySet();
    public final b c = new b();
    public final t0 b = new t0();

    @Override // h2.n
    public final void b(int i3, int i5) {
        d g5 = g();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onSurfaceSizeChanged(g5, i3, i5);
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, k0.d] */
    public final d c(int i3, u0 u0Var, j1.n nVar) {
        boolean z3;
        if (u0Var.o()) {
            nVar = null;
        }
        SystemClock.elapsedRealtime();
        if (u0Var == this.d.r() && i3 == this.d.w()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (nVar != null && nVar.a()) {
            if (z3 && this.d.m() == nVar.b && this.d.o() == nVar.c) {
                this.d.getCurrentPosition();
            }
        } else if (z3) {
            this.d.f();
        } else if (!u0Var.o()) {
            long j2 = u0Var.m(i3, this.b, 0L).f2324h;
            UUID uuid = j0.i.f2256a;
        }
        this.d.getCurrentPosition();
        this.d.g();
        return new Object();
    }

    public final d d(a aVar) {
        this.d.getClass();
        if (aVar == null) {
            int w = this.d.w();
            a aVar2 = null;
            int i3 = 0;
            while (true) {
                b bVar = this.c;
                ArrayList arrayList = bVar.f2494a;
                if (i3 >= arrayList.size()) {
                    break;
                }
                a aVar3 = (a) arrayList.get(i3);
                int b = bVar.f2497g.b(aVar3.f2493a.f2454a);
                if (b != -1 && bVar.f2497g.f(b, bVar.c, false).c == w) {
                    if (aVar2 != null) {
                        aVar2 = null;
                        break;
                    }
                    aVar2 = aVar3;
                }
                i3++;
            }
            if (aVar2 == null) {
                u0 r5 = this.d.r();
                if (w >= r5.n()) {
                    r5 = u0.f2344a;
                }
                return c(w, r5, null);
            }
            aVar = aVar2;
        }
        return c(aVar.c, aVar.b, aVar.f2493a);
    }

    public final d e(int i3, j1.n nVar) {
        this.d.getClass();
        u0 u0Var = u0.f2344a;
        if (nVar != null) {
            a aVar = (a) this.c.b.get(nVar);
            if (aVar != null) {
                return d(aVar);
            }
            return c(i3, u0Var, nVar);
        }
        u0 r5 = this.d.r();
        if (i3 < r5.n()) {
            u0Var = r5;
        }
        return c(i3, u0Var, null);
    }

    public final d f() {
        a aVar;
        b bVar = this.c;
        ArrayList arrayList = bVar.f2494a;
        if (!arrayList.isEmpty() && !bVar.f2497g.o() && !bVar.f2498h) {
            aVar = (a) arrayList.get(0);
        } else {
            aVar = null;
        }
        return d(aVar);
    }

    public final d g() {
        return d(this.c.f2496f);
    }

    public final void h() {
        Iterator it = new ArrayList(this.c.f2494a).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            onMediaPeriodReleased(aVar.c, aVar.f2493a);
        }
    }

    @Override // l0.i
    public final void onAudioDecoderInitialized(String str, long j2, long j5) {
        d g5 = g();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDecoderInitialized(g5, 1, str, j5);
        }
    }

    @Override // l0.i
    public final void onAudioDisabled(m0.c cVar) {
        d d = d(this.c.f2495e);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDecoderDisabled(d, 1, cVar);
        }
    }

    @Override // l0.i
    public final void onAudioEnabled(m0.c cVar) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDecoderEnabled(f4, 1, cVar);
        }
    }

    @Override // l0.i
    public final void onAudioInputFormatChanged(Format format) {
        d g5 = g();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDecoderInputFormatChanged(g5, 1, format);
        }
    }

    @Override // l0.i
    public final void onAudioSessionId(int i3) {
        d g5 = g();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onAudioSessionId(g5, i3);
        }
    }

    @Override // l0.i
    public final void onAudioSinkUnderrun(int i3, long j2, long j5) {
        d g5 = g();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onAudioUnderrun(g5, i3, j2, j5);
        }
    }

    @Override // j1.x
    public final void onDownstreamFormatChanged(int i3, j1.n nVar, w wVar) {
        d e5 = e(i3, nVar);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDownstreamFormatChanged(e5, wVar);
        }
    }

    @Override // h2.s
    public final void onDroppedFrames(int i3, long j2) {
        d d = d(this.c.f2495e);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDroppedVideoFrames(d, i3, j2);
        }
    }

    @Override // j0.j0
    public final void onIsPlayingChanged(boolean z3) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onIsPlayingChanged(f4, z3);
        }
    }

    @Override // j1.x
    public final void onLoadCanceled(int i3, j1.n nVar, v vVar, w wVar) {
        d e5 = e(i3, nVar);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onLoadCanceled(e5, vVar, wVar);
        }
    }

    @Override // j1.x
    public final void onLoadCompleted(int i3, j1.n nVar, v vVar, w wVar) {
        d e5 = e(i3, nVar);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onLoadCompleted(e5, vVar, wVar);
        }
    }

    @Override // j1.x
    public final void onLoadError(int i3, j1.n nVar, v vVar, w wVar, IOException iOException, boolean z3) {
        d e5 = e(i3, nVar);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onLoadError(e5, vVar, wVar, iOException, z3);
        }
    }

    @Override // j1.x
    public final void onLoadStarted(int i3, j1.n nVar, v vVar, w wVar) {
        d e5 = e(i3, nVar);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onLoadStarted(e5, vVar, wVar);
        }
    }

    @Override // j0.j0
    public final void onLoadingChanged(boolean z3) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onLoadingChanged(f4, z3);
        }
    }

    @Override // j1.x
    public final void onMediaPeriodCreated(int i3, j1.n nVar) {
        boolean z3;
        u0 u0Var;
        int i5;
        b bVar = this.c;
        int b = bVar.f2497g.b(nVar.f2454a);
        if (b != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            u0Var = bVar.f2497g;
        } else {
            u0Var = u0.f2344a;
        }
        if (z3) {
            i5 = bVar.f2497g.f(b, bVar.c, false).c;
        } else {
            i5 = i3;
        }
        a aVar = new a(i5, u0Var, nVar);
        ArrayList arrayList = bVar.f2494a;
        arrayList.add(aVar);
        bVar.b.put(nVar, aVar);
        bVar.d = (a) arrayList.get(0);
        if (arrayList.size() == 1 && !bVar.f2497g.o()) {
            bVar.f2495e = bVar.d;
        }
        d e5 = e(i3, nVar);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onMediaPeriodCreated(e5);
        }
    }

    @Override // j1.x
    public final void onMediaPeriodReleased(int i3, j1.n nVar) {
        a aVar;
        d e5 = e(i3, nVar);
        b bVar = this.c;
        a aVar2 = (a) bVar.b.remove(nVar);
        if (aVar2 != null) {
            ArrayList arrayList = bVar.f2494a;
            arrayList.remove(aVar2);
            a aVar3 = bVar.f2496f;
            if (aVar3 != null && nVar.equals(aVar3.f2493a)) {
                if (arrayList.isEmpty()) {
                    aVar = null;
                } else {
                    aVar = (a) arrayList.get(0);
                }
                bVar.f2496f = aVar;
            }
            if (!arrayList.isEmpty()) {
                bVar.d = (a) arrayList.get(0);
            }
            Iterator it = this.f2499a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onMediaPeriodReleased(e5);
            }
        }
    }

    @Override // b1.e
    public final void onMetadata(Metadata metadata) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onMetadata(f4, metadata);
        }
    }

    @Override // j0.j0
    public final void onPlaybackParametersChanged(h0 h0Var) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onPlaybackParametersChanged(f4, h0Var);
        }
    }

    @Override // j0.j0
    public final void onPlaybackSuppressionReasonChanged(int i3) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onPlaybackSuppressionReasonChanged(f4, i3);
        }
    }

    @Override // j0.j0
    public final void onPlayerError(j0.n nVar) {
        d d = d(this.c.f2495e);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onPlayerError(d, nVar);
        }
    }

    @Override // j0.j0
    public final void onPlayerStateChanged(boolean z3, int i3) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onPlayerStateChanged(f4, z3, i3);
        }
    }

    @Override // j0.j0
    public final void onPositionDiscontinuity(int i3) {
        b bVar = this.c;
        bVar.f2495e = bVar.d;
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onPositionDiscontinuity(f4, i3);
        }
    }

    @Override // j1.x
    public final void onReadingStarted(int i3, j1.n nVar) {
        b bVar = this.c;
        bVar.f2496f = (a) bVar.b.get(nVar);
        d e5 = e(i3, nVar);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onReadingStarted(e5);
        }
    }

    @Override // h2.s
    public final void onRenderedFirstFrame(Surface surface) {
        d g5 = g();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onRenderedFirstFrame(g5, surface);
        }
    }

    @Override // j0.j0
    public final void onRepeatModeChanged(int i3) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onRepeatModeChanged(f4, i3);
        }
    }

    @Override // j0.j0
    public final void onSeekProcessed() {
        b bVar = this.c;
        if (bVar.f2498h) {
            bVar.f2498h = false;
            bVar.f2495e = bVar.d;
            d f4 = f();
            Iterator it = this.f2499a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onSeekProcessed(f4);
            }
        }
    }

    @Override // j0.j0
    public final void onShuffleModeEnabledChanged(boolean z3) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onShuffleModeChanged(f4, z3);
        }
    }

    @Override // j0.j0
    public final /* synthetic */ void onTimelineChanged(u0 u0Var, Object obj, int i3) {
    }

    @Override // j0.j0
    public final void onTracksChanged(TrackGroupArray trackGroupArray, o oVar) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onTracksChanged(f4, trackGroupArray, oVar);
        }
    }

    @Override // j1.x
    public final void onUpstreamDiscarded(int i3, j1.n nVar, w wVar) {
        d e5 = e(i3, nVar);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onUpstreamDiscarded(e5, wVar);
        }
    }

    @Override // h2.s
    public final void onVideoDecoderInitialized(String str, long j2, long j5) {
        d g5 = g();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDecoderInitialized(g5, 2, str, j5);
        }
    }

    @Override // h2.s
    public final void onVideoDisabled(m0.c cVar) {
        d d = d(this.c.f2495e);
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDecoderDisabled(d, 2, cVar);
        }
    }

    @Override // h2.s
    public final void onVideoEnabled(m0.c cVar) {
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDecoderEnabled(f4, 2, cVar);
        }
    }

    @Override // h2.s
    public final void onVideoInputFormatChanged(Format format) {
        d g5 = g();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onDecoderInputFormatChanged(g5, 2, format);
        }
    }

    @Override // h2.s
    public final void onVideoSizeChanged(int i3, int i5, int i6, float f4) {
        d g5 = g();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onVideoSizeChanged(g5, i3, i5, i6, f4);
        }
    }

    @Override // j0.j0
    public final void onTimelineChanged(u0 u0Var, int i3) {
        b bVar;
        s0 s0Var;
        int i5 = 0;
        while (true) {
            bVar = this.c;
            ArrayList arrayList = bVar.f2494a;
            int size = arrayList.size();
            s0Var = bVar.c;
            if (i5 >= size) {
                break;
            }
            a aVar = (a) arrayList.get(i5);
            int b = u0Var.b(aVar.f2493a.f2454a);
            if (b != -1) {
                aVar = new a(u0Var.f(b, s0Var, false).c, u0Var, aVar.f2493a);
            }
            arrayList.set(i5, aVar);
            bVar.b.put(aVar.f2493a, aVar);
            i5++;
        }
        a aVar2 = bVar.f2496f;
        if (aVar2 != null) {
            j1.n nVar = aVar2.f2493a;
            int b5 = u0Var.b(nVar.f2454a);
            if (b5 != -1) {
                aVar2 = new a(u0Var.f(b5, s0Var, false).c, u0Var, nVar);
            }
            bVar.f2496f = aVar2;
        }
        bVar.f2497g = u0Var;
        bVar.f2495e = bVar.d;
        d f4 = f();
        Iterator it = this.f2499a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onTimelineChanged(f4, i3);
        }
    }

    @Override // h2.n
    public final void a() {
    }
}

package j0;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p0 implements h2.s, l0.i, s1.j, b1.e, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, j0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f2282a;

    public p0(q0 q0Var) {
        this.f2282a = q0Var;
    }

    @Override // l0.i
    public final void onAudioDecoderInitialized(String str, long j2, long j5) {
        Iterator it = this.f2282a.f2290k.iterator();
        while (it.hasNext()) {
            ((l0.i) it.next()).onAudioDecoderInitialized(str, j2, j5);
        }
    }

    @Override // l0.i
    public final void onAudioDisabled(m0.c cVar) {
        q0 q0Var = this.f2282a;
        Iterator it = q0Var.f2290k.iterator();
        while (it.hasNext()) {
            ((l0.i) it.next()).onAudioDisabled(cVar);
        }
        q0Var.getClass();
        q0Var.getClass();
        q0Var.w = 0;
    }

    @Override // l0.i
    public final void onAudioEnabled(m0.c cVar) {
        q0 q0Var = this.f2282a;
        q0Var.getClass();
        Iterator it = q0Var.f2290k.iterator();
        while (it.hasNext()) {
            ((l0.i) it.next()).onAudioEnabled(cVar);
        }
    }

    @Override // l0.i
    public final void onAudioInputFormatChanged(Format format) {
        q0 q0Var = this.f2282a;
        q0Var.getClass();
        Iterator it = q0Var.f2290k.iterator();
        while (it.hasNext()) {
            ((l0.i) it.next()).onAudioInputFormatChanged(format);
        }
    }

    @Override // l0.i
    public final void onAudioSessionId(int i3) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        q0 q0Var = this.f2282a;
        if (q0Var.w == i3) {
            return;
        }
        q0Var.w = i3;
        Iterator it = q0Var.f2286g.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            copyOnWriteArraySet = q0Var.f2290k;
            if (!hasNext) {
                break;
            }
            k0.c cVar = (k0.c) it.next();
            if (!copyOnWriteArraySet.contains(cVar)) {
                cVar.onAudioSessionId(i3);
            }
        }
        Iterator it2 = copyOnWriteArraySet.iterator();
        while (it2.hasNext()) {
            ((l0.i) it2.next()).onAudioSessionId(i3);
        }
    }

    @Override // l0.i
    public final void onAudioSinkUnderrun(int i3, long j2, long j5) {
        Iterator it = this.f2282a.f2290k.iterator();
        while (it.hasNext()) {
            ((l0.i) it.next()).onAudioSinkUnderrun(i3, j2, j5);
        }
    }

    @Override // s1.j
    public final void onCues(List list) {
        q0 q0Var = this.f2282a;
        q0Var.f2302z = list;
        Iterator it = q0Var.f2287h.iterator();
        while (it.hasNext()) {
            ((s1.j) it.next()).onCues(list);
        }
    }

    @Override // h2.s
    public final void onDroppedFrames(int i3, long j2) {
        Iterator it = this.f2282a.f2289j.iterator();
        while (it.hasNext()) {
            ((h2.s) it.next()).onDroppedFrames(i3, j2);
        }
    }

    @Override // j0.j0
    public final /* synthetic */ void onIsPlayingChanged(boolean z3) {
    }

    @Override // j0.j0
    public final void onLoadingChanged(boolean z3) {
        this.f2282a.getClass();
    }

    @Override // b1.e
    public final void onMetadata(Metadata metadata) {
        Iterator it = this.f2282a.f2288i.iterator();
        while (it.hasNext()) {
            ((b1.e) it.next()).onMetadata(metadata);
        }
    }

    @Override // j0.j0
    public final /* synthetic */ void onPlaybackParametersChanged(h0 h0Var) {
    }

    @Override // j0.j0
    public final /* synthetic */ void onPlaybackSuppressionReasonChanged(int i3) {
    }

    @Override // j0.j0
    public final /* synthetic */ void onPlayerError(n nVar) {
    }

    @Override // j0.j0
    public final void onPlayerStateChanged(boolean z3, int i3) {
        q0 q0Var = this.f2282a;
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    return;
                }
            } else {
                q0Var.f2295p.getClass();
                return;
            }
        }
        q0Var.f2295p.getClass();
    }

    @Override // j0.j0
    public final /* synthetic */ void onPositionDiscontinuity(int i3) {
    }

    @Override // h2.s
    public final void onRenderedFirstFrame(Surface surface) {
        q0 q0Var = this.f2282a;
        if (q0Var.q == surface) {
            Iterator it = q0Var.f2285f.iterator();
            while (it.hasNext()) {
                ((h2.n) it.next()).a();
            }
        }
        Iterator it2 = q0Var.f2289j.iterator();
        while (it2.hasNext()) {
            ((h2.s) it2.next()).onRenderedFirstFrame(surface);
        }
    }

    @Override // j0.j0
    public final /* synthetic */ void onRepeatModeChanged(int i3) {
    }

    @Override // j0.j0
    public final /* synthetic */ void onSeekProcessed() {
    }

    @Override // j0.j0
    public final /* synthetic */ void onShuffleModeEnabledChanged(boolean z3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i5) {
        Surface surface = new Surface(surfaceTexture);
        q0 q0Var = this.f2282a;
        q0Var.L(surface, true);
        q0Var.D(i3, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        q0 q0Var = this.f2282a;
        q0Var.L(null, true);
        q0Var.D(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i5) {
        this.f2282a.D(i3, i5);
    }

    @Override // j0.j0
    public final /* synthetic */ void onTimelineChanged(u0 u0Var, int i3) {
        a1.i.a(this, u0Var, i3);
    }

    @Override // j0.j0
    public final /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, b2.o oVar) {
    }

    @Override // h2.s
    public final void onVideoDecoderInitialized(String str, long j2, long j5) {
        Iterator it = this.f2282a.f2289j.iterator();
        while (it.hasNext()) {
            ((h2.s) it.next()).onVideoDecoderInitialized(str, j2, j5);
        }
    }

    @Override // h2.s
    public final void onVideoDisabled(m0.c cVar) {
        q0 q0Var = this.f2282a;
        Iterator it = q0Var.f2289j.iterator();
        while (it.hasNext()) {
            ((h2.s) it.next()).onVideoDisabled(cVar);
        }
        q0Var.getClass();
        q0Var.getClass();
    }

    @Override // h2.s
    public final void onVideoEnabled(m0.c cVar) {
        q0 q0Var = this.f2282a;
        q0Var.getClass();
        Iterator it = q0Var.f2289j.iterator();
        while (it.hasNext()) {
            ((h2.s) it.next()).onVideoEnabled(cVar);
        }
    }

    @Override // h2.s
    public final void onVideoInputFormatChanged(Format format) {
        q0 q0Var = this.f2282a;
        q0Var.getClass();
        Iterator it = q0Var.f2289j.iterator();
        while (it.hasNext()) {
            ((h2.s) it.next()).onVideoInputFormatChanged(format);
        }
    }

    @Override // h2.s
    public final void onVideoSizeChanged(int i3, int i5, int i6, float f4) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        q0 q0Var = this.f2282a;
        Iterator it = q0Var.f2285f.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            copyOnWriteArraySet = q0Var.f2289j;
            if (!hasNext) {
                break;
            }
            h2.n nVar = (h2.n) it.next();
            if (!copyOnWriteArraySet.contains(nVar)) {
                nVar.onVideoSizeChanged(i3, i5, i6, f4);
            }
        }
        Iterator it2 = copyOnWriteArraySet.iterator();
        while (it2.hasNext()) {
            ((h2.s) it2.next()).onVideoSizeChanged(i3, i5, i6, f4);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i5, int i6) {
        this.f2282a.D(i5, i6);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f2282a.L(surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        q0 q0Var = this.f2282a;
        q0Var.L(null, false);
        q0Var.D(0, 0);
    }

    @Override // j0.j0
    public final /* synthetic */ void onTimelineChanged(u0 u0Var, Object obj, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

package c2;

import android.view.TextureView;
import android.view.View;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import j0.h0;
import j0.j0;
import j0.u0;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements j0, s1.j, h2.n, View.OnLayoutChangeListener, d2.g, f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlayerView f204a;

    public g(PlayerView playerView) {
        this.f204a = playerView;
    }

    @Override // h2.n
    public final void a() {
        View view = this.f204a.c;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // h2.n
    public final /* synthetic */ void b(int i3, int i5) {
    }

    @Override // s1.j
    public final void onCues(List list) {
        SubtitleView subtitleView = this.f204a.f463f;
        if (subtitleView != null) {
            subtitleView.setCues(list);
        }
    }

    @Override // j0.j0
    public final /* synthetic */ void onIsPlayingChanged(boolean z3) {
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        PlayerView.a((TextureView) view, this.f204a.f478x);
    }

    @Override // j0.j0
    public final /* synthetic */ void onLoadingChanged(boolean z3) {
    }

    @Override // j0.j0
    public final /* synthetic */ void onPlaybackParametersChanged(h0 h0Var) {
    }

    @Override // j0.j0
    public final /* synthetic */ void onPlaybackSuppressionReasonChanged(int i3) {
    }

    @Override // j0.j0
    public final /* synthetic */ void onPlayerError(j0.n nVar) {
    }

    @Override // j0.j0
    public final void onPlayerStateChanged(boolean z3, int i3) {
        int i5 = PlayerView.f460z;
        PlayerView playerView = this.f204a;
        playerView.h();
        playerView.j();
        if (playerView.b() && playerView.f477v) {
            PlayerControlView playerControlView = playerView.f466i;
            if (playerControlView != null) {
                playerControlView.b();
                return;
            }
            return;
        }
        playerView.c(false);
    }

    @Override // j0.j0
    public final void onPositionDiscontinuity(int i3) {
        PlayerControlView playerControlView;
        int i5 = PlayerView.f460z;
        PlayerView playerView = this.f204a;
        if (playerView.b() && playerView.f477v && (playerControlView = playerView.f466i) != null) {
            playerControlView.b();
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

    @Override // j0.j0
    public final /* synthetic */ void onTimelineChanged(u0 u0Var, int i3) {
        a1.i.a(this, u0Var, i3);
    }

    @Override // j0.j0
    public final void onTracksChanged(TrackGroupArray trackGroupArray, b2.o oVar) {
        int i3 = PlayerView.f460z;
        this.f204a.k(false);
    }

    @Override // h2.n
    public final void onVideoSizeChanged(int i3, int i5, int i6, float f4) {
        float f5;
        if (i5 != 0 && i3 != 0) {
            f5 = (i3 * f4) / i5;
        } else {
            f5 = 1.0f;
        }
        PlayerView playerView = this.f204a;
        View view = playerView.d;
        boolean z3 = view instanceof TextureView;
        View view2 = playerView.d;
        if (z3) {
            if (i6 == 90 || i6 == 270) {
                f5 = 1.0f / f5;
            }
            if (playerView.f478x != 0) {
                view.removeOnLayoutChangeListener(this);
            }
            playerView.f478x = i6;
            if (i6 != 0) {
                view2.addOnLayoutChangeListener(this);
            }
            PlayerView.a((TextureView) view2, playerView.f478x);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = playerView.b;
        if (aspectRatioFrameLayout != null) {
            if (view2 instanceof SphericalGLSurfaceView) {
                f5 = 0.0f;
            }
            aspectRatioFrameLayout.setAspectRatio(f5);
        }
    }

    @Override // j0.j0
    public final /* synthetic */ void onTimelineChanged(u0 u0Var, Object obj, int i3) {
    }
}

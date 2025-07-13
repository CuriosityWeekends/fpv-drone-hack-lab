package c2;

import android.view.View;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.ui.PlayerControlView;
import j0.h0;
import j0.j0;
import j0.l0;
import j0.t0;
import j0.u0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements j0, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlayerControlView f203a;

    public d(PlayerControlView playerControlView) {
        this.f203a = playerControlView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i3;
        int i5;
        PlayerControlView playerControlView = this.f203a;
        l0 l0Var = playerControlView.G;
        if (l0Var == null) {
            return;
        }
        if (playerControlView.d == view) {
            playerControlView.e(l0Var);
        } else if (playerControlView.c == view) {
            playerControlView.f(l0Var);
        } else if (playerControlView.f443g == view) {
            j.a aVar = (j.a) l0Var;
            u0 r5 = aVar.r();
            if (!r5.o() && r5.m(aVar.w(), (t0) aVar.f2183a, 0L).d && (i5 = playerControlView.N) > 0) {
                playerControlView.h(aVar, i5);
            }
        } else if (playerControlView.f444h == view) {
            j.a aVar2 = (j.a) l0Var;
            u0 r6 = aVar2.r();
            if (!r6.o() && r6.m(aVar2.w(), (t0) aVar2.f2183a, 0L).d && (i3 = playerControlView.M) > 0) {
                playerControlView.h(aVar2, -i3);
            }
        } else if (playerControlView.f441e == view) {
            if (l0Var.getPlaybackState() != 1 && l0Var.getPlaybackState() == 4) {
                playerControlView.g(l0Var, l0Var.w(), -9223372036854775807L);
            }
            ((j3.a) playerControlView.H).getClass();
            l0Var.c(true);
        } else if (playerControlView.f442f == view) {
            ((j3.a) playerControlView.H).getClass();
            l0Var.c(false);
        } else if (playerControlView.f445i == view) {
            j0.j jVar = playerControlView.H;
            int repeatMode = l0Var.getRepeatMode();
            int i6 = playerControlView.Q;
            for (int i7 = 1; i7 <= 2; i7++) {
                int i8 = (repeatMode + i7) % 3;
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 == 2 && (i6 & 2) != 0) {
                        }
                    } else if ((i6 & 1) == 0) {
                    }
                }
                repeatMode = i8;
            }
            ((j3.a) jVar).getClass();
            l0Var.setRepeatMode(repeatMode);
        } else if (playerControlView.f446j == view) {
            ((j3.a) playerControlView.H).getClass();
            l0Var.k(!l0Var.t());
        }
    }

    @Override // j0.j0
    public final void onIsPlayingChanged(boolean z3) {
        int i3 = PlayerControlView.f438c0;
        this.f203a.m();
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
        int i5 = PlayerControlView.f438c0;
        PlayerControlView playerControlView = this.f203a;
        playerControlView.l();
        playerControlView.m();
    }

    @Override // j0.j0
    public final void onPositionDiscontinuity(int i3) {
        int i5 = PlayerControlView.f438c0;
        PlayerControlView playerControlView = this.f203a;
        playerControlView.k();
        playerControlView.p();
    }

    @Override // j0.j0
    public final void onRepeatModeChanged(int i3) {
        int i5 = PlayerControlView.f438c0;
        PlayerControlView playerControlView = this.f203a;
        playerControlView.n();
        playerControlView.k();
    }

    @Override // j0.j0
    public final /* synthetic */ void onSeekProcessed() {
    }

    @Override // j0.j0
    public final void onShuffleModeEnabledChanged(boolean z3) {
        int i3 = PlayerControlView.f438c0;
        PlayerControlView playerControlView = this.f203a;
        playerControlView.o();
        playerControlView.k();
    }

    @Override // j0.j0
    public final /* synthetic */ void onTimelineChanged(u0 u0Var, Object obj, int i3) {
    }

    @Override // j0.j0
    public final /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, b2.o oVar) {
    }

    @Override // j0.j0
    public final void onTimelineChanged(u0 u0Var, int i3) {
        int i5 = PlayerControlView.f438c0;
        PlayerControlView playerControlView = this.f203a;
        playerControlView.k();
        playerControlView.p();
    }
}

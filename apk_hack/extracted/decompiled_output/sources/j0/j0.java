package j0;

import com.google.android.exoplayer2.source.TrackGroupArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface j0 {
    void onIsPlayingChanged(boolean z3);

    void onLoadingChanged(boolean z3);

    void onPlaybackParametersChanged(h0 h0Var);

    void onPlaybackSuppressionReasonChanged(int i3);

    void onPlayerError(n nVar);

    void onPlayerStateChanged(boolean z3, int i3);

    void onPositionDiscontinuity(int i3);

    void onRepeatModeChanged(int i3);

    void onSeekProcessed();

    void onShuffleModeEnabledChanged(boolean z3);

    void onTimelineChanged(u0 u0Var, int i3);

    void onTimelineChanged(u0 u0Var, Object obj, int i3);

    void onTracksChanged(TrackGroupArray trackGroupArray, b2.o oVar);
}

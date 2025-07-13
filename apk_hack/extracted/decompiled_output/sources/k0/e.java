package k0;

import android.view.Surface;
import b2.o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import j0.h0;
import j0.n;
import j1.v;
import j1.w;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface e {
    void onAudioSessionId(d dVar, int i3);

    void onAudioUnderrun(d dVar, int i3, long j2, long j5);

    void onBandwidthEstimate(d dVar, int i3, long j2, long j5);

    void onDecoderDisabled(d dVar, int i3, m0.c cVar);

    void onDecoderEnabled(d dVar, int i3, m0.c cVar);

    void onDecoderInitialized(d dVar, int i3, String str, long j2);

    void onDecoderInputFormatChanged(d dVar, int i3, Format format);

    void onDownstreamFormatChanged(d dVar, w wVar);

    void onDroppedVideoFrames(d dVar, int i3, long j2);

    void onIsPlayingChanged(d dVar, boolean z3);

    void onLoadCanceled(d dVar, v vVar, w wVar);

    void onLoadCompleted(d dVar, v vVar, w wVar);

    void onLoadError(d dVar, v vVar, w wVar, IOException iOException, boolean z3);

    void onLoadStarted(d dVar, v vVar, w wVar);

    void onLoadingChanged(d dVar, boolean z3);

    void onMediaPeriodCreated(d dVar);

    void onMediaPeriodReleased(d dVar);

    void onMetadata(d dVar, Metadata metadata);

    void onPlaybackParametersChanged(d dVar, h0 h0Var);

    void onPlaybackSuppressionReasonChanged(d dVar, int i3);

    void onPlayerError(d dVar, n nVar);

    void onPlayerStateChanged(d dVar, boolean z3, int i3);

    void onPositionDiscontinuity(d dVar, int i3);

    void onReadingStarted(d dVar);

    void onRenderedFirstFrame(d dVar, Surface surface);

    void onRepeatModeChanged(d dVar, int i3);

    void onSeekProcessed(d dVar);

    void onSeekStarted(d dVar);

    void onShuffleModeChanged(d dVar, boolean z3);

    void onSurfaceSizeChanged(d dVar, int i3, int i5);

    void onTimelineChanged(d dVar, int i3);

    void onTracksChanged(d dVar, TrackGroupArray trackGroupArray, o oVar);

    void onUpstreamDiscarded(d dVar, w wVar);

    void onVideoSizeChanged(d dVar, int i3, int i5, int i6, float f4);

    void onVolumeChanged(d dVar, float f4);
}

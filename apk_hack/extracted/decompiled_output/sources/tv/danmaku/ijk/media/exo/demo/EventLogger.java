package tv.danmaku.ijk.media.exo.demo;

import a1.i;
import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer.MediaCodecTrackRenderer;
import com.google.android.exoplayer.TimeRange;
import com.google.android.exoplayer.audio.AudioTrack;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.util.VerboseLogUtil;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import tv.danmaku.ijk.media.exo.demo.player.DemoPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class EventLogger implements DemoPlayer.Listener, DemoPlayer.InfoListener, DemoPlayer.InternalErrorListener {
    private static final String TAG = "EventLogger";
    private static final NumberFormat TIME_FORMAT;
    private long[] availableRangeValuesUs;
    private long[] loadStartTimeMs = new long[4];
    private long sessionStartTimeMs;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
    }

    private String getSessionTimeString() {
        return getTimeString(SystemClock.elapsedRealtime() - this.sessionStartTimeMs);
    }

    private String getStateString(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "?";
                        }
                        return ExifInterface.LONGITUDE_EAST;
                    }
                    return "R";
                }
                return "B";
            }
            return "P";
        }
        return "I";
    }

    private String getTimeString(long j2) {
        return TIME_FORMAT.format(((float) j2) / 1000.0f);
    }

    private void printInternalError(String str, Exception exc) {
        Log.e(TAG, "internalError [" + getSessionTimeString() + ", " + str + "]", exc);
    }

    public void endSession() {
        Log.d(TAG, "end [" + getSessionTimeString() + "]");
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InfoListener
    public void onAudioFormatEnabled(Format format, int i3, long j2) {
        Log.d(TAG, "audioFormat [" + getSessionTimeString() + ", " + format.id + ", " + Integer.toString(i3) + "]");
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InternalErrorListener
    public void onAudioTrackInitializationError(AudioTrack.InitializationException initializationException) {
        printInternalError("audioTrackInitializationError", initializationException);
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InternalErrorListener
    public void onAudioTrackUnderrun(int i3, long j2, long j5) {
        printInternalError("audioTrackUnderrun [" + i3 + ", " + j2 + ", " + j5 + "]", null);
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InternalErrorListener
    public void onAudioTrackWriteError(AudioTrack.WriteException writeException) {
        printInternalError("audioTrackWriteError", writeException);
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InfoListener
    public void onAvailableRangeChanged(int i3, TimeRange timeRange) {
        this.availableRangeValuesUs = timeRange.getCurrentBoundsUs(this.availableRangeValuesUs);
        Log.d(TAG, "availableRange [" + timeRange.isStatic() + ", " + this.availableRangeValuesUs[0] + ", " + this.availableRangeValuesUs[1] + "]");
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InfoListener
    public void onBandwidthSample(int i3, long j2, long j5) {
        Log.d(TAG, "bandwidth [" + getSessionTimeString() + ", " + j2 + ", " + getTimeString(i3) + ", " + j5 + "]");
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InternalErrorListener
    public void onCryptoError(MediaCodec.CryptoException cryptoException) {
        printInternalError("cryptoError", cryptoException);
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InternalErrorListener
    public void onDecoderInitializationError(MediaCodecTrackRenderer.DecoderInitializationException decoderInitializationException) {
        printInternalError("decoderInitializationError", decoderInitializationException);
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InfoListener
    public void onDecoderInitialized(String str, long j2, long j5) {
        Log.d(TAG, "decoderInitialized [" + getSessionTimeString() + ", " + str + "]");
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InternalErrorListener
    public void onDrmSessionManagerError(Exception exc) {
        printInternalError("drmSessionManagerError", exc);
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InfoListener
    public void onDroppedFrames(int i3, long j2) {
        Log.d(TAG, "droppedFrames [" + getSessionTimeString() + ", " + i3 + "]");
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.Listener
    public void onError(Exception exc) {
        Log.e(TAG, "playerFailed [" + getSessionTimeString() + "]", exc);
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InfoListener
    public void onLoadCompleted(int i3, long j2, int i5, int i6, Format format, long j5, long j6, long j7, long j8) {
        if (VerboseLogUtil.isTagEnabled(TAG)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.loadStartTimeMs[i3];
            Log.v(TAG, "loadEnd [" + getSessionTimeString() + ", " + i3 + ", " + elapsedRealtime + "]");
        }
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InternalErrorListener
    public void onLoadError(int i3, IOException iOException) {
        printInternalError("loadError", iOException);
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InfoListener
    public void onLoadStarted(int i3, long j2, int i5, int i6, Format format, long j5, long j6) {
        this.loadStartTimeMs[i3] = SystemClock.elapsedRealtime();
        if (VerboseLogUtil.isTagEnabled(TAG)) {
            Log.v(TAG, "loadStart [" + getSessionTimeString() + ", " + i3 + ", " + i5 + ", " + j5 + ", " + j6 + "]");
        }
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InternalErrorListener
    public void onRendererInitializationError(Exception exc) {
        printInternalError("rendererInitError", exc);
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.Listener
    public void onStateChanged(boolean z3, int i3) {
        Log.d(TAG, "state [" + getSessionTimeString() + ", " + z3 + ", " + getStateString(i3) + "]");
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.InfoListener
    public void onVideoFormatEnabled(Format format, int i3, long j2) {
        Log.d(TAG, "videoFormat [" + getSessionTimeString() + ", " + format.id + ", " + Integer.toString(i3) + "]");
    }

    @Override // tv.danmaku.ijk.media.exo.demo.player.DemoPlayer.Listener
    public void onVideoSizeChanged(int i3, int i5, int i6, float f4) {
        StringBuilder n5 = i.n("videoSizeChanged [", i3, ", ", i5, ", ");
        n5.append(i6);
        n5.append(", ");
        n5.append(f4);
        n5.append("]");
        Log.d(TAG, n5.toString());
    }

    public void startSession() {
        this.sessionStartTimeMs = SystemClock.elapsedRealtime();
        Log.d(TAG, "start [0]");
    }
}

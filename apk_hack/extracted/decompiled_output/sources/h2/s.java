package h2;

import android.view.Surface;
import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface s {
    void onDroppedFrames(int i3, long j2);

    void onRenderedFirstFrame(Surface surface);

    void onVideoDecoderInitialized(String str, long j2, long j5);

    void onVideoDisabled(m0.c cVar);

    void onVideoEnabled(m0.c cVar);

    void onVideoInputFormatChanged(Format format);

    void onVideoSizeChanged(int i3, int i5, int i6, float f4);
}

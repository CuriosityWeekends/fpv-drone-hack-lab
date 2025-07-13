package l0;

import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface i {
    void onAudioDecoderInitialized(String str, long j2, long j5);

    void onAudioDisabled(m0.c cVar);

    void onAudioEnabled(m0.c cVar);

    void onAudioInputFormatChanged(Format format);

    void onAudioSessionId(int i3);

    void onAudioSinkUnderrun(int i3, long j2, long j5);
}

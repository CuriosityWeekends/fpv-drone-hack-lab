package com.shuyu.gsyvideoplayer.player;

import android.content.Context;
import android.os.Message;
import java.util.List;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface c {
    int getBufferedPercentage();

    long getCurrentPosition();

    long getDuration();

    IMediaPlayer getMediaPlayer();

    long getNetSpeed();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    void initVideoPlayer(Context context, Message message, List list, m3.b bVar);

    boolean isPlaying();

    boolean isSurfaceSupportLockCanvas();

    void pause();

    void release();

    void releaseSurface();

    void seekTo(long j2);

    void setNeedMute(boolean z3);

    void setSpeed(float f4, boolean z3);

    void setSpeedPlaying(float f4, boolean z3);

    void showDisplay(Message message);

    void start();

    void stop();
}

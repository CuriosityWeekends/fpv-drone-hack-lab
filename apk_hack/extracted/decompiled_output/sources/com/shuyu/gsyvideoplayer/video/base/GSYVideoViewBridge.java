package com.shuyu.gsyvideoplayer.video.base;

import android.content.Context;
import android.view.Surface;
import com.shuyu.gsyvideoplayer.player.c;
import java.io.File;
import java.util.Map;
import n3.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface GSYVideoViewBridge {
    boolean cachePreview(Context context, File file, String str);

    void clearCache(Context context, File file, String str);

    int getBufferedPercentage();

    long getCurrentPosition();

    int getCurrentVideoHeight();

    int getCurrentVideoWidth();

    long getDuration();

    int getLastState();

    long getNetSpeed();

    int getPlayPosition();

    String getPlayTag();

    c getPlayer();

    int getRotateInfoFlag();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    boolean isCacheFile();

    boolean isPlaying();

    boolean isSurfaceSupportLockCanvas();

    a lastListener();

    a listener();

    void pause();

    void prepare(String str, Map<String, String> map, boolean z3, float f4, boolean z5, File file);

    void prepare(String str, Map<String, String> map, boolean z3, float f4, boolean z5, File file, String str2);

    void releaseMediaPlayer();

    void releaseSurface(Surface surface);

    void seekTo(long j2);

    void setCurrentVideoHeight(int i3);

    void setCurrentVideoWidth(int i3);

    void setDisplay(Surface surface);

    void setLastListener(a aVar);

    void setLastState(int i3);

    void setListener(a aVar);

    void setPlayPosition(int i3);

    void setPlayTag(String str);

    void setSpeed(float f4, boolean z3);

    void setSpeedPlaying(float f4, boolean z3);

    void start();

    void stop();
}

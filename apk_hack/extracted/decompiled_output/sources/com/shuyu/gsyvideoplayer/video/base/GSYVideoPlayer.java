package com.shuyu.gsyvideoplayer.video.base;

import android.content.Context;
import android.util.AttributeSet;
import l3.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class GSYVideoPlayer extends GSYBaseVideoPlayer {
    public GSYVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public boolean backFromFull(Context context) {
        return e.b(context);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public int getFullId() {
        return e.f2723o;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public GSYVideoViewBridge getGSYVideoManager() {
        e c = e.c();
        Context applicationContext = getContext().getApplicationContext();
        c.getClass();
        c.f2712a = applicationContext.getApplicationContext();
        return e.c();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public int getSmallId() {
        return e.f2722n;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void releaseVideos() {
        if (e.c().listener() != null) {
            e.c().listener().onCompletion();
        }
        e.c().releaseMediaPlayer();
    }

    public GSYVideoPlayer(Context context) {
        super(context);
    }

    public GSYVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GSYVideoPlayer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

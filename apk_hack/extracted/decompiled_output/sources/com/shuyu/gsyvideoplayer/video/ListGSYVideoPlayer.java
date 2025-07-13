package com.shuyu.gsyvideoplayer.video;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import moe.codeest.enviews.ENDownloadView;
import o3.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ListGSYVideoPlayer extends StandardGSYVideoPlayer {
    protected int mPlayPosition;
    protected List<b> mUriList;

    public ListGSYVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
        this.mUriList = new ArrayList();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void changeUiToNormal() {
        super.changeUiToNormal();
        if (this.mHadPlay && this.mPlayPosition < this.mUriList.size()) {
            setViewShowState(this.mThumbImageViewLayout, 8);
            setViewShowState(this.mTopContainer, 4);
            setViewShowState(this.mBottomContainer, 4);
            setViewShowState(this.mStartButton, 8);
            setViewShowState(this.mLoadingProgressBar, 0);
            setViewShowState(this.mBottomProgressBar, 4);
            setViewShowState(this.mLockScreen, 8);
            View view = this.mLoadingProgressBar;
            if (view instanceof ENDownloadView) {
                ((ENDownloadView) view).c();
            }
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        super.cloneParams(gSYBaseVideoPlayer, gSYBaseVideoPlayer2);
        ListGSYVideoPlayer listGSYVideoPlayer = (ListGSYVideoPlayer) gSYBaseVideoPlayer;
        ListGSYVideoPlayer listGSYVideoPlayer2 = (ListGSYVideoPlayer) gSYBaseVideoPlayer2;
        listGSYVideoPlayer2.mPlayPosition = listGSYVideoPlayer.mPlayPosition;
        listGSYVideoPlayer2.mUriList = listGSYVideoPlayer.mUriList;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public void onAutoCompletion() {
        if (playNext()) {
            return;
        }
        super.onAutoCompletion();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public void onCompletion() {
        releaseNetWorkState();
        if (this.mPlayPosition < this.mUriList.size()) {
            return;
        }
        super.onCompletion();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public void onPrepared() {
        super.onPrepared();
    }

    public boolean playNext() {
        if (this.mPlayPosition < this.mUriList.size() - 1) {
            int i3 = this.mPlayPosition + 1;
            this.mPlayPosition = i3;
            b bVar = this.mUriList.get(i3);
            this.mSaveChangeViewTIme = 0L;
            setUp(this.mUriList, this.mCache, this.mPlayPosition, null, this.mMapHeadData, false);
            if (!TextUtils.isEmpty(bVar.getTitle())) {
                this.mTitleTextView.setText(bVar.getTitle());
            }
            startPlayLogic();
            return true;
        }
        return false;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void prepareVideo() {
        super.prepareVideo();
        if (this.mHadPlay && this.mPlayPosition < this.mUriList.size()) {
            setViewShowState(this.mLoadingProgressBar, 0);
            View view = this.mLoadingProgressBar;
            if (view instanceof ENDownloadView) {
                ((ENDownloadView) view).c();
            }
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public void resolveNormalVideoShow(View view, ViewGroup viewGroup, GSYVideoPlayer gSYVideoPlayer) {
        if (gSYVideoPlayer != null) {
            ListGSYVideoPlayer listGSYVideoPlayer = (ListGSYVideoPlayer) gSYVideoPlayer;
            b bVar = this.mUriList.get(this.mPlayPosition);
            if (!TextUtils.isEmpty(bVar.getTitle())) {
                this.mTitleTextView.setText(bVar.getTitle());
            }
        }
        super.resolveNormalVideoShow(view, viewGroup, gSYVideoPlayer);
    }

    public boolean setUp(List<b> list, boolean z3, int i3) {
        return setUp(list, z3, i3, (File) null, new HashMap());
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean z3, boolean z5) {
        GSYBaseVideoPlayer startWindowFullscreen = super.startWindowFullscreen(context, z3, z5);
        if (startWindowFullscreen != null) {
            ListGSYVideoPlayer listGSYVideoPlayer = (ListGSYVideoPlayer) startWindowFullscreen;
            b bVar = this.mUriList.get(this.mPlayPosition);
            if (!TextUtils.isEmpty(bVar.getTitle())) {
                listGSYVideoPlayer.mTitleTextView.setText(bVar.getTitle());
            }
        }
        return startWindowFullscreen;
    }

    public boolean setUp(List<b> list, boolean z3, int i3, File file) {
        return setUp(list, z3, i3, file, new HashMap());
    }

    public ListGSYVideoPlayer(Context context) {
        super(context);
        this.mUriList = new ArrayList();
    }

    public boolean setUp(List<b> list, boolean z3, int i3, File file, Map<String, String> map) {
        return setUp(list, z3, i3, file, map, true);
    }

    public boolean setUp(List<b> list, boolean z3, int i3, File file, Map<String, String> map, boolean z5) {
        this.mUriList = list;
        this.mPlayPosition = i3;
        this.mMapHeadData = map;
        b bVar = list.get(i3);
        boolean up = setUp(bVar.getUrl(), z3, file, bVar.getTitle(), z5);
        if (!TextUtils.isEmpty(bVar.getTitle())) {
            this.mTitleTextView.setText(bVar.getTitle());
        }
        return up;
    }

    public ListGSYVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUriList = new ArrayList();
    }
}

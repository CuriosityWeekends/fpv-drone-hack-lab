package com.shuyu.gsyvideoplayer.builder;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import java.io.File;
import java.util.Map;
import n3.c;
import n3.f;
import n3.g;
import s3.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class a {
    protected Drawable mBottomProgressDrawable;
    protected Drawable mBottomShowProgressDrawable;
    protected Drawable mBottomShowProgressThumbDrawable;
    protected File mCachePath;
    protected boolean mCacheWithPlay;
    protected Drawable mDialogProgressBarDrawable;
    protected c mGSYVideoProgressListener;
    protected f mLockClickListener;
    protected Map<String, String> mMapHeadData;
    protected boolean mNeedLockFull;
    protected String mOverrideExtension;
    protected boolean mSounchTouch;
    protected View mThumbImageView;
    protected boolean mThumbPlay;
    protected String mUrl;
    protected g mVideoAllCallBack;
    protected Drawable mVolumeProgressDrawable;
    protected int mShrinkImageRes = -1;
    protected int mEnlargeImageRes = -1;
    protected int mPlayPosition = -22;
    protected int mDialogProgressHighLightColor = -11;
    protected int mDialogProgressNormalColor = -11;
    protected int mDismissControlTime = 2500;
    protected long mSeekOnStart = -1;
    protected float mSeekRatio = 1.0f;
    protected float mSpeed = 1.0f;
    protected boolean mHideKey = true;
    protected boolean mShowFullAnimation = true;
    protected boolean mAutoFullWithSize = false;
    protected boolean mNeedShowWifiTip = true;
    protected boolean mRotateViewAuto = true;
    protected boolean mLockLand = false;
    protected boolean mLooping = false;
    protected boolean mIsTouchWiget = true;
    protected boolean mIsTouchWigetFull = true;
    protected boolean mShowPauseCover = true;
    protected boolean mRotateWithSystem = true;
    protected boolean mSetUpLazy = false;
    protected boolean mStartAfterPrepared = true;
    protected boolean mReleaseWhenLossAudio = true;
    protected boolean mActionBar = false;
    protected boolean mStatusBar = false;
    protected boolean isShowDragProgressTextOnSeekBar = false;
    protected String mPlayTag = "";
    protected String mVideoTitle = null;
    private boolean mIsOnlyRotateLand = false;
    protected b mEffectFilter = new j3.b(23);

    public void build(StandardGSYVideoPlayer standardGSYVideoPlayer) {
        int i3;
        Drawable drawable;
        Drawable drawable2 = this.mBottomShowProgressDrawable;
        if (drawable2 != null && (drawable = this.mBottomShowProgressThumbDrawable) != null) {
            standardGSYVideoPlayer.setBottomShowProgressBarDrawable(drawable2, drawable);
        }
        Drawable drawable3 = this.mBottomProgressDrawable;
        if (drawable3 != null) {
            standardGSYVideoPlayer.setBottomProgressBarDrawable(drawable3);
        }
        Drawable drawable4 = this.mVolumeProgressDrawable;
        if (drawable4 != null) {
            standardGSYVideoPlayer.setDialogVolumeProgressBar(drawable4);
        }
        Drawable drawable5 = this.mDialogProgressBarDrawable;
        if (drawable5 != null) {
            standardGSYVideoPlayer.setDialogProgressBar(drawable5);
        }
        int i5 = this.mDialogProgressHighLightColor;
        if (i5 > 0 && (i3 = this.mDialogProgressNormalColor) > 0) {
            standardGSYVideoPlayer.setDialogProgressColor(i5, i3);
        }
        build((GSYBaseVideoPlayer) standardGSYVideoPlayer);
    }

    public a setAutoFullWithSize(boolean z3) {
        this.mAutoFullWithSize = z3;
        return this;
    }

    public a setBottomProgressBarDrawable(Drawable drawable) {
        this.mBottomProgressDrawable = drawable;
        return this;
    }

    public a setBottomShowProgressBarDrawable(Drawable drawable, Drawable drawable2) {
        this.mBottomShowProgressDrawable = drawable;
        this.mBottomShowProgressThumbDrawable = drawable2;
        return this;
    }

    public a setCachePath(File file) {
        this.mCachePath = file;
        return this;
    }

    public a setCacheWithPlay(boolean z3) {
        this.mCacheWithPlay = z3;
        return this;
    }

    public a setDialogProgressBar(Drawable drawable) {
        this.mDialogProgressBarDrawable = drawable;
        return this;
    }

    public a setDialogProgressColor(int i3, int i5) {
        this.mDialogProgressHighLightColor = i3;
        this.mDialogProgressNormalColor = i5;
        return this;
    }

    public a setDialogVolumeProgressBar(Drawable drawable) {
        this.mVolumeProgressDrawable = drawable;
        return this;
    }

    public a setDismissControlTime(int i3) {
        this.mDismissControlTime = i3;
        return this;
    }

    public a setEffectFilter(b bVar) {
        this.mEffectFilter = bVar;
        return this;
    }

    public a setEnlargeImageRes(int i3) {
        this.mEnlargeImageRes = i3;
        return this;
    }

    public a setFullHideActionBar(boolean z3) {
        this.mActionBar = z3;
        return this;
    }

    public a setFullHideStatusBar(boolean z3) {
        this.mStatusBar = z3;
        return this;
    }

    public a setHideKey(boolean z3) {
        this.mHideKey = z3;
        return this;
    }

    public a setIsTouchWiget(boolean z3) {
        this.mIsTouchWiget = z3;
        return this;
    }

    public a setIsTouchWigetFull(boolean z3) {
        this.mIsTouchWigetFull = z3;
        return this;
    }

    public a setLockLand(boolean z3) {
        this.mLockLand = z3;
        return this;
    }

    public a setLooping(boolean z3) {
        this.mLooping = z3;
        return this;
    }

    public a setMapHeadData(Map<String, String> map) {
        this.mMapHeadData = map;
        return this;
    }

    public a setNeedLockFull(boolean z3) {
        this.mNeedLockFull = z3;
        return this;
    }

    public a setNeedShowWifiTip(boolean z3) {
        this.mNeedShowWifiTip = z3;
        return this;
    }

    public a setOnlyRotateLand(boolean z3) {
        this.mIsOnlyRotateLand = z3;
        return this;
    }

    public a setOverrideExtension(String str) {
        this.mOverrideExtension = str;
        return this;
    }

    public a setPlayPosition(int i3) {
        this.mPlayPosition = i3;
        return this;
    }

    public a setPlayTag(String str) {
        this.mPlayTag = str;
        return this;
    }

    public a setReleaseWhenLossAudio(boolean z3) {
        this.mReleaseWhenLossAudio = z3;
        return this;
    }

    public a setRotateViewAuto(boolean z3) {
        this.mRotateViewAuto = z3;
        return this;
    }

    public a setRotateWithSystem(boolean z3) {
        this.mRotateWithSystem = z3;
        return this;
    }

    public a setSeekOnStart(long j2) {
        this.mSeekOnStart = j2;
        return this;
    }

    public a setSeekRatio(float f4) {
        if (f4 < 0.0f) {
            return this;
        }
        this.mSeekRatio = f4;
        return this;
    }

    @Deprecated
    public a setSetUpLazy(boolean z3) {
        this.mSetUpLazy = z3;
        return this;
    }

    public a setShowDragProgressTextOnSeekBar(boolean z3) {
        this.isShowDragProgressTextOnSeekBar = z3;
        return this;
    }

    public a setShowFullAnimation(boolean z3) {
        this.mShowFullAnimation = z3;
        return this;
    }

    public a setShowPauseCover(boolean z3) {
        this.mShowPauseCover = z3;
        return this;
    }

    public a setShrinkImageRes(int i3) {
        this.mShrinkImageRes = i3;
        return this;
    }

    public a setSoundTouch(boolean z3) {
        this.mSounchTouch = z3;
        return this;
    }

    public a setSpeed(float f4) {
        this.mSpeed = f4;
        return this;
    }

    public a setStartAfterPrepared(boolean z3) {
        this.mStartAfterPrepared = z3;
        return this;
    }

    public a setThumbImageView(View view) {
        this.mThumbImageView = view;
        return this;
    }

    public a setThumbPlay(boolean z3) {
        this.mThumbPlay = z3;
        return this;
    }

    public a setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public a setVideoAllCallBack(g gVar) {
        this.mVideoAllCallBack = gVar;
        return this;
    }

    public a setVideoTitle(String str) {
        this.mVideoTitle = str;
        return this;
    }

    public void build(GSYBaseVideoPlayer gSYBaseVideoPlayer) {
        gSYBaseVideoPlayer.setPlayTag(this.mPlayTag);
        gSYBaseVideoPlayer.setPlayPosition(this.mPlayPosition);
        gSYBaseVideoPlayer.setThumbPlay(this.mThumbPlay);
        View view = this.mThumbImageView;
        if (view != null) {
            gSYBaseVideoPlayer.setThumbImageView(view);
        }
        gSYBaseVideoPlayer.setNeedLockFull(this.mNeedLockFull);
        gSYBaseVideoPlayer.setDismissControlTime(this.mDismissControlTime);
        long j2 = this.mSeekOnStart;
        if (j2 > 0) {
            gSYBaseVideoPlayer.setSeekOnStart(j2);
        }
        gSYBaseVideoPlayer.setShowFullAnimation(this.mShowFullAnimation);
        gSYBaseVideoPlayer.setLooping(this.mLooping);
        g gVar = this.mVideoAllCallBack;
        if (gVar != null) {
            gSYBaseVideoPlayer.setVideoAllCallBack(gVar);
        }
        gSYBaseVideoPlayer.setOverrideExtension(this.mOverrideExtension);
        gSYBaseVideoPlayer.setAutoFullWithSize(this.mAutoFullWithSize);
        gSYBaseVideoPlayer.setRotateViewAuto(this.mRotateViewAuto);
        gSYBaseVideoPlayer.setOnlyRotateLand(this.mIsOnlyRotateLand);
        gSYBaseVideoPlayer.setLockLand(this.mLockLand);
        gSYBaseVideoPlayer.setSpeed(this.mSpeed, this.mSounchTouch);
        gSYBaseVideoPlayer.setHideKey(this.mHideKey);
        gSYBaseVideoPlayer.setIsTouchWiget(this.mIsTouchWiget);
        gSYBaseVideoPlayer.setIsTouchWigetFull(this.mIsTouchWigetFull);
        gSYBaseVideoPlayer.setNeedShowWifiTip(this.mNeedShowWifiTip);
        gSYBaseVideoPlayer.setEffectFilter(this.mEffectFilter);
        gSYBaseVideoPlayer.setStartAfterPrepared(this.mStartAfterPrepared);
        gSYBaseVideoPlayer.setReleaseWhenLossAudio(this.mReleaseWhenLossAudio);
        gSYBaseVideoPlayer.setFullHideActionBar(this.mActionBar);
        gSYBaseVideoPlayer.setShowDragProgressTextOnSeekBar(this.isShowDragProgressTextOnSeekBar);
        gSYBaseVideoPlayer.setFullHideStatusBar(this.mStatusBar);
        int i3 = this.mEnlargeImageRes;
        if (i3 > 0) {
            gSYBaseVideoPlayer.setEnlargeImageRes(i3);
        }
        int i5 = this.mShrinkImageRes;
        if (i5 > 0) {
            gSYBaseVideoPlayer.setShrinkImageRes(i5);
        }
        gSYBaseVideoPlayer.setShowPauseCover(this.mShowPauseCover);
        gSYBaseVideoPlayer.setSeekRatio(this.mSeekRatio);
        gSYBaseVideoPlayer.setRotateWithSystem(this.mRotateWithSystem);
        if (this.mSetUpLazy) {
            gSYBaseVideoPlayer.setUpLazy(this.mUrl, this.mCacheWithPlay, this.mCachePath, this.mMapHeadData, this.mVideoTitle);
        } else {
            gSYBaseVideoPlayer.setUp(this.mUrl, this.mCacheWithPlay, this.mCachePath, this.mMapHeadData, this.mVideoTitle);
        }
    }

    public a setGSYVideoProgressListener(c cVar) {
        return this;
    }

    public a setLockClickListener(f fVar) {
        return this;
    }
}

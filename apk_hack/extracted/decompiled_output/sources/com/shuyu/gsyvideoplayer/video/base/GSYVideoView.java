package com.shuyu.gsyvideoplayer.video.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.NetInfoModule;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import l3.h;
import n3.a;
import n3.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class GSYVideoView extends GSYTextureRenderView implements a {
    public static final int CHANGE_DELAY_TIME = 2000;
    public static final int CURRENT_STATE_AUTO_COMPLETE = 6;
    public static final int CURRENT_STATE_ERROR = 7;
    public static final int CURRENT_STATE_NORMAL = 0;
    public static final int CURRENT_STATE_PAUSE = 5;
    public static final int CURRENT_STATE_PLAYING = 2;
    public static final int CURRENT_STATE_PLAYING_BUFFERING_START = 3;
    public static final int CURRENT_STATE_PREPAREING = 1;
    protected AudioManager mAudioManager;
    protected int mBackUpPlayingBufferState;
    protected int mBufferPoint;
    protected boolean mCache;
    protected File mCachePath;
    protected Context mContext;
    protected long mCurrentPosition;
    protected int mCurrentState;
    protected boolean mHadPlay;
    protected boolean mHadPrepared;
    protected boolean mIfCurrentIsFullscreen;
    protected boolean mLooping;
    protected Map<String, String> mMapHeadData;
    protected boolean mNetChanged;
    protected NetInfoModule mNetInfoModule;
    protected String mNetSate;
    protected String mOriginUrl;
    protected String mOverrideExtension;
    protected boolean mPauseBeforePrepared;
    protected int mPlayPosition;
    protected String mPlayTag;
    protected boolean mReleaseWhenLossAudio;
    protected long mSaveChangeViewTIme;
    protected int mScreenHeight;
    protected int mScreenWidth;
    protected long mSeekOnStart;
    protected boolean mShowPauseCover;
    protected boolean mSoundTouch;
    protected float mSpeed;
    protected boolean mStartAfterPrepared;
    protected String mTitle;
    protected String mUrl;
    protected g mVideoAllCallBack;
    protected AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    public GSYVideoView(@NonNull Context context) {
        super(context);
        this.mCurrentState = -1;
        this.mPlayPosition = -22;
        this.mBackUpPlayingBufferState = -1;
        this.mSeekOnStart = -1L;
        this.mSaveChangeViewTIme = 0L;
        this.mSpeed = 1.0f;
        this.mCache = false;
        this.mIfCurrentIsFullscreen = false;
        this.mLooping = false;
        this.mHadPlay = false;
        this.mNetChanged = false;
        this.mSoundTouch = false;
        this.mShowPauseCover = false;
        this.mPauseBeforePrepared = false;
        this.mStartAfterPrepared = true;
        this.mHadPrepared = false;
        this.mReleaseWhenLossAudio = true;
        this.mPlayTag = "";
        this.mNetSate = "NORMAL";
        this.mMapHeadData = new HashMap();
        this.onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoView.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i3) {
                if (i3 != -3) {
                    if (i3 != -2) {
                        if (i3 != -1) {
                            if (i3 == 1) {
                                GSYVideoView.this.onGankAudio();
                                return;
                            }
                            return;
                        }
                        GSYVideoView.this.onLossAudio();
                        return;
                    }
                    GSYVideoView.this.onLossTransientAudio();
                    return;
                }
                GSYVideoView.this.onLossTransientCanDuck();
            }
        };
        init(context);
    }

    public abstract boolean backFromFull(Context context);

    public void clearCurrentCache() {
        if (getGSYVideoManager().isCacheFile() && this.mCache) {
            Debuger.printfError("Play Error " + this.mUrl);
            this.mUrl = this.mOriginUrl;
            getGSYVideoManager().clearCache(this.mContext, this.mCachePath, this.mOriginUrl);
        } else if (this.mUrl.contains("127.0.0.1")) {
            getGSYVideoManager().clearCache(getContext(), this.mCachePath, this.mOriginUrl);
        }
    }

    public void createNetWorkState() {
        if (this.mNetInfoModule == null) {
            NetInfoModule netInfoModule = new NetInfoModule(this.mContext.getApplicationContext(), new NetInfoModule.NetChangeListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoView.4
                @Override // com.shuyu.gsyvideoplayer.utils.NetInfoModule.NetChangeListener
                public void changed(String str) {
                    if (!GSYVideoView.this.mNetSate.equals(str)) {
                        Debuger.printfError("******* change network state ******* " + str);
                        GSYVideoView.this.mNetChanged = true;
                    }
                    GSYVideoView.this.mNetSate = str;
                }
            });
            this.mNetInfoModule = netInfoModule;
            this.mNetSate = netInfoModule.getCurrentConnectionType();
        }
    }

    public void deleteCacheFileWhenError() {
        clearCurrentCache();
        Debuger.printfError("Link Or mCache Error, Please Try Again " + this.mOriginUrl);
        if (this.mCache) {
            Debuger.printfError("mCache Link " + this.mUrl);
        }
        this.mUrl = this.mOriginUrl;
    }

    public Context getActivityContext() {
        return CommonUtil.getActivityContext(getContext());
    }

    public int getBuffterPoint() {
        return this.mBufferPoint;
    }

    public int getCurrentPositionWhenPlaying() {
        int i3 = this.mCurrentState;
        int i5 = 0;
        if (i3 == 2 || i3 == 5) {
            try {
                i5 = (int) getGSYVideoManager().getCurrentPosition();
            } catch (Exception e5) {
                e5.printStackTrace();
                return 0;
            }
        }
        if (i5 == 0) {
            long j2 = this.mCurrentPosition;
            if (j2 > 0) {
                return (int) j2;
            }
        }
        return i5;
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getCurrentVideoHeight() {
        if (getGSYVideoManager() != null) {
            return getGSYVideoManager().getVideoHeight();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getCurrentVideoWidth() {
        if (getGSYVideoManager() != null) {
            return getGSYVideoManager().getVideoWidth();
        }
        return 0;
    }

    public int getDuration() {
        try {
            return (int) getGSYVideoManager().getDuration();
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public abstract GSYVideoViewBridge getGSYVideoManager();

    public abstract int getLayoutId();

    public Map<String, String> getMapHeadData() {
        return this.mMapHeadData;
    }

    public long getNetSpeed() {
        return getGSYVideoManager().getNetSpeed();
    }

    public String getNetSpeedText() {
        return CommonUtil.getTextSpeed(getNetSpeed());
    }

    public String getOverrideExtension() {
        return this.mOverrideExtension;
    }

    public int getPlayPosition() {
        return this.mPlayPosition;
    }

    public String getPlayTag() {
        return this.mPlayTag;
    }

    public long getSeekOnStart() {
        return this.mSeekOnStart;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getVideoSarDen() {
        if (getGSYVideoManager() != null) {
            return getGSYVideoManager().getVideoSarDen();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getVideoSarNum() {
        if (getGSYVideoManager() != null) {
            return getGSYVideoManager().getVideoSarNum();
        }
        return 0;
    }

    public void init(Context context) {
        if (getActivityContext() != null) {
            this.mContext = getActivityContext();
        } else {
            this.mContext = context;
        }
        initInflate(this.mContext);
        this.mTextureViewContainer = (ViewGroup) findViewById(h.surface_container);
        if (isInEditMode()) {
            return;
        }
        this.mScreenWidth = this.mContext.getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = this.mContext.getResources().getDisplayMetrics().heightPixels;
        this.mAudioManager = (AudioManager) this.mContext.getApplicationContext().getSystemService("audio");
    }

    public void initInflate(Context context) {
        try {
            View.inflate(context, getLayoutId(), this);
        } catch (InflateException e5) {
            if (!e5.toString().contains("GSYImageCover")) {
                e5.printStackTrace();
                return;
            }
            Debuger.printfError("********************\n*****   注意   *************************\n*该版本需要清除布局文件中的GSYImageCover\n****  Attention  ***\n*Please remove GSYImageCover from Layout in this Version\n********************\n");
            e5.printStackTrace();
            throw new InflateException("该版本需要清除布局文件中的GSYImageCover，please remove GSYImageCover from your layout");
        }
    }

    public boolean isCurrentMediaListener() {
        if (getGSYVideoManager().listener() != null && getGSYVideoManager().listener() == this) {
            return true;
        }
        return false;
    }

    public boolean isIfCurrentIsFullscreen() {
        return this.mIfCurrentIsFullscreen;
    }

    public boolean isInPlayingState() {
        int i3 = this.mCurrentState;
        if (i3 >= 0 && i3 != 0 && i3 != 6 && i3 != 7) {
            return true;
        }
        return false;
    }

    public boolean isLooping() {
        return this.mLooping;
    }

    public boolean isReleaseWhenLossAudio() {
        return this.mReleaseWhenLossAudio;
    }

    public boolean isShowPauseCover() {
        return this.mShowPauseCover;
    }

    public boolean isStartAfterPrepared() {
        return this.mStartAfterPrepared;
    }

    public void listenerNetWorkState() {
        NetInfoModule netInfoModule = this.mNetInfoModule;
        if (netInfoModule != null) {
            netInfoModule.onHostResume();
        }
    }

    public void netWorkErrorLogic() {
        final long currentPositionWhenPlaying = getCurrentPositionWhenPlaying();
        Debuger.printfError("******* Net State Changed. renew player to connect *******" + currentPositionWhenPlaying);
        getGSYVideoManager().releaseMediaPlayer();
        postDelayed(new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoView.this.setSeekOnStart(currentPositionWhenPlaying);
                GSYVideoView.this.startPlayLogic();
            }
        }, 500L);
    }

    public void onAutoCompletion() {
        setStateAndUi(6);
        this.mSaveChangeViewTIme = 0L;
        this.mCurrentPosition = 0L;
        if (this.mTextureViewContainer.getChildCount() > 0) {
            this.mTextureViewContainer.removeAllViews();
        }
        if (!this.mIfCurrentIsFullscreen) {
            getGSYVideoManager().setLastListener(null);
        }
        this.mAudioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
        Context context = this.mContext;
        if (context instanceof Activity) {
            try {
                ((Activity) context).getWindow().clearFlags(128);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        releaseNetWorkState();
        if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
            Debuger.printfLog("onAutoComplete");
            this.mVideoAllCallBack.getClass();
        }
    }

    public abstract /* synthetic */ void onBackFullscreen();

    public abstract /* synthetic */ void onBufferingUpdate(int i3);

    public void onCompletion() {
        setStateAndUi(0);
        this.mSaveChangeViewTIme = 0L;
        this.mCurrentPosition = 0L;
        if (this.mTextureViewContainer.getChildCount() > 0) {
            this.mTextureViewContainer.removeAllViews();
        }
        if (!this.mIfCurrentIsFullscreen) {
            getGSYVideoManager().setListener(null);
            getGSYVideoManager().setLastListener(null);
        }
        getGSYVideoManager().setCurrentVideoHeight(0);
        getGSYVideoManager().setCurrentVideoWidth(0);
        this.mAudioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
        Context context = this.mContext;
        if (context instanceof Activity) {
            try {
                ((Activity) context).getWindow().clearFlags(128);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        releaseNetWorkState();
    }

    public void onError(int i3, int i5) {
        if (this.mNetChanged) {
            this.mNetChanged = false;
            netWorkErrorLogic();
            g gVar = this.mVideoAllCallBack;
            if (gVar != null) {
                gVar.getClass();
            }
        } else if (i3 != 38 && i3 != -38) {
            setStateAndUi(7);
            deleteCacheFileWhenError();
            g gVar2 = this.mVideoAllCallBack;
            if (gVar2 != null) {
                gVar2.getClass();
            }
        }
    }

    public void onGankAudio() {
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [s3.c, android.view.View] */
    public void onInfo(int i3, int i5) {
        int i6;
        if (i3 == 701) {
            int i7 = this.mCurrentState;
            this.mBackUpPlayingBufferState = i7;
            if (this.mHadPlay && i7 != 1 && i7 > 0) {
                setStateAndUi(3);
            }
        } else if (i3 == 702) {
            int i8 = this.mBackUpPlayingBufferState;
            if (i8 != -1) {
                if (i8 == 3) {
                    this.mBackUpPlayingBufferState = 2;
                }
                if (this.mHadPlay && (i6 = this.mCurrentState) != 1 && i6 > 0) {
                    setStateAndUi(this.mBackUpPlayingBufferState);
                }
                this.mBackUpPlayingBufferState = -1;
            }
        } else if (i3 == getGSYVideoManager().getRotateInfoFlag()) {
            this.mRotate = i5;
            Debuger.printfLog("Video Rotate Info " + i5);
            p3.a aVar = this.mTextureView;
            if (aVar != null) {
                float f4 = this.mRotate;
                ?? r42 = aVar.f3226a;
                if (r42 != 0) {
                    r42.getRenderView().setRotation(f4);
                }
            }
        }
    }

    public void onLossAudio() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoView gSYVideoView = GSYVideoView.this;
                if (gSYVideoView.mReleaseWhenLossAudio) {
                    gSYVideoView.releaseVideos();
                } else {
                    gSYVideoView.onVideoPause();
                }
            }
        });
    }

    public void onLossTransientAudio() {
        try {
            onVideoPause();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void onLossTransientCanDuck() {
    }

    public void onPrepared() {
        if (this.mCurrentState != 1) {
            return;
        }
        this.mHadPrepared = true;
        if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
            Debuger.printfLog("onPrepared");
            this.mVideoAllCallBack.c(this.mOriginUrl, this.mTitle, this);
            throw null;
        } else if (!this.mStartAfterPrepared) {
            setStateAndUi(5);
            onVideoPause();
        } else {
            startAfterPrepared();
        }
    }

    @Override // n3.a
    public void onSeekComplete() {
        Debuger.printfLog("onSeekComplete");
    }

    @Override // n3.a
    public void onVideoPause() {
        if (this.mCurrentState == 1) {
            this.mPauseBeforePrepared = true;
        }
        try {
            if (getGSYVideoManager() != null && getGSYVideoManager().isPlaying()) {
                setStateAndUi(5);
                this.mCurrentPosition = getGSYVideoManager().getCurrentPosition();
                if (getGSYVideoManager() != null) {
                    getGSYVideoManager().pause();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void onVideoReset() {
        setStateAndUi(0);
    }

    @Override // n3.a
    public void onVideoResume() {
        onVideoResume(true);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [s3.c, android.view.View] */
    @Override // n3.a
    public void onVideoSizeChanged() {
        p3.a aVar;
        ?? r02;
        int currentVideoWidth = getGSYVideoManager().getCurrentVideoWidth();
        int currentVideoHeight = getGSYVideoManager().getCurrentVideoHeight();
        if (currentVideoWidth != 0 && currentVideoHeight != 0 && (aVar = this.mTextureView) != null && (r02 = aVar.f3226a) != 0) {
            r02.getRenderView().requestLayout();
        }
    }

    public void prepareVideo() {
        startPrepare();
    }

    public void release() {
        this.mSaveChangeViewTIme = 0L;
        if (isCurrentMediaListener() && System.currentTimeMillis() - this.mSaveChangeViewTIme > 2000) {
            releaseVideos();
        }
    }

    public void releaseNetWorkState() {
        NetInfoModule netInfoModule = this.mNetInfoModule;
        if (netInfoModule != null) {
            netInfoModule.onHostPause();
            this.mNetInfoModule = null;
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYTextureRenderView
    public void releasePauseCover() {
        Bitmap bitmap;
        try {
            if (this.mCurrentState != 5 && (bitmap = this.mFullPauseBitmap) != null && !bitmap.isRecycled() && this.mShowPauseCover) {
                this.mFullPauseBitmap.recycle();
                this.mFullPauseBitmap = null;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYTextureRenderView
    public void releaseSurface(Surface surface) {
        getGSYVideoManager().releaseSurface(surface);
    }

    public abstract void releaseVideos();

    public void seekTo(long j2) {
        try {
            if (getGSYVideoManager() != null && j2 > 0) {
                getGSYVideoManager().seekTo(j2);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYTextureRenderView
    public void setDisplay(Surface surface) {
        getGSYVideoManager().setDisplay(surface);
    }

    public void setIfCurrentIsFullscreen(boolean z3) {
        this.mIfCurrentIsFullscreen = z3;
    }

    public void setLooping(boolean z3) {
        this.mLooping = z3;
    }

    public void setMapHeadData(Map<String, String> map) {
        if (map != null) {
            this.mMapHeadData = map;
        }
    }

    public void setOverrideExtension(String str) {
        this.mOverrideExtension = str;
    }

    public void setPlayPosition(int i3) {
        this.mPlayPosition = i3;
    }

    public void setPlayTag(String str) {
        this.mPlayTag = str;
    }

    public void setReleaseWhenLossAudio(boolean z3) {
        this.mReleaseWhenLossAudio = z3;
    }

    public void setSeekOnStart(long j2) {
        this.mSeekOnStart = j2;
    }

    public void setShowPauseCover(boolean z3) {
        this.mShowPauseCover = z3;
    }

    public void setSpeed(float f4) {
        setSpeed(f4, false);
    }

    public void setSpeedPlaying(float f4, boolean z3) {
        setSpeed(f4, z3);
        getGSYVideoManager().setSpeedPlaying(f4, z3);
    }

    public void setStartAfterPrepared(boolean z3) {
        this.mStartAfterPrepared = z3;
    }

    public abstract void setStateAndUi(int i3);

    public boolean setUp(String str, boolean z3, String str2) {
        return setUp(str, z3, null, str2);
    }

    public void setVideoAllCallBack(g gVar) {
        this.mVideoAllCallBack = gVar;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [s3.c, android.view.View] */
    /* JADX WARN: Type inference failed for: r3v1, types: [s3.c, android.view.View] */
    /* JADX WARN: Type inference failed for: r4v2, types: [s3.c, android.view.View] */
    /* JADX WARN: Type inference failed for: r5v1, types: [s3.c, android.view.View] */
    @Override // com.shuyu.gsyvideoplayer.video.base.GSYTextureRenderView
    public void showPauseCover() {
        Bitmap bitmap;
        Surface surface;
        int i3;
        int i5;
        int i6;
        int i7;
        if (this.mCurrentState == 5 && (bitmap = this.mFullPauseBitmap) != null && !bitmap.isRecycled() && this.mShowPauseCover && (surface = this.mSurface) != null && surface.isValid() && getGSYVideoManager().isSurfaceSupportLockCanvas()) {
            try {
                ?? r12 = this.mTextureView.f3226a;
                if (r12 != 0) {
                    i3 = r12.getRenderView().getWidth();
                } else {
                    i3 = 0;
                }
                float f4 = i3;
                ?? r32 = this.mTextureView.f3226a;
                if (r32 != 0) {
                    i5 = r32.getRenderView().getHeight();
                } else {
                    i5 = 0;
                }
                RectF rectF = new RectF(0.0f, 0.0f, f4, i5);
                Surface surface2 = this.mSurface;
                ?? r42 = this.mTextureView.f3226a;
                if (r42 != 0) {
                    i6 = r42.getRenderView().getWidth();
                } else {
                    i6 = 0;
                }
                ?? r5 = this.mTextureView.f3226a;
                if (r5 != 0) {
                    i7 = r5.getRenderView().getHeight();
                } else {
                    i7 = 0;
                }
                Canvas lockCanvas = surface2.lockCanvas(new Rect(0, 0, i6, i7));
                if (lockCanvas != null) {
                    lockCanvas.drawBitmap(this.mFullPauseBitmap, (Rect) null, rectF, (Paint) null);
                    this.mSurface.unlockCanvasAndPost(lockCanvas);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [s3.c, android.view.View] */
    public void startAfterPrepared() {
        ?? r02;
        if (!this.mHadPrepared) {
            prepareVideo();
        }
        try {
            if (getGSYVideoManager() != null) {
                getGSYVideoManager().start();
            }
            setStateAndUi(2);
            if (getGSYVideoManager() != null && this.mSeekOnStart > 0) {
                getGSYVideoManager().seekTo(this.mSeekOnStart);
                this.mSeekOnStart = 0L;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        addTextureView();
        createNetWorkState();
        listenerNetWorkState();
        this.mHadPlay = true;
        p3.a aVar = this.mTextureView;
        if (aVar != null && (r02 = aVar.f3226a) != 0) {
            r02.d();
        }
        if (this.mPauseBeforePrepared) {
            onVideoPause();
            this.mPauseBeforePrepared = false;
        }
    }

    public void startButtonLogic() {
        g gVar = this.mVideoAllCallBack;
        if (gVar != null && this.mCurrentState == 0) {
            Debuger.printfLog("onClickStartIcon");
            this.mVideoAllCallBack.getClass();
        } else if (gVar != null) {
            Debuger.printfLog("onClickStartError");
            this.mVideoAllCallBack.getClass();
        }
        prepareVideo();
    }

    public abstract void startPlayLogic();

    public void startPrepare() {
        if (getGSYVideoManager().listener() != null) {
            getGSYVideoManager().listener().onCompletion();
        }
        if (this.mVideoAllCallBack != null) {
            Debuger.printfLog("onStartPrepared");
            this.mVideoAllCallBack.getClass();
        }
        getGSYVideoManager().setListener(this);
        getGSYVideoManager().setPlayTag(this.mPlayTag);
        getGSYVideoManager().setPlayPosition(this.mPlayPosition);
        this.mAudioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 2);
        try {
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).getWindow().addFlags(128);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        this.mBackUpPlayingBufferState = -1;
        GSYVideoViewBridge gSYVideoManager = getGSYVideoManager();
        String str = this.mUrl;
        Map<String, String> map = this.mMapHeadData;
        if (map == null) {
            map = new HashMap<>();
        }
        gSYVideoManager.prepare(str, map, this.mLooping, this.mSpeed, this.mCache, this.mCachePath, this.mOverrideExtension);
        setStateAndUi(1);
    }

    public void unListenerNetWorkState() {
        NetInfoModule netInfoModule = this.mNetInfoModule;
        if (netInfoModule != null) {
            netInfoModule.onHostPause();
        }
    }

    public void updatePauseCover() {
        Bitmap bitmap = this.mFullPauseBitmap;
        if ((bitmap == null || bitmap.isRecycled()) && this.mShowPauseCover) {
            try {
                initCover();
            } catch (Exception e5) {
                e5.printStackTrace();
                this.mFullPauseBitmap = null;
            }
        }
    }

    public void onVideoResume(boolean z3) {
        this.mPauseBeforePrepared = false;
        if (this.mCurrentState == 5) {
            try {
                if (this.mCurrentPosition < 0 || getGSYVideoManager() == null) {
                    return;
                }
                if (z3) {
                    getGSYVideoManager().seekTo(this.mCurrentPosition);
                }
                getGSYVideoManager().start();
                setStateAndUi(2);
                AudioManager audioManager = this.mAudioManager;
                if (audioManager != null && !this.mReleaseWhenLossAudio) {
                    audioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 2);
                }
                this.mCurrentPosition = 0L;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void setSpeed(float f4, boolean z3) {
        this.mSpeed = f4;
        this.mSoundTouch = z3;
        if (getGSYVideoManager() != null) {
            getGSYVideoManager().setSpeed(f4, z3);
        }
    }

    public boolean setUp(String str, boolean z3, File file, Map<String, String> map, String str2) {
        if (setUp(str, z3, file, str2)) {
            Map<String, String> map2 = this.mMapHeadData;
            if (map2 != null) {
                map2.clear();
            } else {
                this.mMapHeadData = new HashMap();
            }
            if (map != null) {
                this.mMapHeadData.putAll(map);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean setUp(String str, boolean z3, File file, String str2) {
        return setUp(str, z3, file, str2, true);
    }

    public boolean setUp(String str, boolean z3, File file, String str2, boolean z5) {
        this.mCache = z3;
        this.mCachePath = file;
        this.mOriginUrl = str;
        if (!isCurrentMediaListener() || System.currentTimeMillis() - this.mSaveChangeViewTIme >= 2000) {
            this.mCurrentState = 0;
            this.mUrl = str;
            this.mTitle = str2;
            if (z5) {
                setStateAndUi(0);
                return true;
            }
            return true;
        }
        return false;
    }

    public GSYVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = -1;
        this.mPlayPosition = -22;
        this.mBackUpPlayingBufferState = -1;
        this.mSeekOnStart = -1L;
        this.mSaveChangeViewTIme = 0L;
        this.mSpeed = 1.0f;
        this.mCache = false;
        this.mIfCurrentIsFullscreen = false;
        this.mLooping = false;
        this.mHadPlay = false;
        this.mNetChanged = false;
        this.mSoundTouch = false;
        this.mShowPauseCover = false;
        this.mPauseBeforePrepared = false;
        this.mStartAfterPrepared = true;
        this.mHadPrepared = false;
        this.mReleaseWhenLossAudio = true;
        this.mPlayTag = "";
        this.mNetSate = "NORMAL";
        this.mMapHeadData = new HashMap();
        this.onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoView.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i3) {
                if (i3 != -3) {
                    if (i3 != -2) {
                        if (i3 != -1) {
                            if (i3 == 1) {
                                GSYVideoView.this.onGankAudio();
                                return;
                            }
                            return;
                        }
                        GSYVideoView.this.onLossAudio();
                        return;
                    }
                    GSYVideoView.this.onLossTransientAudio();
                    return;
                }
                GSYVideoView.this.onLossTransientCanDuck();
            }
        };
        init(context);
    }

    public GSYVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        this.mCurrentState = -1;
        this.mPlayPosition = -22;
        this.mBackUpPlayingBufferState = -1;
        this.mSeekOnStart = -1L;
        this.mSaveChangeViewTIme = 0L;
        this.mSpeed = 1.0f;
        this.mCache = false;
        this.mIfCurrentIsFullscreen = false;
        this.mLooping = false;
        this.mHadPlay = false;
        this.mNetChanged = false;
        this.mSoundTouch = false;
        this.mShowPauseCover = false;
        this.mPauseBeforePrepared = false;
        this.mStartAfterPrepared = true;
        this.mHadPrepared = false;
        this.mReleaseWhenLossAudio = true;
        this.mPlayTag = "";
        this.mNetSate = "NORMAL";
        this.mMapHeadData = new HashMap();
        this.onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoView.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i32) {
                if (i32 != -3) {
                    if (i32 != -2) {
                        if (i32 != -1) {
                            if (i32 == 1) {
                                GSYVideoView.this.onGankAudio();
                                return;
                            }
                            return;
                        }
                        GSYVideoView.this.onLossAudio();
                        return;
                    }
                    GSYVideoView.this.onLossTransientAudio();
                    return;
                }
                GSYVideoView.this.onLossTransientCanDuck();
            }
        };
        init(context);
    }

    public GSYVideoView(Context context, Boolean bool) {
        super(context);
        this.mCurrentState = -1;
        this.mPlayPosition = -22;
        this.mBackUpPlayingBufferState = -1;
        this.mSeekOnStart = -1L;
        this.mSaveChangeViewTIme = 0L;
        this.mSpeed = 1.0f;
        this.mCache = false;
        this.mIfCurrentIsFullscreen = false;
        this.mLooping = false;
        this.mHadPlay = false;
        this.mNetChanged = false;
        this.mSoundTouch = false;
        this.mShowPauseCover = false;
        this.mPauseBeforePrepared = false;
        this.mStartAfterPrepared = true;
        this.mHadPrepared = false;
        this.mReleaseWhenLossAudio = true;
        this.mPlayTag = "";
        this.mNetSate = "NORMAL";
        this.mMapHeadData = new HashMap();
        this.onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoView.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i32) {
                if (i32 != -3) {
                    if (i32 != -2) {
                        if (i32 != -1) {
                            if (i32 == 1) {
                                GSYVideoView.this.onGankAudio();
                                return;
                            }
                            return;
                        }
                        GSYVideoView.this.onLossAudio();
                        return;
                    }
                    GSYVideoView.this.onLossTransientAudio();
                    return;
                }
                GSYVideoView.this.onLossTransientCanDuck();
            }
        };
        this.mIfCurrentIsFullscreen = bool.booleanValue();
        init(context);
    }
}

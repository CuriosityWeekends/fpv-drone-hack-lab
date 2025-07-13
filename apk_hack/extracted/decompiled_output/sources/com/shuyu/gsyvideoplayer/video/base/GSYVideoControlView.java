package com.shuyu.gsyvideoplayer.video.base;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import java.io.File;
import java.util.Map;
import l3.g;
import l3.h;
import l3.j;
import n3.c;
import n3.f;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class GSYVideoControlView extends GSYVideoView implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    Runnable dismissControlTask;
    protected GestureDetector gestureDetector;
    protected boolean isShowDragProgressTextOnSeekBar;
    protected ImageView mBackButton;
    protected ViewGroup mBottomContainer;
    protected ProgressBar mBottomProgressBar;
    protected boolean mBrightness;
    protected float mBrightnessData;
    protected boolean mChangePosition;
    protected boolean mChangeVolume;
    protected TextView mCurrentTimeTextView;
    protected int mDismissControlTime;
    protected int mDownPosition;
    protected float mDownX;
    protected float mDownY;
    protected int mEnlargeImageRes;
    protected boolean mFirstTouch;
    protected ImageView mFullscreenButton;
    protected c mGSYVideoProgressListener;
    protected int mGestureDownVolume;
    protected boolean mHadSeekTouch;
    protected boolean mHideKey;
    protected boolean mIsTouchWiget;
    protected boolean mIsTouchWigetFull;
    protected View mLoadingProgressBar;
    protected f mLockClickListener;
    protected boolean mLockCurScreen;
    protected ImageView mLockScreen;
    protected float mMoveY;
    protected boolean mNeedLockFull;
    protected boolean mNeedShowWifiTip;
    protected boolean mPostDismiss;
    protected boolean mPostProgress;
    protected SeekBar mProgressBar;
    protected int mSeekEndOffset;
    protected float mSeekRatio;
    protected int mSeekTimePosition;
    protected boolean mSetUpLazy;
    protected boolean mShowVKey;
    protected int mShrinkImageRes;
    protected View mStartButton;
    protected int mThreshold;
    protected View mThumbImageView;
    protected RelativeLayout mThumbImageViewLayout;
    protected boolean mThumbPlay;
    protected TextView mTitleTextView;
    protected ViewGroup mTopContainer;
    protected TextView mTotalTimeTextView;
    protected boolean mTouchingProgressBar;
    Runnable progressTask;

    public GSYVideoControlView(@NonNull Context context) {
        super(context);
        this.mThreshold = 80;
        this.mShrinkImageRes = -1;
        this.mEnlargeImageRes = -1;
        this.mDismissControlTime = 2500;
        this.mBrightnessData = -1.0f;
        this.mSeekRatio = 1.0f;
        this.mTouchingProgressBar = false;
        this.mChangeVolume = false;
        this.mChangePosition = false;
        this.mShowVKey = false;
        this.mBrightness = false;
        this.mFirstTouch = false;
        this.mHideKey = true;
        this.mNeedShowWifiTip = true;
        this.mIsTouchWiget = true;
        this.mIsTouchWigetFull = true;
        this.mSetUpLazy = false;
        this.mHadSeekTouch = false;
        this.mPostProgress = false;
        this.mPostDismiss = false;
        this.isShowDragProgressTextOnSeekBar = false;
        this.gestureDetector = new GestureDetector(getContext().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                GSYVideoControlView.this.touchDoubleUp();
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                if (!gSYVideoControlView.mChangePosition && !gSYVideoControlView.mChangeVolume && !gSYVideoControlView.mBrightness) {
                    gSYVideoControlView.onClickUiToggle();
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.progressTask = new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.4
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                int i3 = gSYVideoControlView.mCurrentState;
                if (i3 == 2 || i3 == 5) {
                    gSYVideoControlView.setTextAndProgress(0);
                }
                GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                if (gSYVideoControlView2.mPostProgress) {
                    gSYVideoControlView2.postDelayed(this, 1000L);
                }
            }
        };
        this.dismissControlTask = new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.5
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                int i3 = gSYVideoControlView.mCurrentState;
                if (i3 != 0 && i3 != 7 && i3 != 6) {
                    if (gSYVideoControlView.getActivityContext() != null) {
                        GSYVideoControlView.this.hideAllWidget();
                        GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                        gSYVideoControlView2.setViewShowState(gSYVideoControlView2.mLockScreen, 8);
                        GSYVideoControlView gSYVideoControlView3 = GSYVideoControlView.this;
                        if (gSYVideoControlView3.mHideKey && gSYVideoControlView3.mIfCurrentIsFullscreen && gSYVideoControlView3.mShowVKey) {
                            CommonUtil.hideNavKey(gSYVideoControlView3.mContext);
                        }
                    }
                    GSYVideoControlView gSYVideoControlView4 = GSYVideoControlView.this;
                    if (gSYVideoControlView4.mPostDismiss) {
                        gSYVideoControlView4.postDelayed(this, gSYVideoControlView4.mDismissControlTime);
                    }
                }
            }
        };
    }

    public void cancelDismissControlViewTimer() {
        this.mPostDismiss = false;
        removeCallbacks(this.dismissControlTask);
    }

    public void cancelProgressTimer() {
        this.mPostProgress = false;
        removeCallbacks(this.progressTask);
    }

    public abstract void changeUiToCompleteShow();

    public abstract void changeUiToError();

    public abstract void changeUiToNormal();

    public abstract void changeUiToPauseShow();

    public abstract void changeUiToPlayingBufferingShow();

    public abstract void changeUiToPlayingShow();

    public abstract void changeUiToPreparingShow();

    public void clearThumbImageView() {
        RelativeLayout relativeLayout = this.mThumbImageViewLayout;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    public void clickStartIcon() {
        if (TextUtils.isEmpty(this.mUrl)) {
            Debuger.printfError("********" + getResources().getString(j.no_url));
            return;
        }
        int i3 = this.mCurrentState;
        if (i3 != 0 && i3 != 7) {
            if (i3 == 2) {
                try {
                    onVideoPause();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                setStateAndUi(5);
                if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                    if (this.mIfCurrentIsFullscreen) {
                        Debuger.printfLog("onClickStopFullscreen");
                        this.mVideoAllCallBack.getClass();
                        return;
                    }
                    Debuger.printfLog("onClickStop");
                    this.mVideoAllCallBack.getClass();
                }
            } else if (i3 == 5) {
                if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                    if (this.mIfCurrentIsFullscreen) {
                        Debuger.printfLog("onClickResumeFullscreen");
                        this.mVideoAllCallBack.getClass();
                    } else {
                        Debuger.printfLog("onClickResume");
                        this.mVideoAllCallBack.getClass();
                    }
                }
                if (!this.mHadPlay && !this.mStartAfterPrepared) {
                    startAfterPrepared();
                }
                try {
                    getGSYVideoManager().start();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                setStateAndUi(2);
            } else if (i3 == 6) {
                startButtonLogic();
            }
        } else if (isShowNetConfirm()) {
            showWifiDialog();
        } else {
            startButtonLogic();
        }
    }

    public abstract void dismissBrightnessDialog();

    public abstract void dismissProgressDialog();

    public abstract void dismissVolumeDialog();

    public ImageView getBackButton() {
        return this.mBackButton;
    }

    public int getDismissControlTime() {
        return this.mDismissControlTime;
    }

    public int getEnlargeImageRes() {
        int i3 = this.mEnlargeImageRes;
        if (i3 == -1) {
            return g.video_enlarge;
        }
        return i3;
    }

    public ImageView getFullscreenButton() {
        return this.mFullscreenButton;
    }

    public float getSeekRatio() {
        return this.mSeekRatio;
    }

    public int getShrinkImageRes() {
        int i3 = this.mShrinkImageRes;
        if (i3 == -1) {
            return g.video_shrink;
        }
        return i3;
    }

    public View getStartButton() {
        return this.mStartButton;
    }

    public View getThumbImageView() {
        return this.mThumbImageView;
    }

    public RelativeLayout getThumbImageViewLayout() {
        return this.mThumbImageViewLayout;
    }

    public TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    public abstract void hideAllWidget();

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void init(Context context) {
        RelativeLayout relativeLayout;
        super.init(context);
        this.mStartButton = findViewById(h.start);
        this.mTitleTextView = (TextView) findViewById(h.title);
        this.mBackButton = (ImageView) findViewById(h.back);
        this.mFullscreenButton = (ImageView) findViewById(h.fullscreen);
        this.mProgressBar = (SeekBar) findViewById(h.progress);
        this.mCurrentTimeTextView = (TextView) findViewById(h.current);
        this.mTotalTimeTextView = (TextView) findViewById(h.total);
        this.mBottomContainer = (ViewGroup) findViewById(h.layout_bottom);
        this.mTopContainer = (ViewGroup) findViewById(h.layout_top);
        this.mBottomProgressBar = (ProgressBar) findViewById(h.bottom_progressbar);
        this.mThumbImageViewLayout = (RelativeLayout) findViewById(h.thumb);
        this.mLockScreen = (ImageView) findViewById(h.lock_screen);
        this.mLoadingProgressBar = findViewById(h.loading);
        if (isInEditMode()) {
            return;
        }
        View view = this.mStartButton;
        if (view != null) {
            view.setOnClickListener(this);
        }
        ImageView imageView = this.mFullscreenButton;
        if (imageView != null) {
            imageView.setOnClickListener(this);
            this.mFullscreenButton.setOnTouchListener(this);
        }
        SeekBar seekBar = this.mProgressBar;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(this);
        }
        ViewGroup viewGroup = this.mBottomContainer;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
        }
        ViewGroup viewGroup2 = this.mTextureViewContainer;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.mTextureViewContainer.setOnTouchListener(this);
        }
        SeekBar seekBar2 = this.mProgressBar;
        if (seekBar2 != null) {
            seekBar2.setOnTouchListener(this);
        }
        RelativeLayout relativeLayout2 = this.mThumbImageViewLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
            this.mThumbImageViewLayout.setOnClickListener(this);
        }
        if (this.mThumbImageView != null && !this.mIfCurrentIsFullscreen && (relativeLayout = this.mThumbImageViewLayout) != null) {
            relativeLayout.removeAllViews();
            resolveThumbImage(this.mThumbImageView);
        }
        ImageView imageView2 = this.mBackButton;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        ImageView imageView3 = this.mLockScreen;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
            this.mLockScreen.setOnClickListener(new View.OnClickListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                    int i3 = gSYVideoControlView.mCurrentState;
                    if (i3 != 6 && i3 != 7) {
                        gSYVideoControlView.lockTouchLogic();
                        GSYVideoControlView.this.getClass();
                    }
                }
            });
        }
        if (getActivityContext() != null) {
            this.mSeekEndOffset = CommonUtil.dip2px(getActivityContext(), 50.0f);
        }
    }

    public void initUIState() {
        setStateAndUi(0);
    }

    public boolean isHideKey() {
        return this.mHideKey;
    }

    public boolean isNeedLockFull() {
        return this.mNeedLockFull;
    }

    public boolean isNeedShowWifiTip() {
        return this.mNeedShowWifiTip;
    }

    public boolean isShowDragProgressTextOnSeekBar() {
        return this.isShowDragProgressTextOnSeekBar;
    }

    public boolean isShowNetConfirm() {
        if (!this.mOriginUrl.startsWith("file") && !this.mOriginUrl.startsWith("android.resource") && !CommonUtil.isWifiConnected(getContext()) && this.mNeedShowWifiTip && !getGSYVideoManager().cachePreview(this.mContext.getApplicationContext(), this.mCachePath, this.mOriginUrl)) {
            return true;
        }
        return false;
    }

    public boolean isTouchWiget() {
        return this.mIsTouchWiget;
    }

    public boolean isTouchWigetFull() {
        return this.mIsTouchWigetFull;
    }

    public void lockTouchLogic() {
        if (this.mLockCurScreen) {
            this.mLockScreen.setImageResource(g.unlock);
            this.mLockCurScreen = false;
            return;
        }
        this.mLockScreen.setImageResource(g.lock);
        this.mLockCurScreen = true;
        hideAllWidget();
    }

    public void loopSetProgressAndTime() {
        SeekBar seekBar = this.mProgressBar;
        if (seekBar != null && this.mTotalTimeTextView != null && this.mCurrentTimeTextView != null) {
            seekBar.setProgress(0);
            this.mProgressBar.setSecondaryProgress(0);
            this.mCurrentTimeTextView.setText(CommonUtil.stringForTime(0));
            ProgressBar progressBar = this.mBottomProgressBar;
            if (progressBar != null) {
                progressBar.setProgress(0);
            }
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public void onAutoCompletion() {
        super.onAutoCompletion();
        if (this.mLockCurScreen) {
            lockTouchLogic();
            this.mLockScreen.setVisibility(8);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public abstract /* synthetic */ void onBackFullscreen();

    public void onBrightnessSlide(float f4) {
        float f5 = ((Activity) this.mContext).getWindow().getAttributes().screenBrightness;
        this.mBrightnessData = f5;
        if (f5 <= 0.0f) {
            this.mBrightnessData = 0.5f;
        } else if (f5 < 0.01f) {
            this.mBrightnessData = 0.01f;
        }
        WindowManager.LayoutParams attributes = ((Activity) this.mContext).getWindow().getAttributes();
        float f6 = this.mBrightnessData + f4;
        attributes.screenBrightness = f6;
        if (f6 > 1.0f) {
            attributes.screenBrightness = 1.0f;
        } else if (f6 < 0.01f) {
            attributes.screenBrightness = 0.01f;
        }
        showBrightnessDialog(attributes.screenBrightness);
        ((Activity) this.mContext).getWindow().setAttributes(attributes);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public void onBufferingUpdate(final int i3) {
        post(new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.3
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                int i5 = gSYVideoControlView.mCurrentState;
                if (i5 != 0 && i5 != 1) {
                    int i6 = i3;
                    if (i6 != 0) {
                        gSYVideoControlView.setTextAndProgress(i6);
                        GSYVideoControlView.this.mBufferPoint = i3;
                        Debuger.printfLog("Net speed: " + GSYVideoControlView.this.getNetSpeedText() + " percent " + i3);
                    }
                    GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                    SeekBar seekBar = gSYVideoControlView2.mProgressBar;
                    if (seekBar != null && gSYVideoControlView2.mLooping && gSYVideoControlView2.mHadPlay && i3 == 0 && seekBar.getProgress() >= GSYVideoControlView.this.mProgressBar.getMax() - 1) {
                        GSYVideoControlView.this.loopSetProgressAndTime();
                    }
                }
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();
        if (this.mHideKey && this.mIfCurrentIsFullscreen) {
            CommonUtil.hideNavKey(this.mContext);
        }
        if (id == h.start) {
            clickStartIcon();
            return;
        }
        int i3 = h.surface_container;
        if (id == i3 && this.mCurrentState == 7) {
            if (this.mVideoAllCallBack != null) {
                Debuger.printfLog("onClickStartError");
                this.mVideoAllCallBack.getClass();
            }
            prepareVideo();
        } else if (id == h.thumb) {
            if (!this.mThumbPlay) {
                return;
            }
            if (TextUtils.isEmpty(this.mUrl)) {
                Debuger.printfError("********" + getResources().getString(j.no_url));
                return;
            }
            int i5 = this.mCurrentState;
            if (i5 == 0) {
                if (isShowNetConfirm()) {
                    showWifiDialog();
                } else {
                    startPlayLogic();
                }
            } else if (i5 == 6) {
                onClickUiToggle();
            }
        } else if (id == i3) {
            if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                if (this.mIfCurrentIsFullscreen) {
                    Debuger.printfLog("onClickBlankFullscreen");
                    this.mVideoAllCallBack.getClass();
                } else {
                    Debuger.printfLog("onClickBlank");
                    this.mVideoAllCallBack.getClass();
                }
            }
            startDismissControlViewTimer();
        }
    }

    public abstract void onClickUiToggle();

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Debuger.printfLog(hashCode() + "------------------------------ dismiss onDetachedFromWindow");
        cancelProgressTimer();
        cancelDismissControlViewTimer();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public void onError(int i3, int i5) {
        super.onError(i3, i5);
        if (this.mLockCurScreen) {
            lockTouchLogic();
            this.mLockScreen.setVisibility(8);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public void onPrepared() {
        setTextAndProgress(0, true);
        super.onPrepared();
        if (this.mCurrentState != 1) {
            return;
        }
        startProgressTimer();
        Debuger.printfLog(hashCode() + "------------------------------ surface_container onPrepared");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z3) {
        showDragProgressTextOnSeekBar(z3, i3);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.mHadSeekTouch = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
            if (isIfCurrentIsFullscreen()) {
                Debuger.printfLog("onClickSeekbarFullscreen");
                this.mVideoAllCallBack.getClass();
            } else {
                Debuger.printfLog("onClickSeekbar");
                this.mVideoAllCallBack.getClass();
            }
        }
        if (getGSYVideoManager() != null && this.mHadPlay) {
            try {
                getGSYVideoManager().seekTo((seekBar.getProgress() * getDuration()) / 100);
            } catch (Exception e5) {
                Debuger.printfWarning(e5.toString());
            }
        }
        this.mHadSeekTouch = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
        if (r8 != 2) goto L35;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            int r8 = r8.getId()
            float r0 = r9.getX()
            float r1 = r9.getY()
            boolean r2 = r7.mIfCurrentIsFullscreen
            r3 = 1
            if (r2 == 0) goto L20
            boolean r2 = r7.mLockCurScreen
            if (r2 == 0) goto L20
            boolean r2 = r7.mNeedLockFull
            if (r2 == 0) goto L20
            r7.onClickUiToggle()
            r7.startDismissControlViewTimer()
            return r3
        L20:
            int r2 = l3.h.fullscreen
            r4 = 0
            if (r8 != r2) goto L26
            return r4
        L26:
            int r2 = l3.h.surface_container
            r5 = 2
            if (r8 != r2) goto L99
            int r8 = r9.getAction()
            if (r8 == 0) goto L90
            if (r8 == r3) goto L66
            if (r8 == r5) goto L36
            goto L93
        L36:
            float r8 = r7.mDownX
            float r0 = r0 - r8
            float r8 = r7.mDownY
            float r8 = r1 - r8
            float r2 = java.lang.Math.abs(r0)
            float r3 = java.lang.Math.abs(r8)
            boolean r5 = r7.mIfCurrentIsFullscreen
            if (r5 == 0) goto L4d
            boolean r6 = r7.mIsTouchWigetFull
            if (r6 != 0) goto L53
        L4d:
            boolean r6 = r7.mIsTouchWiget
            if (r6 == 0) goto L62
            if (r5 != 0) goto L62
        L53:
            boolean r5 = r7.mChangePosition
            if (r5 != 0) goto L62
            boolean r5 = r7.mChangeVolume
            if (r5 != 0) goto L62
            boolean r5 = r7.mBrightness
            if (r5 != 0) goto L62
            r7.touchSurfaceMoveFullLogic(r2, r3)
        L62:
            r7.touchSurfaceMove(r0, r8, r1)
            goto L93
        L66:
            r7.startDismissControlViewTimer()
            r7.touchSurfaceUp()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r0 = r7.hashCode()
            r8.append(r0)
            java.lang.String r0 = "------------------------------ surface_container ACTION_UP"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.shuyu.gsyvideoplayer.utils.Debuger.printfLog(r8)
            r7.startProgressTimer()
            boolean r8 = r7.mHideKey
            if (r8 == 0) goto L93
            boolean r8 = r7.mShowVKey
            if (r8 == 0) goto L93
            return r3
        L90:
            r7.touchSurfaceDown(r0, r1)
        L93:
            android.view.GestureDetector r8 = r7.gestureDetector
            r8.onTouchEvent(r9)
            goto Led
        L99:
            int r0 = l3.h.progress
            if (r8 != r0) goto Led
            int r8 = r9.getAction()
            if (r8 == 0) goto Ld9
            if (r8 == r3) goto La8
            if (r8 == r5) goto Ldc
            goto Led
        La8:
            r7.startDismissControlViewTimer()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = r7.hashCode()
            r8.append(r9)
            java.lang.String r9 = "------------------------------ progress ACTION_UP"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.shuyu.gsyvideoplayer.utils.Debuger.printfLog(r8)
            r7.startProgressTimer()
            android.view.ViewParent r8 = r7.getParent()
        Lca:
            if (r8 == 0) goto Ld4
            r8.requestDisallowInterceptTouchEvent(r4)
            android.view.ViewParent r8 = r8.getParent()
            goto Lca
        Ld4:
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7.mBrightnessData = r8
            goto Led
        Ld9:
            r7.cancelDismissControlViewTimer()
        Ldc:
            r7.cancelProgressTimer()
            android.view.ViewParent r8 = r7.getParent()
        Le3:
            if (r8 == 0) goto Led
            r8.requestDisallowInterceptTouchEvent(r3)
            android.view.ViewParent r8 = r8.getParent()
            goto Le3
        Led:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void prepareVideo() {
        if (this.mSetUpLazy) {
            super.setUp(this.mOriginUrl, this.mCache, this.mCachePath, this.mMapHeadData, this.mTitle);
        }
        super.prepareVideo();
    }

    public void resetProgressAndTime() {
        SeekBar seekBar = this.mProgressBar;
        if (seekBar != null && this.mTotalTimeTextView != null && this.mCurrentTimeTextView != null) {
            seekBar.setProgress(0);
            this.mProgressBar.setSecondaryProgress(0);
            this.mCurrentTimeTextView.setText(CommonUtil.stringForTime(0));
            this.mTotalTimeTextView.setText(CommonUtil.stringForTime(0));
            ProgressBar progressBar = this.mBottomProgressBar;
            if (progressBar != null) {
                progressBar.setProgress(0);
                this.mBottomProgressBar.setSecondaryProgress(0);
            }
        }
    }

    public void resolveThumbImage(View view) {
        RelativeLayout relativeLayout = this.mThumbImageViewLayout;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.mThumbImageViewLayout.addView(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
        }
    }

    public void resolveUIState(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 7) {
                                    changeUiToError();
                                    return;
                                }
                                return;
                            }
                            changeUiToCompleteShow();
                            cancelDismissControlViewTimer();
                            return;
                        }
                        changeUiToPauseShow();
                        cancelDismissControlViewTimer();
                        return;
                    }
                    changeUiToPlayingBufferingShow();
                    return;
                }
                changeUiToPlayingShow();
                startDismissControlViewTimer();
                return;
            }
            changeUiToPreparingShow();
            startDismissControlViewTimer();
            return;
        }
        changeUiToNormal();
        cancelDismissControlViewTimer();
    }

    public void setDismissControlTime(int i3) {
        this.mDismissControlTime = i3;
    }

    public void setEnlargeImageRes(int i3) {
        this.mEnlargeImageRes = i3;
    }

    public void setHideKey(boolean z3) {
        this.mHideKey = z3;
    }

    public void setIsTouchWiget(boolean z3) {
        this.mIsTouchWiget = z3;
    }

    public void setIsTouchWigetFull(boolean z3) {
        this.mIsTouchWigetFull = z3;
    }

    public void setNeedLockFull(boolean z3) {
        this.mNeedLockFull = z3;
    }

    public void setNeedShowWifiTip(boolean z3) {
        this.mNeedShowWifiTip = z3;
    }

    public void setProgressAndTime(int i3, int i5, int i6, int i7, boolean z3) {
        SeekBar seekBar = this.mProgressBar;
        if (seekBar == null || this.mTotalTimeTextView == null || this.mCurrentTimeTextView == null || this.mHadSeekTouch) {
            return;
        }
        if (!this.mTouchingProgressBar && (i3 != 0 || z3)) {
            seekBar.setProgress(i3);
        }
        if (getGSYVideoManager().getBufferedPercentage() > 0) {
            i5 = getGSYVideoManager().getBufferedPercentage();
        }
        if (i5 > 94) {
            i5 = 100;
        }
        setSecondaryProgress(i5);
        this.mTotalTimeTextView.setText(CommonUtil.stringForTime(i7));
        if (i6 > 0) {
            this.mCurrentTimeTextView.setText(CommonUtil.stringForTime(i6));
        }
        ProgressBar progressBar = this.mBottomProgressBar;
        if (progressBar != null) {
            if (i3 != 0 || z3) {
                progressBar.setProgress(i3);
            }
            setSecondaryProgress(i5);
        }
    }

    public void setSecondaryProgress(int i3) {
        if (this.mProgressBar != null && i3 != 0 && !getGSYVideoManager().isCacheFile()) {
            this.mProgressBar.setSecondaryProgress(i3);
        }
        if (this.mBottomProgressBar != null && i3 != 0 && !getGSYVideoManager().isCacheFile()) {
            this.mBottomProgressBar.setSecondaryProgress(i3);
        }
    }

    public void setSeekRatio(float f4) {
        if (f4 < 0.0f) {
            return;
        }
        this.mSeekRatio = f4;
    }

    public void setShowDragProgressTextOnSeekBar(boolean z3) {
        this.isShowDragProgressTextOnSeekBar = z3;
    }

    public void setShrinkImageRes(int i3) {
        this.mShrinkImageRes = i3;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYTextureRenderView
    public void setSmallVideoTextureView(View.OnTouchListener onTouchListener) {
        super.setSmallVideoTextureView(onTouchListener);
        RelativeLayout relativeLayout = this.mThumbImageViewLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnTouchListener(onTouchListener);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void setStateAndUi(int i3) {
        TextView textView;
        this.mCurrentState = i3;
        if ((i3 == 0 && isCurrentMediaListener()) || i3 == 6 || i3 == 7) {
            this.mHadPrepared = false;
        }
        int i5 = this.mCurrentState;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 5) {
                        if (i5 != 6) {
                            if (i5 == 7 && isCurrentMediaListener()) {
                                getGSYVideoManager().releaseMediaPlayer();
                            }
                        } else {
                            Debuger.printfLog(hashCode() + "------------------------------ dismiss CURRENT_STATE_AUTO_COMPLETE");
                            cancelProgressTimer();
                            SeekBar seekBar = this.mProgressBar;
                            if (seekBar != null) {
                                seekBar.setProgress(100);
                            }
                            TextView textView2 = this.mCurrentTimeTextView;
                            if (textView2 != null && (textView = this.mTotalTimeTextView) != null) {
                                textView2.setText(textView.getText());
                            }
                            ProgressBar progressBar = this.mBottomProgressBar;
                            if (progressBar != null) {
                                progressBar.setProgress(100);
                            }
                        }
                    } else {
                        Debuger.printfLog(hashCode() + "------------------------------ CURRENT_STATE_PAUSE");
                        startProgressTimer();
                    }
                } else if (isCurrentMediaListener()) {
                    Debuger.printfLog(hashCode() + "------------------------------ CURRENT_STATE_PLAYING");
                    startProgressTimer();
                }
            } else {
                resetProgressAndTime();
            }
        } else {
            if (isCurrentMediaListener()) {
                Debuger.printfLog(hashCode() + "------------------------------ dismiss CURRENT_STATE_NORMAL");
                cancelProgressTimer();
                getGSYVideoManager().releaseMediaPlayer();
                releasePauseCover();
                this.mBufferPoint = 0;
                this.mSaveChangeViewTIme = 0L;
                AudioManager audioManager = this.mAudioManager;
                if (audioManager != null) {
                    audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
                }
            }
            releaseNetWorkState();
        }
        resolveUIState(i3);
    }

    public void setTextAndProgress(int i3) {
        setTextAndProgress(i3, false);
    }

    public void setThumbImageView(View view) {
        if (this.mThumbImageViewLayout != null) {
            this.mThumbImageView = view;
            resolveThumbImage(view);
        }
    }

    public void setThumbPlay(boolean z3) {
        this.mThumbPlay = z3;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public boolean setUp(String str, boolean z3, String str2) {
        return setUp(str, z3, null, str2);
    }

    public boolean setUpLazy(String str, boolean z3, File file, Map<String, String> map, String str2) {
        this.mOriginUrl = str;
        this.mCache = z3;
        this.mCachePath = file;
        this.mSetUpLazy = true;
        this.mTitle = str2;
        this.mMapHeadData = map;
        if (isCurrentMediaListener() && System.currentTimeMillis() - this.mSaveChangeViewTIme < 2000) {
            return false;
        }
        this.mUrl = "waiting";
        this.mCurrentState = 0;
        return true;
    }

    public void setViewShowState(View view, int i3) {
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public abstract void showBrightnessDialog(float f4);

    public void showDragProgressTextOnSeekBar(boolean z3, int i3) {
        if (z3 && this.isShowDragProgressTextOnSeekBar) {
            int duration = getDuration();
            TextView textView = this.mCurrentTimeTextView;
            if (textView != null) {
                textView.setText(CommonUtil.stringForTime((i3 * duration) / 100));
            }
        }
    }

    public abstract void showProgressDialog(float f4, String str, int i3, String str2, int i5);

    public abstract void showVolumeDialog(float f4, int i3);

    public abstract void showWifiDialog();

    public void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        this.mPostDismiss = true;
        postDelayed(this.dismissControlTask, this.mDismissControlTime);
    }

    public void startProgressTimer() {
        cancelProgressTimer();
        this.mPostProgress = true;
        postDelayed(this.progressTask, 300L);
    }

    public void touchDoubleUp() {
        if (!this.mHadPlay) {
            return;
        }
        clickStartIcon();
    }

    public void touchSurfaceDown(float f4, float f5) {
        this.mTouchingProgressBar = true;
        this.mDownX = f4;
        this.mDownY = f5;
        this.mMoveY = 0.0f;
        this.mChangeVolume = false;
        this.mChangePosition = false;
        this.mShowVKey = false;
        this.mBrightness = false;
        this.mFirstTouch = true;
    }

    public void touchSurfaceMove(float f4, float f5, float f6) {
        int i3;
        int i5;
        int streamMaxVolume;
        if (getActivityContext() != null) {
            if (CommonUtil.getCurrentScreenLand((Activity) getActivityContext())) {
                i3 = this.mScreenHeight;
            } else {
                i3 = this.mScreenWidth;
            }
            if (CommonUtil.getCurrentScreenLand((Activity) getActivityContext())) {
                i5 = this.mScreenWidth;
            } else {
                i5 = this.mScreenHeight;
            }
        } else {
            i3 = 0;
            i5 = 0;
        }
        if (this.mChangePosition) {
            int duration = getDuration();
            int i6 = (int) ((((duration * f4) / i3) / this.mSeekRatio) + this.mDownPosition);
            this.mSeekTimePosition = i6;
            if (i6 > duration) {
                this.mSeekTimePosition = duration;
            }
            showProgressDialog(f4, CommonUtil.stringForTime(this.mSeekTimePosition), this.mSeekTimePosition, CommonUtil.stringForTime(duration), duration);
        } else if (this.mChangeVolume) {
            float f7 = -f5;
            float f8 = i5;
            this.mAudioManager.setStreamVolume(3, this.mGestureDownVolume + ((int) (((this.mAudioManager.getStreamMaxVolume(3) * f7) * 3.0f) / f8)), 0);
            showVolumeDialog(-f7, (int) ((((3.0f * f7) * 100.0f) / f8) + ((this.mGestureDownVolume * 100) / streamMaxVolume)));
        } else if (this.mBrightness && Math.abs(f5) > this.mThreshold) {
            onBrightnessSlide((-f5) / i5);
            this.mDownY = f6;
        }
    }

    public void touchSurfaceMoveFullLogic(float f4, float f5) {
        int i3;
        boolean z3;
        boolean z5;
        if (getActivityContext() != null) {
            if (CommonUtil.getCurrentScreenLand((Activity) getActivityContext())) {
                i3 = this.mScreenHeight;
            } else {
                i3 = this.mScreenWidth;
            }
        } else {
            i3 = 0;
        }
        int i5 = this.mThreshold;
        if (f4 > i5 || f5 > i5) {
            cancelProgressTimer();
            if (f4 >= this.mThreshold) {
                if (Math.abs(CommonUtil.getScreenWidth(getContext()) - this.mDownX) > this.mSeekEndOffset) {
                    this.mChangePosition = true;
                    this.mDownPosition = getCurrentPositionWhenPlaying();
                    return;
                }
                this.mShowVKey = true;
                return;
            }
            if (Math.abs(CommonUtil.getScreenHeight(getContext()) - this.mDownY) > this.mSeekEndOffset) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.mFirstTouch) {
                if (this.mDownX < i3 * 0.5f && z3) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.mBrightness = z5;
                this.mFirstTouch = false;
            }
            if (!this.mBrightness) {
                this.mChangeVolume = z3;
                this.mGestureDownVolume = this.mAudioManager.getStreamVolume(3);
            }
            this.mShowVKey = !z3;
        }
    }

    public void touchSurfaceUp() {
        int i3;
        int i5 = 1;
        if (this.mChangePosition) {
            int duration = getDuration();
            int i6 = this.mSeekTimePosition * 100;
            if (duration == 0) {
                duration = 1;
            }
            int i7 = i6 / duration;
            ProgressBar progressBar = this.mBottomProgressBar;
            if (progressBar != null) {
                progressBar.setProgress(i7);
            }
        }
        this.mTouchingProgressBar = false;
        dismissProgressDialog();
        dismissVolumeDialog();
        dismissBrightnessDialog();
        if (this.mChangePosition && getGSYVideoManager() != null && ((i3 = this.mCurrentState) == 2 || i3 == 5)) {
            try {
                getGSYVideoManager().seekTo(this.mSeekTimePosition);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            int duration2 = getDuration();
            int i8 = this.mSeekTimePosition * 100;
            if (duration2 != 0) {
                i5 = duration2;
            }
            int i9 = i8 / i5;
            SeekBar seekBar = this.mProgressBar;
            if (seekBar != null) {
                seekBar.setProgress(i9);
            }
            if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                Debuger.printfLog("onTouchScreenSeekPosition");
                this.mVideoAllCallBack.getClass();
            }
        } else if (this.mBrightness) {
            if (this.mVideoAllCallBack != null && isCurrentMediaListener()) {
                Debuger.printfLog("onTouchScreenSeekLight");
                this.mVideoAllCallBack.getClass();
            }
        } else if (this.mChangeVolume && this.mVideoAllCallBack != null && isCurrentMediaListener()) {
            Debuger.printfLog("onTouchScreenSeekVolume");
            this.mVideoAllCallBack.getClass();
        }
    }

    public void setTextAndProgress(int i3, boolean z3) {
        int currentPositionWhenPlaying = getCurrentPositionWhenPlaying();
        int duration = getDuration();
        setProgressAndTime((currentPositionWhenPlaying * 100) / (duration == 0 ? 1 : duration), i3, currentPositionWhenPlaying, duration, z3);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public boolean setUp(String str, boolean z3, File file, String str2) {
        TextView textView;
        if (super.setUp(str, z3, file, str2)) {
            if (str2 != null && (textView = this.mTitleTextView) != null) {
                textView.setText(str2);
            }
            if (this.mIfCurrentIsFullscreen) {
                ImageView imageView = this.mFullscreenButton;
                if (imageView != null) {
                    imageView.setImageResource(getShrinkImageRes());
                    return true;
                }
                return true;
            }
            ImageView imageView2 = this.mFullscreenButton;
            if (imageView2 != null) {
                imageView2.setImageResource(getEnlargeImageRes());
                return true;
            }
            return true;
        }
        return false;
    }

    public GSYVideoControlView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mThreshold = 80;
        this.mShrinkImageRes = -1;
        this.mEnlargeImageRes = -1;
        this.mDismissControlTime = 2500;
        this.mBrightnessData = -1.0f;
        this.mSeekRatio = 1.0f;
        this.mTouchingProgressBar = false;
        this.mChangeVolume = false;
        this.mChangePosition = false;
        this.mShowVKey = false;
        this.mBrightness = false;
        this.mFirstTouch = false;
        this.mHideKey = true;
        this.mNeedShowWifiTip = true;
        this.mIsTouchWiget = true;
        this.mIsTouchWigetFull = true;
        this.mSetUpLazy = false;
        this.mHadSeekTouch = false;
        this.mPostProgress = false;
        this.mPostDismiss = false;
        this.isShowDragProgressTextOnSeekBar = false;
        this.gestureDetector = new GestureDetector(getContext().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                GSYVideoControlView.this.touchDoubleUp();
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                if (!gSYVideoControlView.mChangePosition && !gSYVideoControlView.mChangeVolume && !gSYVideoControlView.mBrightness) {
                    gSYVideoControlView.onClickUiToggle();
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.progressTask = new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.4
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                int i3 = gSYVideoControlView.mCurrentState;
                if (i3 == 2 || i3 == 5) {
                    gSYVideoControlView.setTextAndProgress(0);
                }
                GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                if (gSYVideoControlView2.mPostProgress) {
                    gSYVideoControlView2.postDelayed(this, 1000L);
                }
            }
        };
        this.dismissControlTask = new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.5
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                int i3 = gSYVideoControlView.mCurrentState;
                if (i3 != 0 && i3 != 7 && i3 != 6) {
                    if (gSYVideoControlView.getActivityContext() != null) {
                        GSYVideoControlView.this.hideAllWidget();
                        GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                        gSYVideoControlView2.setViewShowState(gSYVideoControlView2.mLockScreen, 8);
                        GSYVideoControlView gSYVideoControlView3 = GSYVideoControlView.this;
                        if (gSYVideoControlView3.mHideKey && gSYVideoControlView3.mIfCurrentIsFullscreen && gSYVideoControlView3.mShowVKey) {
                            CommonUtil.hideNavKey(gSYVideoControlView3.mContext);
                        }
                    }
                    GSYVideoControlView gSYVideoControlView4 = GSYVideoControlView.this;
                    if (gSYVideoControlView4.mPostDismiss) {
                        gSYVideoControlView4.postDelayed(this, gSYVideoControlView4.mDismissControlTime);
                    }
                }
            }
        };
    }

    public void setGSYVideoProgressListener(c cVar) {
    }

    public void setLockClickListener(f fVar) {
    }

    public GSYVideoControlView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        this.mThreshold = 80;
        this.mShrinkImageRes = -1;
        this.mEnlargeImageRes = -1;
        this.mDismissControlTime = 2500;
        this.mBrightnessData = -1.0f;
        this.mSeekRatio = 1.0f;
        this.mTouchingProgressBar = false;
        this.mChangeVolume = false;
        this.mChangePosition = false;
        this.mShowVKey = false;
        this.mBrightness = false;
        this.mFirstTouch = false;
        this.mHideKey = true;
        this.mNeedShowWifiTip = true;
        this.mIsTouchWiget = true;
        this.mIsTouchWigetFull = true;
        this.mSetUpLazy = false;
        this.mHadSeekTouch = false;
        this.mPostProgress = false;
        this.mPostDismiss = false;
        this.isShowDragProgressTextOnSeekBar = false;
        this.gestureDetector = new GestureDetector(getContext().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                GSYVideoControlView.this.touchDoubleUp();
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                if (!gSYVideoControlView.mChangePosition && !gSYVideoControlView.mChangeVolume && !gSYVideoControlView.mBrightness) {
                    gSYVideoControlView.onClickUiToggle();
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.progressTask = new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.4
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                int i32 = gSYVideoControlView.mCurrentState;
                if (i32 == 2 || i32 == 5) {
                    gSYVideoControlView.setTextAndProgress(0);
                }
                GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                if (gSYVideoControlView2.mPostProgress) {
                    gSYVideoControlView2.postDelayed(this, 1000L);
                }
            }
        };
        this.dismissControlTask = new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.5
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                int i32 = gSYVideoControlView.mCurrentState;
                if (i32 != 0 && i32 != 7 && i32 != 6) {
                    if (gSYVideoControlView.getActivityContext() != null) {
                        GSYVideoControlView.this.hideAllWidget();
                        GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                        gSYVideoControlView2.setViewShowState(gSYVideoControlView2.mLockScreen, 8);
                        GSYVideoControlView gSYVideoControlView3 = GSYVideoControlView.this;
                        if (gSYVideoControlView3.mHideKey && gSYVideoControlView3.mIfCurrentIsFullscreen && gSYVideoControlView3.mShowVKey) {
                            CommonUtil.hideNavKey(gSYVideoControlView3.mContext);
                        }
                    }
                    GSYVideoControlView gSYVideoControlView4 = GSYVideoControlView.this;
                    if (gSYVideoControlView4.mPostDismiss) {
                        gSYVideoControlView4.postDelayed(this, gSYVideoControlView4.mDismissControlTime);
                    }
                }
            }
        };
    }

    public GSYVideoControlView(Context context, Boolean bool) {
        super(context, bool);
        this.mThreshold = 80;
        this.mShrinkImageRes = -1;
        this.mEnlargeImageRes = -1;
        this.mDismissControlTime = 2500;
        this.mBrightnessData = -1.0f;
        this.mSeekRatio = 1.0f;
        this.mTouchingProgressBar = false;
        this.mChangeVolume = false;
        this.mChangePosition = false;
        this.mShowVKey = false;
        this.mBrightness = false;
        this.mFirstTouch = false;
        this.mHideKey = true;
        this.mNeedShowWifiTip = true;
        this.mIsTouchWiget = true;
        this.mIsTouchWigetFull = true;
        this.mSetUpLazy = false;
        this.mHadSeekTouch = false;
        this.mPostProgress = false;
        this.mPostDismiss = false;
        this.isShowDragProgressTextOnSeekBar = false;
        this.gestureDetector = new GestureDetector(getContext().getApplicationContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                GSYVideoControlView.this.touchDoubleUp();
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                if (!gSYVideoControlView.mChangePosition && !gSYVideoControlView.mChangeVolume && !gSYVideoControlView.mBrightness) {
                    gSYVideoControlView.onClickUiToggle();
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.progressTask = new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.4
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                int i32 = gSYVideoControlView.mCurrentState;
                if (i32 == 2 || i32 == 5) {
                    gSYVideoControlView.setTextAndProgress(0);
                }
                GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                if (gSYVideoControlView2.mPostProgress) {
                    gSYVideoControlView2.postDelayed(this, 1000L);
                }
            }
        };
        this.dismissControlTask = new Runnable() { // from class: com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView.5
            @Override // java.lang.Runnable
            public void run() {
                GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this;
                int i32 = gSYVideoControlView.mCurrentState;
                if (i32 != 0 && i32 != 7 && i32 != 6) {
                    if (gSYVideoControlView.getActivityContext() != null) {
                        GSYVideoControlView.this.hideAllWidget();
                        GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this;
                        gSYVideoControlView2.setViewShowState(gSYVideoControlView2.mLockScreen, 8);
                        GSYVideoControlView gSYVideoControlView3 = GSYVideoControlView.this;
                        if (gSYVideoControlView3.mHideKey && gSYVideoControlView3.mIfCurrentIsFullscreen && gSYVideoControlView3.mShowVKey) {
                            CommonUtil.hideNavKey(gSYVideoControlView3.mContext);
                        }
                    }
                    GSYVideoControlView gSYVideoControlView4 = GSYVideoControlView.this;
                    if (gSYVideoControlView4.mPostDismiss) {
                        gSYVideoControlView4.postDelayed(this, gSYVideoControlView4.mDismissControlTime);
                    }
                }
            }
        };
    }
}

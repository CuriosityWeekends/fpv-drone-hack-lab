package com.shuyu.gsyvideoplayer.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class OrientationUtils {
    private static final int LAND_TYPE_NORMAL = 1;
    private static final int LAND_TYPE_NULL = 0;
    private static final int LAND_TYPE_REVERSE = 2;
    private Activity mActivity;
    private boolean mClick;
    private boolean mClickLand;
    private boolean mClickPort;
    private boolean mEnable;
    private int mIsLand;
    private boolean mIsOnlyRotateLand;
    private boolean mIsPause;
    private OrientationEventListener mOrientationEventListener;
    private OrientationOption mOrientationOption;
    private boolean mRotateWithSystem;
    private int mScreenType;
    private GSYBaseVideoPlayer mVideoPlayer;

    public OrientationUtils(Activity activity, GSYBaseVideoPlayer gSYBaseVideoPlayer) {
        this(activity, gSYBaseVideoPlayer, null);
    }

    private void initGravity(Activity activity) {
        if (this.mIsLand == 0) {
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 0) {
                this.mIsLand = 0;
                this.mScreenType = 1;
            } else if (rotation == 3) {
                this.mIsLand = 2;
                this.mScreenType = 8;
            } else {
                this.mIsLand = 1;
                this.mScreenType = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestedOrientation(int i3) {
        try {
            this.mActivity.setRequestedOrientation(i3);
        } catch (IllegalStateException e5) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 != 26 && i5 != 27) {
                e5.printStackTrace();
            } else {
                Debuger.printfError("OrientationUtils", e5);
            }
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public int backToProtVideo() {
        if (this.mIsLand <= 0) {
            return 0;
        }
        this.mClick = true;
        setRequestedOrientation(1);
        GSYBaseVideoPlayer gSYBaseVideoPlayer = this.mVideoPlayer;
        if (gSYBaseVideoPlayer != null && gSYBaseVideoPlayer.getFullscreenButton() != null) {
            this.mVideoPlayer.getFullscreenButton().setImageResource(this.mVideoPlayer.getEnlargeImageRes());
        }
        this.mIsLand = 0;
        this.mClickPort = false;
        return 500;
    }

    public int getIsLand() {
        return this.mIsLand;
    }

    public OrientationOption getOrientationOption() {
        return this.mOrientationOption;
    }

    public int getScreenType() {
        return this.mScreenType;
    }

    public void init() {
        OrientationEventListener orientationEventListener = new OrientationEventListener(this.mActivity.getApplicationContext()) { // from class: com.shuyu.gsyvideoplayer.utils.OrientationUtils.1
            @Override // android.view.OrientationEventListener
            @SuppressLint({"SourceLockedOrientationActivity"})
            public void onOrientationChanged(int i3) {
                if (Settings.System.getInt(OrientationUtils.this.mActivity.getContentResolver(), "accelerometer_rotation", 0) != 1 && OrientationUtils.this.mRotateWithSystem && (!OrientationUtils.this.mIsOnlyRotateLand || OrientationUtils.this.getIsLand() == 0)) {
                    return;
                }
                if ((OrientationUtils.this.mVideoPlayer != null && OrientationUtils.this.mVideoPlayer.isVerticalFullByVideoSize()) || OrientationUtils.this.mIsPause) {
                    return;
                }
                if ((i3 >= 0 && i3 <= OrientationUtils.this.mOrientationOption.getNormalPortraitAngleStart()) || i3 >= OrientationUtils.this.mOrientationOption.getNormalPortraitAngleEnd()) {
                    if (OrientationUtils.this.mClick) {
                        if (OrientationUtils.this.mIsLand <= 0 || OrientationUtils.this.mClickLand) {
                            OrientationUtils.this.mClickPort = true;
                            OrientationUtils.this.mClick = false;
                            OrientationUtils.this.mIsLand = 0;
                        }
                    } else if (OrientationUtils.this.mIsLand > 0) {
                        if (!OrientationUtils.this.mIsOnlyRotateLand) {
                            OrientationUtils.this.mScreenType = 1;
                            OrientationUtils.this.setRequestedOrientation(1);
                            if (OrientationUtils.this.mVideoPlayer.getFullscreenButton() != null) {
                                if (OrientationUtils.this.mVideoPlayer.isIfCurrentIsFullscreen()) {
                                    OrientationUtils.this.mVideoPlayer.getFullscreenButton().setImageResource(OrientationUtils.this.mVideoPlayer.getShrinkImageRes());
                                } else {
                                    OrientationUtils.this.mVideoPlayer.getFullscreenButton().setImageResource(OrientationUtils.this.mVideoPlayer.getEnlargeImageRes());
                                }
                            }
                            OrientationUtils.this.mIsLand = 0;
                        }
                        OrientationUtils.this.mClick = false;
                    }
                } else if (i3 >= OrientationUtils.this.mOrientationOption.getNormalLandAngleStart() && i3 <= OrientationUtils.this.mOrientationOption.getNormalLandAngleEnd()) {
                    if (OrientationUtils.this.mClick) {
                        if (OrientationUtils.this.mIsLand == 1 || OrientationUtils.this.mClickPort) {
                            OrientationUtils.this.mClickLand = true;
                            OrientationUtils.this.mClick = false;
                            OrientationUtils.this.mIsLand = 1;
                        }
                    } else if (OrientationUtils.this.mIsLand != 1) {
                        OrientationUtils.this.mScreenType = 0;
                        OrientationUtils.this.setRequestedOrientation(0);
                        if (OrientationUtils.this.mVideoPlayer.getFullscreenButton() != null) {
                            OrientationUtils.this.mVideoPlayer.getFullscreenButton().setImageResource(OrientationUtils.this.mVideoPlayer.getShrinkImageRes());
                        }
                        OrientationUtils.this.mIsLand = 1;
                        OrientationUtils.this.mClick = false;
                    }
                } else if (i3 > OrientationUtils.this.mOrientationOption.getReverseLandAngleStart() && i3 < OrientationUtils.this.mOrientationOption.getReverseLandAngleEnd()) {
                    if (OrientationUtils.this.mClick) {
                        if (OrientationUtils.this.mIsLand == 2 || OrientationUtils.this.mClickPort) {
                            OrientationUtils.this.mClickLand = true;
                            OrientationUtils.this.mClick = false;
                            OrientationUtils.this.mIsLand = 2;
                        }
                    } else if (OrientationUtils.this.mIsLand != 2) {
                        OrientationUtils.this.mScreenType = 0;
                        OrientationUtils.this.setRequestedOrientation(8);
                        if (OrientationUtils.this.mVideoPlayer.getFullscreenButton() != null) {
                            OrientationUtils.this.mVideoPlayer.getFullscreenButton().setImageResource(OrientationUtils.this.mVideoPlayer.getShrinkImageRes());
                        }
                        OrientationUtils.this.mIsLand = 2;
                        OrientationUtils.this.mClick = false;
                    }
                }
            }
        };
        this.mOrientationEventListener = orientationEventListener;
        orientationEventListener.enable();
    }

    public boolean isClick() {
        return this.mClick;
    }

    public boolean isClickLand() {
        return this.mClickLand;
    }

    public boolean isClickPort() {
        return this.mClickPort;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public boolean isOnlyRotateLand() {
        return this.mIsOnlyRotateLand;
    }

    public boolean isPause() {
        return this.mIsPause;
    }

    public boolean isRotateWithSystem() {
        return this.mRotateWithSystem;
    }

    public void releaseListener() {
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public void resolveByClick() {
        GSYBaseVideoPlayer gSYBaseVideoPlayer;
        if (this.mIsLand == 0 && (gSYBaseVideoPlayer = this.mVideoPlayer) != null && gSYBaseVideoPlayer.isVerticalFullByVideoSize()) {
            return;
        }
        this.mClick = true;
        if (this.mIsLand == 0) {
            if (this.mActivity.getRequestedOrientation() == 8) {
                this.mScreenType = 8;
            } else {
                this.mScreenType = 0;
            }
            setRequestedOrientation(this.mScreenType);
            if (this.mVideoPlayer.getFullscreenButton() != null) {
                this.mVideoPlayer.getFullscreenButton().setImageResource(this.mVideoPlayer.getShrinkImageRes());
            }
            this.mIsLand = 1;
            this.mClickLand = false;
            return;
        }
        this.mScreenType = 1;
        setRequestedOrientation(1);
        if (this.mVideoPlayer.getFullscreenButton() != null) {
            if (this.mVideoPlayer.isIfCurrentIsFullscreen()) {
                this.mVideoPlayer.getFullscreenButton().setImageResource(this.mVideoPlayer.getShrinkImageRes());
            } else {
                this.mVideoPlayer.getFullscreenButton().setImageResource(this.mVideoPlayer.getEnlargeImageRes());
            }
        }
        this.mIsLand = 0;
        this.mClickPort = false;
    }

    public void setClick(boolean z3) {
        this.mClick = z3;
    }

    public void setClickLand(boolean z3) {
        this.mClickLand = z3;
    }

    public void setClickPort(boolean z3) {
        this.mClickPort = z3;
    }

    public void setEnable(boolean z3) {
        this.mEnable = z3;
        if (z3) {
            this.mOrientationEventListener.enable();
        } else {
            this.mOrientationEventListener.disable();
        }
    }

    public void setIsLand(int i3) {
        this.mIsLand = i3;
    }

    public void setIsPause(boolean z3) {
        this.mIsPause = z3;
    }

    public void setOnlyRotateLand(boolean z3) {
        this.mIsOnlyRotateLand = z3;
    }

    public void setOrientationOption(OrientationOption orientationOption) {
        this.mOrientationOption = orientationOption;
    }

    public void setRotateWithSystem(boolean z3) {
        this.mRotateWithSystem = z3;
    }

    public void setScreenType(int i3) {
        this.mScreenType = i3;
    }

    public OrientationUtils(Activity activity, GSYBaseVideoPlayer gSYBaseVideoPlayer, OrientationOption orientationOption) {
        this.mScreenType = 1;
        this.mIsLand = 0;
        this.mClick = false;
        this.mClickLand = false;
        this.mEnable = true;
        this.mRotateWithSystem = true;
        this.mIsPause = false;
        this.mIsOnlyRotateLand = false;
        this.mActivity = activity;
        this.mVideoPlayer = gSYBaseVideoPlayer;
        if (orientationOption == null) {
            this.mOrientationOption = new OrientationOption();
        } else {
            this.mOrientationOption = orientationOption;
        }
        initGravity(activity);
        init();
    }
}

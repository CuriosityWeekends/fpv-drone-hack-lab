package com.shuyu.gsyvideoplayer.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge;
import l3.a;
import l3.f;
import l3.g;
import l3.h;
import l3.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GSYADVideoPlayer extends StandardGSYVideoPlayer {
    protected boolean isFirstPrepared;
    protected TextView mADTime;
    protected View mJumpAd;

    public GSYADVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public boolean backFromFull(Context context) {
        return a.b(context);
    }

    public void changeAdUIState() {
        int i3;
        int i5;
        int color;
        int i6;
        View view = this.mJumpAd;
        int i7 = 8;
        int i8 = 0;
        if (view != null) {
            if (this.isFirstPrepared) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            view.setVisibility(i6);
        }
        TextView textView = this.mADTime;
        if (textView != null) {
            if (this.isFirstPrepared) {
                i7 = 0;
            }
            textView.setVisibility(i7);
        }
        if (this.mBottomContainer != null) {
            if (this.isFirstPrepared) {
                color = 0;
            } else {
                color = getContext().getResources().getColor(f.bottom_container_bg);
            }
            this.mBottomContainer.setBackgroundColor(color);
        }
        TextView textView2 = this.mCurrentTimeTextView;
        if (textView2 != null) {
            if (this.isFirstPrepared) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            textView2.setVisibility(i5);
        }
        TextView textView3 = this.mTotalTimeTextView;
        if (textView3 != null) {
            if (this.isFirstPrepared) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            textView3.setVisibility(i3);
        }
        SeekBar seekBar = this.mProgressBar;
        if (seekBar != null) {
            if (this.isFirstPrepared) {
                i8 = 4;
            }
            seekBar.setVisibility(i8);
            this.mProgressBar.setEnabled(!this.isFirstPrepared);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        super.cloneParams(gSYBaseVideoPlayer, gSYBaseVideoPlayer2);
        GSYADVideoPlayer gSYADVideoPlayer = (GSYADVideoPlayer) gSYBaseVideoPlayer2;
        gSYADVideoPlayer.isFirstPrepared = ((GSYADVideoPlayer) gSYBaseVideoPlayer).isFirstPrepared;
        gSYADVideoPlayer.changeAdUIState();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public int getFullId() {
        return a.f2708o;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public GSYVideoViewBridge getGSYVideoManager() {
        a c = a.c();
        Context applicationContext = getContext().getApplicationContext();
        c.getClass();
        c.f2712a = applicationContext.getApplicationContext();
        return a.c();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public int getLayoutId() {
        return i.video_layout_ad;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public int getSmallId() {
        return a.f2707n;
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void hideAllWidget() {
        if (this.isFirstPrepared) {
            return;
        }
        super.hideAllWidget();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void init(Context context) {
        super.init(context);
        this.mJumpAd = findViewById(h.jump_ad);
        this.mADTime = (TextView) findViewById(h.ad_time);
        View view = this.mJumpAd;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.shuyu.gsyvideoplayer.video.GSYADVideoPlayer.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (GSYADVideoPlayer.this.getGSYVideoManager().listener() != null) {
                        GSYADVideoPlayer.this.getGSYVideoManager().listener().onAutoCompletion();
                    }
                }
            });
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == h.start) {
            if (this.mCurrentState == 7) {
                clickStartIcon();
                return;
            }
            return;
        }
        super.onClick(view);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public void onPrepared() {
        super.onPrepared();
        this.isFirstPrepared = true;
        changeAdUIState();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void release() {
        super.release();
        TextView textView = this.mADTime;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void releaseVideos() {
        if (a.c().listener() != null) {
            a.c().listener().onCompletion();
        }
        a.c().releaseMediaPlayer();
    }

    public void removeFullWindowViewOnly() {
        ViewGroup viewGroup = (ViewGroup) CommonUtil.scanForActivity(getContext()).findViewById(16908290);
        View findViewById = viewGroup.findViewById(getFullId());
        if (findViewById != null && findViewById.getParent() != null) {
            viewGroup.removeView((ViewGroup) findViewById.getParent());
        }
        this.mIfCurrentIsFullscreen = false;
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void setProgressAndTime(int i3, int i5, int i6, int i7, boolean z3) {
        super.setProgressAndTime(i3, i5, i6, i7, z3);
        TextView textView = this.mADTime;
        if (textView != null && i6 > 0) {
            textView.setText("" + ((i7 / 1000) - (i6 / 1000)));
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void touchDoubleUp() {
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void touchSurfaceMove(float f4, float f5, float f6) {
        if (!this.mChangePosition) {
            super.touchSurfaceMove(f4, f5, f6);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void touchSurfaceMoveFullLogic(float f4, float f5) {
        int i3 = this.mThreshold;
        if (f4 > i3 || f5 > i3) {
            int screenWidth = CommonUtil.getScreenWidth(getContext());
            if (f4 >= this.mThreshold && Math.abs(screenWidth - this.mDownX) > this.mSeekEndOffset) {
                this.mChangePosition = true;
                this.mDownPosition = getCurrentPositionWhenPlaying();
                return;
            }
            super.touchSurfaceMoveFullLogic(f4, f5);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void touchSurfaceUp() {
        if (this.mChangePosition) {
            return;
        }
        super.touchSurfaceUp();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
    public void updateStartImage() {
        View view = this.mStartButton;
        if (view != null && (view instanceof ImageView)) {
            ImageView imageView = (ImageView) view;
            int i3 = this.mCurrentState;
            if (i3 == 2) {
                imageView.setImageResource(g.empty_drawable);
            } else if (i3 == 7) {
                imageView.setImageResource(g.video_click_error_selector);
            } else {
                imageView.setImageResource(g.empty_drawable);
            }
        }
    }

    public GSYADVideoPlayer(Context context) {
        super(context);
    }

    public GSYADVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

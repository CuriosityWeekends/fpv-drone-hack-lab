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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l3.f;
import l3.g;
import l3.h;
import l3.i;
import o3.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GSYSampleADVideoPlayer extends ListGSYVideoPlayer {
    protected boolean isAdModel;
    protected boolean isFirstPrepared;
    protected TextView mADTime;
    protected View mJumpAd;
    protected ViewGroup mWidgetContainer;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class GSYADVideoModel extends b {
        public static int TYPE_AD = 1;
        public static int TYPE_NORMAL;
        private boolean isSkip;
        private int mType;

        public GSYADVideoModel(String str, String str2, int i3) {
            this(str, str2, i3, false);
        }

        public int getType() {
            return this.mType;
        }

        public boolean isSkip() {
            return this.isSkip;
        }

        public void setSkip(boolean z3) {
            this.isSkip = z3;
        }

        public void setType(int i3) {
            this.mType = i3;
        }

        public GSYADVideoModel(String str, String str2, int i3, boolean z3) {
            super(str, str2);
            this.mType = i3;
            this.isSkip = z3;
        }
    }

    public GSYSampleADVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
        this.isAdModel = false;
        this.isFirstPrepared = false;
    }

    public void changeAdUIState() {
        int i3;
        int i5;
        int color;
        int i6;
        int i7;
        View view = this.mJumpAd;
        int i8 = 8;
        boolean z3 = false;
        if (view != null) {
            if (this.isFirstPrepared && this.isAdModel) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            view.setVisibility(i7);
        }
        TextView textView = this.mADTime;
        if (textView != null) {
            if (this.isFirstPrepared && this.isAdModel) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            textView.setVisibility(i6);
        }
        ViewGroup viewGroup = this.mWidgetContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility((this.isFirstPrepared && this.isAdModel) ? 0 : 0);
        }
        if (this.mBottomContainer != null) {
            if (this.isFirstPrepared && this.isAdModel) {
                color = 0;
            } else {
                color = getContext().getResources().getColor(f.bottom_container_bg);
            }
            this.mBottomContainer.setBackgroundColor(color);
        }
        TextView textView2 = this.mCurrentTimeTextView;
        int i9 = 4;
        if (textView2 != null) {
            if (this.isFirstPrepared && this.isAdModel) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            textView2.setVisibility(i5);
        }
        TextView textView3 = this.mTotalTimeTextView;
        if (textView3 != null) {
            if (this.isFirstPrepared && this.isAdModel) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            textView3.setVisibility(i3);
        }
        SeekBar seekBar = this.mProgressBar;
        if (seekBar != null) {
            seekBar.setVisibility((this.isFirstPrepared && this.isAdModel) ? 0 : 0);
            this.mProgressBar.setEnabled((this.isFirstPrepared && this.isAdModel) ? true : true);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.ListGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer
    public void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        super.cloneParams(gSYBaseVideoPlayer, gSYBaseVideoPlayer2);
        GSYSampleADVideoPlayer gSYSampleADVideoPlayer = (GSYSampleADVideoPlayer) gSYBaseVideoPlayer;
        GSYSampleADVideoPlayer gSYSampleADVideoPlayer2 = (GSYSampleADVideoPlayer) gSYBaseVideoPlayer2;
        gSYSampleADVideoPlayer2.isAdModel = gSYSampleADVideoPlayer.isAdModel;
        gSYSampleADVideoPlayer2.isFirstPrepared = gSYSampleADVideoPlayer.isFirstPrepared;
        gSYSampleADVideoPlayer2.changeAdUIState();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public int getLayoutId() {
        return i.video_layout_sample_ad;
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void hideAllWidget() {
        if (this.isFirstPrepared && this.isAdModel) {
            return;
        }
        super.hideAllWidget();
    }

    @Override // com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView
    public void init(Context context) {
        super.init(context);
        this.mJumpAd = findViewById(h.jump_ad);
        this.mADTime = (TextView) findViewById(h.ad_time);
        this.mWidgetContainer = (ViewGroup) findViewById(h.widget_container);
        View view = this.mJumpAd;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.shuyu.gsyvideoplayer.video.GSYSampleADVideoPlayer.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    GSYSampleADVideoPlayer.this.playNext();
                }
            });
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.ListGSYVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer, com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView, com.shuyu.gsyvideoplayer.video.base.GSYVideoView, n3.a
    public void onPrepared() {
        super.onPrepared();
        this.isFirstPrepared = true;
        changeAdUIState();
    }

    public boolean setAdUp(ArrayList<GSYADVideoModel> arrayList, boolean z3, int i3) {
        return setUp((ArrayList) arrayList.clone(), z3, i3);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void setProgressAndTime(int i3, int i5, int i6, int i7, boolean z3) {
        super.setProgressAndTime(i3, i5, i6, i7, z3);
        TextView textView = this.mADTime;
        if (textView != null && i6 > 0) {
            textView.setText("" + ((i7 / 1000) - (i6 / 1000)));
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.ListGSYVideoPlayer
    public boolean setUp(List<b> list, boolean z3, int i3) {
        return setUp(list, z3, i3, (File) null);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void touchDoubleUp() {
        if (this.isAdModel) {
            return;
        }
        super.touchDoubleUp();
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void touchSurfaceMove(float f4, float f5, float f6) {
        if (this.mChangePosition && this.isAdModel) {
            return;
        }
        super.touchSurfaceMove(f4, f5, f6);
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void touchSurfaceMoveFullLogic(float f4, float f5) {
        int i3 = this.mThreshold;
        if (f4 > i3 || f5 > i3) {
            int screenWidth = CommonUtil.getScreenWidth(getContext());
            if (this.isAdModel && f4 >= this.mThreshold && Math.abs(screenWidth - this.mDownX) > this.mSeekEndOffset) {
                this.mChangePosition = true;
                this.mDownPosition = getCurrentPositionWhenPlaying();
                return;
            }
            super.touchSurfaceMoveFullLogic(f4, f5);
        }
    }

    @Override // com.shuyu.gsyvideoplayer.video.base.GSYVideoControlView
    public void touchSurfaceUp() {
        if (this.mChangePosition && this.isAdModel) {
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
                imageView.setImageResource(g.video_click_pause_selector);
            } else if (i3 == 7) {
                imageView.setImageResource(g.video_click_play_selector);
            } else {
                imageView.setImageResource(g.video_click_play_selector);
            }
        }
    }

    public boolean setAdUp(ArrayList<GSYADVideoModel> arrayList, boolean z3, int i3, File file) {
        return setUp((ArrayList) arrayList.clone(), z3, i3, file);
    }

    @Override // com.shuyu.gsyvideoplayer.video.ListGSYVideoPlayer
    public boolean setUp(List<b> list, boolean z3, int i3, File file) {
        return setUp(list, z3, i3, file, new HashMap());
    }

    public boolean setAdUp(ArrayList<GSYADVideoModel> arrayList, boolean z3, int i3, File file, Map<String, String> map) {
        return setUp((ArrayList) arrayList.clone(), z3, i3, file, map);
    }

    @Override // com.shuyu.gsyvideoplayer.video.ListGSYVideoPlayer
    public boolean setUp(List<b> list, boolean z3, int i3, File file, Map<String, String> map) {
        return setUp(list, z3, i3, file, map, true);
    }

    public GSYSampleADVideoPlayer(Context context) {
        super(context);
        this.isAdModel = false;
        this.isFirstPrepared = false;
    }

    @Override // com.shuyu.gsyvideoplayer.video.ListGSYVideoPlayer
    public boolean setUp(List<b> list, boolean z3, int i3, File file, Map<String, String> map, boolean z5) {
        b bVar = list.get(i3);
        if (bVar instanceof GSYADVideoModel) {
            GSYADVideoModel gSYADVideoModel = (GSYADVideoModel) bVar;
            if (gSYADVideoModel.isSkip() && i3 < list.size() - 1) {
                return setUp(list, z3, i3 + 1, file, map, z5);
            }
            this.isAdModel = gSYADVideoModel.getType() == GSYADVideoModel.TYPE_AD;
        }
        changeAdUIState();
        return super.setUp(list, z3, i3, file, map, z5);
    }

    public GSYSampleADVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isAdModel = false;
        this.isFirstPrepared = false;
    }
}

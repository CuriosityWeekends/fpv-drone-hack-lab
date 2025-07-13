package com.shuyu.gsyvideoplayer.utils;

import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class MeasureHelper {
    private int mCurrentAspectRatio = 0;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private final MeasureFormVideoParamsListener mParamsListener;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private WeakReference<View> mWeakView;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface MeasureFormVideoParamsListener {
        int getCurrentVideoHeight();

        int getCurrentVideoWidth();

        int getVideoSarDen();

        int getVideoSarNum();
    }

    public MeasureHelper(View view, MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        this.mParamsListener = measureFormVideoParamsListener;
        this.mWeakView = new WeakReference<>(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ea, code lost:
        if (r4 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ec, code lost:
        r14 = (int) (r5 * r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f1, code lost:
        r15 = (int) (r2 / r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f5, code lost:
        if (r4 != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void doMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuyu.gsyvideoplayer.utils.MeasureHelper.doMeasure(int, int):void");
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public View getView() {
        WeakReference<View> weakReference = this.mWeakView;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void prepareMeasure(int i3, int i5, int i6) {
        MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mParamsListener;
        if (measureFormVideoParamsListener != null) {
            try {
                int currentVideoWidth = measureFormVideoParamsListener.getCurrentVideoWidth();
                int currentVideoHeight = this.mParamsListener.getCurrentVideoHeight();
                Debuger.printfLog("videoWidth: " + currentVideoWidth + " videoHeight: " + currentVideoHeight);
                int videoSarNum = this.mParamsListener.getVideoSarNum();
                int videoSarDen = this.mParamsListener.getVideoSarDen();
                if (currentVideoWidth > 0 && currentVideoHeight > 0) {
                    setVideoSampleAspectRatio(videoSarNum, videoSarDen);
                    setVideoSize(currentVideoWidth, currentVideoHeight);
                }
                setVideoRotation(i6);
                doMeasure(i3, i5);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void setAspectRatio(int i3) {
        this.mCurrentAspectRatio = i3;
    }

    public void setVideoRotation(int i3) {
        this.mVideoRotationDegree = i3;
    }

    public void setVideoSampleAspectRatio(int i3, int i5) {
        this.mVideoSarNum = i3;
        this.mVideoSarDen = i5;
    }

    public void setVideoSize(int i3, int i5) {
        this.mVideoWidth = i3;
        this.mVideoHeight = i5;
    }
}

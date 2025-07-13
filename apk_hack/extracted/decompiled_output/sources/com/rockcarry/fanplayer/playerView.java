package com.rockcarry.fanplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class playerView extends RelativeLayout {
    private OnSizeChangedListener mListener;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnSizeChangedListener {
        void onSizeChanged(int i3, int i5, int i6, int i7);
    }

    public playerView(Context context) {
        super(context);
        this.mListener = null;
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i3, i5, i6, i7);
        OnSizeChangedListener onSizeChangedListener = this.mListener;
        if (onSizeChangedListener != null) {
            onSizeChangedListener.onSizeChanged(i3, i5, i6, i7);
        }
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.mListener = onSizeChangedListener;
    }

    public playerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mListener = null;
    }
}

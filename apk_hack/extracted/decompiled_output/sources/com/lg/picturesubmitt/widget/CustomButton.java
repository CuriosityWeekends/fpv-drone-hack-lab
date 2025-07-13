package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class CustomButton extends ImageButton {
    public CustomButton(Context context) {
        super(context);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 3) {
            if (action != 0) {
                if (action == 1) {
                    if (getDrawable() != null) {
                        clearColorFilter();
                    } else if (getBackground() != null) {
                        getBackground().clearColorFilter();
                    }
                }
            } else if (getDrawable() != null) {
                setColorFilter(Color.parseColor("#60000000"));
            } else if (getBackground() != null) {
                getBackground().setColorFilter(Color.parseColor("#60000000"), PorterDuff.Mode.SRC_ATOP);
            }
        } else if (getDrawable() != null) {
            clearColorFilter();
        } else if (getBackground() != null) {
            getBackground().clearColorFilter();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setStatus(boolean z3) {
        if (z3) {
            if (getDrawable() != null) {
                setColorFilter(Color.parseColor("#60000000"));
            } else if (getBackground() != null) {
                getBackground().setColorFilter(Color.parseColor("#60000000"), PorterDuff.Mode.SRC_ATOP);
            }
        } else if (getDrawable() != null) {
            clearColorFilter();
        } else if (getBackground() != null) {
            getBackground().clearColorFilter();
        }
    }

    public CustomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

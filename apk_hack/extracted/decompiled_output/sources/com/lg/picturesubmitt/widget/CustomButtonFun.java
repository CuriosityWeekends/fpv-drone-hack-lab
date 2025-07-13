package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class CustomButtonFun extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f893a;

    public CustomButtonFun(Context context) {
        super(context);
        this.f893a = context.getResources().getDrawable(2131558504);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        setBackground(this.f893a);
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

    public CustomButtonFun(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f893a = context.getResources().getDrawable(2131558504);
    }

    public CustomButtonFun(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f893a = context.getResources().getDrawable(2131558504);
    }
}

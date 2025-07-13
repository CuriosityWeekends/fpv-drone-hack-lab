package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        init(context, attributeSet, i3, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i3, int i5) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i3, i5);
        int i6 = R.styleable.PopupWindow_overlapAnchor;
        if (obtainStyledAttributes.hasValue(i6)) {
            setSupportOverlapAnchor(obtainStyledAttributes.getBoolean(i6, false));
        }
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
    }

    private void setSupportOverlapAnchor(boolean z3) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z3;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z3);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i5) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i5 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i5);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i3, int i5, int i6, int i7) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i5 -= view.getHeight();
        }
        super.update(view, i3, i5, i6, i7);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i5) {
        super(context, attributeSet, i3, i5);
        init(context, attributeSet, i3, i5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i5, int i6) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i5 -= view.getHeight();
        }
        super.showAsDropDown(view, i3, i5, i6);
    }
}

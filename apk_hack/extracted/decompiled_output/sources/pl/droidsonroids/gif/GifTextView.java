package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GifTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public l f3276a;

    public GifTextView(Context context) {
        super(context);
    }

    private void setCompoundDrawablesVisible(boolean z3) {
        Drawable[] compoundDrawables;
        Drawable[] compoundDrawablesRelative;
        for (Drawable drawable : getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setVisible(z3, false);
            }
        }
        for (Drawable drawable2 : getCompoundDrawablesRelative()) {
            if (drawable2 != null) {
                drawable2.setVisible(z3, false);
            }
        }
    }

    public final Drawable a(int i3) {
        if (i3 == 0) {
            return null;
        }
        Resources resources = getResources();
        String resourceTypeName = resources.getResourceTypeName(i3);
        if (!isInEditMode() && m.f3307a.contains(resourceTypeName)) {
            try {
                return new c(resources, i3);
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return resources.getDrawable(i3, getContext().getTheme());
    }

    public final void b(AttributeSet attributeSet, int i3) {
        if (attributeSet != null) {
            Drawable a5 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable a6 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable a7 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable a8 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable a9 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable a10 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (getLayoutDirection() == 0) {
                if (a9 != null) {
                    a5 = a9;
                }
                if (a10 == null) {
                    a10 = a7;
                }
            } else {
                if (a9 != null) {
                    a7 = a9;
                }
                if (a10 == null) {
                    a10 = a5;
                }
                a5 = a7;
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(a5, a6, a10, a8);
            setBackground(a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
            l lVar = new l(this, attributeSet, i3);
            this.f3276a = lVar;
            if (lVar.b >= 0) {
                for (Drawable drawable : getCompoundDrawables()) {
                    m.a(drawable, this.f3276a.b);
                }
                for (Drawable drawable2 : getCompoundDrawablesRelative()) {
                    m.a(drawable2, this.f3276a.b);
                }
                m.a(getBackground(), this.f3276a.b);
            }
        }
        this.f3276a = new l();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCompoundDrawablesVisible(true);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setCompoundDrawablesVisible(false);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.c(compoundDrawables[0], 0);
        gifViewSavedState.c(compoundDrawables[1], 1);
        gifViewSavedState.c(compoundDrawables[2], 2);
        gifViewSavedState.c(compoundDrawables[3], 3);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        gifViewSavedState.c(compoundDrawablesRelative[0], 4);
        gifViewSavedState.c(compoundDrawablesRelative[2], 5);
        gifViewSavedState.c(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.f3276a.f3306a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            drawableArr[4] = compoundDrawablesRelative[0];
            drawableArr[5] = compoundDrawablesRelative[2];
            drawableArr[6] = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        setBackground(a(i3));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i5, int i6, int i7) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(a(i3), a(i5), a(i6), a(i7));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i3, int i5, int i6, int i7) {
        setCompoundDrawablesWithIntrinsicBounds(a(i3), a(i5), a(i6), a(i7));
    }

    public void setFreezesAnimation(boolean z3) {
        this.f3276a.f3306a = z3;
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(attributeSet, i3);
    }
}

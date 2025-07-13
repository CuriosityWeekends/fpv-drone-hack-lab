package pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GifImageButton extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3273a;

    public GifImageButton(Context context) {
        super(context);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.c(getDrawable(), 0);
        gifViewSavedState.c(getBackground(), 1);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Drawable drawable;
        Drawable drawable2 = null;
        if (this.f3273a) {
            drawable = getDrawable();
        } else {
            drawable = null;
        }
        if (this.f3273a) {
            drawable2 = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawable, drawable2);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        if (!m.d(this, false, i3)) {
            super.setBackgroundResource(i3);
        }
    }

    public void setFreezesAnimation(boolean z3) {
        this.f3273a = z3;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        if (!m.d(this, true, i3)) {
            super.setImageResource(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (!m.c(this, uri)) {
            super.setImageURI(uri);
        }
    }

    public GifImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k b = m.b(this, attributeSet, 0);
        this.f3273a = b.f3306a;
        int i3 = b.c;
        if (i3 > 0) {
            super.setImageResource(i3);
        }
        int i5 = b.d;
        if (i5 > 0) {
            super.setBackgroundResource(i5);
        }
    }

    public GifImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        k b = m.b(this, attributeSet, i3);
        this.f3273a = b.f3306a;
        int i5 = b.c;
        if (i5 > 0) {
            super.setImageResource(i5);
        }
        int i6 = b.d;
        if (i6 > 0) {
            super.setBackgroundResource(i6);
        }
    }
}

package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class EdgeEffectCompat {
    private EdgeEffect mEdgeEffect;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i3) {
        this.mEdgeEffect.onAbsorb(i3);
        return true;
    }

    @Deprecated
    public boolean onPull(float f4) {
        this.mEdgeEffect.onPull(f4);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i3, int i5) {
        this.mEdgeEffect.setSize(i3, i5);
    }

    @Deprecated
    public boolean onPull(float f4, float f5) {
        onPull(this.mEdgeEffect, f4, f5);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f4, float f5) {
        edgeEffect.onPull(f4, f5);
    }
}

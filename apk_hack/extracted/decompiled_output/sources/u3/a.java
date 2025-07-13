package u3;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f3775a;
    public int b;
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f3776e;

    /* renamed from: f  reason: collision with root package name */
    public int f3777f;

    /* renamed from: g  reason: collision with root package name */
    public GSYBaseVideoPlayer f3778g;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        GSYBaseVideoPlayer gSYBaseVideoPlayer = this.f3778g;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) gSYBaseVideoPlayer.getLayoutParams();
                    int i3 = rawX - this.f3776e;
                    layoutParams.leftMargin = i3;
                    int i5 = rawY - this.f3777f;
                    layoutParams.topMargin = i5;
                    int i6 = this.c;
                    if (i3 >= i6) {
                        layoutParams.leftMargin = i6;
                    }
                    int i7 = this.d;
                    if (i5 >= i7) {
                        layoutParams.topMargin = i7;
                    }
                    if (layoutParams.leftMargin <= 0) {
                        layoutParams.leftMargin = 0;
                    }
                    if (layoutParams.topMargin <= 0) {
                        layoutParams.topMargin = 0;
                    }
                    gSYBaseVideoPlayer.setLayoutParams(layoutParams);
                }
            } else if (Math.abs(this.b - rawY) < 5 && Math.abs(this.f3775a - rawX) < 5) {
                return false;
            } else {
                return true;
            }
        } else {
            this.f3775a = rawX;
            this.b = rawY;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) gSYBaseVideoPlayer.getLayoutParams();
            this.f3776e = rawX - layoutParams2.leftMargin;
            this.f3777f = rawY - layoutParams2.topMargin;
        }
        return false;
    }
}

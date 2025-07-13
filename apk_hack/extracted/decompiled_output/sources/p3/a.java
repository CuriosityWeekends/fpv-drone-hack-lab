package p3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public View f3226a;

    public static void a(ViewGroup viewGroup, View view) {
        int i3;
        if (GSYVideoType.getShowType() != 0) {
            i3 = -2;
        } else {
            i3 = -1;
        }
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
            layoutParams.addRule(13);
            viewGroup.addView(view, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i3);
            layoutParams2.gravity = 17;
            viewGroup.addView(view, layoutParams2);
        }
    }
}

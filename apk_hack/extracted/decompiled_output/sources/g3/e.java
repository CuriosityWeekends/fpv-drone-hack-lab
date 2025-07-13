package g3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.media.SoundPool;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.lg.picturesubmitt.MyApplication;
import com.tencent.bugly.proguard.c0;
import java.util.Timer;
import x2.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public long f1973a = 0;
    public final d b;
    public final SoundPool c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1974e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1975f;

    /* renamed from: g  reason: collision with root package name */
    public final com.lxj.xpopup.util.e f1976g;

    /* JADX WARN: Type inference failed for: r14v5, types: [com.lxj.xpopup.util.e, java.lang.Object] */
    public e(Activity activity, d dVar) {
        SoundPool soundPool = new SoundPool(100, 3, 0);
        this.c = soundPool;
        this.f1975f = 500;
        this.b = dVar;
        this.d = soundPool.load(activity, 2131689480, 0);
        this.f1974e = soundPool.load(activity, 2131689479, 0);
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        ?? obj = new Object();
        obj.f1121e = new Timer();
        obj.f1123g = new i();
        obj.c = childAt;
        obj.d = new int[]{2131558598, 2131558599, 2131558600};
        View inflate = LayoutInflater.from(activity).inflate(2131427487, (ViewGroup) null);
        obj.b = (ImageView) inflate.findViewById(2131230952);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
        obj.f1120a = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setTouchable(false);
        popupWindow.setFocusable(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(3.0f, 1.0f, 3.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatCount(0);
        scaleAnimation.setFillAfter(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setRepeatCount(0);
        alphaAnimation.setFillAfter(true);
        AnimationSet animationSet = new AnimationSet(false);
        obj.f1122f = animationSet;
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.f1976g = obj;
    }

    public final void a(Bitmap bitmap) {
        if (MyApplication.f541h && System.currentTimeMillis() - this.f1973a > this.f1975f) {
            Log.d("GestureReconizerHelper", "process");
            b3.e eVar = new b3.e(7, this);
            if (b.c != null) {
                Log.d("GestureReconizer", "reconizeThread return");
            } else {
                b.c = new Thread(new c0(5, bitmap, eVar, false));
                b.c.setPriority(3);
                b.c.start();
            }
            this.f1973a = System.currentTimeMillis();
        }
    }
}

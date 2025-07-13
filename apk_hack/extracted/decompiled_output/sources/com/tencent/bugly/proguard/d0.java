package com.tencent.bugly.proguard;

import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.PopupWindow;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1480a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d0(Object obj, int i3, int i5) {
        this.f1480a = i5;
        this.c = obj;
        this.b = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        switch (this.f1480a) {
            case 0:
                for (int i3 = 0; i3 < this.b && (runnable = (Runnable) ((LinkedBlockingQueue) this.c).poll()) != null; i3++) {
                    runnable.run();
                }
                return;
            case 1:
                l3.d dVar = (l3.d) this.c;
                if (dVar.listener() != null) {
                    dVar.getClass();
                    int i5 = this.b;
                    if (i5 > 0) {
                        dVar.listener().onBufferingUpdate(i5);
                        return;
                    }
                    n3.a listener = dVar.listener();
                    dVar.getClass();
                    listener.onBufferingUpdate(0);
                    return;
                }
                return;
            default:
                com.lxj.xpopup.util.e eVar = (com.lxj.xpopup.util.e) this.c;
                ((TimerTask) eVar.f1123g).cancel();
                ((Timer) eVar.f1121e).cancel();
                eVar.f1121e = new Timer();
                eVar.f1123g = new t2.c(1, this);
                if (((PopupWindow) eVar.f1120a).isShowing()) {
                    ((PopupWindow) eVar.f1120a).dismiss();
                }
                ((ImageView) eVar.b).setImageResource(((int[]) eVar.d)[this.b]);
                ((PopupWindow) eVar.f1120a).showAtLocation((View) eVar.c, 17, 0, 0);
                ((Timer) eVar.f1121e).schedule((TimerTask) eVar.f1123g, 900L);
                ((ImageView) eVar.b).startAnimation((AnimationSet) eVar.f1122f);
                return;
        }
    }

    public d0(int i3, LinkedBlockingQueue linkedBlockingQueue) {
        this.f1480a = 0;
        this.b = i3;
        this.c = linkedBlockingQueue;
    }
}

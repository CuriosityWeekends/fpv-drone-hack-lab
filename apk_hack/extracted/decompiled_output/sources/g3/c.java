package g3;

import android.view.View;
import com.tencent.bugly.proguard.d0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1972a;
    public final /* synthetic */ b3.e b;

    public /* synthetic */ c(b3.e eVar, int i3) {
        this.f1972a = i3;
        this.b = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1972a) {
            case 0:
                int i3 = 0;
                while (true) {
                    b3.e eVar = this.b;
                    if (i3 < 3) {
                        com.lxj.xpopup.util.e eVar2 = ((e) eVar.b).f1976g;
                        eVar2.getClass();
                        ((View) eVar2.c).post(new d0(eVar2, 2 - i3, 2));
                        e eVar3 = (e) eVar.b;
                        eVar3.c.play(eVar3.f1974e, 1.0f, 1.0f, 0, 0, 1.0f);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e5) {
                            e5.printStackTrace();
                        }
                        i3++;
                    } else {
                        d dVar = ((e) eVar.b).b;
                        if (dVar != null) {
                            dVar.e();
                            return;
                        }
                        return;
                    }
                }
            default:
                int i5 = 0;
                while (true) {
                    b3.e eVar4 = this.b;
                    if (i5 < 3) {
                        com.lxj.xpopup.util.e eVar5 = ((e) eVar4.b).f1976g;
                        eVar5.getClass();
                        ((View) eVar5.c).post(new d0(eVar5, 2 - i5, 2));
                        e eVar6 = (e) eVar4.b;
                        eVar6.c.play(eVar6.f1974e, 1.0f, 1.0f, 0, 0, 1.0f);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e6) {
                            e6.printStackTrace();
                        }
                        i5++;
                    } else {
                        d dVar2 = ((e) eVar4.b).b;
                        if (dVar2 != null) {
                            dVar2.a();
                            return;
                        }
                        return;
                    }
                }
        }
    }
}

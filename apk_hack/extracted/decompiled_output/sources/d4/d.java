package d4;

import com.zhouyou.view.seekbar.SignSeekBar;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1647a;
    public final /* synthetic */ SignSeekBar b;

    public /* synthetic */ d(SignSeekBar signSeekBar, int i3) {
        this.f1647a = i3;
        this.b = signSeekBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1647a) {
            case 0:
                this.b.requestLayout();
                return;
            default:
                SignSeekBar signSeekBar = this.b;
                signSeekBar.T = false;
                signSeekBar.a();
                return;
        }
    }
}

package x2;

import android.view.View;
import com.lg.picturesubmitt.widget.HTrimView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3965a;
    public final /* synthetic */ HTrimView b;

    public /* synthetic */ e(HTrimView hTrimView, int i3) {
        this.f3965a = i3;
        this.b = hTrimView;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        switch (this.f3965a) {
            case 0:
                HTrimView hTrimView = this.b;
                hTrimView.d = true;
                hTrimView.c.post(hTrimView.f919l);
                return true;
            default:
                HTrimView hTrimView2 = this.b;
                hTrimView2.f918k = true;
                hTrimView2.c.post(hTrimView2.f919l);
                return true;
        }
    }
}

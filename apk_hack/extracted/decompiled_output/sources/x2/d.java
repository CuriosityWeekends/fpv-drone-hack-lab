package x2;

import android.view.View;
import com.lg.picturesubmitt.widget.HTrimView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3964a;
    public final /* synthetic */ HTrimView b;

    public /* synthetic */ d(HTrimView hTrimView, int i3) {
        this.f3964a = i3;
        this.b = hTrimView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3964a) {
            case 0:
                this.b.a(false);
                return;
            default:
                this.b.a(true);
                return;
        }
    }
}

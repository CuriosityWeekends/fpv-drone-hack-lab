package t2;

import android.view.View;
import com.lg.picturesubmitt.activity.BaseActivity;
import com.lg.picturesubmitt.activity.ControlActivity;
import com.lg.picturesubmitt.activity.FFMPEGPlayActivity;
import com.lg.picturesubmitt.activity.ImageListActivity;
import com.lg.picturesubmitt.activity.MusicActivity;
import com.lg.picturesubmitt.activity.ViewPhotoDetailActivity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3684a;
    public final /* synthetic */ BaseActivity b;

    public /* synthetic */ a(BaseActivity baseActivity, int i3) {
        this.f3684a = i3;
        this.b = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseActivity baseActivity = this.b;
        switch (this.f3684a) {
            case 0:
                int i3 = ControlActivity.d;
                ((ControlActivity) baseActivity).finish();
                return;
            case 1:
                ((FFMPEGPlayActivity) baseActivity).onViewClicked(view);
                return;
            case 2:
                ((ImageListActivity) baseActivity).onViewClicked(view);
                return;
            case 3:
                ((MusicActivity) baseActivity).onViewClicked(view);
                return;
            default:
                int i5 = ViewPhotoDetailActivity.c;
                ((ViewPhotoDetailActivity) baseActivity).finish();
                return;
        }
    }
}

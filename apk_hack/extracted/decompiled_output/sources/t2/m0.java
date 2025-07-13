package t2;

import android.text.TextUtils;
import android.widget.ImageView;
import com.lg.picturesubmitt.activity.TrinityActivity;
import com.lg.picturesubmitt.model.MusicInfo;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3706a;
    public final /* synthetic */ TrinityActivity b;

    public /* synthetic */ m0(TrinityActivity trinityActivity, int i3) {
        this.f3706a = i3;
        this.b = trinityActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3706a) {
            case 0:
                TrinityActivity trinityActivity = this.b;
                if (trinityActivity.M0) {
                    trinityActivity.O.setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    trinityActivity.O.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                TrinityActivity trinityActivity2 = this.b;
                trinityActivity2.O.setImageBitmap(trinityActivity2.T);
                if (this.b.f822d0) {
                    this.b.P.setVisibility(0);
                    TrinityActivity trinityActivity3 = this.b;
                    trinityActivity3.P.setImageBitmap(trinityActivity3.T);
                    return;
                }
                this.b.P.setVisibility(8);
                return;
            case 1:
                TrinityActivity trinityActivity4 = this.b;
                int i3 = trinityActivity4.f873w0 + 1;
                trinityActivity4.f873w0 = i3;
                int i5 = i3 / 2;
                if (i3 % 2 == 0) {
                    trinityActivity4.H.setText(String.format("%02d:%02d", Integer.valueOf(i5 / 60), Integer.valueOf(i5 % 60)));
                    trinityActivity4.f855p.setVisibility(0);
                } else {
                    trinityActivity4.f855p.setVisibility(4);
                }
                MusicInfo musicInfo = trinityActivity4.G0;
                if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path) && i5 == trinityActivity4.G0.value) {
                    trinityActivity4.A.performClick();
                    return;
                } else {
                    trinityActivity4.f839j1.postDelayed(trinityActivity4.i1, 500L);
                    return;
                }
        }
        for (int i6 = 0; i6 < 5; i6++) {
            try {
                TrinityActivity trinityActivity5 = this.b;
                trinityActivity5.d.sendPIDData(trinityActivity5.f850n0);
                Thread.sleep(50L);
            } catch (InterruptedException e5) {
                e5.printStackTrace();
                return;
            }
        }
    }
}

package t2;

import android.text.TextUtils;
import android.widget.ImageView;
import com.lg.picturesubmitt.activity.MainActivityNew;
import com.lg.picturesubmitt.model.MusicInfo;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3720a;
    public final /* synthetic */ MainActivityNew b;

    public /* synthetic */ x(MainActivityNew mainActivityNew, int i3) {
        this.f3720a = i3;
        this.b = mainActivityNew;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3720a) {
            case 0:
                MainActivityNew mainActivityNew = this.b;
                if (mainActivityNew.X0) {
                    mainActivityNew.U.setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    mainActivityNew.U.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                MainActivityNew mainActivityNew2 = this.b;
                mainActivityNew2.U.setImageBitmap(mainActivityNew2.Z);
                if (this.b.f694h0) {
                    this.b.V.setVisibility(0);
                    MainActivityNew mainActivityNew3 = this.b;
                    mainActivityNew3.V.setImageBitmap(mainActivityNew3.Z);
                    return;
                }
                this.b.V.setVisibility(8);
                return;
            default:
                MainActivityNew mainActivityNew4 = this.b;
                int i3 = mainActivityNew4.F0 + 1;
                mainActivityNew4.F0 = i3;
                int i5 = i3 / 2;
                if (i3 % 2 == 0) {
                    mainActivityNew4.L.setText(String.format("%02d:%02d", Integer.valueOf(i5 / 60), Integer.valueOf(i5 % 60)));
                    mainActivityNew4.q.setVisibility(0);
                } else {
                    mainActivityNew4.q.setVisibility(4);
                }
                MusicInfo musicInfo = mainActivityNew4.R0;
                if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path) && i5 == mainActivityNew4.R0.value) {
                    mainActivityNew4.D.performClick();
                    return;
                } else {
                    mainActivityNew4.f745z1.postDelayed(mainActivityNew4.f742y1, 500L);
                    return;
                }
        }
    }
}

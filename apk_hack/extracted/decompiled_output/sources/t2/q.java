package t2;

import android.text.TextUtils;
import android.widget.ImageView;
import com.lg.picturesubmitt.activity.MainActivityDecode;
import com.lg.picturesubmitt.model.MusicInfo;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3713a;
    public final /* synthetic */ MainActivityDecode b;

    public /* synthetic */ q(MainActivityDecode mainActivityDecode, int i3) {
        this.f3713a = i3;
        this.b = mainActivityDecode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3713a) {
            case 0:
                MainActivityDecode mainActivityDecode = this.b;
                if (mainActivityDecode.Y0) {
                    mainActivityDecode.U.setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    mainActivityDecode.U.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                MainActivityDecode mainActivityDecode2 = this.b;
                mainActivityDecode2.U.setImageBitmap(mainActivityDecode2.Z);
                if (this.b.f629i0) {
                    this.b.V.setVisibility(0);
                    MainActivityDecode mainActivityDecode3 = this.b;
                    mainActivityDecode3.V.setImageBitmap(mainActivityDecode3.Z);
                    return;
                }
                this.b.V.setVisibility(8);
                return;
            default:
                MainActivityDecode mainActivityDecode4 = this.b;
                int i3 = mainActivityDecode4.G0 + 1;
                mainActivityDecode4.G0 = i3;
                int i5 = i3 / 2;
                if (i3 % 2 == 0) {
                    mainActivityDecode4.L.setText(String.format("%02d:%02d", Integer.valueOf(i5 / 60), Integer.valueOf(i5 % 60)));
                    mainActivityDecode4.q.setVisibility(0);
                } else {
                    mainActivityDecode4.q.setVisibility(4);
                }
                MusicInfo musicInfo = mainActivityDecode4.S0;
                if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path) && i5 == mainActivityDecode4.S0.value) {
                    mainActivityDecode4.D.performClick();
                    return;
                } else {
                    mainActivityDecode4.A1.postDelayed(mainActivityDecode4.f677z1, 500L);
                    return;
                }
        }
    }
}

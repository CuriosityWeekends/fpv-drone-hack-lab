package t2;

import android.content.Intent;
import android.util.Log;
import com.lg.picturesubmitt.activity.FileDirActivity;
import com.lg.picturesubmitt.activity.MainActivityNew;
import com.lg.picturesubmitt.activity.MusicActivity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class v implements g3.d, e3.b, d4.f, r2.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3718a;
    public final /* synthetic */ MainActivityNew b;

    public /* synthetic */ v(MainActivityNew mainActivityNew, int i3) {
        this.f3718a = i3;
        this.b = mainActivityNew;
    }

    @Override // g3.d
    public void a() {
        Log.d("MainActivityNew", "手势录像");
        this.b.f745z1.sendEmptyMessage(9);
    }

    @Override // e3.b
    public void b() {
        switch (this.f3718a) {
            case 1:
                if (this.b.f691g0) {
                    this.b.D.performClick();
                }
                this.b.m();
                return;
            case 2:
            case 4:
            default:
                if (this.b.f691g0) {
                    this.b.D.performClick();
                }
                MainActivityNew mainActivityNew = this.b;
                mainActivityNew.getClass();
                mainActivityNew.startActivity(new Intent(mainActivityNew, FileDirActivity.class));
                return;
            case 3:
                if (this.b.f691g0) {
                    this.b.D.performClick();
                }
                this.b.startActivityForResult(new Intent(this.b, MusicActivity.class), 1);
                return;
            case 5:
                if (this.b.f691g0) {
                    this.b.D.performClick();
                }
                this.b.m();
                return;
        }
    }

    @Override // r2.a
    public void c(float f4, float f5) {
        float f6 = ((f4 / 100.0f) * 4.0f) + 1.0f;
        Log.d("MainActivityNew", "onRangeChanged--leftValue=" + f6 + "  rightValue=" + f5);
        this.b.W.setScaleValue(f6);
    }

    @Override // d4.f
    public void d(int i3) {
        a1.i.x("sensitive--sensitive=", i3, "MainActivityNew");
        this.b.K1 = i3;
    }

    @Override // g3.d
    public void e() {
        Log.d("MainActivityNew", "手势拍照");
        this.b.f745z1.sendEmptyMessage(8);
    }
}

package t2;

import android.content.Intent;
import android.util.Log;
import com.lg.picturesubmitt.activity.FileDirActivity;
import com.lg.picturesubmitt.activity.MusicActivity;
import com.lg.picturesubmitt.activity.TrinityActivity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k0 implements g3.d, e3.b, d4.f, r2.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3702a;
    public final /* synthetic */ TrinityActivity b;

    public /* synthetic */ k0(TrinityActivity trinityActivity, int i3) {
        this.f3702a = i3;
        this.b = trinityActivity;
    }

    @Override // g3.d
    public void a() {
        Log.d("TrinityActivity", "手势录像");
        this.b.f839j1.sendEmptyMessage(9);
    }

    @Override // e3.b
    public void b() {
        switch (this.f3702a) {
            case 1:
                if (this.b.f820c0) {
                    this.b.A.performClick();
                }
                this.b.l();
                return;
            case 15:
                if (this.b.f820c0) {
                    this.b.A.performClick();
                }
                this.b.startActivityForResult(new Intent(this.b, MusicActivity.class), 1);
                return;
            case 17:
                if (this.b.f820c0) {
                    this.b.A.performClick();
                }
                this.b.l();
                return;
            default:
                if (this.b.f820c0) {
                    this.b.A.performClick();
                }
                TrinityActivity trinityActivity = this.b;
                trinityActivity.getClass();
                trinityActivity.startActivity(new Intent(trinityActivity, FileDirActivity.class));
                return;
        }
    }

    @Override // r2.a
    public void c(float f4, float f5) {
        float f6 = ((f4 / 100.0f) * 4.0f) + 1.0f;
        Log.d("TrinityActivity", "onRangeChanged--leftValue=" + f6 + "  rightValue=" + f5);
        this.b.Q.setScaleValue(f6);
    }

    @Override // d4.f
    public void d(int i3) {
        switch (this.f3702a) {
            case 2:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f870u1 = i3;
                return;
            case 3:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[0] = (byte) i3;
                return;
            case 4:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[1] = (byte) i3;
                return;
            case 5:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[2] = (byte) i3;
                return;
            case 6:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[3] = (byte) i3;
                return;
            case 7:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[4] = (byte) i3;
                return;
            case 8:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[5] = (byte) i3;
                return;
            case 9:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[6] = (byte) i3;
                return;
            case 10:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[7] = (byte) i3;
                return;
            case 11:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[8] = (byte) i3;
                return;
            case 12:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[9] = (byte) i3;
                return;
            case 13:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[10] = (byte) i3;
                return;
            default:
                a1.i.x("sensitive--sensitive=", i3, "TrinityActivity");
                this.b.f850n0[11] = (byte) i3;
                return;
        }
    }

    @Override // g3.d
    public void e() {
        Log.d("TrinityActivity", "手势拍照");
        this.b.f839j1.sendEmptyMessage(8);
    }
}

package t2;

import android.widget.Toast;
import com.lg.picturesubmitt.activity.MainActivity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class g implements s2.f, x2.h, k4.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3694a;
    public final /* synthetic */ MainActivity b;

    public /* synthetic */ g(MainActivity mainActivity, int i3) {
        this.f3694a = i3;
        this.b = mainActivity;
    }

    @Override // k4.a
    public void accept(Object obj) {
        int i3 = MainActivity.J0;
        MainActivity mainActivity = this.b;
        mainActivity.getClass();
        if (((Boolean) obj).booleanValue()) {
            com.bumptech.glide.c.i(mainActivity, 2131689495);
            mainActivity.V = true;
            return;
        }
        Toast.makeText(mainActivity, mainActivity.getString(2131755289), 1).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    @Override // x2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.g.b(int, int):void");
    }

    @Override // s2.f
    public void c(int i3) {
        int i5;
        switch (this.f3694a) {
            case 0:
                MainActivity mainActivity = this.b;
                mainActivity.f573g = i3;
                int i6 = mainActivity.f596s0;
                int i7 = mainActivity.f576h0;
                if (i7 != 40) {
                    if (i7 == 70) {
                        if (i6 > 128) {
                            i6 = a1.i.c(i6, 128, 2, 128);
                        } else {
                            i6 = a1.i.y(128, i6, 2, 128);
                        }
                    }
                } else if (i6 > 128) {
                    i6 = a1.i.c(i6, 128, 3, 128);
                } else {
                    i6 = a1.i.y(128, i6, 3, 128);
                }
                if (i3 < 16) {
                    int i8 = (16 - i3) * 2;
                    if (i6 < i8) {
                        i5 = 0;
                    } else {
                        i5 = i6 - i8;
                    }
                } else {
                    int i9 = (i3 - 16) * 2;
                    if (255 - i6 < i9) {
                        i5 = 255;
                    } else {
                        i5 = i9 + i6;
                    }
                }
                mainActivity.f574g0[4] = (byte) i5;
                mainActivity.p("mLeftRocker");
                return;
            case 1:
                MainActivity mainActivity2 = this.b;
                mainActivity2.f575h = i3;
                mainActivity2.n(mainActivity2.f590o0, mainActivity2.f592p0);
                return;
            default:
                MainActivity mainActivity3 = this.b;
                mainActivity3.f577i = i3;
                mainActivity3.n(mainActivity3.f590o0, mainActivity3.f592p0);
                return;
        }
    }
}

package t2;

import android.content.Intent;
import android.view.View;
import com.lg.picturesubmitt.activity.ProtocolActivity;
import com.lg.picturesubmitt.activity.SettingActivity;
import com.lg.picturesubmitt.activity.SplashActivity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3696a;
    public final /* synthetic */ SplashActivity b;

    public /* synthetic */ h0(SplashActivity splashActivity, int i3) {
        this.f3696a = i3;
        this.b = splashActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3696a) {
            case 0:
                SplashActivity splashActivity = this.b;
                splashActivity.startActivity(new Intent(splashActivity, SettingActivity.class));
                return;
            default:
                SplashActivity splashActivity2 = this.b;
                splashActivity2.startActivity(new Intent(splashActivity2, ProtocolActivity.class));
                return;
        }
    }
}

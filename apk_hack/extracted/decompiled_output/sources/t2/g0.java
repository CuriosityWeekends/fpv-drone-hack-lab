package t2;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;
import com.lg.picturesubmitt.MyApplication;
import com.lg.picturesubmitt.activity.MainActivityDecode;
import com.lg.picturesubmitt.activity.MainActivityNew;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
import com.lg.picturesubmitt.activity.SplashActivity;
import com.lg.picturesubmitt.activity.TrinityActivity;
import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class g0 implements k4.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3695a;
    public final /* synthetic */ SplashActivity b;

    public /* synthetic */ g0(SplashActivity splashActivity, int i3) {
        this.f3695a = i3;
        this.b = splashActivity;
    }

    @Override // k4.a
    public final void accept(Object obj) {
        Intent intent;
        SplashActivity splashActivity = this.b;
        Boolean bool = (Boolean) obj;
        switch (this.f3695a) {
            case 0:
                int i3 = SplashActivity.f811i;
                splashActivity.getClass();
                if (bool.booleanValue()) {
                    NetworkInfo[] allNetworkInfo = ((ConnectivityManager) splashActivity.getApplicationContext().getSystemService("connectivity")).getAllNetworkInfo();
                    boolean z3 = false;
                    for (int i5 = 0; i5 < allNetworkInfo.length; i5++) {
                        if (allNetworkInfo[i5].getState() == NetworkInfo.State.CONNECTED) {
                            if (allNetworkInfo[i5].getType() == 0) {
                                z3 = false;
                            }
                            if (allNetworkInfo[i5].getType() == 1) {
                                z3 = true;
                            }
                        }
                    }
                    if (!z3) {
                        Toast.makeText(splashActivity, splashActivity.getResources().getString(2131755085), 1).show();
                    }
                    if (!splashActivity.c.isWifiEnabled()) {
                        splashActivity.c.setWifiEnabled(true);
                    }
                    int ipAddress = splashActivity.c.getConnectionInfo().getIpAddress();
                    String str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                    if (str.contains("192.168.27")) {
                        MyApplication.f542i = "192.168.27.1";
                        intent = new Intent(splashActivity, TrinityActivity.class);
                    } else if (str.contains("192.168.24")) {
                        MyApplication.f542i = "192.168.24.1";
                        intent = new Intent(splashActivity, MainActivityNew.class);
                    } else if (str.contains("172.16.11")) {
                        MyApplication.f542i = "172.16.11.1";
                        intent = new Intent(splashActivity, MainActivityRTSP.class);
                    } else {
                        if (str.contains("192.168.25")) {
                            MyApplication.f542i = "192.168.25.1";
                        } else {
                            MyApplication.f542i = "192.168.28.1";
                        }
                        intent = new Intent(splashActivity, MainActivityDecode.class);
                    }
                    Toast.makeText(splashActivity, "wifi ip=".concat(str), 1).show();
                    splashActivity.startActivity(intent);
                    return;
                }
                Toast.makeText(splashActivity, 2131755360, 1).show();
                return;
            default:
                int i6 = SplashActivity.f811i;
                splashActivity.getClass();
                if (bool.booleanValue()) {
                    File file = new File(splashActivity.b.f544a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    Log.d("SplashActivity", "已存在:" + splashActivity.b.f544a);
                    File file2 = new File(splashActivity.b.b);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    Log.d("SplashActivity", "已存在:" + splashActivity.b.b);
                    File file3 = new File(splashActivity.b.d);
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    Log.d("SplashActivity", "已存在:" + splashActivity.b.d);
                    File file4 = new File(splashActivity.b.c);
                    if (!file4.exists()) {
                        file4.mkdirs();
                    }
                    Log.d("SplashActivity", "已存在:" + splashActivity.b.c);
                    File file5 = new File(splashActivity.b.f545e);
                    if (!file5.exists()) {
                        file5.mkdirs();
                    }
                    Log.d("SplashActivity", "已存在:" + splashActivity.b.f545e);
                    SplashActivity.l(splashActivity, "music", splashActivity.b.f545e);
                    return;
                }
                Toast.makeText(splashActivity, splashActivity.getString(2131755289), 1).show();
                return;
        }
    }
}

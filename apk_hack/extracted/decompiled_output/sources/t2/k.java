package t2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.util.Log;
import com.lg.picturesubmitt.activity.MainActivity;
import com.lg.picturesubmitt.activity.MainActivityDecode;
import com.lg.picturesubmitt.activity.MainActivityNew;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
import com.lg.picturesubmitt.activity.TrinityActivity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3701a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k(int i3, Object obj) {
        this.f3701a = i3;
        this.b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.f3701a) {
            case 0:
                boolean equals = "android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction());
                MainActivity mainActivity = (MainActivity) this.b;
                if (equals) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    if (intExtra != 0) {
                        if (intExtra != 1) {
                            if (intExtra != 2) {
                                if (intExtra == 3) {
                                    Log.d("MainActivity", "wifi已经开启");
                                    return;
                                }
                                return;
                            }
                            Log.d("MainActivity", "wifi正在开启");
                            return;
                        }
                        mainActivity.q("wifi已经关闭，请连接设备wifi");
                        Log.d("MainActivity", "wifi已经关闭");
                        return;
                    }
                    Log.d("MainActivity", "wifi正在关闭");
                    return;
                } else if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                    NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (NetworkInfo.State.DISCONNECTED.equals(networkInfo.getState())) {
                        Log.d("MainActivity", "wifi连接已断开，请连接设备wifi");
                        s2.i iVar = mainActivity.L;
                        if (!iVar.f3529l) {
                            iVar.f3529l = true;
                        }
                        mainActivity.I.setVisibility(4);
                        return;
                    } else if (NetworkInfo.State.CONNECTED.equals(networkInfo.getState())) {
                        WifiInfo connectionInfo = mainActivity.f569e.getConnectionInfo();
                        mainActivity.q("wifi-->" + connectionInfo.getSSID());
                        mainActivity.I.setVisibility(0);
                        s2.i iVar2 = mainActivity.L;
                        iVar2.f3529l = false;
                        iVar2.d(true);
                        Log.d("MainActivity", "wifi已重连接");
                        return;
                    } else {
                        return;
                    }
                } else if (!"android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction()) && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Log.d("MainActivity", "wifi-CONNECTIVITY_CHANGE");
                    return;
                } else {
                    return;
                }
            case 1:
                boolean equals2 = "android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction());
                MainActivityDecode mainActivityDecode = (MainActivityDecode) this.b;
                if (equals2) {
                    int intExtra2 = intent.getIntExtra("wifi_state", 0);
                    if (intExtra2 != 0) {
                        if (intExtra2 != 1) {
                            if (intExtra2 != 2) {
                                if (intExtra2 == 3) {
                                    Log.d("MainActivityDecode", "wifi已经开启");
                                    return;
                                }
                                return;
                            }
                            Log.d("MainActivityDecode", "wifi正在开启");
                            return;
                        }
                        mainActivityDecode.y(mainActivityDecode.getString(2131755399));
                        Log.d("MainActivityDecode", "wifi已经关闭");
                        mainActivityDecode.Z0 = true;
                        return;
                    }
                    Log.d("MainActivityDecode", "wifi正在关闭");
                    return;
                } else if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                    NetworkInfo networkInfo2 = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (NetworkInfo.State.DISCONNECTED.equals(networkInfo2.getState())) {
                        Log.d("MainActivityDecode", "wifi连接已断开，请连接设备wifi");
                        return;
                    } else if (NetworkInfo.State.CONNECTED.equals(networkInfo2.getState())) {
                        String u5 = MainActivityDecode.u(mainActivityDecode.f619f.getConnectionInfo().getIpAddress());
                        Log.d("MainActivityDecode", "wifi已重连接");
                        if (u5.startsWith("192.168.28.") && mainActivityDecode.Z0) {
                            mainActivityDecode.m();
                        }
                        mainActivityDecode.Z0 = true;
                        return;
                    } else {
                        return;
                    }
                } else if (!"android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction()) && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Log.d("MainActivityDecode", "wifi-CONNECTIVITY_CHANGE");
                    return;
                } else {
                    return;
                }
            case 2:
                boolean equals3 = "android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction());
                MainActivityNew mainActivityNew = (MainActivityNew) this.b;
                if (equals3) {
                    int intExtra3 = intent.getIntExtra("wifi_state", 0);
                    if (intExtra3 != 0) {
                        if (intExtra3 != 1) {
                            if (intExtra3 != 2) {
                                if (intExtra3 == 3) {
                                    Log.d("MainActivityNew", "wifi已经开启");
                                    return;
                                }
                                return;
                            }
                            Log.d("MainActivityNew", "wifi正在开启");
                            return;
                        }
                        mainActivityNew.y(mainActivityNew.getString(2131755399));
                        Log.d("MainActivityNew", "wifi已经关闭");
                        mainActivityNew.Y0 = true;
                        return;
                    }
                    Log.d("MainActivityNew", "wifi正在关闭");
                    return;
                } else if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                    NetworkInfo networkInfo3 = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (NetworkInfo.State.DISCONNECTED.equals(networkInfo3.getState())) {
                        Log.d("MainActivityNew", "wifi连接已断开，请连接设备wifi");
                        return;
                    } else if (NetworkInfo.State.CONNECTED.equals(networkInfo3.getState())) {
                        String u6 = MainActivityNew.u(mainActivityNew.f687f.getConnectionInfo().getIpAddress());
                        Log.d("MainActivityNew", "wifi已重连接");
                        if (u6.startsWith("192.168.28.") && mainActivityNew.Y0) {
                            mainActivityNew.m();
                        }
                        mainActivityNew.Y0 = true;
                        return;
                    } else {
                        return;
                    }
                } else if (!"android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction()) && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Log.d("MainActivityNew", "wifi-CONNECTIVITY_CHANGE");
                    return;
                } else {
                    return;
                }
            case 3:
                boolean equals4 = "android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction());
                MainActivityRTSP mainActivityRTSP = (MainActivityRTSP) this.b;
                if (equals4) {
                    int intExtra4 = intent.getIntExtra("wifi_state", 0);
                    if (intExtra4 != 0) {
                        if (intExtra4 != 1) {
                            if (intExtra4 != 2) {
                                if (intExtra4 == 3) {
                                    Log.d("MainActivityRTSP", "wifi已经开启");
                                    return;
                                }
                                return;
                            }
                            Log.d("MainActivityRTSP", "wifi正在开启");
                            return;
                        }
                        mainActivityRTSP.C(mainActivityRTSP.getString(2131755399));
                        Log.d("MainActivityRTSP", "wifi已经关闭");
                        mainActivityRTSP.S0 = true;
                        return;
                    }
                    Log.d("MainActivityRTSP", "wifi正在关闭");
                    return;
                } else if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                    NetworkInfo networkInfo4 = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (NetworkInfo.State.DISCONNECTED.equals(networkInfo4.getState())) {
                        Log.d("MainActivityRTSP", "wifi连接已断开，请连接设备wifi");
                        return;
                    } else if (NetworkInfo.State.CONNECTED.equals(networkInfo4.getState())) {
                        String w = MainActivityRTSP.w(mainActivityRTSP.f756f.getConnectionInfo().getIpAddress());
                        Log.d("MainActivityRTSP", "wifi已重连接");
                        if (w.startsWith("192.168.28.") && mainActivityRTSP.S0) {
                            mainActivityRTSP.o();
                        }
                        mainActivityRTSP.S0 = true;
                        return;
                    } else {
                        return;
                    }
                } else if (!"android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction()) && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Log.d("MainActivityRTSP", "wifi-CONNECTIVITY_CHANGE");
                    return;
                } else {
                    return;
                }
            case 4:
                boolean equals5 = "android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction());
                TrinityActivity trinityActivity = (TrinityActivity) this.b;
                if (equals5) {
                    int intExtra5 = intent.getIntExtra("wifi_state", 0);
                    if (intExtra5 != 0) {
                        if (intExtra5 != 1) {
                            if (intExtra5 != 2) {
                                if (intExtra5 == 3) {
                                    Log.d("TrinityActivity", "wifi已经开启");
                                    return;
                                }
                                return;
                            }
                            Log.d("TrinityActivity", "wifi正在开启");
                            return;
                        }
                        trinityActivity.t(trinityActivity.getString(2131755399));
                        Log.d("TrinityActivity", "wifi已经关闭");
                        trinityActivity.N0 = true;
                        return;
                    }
                    Log.d("TrinityActivity", "wifi正在关闭");
                    return;
                } else if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                    NetworkInfo networkInfo5 = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (NetworkInfo.State.DISCONNECTED.equals(networkInfo5.getState())) {
                        Log.d("TrinityActivity", "wifi连接已断开，请连接设备wifi");
                        return;
                    } else if (NetworkInfo.State.CONNECTED.equals(networkInfo5.getState())) {
                        String q = TrinityActivity.q(trinityActivity.f823e.getConnectionInfo().getIpAddress());
                        Log.d("TrinityActivity", "wifi已重连接");
                        if (q.startsWith("192.168.28.") && trinityActivity.N0) {
                            trinityActivity.l();
                        }
                        trinityActivity.N0 = true;
                        return;
                    } else {
                        return;
                    }
                } else if (!"android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction()) && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    Log.d("TrinityActivity", "wifi-CONNECTIVITY_CHANGE");
                    return;
                } else {
                    return;
                }
            default:
                v.b bVar = (v.b) this.b;
                boolean z3 = bVar.c;
                bVar.c = v.b.j(context);
                if (z3 != ((v.b) this.b).c) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + ((v.b) this.b).c);
                    }
                    v.b bVar2 = (v.b) this.b;
                    c1.b bVar3 = bVar2.b;
                    if (bVar2.c) {
                        synchronized (((com.bumptech.glide.p) bVar3.c)) {
                            ((j0.b) bVar3.b).e();
                        }
                        return;
                    }
                    bVar3.getClass();
                    return;
                }
                return;
        }
    }
}

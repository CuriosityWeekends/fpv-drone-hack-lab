package com.tencent.bugly.proguard;

import android.util.Log;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1520a;
    public final boolean b;
    public final Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ r0(int i3, Object obj, Object obj2, boolean z3) {
        this.f1520a = i3;
        this.d = obj;
        this.c = obj2;
        this.b = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1520a) {
            case 0:
                r rVar = (r) this.d;
                if (r.a(rVar)) {
                    UserInfoBean userInfoBean = (UserInfoBean) this.c;
                    if (userInfoBean != null) {
                        try {
                            r.a(userInfoBean);
                            al.c("[UserInfo] Record user info.", new Object[0]);
                            r.a(rVar, userInfoBean, false);
                        } catch (Throwable th) {
                            if (!al.a(th)) {
                                th.printStackTrace();
                                return;
                            }
                            return;
                        }
                    }
                    if (this.b) {
                        rVar.b();
                        return;
                    }
                    return;
                }
                return;
            default:
                byte[] bArr = (byte[]) this.c;
                s2.h hVar = (s2.h) this.d;
                DatagramSocket datagramSocket = hVar.b;
                if (datagramSocket != null && !datagramSocket.isClosed()) {
                    try {
                        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, hVar.c, hVar.f3517a);
                        if (this.b) {
                            Log.d("UDPClient_Control", "设置光流属性指令  " + ((int) bArr[3]) + " length=" + bArr.length);
                        } else {
                            Log.d("UDPClient_Control", "读取光流属性指令  " + ((int) bArr[3]) + " length=" + bArr.length);
                        }
                        hVar.b.send(datagramPacket);
                        return;
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        Log.d("UDPClient_Control", "设置或者读取光流属性指令发送异常");
                        return;
                    }
                }
                return;
        }
    }
}

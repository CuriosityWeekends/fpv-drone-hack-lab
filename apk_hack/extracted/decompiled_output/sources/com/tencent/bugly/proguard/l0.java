package com.tencent.bugly.proguard;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.lg.picturesubmitt.MyApplication;
import com.lg.picturesubmitt.activity.TrinityActivity;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ag;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l0 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1506a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l0(int i3, Object obj) {
        this.f1506a = i3;
        this.b = obj;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ag agVar;
        ArrayList arrayList;
        DatagramSocket datagramSocket;
        switch (this.f1506a) {
            case 0:
                at atVar = (at) this.b;
                if (ap.a(at.b(atVar), "local_crash_lock")) {
                    agVar = ag.a.f1266a;
                    List<ag.b> a5 = ag.a();
                    if (a5 != null && !a5.isEmpty()) {
                        al.c("sla load local data list size:%s", Integer.valueOf(a5.size()));
                        Iterator<ag.b> it = a5.iterator();
                        ArrayList arrayList2 = new ArrayList();
                        while (it.hasNext()) {
                            ag.b next = it.next();
                            if (next.b < ap.b() - 604800000) {
                                al.c("sla local data is expired:%s", next.c);
                                arrayList2.add(next);
                                it.remove();
                            }
                        }
                        ag.d(arrayList2);
                        agVar.b(a5);
                    } else {
                        al.c("sla local data is null", new Object[0]);
                    }
                    List<CrashDetailBean> a6 = as.a();
                    if (a6 != null && a6.size() > 0) {
                        al.c("Size of crash list: %s", Integer.valueOf(a6.size()));
                        int size = a6.size();
                        if (size > 20) {
                            ArrayList arrayList3 = new ArrayList();
                            Collections.sort(a6);
                            for (int i3 = 0; i3 < 20; i3++) {
                                arrayList3.add(a6.get((size - 1) - i3));
                            }
                            arrayList = arrayList3;
                        } else {
                            arrayList = a6;
                        }
                        atVar.s.a(arrayList, 0L, false, false, false);
                    } else {
                        al.c("no crash need to be uploaded at this start", new Object[0]);
                    }
                    ap.b(at.b(atVar), "local_crash_lock");
                    return;
                }
                al.c("Failed to lock file for uploading local crash.", new Object[0]);
                return;
            case 1:
                Process.setThreadPriority(9);
                if (((l.a) this.b).b) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                    return;
                } catch (Throwable th) {
                    if (Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                        return;
                    }
                    return;
                }
            case 2:
                s1.c cVar = (s1.c) this.b;
                cVar.getClass();
                do {
                    try {
                    } catch (InterruptedException e5) {
                        throw new IllegalStateException(e5);
                    }
                } while (cVar.g());
                return;
            case 3:
                DatagramPacket datagramPacket = new DatagramPacket(new byte[1500], 1500);
                while (!((s2.i) this.b).f3525h) {
                    try {
                        s2.i iVar = (s2.i) this.b;
                        if (!iVar.f3529l && (datagramSocket = iVar.b) != null && !datagramSocket.isClosed()) {
                            ((s2.i) this.b).b.receive(datagramPacket);
                            if (datagramPacket.getPort() == 7070) {
                                ((s2.i) this.b).f3522e.j(datagramPacket.getData(), datagramPacket.getLength());
                            } else if (datagramPacket.getPort() == 7080) {
                                ((s2.i) this.b).f3528k.e(datagramPacket.getData(), datagramPacket.getLength());
                            }
                            Log.d("i", "recvPacket.getLength()=" + datagramPacket.getLength() + " recvPacket.getData().length=" + datagramPacket.getData().length + " port=" + datagramPacket.getPort());
                            datagramPacket = new DatagramPacket(new byte[1500], 1500);
                        }
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        Log.d("i", "图片接收异常timeFault=" + ((s2.i) this.b).f3526i + " isFinishThread=" + ((s2.i) this.b).f3525h + " stopUdp=" + ((s2.i) this.b).f3529l);
                        if (!((s2.i) this.b).f3525h) {
                            s2.i iVar2 = (s2.i) this.b;
                            int i5 = iVar2.f3526i + 1;
                            iVar2.f3526i = i5;
                            if (i5 <= 5) {
                                s2.j jVar = iVar2.f3523f;
                                jVar.b(1, ((s2.i) this.b).c.getResources().getString(2131755337) + e6.getMessage() + ((s2.i) this.b).f3524g.isAlive() + ((s2.i) this.b).f3524g.isDaemon() + ((s2.i) this.b).f3524g.isInterrupted());
                            } else {
                                iVar2.f3523f.b(1, iVar2.c.getResources().getString(2131755336));
                            }
                        }
                    }
                }
                Log.d("i", "图片接收线程-循环-执行完");
                return;
        }
        while (true) {
            TrinityActivity trinityActivity = (TrinityActivity) this.b;
            if (!trinityActivity.f831g1) {
                if (trinityActivity.f828f1) {
                    trinityActivity.d.sendControlDataXL(trinityActivity.f847m0);
                }
                try {
                    Thread.sleep(MyApplication.f543j);
                } catch (InterruptedException e7) {
                    e7.printStackTrace();
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(l.a aVar, Runnable runnable, String str) {
        super(runnable, str);
        this.f1506a = 1;
        this.b = aVar;
    }
}

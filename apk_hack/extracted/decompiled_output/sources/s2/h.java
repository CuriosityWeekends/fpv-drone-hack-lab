package s2;

import android.util.Log;
import com.lg.picturesubmitt.MyApplication;
import com.tencent.bugly.proguard.r0;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f3517a;
    public DatagramSocket b;
    public InetAddress c;
    public volatile boolean d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f3518e = true;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3519f = {-52, 90, 1, -125, 9, 102, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, 0, 0, -103, 0};

    public h() {
        this.b = null;
        this.c = null;
        Log.d("UDPClient_Control", "init");
        this.f3517a = 7080;
        try {
            InetAddress byName = InetAddress.getByName(MyApplication.f542i);
            this.c = byName;
            Log.d("UDPClient_Control本机ip：", byName.getHostAddress());
            this.b = new DatagramSocket(7060);
            new g(this, 1).start();
            new g(this, 0).start();
            Log.d("UDPClient_Control", "启动发送指令的线程");
        } catch (SocketException e5) {
            e5.printStackTrace();
        } catch (UnknownHostException e6) {
            e6.printStackTrace();
        }
    }

    public final void a() {
        Log.d("UDPClient_Control", "close");
        this.f3518e = true;
        this.d = true;
        try {
            DatagramSocket datagramSocket = this.b;
            if (datagramSocket != null && !datagramSocket.isClosed()) {
                this.b.close();
            }
            this.b = null;
        } catch (Exception unused) {
        }
    }

    public final void b(boolean z3, byte[] bArr) {
        new Thread(new r0(1, this, bArr, z3)).start();
    }

    public final void c(boolean z3) {
        Log.d("UDPClient_Control", "setStopSendUdp=" + z3);
        this.f3518e = z3;
    }

    public final void d(byte[] bArr) {
        StringBuilder sb = new StringBuilder("updataData---");
        sb.append((int) this.f3519f[11]);
        sb.append("---");
        a1.i.u(sb, this.f3519f[13], "UDPClient_Control");
        this.f3519f = bArr;
    }
}

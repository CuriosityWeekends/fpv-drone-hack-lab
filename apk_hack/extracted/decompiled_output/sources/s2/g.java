package s2;

import android.util.Log;
import com.lg.picturesubmitt.MyApplication;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3516a;
    public final /* synthetic */ h b;

    public /* synthetic */ g(h hVar, int i3) {
        this.f3516a = i3;
        this.b = hVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch (this.f3516a) {
            case 0:
                DatagramPacket datagramPacket = new DatagramPacket(new byte[20], 20);
                Log.d("UDPClient_Control", "启动接收");
                while (!this.b.d) {
                    try {
                        DatagramSocket datagramSocket = this.b.b;
                        if (datagramSocket != null && !datagramSocket.isClosed()) {
                            Log.d("UDPClient_Control", "开始接收");
                            this.b.b.receive(datagramPacket);
                            Log.d("UDPClient_Control", "recvPacket.getLength()=" + datagramPacket.getLength() + " recvPacket.getData().length=" + datagramPacket.getData().length + " port=" + datagramPacket.getPort());
                            Log.d("UDPClient_Control", "收到数据");
                            datagramPacket = new DatagramPacket(new byte[20], 20);
                        }
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return;
                    }
                }
                return;
        }
        while (!this.b.d) {
            if (!this.b.f3518e) {
                try {
                    DatagramSocket datagramSocket2 = this.b.b;
                    if (datagramSocket2 != null && !datagramSocket2.isClosed()) {
                        Log.d("UDPClient_Control", "发送控制data.length=" + this.b.f3519f.length);
                        h hVar = this.b;
                        byte[] bArr = hVar.f3519f;
                        this.b.b.send(new DatagramPacket(bArr, bArr.length, hVar.c, hVar.f3517a));
                    }
                    Thread.sleep(MyApplication.f543j);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    Log.d("UDPClient_Control", "发送指令异常");
                }
            }
        }
        Log.d("UDPClient_Control", "发送线程结束");
    }
}

package s2;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.lg.picturesubmitt.MyApplication;
import com.tencent.bugly.proguard.c0;
import com.tencent.bugly.proguard.l0;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ int f3520m = 0;

    /* renamed from: a  reason: collision with root package name */
    public final int f3521a;
    public final Context c;
    public InetAddress d;

    /* renamed from: e  reason: collision with root package name */
    public final a f3522e;

    /* renamed from: f  reason: collision with root package name */
    public final j f3523f;

    /* renamed from: g  reason: collision with root package name */
    public l0 f3524g;

    /* renamed from: k  reason: collision with root package name */
    public final e f3528k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3529l;
    public DatagramSocket b = null;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f3525h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f3526i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f3527j = 0;

    public i(Context context, a aVar, j jVar, e eVar) {
        this.d = null;
        Log.d("i", "初始化");
        this.c = context;
        this.f3522e = aVar;
        this.f3528k = eVar;
        this.f3523f = jVar;
        this.f3521a = 7080;
        this.f3524g = new l0(3, this);
        try {
            this.d = InetAddress.getByName(MyApplication.f542i);
        } catch (UnknownHostException e5) {
            e5.printStackTrace();
            jVar.b(2, context.getResources().getString(2131755340));
        }
        b();
    }

    public final void a() {
        this.f3529l = true;
        this.f3525h = true;
        try {
            DatagramSocket datagramSocket = this.b;
            if (datagramSocket != null) {
                if (!datagramSocket.isClosed()) {
                    this.b.close();
                }
                this.b.disconnect();
                this.b = null;
                Log.d("i", "关闭通道close()--完成");
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void b() {
        j jVar = this.f3523f;
        DatagramSocket datagramSocket = this.b;
        if (datagramSocket != null) {
            if (datagramSocket != null && !datagramSocket.isClosed()) {
                this.b.close();
            }
            this.b = null;
        }
        try {
            try {
                this.b = new DatagramSocket(7070);
                if (this.f3527j < 3) {
                    return;
                }
            } catch (SocketException e5) {
                e5.printStackTrace();
                Log.d("i", "图片socket异常");
                jVar.b(3, this.c.getResources().getString(2131755338));
                int i3 = this.f3527j + 1;
                this.f3527j = i3;
                if (i3 < 3) {
                    return;
                }
            }
            jVar.b(5, "连接失败，页面关闭后请重试");
        } catch (Throwable th) {
            if (this.f3527j >= 3) {
                jVar.b(5, "连接失败，页面关闭后请重试");
            }
            throw th;
        }
    }

    public final void c() {
        if (this.b == null) {
            b();
        }
        if (this.b == null) {
            Toast.makeText(this.c, "启动接收图片线程失败，请关闭页面后重试", 0).show();
            return;
        }
        l0 l0Var = this.f3524g;
        if (l0Var == null || !l0Var.isAlive()) {
            l0 l0Var2 = new l0(3, this);
            this.f3524g = l0Var2;
            l0Var2.start();
            Log.d("i", "启动接收图片线程");
        }
    }

    public final void d(boolean z3) {
        byte[] bArr = z3 ? new byte[]{-52, 90, 1, -126, 2, 54, -73} : new byte[]{-52, 90, 1, -126, 2, 55, -74};
        if (this.b == null) {
            b();
        }
        if (this.b == null) {
            Toast.makeText(this.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
        } else {
            new Thread(new c0(7, this, bArr)).start();
        }
    }

    public final void e() {
        byte[] bArr = {-52, 90, 1, -126, 2, 56, -71};
        if (this.b == null) {
            Toast.makeText(this.c, "sendSW_CMD()通道异常，请关闭页面后重试", 0).show();
        } else {
            new Thread(new c0(7, this, bArr)).start();
        }
    }
}

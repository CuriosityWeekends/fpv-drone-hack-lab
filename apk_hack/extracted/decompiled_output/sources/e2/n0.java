package e2;

import android.net.Uri;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n0 extends e {

    /* renamed from: a  reason: collision with root package name */
    public final int f1706a;
    public final byte[] b;
    public final DatagramPacket c;
    public Uri d;

    /* renamed from: e  reason: collision with root package name */
    public DatagramSocket f1707e;

    /* renamed from: f  reason: collision with root package name */
    public MulticastSocket f1708f;

    /* renamed from: g  reason: collision with root package name */
    public InetAddress f1709g;

    /* renamed from: h  reason: collision with root package name */
    public InetSocketAddress f1710h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1711i;

    /* renamed from: j  reason: collision with root package name */
    public int f1712j;

    public n0() {
        super(true);
        this.f1706a = 8000;
        byte[] bArr = new byte[GSYVideoView.CHANGE_DELAY_TIME];
        this.b = bArr;
        this.c = new DatagramPacket(bArr, 0, (int) GSYVideoView.CHANGE_DELAY_TIME);
    }

    @Override // e2.i
    public final void close() {
        this.d = null;
        MulticastSocket multicastSocket = this.f1708f;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.f1709g);
            } catch (IOException unused) {
            }
            this.f1708f = null;
        }
        DatagramSocket datagramSocket = this.f1707e;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f1707e = null;
        }
        this.f1709g = null;
        this.f1710h = null;
        this.f1712j = 0;
        if (this.f1711i) {
            this.f1711i = false;
            transferEnded();
        }
    }

    @Override // e2.i
    public final Uri getUri() {
        return this.d;
    }

    @Override // e2.i
    public final long open(l lVar) {
        Uri uri = lVar.f1694a;
        this.d = uri;
        String host = uri.getHost();
        int port = this.d.getPort();
        transferInitializing(lVar);
        try {
            this.f1709g = InetAddress.getByName(host);
            this.f1710h = new InetSocketAddress(this.f1709g, port);
            if (this.f1709g.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.f1710h);
                this.f1708f = multicastSocket;
                multicastSocket.joinGroup(this.f1709g);
                this.f1707e = this.f1708f;
            } else {
                this.f1707e = new DatagramSocket(this.f1710h);
            }
            try {
                this.f1707e.setSoTimeout(this.f1706a);
                this.f1711i = true;
                transferStarted(lVar);
                return -1L;
            } catch (SocketException e5) {
                throw new IOException(e5);
            }
        } catch (IOException e6) {
            throw new IOException(e6);
        }
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        if (i5 == 0) {
            return 0;
        }
        int i6 = this.f1712j;
        DatagramPacket datagramPacket = this.c;
        if (i6 == 0) {
            try {
                this.f1707e.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.f1712j = length;
                bytesTransferred(length);
            } catch (IOException e5) {
                throw new IOException(e5);
            }
        }
        int length2 = datagramPacket.getLength();
        int i7 = this.f1712j;
        int min = Math.min(i7, i5);
        System.arraycopy(this.b, length2 - i7, bArr, i3, min);
        this.f1712j -= min;
        return min;
    }
}

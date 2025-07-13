package o0;

import android.net.Uri;
import e2.e;
import e2.l;
import g2.w;
import j0.z;
import net.butterflytv.rtmp_client.RtmpClient;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends e {
    public static final /* synthetic */ int c = 0;

    /* renamed from: a  reason: collision with root package name */
    public RtmpClient f2954a;
    public Uri b;

    static {
        z.a("goog.exo.rtmp");
    }

    public a() {
        super(true);
    }

    @Override // e2.i
    public final void close() {
        if (this.b != null) {
            this.b = null;
            transferEnded();
        }
        RtmpClient rtmpClient = this.f2954a;
        if (rtmpClient != null) {
            rtmpClient.a();
            this.f2954a = null;
        }
    }

    @Override // e2.i
    public final Uri getUri() {
        return this.b;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, net.butterflytv.rtmp_client.RtmpClient] */
    @Override // e2.i
    public final long open(l lVar) {
        transferInitializing(lVar);
        ?? obj = new Object();
        obj.f2949a = 0L;
        this.f2954a = obj;
        obj.b(lVar.f1694a.toString());
        this.b = lVar.f1694a;
        transferStarted(lVar);
        return -1L;
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        RtmpClient rtmpClient = this.f2954a;
        int i6 = w.f1960a;
        int c5 = rtmpClient.c(bArr, i3, i5);
        if (c5 == -1) {
            return -1;
        }
        bytesTransferred(c5);
        return c5;
    }
}

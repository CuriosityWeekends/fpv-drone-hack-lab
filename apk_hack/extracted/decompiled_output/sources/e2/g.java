package e2;

import android.net.Uri;
import android.util.Base64;
import java.io.IOException;
import java.net.URLDecoder;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends e {

    /* renamed from: a  reason: collision with root package name */
    public l f1687a;
    public byte[] b;
    public int c;
    public int d;

    @Override // e2.i
    public final void close() {
        if (this.b != null) {
            this.b = null;
            transferEnded();
        }
        this.f1687a = null;
    }

    @Override // e2.i
    public final Uri getUri() {
        l lVar = this.f1687a;
        if (lVar != null) {
            return lVar.f1694a;
        }
        return null;
    }

    @Override // e2.i
    public final long open(l lVar) {
        int length;
        transferInitializing(lVar);
        this.f1687a = lVar;
        this.d = (int) lVar.f1696f;
        Uri uri = lVar.f1694a;
        String scheme = uri.getScheme();
        if ("data".equals(scheme)) {
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            int i3 = g2.w.f1960a;
            String[] split = schemeSpecificPart.split(",", -1);
            if (split.length == 2) {
                String str = split[1];
                if (split[0].contains(";base64")) {
                    try {
                        this.b = Base64.decode(str, 0);
                    } catch (IllegalArgumentException e5) {
                        throw new IOException(a1.i.w("Error while parsing Base64 encoded string: ", str), e5);
                    }
                } else {
                    this.b = g2.w.r(URLDecoder.decode(str, "US-ASCII"));
                }
                long j2 = lVar.f1697g;
                if (j2 != -1) {
                    length = ((int) j2) + this.d;
                } else {
                    length = this.b.length;
                }
                this.c = length;
                if (length <= this.b.length && this.d <= length) {
                    transferStarted(lVar);
                    return this.c - this.d;
                }
                this.b = null;
                throw new j();
            }
            throw new IOException("Unexpected URI format: " + uri);
        }
        throw new IOException(a1.i.w("Unsupported scheme: ", scheme));
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        if (i5 == 0) {
            return 0;
        }
        int i6 = this.c - this.d;
        if (i6 == 0) {
            return -1;
        }
        int min = Math.min(i5, i6);
        byte[] bArr2 = this.b;
        int i7 = g2.w.f1960a;
        System.arraycopy(bArr2, this.d, bArr, i3, min);
        this.d += min;
        bytesTransferred(min);
        return min;
    }
}

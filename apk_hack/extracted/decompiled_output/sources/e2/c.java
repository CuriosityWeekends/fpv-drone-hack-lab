package e2;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f1680a;
    public Uri b;
    public InputStream c;
    public long d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1681e;

    public c(Context context) {
        super(false);
        this.f1680a = context.getAssets();
    }

    @Override // e2.i
    public final void close() {
        this.b = null;
        try {
            try {
                InputStream inputStream = this.c;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e5) {
                throw new IOException(e5);
            }
        } finally {
            this.c = null;
            if (this.f1681e) {
                this.f1681e = false;
                transferEnded();
            }
        }
    }

    @Override // e2.i
    public final Uri getUri() {
        return this.b;
    }

    @Override // e2.i
    public final long open(l lVar) {
        try {
            Uri uri = lVar.f1694a;
            long j2 = lVar.f1696f;
            this.b = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            transferInitializing(lVar);
            InputStream open = this.f1680a.open(path, 1);
            this.c = open;
            if (open.skip(j2) >= j2) {
                long j5 = lVar.f1697g;
                if (j5 != -1) {
                    this.d = j5;
                } else {
                    long available = this.c.available();
                    this.d = available;
                    if (available == 2147483647L) {
                        this.d = -1L;
                    }
                }
                this.f1681e = true;
                transferStarted(lVar);
                return this.d;
            }
            throw new EOFException();
        } catch (IOException e5) {
            throw new IOException(e5);
        }
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.d;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i5 = (int) Math.min(j2, i5);
            } catch (IOException e5) {
                throw new IOException(e5);
            }
        }
        InputStream inputStream = this.c;
        int i6 = g2.w.f1960a;
        int read = inputStream.read(bArr, i3, i5);
        if (read == -1) {
            if (this.d == -1) {
                return -1;
            }
            throw new IOException(new EOFException());
        }
        long j5 = this.d;
        if (j5 != -1) {
            this.d = j5 - read;
        }
        bytesTransferred(read);
        return read;
    }
}

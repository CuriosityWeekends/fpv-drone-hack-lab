package e2;

import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class u extends e {

    /* renamed from: a  reason: collision with root package name */
    public RandomAccessFile f1753a;
    public Uri b;
    public long c;
    public boolean d;

    public static RandomAccessFile a(Uri uri) {
        try {
            String path = uri.getPath();
            path.getClass();
            return new RandomAccessFile(path, "r");
        } catch (FileNotFoundException e5) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new IOException(e5);
            }
            String path2 = uri.getPath();
            String query = uri.getQuery();
            String fragment = uri.getFragment();
            throw new IOException("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=" + path2 + ",query=" + query + ",fragment=" + fragment, e5);
        }
    }

    @Override // e2.i
    public final void close() {
        this.b = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f1753a;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e5) {
                throw new IOException(e5);
            }
        } finally {
            this.f1753a = null;
            if (this.d) {
                this.d = false;
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
            transferInitializing(lVar);
            RandomAccessFile a5 = a(uri);
            this.f1753a = a5;
            a5.seek(j2);
            long j5 = lVar.f1697g;
            if (j5 == -1) {
                j5 = this.f1753a.length() - j2;
            }
            this.c = j5;
            if (j5 >= 0) {
                this.d = true;
                transferStarted(lVar);
                return this.c;
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
        long j2 = this.c;
        if (j2 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f1753a;
            int i6 = g2.w.f1960a;
            int read = randomAccessFile.read(bArr, i3, (int) Math.min(j2, i5));
            if (read > 0) {
                this.c -= read;
                bytesTransferred(read);
            }
            return read;
        } catch (IOException e5) {
            throw new IOException(e5);
        }
    }
}

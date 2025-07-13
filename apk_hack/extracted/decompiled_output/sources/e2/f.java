package e2;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f extends e {

    /* renamed from: a  reason: collision with root package name */
    public final ContentResolver f1682a;
    public Uri b;
    public AssetFileDescriptor c;
    public FileInputStream d;

    /* renamed from: e  reason: collision with root package name */
    public long f1683e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1684f;

    public f(Context context) {
        super(false);
        this.f1682a = context.getContentResolver();
    }

    @Override // e2.i
    public final void close() {
        this.b = null;
        try {
            try {
                FileInputStream fileInputStream = this.d;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.d = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.c;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.c = null;
                        if (this.f1684f) {
                            this.f1684f = false;
                            transferEnded();
                        }
                    }
                } catch (IOException e5) {
                    throw new IOException(e5);
                }
            } catch (Throwable th) {
                this.d = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.c;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.c = null;
                        if (this.f1684f) {
                            this.f1684f = false;
                            transferEnded();
                        }
                        throw th;
                    } finally {
                        this.c = null;
                        if (this.f1684f) {
                            this.f1684f = false;
                            transferEnded();
                        }
                    }
                } catch (IOException e6) {
                    throw new IOException(e6);
                }
            }
        } catch (IOException e7) {
            throw new IOException(e7);
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
            AssetFileDescriptor openAssetFileDescriptor = this.f1682a.openAssetFileDescriptor(uri, "r");
            this.c = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.d = fileInputStream;
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(startOffset + j2) - startOffset;
                if (skip == j2) {
                    long j5 = lVar.f1697g;
                    long j6 = -1;
                    if (j5 != -1) {
                        this.f1683e = j5;
                    } else {
                        long length = openAssetFileDescriptor.getLength();
                        if (length == -1) {
                            FileChannel channel = fileInputStream.getChannel();
                            long size = channel.size();
                            if (size != 0) {
                                j6 = size - channel.position();
                            }
                            this.f1683e = j6;
                        } else {
                            this.f1683e = length - skip;
                        }
                    }
                    this.f1684f = true;
                    transferStarted(lVar);
                    return this.f1683e;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException("Could not open file descriptor for: " + uri);
        } catch (IOException e5) {
            throw new IOException(e5);
        }
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.f1683e;
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
        FileInputStream fileInputStream = this.d;
        int i6 = g2.w.f1960a;
        int read = fileInputStream.read(bArr, i3, i5);
        if (read == -1) {
            if (this.f1683e == -1) {
                return -1;
            }
            throw new IOException(new EOFException());
        }
        long j5 = this.f1683e;
        if (j5 != -1) {
            this.f1683e = j5 - read;
        }
        bytesTransferred(read);
        return read;
    }
}

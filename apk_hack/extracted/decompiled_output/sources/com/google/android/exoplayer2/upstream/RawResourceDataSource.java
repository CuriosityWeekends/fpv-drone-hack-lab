package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import e2.e;
import e2.l;
import g2.w;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class RawResourceDataSource extends e {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f494a;
    public Uri b;
    public AssetFileDescriptor c;
    public FileInputStream d;

    /* renamed from: e  reason: collision with root package name */
    public long f495e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f496f;

    public RawResourceDataSource(Context context) {
        super(false);
        this.f494a = context.getResources();
    }

    public static Uri buildRawResourceUri(int i3) {
        return Uri.parse("rawresource:///" + i3);
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
                        if (this.f496f) {
                            this.f496f = false;
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
                        if (this.f496f) {
                            this.f496f = false;
                            transferEnded();
                        }
                        throw th;
                    } finally {
                        this.c = null;
                        if (this.f496f) {
                            this.f496f = false;
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
            if (TextUtils.equals("rawresource", uri.getScheme())) {
                try {
                    String lastPathSegment = uri.getLastPathSegment();
                    lastPathSegment.getClass();
                    int parseInt = Integer.parseInt(lastPathSegment);
                    transferInitializing(lVar);
                    AssetFileDescriptor openRawResourceFd = this.f494a.openRawResourceFd(parseInt);
                    this.c = openRawResourceFd;
                    if (openRawResourceFd != null) {
                        FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                        this.d = fileInputStream;
                        fileInputStream.skip(openRawResourceFd.getStartOffset());
                        if (fileInputStream.skip(j2) >= j2) {
                            long j5 = lVar.f1697g;
                            long j6 = -1;
                            if (j5 != -1) {
                                this.f495e = j5;
                            } else {
                                long length = openRawResourceFd.getLength();
                                if (length != -1) {
                                    j6 = length - j2;
                                }
                                this.f495e = j6;
                            }
                            this.f496f = true;
                            transferStarted(lVar);
                            return this.f495e;
                        }
                        throw new EOFException();
                    }
                    throw new IOException("Resource is compressed: " + uri);
                } catch (NumberFormatException unused) {
                    throw new IOException("Resource identifier must be an integer.");
                }
            }
            throw new IOException("URI must use scheme rawresource");
        } catch (IOException e5) {
            throw new IOException(e5);
        }
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.f495e;
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
        int i6 = w.f1960a;
        int read = fileInputStream.read(bArr, i3, i5);
        if (read == -1) {
            if (this.f495e == -1) {
                return -1;
            }
            throw new IOException(new EOFException());
        }
        long j5 = this.f495e;
        if (j5 != -1) {
            this.f495e = j5 - read;
        }
        bytesTransferred(read);
        return read;
    }
}

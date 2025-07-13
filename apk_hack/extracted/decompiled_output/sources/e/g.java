package e;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f1667a;
    public final Charset b;
    public byte[] c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f1668e;

    public g(FileInputStream fileInputStream) {
        Charset charset = h.f1669a;
        if (charset != null) {
            if (charset.equals(charset)) {
                this.f1667a = fileInputStream;
                this.b = charset;
                this.c = new byte[8192];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw null;
    }

    public final String a() {
        int i3;
        synchronized (this.f1667a) {
            try {
                byte[] bArr = this.c;
                if (bArr != null) {
                    if (this.d >= this.f1668e) {
                        int read = this.f1667a.read(bArr, 0, bArr.length);
                        if (read != -1) {
                            this.d = 0;
                            this.f1668e = read;
                        } else {
                            throw new EOFException();
                        }
                    }
                    for (int i5 = this.d; i5 != this.f1668e; i5++) {
                        byte[] bArr2 = this.c;
                        if (bArr2[i5] == 10) {
                            int i6 = this.d;
                            if (i5 != i6) {
                                i3 = i5 - 1;
                                if (bArr2[i3] == 13) {
                                    String str = new String(bArr2, i6, i3 - i6, this.b.name());
                                    this.d = i5 + 1;
                                    return str;
                                }
                            }
                            i3 = i5;
                            String str2 = new String(bArr2, i6, i3 - i6, this.b.name());
                            this.d = i5 + 1;
                            return str2;
                        }
                    }
                    f fVar = new f(this, (this.f1668e - this.d) + 80);
                    while (true) {
                        byte[] bArr3 = this.c;
                        int i7 = this.d;
                        fVar.write(bArr3, i7, this.f1668e - i7);
                        this.f1668e = -1;
                        byte[] bArr4 = this.c;
                        int read2 = this.f1667a.read(bArr4, 0, bArr4.length);
                        if (read2 != -1) {
                            this.d = 0;
                            this.f1668e = read2;
                            for (int i8 = 0; i8 != this.f1668e; i8++) {
                                byte[] bArr5 = this.c;
                                if (bArr5[i8] == 10) {
                                    int i9 = this.d;
                                    if (i8 != i9) {
                                        fVar.write(bArr5, i9, i8 - i9);
                                    }
                                    this.d = i8 + 1;
                                    return fVar.toString();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                } else {
                    throw new IOException("LineReader is closed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f1667a) {
            try {
                if (this.c != null) {
                    this.c = null;
                    this.f1667a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

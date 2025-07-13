package com.bumptech.glide.load.data;

import java.io.FileOutputStream;
import java.io.OutputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final OutputStream f258a;
    public byte[] b;
    public final j.g c;
    public int d;

    public c(FileOutputStream fileOutputStream, j.g gVar) {
        this.f258a = fileOutputStream;
        this.c = gVar;
        this.b = (byte[]) gVar.d(byte[].class, 65536);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        OutputStream outputStream = this.f258a;
        try {
            flush();
            outputStream.close();
            byte[] bArr = this.b;
            if (bArr != null) {
                this.c.h(bArr);
                this.b = null;
            }
        } catch (Throwable th) {
            outputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        int i3 = this.d;
        OutputStream outputStream = this.f258a;
        if (i3 > 0) {
            outputStream.write(this.b, 0, i3);
            this.d = 0;
        }
        outputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i3) {
        byte[] bArr = this.b;
        int i5 = this.d;
        int i6 = i5 + 1;
        this.d = i6;
        bArr[i5] = (byte) i3;
        if (i6 != bArr.length || i6 <= 0) {
            return;
        }
        this.f258a.write(bArr, 0, i6);
        this.d = 0;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i3, int i5) {
        int i6 = 0;
        do {
            int i7 = i5 - i6;
            int i8 = i3 + i6;
            int i9 = this.d;
            OutputStream outputStream = this.f258a;
            if (i9 == 0 && i7 >= this.b.length) {
                outputStream.write(bArr, i8, i7);
                return;
            }
            int min = Math.min(i7, this.b.length - i9);
            System.arraycopy(bArr, i8, this.b, this.d, min);
            int i10 = this.d + min;
            this.d = i10;
            i6 += min;
            byte[] bArr2 = this.b;
            if (i10 == bArr2.length && i10 > 0) {
                outputStream.write(bArr2, 0, i10);
                this.d = 0;
                continue;
            }
        } while (i6 < i5);
    }
}

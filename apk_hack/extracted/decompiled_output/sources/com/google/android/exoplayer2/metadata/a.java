package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b1.b;
import b1.c;
import b1.d;
import b1.e;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g2.w;
import j0.h;
import j0.p0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends h implements Handler.Callback {

    /* renamed from: l  reason: collision with root package name */
    public final c f331l;

    /* renamed from: m  reason: collision with root package name */
    public final e f332m;

    /* renamed from: n  reason: collision with root package name */
    public final Handler f333n;

    /* renamed from: o  reason: collision with root package name */
    public final d f334o;

    /* renamed from: p  reason: collision with root package name */
    public final Metadata[] f335p;
    public final long[] q;

    /* renamed from: r  reason: collision with root package name */
    public int f336r;
    public int s;

    /* renamed from: t  reason: collision with root package name */
    public b f337t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f338u;

    /* renamed from: v  reason: collision with root package name */
    public long f339v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v4, types: [b1.d, m0.d] */
    public a(p0 p0Var, Looper looper) {
        super(4);
        Handler handler;
        c cVar = c.f125a;
        this.f332m = p0Var;
        if (looper == null) {
            handler = null;
        } else {
            int i3 = w.f1960a;
            handler = new Handler(looper, this);
        }
        this.f333n = handler;
        this.f331l = cVar;
        this.f334o = new m0.d(1);
        this.f335p = new Metadata[5];
        this.q = new long[5];
    }

    @Override // j0.h
    public final boolean h() {
        return this.f338u;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.f332m.onMetadata((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // j0.h
    public final boolean i() {
        return true;
    }

    @Override // j0.h
    public final void j() {
        Arrays.fill(this.f335p, (Object) null);
        this.f336r = 0;
        this.s = 0;
        this.f337t = null;
    }

    @Override // j0.h
    public final void l(long j2, boolean z3) {
        Arrays.fill(this.f335p, (Object) null);
        this.f336r = 0;
        this.s = 0;
        this.f338u = false;
    }

    @Override // j0.h
    public final void p(Format[] formatArr, long j2) {
        this.f337t = this.f331l.a(formatArr[0]);
    }

    @Override // j0.h
    public final void r(long j2, long j5) {
        boolean z3 = this.f338u;
        long[] jArr = this.q;
        Metadata[] metadataArr = this.f335p;
        if (!z3 && this.s < 5) {
            d dVar = this.f334o;
            dVar.clear();
            j0.b bVar = this.b;
            bVar.b();
            int q = q(bVar, dVar, false);
            if (q == -4) {
                if (dVar.isEndOfStream()) {
                    this.f338u = true;
                } else if (!dVar.isDecodeOnly()) {
                    dVar.f126f = this.f339v;
                    dVar.d();
                    b bVar2 = this.f337t;
                    int i3 = w.f1960a;
                    Metadata a5 = bVar2.a(dVar);
                    if (a5 != null) {
                        ArrayList arrayList = new ArrayList(a5.f330a.length);
                        w(a5, arrayList);
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata(arrayList);
                            int i5 = this.f336r;
                            int i6 = this.s;
                            int i7 = (i5 + i6) % 5;
                            metadataArr[i7] = metadata;
                            jArr[i7] = dVar.c;
                            this.s = i6 + 1;
                        }
                    }
                }
            } else if (q == -5) {
                Format format = (Format) bVar.d;
                format.getClass();
                this.f339v = format.f315m;
            }
        }
        if (this.s > 0) {
            int i8 = this.f336r;
            if (jArr[i8] <= j2) {
                Metadata metadata2 = metadataArr[i8];
                int i9 = w.f1960a;
                Handler handler = this.f333n;
                if (handler != null) {
                    handler.obtainMessage(0, metadata2).sendToTarget();
                } else {
                    this.f332m.onMetadata(metadata2);
                }
                int i10 = this.f336r;
                metadataArr[i10] = null;
                this.f336r = (i10 + 1) % 5;
                this.s--;
            }
        }
    }

    @Override // j0.h
    public final int u(Format format) {
        if (this.f331l.b(format)) {
            if (format.f314l == null) {
                return 4;
            }
            return 2;
        }
        return 0;
    }

    public final void w(Metadata metadata, ArrayList arrayList) {
        int i3 = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.f330a;
            if (i3 < entryArr.length) {
                Format a5 = entryArr[i3].a();
                if (a5 != null) {
                    c cVar = this.f331l;
                    if (cVar.b(a5)) {
                        b a6 = cVar.a(a5);
                        byte[] b = entryArr[i3].b();
                        b.getClass();
                        d dVar = this.f334o;
                        dVar.clear();
                        dVar.c(b.length);
                        ByteBuffer byteBuffer = dVar.b;
                        int i5 = w.f1960a;
                        byteBuffer.put(b);
                        dVar.d();
                        Metadata a7 = a6.a(dVar);
                        if (a7 != null) {
                            w(a7, arrayList);
                        }
                        i3++;
                    }
                }
                arrayList.add(entryArr[i3]);
                i3++;
            } else {
                return;
            }
        }
    }
}

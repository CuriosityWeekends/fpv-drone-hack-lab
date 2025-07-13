package f2;

import android.net.Uri;
import e2.l0;
import e2.m0;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements e2.i {

    /* renamed from: a  reason: collision with root package name */
    public final b f1810a;
    public final e2.i b;
    public final l0 c;
    public final e2.i d;

    /* renamed from: i  reason: collision with root package name */
    public e2.i f1815i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1816j;

    /* renamed from: k  reason: collision with root package name */
    public Uri f1817k;

    /* renamed from: l  reason: collision with root package name */
    public Uri f1818l;

    /* renamed from: m  reason: collision with root package name */
    public int f1819m;

    /* renamed from: n  reason: collision with root package name */
    public byte[] f1820n;

    /* renamed from: p  reason: collision with root package name */
    public int f1822p;
    public String q;

    /* renamed from: r  reason: collision with root package name */
    public long f1823r;
    public long s;

    /* renamed from: t  reason: collision with root package name */
    public r f1824t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1825u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1826v;
    public long w;

    /* renamed from: o  reason: collision with root package name */
    public Map f1821o = Collections.emptyMap();

    /* renamed from: e  reason: collision with root package name */
    public final a1.f f1811e = h.f1831a;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1812f = false;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f1813g = true;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1814h = false;

    public e(b bVar, e2.i iVar, e2.i iVar2, d dVar) {
        this.f1810a = bVar;
        this.b = iVar2;
        this.d = iVar;
        if (dVar != null) {
            this.c = new l0(iVar, dVar);
        } else {
            this.c = null;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [e2.i, f2.r] */
    public final void a() {
        b bVar = this.f1810a;
        e2.i iVar = this.f1815i;
        if (iVar == null) {
            return;
        }
        try {
            iVar.close();
        } finally {
            this.f1815i = null;
            this.f1816j = false;
            r rVar = this.f1824t;
            if (rVar != null) {
                ((q) bVar).k(rVar);
                this.f1824t = null;
            }
        }
    }

    @Override // e2.i
    public final void addTransferListener(m0 m0Var) {
        this.b.addTransferListener(m0Var);
        this.d.addTransferListener(m0Var);
    }

    public final void b(Throwable th) {
        if (this.f1815i == this.b || (th instanceof a)) {
            this.f1825u = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(boolean r23) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.e.c(boolean):void");
    }

    @Override // e2.i
    public final void close() {
        this.f1817k = null;
        this.f1818l = null;
        this.f1819m = 1;
        this.f1820n = null;
        this.f1821o = Collections.emptyMap();
        this.f1822p = 0;
        this.f1823r = 0L;
        this.q = null;
        try {
            a();
        } catch (Throwable th) {
            b(th);
            throw th;
        }
    }

    public final void d() {
        this.s = 0L;
        if (this.f1815i == this.c) {
            l lVar = new l(0);
            lVar.a(Long.valueOf(this.f1823r), "exo_len");
            ((q) this.f1810a).c(this.q, lVar);
        }
    }

    @Override // e2.i
    public final Map getResponseHeaders() {
        boolean z3;
        if (this.f1815i == this.b) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return this.d.getResponseHeaders();
        }
        return Collections.emptyMap();
    }

    @Override // e2.i
    public final Uri getUri() {
        return this.f1818l;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008f A[Catch: all -> 0x00b5, TryCatch #0 {all -> 0x00b5, blocks: (B:3:0x0002, B:7:0x0010, B:8:0x0014, B:10:0x002a, B:17:0x0047, B:20:0x0064, B:29:0x0074, B:33:0x007d, B:35:0x008f, B:37:0x009f, B:39:0x00a5, B:42:0x00af, B:43:0x00b4, B:47:0x00b9, B:46:0x00b7, B:23:0x0069, B:14:0x0040), top: B:51:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5 A[Catch: all -> 0x00b5, TryCatch #0 {all -> 0x00b5, blocks: (B:3:0x0002, B:7:0x0010, B:8:0x0014, B:10:0x002a, B:17:0x0047, B:20:0x0064, B:29:0x0074, B:33:0x007d, B:35:0x008f, B:37:0x009f, B:39:0x00a5, B:42:0x00af, B:43:0x00b4, B:47:0x00b9, B:46:0x00b7, B:23:0x0069, B:14:0x0040), top: B:51:0x0002 }] */
    @Override // e2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long open(e2.l r10) {
        /*
            r9 = this;
            f2.b r0 = r9.f1810a
            a1.f r1 = r9.f1811e     // Catch: java.lang.Throwable -> Lb5
            r1.getClass()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r1 = r10.f1698h     // Catch: java.lang.Throwable -> Lb5
            long r2 = r10.f1696f
            android.net.Uri r4 = r10.f1694a
            if (r1 == 0) goto L10
            goto L14
        L10:
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> Lb5
        L14:
            r9.q = r1     // Catch: java.lang.Throwable -> Lb5
            r9.f1817k = r4     // Catch: java.lang.Throwable -> Lb5
            r5 = r0
            f2.q r5 = (f2.q) r5     // Catch: java.lang.Throwable -> Lb5
            f2.m r1 = r5.g(r1)     // Catch: java.lang.Throwable -> Lb5
            java.util.Map r1 = r1.b     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r5 = "exo_redir"
            boolean r6 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> Lb5
            r7 = 0
            if (r6 == 0) goto L3c
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> Lb5
            byte[] r1 = (byte[]) r1     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch: java.lang.Throwable -> Lb5
            r5.<init>(r1, r6)     // Catch: java.lang.Throwable -> Lb5
            goto L3d
        L3c:
            r5 = r7
        L3d:
            if (r5 != 0) goto L40
            goto L44
        L40:
            android.net.Uri r7 = android.net.Uri.parse(r5)     // Catch: java.lang.Throwable -> Lb5
        L44:
            if (r7 == 0) goto L47
            r4 = r7
        L47:
            r9.f1818l = r4     // Catch: java.lang.Throwable -> Lb5
            int r1 = r10.b     // Catch: java.lang.Throwable -> Lb5
            r9.f1819m = r1     // Catch: java.lang.Throwable -> Lb5
            byte[] r1 = r10.c     // Catch: java.lang.Throwable -> Lb5
            r9.f1820n = r1     // Catch: java.lang.Throwable -> Lb5
            java.util.Map r1 = r10.d     // Catch: java.lang.Throwable -> Lb5
            r9.f1821o = r1     // Catch: java.lang.Throwable -> Lb5
            int r1 = r10.f1699i     // Catch: java.lang.Throwable -> Lb5
            r9.f1822p = r1     // Catch: java.lang.Throwable -> Lb5
            r9.f1823r = r2     // Catch: java.lang.Throwable -> Lb5
            boolean r1 = r9.f1813g     // Catch: java.lang.Throwable -> Lb5
            r4 = -1
            r6 = 0
            long r7 = r10.f1697g
            if (r1 == 0) goto L69
            boolean r10 = r9.f1825u     // Catch: java.lang.Throwable -> Lb5
            if (r10 == 0) goto L69
            goto L71
        L69:
            boolean r10 = r9.f1814h     // Catch: java.lang.Throwable -> Lb5
            if (r10 == 0) goto L73
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 != 0) goto L73
        L71:
            r10 = 1
            goto L74
        L73:
            r10 = 0
        L74:
            r9.f1826v = r10     // Catch: java.lang.Throwable -> Lb5
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 != 0) goto Lb7
            if (r10 == 0) goto L7d
            goto Lb7
        L7d:
            java.lang.String r10 = r9.q     // Catch: java.lang.Throwable -> Lb5
            f2.q r0 = (f2.q) r0     // Catch: java.lang.Throwable -> Lb5
            f2.m r10 = r0.g(r10)     // Catch: java.lang.Throwable -> Lb5
            java.util.Map r10 = r10.b     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = "exo_len"
            boolean r1 = r10.containsKey(r0)     // Catch: java.lang.Throwable -> Lb5
            if (r1 == 0) goto L9e
            java.lang.Object r10 = r10.get(r0)     // Catch: java.lang.Throwable -> Lb5
            byte[] r10 = (byte[]) r10     // Catch: java.lang.Throwable -> Lb5
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.wrap(r10)     // Catch: java.lang.Throwable -> Lb5
            long r0 = r10.getLong()     // Catch: java.lang.Throwable -> Lb5
            goto L9f
        L9e:
            r0 = r4
        L9f:
            r9.s = r0     // Catch: java.lang.Throwable -> Lb5
            int r10 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r10 == 0) goto Lb9
            long r0 = r0 - r2
            r9.s = r0     // Catch: java.lang.Throwable -> Lb5
            r2 = 0
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 <= 0) goto Laf
            goto Lb9
        Laf:
            e2.j r10 = new e2.j     // Catch: java.lang.Throwable -> Lb5
            r10.<init>()     // Catch: java.lang.Throwable -> Lb5
            throw r10     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            r10 = move-exception
            goto Lbf
        Lb7:
            r9.s = r7     // Catch: java.lang.Throwable -> Lb5
        Lb9:
            r9.c(r6)     // Catch: java.lang.Throwable -> Lb5
            long r0 = r9.s     // Catch: java.lang.Throwable -> Lb5
            return r0
        Lbf:
            r9.b(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.e.open(e2.l):long");
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        if (i5 == 0) {
            return 0;
        }
        if (this.s == 0) {
            return -1;
        }
        try {
            if (this.f1823r >= this.w) {
                c(true);
            }
            int read = this.f1815i.read(bArr, i3, i5);
            if (read != -1) {
                long j2 = read;
                this.f1823r += j2;
                long j5 = this.s;
                if (j5 != -1) {
                    this.s = j5 - j2;
                }
            } else if (this.f1816j) {
                d();
            } else {
                long j6 = this.s;
                if (j6 <= 0) {
                    if (j6 == -1) {
                    }
                }
                a();
                c(false);
                return read(bArr, i3, i5);
            }
            return read;
        } catch (IOException e5) {
            if (this.f1816j) {
                for (Throwable th = e5; th != null; th = th.getCause()) {
                    if ((th instanceof e2.j) && ((e2.j) th).f1690a == 0) {
                        d();
                        return -1;
                    }
                }
            }
            b(e5);
            throw e5;
        } catch (Throwable th2) {
            b(th2);
            throw th2;
        }
    }
}

package f2;

import g2.w;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f1803a;
    public final long b = 5242880;
    public final int c = 20480;
    public e2.l d;

    /* renamed from: e  reason: collision with root package name */
    public long f1804e;

    /* renamed from: f  reason: collision with root package name */
    public File f1805f;

    /* renamed from: g  reason: collision with root package name */
    public OutputStream f1806g;

    /* renamed from: h  reason: collision with root package name */
    public long f1807h;

    /* renamed from: i  reason: collision with root package name */
    public long f1808i;

    /* renamed from: j  reason: collision with root package name */
    public g2.p f1809j;

    public d(b bVar) {
        this.f1803a = bVar;
    }

    public final void a() {
        long j2;
        OutputStream outputStream = this.f1806g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            w.g(this.f1806g);
            this.f1806g = null;
            File file = this.f1805f;
            this.f1805f = null;
            long j5 = this.f1807h;
            q qVar = (q) this.f1803a;
            synchronized (qVar) {
                boolean z3 = true;
                g2.b.h(!qVar.f1851h);
                if (file.exists()) {
                    if (j5 == 0) {
                        file.delete();
                        return;
                    }
                    r b = r.b(file, j5, qVar.c);
                    b.getClass();
                    i b5 = qVar.c.b(b.f1828a);
                    b5.getClass();
                    g2.b.h(b5.f1833e);
                    Map map = b5.d.b;
                    if (map.containsKey("exo_len")) {
                        j2 = ByteBuffer.wrap((byte[]) map.get("exo_len")).getLong();
                    } else {
                        j2 = -1;
                    }
                    if (j2 != -1) {
                        if (b.b + b.c > j2) {
                            z3 = false;
                        }
                        g2.b.h(z3);
                    }
                    qVar.b(b);
                    try {
                        qVar.c.f();
                        qVar.notifyAll();
                    } catch (IOException e5) {
                        throw new IOException(e5);
                    }
                }
            }
        } catch (Throwable th) {
            w.g(this.f1806g);
            this.f1806g = null;
            File file2 = this.f1805f;
            this.f1805f = null;
            file2.delete();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [g2.p, java.io.BufferedOutputStream] */
    public final void b() {
        long min;
        File c;
        long j2 = this.d.f1697g;
        if (j2 == -1) {
            min = -1;
        } else {
            min = Math.min(j2 - this.f1808i, this.f1804e);
        }
        b bVar = this.f1803a;
        e2.l lVar = this.d;
        String str = lVar.f1698h;
        long j5 = lVar.f1695e + this.f1808i;
        q qVar = (q) bVar;
        synchronized (qVar) {
            try {
                g2.b.h(!qVar.f1851h);
                qVar.d();
                i b = qVar.c.b(str);
                b.getClass();
                g2.b.h(b.f1833e);
                if (!qVar.f1847a.exists()) {
                    qVar.f1847a.mkdirs();
                    qVar.m();
                }
                o oVar = qVar.b;
                if (min != -1) {
                    oVar.a(qVar, min);
                } else {
                    oVar.getClass();
                }
                File file = new File(qVar.f1847a, Integer.toString(qVar.f1848e.nextInt(10)));
                if (!file.exists()) {
                    file.mkdir();
                }
                c = r.c(file, b.f1832a, j5, System.currentTimeMillis());
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f1805f = c;
        FileOutputStream fileOutputStream = new FileOutputStream(this.f1805f);
        if (this.c > 0) {
            g2.p pVar = this.f1809j;
            if (pVar == null) {
                this.f1809j = new BufferedOutputStream(fileOutputStream, this.c);
            } else {
                pVar.a(fileOutputStream);
            }
            this.f1806g = this.f1809j;
        } else {
            this.f1806g = fileOutputStream;
        }
        this.f1807h = 0L;
    }
}

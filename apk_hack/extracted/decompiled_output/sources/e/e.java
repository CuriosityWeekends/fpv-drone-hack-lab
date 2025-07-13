package e;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final File f1655a;
    public final File b;
    public final File c;
    public final File d;

    /* renamed from: f  reason: collision with root package name */
    public final long f1657f;

    /* renamed from: i  reason: collision with root package name */
    public BufferedWriter f1660i;

    /* renamed from: k  reason: collision with root package name */
    public int f1662k;

    /* renamed from: h  reason: collision with root package name */
    public long f1659h = 0;

    /* renamed from: j  reason: collision with root package name */
    public final LinkedHashMap f1661j = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    public long f1663l = 0;

    /* renamed from: m  reason: collision with root package name */
    public final ThreadPoolExecutor f1664m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), (ThreadFactory) new Object());

    /* renamed from: n  reason: collision with root package name */
    public final a f1665n = new a(this);

    /* renamed from: e  reason: collision with root package name */
    public final int f1656e = 1;

    /* renamed from: g  reason: collision with root package name */
    public final int f1658g = 1;

    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Object, java.util.concurrent.ThreadFactory] */
    public e(File file, long j2) {
        this.f1655a = file;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.f1657f = j2;
    }

    public static void a(e eVar, c cVar, boolean z3) {
        synchronized (eVar) {
            d dVar = (d) cVar.b;
            if (dVar.f1653f == cVar) {
                if (z3 && !dVar.f1652e) {
                    for (int i3 = 0; i3 < eVar.f1658g; i3++) {
                        if (((boolean[]) cVar.c)[i3]) {
                            if (!dVar.d[i3].exists()) {
                                cVar.a();
                                return;
                            }
                        } else {
                            cVar.a();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                        }
                    }
                }
                for (int i5 = 0; i5 < eVar.f1658g; i5++) {
                    File file = dVar.d[i5];
                    if (z3) {
                        if (file.exists()) {
                            File file2 = dVar.c[i5];
                            file.renameTo(file2);
                            long j2 = dVar.b[i5];
                            long length = file2.length();
                            dVar.b[i5] = length;
                            eVar.f1659h = (eVar.f1659h - j2) + length;
                        }
                    } else {
                        c(file);
                    }
                }
                eVar.f1662k++;
                dVar.f1653f = null;
                if (dVar.f1652e | z3) {
                    dVar.f1652e = true;
                    eVar.f1660i.append((CharSequence) "CLEAN");
                    eVar.f1660i.append(' ');
                    eVar.f1660i.append((CharSequence) dVar.f1651a);
                    eVar.f1660i.append((CharSequence) dVar.a());
                    eVar.f1660i.append('\n');
                    if (z3) {
                        eVar.f1663l++;
                        dVar.getClass();
                    }
                } else {
                    eVar.f1661j.remove(dVar.f1651a);
                    eVar.f1660i.append((CharSequence) "REMOVE");
                    eVar.f1660i.append(' ');
                    eVar.f1660i.append((CharSequence) dVar.f1651a);
                    eVar.f1660i.append('\n');
                }
                e(eVar.f1660i);
                if (eVar.f1659h > eVar.f1657f || eVar.g()) {
                    eVar.f1664m.submit(eVar.f1665n);
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    public static void b(Writer writer) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void c(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void e(Writer writer) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static e h(File file, long j2) {
        if (j2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m(file2, file3, false);
                }
            }
            e eVar = new e(file, j2);
            if (eVar.b.exists()) {
                try {
                    eVar.j();
                    eVar.i();
                    return eVar;
                } catch (IOException e5) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e5.getMessage() + ", removing");
                    eVar.close();
                    h.a(eVar.f1655a);
                }
            }
            file.mkdirs();
            e eVar2 = new e(file, j2);
            eVar2.l();
            return eVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void m(File file, File file2, boolean z3) {
        if (z3) {
            c(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f1660i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f1661j.values()).iterator();
            while (it.hasNext()) {
                c cVar = ((d) it.next()).f1653f;
                if (cVar != null) {
                    cVar.a();
                }
            }
            n();
            b(this.f1660i);
            this.f1660i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final c d(String str) {
        synchronized (this) {
            try {
                if (this.f1660i != null) {
                    d dVar = (d) this.f1661j.get(str);
                    if (dVar == null) {
                        dVar = new d(this, str);
                        this.f1661j.put(str, dVar);
                    } else if (dVar.f1653f != null) {
                        return null;
                    }
                    c cVar = new c(this, dVar);
                    dVar.f1653f = cVar;
                    this.f1660i.append((CharSequence) "DIRTY");
                    this.f1660i.append(' ');
                    this.f1660i.append((CharSequence) str);
                    this.f1660i.append('\n');
                    e(this.f1660i);
                    return cVar;
                }
                throw new IllegalStateException("cache is closed");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized b3.e f(String str) {
        if (this.f1660i != null) {
            d dVar = (d) this.f1661j.get(str);
            if (dVar == null) {
                return null;
            }
            if (!dVar.f1652e) {
                return null;
            }
            for (File file : dVar.c) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.f1662k++;
            this.f1660i.append((CharSequence) "READ");
            this.f1660i.append(' ');
            this.f1660i.append((CharSequence) str);
            this.f1660i.append('\n');
            if (g()) {
                this.f1664m.submit(this.f1665n);
            }
            return new b3.e(2, dVar.c);
        }
        throw new IllegalStateException("cache is closed");
    }

    public final boolean g() {
        int i3 = this.f1662k;
        if (i3 >= 2000 && i3 >= this.f1661j.size()) {
            return true;
        }
        return false;
    }

    public final void i() {
        c(this.c);
        Iterator it = this.f1661j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            c cVar = dVar.f1653f;
            int i3 = this.f1658g;
            int i5 = 0;
            if (cVar == null) {
                while (i5 < i3) {
                    this.f1659h += dVar.b[i5];
                    i5++;
                }
            } else {
                dVar.f1653f = null;
                while (i5 < i3) {
                    c(dVar.c[i5]);
                    c(dVar.d[i5]);
                    i5++;
                }
                it.remove();
            }
        }
    }

    public final void j() {
        File file = this.b;
        FileInputStream fileInputStream = new FileInputStream(file);
        Charset charset = h.f1669a;
        g gVar = new g(fileInputStream);
        try {
            String a5 = gVar.a();
            String a6 = gVar.a();
            String a7 = gVar.a();
            String a8 = gVar.a();
            String a9 = gVar.a();
            if ("libcore.io.DiskLruCache".equals(a5) && "1".equals(a6) && Integer.toString(this.f1656e).equals(a7) && Integer.toString(this.f1658g).equals(a8) && "".equals(a9)) {
                int i3 = 0;
                while (true) {
                    try {
                        k(gVar.a());
                        i3++;
                    } catch (EOFException unused) {
                        this.f1662k = i3 - this.f1661j.size();
                        if (gVar.f1668e == -1) {
                            l();
                        } else {
                            this.f1660i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), h.f1669a));
                        }
                        try {
                            gVar.close();
                            return;
                        } catch (RuntimeException e5) {
                            throw e5;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + a5 + ", " + a6 + ", " + a8 + ", " + a9 + "]");
            }
        } catch (Throwable th) {
            try {
                gVar.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void k(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i3 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i3);
            LinkedHashMap linkedHashMap = this.f1661j;
            if (indexOf2 == -1) {
                substring = str.substring(i3);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    linkedHashMap.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i3, indexOf2);
            }
            d dVar = (d) linkedHashMap.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring);
                linkedHashMap.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f1652e = true;
                dVar.f1653f = null;
                if (split.length == dVar.f1654g.f1658g) {
                    for (int i5 = 0; i5 < split.length; i5++) {
                        try {
                            dVar.b[i5] = Long.parseLong(split[i5]);
                        } catch (NumberFormatException unused) {
                            throw new IOException("unexpected journal line: " + Arrays.toString(split));
                        }
                    }
                    return;
                }
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f1653f = new c(this, dVar);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: ".concat(str));
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    public final synchronized void l() {
        try {
            BufferedWriter bufferedWriter = this.f1660i;
            if (bufferedWriter != null) {
                b(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), h.f1669a));
            bufferedWriter2.write("libcore.io.DiskLruCache");
            bufferedWriter2.write("\n");
            bufferedWriter2.write("1");
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.f1656e));
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.f1658g));
            bufferedWriter2.write("\n");
            bufferedWriter2.write("\n");
            for (d dVar : this.f1661j.values()) {
                if (dVar.f1653f != null) {
                    bufferedWriter2.write("DIRTY " + dVar.f1651a + '\n');
                } else {
                    bufferedWriter2.write("CLEAN " + dVar.f1651a + dVar.a() + '\n');
                }
            }
            b(bufferedWriter2);
            if (this.b.exists()) {
                m(this.b, this.d, true);
            }
            m(this.c, this.b, false);
            this.d.delete();
            this.f1660i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), h.f1669a));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void n() {
        while (this.f1659h > this.f1657f) {
            String str = (String) ((Map.Entry) this.f1661j.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.f1660i != null) {
                        d dVar = (d) this.f1661j.get(str);
                        if (dVar != null && dVar.f1653f == null) {
                            for (int i3 = 0; i3 < this.f1658g; i3++) {
                                File file = dVar.c[i3];
                                if (file.exists() && !file.delete()) {
                                    throw new IOException("failed to delete " + file);
                                }
                                long j2 = this.f1659h;
                                long[] jArr = dVar.b;
                                this.f1659h = j2 - jArr[i3];
                                jArr[i3] = 0;
                            }
                            this.f1662k++;
                            this.f1660i.append((CharSequence) "REMOVE");
                            this.f1660i.append(' ');
                            this.f1660i.append((CharSequence) str);
                            this.f1660i.append('\n');
                            this.f1661j.remove(str);
                            if (g()) {
                                this.f1664m.submit(this.f1665n);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cache is closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}

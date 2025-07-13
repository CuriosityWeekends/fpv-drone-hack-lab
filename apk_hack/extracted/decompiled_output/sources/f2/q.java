package f2;

import android.os.ConditionVariable;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q implements b {

    /* renamed from: j  reason: collision with root package name */
    public static final HashSet f1846j = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public final File f1847a;
    public final o b;
    public final k c;
    public final HashMap d;

    /* renamed from: e  reason: collision with root package name */
    public final Random f1848e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1849f;

    /* renamed from: g  reason: collision with root package name */
    public long f1850g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1851h;

    /* renamed from: i  reason: collision with root package name */
    public a f1852i;

    public q(File file, o oVar) {
        boolean add;
        k kVar = new k(file);
        synchronized (q.class) {
            add = f1846j.add(file.getAbsoluteFile());
        }
        if (add) {
            this.f1847a = file;
            this.b = oVar;
            this.c = kVar;
            this.d = new HashMap();
            this.f1848e = new Random();
            this.f1849f = true;
            this.f1850g = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new p(this, conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [f2.a, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v5, types: [f2.a, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r2v3, types: [f2.a, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r2v6, types: [f2.a, java.io.IOException] */
    public static void a(q qVar) {
        long j2;
        k kVar = qVar.c;
        File file = qVar.f1847a;
        if (!file.exists() && !file.mkdirs()) {
            String str = "Failed to create cache directory: " + file;
            Log.e("SimpleCache", str);
            qVar.f1852i = new IOException(str);
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            String str2 = "Failed to list cache directory files: " + file;
            Log.e("SimpleCache", str2);
            qVar.f1852i = new IOException(str2);
            return;
        }
        int length = listFiles.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                File file2 = listFiles[i3];
                String name = file2.getName();
                if (name.endsWith(".uid")) {
                    try {
                        j2 = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                        break;
                    } catch (NumberFormatException unused) {
                        Log.e("SimpleCache", "Malformed UID file: " + file2);
                        file2.delete();
                    }
                }
                i3++;
            } else {
                j2 = -1;
                break;
            }
        }
        qVar.f1850g = j2;
        if (j2 == -1) {
            try {
                qVar.f1850g = e(file);
            } catch (IOException e5) {
                String str3 = "Failed to create cache UID: " + file;
                Log.e("SimpleCache", str3, e5);
                qVar.f1852i = new IOException(str3, e5);
                return;
            }
        }
        try {
            kVar.d(qVar.f1850g);
            qVar.i(file, true, listFiles);
            HashMap hashMap = kVar.f1838a;
            int size = hashMap.size();
            String[] strArr = new String[size];
            hashMap.keySet().toArray(strArr);
            for (int i5 = 0; i5 < size; i5++) {
                kVar.e(strArr[i5]);
            }
            try {
                kVar.f();
            } catch (IOException e6) {
                Log.e("SimpleCache", "Storing index file failed", e6);
            }
        } catch (IOException e7) {
            String str4 = "Failed to initialize cache indices: " + file;
            Log.e("SimpleCache", str4, e7);
            qVar.f1852i = new IOException(str4, e7);
        }
    }

    public static long e(File file) {
        long abs;
        long nextLong = new SecureRandom().nextLong();
        if (nextLong == Long.MIN_VALUE) {
            abs = 0;
        } else {
            abs = Math.abs(nextLong);
        }
        File file2 = new File(file, a1.i.h(Long.toString(abs, 16), ".uid"));
        if (file2.createNewFile()) {
            return abs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public static synchronized boolean h(File file) {
        boolean contains;
        synchronized (q.class) {
            contains = f1846j.contains(file.getAbsoluteFile());
        }
        return contains;
    }

    public static synchronized void p(File file) {
        synchronized (q.class) {
            f1846j.remove(file.getAbsoluteFile());
        }
    }

    public final void b(r rVar) {
        k kVar = this.c;
        String str = rVar.f1828a;
        kVar.c(str).c.add(rVar);
        ArrayList arrayList = (ArrayList) this.d.get(str);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((o) arrayList.get(size)).b(this, rVar);
            }
        }
        this.b.b(this, rVar);
    }

    public final synchronized void c(String str, l lVar) {
        g2.b.h(!this.f1851h);
        d();
        k kVar = this.c;
        i c = kVar.c(str);
        m mVar = c.d;
        m a5 = mVar.a(lVar);
        c.d = a5;
        if (!a5.equals(mVar)) {
            kVar.f1839e.g(c);
        }
        try {
            this.c.f();
        } catch (IOException e5) {
            throw new IOException(e5);
        }
    }

    public final synchronized void d() {
        a aVar = this.f1852i;
        if (aVar != null) {
            throw aVar;
        }
    }

    public final synchronized TreeSet f(String str) {
        TreeSet treeSet;
        try {
            g2.b.h(!this.f1851h);
            i b = this.c.b(str);
            if (b != null && !b.c.isEmpty()) {
                treeSet = new TreeSet((Collection) b.c);
            }
            treeSet = new TreeSet();
        } catch (Throwable th) {
            throw th;
        }
        return treeSet;
    }

    public final synchronized m g(String str) {
        m mVar;
        g2.b.h(!this.f1851h);
        i b = this.c.b(str);
        if (b != null) {
            mVar = b.d;
        } else {
            mVar = m.c;
        }
        return mVar;
    }

    public final void i(File file, boolean z3, File[] fileArr) {
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                String name = file2.getName();
                if (z3 && name.indexOf(46) == -1) {
                    i(file2, false, file2.listFiles());
                } else if (!z3 || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                    r b = r.b(file2, -1L, this.c);
                    if (b != null) {
                        b(b);
                    } else {
                        file2.delete();
                    }
                }
            }
        } else if (!z3) {
            file.delete();
        }
    }

    public final synchronized void j() {
        if (this.f1851h) {
            return;
        }
        this.d.clear();
        m();
        try {
            this.c.f();
            p(this.f1847a);
        } catch (IOException e5) {
            Log.e("SimpleCache", "Storing index file failed", e5);
            p(this.f1847a);
        }
        this.f1851h = true;
    }

    public final synchronized void k(r rVar) {
        g2.b.h(!this.f1851h);
        i b = this.c.b(rVar.f1828a);
        b.getClass();
        g2.b.h(b.f1833e);
        b.f1833e = false;
        this.c.e(b.b);
        notifyAll();
    }

    public final void l(g gVar) {
        String str = gVar.f1828a;
        k kVar = this.c;
        i b = kVar.b(str);
        if (b != null && b.c.remove(gVar)) {
            gVar.f1829e.delete();
            kVar.e(b.b);
            ArrayList arrayList = (ArrayList) this.d.get(gVar.f1828a);
            long j2 = gVar.c;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    o oVar = (o) arrayList.get(size);
                    oVar.f1844a.remove(gVar);
                    oVar.b -= j2;
                }
            }
            o oVar2 = this.b;
            oVar2.f1844a.remove(gVar);
            oVar2.b -= j2;
        }
    }

    public final void m() {
        ArrayList arrayList = new ArrayList();
        for (i iVar : this.c.f1838a.values()) {
            Iterator it = iVar.c.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar.f1829e.length() != gVar.c) {
                    arrayList.add(gVar);
                }
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            l((g) arrayList.get(i3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [f2.g] */
    public final synchronized r n(String str, long j2) {
        r b;
        r rVar;
        g2.b.h(!this.f1851h);
        d();
        i b5 = this.c.b(str);
        if (b5 == null) {
            rVar = new g(str, j2, -1L, -9223372036854775807L, null);
        } else {
            while (true) {
                b = b5.b(j2);
                if (!b.d || b.f1829e.length() == b.c) {
                    break;
                }
                m();
            }
            rVar = b;
        }
        if (rVar.d) {
            return o(str, rVar);
        }
        i c = this.c.c(str);
        if (!c.f1833e) {
            c.f1833e = true;
            return rVar;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5, types: [f2.g, java.lang.Object, f2.r] */
    public final r o(String str, r rVar) {
        File file;
        if (!this.f1849f) {
            return rVar;
        }
        File file2 = rVar.f1829e;
        file2.getClass();
        file2.getName();
        long currentTimeMillis = System.currentTimeMillis();
        i b = this.c.b(str);
        TreeSet treeSet = b.c;
        g2.b.h(treeSet.remove(rVar));
        File c = r.c(file2.getParentFile(), b.f1832a, rVar.b, currentTimeMillis);
        if (file2.renameTo(c)) {
            file = c;
        } else {
            Log.w("CachedContent", "Failed to rename " + file2 + " to " + c);
            file = file2;
        }
        g2.b.h(rVar.d);
        ?? gVar = new g(rVar.f1828a, rVar.b, rVar.c, currentTimeMillis, file);
        treeSet.add(gVar);
        ArrayList arrayList = (ArrayList) this.d.get(rVar.f1828a);
        long j2 = rVar.c;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                o oVar = (o) arrayList.get(size);
                oVar.f1844a.remove(rVar);
                oVar.b -= j2;
                oVar.b(this, gVar);
            }
        }
        o oVar2 = this.b;
        oVar2.f1844a.remove(rVar);
        oVar2.b -= j2;
        oVar2.b(this, gVar);
        return gVar;
    }
}

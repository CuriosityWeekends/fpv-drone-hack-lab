package c1;

import a1.i;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaCodec;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import androidx.collection.ArrayMap;
import c0.l;
import com.bumptech.glide.load.data.d;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.shuyu.gsyvideoplayer.utils.FileUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.r;
import g.h;
import g.k;
import h2.q;
import i.g0;
import i.l0;
import i.m;
import j.j;
import j1.i0;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import m.p;
import m0.c;
import p.n;
import p0.g;
import p0.u;
import s1.e;
import y0.a0;
import y0.c0;
import y0.t;
import y0.w;
import y0.x;
import y0.z;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements ah, d, k, n, n3.d, e, p0.e, w {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f200a;
    public Object b;
    public Object c;

    public /* synthetic */ b(int i3, Object obj, Object obj2) {
        this.f200a = i3;
        this.c = obj;
        this.b = obj2;
    }

    public static void C(DataOutputStream dataOutputStream, long j2) {
        dataOutputStream.writeByte(((int) (j2 >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j2 >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j2 >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j2) & 255);
    }

    private final void p(c cVar) {
        synchronized (cVar) {
        }
        Handler handler = (Handler) this.b;
        if (handler != null) {
            handler.post(new q(this, cVar, 0));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.Map] */
    public File A() {
        ?? emptyMap;
        File file = (File) this.c;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        String path = new File("sync", "assets.lst").getPath();
        AssetManager assetManager = (AssetManager) this.b;
        InputStream open = assetManager.open(path);
        ArrayList arrayList3 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            arrayList3.add(readLine);
        }
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            hashMap.put(str, new BufferedReader(new InputStreamReader(assetManager.open(new File("sync", i.h(str, ".md5")).getPath()))).readLine());
        }
        try {
            emptyMap = new HashMap();
            FileInputStream fileInputStream = new FileInputStream(new File(file, "assets.lst"));
            ArrayList arrayList4 = new ArrayList();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine2 = bufferedReader2.readLine();
                if (readLine2 == null) {
                    break;
                }
                arrayList4.add(readLine2);
            }
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                String[] split = ((String) it2.next()).split(" ");
                emptyMap.put(split[0], split[1]);
            }
        } catch (IOException unused) {
            emptyMap = Collections.emptyMap();
        }
        for (String str2 : hashMap.keySet()) {
            if (((String) hashMap.get(str2)).equals(emptyMap.get(str2)) && new File(file, str2).exists()) {
                Log.i("b", "Skipping asset " + str2 + ": checksums are equal");
            } else {
                arrayList.add(str2);
            }
        }
        arrayList2.addAll(emptyMap.keySet());
        arrayList2.removeAll(hashMap.keySet());
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            String str3 = (String) it3.next();
            InputStream open2 = assetManager.open(new File("sync", str3).getPath());
            File file2 = new File(file, str3);
            file2.getParentFile().mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open2.read(bArr);
                if (read == -1) {
                    break;
                } else if (read == 0) {
                    int read2 = open2.read();
                    if (read2 < 0) {
                        break;
                    }
                    fileOutputStream.write(read2);
                } else {
                    fileOutputStream.write(bArr, 0, read);
                }
            }
            fileOutputStream.close();
            Log.i("b", String.format("Copying asset %s to %s", str3, file2));
        }
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            File file3 = new File(file, (String) it4.next());
            file3.delete();
            Log.i("b", String.format("Removing asset %s", file3));
        }
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(file, "assets.lst")));
        for (Map.Entry entry : hashMap.entrySet()) {
            printWriter.format("%s %s\n", entry.getKey(), entry.getValue());
        }
        printWriter.close();
        return file;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [p0.u, java.lang.Object] */
    public u B(int i3) {
        int i5 = 0;
        while (true) {
            int[] iArr = (int[]) this.b;
            if (i5 < iArr.length) {
                if (i3 == iArr[i5]) {
                    return ((i0[]) this.c)[i5];
                }
                i5++;
            } else {
                Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i3);
                return new Object();
            }
        }
    }

    @Override // com.tencent.bugly.proguard.ah
    public void a(boolean z3, String str) {
        if (z3) {
            al.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : (List) this.b) {
                userInfoBean.f1169f = currentTimeMillis;
                ((r) this.c).a(userInfoBean, true);
            }
        }
    }

    @Override // s1.e
    public int b(long j2) {
        int i3;
        switch (this.f200a) {
            case 21:
                Long valueOf = Long.valueOf(j2);
                int i5 = g2.w.f1960a;
                List list = (List) this.c;
                int binarySearch = Collections.binarySearch(list, valueOf);
                if (binarySearch < 0) {
                    i3 = ~binarySearch;
                } else {
                    int size = list.size();
                    do {
                        binarySearch++;
                        if (binarySearch < size) {
                        }
                        i3 = binarySearch;
                    } while (((Comparable) list.get(binarySearch)).compareTo(valueOf) == 0);
                    i3 = binarySearch;
                }
                if (i3 >= list.size()) {
                    return -1;
                }
                return i3;
            default:
                long[] jArr = (long[]) this.c;
                int b = g2.w.b(jArr, j2, false, false);
                if (b >= jArr.length) {
                    return -1;
                }
                return b;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void d(Exception exc) {
        l0 l0Var = (l0) this.c;
        p pVar = (p) this.b;
        p pVar2 = l0Var.f2112f;
        if (pVar2 != null && pVar2 == pVar) {
            i.e eVar = l0Var.f2113g;
            com.bumptech.glide.load.data.e eVar2 = pVar.c;
            l0Var.b.d(eVar, exc, eVar2, eVar2.getDataSource());
        }
    }

    @Override // s1.e
    public long e(int i3) {
        boolean z3;
        boolean z5;
        switch (this.f200a) {
            case 21:
                boolean z6 = false;
                if (i3 >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                g2.b.e(z3);
                List list = (List) this.c;
                if (i3 < list.size()) {
                    z6 = true;
                }
                g2.b.e(z6);
                return ((Long) list.get(i3)).longValue();
            default:
                boolean z7 = false;
                if (i3 >= 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                g2.b.e(z5);
                long[] jArr = (long[]) this.c;
                if (i3 < jArr.length) {
                    z7 = true;
                }
                g2.b.e(z7);
                return jArr[i3];
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void f(Object obj) {
        l0 l0Var = (l0) this.c;
        p pVar = (p) this.b;
        p pVar2 = l0Var.f2112f;
        if (pVar2 != null && pVar2 == pVar) {
            m mVar = l0Var.f2110a.f2071p;
            if (obj != null && mVar.c(pVar.c.getDataSource())) {
                l0Var.f2111e = obj;
                l0Var.b.a();
                return;
            }
            g.e eVar = pVar.f2748a;
            com.bumptech.glide.load.data.e eVar2 = pVar.c;
            l0Var.b.b(eVar, obj, eVar2, eVar2.getDataSource(), l0Var.f2113g);
        }
    }

    @Override // p0.e
    public p0.d g(g gVar, long j2) {
        int a5;
        p0.d dVar;
        long j5 = gVar.d;
        int min = (int) Math.min(20000L, gVar.c - j5);
        c0.b bVar = (c0.b) this.c;
        bVar.v(min);
        gVar.d(bVar.f187a, 0, min, false);
        int i3 = -1;
        long j6 = -9223372036854775807L;
        int i5 = -1;
        while (bVar.a() >= 4) {
            if (r0.b.a(bVar.f187a, bVar.b) != 442) {
                bVar.z(1);
            } else {
                bVar.z(4);
                long c = t.c(bVar);
                if (c != -9223372036854775807L) {
                    long b = ((g2.u) this.b).b(c);
                    if (b > j2) {
                        if (j6 == -9223372036854775807L) {
                            return new p0.d(-1, b, j5);
                        }
                        dVar = new p0.d(0, -9223372036854775807L, j5 + i5);
                    } else if (100000 + b > j2) {
                        dVar = new p0.d(0, -9223372036854775807L, j5 + bVar.b);
                    } else {
                        i5 = bVar.b;
                        j6 = b;
                    }
                    return dVar;
                }
                int i6 = bVar.c;
                if (bVar.a() < 10) {
                    bVar.y(i6);
                } else {
                    bVar.z(9);
                    int n5 = bVar.n() & 7;
                    if (bVar.a() < n5) {
                        bVar.y(i6);
                    } else {
                        bVar.z(n5);
                        if (bVar.a() < 4) {
                            bVar.y(i6);
                        } else {
                            if (r0.b.a(bVar.f187a, bVar.b) == 443) {
                                bVar.z(4);
                                int s = bVar.s();
                                if (bVar.a() < s) {
                                    bVar.y(i6);
                                } else {
                                    bVar.z(s);
                                }
                            }
                            while (true) {
                                if (bVar.a() < 4 || (a5 = r0.b.a(bVar.f187a, bVar.b)) == 442 || a5 == 441 || (a5 >>> 8) != 1) {
                                    break;
                                }
                                bVar.z(4);
                                if (bVar.a() < 2) {
                                    bVar.y(i6);
                                    break;
                                }
                                bVar.y(Math.min(bVar.c, bVar.b + bVar.s()));
                            }
                        }
                    }
                }
                i3 = bVar.b;
            }
        }
        if (j6 != -9223372036854775807L) {
            return new p0.d(-2, j6, j5 + i3);
        }
        return p0.d.d;
    }

    @Override // g.k
    public int h(h hVar) {
        return ((k) this.c).h(hVar);
    }

    @Override // s1.e
    public List i(long j2) {
        s1.b bVar;
        switch (this.f200a) {
            case 21:
                int c = g2.w.c((List) this.c, Long.valueOf(j2), false);
                if (c == -1) {
                    return Collections.emptyList();
                }
                return (List) ((List) this.b).get(c);
            default:
                int d = g2.w.d((long[]) this.c, j2, false);
                if (d != -1 && (bVar = ((s1.b[]) this.b)[d]) != s1.b.f3480o) {
                    return Collections.singletonList(bVar);
                }
                return Collections.emptyList();
        }
    }

    @Override // p0.e
    public void j() {
        byte[] bArr = g2.w.f1962f;
        c0.b bVar = (c0.b) this.c;
        bVar.getClass();
        bVar.w(bArr, bArr.length);
    }

    @Override // g.b
    public boolean k(Object obj, File file, h hVar) {
        return ((k) this.c).k(new p.c(((BitmapDrawable) ((g0) obj).get()).getBitmap(), (j.b) this.b), file, hVar);
    }

    @Override // p.n
    public void l(Bitmap bitmap, j.b bVar) {
        IOException iOException = ((c0.e) this.c).b;
        if (iOException != null) {
            if (bitmap != null) {
                bVar.e(bitmap);
            }
            throw iOException;
        }
    }

    @Override // p.n
    public void m() {
        p.w wVar = (p.w) this.b;
        synchronized (wVar) {
            wVar.c = wVar.f3091a.length;
        }
    }

    @Override // s1.e
    public int n() {
        switch (this.f200a) {
            case 21:
                return ((List) this.c).size();
            default:
                return ((long[]) this.c).length;
        }
    }

    public void o(c cVar) {
        switch (this.f200a) {
            case 6:
                p(cVar);
                return;
            default:
                synchronized (cVar) {
                }
                Handler handler = (Handler) this.b;
                if (handler != null) {
                    handler.post(new l0.g(this, cVar, 1));
                    return;
                }
                return;
        }
    }

    public byte[] q(EventMessage eventMessage) {
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.b;
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = (DataOutputStream) this.c;
        try {
            dataOutputStream.writeBytes(eventMessage.f342a);
            dataOutputStream.writeByte(0);
            String str = eventMessage.b;
            if (str == null) {
                str = "";
            }
            dataOutputStream.writeBytes(str);
            dataOutputStream.writeByte(0);
            C(dataOutputStream, eventMessage.c);
            C(dataOutputStream, eventMessage.d);
            dataOutputStream.write(eventMessage.f343e);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    public Object r(j jVar) {
        int i3;
        HashMap hashMap = (HashMap) this.c;
        j.d dVar = (j.d) hashMap.get(jVar);
        if (dVar == null) {
            dVar = new j.d(jVar);
            hashMap.put(jVar, dVar);
        } else {
            jVar.a();
        }
        j.d dVar2 = dVar.d;
        dVar2.c = dVar.c;
        dVar.c.d = dVar2;
        j.d dVar3 = (j.d) this.b;
        dVar.d = dVar3;
        j.d dVar4 = dVar3.c;
        dVar.c = dVar4;
        dVar4.d = dVar;
        dVar.d.c = dVar;
        ArrayList arrayList = dVar.b;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            return dVar.b.remove(i3 - 1);
        }
        return null;
    }

    public void s(Bitmap bitmap) {
        n3.e eVar = (n3.e) this.b;
        File file = (File) this.c;
        if (bitmap == null) {
            eVar.result(false, file);
            return;
        }
        FileUtils.saveBitmap(bitmap, file);
        eVar.result(true, file);
    }

    public boolean t(String str) {
        return ((SharedPreferences) this.b).getBoolean(str, false);
    }

    public String toString() {
        int i3;
        switch (this.f200a) {
            case 9:
                StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
                j.d dVar = (j.d) this.b;
                j.d dVar2 = dVar.c;
                boolean z3 = false;
                while (!dVar2.equals(dVar)) {
                    sb.append('{');
                    sb.append(dVar2.f2185a);
                    sb.append(':');
                    ArrayList arrayList = dVar2.b;
                    if (arrayList != null) {
                        i3 = arrayList.size();
                    } else {
                        i3 = 0;
                    }
                    sb.append(i3);
                    sb.append("}, ");
                    dVar2 = dVar2.c;
                    z3 = true;
                }
                if (z3) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(" )");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void u(j jVar, Object obj) {
        HashMap hashMap = (HashMap) this.c;
        j.d dVar = (j.d) hashMap.get(jVar);
        if (dVar == null) {
            dVar = new j.d(jVar);
            dVar.c = dVar;
            dVar.d = dVar;
            j.d dVar2 = (j.d) this.b;
            dVar.d = dVar2.d;
            dVar.c = dVar2;
            dVar2.d = dVar;
            dVar.d.c = dVar;
            hashMap.put(jVar, dVar);
        } else {
            jVar.a();
        }
        if (dVar.b == null) {
            dVar.b = new ArrayList();
        }
        dVar.b.add(obj);
    }

    public void v(Class cls, Class cls2, Class cls3, List list) {
        synchronized (((ArrayMap) this.c)) {
            ((ArrayMap) this.c).put(new l(cls, cls2, cls3), list);
        }
    }

    public void w(String str) {
        k.b bVar;
        synchronized (this) {
            try {
                Object obj = ((HashMap) this.b).get(str);
                c0.g.c(obj, "Argument must not be null");
                bVar = (k.b) obj;
                int i3 = bVar.b;
                if (i3 >= 1) {
                    int i5 = i3 - 1;
                    bVar.b = i5;
                    if (i5 == 0) {
                        k.b bVar2 = (k.b) ((HashMap) this.b).remove(str);
                        if (bVar2.equals(bVar)) {
                            ((k.c) this.c).b(bVar2);
                        } else {
                            throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar + ", but actually removed: " + bVar2 + ", safeKey: " + str);
                        }
                    }
                } else {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + bVar.b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.f2485a.unlock();
    }

    public Object x() {
        int i3;
        j.d dVar = (j.d) this.b;
        j.d dVar2 = dVar.d;
        while (true) {
            Object obj = null;
            if (dVar2.equals(dVar)) {
                return null;
            }
            ArrayList arrayList = dVar2.b;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                obj = dVar2.b.remove(i3 - 1);
            }
            if (obj != null) {
                return obj;
            }
            j.d dVar3 = dVar2.d;
            dVar3.c = dVar2.c;
            dVar2.c.d = dVar3;
            Object obj2 = dVar2.f2185a;
            ((HashMap) this.c).remove(obj2);
            ((j) obj2).a();
            dVar2 = dVar2.d;
        }
    }

    public p0.j y(g gVar, p0.k kVar) {
        p0.j jVar = (p0.j) this.c;
        if (jVar != null) {
            return jVar;
        }
        p0.j[] jVarArr = (p0.j[]) this.b;
        if (jVarArr.length == 1) {
            this.c = jVarArr[0];
        } else {
            int length = jVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                p0.j jVar2 = jVarArr[i3];
                try {
                    if (jVar2.f(gVar)) {
                        this.c = jVar2;
                        gVar.f3111f = 0;
                        break;
                    }
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    gVar.f3111f = 0;
                    throw th;
                }
                gVar.f3111f = 0;
                i3++;
            }
            if (((p0.j) this.c) == null) {
                StringBuilder sb = new StringBuilder("None of the available extractors (");
                int i5 = g2.w.f1960a;
                StringBuilder sb2 = new StringBuilder();
                for (int i6 = 0; i6 < jVarArr.length; i6++) {
                    sb2.append(jVarArr[i6].getClass().getSimpleName());
                    if (i6 < jVarArr.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb.append(sb2.toString());
                sb.append(") could read the stream.");
                throw new IOException(sb.toString());
            }
        }
        ((p0.j) this.c).b(kVar);
        return (p0.j) this.c;
    }

    public g2.a z() {
        File file = (File) this.b;
        if (file.exists()) {
            File file2 = (File) this.c;
            if (!file2.exists()) {
                if (!file.renameTo(file2)) {
                    Log.w("AtomicFile", "Couldn't rename file " + file + " to backup file " + file2);
                }
            } else {
                file.delete();
            }
        }
        try {
            return new g2.a(file);
        } catch (FileNotFoundException e5) {
            File parentFile = file.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    return new g2.a(file);
                } catch (FileNotFoundException e6) {
                    throw new IOException("Couldn't create " + file, e6);
                }
            }
            throw new IOException("Couldn't create " + file, e5);
        }
    }

    public /* synthetic */ b(int i3, Object obj, Object obj2, boolean z3) {
        this.f200a = i3;
        this.b = obj;
        this.c = obj2;
    }

    public /* synthetic */ b(int i3, boolean z3) {
        this.f200a = i3;
    }

    public b(int i3) {
        this.f200a = i3;
        switch (i3) {
            case 7:
                this.b = new HashMap();
                this.c = new HashMap();
                return;
            case 9:
                this.b = new j.d(null);
                this.c = new HashMap();
                return;
            case 11:
                this.b = new HashMap();
                this.c = new k.c(0);
                return;
            case 23:
                this.b = new AtomicReference();
                this.c = new ArrayMap();
                return;
            default:
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                this.b = byteArrayOutputStream;
                this.c = new DataOutputStream(byteArrayOutputStream);
                return;
        }
    }

    @Override // y0.w
    public void a(c0.b bVar) {
        a0 a0Var;
        if (bVar.n() != 0) {
            return;
        }
        bVar.z(7);
        int a5 = bVar.a() / 4;
        int i3 = 0;
        while (true) {
            a0Var = (a0) this.c;
            if (i3 >= a5) {
                break;
            }
            g2.n nVar = (g2.n) this.b;
            bVar.b(nVar.b, 0, 4);
            nVar.l(0);
            int g5 = nVar.g(16);
            nVar.o(3);
            if (g5 == 0) {
                nVar.o(13);
            } else {
                int g6 = nVar.g(13);
                a0Var.f4029f.put(g6, new x(new z(a0Var, g6)));
                a0Var.f4035l++;
            }
            i3++;
        }
        if (a0Var.f4027a != 2) {
            a0Var.f4029f.remove(0);
        }
    }

    public b(File file) {
        this.f200a = 4;
        this.b = file;
        this.c = new File(file.getPath() + ".bak");
    }

    public b(g2.u uVar) {
        this.f200a = 25;
        this.b = uVar;
        this.c = new c0.b();
    }

    public b(Context context, int i3) {
        this.f200a = i3;
        switch (i3) {
            case 12:
                this.b = context;
                this.c = "image_manager_disk_cache";
                return;
            case 22:
                SharedPreferences sharedPreferences = context.getSharedPreferences("rcfpvpro", 0);
                this.b = sharedPreferences;
                this.c = sharedPreferences.edit();
                return;
            default:
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    this.c = new File(externalFilesDir, "sync");
                    this.b = context.getAssets();
                    return;
                }
                throw new IOException("cannot get external files dir, external storage state is " + Environment.getExternalStorageState());
        }
    }

    public b(MediaCodec.CryptoInfo cryptoInfo) {
        this.f200a = 15;
        this.b = cryptoInfo;
        this.c = androidx.core.view.b.g();
    }

    public b(a0 a0Var) {
        this.f200a = 26;
        this.c = a0Var;
        this.b = new g2.n(new byte[4], 4);
    }

    public b(p0.j[] jVarArr) {
        this.f200a = 10;
        this.b = jVarArr;
    }

    @Override // y0.w
    public void c(g2.u uVar, p0.k kVar, c0 c0Var) {
    }
}

package i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.tbruyelle.rxpermissions3.RxPermissionsFragment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements j1.x, l2.l, u.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2045a;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i3) {
        this.f2045a = i3;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public static void l(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
    }

    public synchronized void a(g.e eVar, a0 a0Var) {
        a aVar = (a) ((HashMap) this.b).put(eVar, new a(eVar, a0Var, (ReferenceQueue) this.c));
        if (aVar != null) {
            aVar.c = null;
            aVar.clear();
        }
    }

    @Override // u.a
    public g0 b(g0 g0Var, g.h hVar) {
        Drawable drawable = (Drawable) g0Var.get();
        if (drawable instanceof BitmapDrawable) {
            return ((u.a) this.c).b(p.c.b(((BitmapDrawable) drawable).getBitmap(), (j.b) this.b), hVar);
        } else if (drawable instanceof GifDrawable) {
            return ((u.a) this.d).b(g0Var, hVar);
        } else {
            return null;
        }
    }

    public void c(a aVar) {
        g0 g0Var;
        synchronized (this) {
            ((HashMap) this.b).remove(aVar.f2040a);
            if (aVar.b && (g0Var = aVar.c) != null) {
                ((s) ((z) this.d)).f(aVar.f2040a, new a0(g0Var, true, false, aVar.f2040a, (z) this.d));
            }
        }
    }

    public Bitmap d(BitmapFactory.Options options) {
        switch (this.f2045a) {
            case 7:
                p.w wVar = (p.w) ((com.bumptech.glide.load.data.i) this.b).b;
                wVar.reset();
                return BitmapFactory.decodeStream(wVar, null, options);
            default:
                return BitmapFactory.decodeFileDescriptor(((com.bumptech.glide.load.data.i) this.d).e().getFileDescriptor(), null, options);
        }
    }

    public RxPermissionsFragment e() {
        RxPermissionsFragment rxPermissionsFragment;
        synchronized (this) {
            try {
                if (((RxPermissionsFragment) this.b) == null) {
                    FragmentManager fragmentManager = (FragmentManager) this.c;
                    ((v3.c) this.d).getClass();
                    RxPermissionsFragment rxPermissionsFragment2 = (RxPermissionsFragment) fragmentManager.findFragmentByTag("c");
                    if (rxPermissionsFragment2 == null) {
                        rxPermissionsFragment2 = new RxPermissionsFragment();
                        fragmentManager.beginTransaction().add(rxPermissionsFragment2, "c").commitNow();
                    }
                    this.b = rxPermissionsFragment2;
                }
                rxPermissionsFragment = (RxPermissionsFragment) this.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rxPermissionsFragment;
    }

    public int f() {
        switch (this.f2045a) {
            case 7:
                p.w wVar = (p.w) ((com.bumptech.glide.load.data.i) this.b).b;
                wVar.reset();
                return com.bumptech.glide.c.e((j.g) this.c, wVar, (List) this.d);
            default:
                com.bumptech.glide.load.data.i iVar = (com.bumptech.glide.load.data.i) this.d;
                j.g gVar = (j.g) this.b;
                ArrayList arrayList = (ArrayList) ((List) this.c);
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    g.d dVar = (g.d) arrayList.get(i3);
                    p.w wVar2 = null;
                    try {
                        p.w wVar3 = new p.w(new FileInputStream(iVar.e().getFileDescriptor()), gVar);
                        try {
                            int b = dVar.b(wVar3, gVar);
                            try {
                                wVar3.close();
                            } catch (IOException unused) {
                            }
                            iVar.e();
                            if (b != -1) {
                                return b;
                            }
                        } catch (Throwable th) {
                            th = th;
                            wVar2 = wVar3;
                            if (wVar2 != null) {
                                try {
                                    wVar2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            iVar.e();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return -1;
        }
    }

    public ImageHeaderParser$ImageType g() {
        switch (this.f2045a) {
            case 7:
                p.w wVar = (p.w) ((com.bumptech.glide.load.data.i) this.b).b;
                wVar.reset();
                return com.bumptech.glide.c.f((j.g) this.c, wVar, (List) this.d);
            default:
                com.bumptech.glide.load.data.i iVar = (com.bumptech.glide.load.data.i) this.d;
                j.g gVar = (j.g) this.b;
                List list = (List) this.c;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    g.d dVar = (g.d) list.get(i3);
                    p.w wVar2 = null;
                    try {
                        p.w wVar3 = new p.w(new FileInputStream(iVar.e().getFileDescriptor()), gVar);
                        try {
                            ImageHeaderParser$ImageType c = dVar.c(wVar3);
                            try {
                                wVar3.close();
                            } catch (IOException unused) {
                            }
                            iVar.e();
                            if (c != ImageHeaderParser$ImageType.UNKNOWN) {
                                return c;
                            }
                        } catch (Throwable th) {
                            th = th;
                            wVar2 = wVar3;
                            if (wVar2 != null) {
                                try {
                                    wVar2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            iVar.e();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public File h(Context context) {
        ((t2.b0) this.c).getClass();
        return new File(context.getDir("lib", 0), System.mapLibraryName("pl_droidsonroids_gif"));
    }

    public boolean i() {
        String trim;
        if (((String) this.d) != null) {
            return true;
        }
        Queue queue = (Queue) this.c;
        if (!queue.isEmpty()) {
            Object poll = queue.poll();
            poll.getClass();
            this.d = (String) poll;
            return true;
        }
        do {
            String readLine = ((BufferedReader) this.b).readLine();
            this.d = readLine;
            if (readLine != null) {
                trim = readLine.trim();
                this.d = trim;
            } else {
                return false;
            }
        } while (trim.isEmpty());
        return true;
    }

    public void j(Context context) {
        if (context != null) {
            if ("pl_droidsonroids_gif".length() != 0) {
                l("Beginning load of %s...", "pl_droidsonroids_gif");
                k(context);
                return;
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0169, code lost:
        if (r12 != null) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.k(android.content.Context):void");
    }

    public boolean m(int i3, j1.n nVar) {
        j1.k kVar = (j1.k) this.d;
        if (nVar != null) {
            kVar.getClass();
            Void r12 = (Void) this.b;
            if (kVar.f2445j != Integer.MAX_VALUE) {
                nVar = (j1.n) kVar.f2446k.get(nVar);
            }
            if (nVar == null) {
                return false;
            }
        } else {
            nVar = null;
        }
        j1.n nVar2 = nVar;
        kVar.getClass();
        j1.u uVar = (j1.u) this.c;
        if (uVar.f2464a != i3 || !g2.w.a(uVar.b, nVar2)) {
            this.c = new j1.u(kVar.c.c, i3, nVar2, 0L);
            return true;
        }
        return true;
    }

    public j1.w n(j1.w wVar) {
        ((j1.k) this.d).getClass();
        long j2 = wVar.f2467f;
        long j5 = wVar.f2467f;
        long j6 = wVar.f2468g;
        if (j2 == j5 && j6 == j6) {
            return wVar;
        }
        return new j1.w(wVar.f2465a, wVar.b, wVar.c, wVar.d, wVar.f2466e, j2, j6);
    }

    public String o() {
        if (i()) {
            String str = (String) this.d;
            this.d = null;
            return str;
        }
        throw new NoSuchElementException();
    }

    @Override // j1.x
    public void onDownstreamFormatChanged(int i3, j1.n nVar, j1.w wVar) {
        if (m(i3, nVar)) {
            ((j1.u) this.c).c(n(wVar));
        }
    }

    @Override // j1.x
    public void onLoadCanceled(int i3, j1.n nVar, j1.v vVar, j1.w wVar) {
        if (m(i3, nVar)) {
            ((j1.u) this.c).e(vVar, n(wVar));
        }
    }

    @Override // j1.x
    public void onLoadCompleted(int i3, j1.n nVar, j1.v vVar, j1.w wVar) {
        if (m(i3, nVar)) {
            ((j1.u) this.c).h(vVar, n(wVar));
        }
    }

    @Override // j1.x
    public void onLoadError(int i3, j1.n nVar, j1.v vVar, j1.w wVar, IOException iOException, boolean z3) {
        if (m(i3, nVar)) {
            ((j1.u) this.c).k(vVar, n(wVar), iOException, z3);
        }
    }

    @Override // j1.x
    public void onLoadStarted(int i3, j1.n nVar, j1.v vVar, j1.w wVar) {
        if (m(i3, nVar)) {
            ((j1.u) this.c).m(vVar, n(wVar));
        }
    }

    @Override // j1.x
    public void onMediaPeriodCreated(int i3, j1.n nVar) {
        if (m(i3, nVar)) {
            ((j1.u) this.c).b.getClass();
            ((j1.k) this.d).getClass();
            ((j1.u) this.c).n();
        }
    }

    @Override // j1.x
    public void onMediaPeriodReleased(int i3, j1.n nVar) {
        if (m(i3, nVar)) {
            ((j1.u) this.c).b.getClass();
            ((j1.k) this.d).getClass();
            ((j1.u) this.c).o();
        }
    }

    @Override // j1.x
    public void onReadingStarted(int i3, j1.n nVar) {
        if (m(i3, nVar)) {
            ((j1.u) this.c).q();
        }
    }

    @Override // j1.x
    public void onUpstreamDiscarded(int i3, j1.n nVar, j1.w wVar) {
        if (m(i3, nVar)) {
            ((j1.u) this.c).r(n(wVar));
        }
    }

    public void p() {
        switch (this.f2045a) {
            case 7:
                p.w wVar = (p.w) ((com.bumptech.glide.load.data.i) this.b).b;
                synchronized (wVar) {
                    wVar.c = wVar.f3091a.length;
                }
                return;
            default:
                return;
        }
    }

    @Override // l2.l
    public Object x() {
        try {
            return ((l2.d) this.b).h((Class) this.c);
        } catch (Exception e5) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + ((Type) this.d) + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e5);
        }
    }

    public b(int i3) {
        this.f2045a = i3;
        switch (i3) {
            case 2:
                return;
            case 13:
                Object obj = new Object();
                Object obj2 = new Object();
                this.b = new HashSet();
                this.c = obj;
                this.d = obj2;
                return;
            default:
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new com.tencent.bugly.proguard.e0(1));
                this.b = new HashMap();
                this.c = new ReferenceQueue();
                newSingleThreadExecutor.execute(new b3.d(9, this));
                return;
        }
    }

    public b(j.g gVar, InputStream inputStream, List list) {
        this.f2045a = 7;
        c0.g.c(gVar, "Argument must not be null");
        this.c = gVar;
        c0.g.c(list, "Argument must not be null");
        this.d = list;
        this.b = new com.bumptech.glide.load.data.i(inputStream, gVar);
    }

    public b(v3.c cVar, FragmentManager fragmentManager) {
        this.f2045a = 11;
        this.d = cVar;
        this.c = fragmentManager;
    }

    public b(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, j.g gVar) {
        this.f2045a = 8;
        c0.g.c(gVar, "Argument must not be null");
        this.b = gVar;
        c0.g.c(arrayList, "Argument must not be null");
        this.c = arrayList;
        this.d = new com.bumptech.glide.load.data.i(parcelFileDescriptor);
    }

    private final void q() {
    }

    public b(int i3, String str, ArrayList arrayList, byte[] bArr) {
        List unmodifiableList;
        this.f2045a = 12;
        this.b = str;
        if (arrayList == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        this.c = unmodifiableList;
        this.d = bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [l0.q, java.lang.Object, l0.y] */
    /* JADX WARN: Type inference failed for: r2v2, types: [l0.a0, java.lang.Object] */
    public b(l0.f[] fVarArr) {
        this.f2045a = 5;
        l0.f[] fVarArr2 = new l0.f[fVarArr.length + 2];
        this.b = fVarArr2;
        System.arraycopy(fVarArr, 0, fVarArr2, 0, fVarArr.length);
        ?? qVar = new l0.q();
        byte[] bArr = g2.w.f1962f;
        qVar.f2610k = bArr;
        qVar.f2611l = bArr;
        this.c = qVar;
        ?? obj = new Object();
        obj.c = 1.0f;
        obj.d = 1.0f;
        l0.d dVar = l0.d.f2533e;
        obj.f2512e = dVar;
        obj.f2513f = dVar;
        obj.f2514g = dVar;
        obj.f2515h = dVar;
        ByteBuffer byteBuffer = l0.f.f2535a;
        obj.f2518k = byteBuffer;
        obj.f2519l = byteBuffer.asShortBuffer();
        obj.f2520m = byteBuffer;
        obj.b = -1;
        this.d = obj;
        fVarArr2[fVarArr.length] = qVar;
        fVarArr2[fVarArr.length + 1] = obj;
    }

    public b(Class cls, Type type) {
        Object obj;
        this.f2045a = 6;
        this.c = cls;
        this.d = type;
        try {
            try {
                try {
                    Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls2.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    obj = new l2.n(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    obj = new Object();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                obj = new l2.p(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            obj = new l2.o(intValue, declaredMethod3);
        }
        this.b = obj;
    }

    public b(j1.k kVar) {
        this.f2045a = 4;
        this.d = kVar;
        this.c = kVar.d(null);
        this.b = null;
    }

    public b(s sVar, y.f fVar, w wVar) {
        this.f2045a = 3;
        this.d = sVar;
        this.c = fVar;
        this.b = wVar;
    }

    public b(ArrayDeque arrayDeque, BufferedReader bufferedReader) {
        this.f2045a = 9;
        this.c = arrayDeque;
        this.b = bufferedReader;
    }
}

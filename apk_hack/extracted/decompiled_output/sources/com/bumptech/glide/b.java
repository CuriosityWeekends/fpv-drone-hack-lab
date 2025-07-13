package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import i.s;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m.b0;
import m.z;
import p.a0;
import p.f0;
import t2.d0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements ComponentCallbacks2 {

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f232i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile boolean f233j;

    /* renamed from: a  reason: collision with root package name */
    public final j.b f234a;
    public final k.e b;
    public final f c;
    public final m d;

    /* renamed from: e  reason: collision with root package name */
    public final j.g f235e;

    /* renamed from: f  reason: collision with root package name */
    public final v.i f236f;

    /* renamed from: g  reason: collision with root package name */
    public final d0 f237g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f238h = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [t2.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.lang.Object, g.d] */
    public b(Context context, s sVar, k.e eVar, j.b bVar, j.g gVar, v.i iVar, d0 d0Var, j3.b bVar2, ArrayMap arrayMap, List list, h hVar) {
        g.j eVar2;
        g.j aVar;
        this.f234a = bVar;
        this.f235e = gVar;
        this.b = eVar;
        this.f236f = iVar;
        this.f237g = d0Var;
        Resources resources = context.getResources();
        m mVar = new m();
        this.d = mVar;
        Object obj = new Object();
        u.c cVar = mVar.f278g;
        synchronized (cVar) {
            cVar.f3724a.add(obj);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 27) {
            mVar.i(new Object());
        }
        ArrayList f4 = mVar.f();
        t.a aVar2 = new t.a(context, f4, bVar, gVar);
        f0 f0Var = new f0(bVar, new j3.b(21));
        p.o oVar = new p.o(mVar.f(), resources.getDisplayMetrics(), bVar, gVar);
        if (hVar.b.containsKey(c.class) && i3 >= 28) {
            aVar = new p.f(1);
            eVar2 = new p.f(0);
        } else {
            eVar2 = new p.e(oVar, 0);
            aVar = new p.a(3, oVar, gVar);
        }
        r.b bVar3 = new r.b(context);
        z zVar = new z(resources, 2);
        z zVar2 = new z(resources, 3);
        z zVar3 = new z(resources, 1);
        z zVar4 = new z(resources, 0);
        p.b bVar4 = new p.b(gVar);
        a1.m mVar2 = new a1.m(5);
        u.d dVar = new u.d(1);
        ContentResolver contentResolver = context.getContentResolver();
        mVar.a(ByteBuffer.class, new b0(5));
        mVar.a(InputStream.class, new b3.e(19, gVar));
        mVar.d("Bitmap", ByteBuffer.class, Bitmap.class, eVar2);
        mVar.d("Bitmap", InputStream.class, Bitmap.class, aVar);
        mVar.d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new p.e(oVar, 1));
        mVar.d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, f0Var);
        mVar.d("Bitmap", AssetFileDescriptor.class, Bitmap.class, new f0(bVar, new j3.a(20)));
        b0 b0Var = b0.b;
        mVar.c(Bitmap.class, Bitmap.class, b0Var);
        mVar.d("Bitmap", Bitmap.class, Bitmap.class, new a0(0));
        mVar.b(Bitmap.class, bVar4);
        mVar.d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new p.a(resources, eVar2));
        mVar.d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new p.a(resources, aVar));
        mVar.d("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new p.a(resources, f0Var));
        mVar.b(BitmapDrawable.class, new c1.b(16, bVar, bVar4, false));
        mVar.d("Gif", InputStream.class, GifDrawable.class, new t.i(f4, aVar2, gVar));
        mVar.d("Gif", ByteBuffer.class, GifDrawable.class, aVar2);
        mVar.b(GifDrawable.class, new j3.b(24));
        mVar.c(f.d.class, f.d.class, b0Var);
        mVar.d("Bitmap", f.d.class, Bitmap.class, new r.b(bVar));
        mVar.d("legacy_append", Uri.class, Drawable.class, bVar3);
        mVar.d("legacy_append", Uri.class, Bitmap.class, new p.a(2, bVar3, bVar));
        mVar.h(new com.bumptech.glide.load.data.h(2));
        mVar.c(File.class, ByteBuffer.class, new b0(6));
        mVar.c(File.class, InputStream.class, new j.a(new b0(9)));
        mVar.d("legacy_append", File.class, File.class, new a0(2));
        mVar.c(File.class, ParcelFileDescriptor.class, new j.a(new b0(8)));
        mVar.c(File.class, File.class, b0Var);
        mVar.h(new com.bumptech.glide.load.data.m(gVar));
        mVar.h(new com.bumptech.glide.load.data.h(1));
        Class cls = Integer.TYPE;
        mVar.c(cls, InputStream.class, zVar);
        mVar.c(cls, ParcelFileDescriptor.class, zVar3);
        mVar.c(Integer.class, InputStream.class, zVar);
        mVar.c(Integer.class, ParcelFileDescriptor.class, zVar3);
        mVar.c(Integer.class, Uri.class, zVar2);
        mVar.c(cls, AssetFileDescriptor.class, zVar4);
        mVar.c(Integer.class, AssetFileDescriptor.class, zVar4);
        mVar.c(cls, Uri.class, zVar2);
        mVar.c(String.class, InputStream.class, new b3.e(17));
        mVar.c(Uri.class, InputStream.class, new b3.e(17));
        mVar.c(String.class, InputStream.class, new b0(12));
        mVar.c(String.class, ParcelFileDescriptor.class, new b0(11));
        mVar.c(String.class, AssetFileDescriptor.class, new b0(10));
        mVar.c(Uri.class, InputStream.class, new m.a(context.getAssets(), 1));
        mVar.c(Uri.class, ParcelFileDescriptor.class, new m.a(context.getAssets(), 0));
        mVar.c(Uri.class, InputStream.class, new m.k(context, 1));
        mVar.c(Uri.class, InputStream.class, new m.k(context, 2));
        if (i3 >= 29) {
            mVar.c(Uri.class, InputStream.class, new n.b(context, InputStream.class));
            mVar.c(Uri.class, ParcelFileDescriptor.class, new n.b(context, ParcelFileDescriptor.class));
        }
        mVar.c(Uri.class, InputStream.class, new m.d0(contentResolver, 2));
        mVar.c(Uri.class, ParcelFileDescriptor.class, new m.d0(contentResolver, 1));
        mVar.c(Uri.class, AssetFileDescriptor.class, new m.d0(contentResolver, 0));
        mVar.c(Uri.class, InputStream.class, new b0(13));
        mVar.c(URL.class, InputStream.class, new j3.a(18));
        mVar.c(Uri.class, File.class, new m.k(context, 0));
        mVar.c(m.f.class, InputStream.class, new b3.e(20));
        mVar.c(byte[].class, ByteBuffer.class, new b0(2));
        mVar.c(byte[].class, InputStream.class, new b0(4));
        mVar.c(Uri.class, Uri.class, b0Var);
        mVar.c(Drawable.class, Drawable.class, b0Var);
        mVar.d("legacy_append", Drawable.class, Drawable.class, new a0(1));
        mVar.j(Bitmap.class, BitmapDrawable.class, new z(resources, 4));
        mVar.j(Bitmap.class, byte[].class, mVar2);
        mVar.j(Drawable.class, byte[].class, new i.b(bVar, mVar2, dVar, 10));
        mVar.j(GifDrawable.class, byte[].class, dVar);
        if (i3 >= 23) {
            f0 f0Var2 = new f0(bVar, new j3.b(20));
            mVar.d("legacy_append", ByteBuffer.class, Bitmap.class, f0Var2);
            mVar.d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new p.a(resources, f0Var2));
        }
        this.c = new f(context, gVar, mVar, new Object(), bVar2, arrayMap, list, sVar, hVar);
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [k.e, c0.j] */
    /* JADX WARN: Type inference failed for: r8v3, types: [t2.d0, java.lang.Object] */
    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        int i3;
        Context context2;
        j.b aVar;
        if (!f233j) {
            f233j = true;
            ArrayMap arrayMap = new ArrayMap();
            g gVar = new g(0);
            j3.b bVar = new j3.b(1);
            Context applicationContext = context.getApplicationContext();
            Collections.emptyList();
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Loading Glide modules");
            }
            ArrayList arrayList = new ArrayList();
            try {
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo.metaData == null) {
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Got null app info metadata");
                    }
                } else {
                    if (Log.isLoggable("ManifestParser", 2)) {
                        Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
                    }
                    for (String str : applicationInfo.metaData.keySet()) {
                        if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                            j4.b.p(str);
                            throw null;
                        }
                    }
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Finished loading Glide modules");
                    }
                }
                if (generatedAppGlideModule != null && !generatedAppGlideModule.j().isEmpty()) {
                    generatedAppGlideModule.j();
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        i.a(it.next());
                        throw null;
                    }
                }
                if (Log.isLoggable("Glide", 3)) {
                    Iterator it2 = arrayList.iterator();
                    if (it2.hasNext()) {
                        i.a(it2.next());
                        throw null;
                    }
                }
                Iterator it3 = arrayList.iterator();
                if (!it3.hasNext()) {
                    if (l.b.c == 0) {
                        l.b.c = Math.min(4, Runtime.getRuntime().availableProcessors());
                    }
                    int i5 = l.b.c;
                    if (!TextUtils.isEmpty("source")) {
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        l.b bVar2 = new l.b(new ThreadPoolExecutor(i5, i5, 0L, timeUnit, new PriorityBlockingQueue(), new l.a("source", false)));
                        if (!TextUtils.isEmpty("disk-cache")) {
                            l.b bVar3 = new l.b(new ThreadPoolExecutor(1, 1, 0L, timeUnit, new PriorityBlockingQueue(), new l.a("disk-cache", true)));
                            if (l.b.c == 0) {
                                l.b.c = Math.min(4, Runtime.getRuntime().availableProcessors());
                            }
                            if (l.b.c >= 4) {
                                i3 = 2;
                            } else {
                                i3 = 1;
                            }
                            if (!TextUtils.isEmpty("animation")) {
                                l.b bVar4 = new l.b(new ThreadPoolExecutor(i3, i3, 0L, timeUnit, new PriorityBlockingQueue(), new l.a("animation", true)));
                                h2.d dVar = new h2.d(new k.g(applicationContext));
                                ?? obj = new Object();
                                int i6 = dVar.f1991a;
                                if (i6 > 0) {
                                    context2 = applicationContext;
                                    aVar = new j.h(i6);
                                } else {
                                    context2 = applicationContext;
                                    aVar = new j3.a(7);
                                }
                                j.g gVar2 = new j.g(dVar.c);
                                ?? jVar = new c0.j(dVar.b);
                                Context context3 = context2;
                                s sVar = new s(jVar, new b3.e(context3), bVar3, bVar2, new l.b(new ThreadPoolExecutor(0, Integer.MAX_VALUE, l.b.b, timeUnit, new SynchronousQueue(), new l.a("source-unlimited", false))), bVar4);
                                List emptyList = Collections.emptyList();
                                h hVar = new h(gVar);
                                b bVar5 = new b(context3, sVar, jVar, aVar, gVar2, new v.i(hVar), obj, bVar, arrayMap, emptyList, hVar);
                                Iterator it4 = arrayList.iterator();
                                if (!it4.hasNext()) {
                                    context3.registerComponentCallbacks(bVar5);
                                    f232i = bVar5;
                                    f233j = false;
                                    return;
                                }
                                i.a(it4.next());
                                throw null;
                            }
                            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
                        }
                        throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
                    }
                    throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
                }
                i.a(it3.next());
                throw null;
            } catch (PackageManager.NameNotFoundException e5) {
                throw new RuntimeException("Unable to find metadata to parse GlideModules", e5);
            }
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static b b(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (f232i == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e5);
            } catch (InstantiationException e6) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e6);
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e8);
            }
            synchronized (b.class) {
                try {
                    if (f232i == null) {
                        a(context, generatedAppGlideModule);
                    }
                } finally {
                }
            }
        }
        return f232i;
    }

    public final void c(p pVar) {
        synchronized (this.f238h) {
            try {
                if (!this.f238h.contains(pVar)) {
                    this.f238h.add(pVar);
                } else {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(p pVar) {
        synchronized (this.f238h) {
            try {
                if (this.f238h.contains(pVar)) {
                    this.f238h.remove(pVar);
                } else {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        char[] cArr = c0.n.f199a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.b.h(0L);
            this.f234a.j();
            this.f235e.a();
            return;
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
        char[] cArr = c0.n.f199a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            synchronized (this.f238h) {
                try {
                    Iterator it = this.f238h.iterator();
                    while (it.hasNext()) {
                        ((p) it.next()).getClass();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.b.i(i3);
            this.f234a.h(i3);
            this.f235e.i(i3);
            return;
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }
}

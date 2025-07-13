package tv.danmaku.ijk.media.exo2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import b3.e;
import com.google.android.exoplayer2.source.dash.DashMediaSource$Factory;
import com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import e2.f0;
import e2.j0;
import e2.l;
import e2.t;
import f2.b;
import f2.f;
import f2.g;
import f2.h;
import f2.i;
import f2.o;
import f2.q;
import g2.w;
import j1.a;
import j1.e0;
import j1.p;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import m1.k;
import n1.d;
import q1.c;
import tv.danmaku.ijk.media.exo2.source.GSYExoHttpDataSourceFactory;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ExoSourceManager {
    private static final long DEFAULT_MAX_SIZE = 536870912;
    private static final String TAG = "ExoSourceManager";
    public static final int TYPE_RTMP = 4;
    private static b mCache = null;
    private static boolean s = false;
    private static ExoMediaSourceInterceptListener sExoMediaSourceInterceptListener = null;
    private static int sHttpConnectTimeout = -1;
    private static int sHttpReadTimeout = -1;
    private static boolean sSkipSSLChain = false;
    private boolean isCached = false;
    private Context mAppContext;
    private String mDataSource;
    private Map<String, String> mMapHeadData;

    private ExoSourceManager(Context context, Map<String, String> map) {
        this.mAppContext = context.getApplicationContext();
        this.mMapHeadData = map;
    }

    public static boolean cachePreView(Context context, File file, String str) {
        return resolveCacheState(getCacheSingleInstance(context, file), str);
    }

    public static void clearCache(Context context, File file, String str) {
        HashSet hashSet;
        try {
            b cacheSingleInstance = getCacheSingleInstance(context, file);
            if (!TextUtils.isEmpty(str)) {
                if (cacheSingleInstance != null) {
                    h.a(cacheSingleInstance, Uri.parse(str).toString());
                }
            } else if (cacheSingleInstance != null) {
                q qVar = (q) cacheSingleInstance;
                synchronized (qVar) {
                    g2.b.h(!qVar.f1851h);
                    hashSet = new HashSet(qVar.c.f1838a.keySet());
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    h.a(cacheSingleInstance, (String) it.next());
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public static synchronized b getCacheSingleInstance(Context context, File file) {
        b bVar;
        synchronized (ExoSourceManager.class) {
            try {
                String absolutePath = context.getCacheDir().getAbsolutePath();
                if (file != null) {
                    absolutePath = file.getAbsolutePath();
                }
                if (mCache == null) {
                    String str = absolutePath + File.separator + "exo";
                    if (!q.h(new File(str))) {
                        mCache = new q(new File(str), new o());
                    }
                }
                bVar = mCache;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private e2.h getDataSourceFactory(Context context, boolean z3) {
        e2.q a5;
        if (z3) {
            a5 = null;
        } else {
            a5 = new e2.o(context).a();
        }
        return new f0(context, a5, getHttpDataSourceFactory(context, z3));
    }

    private e2.h getDataSourceFactoryCache(Context context, boolean z3, boolean z5, File file) {
        b cacheSingleInstance;
        if (z3 && (cacheSingleInstance = getCacheSingleInstance(context, file)) != null) {
            this.isCached = resolveCacheState(cacheSingleInstance, this.mDataSource);
            return new f(cacheSingleInstance, getDataSourceFactory(context, z5));
        }
        return getDataSourceFactory(context, z5);
    }

    public static ExoMediaSourceInterceptListener getExoMediaSourceInterceptListener() {
        return sExoMediaSourceInterceptListener;
    }

    public static int getHttpConnectTimeout() {
        return sHttpConnectTimeout;
    }

    private e2.h getHttpDataSourceFactory(Context context, boolean z3) {
        int i3;
        int i5;
        boolean z5;
        e2.q a5;
        e2.q a6;
        int i6 = sHttpConnectTimeout;
        if (i6 > 0) {
            i3 = i6;
        } else {
            i3 = 8000;
        }
        int i7 = sHttpReadTimeout;
        if (i7 > 0) {
            i5 = i7;
        } else {
            i5 = 8000;
        }
        Map<String, String> map = this.mMapHeadData;
        if (map != null && map.size() > 0) {
            z5 = "true".equals(this.mMapHeadData.get("allowCrossProtocolRedirects"));
        } else {
            z5 = false;
        }
        if (sSkipSSLChain) {
            String q = w.q(context);
            if (z3) {
                a6 = null;
            } else {
                a6 = new e2.o(this.mAppContext).a();
            }
            GSYExoHttpDataSourceFactory gSYExoHttpDataSourceFactory = new GSYExoHttpDataSourceFactory(q, a6, i3, i5, z5);
            Map<String, String> map2 = this.mMapHeadData;
            if (map2 != null && map2.size() > 0) {
                for (Map.Entry<String, String> entry : this.mMapHeadData.entrySet()) {
                    gSYExoHttpDataSourceFactory.getDefaultRequestProperties().b(entry.getKey(), entry.getValue());
                }
            }
            return gSYExoHttpDataSourceFactory;
        }
        String q3 = w.q(context);
        if (z3) {
            a5 = null;
        } else {
            a5 = new e2.o(this.mAppContext).a();
        }
        t tVar = new t(q3, a5, i3, i5, z5);
        Map<String, String> map3 = this.mMapHeadData;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry2 : this.mMapHeadData.entrySet()) {
                tVar.getDefaultRequestProperties().b(entry2.getKey(), entry2.getValue());
            }
        }
        return tVar;
    }

    public static int getHttpReadTimeout() {
        return sHttpReadTimeout;
    }

    @SuppressLint({"WrongConstant"})
    public static int inferContentType(String str, @Nullable String str2) {
        String E = w.E(str);
        if (E.startsWith("rtmp:")) {
            return 4;
        }
        return inferContentType(Uri.parse(E), str2);
    }

    public static boolean isSkipSSLChain() {
        return sSkipSSLChain;
    }

    public static ExoSourceManager newInstance(Context context, @Nullable Map<String, String> map) {
        return new ExoSourceManager(context, map);
    }

    public static void resetExoMediaSourceInterceptListener() {
        sExoMediaSourceInterceptListener = null;
    }

    private static boolean resolveCacheState(b bVar, String str) {
        long j2;
        long j5;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String uri = Uri.parse(str).toString();
        if (!TextUtils.isEmpty(uri)) {
            q qVar = (q) bVar;
            TreeSet<g> f4 = qVar.f(uri);
            if (f4.size() != 0) {
                Map map = qVar.g(uri).b;
                if (map.containsKey("exo_len")) {
                    j2 = ByteBuffer.wrap((byte[]) map.get("exo_len")).getLong();
                } else {
                    j2 = -1;
                }
                long j6 = 0;
                for (g gVar : f4) {
                    long j7 = gVar.b;
                    long j8 = gVar.c;
                    synchronized (qVar) {
                        g2.b.h(!qVar.f1851h);
                        i b = qVar.c.b(uri);
                        if (b != null) {
                            j5 = b.a(j7, j8);
                        } else {
                            j5 = -j8;
                        }
                    }
                    j6 += j5;
                }
                if (j6 >= j2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setExoMediaSourceInterceptListener(ExoMediaSourceInterceptListener exoMediaSourceInterceptListener) {
        sExoMediaSourceInterceptListener = exoMediaSourceInterceptListener;
    }

    public static void setHttpConnectTimeout(int i3) {
        sHttpConnectTimeout = i3;
    }

    public static void setHttpReadTimeout(int i3) {
        sHttpReadTimeout = i3;
    }

    public static void setSkipSSLChain(boolean z3) {
        sSkipSSLChain = z3;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [p0.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16, types: [p0.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v19, types: [p0.h, java.lang.Object] */
    public p getMediaSource(String str, boolean z3, boolean z5, boolean z6, File file, @Nullable String str2) {
        p pVar;
        a hVar;
        ExoMediaSourceInterceptListener exoMediaSourceInterceptListener = sExoMediaSourceInterceptListener;
        if (exoMediaSourceInterceptListener != null) {
            pVar = exoMediaSourceInterceptListener.getMediaSource(str, z3, z5, z6, file);
        } else {
            pVar = null;
        }
        if (pVar != null) {
            return pVar;
        }
        this.mDataSource = str;
        Uri parse = Uri.parse(str);
        int inferContentType = inferContentType(str, str2);
        if ("android.resource".equals(parse.getScheme())) {
            l lVar = new l(parse, 0);
            final RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.mAppContext);
            try {
                rawResourceDataSource.open(lVar);
            } catch (j0 e5) {
                e5.printStackTrace();
            }
            return new e0(parse, new e2.h() { // from class: tv.danmaku.ijk.media.exo2.ExoSourceManager.1
                @Override // e2.h
                public e2.i createDataSource() {
                    return rawResourceDataSource;
                }
            }, new Object(), new j3.a(3));
        }
        if (inferContentType != 0) {
            if (inferContentType != 1) {
                if (inferContentType != 2) {
                    if (inferContentType != 4) {
                        hVar = new e0(parse, getDataSourceFactoryCache(this.mAppContext, z5, z3, file), new Object(), new j3.a(3));
                    } else {
                        hVar = new e0(parse, new j3.b(18), new Object(), new j3.a(3));
                    }
                } else {
                    HlsMediaSource$Factory hlsMediaSource$Factory = new HlsMediaSource$Factory(getDataSourceFactoryCache(this.mAppContext, z5, z3, file));
                    o1.b bVar = hlsMediaSource$Factory.b;
                    n0.b bVar2 = hlsMediaSource$Factory.f389f;
                    j3.b bVar3 = hlsMediaSource$Factory.c;
                    hlsMediaSource$Factory.d.getClass();
                    j3.a aVar = hlsMediaSource$Factory.f390g;
                    k kVar = hlsMediaSource$Factory.f387a;
                    hVar = new o1.k(parse, kVar, bVar, hlsMediaSource$Factory.f388e, bVar2, aVar, new p1.b(kVar, aVar, bVar3), hlsMediaSource$Factory.f391h);
                }
            } else {
                k kVar2 = new k(getDataSourceFactoryCache(this.mAppContext, z5, z3, file));
                Context context = this.mAppContext;
                f0 f0Var = new f0(context, null, getHttpDataSourceFactory(context, z3));
                SsMediaSource$Factory ssMediaSource$Factory = new SsMediaSource$Factory(kVar2, f0Var);
                if (ssMediaSource$Factory.f395a == null) {
                    ssMediaSource$Factory.f395a = new e(27);
                }
                hVar = new c(parse, f0Var, ssMediaSource$Factory.f395a, kVar2, ssMediaSource$Factory.b, ssMediaSource$Factory.c, 30000L);
            }
        } else {
            k kVar3 = new k(getDataSourceFactoryCache(this.mAppContext, z5, z3, file));
            Context context2 = this.mAppContext;
            f0 f0Var2 = new f0(context2, null, getHttpDataSourceFactory(context2, z3));
            DashMediaSource$Factory dashMediaSource$Factory = new DashMediaSource$Factory(kVar3, f0Var2);
            if (dashMediaSource$Factory.f386a == null) {
                dashMediaSource$Factory.f386a = new d();
            }
            hVar = new m1.h(parse, f0Var2, dashMediaSource$Factory.f386a, kVar3, dashMediaSource$Factory.b, dashMediaSource$Factory.c, 30000L);
        }
        if (z6) {
            return new j1.k(hVar);
        }
        return hVar;
    }

    public boolean hadCached() {
        return this.isCached;
    }

    public void release() {
        this.isCached = false;
        b bVar = mCache;
        if (bVar != null) {
            try {
                ((q) bVar).j();
                mCache = null;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static int inferContentType(Uri uri, @Nullable String str) {
        int i3 = w.f1960a;
        if (TextUtils.isEmpty(str)) {
            String path = uri.getPath();
            if (path == null) {
                return 3;
            }
            return w.s(path);
        }
        return w.s("." + str);
    }
}

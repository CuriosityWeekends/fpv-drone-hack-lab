package e2;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1730a;
    public final ArrayList b;
    public final i c;
    public u d;

    /* renamed from: e  reason: collision with root package name */
    public c f1731e;

    /* renamed from: f  reason: collision with root package name */
    public f f1732f;

    /* renamed from: g  reason: collision with root package name */
    public i f1733g;

    /* renamed from: h  reason: collision with root package name */
    public n0 f1734h;

    /* renamed from: i  reason: collision with root package name */
    public g f1735i;

    /* renamed from: j  reason: collision with root package name */
    public RawResourceDataSource f1736j;

    /* renamed from: k  reason: collision with root package name */
    public i f1737k;

    public r(Context context, i iVar) {
        this.f1730a = context.getApplicationContext();
        iVar.getClass();
        this.c = iVar;
        this.b = new ArrayList();
    }

    public static void b(i iVar, m0 m0Var) {
        if (iVar != null) {
            iVar.addTransferListener(m0Var);
        }
    }

    public final void a(i iVar) {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.b;
            if (i3 < arrayList.size()) {
                iVar.addTransferListener((m0) arrayList.get(i3));
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // e2.i
    public final void addTransferListener(m0 m0Var) {
        this.c.addTransferListener(m0Var);
        this.b.add(m0Var);
        b(this.d, m0Var);
        b(this.f1731e, m0Var);
        b(this.f1732f, m0Var);
        b(this.f1733g, m0Var);
        b(this.f1734h, m0Var);
        b(this.f1735i, m0Var);
        b(this.f1736j, m0Var);
    }

    @Override // e2.i
    public final void close() {
        i iVar = this.f1737k;
        if (iVar != null) {
            try {
                iVar.close();
            } finally {
                this.f1737k = null;
            }
        }
    }

    @Override // e2.i
    public final Map getResponseHeaders() {
        i iVar = this.f1737k;
        if (iVar == null) {
            return Collections.emptyMap();
        }
        return iVar.getResponseHeaders();
    }

    @Override // e2.i
    public final Uri getUri() {
        i iVar = this.f1737k;
        if (iVar == null) {
            return null;
        }
        return iVar.getUri();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [e2.i, e2.g, e2.e] */
    /* JADX WARN: Type inference failed for: r0v8, types: [e2.i, e2.e, e2.u] */
    @Override // e2.i
    public final long open(l lVar) {
        boolean z3;
        if (this.f1737k == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        String scheme = lVar.f1694a.getScheme();
        int i3 = g2.w.f1960a;
        Uri uri = lVar.f1694a;
        String scheme2 = uri.getScheme();
        boolean isEmpty = TextUtils.isEmpty(scheme2);
        Context context = this.f1730a;
        if (!isEmpty && !"file".equals(scheme2)) {
            if ("asset".equals(scheme)) {
                if (this.f1731e == null) {
                    c cVar = new c(context);
                    this.f1731e = cVar;
                    a(cVar);
                }
                this.f1737k = this.f1731e;
            } else if ("content".equals(scheme)) {
                if (this.f1732f == null) {
                    f fVar = new f(context);
                    this.f1732f = fVar;
                    a(fVar);
                }
                this.f1737k = this.f1732f;
            } else {
                boolean equals = "rtmp".equals(scheme);
                i iVar = this.c;
                if (equals) {
                    if (this.f1733g == null) {
                        try {
                            int i5 = o0.a.c;
                            i iVar2 = (i) o0.a.class.getConstructor(null).newInstance(null);
                            this.f1733g = iVar2;
                            a(iVar2);
                        } catch (ClassNotFoundException unused) {
                            Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                        } catch (Exception e5) {
                            throw new RuntimeException("Error instantiating RTMP extension", e5);
                        }
                        if (this.f1733g == null) {
                            this.f1733g = iVar;
                        }
                    }
                    this.f1737k = this.f1733g;
                } else if ("udp".equals(scheme)) {
                    if (this.f1734h == null) {
                        n0 n0Var = new n0();
                        this.f1734h = n0Var;
                        a(n0Var);
                    }
                    this.f1737k = this.f1734h;
                } else if ("data".equals(scheme)) {
                    if (this.f1735i == null) {
                        ?? eVar = new e(false);
                        this.f1735i = eVar;
                        a(eVar);
                    }
                    this.f1737k = this.f1735i;
                } else if ("rawresource".equals(scheme)) {
                    if (this.f1736j == null) {
                        RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(context);
                        this.f1736j = rawResourceDataSource;
                        a(rawResourceDataSource);
                    }
                    this.f1737k = this.f1736j;
                } else {
                    this.f1737k = iVar;
                }
            }
        } else {
            String path = uri.getPath();
            if (path != null && path.startsWith("/android_asset/")) {
                if (this.f1731e == null) {
                    c cVar2 = new c(context);
                    this.f1731e = cVar2;
                    a(cVar2);
                }
                this.f1737k = this.f1731e;
            } else {
                if (this.d == null) {
                    ?? eVar2 = new e(false);
                    this.d = eVar2;
                    a(eVar2);
                }
                this.f1737k = this.d;
            }
        }
        return this.f1737k.open(lVar);
    }

    @Override // e2.i
    public final int read(byte[] bArr, int i3, int i5) {
        i iVar = this.f1737k;
        iVar.getClass();
        return iVar.read(bArr, i3, i5);
    }
}

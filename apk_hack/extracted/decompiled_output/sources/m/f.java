package m;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements g.e {
    public final g b;
    public final URL c;
    public final String d;

    /* renamed from: e  reason: collision with root package name */
    public String f2736e;

    /* renamed from: f  reason: collision with root package name */
    public URL f2737f;

    /* renamed from: g  reason: collision with root package name */
    public volatile byte[] f2738g;

    /* renamed from: h  reason: collision with root package name */
    public int f2739h;

    public f(URL url) {
        j jVar = g.f2741a;
        c0.g.c(url, "Argument must not be null");
        this.c = url;
        this.d = null;
        c0.g.c(jVar, "Argument must not be null");
        this.b = jVar;
    }

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        if (this.f2738g == null) {
            this.f2738g = c().getBytes(g.e.f1896a);
        }
        messageDigest.update(this.f2738g);
    }

    public final String c() {
        String str = this.d;
        if (str == null) {
            URL url = this.c;
            c0.g.c(url, "Argument must not be null");
            return url.toString();
        }
        return str;
    }

    public final URL d() {
        if (this.f2737f == null) {
            if (TextUtils.isEmpty(this.f2736e)) {
                String str = this.d;
                if (TextUtils.isEmpty(str)) {
                    URL url = this.c;
                    c0.g.c(url, "Argument must not be null");
                    str = url.toString();
                }
                this.f2736e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f2737f = new URL(this.f2736e);
        }
        return this.f2737f;
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!c().equals(fVar.c()) || !this.b.equals(fVar.b)) {
            return false;
        }
        return true;
    }

    @Override // g.e
    public final int hashCode() {
        if (this.f2739h == 0) {
            int hashCode = c().hashCode();
            this.f2739h = hashCode;
            this.f2739h = this.b.hashCode() + (hashCode * 31);
        }
        return this.f2739h;
    }

    public final String toString() {
        return c();
    }

    public f(String str) {
        j jVar = g.f2741a;
        this.c = null;
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            c0.g.c(jVar, "Argument must not be null");
            this.b = jVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}

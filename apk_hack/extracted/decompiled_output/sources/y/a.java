package y;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.collection.SimpleArrayMap;
import c0.n;
import com.bumptech.glide.j;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import g.l;
import i.m;
import java.util.Map;
import p.r;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public int f3979a;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f3980e;

    /* renamed from: f  reason: collision with root package name */
    public int f3981f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f3982g;

    /* renamed from: h  reason: collision with root package name */
    public int f3983h;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3988m;

    /* renamed from: o  reason: collision with root package name */
    public Drawable f3990o;

    /* renamed from: p  reason: collision with root package name */
    public int f3991p;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3993t;

    /* renamed from: u  reason: collision with root package name */
    public Resources.Theme f3994u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f3995v;
    public boolean w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f3996x;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3998z;
    public float b = 1.0f;
    public m c = m.d;
    public j d = j.c;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3984i = true;

    /* renamed from: j  reason: collision with root package name */
    public int f3985j = -1;

    /* renamed from: k  reason: collision with root package name */
    public int f3986k = -1;

    /* renamed from: l  reason: collision with root package name */
    public g.e f3987l = b0.a.b;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3989n = true;
    public g.h q = new g.h();

    /* renamed from: r  reason: collision with root package name */
    public CachedHashCodeArrayMap f3992r = new CachedHashCodeArrayMap();
    public Class s = Object.class;

    /* renamed from: y  reason: collision with root package name */
    public boolean f3997y = true;

    public static boolean e(int i3, int i5) {
        if ((i3 & i5) != 0) {
            return true;
        }
        return false;
    }

    public a a(a aVar) {
        if (this.f3995v) {
            return clone().a(aVar);
        }
        if (e(aVar.f3979a, 2)) {
            this.b = aVar.b;
        }
        if (e(aVar.f3979a, 262144)) {
            this.w = aVar.w;
        }
        if (e(aVar.f3979a, 1048576)) {
            this.f3998z = aVar.f3998z;
        }
        if (e(aVar.f3979a, 4)) {
            this.c = aVar.c;
        }
        if (e(aVar.f3979a, 8)) {
            this.d = aVar.d;
        }
        if (e(aVar.f3979a, 16)) {
            this.f3980e = aVar.f3980e;
            this.f3981f = 0;
            this.f3979a &= -33;
        }
        if (e(aVar.f3979a, 32)) {
            this.f3981f = aVar.f3981f;
            this.f3980e = null;
            this.f3979a &= -17;
        }
        if (e(aVar.f3979a, 64)) {
            this.f3982g = aVar.f3982g;
            this.f3983h = 0;
            this.f3979a &= -129;
        }
        if (e(aVar.f3979a, 128)) {
            this.f3983h = aVar.f3983h;
            this.f3982g = null;
            this.f3979a &= -65;
        }
        if (e(aVar.f3979a, 256)) {
            this.f3984i = aVar.f3984i;
        }
        if (e(aVar.f3979a, 512)) {
            this.f3986k = aVar.f3986k;
            this.f3985j = aVar.f3985j;
        }
        if (e(aVar.f3979a, 1024)) {
            this.f3987l = aVar.f3987l;
        }
        if (e(aVar.f3979a, 4096)) {
            this.s = aVar.s;
        }
        if (e(aVar.f3979a, 8192)) {
            this.f3990o = aVar.f3990o;
            this.f3991p = 0;
            this.f3979a &= -16385;
        }
        if (e(aVar.f3979a, 16384)) {
            this.f3991p = aVar.f3991p;
            this.f3990o = null;
            this.f3979a &= -8193;
        }
        if (e(aVar.f3979a, 32768)) {
            this.f3994u = aVar.f3994u;
        }
        if (e(aVar.f3979a, 65536)) {
            this.f3989n = aVar.f3989n;
        }
        if (e(aVar.f3979a, 131072)) {
            this.f3988m = aVar.f3988m;
        }
        if (e(aVar.f3979a, 2048)) {
            this.f3992r.putAll((Map) aVar.f3992r);
            this.f3997y = aVar.f3997y;
        }
        if (e(aVar.f3979a, 524288)) {
            this.f3996x = aVar.f3996x;
        }
        if (!this.f3989n) {
            this.f3992r.clear();
            int i3 = this.f3979a;
            this.f3988m = false;
            this.f3979a = i3 & (-133121);
            this.f3997y = true;
        }
        this.f3979a |= aVar.f3979a;
        this.q.b.putAll((SimpleArrayMap) aVar.q.b);
        i();
        return this;
    }

    @Override // 
    /* renamed from: b */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            g.h hVar = new g.h();
            aVar.q = hVar;
            hVar.b.putAll((SimpleArrayMap) this.q.b);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            aVar.f3992r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll((Map) this.f3992r);
            aVar.f3993t = false;
            aVar.f3995v = false;
            return aVar;
        } catch (CloneNotSupportedException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final a c(Class cls) {
        if (this.f3995v) {
            return clone().c(cls);
        }
        this.s = cls;
        this.f3979a |= 4096;
        i();
        return this;
    }

    public final a d(m mVar) {
        if (this.f3995v) {
            return clone().d(mVar);
        }
        this.c = mVar;
        this.f3979a |= 4;
        i();
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Float.compare(aVar.b, this.b) != 0 || this.f3981f != aVar.f3981f || !n.a(this.f3980e, aVar.f3980e) || this.f3983h != aVar.f3983h || !n.a(this.f3982g, aVar.f3982g) || this.f3991p != aVar.f3991p || !n.a(this.f3990o, aVar.f3990o) || this.f3984i != aVar.f3984i || this.f3985j != aVar.f3985j || this.f3986k != aVar.f3986k || this.f3988m != aVar.f3988m || this.f3989n != aVar.f3989n || this.w != aVar.w || this.f3996x != aVar.f3996x || !this.c.equals(aVar.c) || this.d != aVar.d || !this.q.equals(aVar.q) || !this.f3992r.equals(aVar.f3992r) || !this.s.equals(aVar.s) || !n.a(this.f3987l, aVar.f3987l) || !n.a(this.f3994u, aVar.f3994u)) {
            return false;
        }
        return true;
    }

    public final a f(p.m mVar, p.d dVar) {
        if (this.f3995v) {
            return clone().f(mVar, dVar);
        }
        j(p.m.f3070g, mVar);
        return m(dVar, false);
    }

    public final a g(int i3, int i5) {
        if (this.f3995v) {
            return clone().g(i3, i5);
        }
        this.f3986k = i3;
        this.f3985j = i5;
        this.f3979a |= 512;
        i();
        return this;
    }

    public final a h() {
        j jVar = j.d;
        if (this.f3995v) {
            return clone().h();
        }
        this.d = jVar;
        this.f3979a |= 8;
        i();
        return this;
    }

    public final int hashCode() {
        float f4 = this.b;
        char[] cArr = n.f199a;
        return n.g(n.g(n.g(n.g(n.g(n.g(n.g(n.f(this.f3996x ? 1 : 0, n.f(this.w ? 1 : 0, n.f(this.f3989n ? 1 : 0, n.f(this.f3988m ? 1 : 0, n.f(this.f3986k, n.f(this.f3985j, n.f(this.f3984i ? 1 : 0, n.g(n.f(this.f3991p, n.g(n.f(this.f3983h, n.g(n.f(this.f3981f, n.f(Float.floatToIntBits(f4), 17)), this.f3980e)), this.f3982g)), this.f3990o)))))))), this.c), this.d), this.q), this.f3992r), this.s), this.f3987l), this.f3994u);
    }

    public final void i() {
        if (!this.f3993t) {
            return;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final a j(g.g gVar, Object obj) {
        if (this.f3995v) {
            return clone().j(gVar, obj);
        }
        c0.g.b(gVar);
        this.q.b.put(gVar, obj);
        i();
        return this;
    }

    public final a k(b0.b bVar) {
        if (this.f3995v) {
            return clone().k(bVar);
        }
        this.f3987l = bVar;
        this.f3979a |= 1024;
        i();
        return this;
    }

    public final a l() {
        if (this.f3995v) {
            return clone().l();
        }
        this.f3984i = false;
        this.f3979a |= 256;
        i();
        return this;
    }

    public final a m(l lVar, boolean z3) {
        if (this.f3995v) {
            return clone().m(lVar, z3);
        }
        r rVar = new r(lVar, z3);
        n(Bitmap.class, lVar, z3);
        n(Drawable.class, rVar, z3);
        n(BitmapDrawable.class, rVar, z3);
        n(GifDrawable.class, new t.c(lVar), z3);
        i();
        return this;
    }

    public final a n(Class cls, l lVar, boolean z3) {
        if (this.f3995v) {
            return clone().n(cls, lVar, z3);
        }
        c0.g.b(lVar);
        this.f3992r.put(cls, lVar);
        int i3 = this.f3979a;
        this.f3989n = true;
        this.f3979a = 67584 | i3;
        this.f3997y = false;
        if (z3) {
            this.f3979a = i3 | 198656;
            this.f3988m = true;
        }
        i();
        return this;
    }

    public final a o() {
        if (this.f3995v) {
            return clone().o();
        }
        this.f3998z = true;
        this.f3979a |= 1048576;
        i();
        return this;
    }
}

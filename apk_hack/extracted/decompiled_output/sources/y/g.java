package y;

import a1.i;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import c0.n;
import com.bumptech.glide.j;
import i.c0;
import i.g0;
import i.s;
import i.w;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements c, z.c, f {
    public static final boolean C = Log.isLoggable("Request", 2);
    public final RuntimeException A;
    public int B;

    /* renamed from: a  reason: collision with root package name */
    public final String f4002a;
    public final d0.h b;
    public final Object c;
    public final d d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f4003e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bumptech.glide.f f4004f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f4005g;

    /* renamed from: h  reason: collision with root package name */
    public final Class f4006h;

    /* renamed from: i  reason: collision with root package name */
    public final a f4007i;

    /* renamed from: j  reason: collision with root package name */
    public final int f4008j;

    /* renamed from: k  reason: collision with root package name */
    public final int f4009k;

    /* renamed from: l  reason: collision with root package name */
    public final j f4010l;

    /* renamed from: m  reason: collision with root package name */
    public final z.d f4011m;

    /* renamed from: n  reason: collision with root package name */
    public final List f4012n;

    /* renamed from: o  reason: collision with root package name */
    public final a0.a f4013o;

    /* renamed from: p  reason: collision with root package name */
    public final Executor f4014p;
    public g0 q;

    /* renamed from: r  reason: collision with root package name */
    public i.b f4015r;
    public long s;

    /* renamed from: t  reason: collision with root package name */
    public volatile s f4016t;

    /* renamed from: u  reason: collision with root package name */
    public Drawable f4017u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f4018v;
    public Drawable w;

    /* renamed from: x  reason: collision with root package name */
    public int f4019x;

    /* renamed from: y  reason: collision with root package name */
    public int f4020y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f4021z;

    /* JADX WARN: Type inference failed for: r3v3, types: [d0.h, java.lang.Object] */
    public g(Context context, com.bumptech.glide.f fVar, Object obj, Object obj2, Class cls, a aVar, int i3, int i5, j jVar, z.d dVar, List list, d dVar2, s sVar, a0.a aVar2) {
        String str;
        c0.f fVar2 = c0.g.f192a;
        if (C) {
            str = String.valueOf(hashCode());
        } else {
            str = null;
        }
        this.f4002a = str;
        this.b = new Object();
        this.c = obj;
        this.f4003e = context;
        this.f4004f = fVar;
        this.f4005g = obj2;
        this.f4006h = cls;
        this.f4007i = aVar;
        this.f4008j = i3;
        this.f4009k = i5;
        this.f4010l = jVar;
        this.f4011m = dVar;
        this.f4012n = list;
        this.d = dVar2;
        this.f4016t = sVar;
        this.f4013o = aVar2;
        this.f4014p = fVar2;
        this.B = 1;
        if (this.A == null && fVar.f247h.b.containsKey(com.bumptech.glide.d.class)) {
            this.A = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // y.c
    public final boolean a() {
        boolean z3;
        synchronized (this.c) {
            if (this.B == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    public final void b() {
        if (!this.f4021z) {
            this.b.d();
            this.f4011m.h(this);
            i.b bVar = this.f4015r;
            if (bVar != null) {
                synchronized (((s) bVar.d)) {
                    ((w) bVar.b).j((f) bVar.c);
                }
                this.f4015r = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    public final Drawable c() {
        int i3;
        if (this.f4018v == null) {
            a aVar = this.f4007i;
            Drawable drawable = aVar.f3982g;
            this.f4018v = drawable;
            if (drawable == null && (i3 = aVar.f3983h) > 0) {
                this.f4018v = d(i3);
            }
        }
        return this.f4018v;
    }

    @Override // y.c
    public final void clear() {
        synchronized (this.c) {
            try {
                if (!this.f4021z) {
                    this.b.d();
                    if (this.B == 6) {
                        return;
                    }
                    b();
                    g0 g0Var = this.q;
                    if (g0Var != null) {
                        this.q = null;
                    } else {
                        g0Var = null;
                    }
                    d dVar = this.d;
                    if (dVar == null || dVar.c(this)) {
                        this.f4011m.f(c());
                    }
                    this.B = 6;
                    if (g0Var != null) {
                        this.f4016t.getClass();
                        s.g(g0Var);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Drawable d(int i3) {
        Resources.Theme theme = this.f4007i.f3994u;
        if (theme == null) {
            theme = this.f4003e.getTheme();
        }
        com.bumptech.glide.f fVar = this.f4004f;
        return com.bumptech.glide.e.b(fVar, fVar, i3, theme);
    }

    @Override // y.c
    public final boolean e() {
        boolean z3;
        synchronized (this.c) {
            if (this.B == 6) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    public final void f(String str) {
        StringBuilder o5 = i.o(str, " this: ");
        o5.append(this.f4002a);
        Log.v("Request", o5.toString());
    }

    @Override // y.c
    public final void g() {
        d dVar;
        int i3;
        synchronized (this.c) {
            try {
                if (!this.f4021z) {
                    this.b.d();
                    int i5 = c0.h.b;
                    this.s = SystemClock.elapsedRealtimeNanos();
                    int i6 = 3;
                    if (this.f4005g == null) {
                        if (n.h(this.f4008j, this.f4009k)) {
                            this.f4019x = this.f4008j;
                            this.f4020y = this.f4009k;
                        }
                        if (this.w == null) {
                            a aVar = this.f4007i;
                            Drawable drawable = aVar.f3990o;
                            this.w = drawable;
                            if (drawable == null && (i3 = aVar.f3991p) > 0) {
                                this.w = d(i3);
                            }
                        }
                        if (this.w == null) {
                            i6 = 5;
                        }
                        h(new c0("Received null model"), i6);
                        return;
                    }
                    int i7 = this.B;
                    if (i7 != 2) {
                        if (i7 == 4) {
                            k(this.q, 5, false);
                            return;
                        }
                        this.B = 3;
                        if (n.h(this.f4008j, this.f4009k)) {
                            m(this.f4008j, this.f4009k);
                        } else {
                            this.f4011m.a(this);
                        }
                        int i8 = this.B;
                        if ((i8 == 2 || i8 == 3) && ((dVar = this.d) == null || dVar.d(this))) {
                            this.f4011m.c(c());
                        }
                        if (C) {
                            f("finished run method in " + c0.h.a(this.s));
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(c0 c0Var, int i3) {
        int i5;
        int i6;
        this.b.d();
        synchronized (this.c) {
            try {
                c0Var.getClass();
                int i7 = this.f4004f.f248i;
                if (i7 <= i3) {
                    Log.w("Glide", "Load failed for " + this.f4005g + " with size [" + this.f4019x + "x" + this.f4020y + "]", c0Var);
                    if (i7 <= 4) {
                        c0Var.d();
                    }
                }
                Drawable drawable = null;
                this.f4015r = null;
                this.B = 5;
                this.f4021z = true;
                List list = this.f4012n;
                if (list != null) {
                    Iterator it = list.iterator();
                    if (it.hasNext()) {
                        com.bumptech.glide.i.a(it.next());
                        d dVar = this.d;
                        if (dVar != null) {
                            dVar.getRoot().a();
                        }
                        throw null;
                    }
                }
                d dVar2 = this.d;
                if (dVar2 == null || dVar2.d(this)) {
                    if (this.f4005g == null) {
                        if (this.w == null) {
                            a aVar = this.f4007i;
                            Drawable drawable2 = aVar.f3990o;
                            this.w = drawable2;
                            if (drawable2 == null && (i6 = aVar.f3991p) > 0) {
                                this.w = d(i6);
                            }
                        }
                        drawable = this.w;
                    }
                    if (drawable == null) {
                        if (this.f4017u == null) {
                            a aVar2 = this.f4007i;
                            Drawable drawable3 = aVar2.f3980e;
                            this.f4017u = drawable3;
                            if (drawable3 == null && (i5 = aVar2.f3981f) > 0) {
                                this.f4017u = d(i5);
                            }
                        }
                        drawable = this.f4017u;
                    }
                    if (drawable == null) {
                        drawable = c();
                    }
                    this.f4011m.b(drawable);
                }
                this.f4021z = false;
                d dVar3 = this.d;
                if (dVar3 != null) {
                    dVar3.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y.c
    public final boolean i() {
        boolean z3;
        synchronized (this.c) {
            if (this.B == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    @Override // y.c
    public final boolean isRunning() {
        boolean z3;
        synchronized (this.c) {
            int i3 = this.B;
            if (i3 != 2 && i3 != 3) {
                z3 = false;
            }
            z3 = true;
        }
        return z3;
    }

    @Override // y.c
    public final boolean j(c cVar) {
        int i3;
        int i5;
        Object obj;
        Class cls;
        a aVar;
        j jVar;
        int i6;
        int i7;
        int i8;
        Object obj2;
        Class cls2;
        a aVar2;
        j jVar2;
        int i9;
        boolean equals;
        if (!(cVar instanceof g)) {
            return false;
        }
        synchronized (this.c) {
            try {
                i3 = this.f4008j;
                i5 = this.f4009k;
                obj = this.f4005g;
                cls = this.f4006h;
                aVar = this.f4007i;
                jVar = this.f4010l;
                List list = this.f4012n;
                if (list != null) {
                    i6 = list.size();
                } else {
                    i6 = 0;
                }
            } finally {
            }
        }
        g gVar = (g) cVar;
        synchronized (gVar.c) {
            try {
                i7 = gVar.f4008j;
                i8 = gVar.f4009k;
                obj2 = gVar.f4005g;
                cls2 = gVar.f4006h;
                aVar2 = gVar.f4007i;
                jVar2 = gVar.f4010l;
                List list2 = gVar.f4012n;
                if (list2 != null) {
                    i9 = list2.size();
                } else {
                    i9 = 0;
                }
            } finally {
            }
        }
        if (i3 == i7 && i5 == i8) {
            char[] cArr = n.f199a;
            if (obj == null) {
                if (obj2 == null) {
                    equals = true;
                } else {
                    equals = false;
                }
            } else {
                equals = obj.equals(obj2);
            }
            if (equals && cls.equals(cls2) && aVar.equals(aVar2) && jVar == jVar2 && i6 == i9) {
                return true;
            }
        }
        return false;
    }

    public final void k(g0 g0Var, int i3, boolean z3) {
        Object obj;
        String str;
        this.b.d();
        g0 g0Var2 = null;
        try {
            synchronized (this.c) {
                try {
                    this.f4015r = null;
                    if (g0Var == null) {
                        h(new c0("Expected to receive a Resource<R> with an object of " + this.f4006h + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj2 = g0Var.get();
                    try {
                        if (obj2 != null && this.f4006h.isAssignableFrom(obj2.getClass())) {
                            d dVar = this.d;
                            if (dVar != null && !dVar.h(this)) {
                                this.q = null;
                                this.B = 4;
                                this.f4016t.getClass();
                                s.g(g0Var);
                                return;
                            }
                            l(g0Var, obj2, i3);
                            return;
                        }
                        this.q = null;
                        StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                        sb.append(this.f4006h);
                        sb.append(" but instead got ");
                        if (obj2 != null) {
                            obj = obj2.getClass();
                        } else {
                            obj = "";
                        }
                        sb.append(obj);
                        sb.append("{");
                        sb.append(obj2);
                        sb.append("} inside Resource{");
                        sb.append(g0Var);
                        sb.append("}.");
                        if (obj2 != null) {
                            str = "";
                        } else {
                            str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                        }
                        sb.append(str);
                        h(new c0(sb.toString()), 5);
                        this.f4016t.getClass();
                        s.g(g0Var);
                    } catch (Throwable th) {
                        g0Var2 = g0Var;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (g0Var2 != null) {
                this.f4016t.getClass();
                s.g(g0Var2);
            }
            throw th3;
        }
    }

    public final void l(g0 g0Var, Object obj, int i3) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.getRoot().a();
        }
        this.B = 4;
        this.q = g0Var;
        if (this.f4004f.f248i <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + i.z(i3) + " for " + this.f4005g + " with size [" + this.f4019x + "x" + this.f4020y + "] in " + c0.h.a(this.s) + " ms");
        }
        this.f4021z = true;
        try {
            List list = this.f4012n;
            if (list != null) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    com.bumptech.glide.i.a(it.next());
                    throw null;
                }
            }
            this.f4013o.getClass();
            this.f4011m.g(obj);
            this.f4021z = false;
            if (dVar != null) {
                dVar.f(this);
            }
        } catch (Throwable th) {
            this.f4021z = false;
            throw th;
        }
    }

    public final void m(int i3, int i5) {
        Object obj;
        int round;
        int i6 = i3;
        this.b.d();
        Object obj2 = this.c;
        synchronized (obj2) {
            try {
                try {
                    boolean z3 = C;
                    if (z3) {
                        f("Got onSizeReady in " + c0.h.a(this.s));
                    }
                    if (this.B == 3) {
                        this.B = 2;
                        float f4 = this.f4007i.b;
                        if (i6 != Integer.MIN_VALUE) {
                            i6 = Math.round(i6 * f4);
                        }
                        this.f4019x = i6;
                        if (i5 == Integer.MIN_VALUE) {
                            round = i5;
                        } else {
                            round = Math.round(f4 * i5);
                        }
                        this.f4020y = round;
                        if (z3) {
                            f("finished setup for calling load in " + c0.h.a(this.s));
                        }
                        s sVar = this.f4016t;
                        com.bumptech.glide.f fVar = this.f4004f;
                        Object obj3 = this.f4005g;
                        a aVar = this.f4007i;
                        try {
                            obj = obj2;
                            try {
                                this.f4015r = sVar.a(fVar, obj3, aVar.f3987l, this.f4019x, this.f4020y, aVar.s, this.f4006h, this.f4010l, aVar.c, aVar.f3992r, aVar.f3988m, aVar.f3997y, aVar.q, aVar.f3984i, aVar.w, aVar.f3998z, aVar.f3996x, this, this.f4014p);
                                if (this.B != 2) {
                                    this.f4015r = null;
                                }
                                if (z3) {
                                    f("finished onSizeReady in " + c0.h.a(this.s));
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            obj = obj2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
            }
        }
    }

    @Override // y.c
    public final void pause() {
        synchronized (this.c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

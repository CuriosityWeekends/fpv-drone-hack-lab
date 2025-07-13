package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o extends y.a {
    public final Context A;
    public final p B;
    public final Class C;
    public final f D;
    public a E;
    public Object F;
    public ArrayList G;
    public o H;
    public o I;
    public final boolean J = true;
    public boolean K;
    public boolean L;

    static {
        y.e eVar = (y.e) ((y.e) ((y.e) new y.a().d(i.m.c)).h()).l();
    }

    public o(b bVar, p pVar, Class cls, Context context) {
        y.e eVar;
        this.B = pVar;
        this.C = cls;
        this.A = context;
        Map map = pVar.f287a.c.f245f;
        a aVar = (a) map.get(cls);
        if (aVar == null) {
            for (Map.Entry entry : map.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    aVar = (a) entry.getValue();
                }
            }
        }
        this.E = aVar == null ? f.f242k : aVar;
        this.D = bVar.c;
        Iterator it = pVar.f292i.iterator();
        while (it.hasNext()) {
            i.a(it.next());
            p();
        }
        synchronized (pVar) {
            eVar = pVar.f293j;
        }
        a(eVar);
    }

    public final o p() {
        if (this.f3995v) {
            return clone().p();
        }
        i();
        return this;
    }

    @Override // y.a
    /* renamed from: q */
    public final o a(y.a aVar) {
        c0.g.b(aVar);
        return (o) super.a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final y.c r(Object obj, z.d dVar, y.d dVar2, a aVar, j jVar, int i3, int i5, y.a aVar2) {
        y.b bVar;
        y.b bVar2;
        y.b bVar3;
        y.g gVar;
        int i6;
        int i7;
        a aVar3;
        j jVar2;
        int i8;
        int i9;
        if (this.I != null) {
            y.b bVar4 = new y.b(obj, dVar2);
            bVar = bVar4;
            bVar2 = bVar4;
        } else {
            bVar = null;
            bVar2 = dVar2;
        }
        o oVar = this.H;
        if (oVar != null) {
            if (!this.L) {
                a aVar4 = oVar.E;
                if (oVar.J) {
                    aVar3 = aVar;
                } else {
                    aVar3 = aVar4;
                }
                if (y.a.e(oVar.f3979a, 8)) {
                    jVar2 = this.H.d;
                } else {
                    int ordinal = jVar.ordinal();
                    if (ordinal != 0 && ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                jVar2 = j.c;
                            } else {
                                throw new IllegalArgumentException("unknown priority: " + this.d);
                            }
                        } else {
                            jVar2 = j.b;
                        }
                    } else {
                        jVar2 = j.f252a;
                    }
                }
                j jVar3 = jVar2;
                o oVar2 = this.H;
                int i10 = oVar2.f3986k;
                int i11 = oVar2.f3985j;
                if (c0.n.h(i3, i5)) {
                    o oVar3 = this.H;
                    if (!c0.n.h(oVar3.f3986k, oVar3.f3985j)) {
                        i9 = aVar2.f3986k;
                        i8 = aVar2.f3985j;
                        y.h hVar = new y.h(obj, bVar2);
                        Object obj2 = this.F;
                        ArrayList arrayList = this.G;
                        f fVar = this.D;
                        bVar3 = bVar;
                        y.g gVar2 = new y.g(this.A, fVar, obj, obj2, this.C, aVar2, i3, i5, jVar, dVar, arrayList, hVar, fVar.f246g, aVar.f231a);
                        this.L = true;
                        o oVar4 = this.H;
                        y.c r5 = oVar4.r(obj, dVar, hVar, aVar3, jVar3, i9, i8, oVar4);
                        this.L = false;
                        hVar.c = gVar2;
                        hVar.d = r5;
                        gVar = hVar;
                    }
                }
                i8 = i11;
                i9 = i10;
                y.h hVar2 = new y.h(obj, bVar2);
                Object obj22 = this.F;
                ArrayList arrayList2 = this.G;
                f fVar2 = this.D;
                bVar3 = bVar;
                y.g gVar22 = new y.g(this.A, fVar2, obj, obj22, this.C, aVar2, i3, i5, jVar, dVar, arrayList2, hVar2, fVar2.f246g, aVar.f231a);
                this.L = true;
                o oVar42 = this.H;
                y.c r52 = oVar42.r(obj, dVar, hVar2, aVar3, jVar3, i9, i8, oVar42);
                this.L = false;
                hVar2.c = gVar22;
                hVar2.d = r52;
                gVar = hVar2;
            } else {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
        } else {
            bVar3 = bVar;
            Object obj3 = this.F;
            ArrayList arrayList3 = this.G;
            f fVar3 = this.D;
            gVar = new y.g(this.A, fVar3, obj, obj3, this.C, aVar2, i3, i5, jVar, dVar, arrayList3, bVar2, fVar3.f246g, aVar.f231a);
        }
        y.b bVar5 = bVar3;
        if (bVar5 == null) {
            return gVar;
        }
        o oVar5 = this.I;
        int i12 = oVar5.f3986k;
        int i13 = oVar5.f3985j;
        if (c0.n.h(i3, i5)) {
            o oVar6 = this.I;
            if (!c0.n.h(oVar6.f3986k, oVar6.f3985j)) {
                i7 = aVar2.f3986k;
                i6 = aVar2.f3985j;
                o oVar7 = this.I;
                y.c r6 = oVar7.r(obj, dVar, bVar5, oVar7.E, oVar7.d, i7, i6, oVar7);
                bVar5.c = gVar;
                bVar5.d = r6;
                return bVar5;
            }
        }
        i6 = i13;
        i7 = i12;
        o oVar72 = this.I;
        y.c r62 = oVar72.r(obj, dVar, bVar5, oVar72.E, oVar72.d, i7, i6, oVar72);
        bVar5.c = gVar;
        bVar5.d = r62;
        return bVar5;
    }

    @Override // y.a
    /* renamed from: s */
    public final o clone() {
        o oVar = (o) super.clone();
        oVar.E = oVar.E.clone();
        if (oVar.G != null) {
            oVar.G = new ArrayList(oVar.G);
        }
        o oVar2 = oVar.H;
        if (oVar2 != null) {
            oVar.H = oVar2.clone();
        }
        o oVar3 = oVar.I;
        if (oVar3 != null) {
            oVar.I = oVar3.clone();
        }
        return oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Type inference failed for: r3v1, types: [p.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [p.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [p.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [p.d, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.widget.ImageView r5) {
        /*
            r4 = this;
            r0 = 1
            char[] r1 = c0.n.f199a
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            if (r1 != r2) goto Lbe
            c0.g.b(r5)
            int r1 = r4.f3979a
            r2 = 2048(0x800, float:2.87E-42)
            boolean r1 = y.a.e(r1, r2)
            if (r1 != 0) goto L7a
            boolean r1 = r4.f3989n
            if (r1 == 0) goto L7a
            android.widget.ImageView$ScaleType r1 = r5.getScaleType()
            if (r1 == 0) goto L7a
            int[] r1 = com.bumptech.glide.n.f285a
            android.widget.ImageView$ScaleType r2 = r5.getScaleType()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L6a;
                case 2: goto L58;
                case 3: goto L46;
                case 4: goto L46;
                case 5: goto L46;
                case 6: goto L34;
                default: goto L33;
            }
        L33:
            goto L7a
        L34:
            com.bumptech.glide.o r1 = r4.clone()
            p.m r2 = p.m.c
            p.h r3 = new p.h
            r3.<init>()
            y.a r1 = r1.f(r2, r3)
            r1.f3997y = r0
            goto L7b
        L46:
            com.bumptech.glide.o r1 = r4.clone()
            p.m r2 = p.m.b
            p.t r3 = new p.t
            r3.<init>()
            y.a r1 = r1.f(r2, r3)
            r1.f3997y = r0
            goto L7b
        L58:
            com.bumptech.glide.o r1 = r4.clone()
            p.m r2 = p.m.c
            p.h r3 = new p.h
            r3.<init>()
            y.a r1 = r1.f(r2, r3)
            r1.f3997y = r0
            goto L7b
        L6a:
            com.bumptech.glide.o r1 = r4.clone()
            p.m r2 = p.m.d
            p.g r3 = new p.g
            r3.<init>()
            y.a r1 = r1.f(r2, r3)
            goto L7b
        L7a:
            r1 = r4
        L7b:
            com.bumptech.glide.f r2 = r4.D
            t2.b0 r2 = r2.c
            r2.getClass()
            java.lang.Class<android.graphics.Bitmap> r2 = android.graphics.Bitmap.class
            java.lang.Class r3 = r4.C
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L93
            z.b r0 = new z.b
            r2 = 0
            r0.<init>(r5, r2)
            goto La1
        L93:
            java.lang.Class<android.graphics.drawable.Drawable> r2 = android.graphics.drawable.Drawable.class
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto La5
            z.b r2 = new z.b
            r2.<init>(r5, r0)
            r0 = r2
        La1:
            r4.u(r0, r1)
            return
        La5:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unhandled class: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = ", try .as*(Class).transcode(ResourceTranscoder)"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        Lbe:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "You must call this method on the main thread"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.o.t(android.widget.ImageView):void");
    }

    public final void u(z.d dVar, y.a aVar) {
        c0.g.b(dVar);
        if (this.K) {
            y.c r5 = r(new Object(), dVar, null, this.E, aVar.d, aVar.f3986k, aVar.f3985j, aVar);
            y.c e5 = dVar.e();
            if (r5.j(e5) && (aVar.f3984i || !e5.i())) {
                c0.g.c(e5, "Argument must not be null");
                if (!e5.isRunning()) {
                    e5.g();
                    return;
                }
                return;
            }
            this.B.j(dVar);
            dVar.d(r5);
            p pVar = this.B;
            synchronized (pVar) {
                pVar.f289f.f3790a.add(dVar);
                j0.b bVar = pVar.d;
                ((Set) bVar.c).add(r5);
                if (!bVar.b) {
                    r5.g();
                } else {
                    r5.clear();
                    if (Log.isLoggable("RequestTracker", 2)) {
                        Log.v("RequestTracker", "Paused, delaying request");
                    }
                    ((ArrayList) bVar.d).add(r5);
                }
            }
            return;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public final o v(Object obj) {
        if (this.f3995v) {
            return clone().v(obj);
        }
        this.F = obj;
        this.K = true;
        i();
        return this;
    }
}

package j0;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final g0 f2308a;
    public final CopyOnWriteArrayList b;
    public final b2.l c;
    public final boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2309e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2310f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2311g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f2312h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2313i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f2314j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f2315k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f2316l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f2317m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f2318n;

    public t(g0 g0Var, g0 g0Var2, CopyOnWriteArrayList copyOnWriteArrayList, b2.l lVar, boolean z3, int i3, int i5, boolean z5, boolean z6, boolean z7) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        this.f2308a = g0Var;
        this.b = new CopyOnWriteArrayList(copyOnWriteArrayList);
        this.c = lVar;
        this.d = z3;
        this.f2309e = i3;
        this.f2310f = i5;
        this.f2311g = z5;
        this.f2317m = z6;
        this.f2318n = z7;
        if (g0Var2.f2237e != g0Var.f2237e) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.f2312h = z8;
        n nVar = g0Var2.f2238f;
        n nVar2 = g0Var.f2238f;
        if (nVar != nVar2 && nVar2 != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        this.f2313i = z9;
        if (g0Var2.f2236a != g0Var.f2236a) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f2314j = z10;
        if (g0Var2.f2239g != g0Var.f2239g) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f2315k = z11;
        this.f2316l = g0Var2.f2241i != g0Var.f2241i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        boolean z5 = this.f2314j;
        int i3 = this.f2310f;
        g0 g0Var = this.f2308a;
        CopyOnWriteArrayList copyOnWriteArrayList = this.b;
        if (z5 || i3 == 0) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!fVar.b) {
                    fVar.f2234a.onTimelineChanged(g0Var.f2236a, i3);
                }
            }
        }
        if (this.d) {
            Iterator it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                f fVar2 = (f) it2.next();
                if (!fVar2.b) {
                    fVar2.f2234a.onPositionDiscontinuity(this.f2309e);
                }
            }
        }
        if (this.f2313i) {
            Iterator it3 = copyOnWriteArrayList.iterator();
            while (it3.hasNext()) {
                f fVar3 = (f) it3.next();
                if (!fVar3.b) {
                    fVar3.f2234a.onPlayerError(g0Var.f2238f);
                }
            }
        }
        if (this.f2316l) {
            Object obj = g0Var.f2241i.d;
            b2.l lVar = this.c;
            lVar.getClass();
            lVar.b = (b2.k) obj;
            Iterator it4 = copyOnWriteArrayList.iterator();
            while (it4.hasNext()) {
                f fVar4 = (f) it4.next();
                if (!fVar4.b) {
                    fVar4.f2234a.onTracksChanged(g0Var.f2240h, (b2.o) g0Var.f2241i.c);
                }
            }
        }
        if (this.f2315k) {
            Iterator it5 = copyOnWriteArrayList.iterator();
            while (it5.hasNext()) {
                f fVar5 = (f) it5.next();
                if (!fVar5.b) {
                    fVar5.f2234a.onLoadingChanged(g0Var.f2239g);
                }
            }
        }
        if (this.f2312h) {
            Iterator it6 = copyOnWriteArrayList.iterator();
            while (it6.hasNext()) {
                f fVar6 = (f) it6.next();
                if (!fVar6.b) {
                    int i5 = g0Var.f2237e;
                    fVar6.f2234a.onPlayerStateChanged(this.f2317m, i5);
                }
            }
        }
        if (this.f2318n) {
            Iterator it7 = copyOnWriteArrayList.iterator();
            while (it7.hasNext()) {
                f fVar7 = (f) it7.next();
                if (!fVar7.b) {
                    if (g0Var.f2237e == 3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    fVar7.f2234a.onIsPlayingChanged(z3);
                }
            }
        }
        if (this.f2311g) {
            Iterator it8 = copyOnWriteArrayList.iterator();
            while (it8.hasNext()) {
                f fVar8 = (f) it8.next();
                if (!fVar8.b) {
                    fVar8.f2234a.onSeekProcessed();
                }
            }
        }
    }
}

package j0;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q0 extends j.a implements k0 {
    public d2.f A;
    public d2.f B;
    public boolean C;
    public final h[] b;
    public final u c;
    public final Handler d;

    /* renamed from: e  reason: collision with root package name */
    public final p0 f2284e;

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArraySet f2285f;

    /* renamed from: g  reason: collision with root package name */
    public final CopyOnWriteArraySet f2286g;

    /* renamed from: h  reason: collision with root package name */
    public final CopyOnWriteArraySet f2287h;

    /* renamed from: i  reason: collision with root package name */
    public final CopyOnWriteArraySet f2288i;

    /* renamed from: j  reason: collision with root package name */
    public final CopyOnWriteArraySet f2289j;

    /* renamed from: k  reason: collision with root package name */
    public final CopyOnWriteArraySet f2290k;

    /* renamed from: l  reason: collision with root package name */
    public final e2.d f2291l;

    /* renamed from: m  reason: collision with root package name */
    public final k0.c f2292m;

    /* renamed from: n  reason: collision with root package name */
    public final b f2293n;

    /* renamed from: o  reason: collision with root package name */
    public final e f2294o;

    /* renamed from: p  reason: collision with root package name */
    public final j3.b f2295p;
    public Surface q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2296r;
    public SurfaceHolder s;

    /* renamed from: t  reason: collision with root package name */
    public TextureView f2297t;

    /* renamed from: u  reason: collision with root package name */
    public int f2298u;

    /* renamed from: v  reason: collision with root package name */
    public int f2299v;
    public int w;

    /* renamed from: x  reason: collision with root package name */
    public float f2300x;

    /* renamed from: y  reason: collision with root package name */
    public j1.p f2301y;

    /* renamed from: z  reason: collision with root package name */
    public List f2302z;

    /* JADX WARN: Removed duplicated region for block: B:40:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q0(android.content.Context r27, j0.m r28, b2.l r29, j0.b0 r30, e2.d r31, k0.c r32, android.os.Looper r33) {
        /*
            Method dump skipped, instructions count: 827
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.q0.<init>(android.content.Context, j0.m, b2.l, j0.b0, e2.d, k0.c, android.os.Looper):void");
    }

    public final void D(int i3, int i5) {
        if (i3 != this.f2298u || i5 != this.f2299v) {
            this.f2298u = i3;
            this.f2299v = i5;
            Iterator it = this.f2285f.iterator();
            while (it.hasNext()) {
                ((h2.n) it.next()).b(i3, i5);
            }
        }
    }

    public final void E() {
        String str;
        P();
        b bVar = this.f2293n;
        a aVar = (a) bVar.d;
        Context context = (Context) bVar.c;
        if (bVar.b) {
            context.unregisterReceiver(aVar);
            bVar.b = false;
        }
        this.f2294o.a();
        this.f2295p.getClass();
        u uVar = this.c;
        uVar.getClass();
        StringBuilder sb = new StringBuilder("Release ");
        sb.append(Integer.toHexString(System.identityHashCode(uVar)));
        sb.append(" [ExoPlayerLib/2.11.3] [");
        sb.append(g2.w.f1961e);
        sb.append("] [");
        HashSet hashSet = z.f2368a;
        synchronized (z.class) {
            str = z.b;
        }
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        uVar.f2328f.r();
        uVar.f2327e.removeCallbacksAndMessages(null);
        uVar.f2341u = uVar.E(false, false, false, 1);
        F();
        Surface surface = this.q;
        if (surface != null) {
            if (this.f2296r) {
                surface.release();
            }
            this.q = null;
        }
        j1.p pVar = this.f2301y;
        if (pVar != null) {
            ((j1.a) pVar).q(this.f2292m);
            this.f2301y = null;
        }
        e2.d dVar = this.f2291l;
        k0.c cVar = this.f2292m;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) ((e2.q) dVar).c.b;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            g2.h hVar = (g2.h) it.next();
            if (hVar.b == cVar) {
                hVar.c = true;
                copyOnWriteArrayList.remove(hVar);
            }
        }
        this.f2302z = Collections.emptyList();
    }

    public final void F() {
        TextureView textureView = this.f2297t;
        p0 p0Var = this.f2284e;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != p0Var) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f2297t.setSurfaceTextureListener(null);
            }
            this.f2297t = null;
        }
        SurfaceHolder surfaceHolder = this.s;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(p0Var);
            this.s = null;
        }
    }

    public final void G() {
        h[] hVarArr;
        float f4 = this.f2300x * this.f2294o.f2224e;
        for (h hVar : this.b) {
            if (hVar.f2246a == 1) {
                m0 D = this.c.D(hVar);
                D.d(2);
                D.c(Float.valueOf(f4));
                D.b();
            }
        }
    }

    public final void H(h0 h0Var) {
        P();
        u uVar = this.c;
        if (h0Var == null) {
            uVar.getClass();
            h0Var = h0.f2254e;
        }
        if (!uVar.s.equals(h0Var)) {
            uVar.f2339r++;
            uVar.s = h0Var;
            ((Handler) uVar.f2328f.f2351g.b).obtainMessage(4, h0Var).sendToTarget();
            uVar.F(new o(h0Var, 1));
        }
    }

    public final void I(h2.i iVar) {
        h[] hVarArr;
        for (h hVar : this.b) {
            if (hVar.f2246a == 2) {
                m0 D = this.c.D(hVar);
                D.d(8);
                D.c(iVar);
                D.b();
            }
        }
    }

    public final void J(Surface surface) {
        P();
        F();
        if (surface != null) {
            P();
            I(null);
        }
        int i3 = 0;
        L(surface, false);
        if (surface != null) {
            i3 = -1;
        }
        D(i3, i3);
    }

    public final void K(SurfaceHolder surfaceHolder) {
        P();
        F();
        if (surfaceHolder != null) {
            P();
            I(null);
        }
        this.s = surfaceHolder;
        if (surfaceHolder == null) {
            L(null, false);
            D(0, 0);
            return;
        }
        surfaceHolder.addCallback(this.f2284e);
        Surface surface = surfaceHolder.getSurface();
        if (surface != null && surface.isValid()) {
            L(surface, false);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            D(surfaceFrame.width(), surfaceFrame.height());
            return;
        }
        L(null, false);
        D(0, 0);
    }

    public final void L(Surface surface, boolean z3) {
        h[] hVarArr;
        boolean z5;
        ArrayList arrayList = new ArrayList();
        for (h hVar : this.b) {
            if (hVar.f2246a == 2) {
                m0 D = this.c.D(hVar);
                D.d(1);
                D.c(surface);
                D.b();
                arrayList.add(D);
            }
        }
        Surface surface2 = this.q;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    m0 m0Var = (m0) it.next();
                    synchronized (m0Var) {
                        g2.b.h(m0Var.f2272f);
                        if (m0Var.f2271e.getLooper().getThread() != Thread.currentThread()) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        g2.b.h(z5);
                        while (!m0Var.f2273g) {
                            m0Var.wait();
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.f2296r) {
                this.q.release();
            }
        }
        this.q = surface;
        this.f2296r = z3;
    }

    public final void M(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        P();
        F();
        if (textureView != null) {
            P();
            I(null);
        }
        this.f2297t = textureView;
        if (textureView == null) {
            L(null, true);
            D(0, 0);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f2284e);
        if (textureView.isAvailable()) {
            surfaceTexture = textureView.getSurfaceTexture();
        } else {
            surfaceTexture = null;
        }
        if (surfaceTexture == null) {
            L(null, true);
            D(0, 0);
            return;
        }
        L(new Surface(surfaceTexture), true);
        D(textureView.getWidth(), textureView.getHeight());
    }

    public final void N() {
        P();
        u uVar = this.c;
        g0 E = uVar.E(false, false, false, 1);
        uVar.f2337o++;
        ((Handler) uVar.f2328f.f2351g.b).obtainMessage(6, 0, 0).sendToTarget();
        uVar.J(E, false, 4, 1, false);
        j1.p pVar = this.f2301y;
        if (pVar != null) {
            k0.c cVar = this.f2292m;
            ((j1.a) pVar).q(cVar);
            cVar.h();
        }
        this.f2294o.a();
        this.f2302z = Collections.emptyList();
    }

    public final void O(int i3, boolean z3) {
        boolean z5;
        int i5 = 0;
        if (z3 && i3 != -1) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 && i3 != 1) {
            i5 = 1;
        }
        this.c.H(i5, z5);
    }

    public final void P() {
        IllegalStateException illegalStateException;
        if (Looper.myLooper() != s()) {
            if (this.C) {
                illegalStateException = null;
            } else {
                illegalStateException = new IllegalStateException();
            }
            Log.w("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", illegalStateException);
            this.C = true;
        }
    }

    @Override // j0.l0
    public final h0 a() {
        P();
        return this.c.s;
    }

    @Override // j0.l0
    public final void b(j0 j0Var) {
        P();
        this.c.b(j0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r5 != false) goto L10;
     */
    @Override // j0.l0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(boolean r5) {
        /*
            r4 = this;
            r4.P()
            int r0 = r4.getPlaybackState()
            j0.e r1 = r4.f2294o
            r1.getClass()
            r2 = -1
            if (r5 != 0) goto L13
            r1.a()
            goto L22
        L13:
            r3 = 1
            if (r0 != r3) goto L1a
            if (r5 == 0) goto L22
        L18:
            r2 = 1
            goto L22
        L1a:
            int r0 = r1.d
            if (r0 == 0) goto L18
            r1.a()
            goto L18
        L22:
            r4.O(r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.q0.c(boolean):void");
    }

    @Override // j0.l0
    public final boolean e() {
        P();
        return this.c.e();
    }

    @Override // j0.l0
    public final long f() {
        P();
        return this.c.f();
    }

    @Override // j0.l0
    public final long g() {
        P();
        return this.c.g();
    }

    @Override // j0.l0
    public final long getCurrentPosition() {
        P();
        return this.c.getCurrentPosition();
    }

    @Override // j0.l0
    public final long getDuration() {
        P();
        return this.c.getDuration();
    }

    @Override // j0.l0
    public final int getPlaybackState() {
        P();
        return this.c.f2341u.f2237e;
    }

    @Override // j0.l0
    public final int getRepeatMode() {
        P();
        return this.c.f2335m;
    }

    @Override // j0.l0
    public final void h(int i3, long j2) {
        P();
        k0.c cVar = this.f2292m;
        k0.b bVar = cVar.c;
        if (!bVar.f2498h) {
            k0.d f4 = cVar.f();
            bVar.f2498h = true;
            Iterator it = cVar.f2499a.iterator();
            while (it.hasNext()) {
                ((k0.e) it.next()).onSeekStarted(f4);
            }
        }
        this.c.h(i3, j2);
    }

    @Override // j0.l0
    public final long i() {
        P();
        return this.c.i();
    }

    @Override // j0.l0
    public final boolean j() {
        P();
        return this.c.f2333k;
    }

    @Override // j0.l0
    public final void k(boolean z3) {
        P();
        this.c.k(z3);
    }

    @Override // j0.l0
    public final n l() {
        P();
        return this.c.f2341u.f2238f;
    }

    @Override // j0.l0
    public final int m() {
        P();
        return this.c.m();
    }

    @Override // j0.l0
    public final int o() {
        P();
        return this.c.o();
    }

    @Override // j0.l0
    public final int p() {
        P();
        return this.c.f2334l;
    }

    @Override // j0.l0
    public final TrackGroupArray q() {
        P();
        return this.c.f2341u.f2240h;
    }

    @Override // j0.l0
    public final u0 r() {
        P();
        return this.c.f2341u.f2236a;
    }

    @Override // j0.l0
    public final Looper s() {
        return this.c.f2327e.getLooper();
    }

    @Override // j0.l0
    public final void setRepeatMode(int i3) {
        P();
        this.c.setRepeatMode(i3);
    }

    @Override // j0.l0
    public final boolean t() {
        P();
        return this.c.f2336n;
    }

    @Override // j0.l0
    public final void u(j0 j0Var) {
        P();
        this.c.u(j0Var);
    }

    @Override // j0.l0
    public final long v() {
        P();
        return this.c.v();
    }

    @Override // j0.l0
    public final int w() {
        P();
        return this.c.w();
    }

    @Override // j0.l0
    public final b2.o x() {
        P();
        return this.c.x();
    }

    @Override // j0.l0
    public final int y(int i3) {
        P();
        return this.c.y(i3);
    }

    @Override // j0.l0
    public final k0 d() {
        return this;
    }

    @Override // j0.l0
    public final q0 z() {
        return this;
    }
}

package s1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import g2.w;
import j0.p0;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends j0.h implements Handler.Callback {

    /* renamed from: l  reason: collision with root package name */
    public final Handler f3505l;

    /* renamed from: m  reason: collision with root package name */
    public final j f3506m;

    /* renamed from: n  reason: collision with root package name */
    public final h f3507n;

    /* renamed from: o  reason: collision with root package name */
    public final j0.b f3508o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3509p;
    public boolean q;

    /* renamed from: r  reason: collision with root package name */
    public int f3510r;
    public Format s;

    /* renamed from: t  reason: collision with root package name */
    public f f3511t;

    /* renamed from: u  reason: collision with root package name */
    public i f3512u;

    /* renamed from: v  reason: collision with root package name */
    public d f3513v;
    public d w;

    /* renamed from: x  reason: collision with root package name */
    public int f3514x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(p0 p0Var, Looper looper) {
        super(3);
        Handler handler;
        h hVar = h.f3503a;
        this.f3506m = p0Var;
        if (looper == null) {
            handler = null;
        } else {
            int i3 = w.f1960a;
            handler = new Handler(looper, this);
        }
        this.f3505l = handler;
        this.f3507n = hVar;
        this.f3508o = new j0.b(1);
    }

    @Override // j0.h
    public final boolean h() {
        return this.q;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.f3506m.onCues((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // j0.h
    public final boolean i() {
        return true;
    }

    @Override // j0.h
    public final void j() {
        this.s = null;
        List emptyList = Collections.emptyList();
        Handler handler = this.f3505l;
        if (handler != null) {
            handler.obtainMessage(0, emptyList).sendToTarget();
        } else {
            this.f3506m.onCues(emptyList);
        }
        x();
        this.f3511t.release();
        this.f3511t = null;
        this.f3510r = 0;
    }

    @Override // j0.h
    public final void l(long j2, boolean z3) {
        List emptyList = Collections.emptyList();
        Handler handler = this.f3505l;
        if (handler != null) {
            handler.obtainMessage(0, emptyList).sendToTarget();
        } else {
            this.f3506m.onCues(emptyList);
        }
        this.f3509p = false;
        this.q = false;
        if (this.f3510r != 0) {
            x();
            this.f3511t.release();
            this.f3511t = null;
            this.f3510r = 0;
            this.f3511t = this.f3507n.a(this.s);
            return;
        }
        x();
        this.f3511t.flush();
    }

    @Override // j0.h
    public final void p(Format[] formatArr, long j2) {
        Format format = formatArr[0];
        this.s = format;
        if (this.f3511t != null) {
            this.f3510r = 1;
        } else {
            this.f3511t = this.f3507n.a(format);
        }
    }

    @Override // j0.h
    public final void r(long j2, long j5) {
        boolean z3;
        j0.b bVar = this.f3508o;
        if (this.q) {
            return;
        }
        if (this.w == null) {
            this.f3511t.a(j2);
            try {
                this.w = (d) this.f3511t.c();
            } catch (g e5) {
                throw d(e5, this.s);
            }
        }
        if (this.f2247e != 2) {
            return;
        }
        if (this.f3513v != null) {
            long w = w();
            z3 = false;
            while (w <= j2) {
                this.f3514x++;
                w = w();
                z3 = true;
            }
        } else {
            z3 = false;
        }
        d dVar = this.w;
        if (dVar != null) {
            if (dVar.isEndOfStream()) {
                if (!z3 && w() == Long.MAX_VALUE) {
                    if (this.f3510r == 2) {
                        x();
                        this.f3511t.release();
                        this.f3511t = null;
                        this.f3510r = 0;
                        this.f3511t = this.f3507n.a(this.s);
                    } else {
                        x();
                        this.q = true;
                    }
                }
            } else if (this.w.timeUs <= j2) {
                d dVar2 = this.f3513v;
                if (dVar2 != null) {
                    dVar2.release();
                }
                d dVar3 = this.w;
                this.f3513v = dVar3;
                this.w = null;
                this.f3514x = dVar3.b(j2);
                z3 = true;
            }
        }
        if (z3) {
            List i3 = this.f3513v.i(j2);
            Handler handler = this.f3505l;
            if (handler != null) {
                handler.obtainMessage(0, i3).sendToTarget();
            } else {
                this.f3506m.onCues(i3);
            }
        }
        if (this.f3510r == 2) {
            return;
        }
        while (!this.f3509p) {
            try {
                if (this.f3512u == null) {
                    i iVar = (i) this.f3511t.d();
                    this.f3512u = iVar;
                    if (iVar == null) {
                        return;
                    }
                }
                if (this.f3510r == 1) {
                    this.f3512u.setFlags(4);
                    this.f3511t.b(this.f3512u);
                    this.f3512u = null;
                    this.f3510r = 2;
                    return;
                }
                int q = q(bVar, this.f3512u, false);
                if (q == -4) {
                    if (this.f3512u.isEndOfStream()) {
                        this.f3509p = true;
                    } else {
                        i iVar2 = this.f3512u;
                        iVar2.f3504f = ((Format) bVar.d).f315m;
                        iVar2.d();
                    }
                    this.f3511t.b(this.f3512u);
                    this.f3512u = null;
                } else if (q == -3) {
                    return;
                }
            } catch (g e6) {
                throw d(e6, this.s);
            }
        }
    }

    @Override // j0.h
    public final int u(Format format) {
        this.f3507n.getClass();
        String str = format.f311i;
        if (!"text/vtt".equals(str) && !"text/x-ssa".equals(str) && !"application/ttml+xml".equals(str) && !"application/x-mp4-vtt".equals(str) && !"application/x-subrip".equals(str) && !"application/x-quicktime-tx3g".equals(str) && !"application/cea-608".equals(str) && !"application/x-mp4-cea-608".equals(str) && !"application/cea-708".equals(str) && !"application/dvbsubs".equals(str) && !"application/pgs".equals(str)) {
            if ("text".equals(g2.k.d(format.f311i))) {
                return 1;
            }
            return 0;
        } else if (format.f314l == null) {
            return 4;
        } else {
            return 2;
        }
    }

    public final long w() {
        int i3 = this.f3514x;
        if (i3 != -1 && i3 < this.f3513v.n()) {
            return this.f3513v.e(this.f3514x);
        }
        return Long.MAX_VALUE;
    }

    public final void x() {
        this.f3512u = null;
        this.f3514x = -1;
        d dVar = this.f3513v;
        if (dVar != null) {
            dVar.release();
            this.f3513v = null;
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.release();
            this.w = null;
        }
    }
}

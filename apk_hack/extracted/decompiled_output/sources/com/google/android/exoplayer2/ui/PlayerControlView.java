package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c2.c;
import c2.d;
import c2.e;
import c2.f;
import c2.g;
import c2.i;
import c2.k;
import c2.l;
import c2.m;
import c2.n;
import c2.p;
import com.google.android.exoplayer2.ui.PlayerControlView;
import g2.b;
import g2.w;
import j.a;
import j0.i0;
import j0.j;
import j0.l0;
import j0.s0;
import j0.t0;
import j0.u0;
import j0.z;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PlayerControlView extends FrameLayout {

    /* renamed from: c0  reason: collision with root package name */
    public static final /* synthetic */ int f438c0 = 0;
    public final Drawable A;
    public final Drawable B;
    public final float C;
    public final float D;
    public final String E;
    public final String F;
    public l0 G;
    public j H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public long S;
    public long[] T;
    public boolean[] U;
    public final long[] V;
    public final boolean[] W;

    /* renamed from: a  reason: collision with root package name */
    public final d f439a;
    public final CopyOnWriteArrayList b;

    /* renamed from: b0  reason: collision with root package name */
    public long f440b0;
    public final View c;
    public final View d;

    /* renamed from: e  reason: collision with root package name */
    public final View f441e;

    /* renamed from: f  reason: collision with root package name */
    public final View f442f;

    /* renamed from: g  reason: collision with root package name */
    public final View f443g;

    /* renamed from: h  reason: collision with root package name */
    public final View f444h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f445i;

    /* renamed from: j  reason: collision with root package name */
    public final ImageView f446j;

    /* renamed from: k  reason: collision with root package name */
    public final View f447k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f448l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f449m;

    /* renamed from: n  reason: collision with root package name */
    public final p f450n;

    /* renamed from: o  reason: collision with root package name */
    public final StringBuilder f451o;

    /* renamed from: p  reason: collision with root package name */
    public final Formatter f452p;
    public final s0 q;

    /* renamed from: r  reason: collision with root package name */
    public final t0 f453r;
    public final c s;

    /* renamed from: t  reason: collision with root package name */
    public final c f454t;

    /* renamed from: u  reason: collision with root package name */
    public final Drawable f455u;

    /* renamed from: v  reason: collision with root package name */
    public final Drawable f456v;
    public final Drawable w;

    /* renamed from: x  reason: collision with root package name */
    public final String f457x;

    /* renamed from: y  reason: collision with root package name */
    public final String f458y;

    /* renamed from: z  reason: collision with root package name */
    public final String f459z;

    static {
        z.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public final boolean a(KeyEvent keyEvent) {
        int i3;
        int i5;
        int keyCode = keyEvent.getKeyCode();
        l0 l0Var = this.G;
        if (l0Var == null || (keyCode != 90 && keyCode != 89 && keyCode != 85 && keyCode != 126 && keyCode != 127 && keyCode != 87 && keyCode != 88)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                a aVar = (a) l0Var;
                u0 r5 = aVar.r();
                if (!r5.o() && r5.m(aVar.w(), (t0) aVar.f2183a, 0L).d && (i5 = this.N) > 0) {
                    h(aVar, i5);
                }
            } else if (keyCode == 89) {
                a aVar2 = (a) l0Var;
                u0 r6 = aVar2.r();
                if (!r6.o() && r6.m(aVar2.w(), (t0) aVar2.f2183a, 0L).d && (i3 = this.M) > 0) {
                    h(aVar2, -i3);
                }
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode != 85) {
                    if (keyCode != 87) {
                        if (keyCode != 88) {
                            if (keyCode != 126) {
                                if (keyCode == 127) {
                                    ((j3.a) this.H).getClass();
                                    l0Var.c(false);
                                }
                            } else {
                                ((j3.a) this.H).getClass();
                                l0Var.c(true);
                            }
                        } else {
                            f(l0Var);
                        }
                    } else {
                        e(l0Var);
                    }
                } else {
                    ((j3.a) this.H).getClass();
                    l0Var.c(!l0Var.j());
                }
            }
        }
        return true;
    }

    public final void b() {
        if (d()) {
            setVisibility(8);
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                getVisibility();
                g gVar = (g) ((f) it.next());
                gVar.getClass();
                gVar.f204a.i();
            }
            removeCallbacks(this.s);
            removeCallbacks(this.f454t);
            this.S = -9223372036854775807L;
        }
    }

    public final void c() {
        c cVar = this.f454t;
        removeCallbacks(cVar);
        if (this.O > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = this.O;
            this.S = uptimeMillis + j2;
            if (this.I) {
                postDelayed(cVar, j2);
                return;
            }
            return;
        }
        this.S = -9223372036854775807L;
    }

    public final boolean d() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!a(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f454t);
        } else if (motionEvent.getAction() == 1) {
            c();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(l0 l0Var) {
        int e5;
        u0 r5 = l0Var.r();
        if (!r5.o() && !l0Var.e()) {
            int w = l0Var.w();
            a aVar = (a) l0Var;
            u0 r6 = aVar.r();
            if (r6.o()) {
                e5 = -1;
            } else {
                int w3 = aVar.w();
                int repeatMode = aVar.getRepeatMode();
                if (repeatMode == 1) {
                    repeatMode = 0;
                }
                e5 = r6.e(w3, repeatMode, aVar.t());
            }
            if (e5 != -1) {
                g(l0Var, e5, -9223372036854775807L);
            } else if (r5.m(w, this.f453r, 0L).f2321e) {
                g(l0Var, w, -9223372036854775807L);
            }
        }
    }

    public final void f(l0 l0Var) {
        int k5;
        u0 r5 = l0Var.r();
        if (!r5.o() && !l0Var.e()) {
            int w = l0Var.w();
            t0 t0Var = this.f453r;
            r5.m(w, t0Var, 0L);
            a aVar = (a) l0Var;
            u0 r6 = aVar.r();
            if (r6.o()) {
                k5 = -1;
            } else {
                int w3 = aVar.w();
                int repeatMode = aVar.getRepeatMode();
                if (repeatMode == 1) {
                    repeatMode = 0;
                }
                k5 = r6.k(w3, repeatMode, aVar.t());
            }
            if (k5 != -1 && (l0Var.getCurrentPosition() <= 3000 || (t0Var.f2321e && !t0Var.d))) {
                g(l0Var, k5, -9223372036854775807L);
            } else {
                g(l0Var, w, 0L);
            }
        }
    }

    public final void g(l0 l0Var, int i3, long j2) {
        ((j3.a) this.H).getClass();
        l0Var.h(i3, j2);
    }

    @Nullable
    public l0 getPlayer() {
        return this.G;
    }

    public int getRepeatToggleModes() {
        return this.Q;
    }

    public boolean getShowShuffleButton() {
        return this.R;
    }

    public int getShowTimeoutMs() {
        return this.O;
    }

    public boolean getShowVrButton() {
        View view = this.f447k;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void h(l0 l0Var, long j2) {
        long currentPosition = l0Var.getCurrentPosition() + j2;
        long duration = l0Var.getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        g(l0Var, l0Var.w(), Math.max(currentPosition, 0L));
    }

    public final void i(View view, boolean z3) {
        float f4;
        if (view == null) {
            return;
        }
        view.setEnabled(z3);
        if (z3) {
            f4 = this.C;
        } else {
            f4 = this.D;
        }
        view.setAlpha(f4);
        view.setVisibility(0);
    }

    public final boolean j() {
        l0 l0Var = this.G;
        if (l0Var != null && l0Var.getPlaybackState() != 4 && this.G.getPlaybackState() != 1 && this.G.j()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0095, code lost:
        if (r0 != (-1)) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            r11 = this;
            boolean r0 = r11.d()
            if (r0 == 0) goto Lba
            boolean r0 = r11.I
            if (r0 != 0) goto Lc
            goto Lba
        Lc:
            j0.l0 r0 = r11.G
            r1 = 0
            if (r0 == 0) goto L9b
            j0.u0 r2 = r0.r()
            boolean r3 = r2.o()
            if (r3 != 0) goto L9b
            boolean r3 = r0.e()
            if (r3 != 0) goto L9b
            int r3 = r0.w()
            r4 = 0
            j0.t0 r6 = r11.f453r
            r2.m(r3, r6, r4)
            boolean r2 = r6.d
            r3 = 1
            r4 = -1
            if (r2 != 0) goto L5d
            boolean r5 = r6.f2321e
            if (r5 == 0) goto L5d
            r5 = r0
            j.a r5 = (j.a) r5
            j0.u0 r7 = r5.r()
            boolean r8 = r7.o()
            if (r8 == 0) goto L45
            r5 = -1
            goto L58
        L45:
            int r8 = r5.w()
            int r9 = r5.getRepeatMode()
            if (r9 != r3) goto L50
            r9 = 0
        L50:
            boolean r5 = r5.t()
            int r5 = r7.k(r8, r9, r5)
        L58:
            if (r5 == r4) goto L5b
            goto L5d
        L5b:
            r5 = 0
            goto L5e
        L5d:
            r5 = 1
        L5e:
            if (r2 == 0) goto L66
            int r7 = r11.M
            if (r7 <= 0) goto L66
            r7 = 1
            goto L67
        L66:
            r7 = 0
        L67:
            if (r2 == 0) goto L6f
            int r8 = r11.N
            if (r8 <= 0) goto L6f
            r8 = 1
            goto L70
        L6f:
            r8 = 0
        L70:
            boolean r6 = r6.f2321e
            if (r6 != 0) goto L97
            j.a r0 = (j.a) r0
            j0.u0 r6 = r0.r()
            boolean r9 = r6.o()
            if (r9 == 0) goto L82
            r0 = -1
            goto L95
        L82:
            int r9 = r0.w()
            int r10 = r0.getRepeatMode()
            if (r10 != r3) goto L8d
            r10 = 0
        L8d:
            boolean r0 = r0.t()
            int r0 = r6.e(r9, r10, r0)
        L95:
            if (r0 == r4) goto L98
        L97:
            r1 = 1
        L98:
            r0 = r1
            r1 = r5
            goto L9f
        L9b:
            r0 = 0
            r2 = 0
            r7 = 0
            r8 = 0
        L9f:
            android.view.View r3 = r11.c
            r11.i(r3, r1)
            android.view.View r1 = r11.f444h
            r11.i(r1, r7)
            android.view.View r1 = r11.f443g
            r11.i(r1, r8)
            android.view.View r1 = r11.d
            r11.i(r1, r0)
            c2.p r0 = r11.f450n
            if (r0 == 0) goto Lba
            r0.setEnabled(r2)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.k():void");
    }

    public final void l() {
        boolean z3;
        int i3;
        if (d() && this.I) {
            boolean j2 = j();
            View view = this.f441e;
            int i5 = 8;
            boolean z5 = true;
            if (view != null) {
                if (j2 && view.isFocused()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (j2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                view.setVisibility(i3);
            } else {
                z3 = false;
            }
            View view2 = this.f442f;
            if (view2 != null) {
                z3 |= (j2 || !view2.isFocused()) ? false : false;
                if (j2) {
                    i5 = 0;
                }
                view2.setVisibility(i5);
            }
            if (z3) {
                boolean j5 = j();
                if (!j5 && view != null) {
                    view.requestFocus();
                } else if (j5 && view2 != null) {
                    view2.requestFocus();
                }
            }
        }
    }

    public final void m() {
        long j2;
        long j5;
        int playbackState;
        long j6;
        if (d() && this.I) {
            l0 l0Var = this.G;
            if (l0Var != null) {
                j2 = l0Var.f() + this.f440b0;
                j5 = l0Var.v() + this.f440b0;
            } else {
                j2 = 0;
                j5 = 0;
            }
            TextView textView = this.f449m;
            if (textView != null && !this.L) {
                textView.setText(w.p(this.f451o, this.f452p, j2));
            }
            p pVar = this.f450n;
            if (pVar != null) {
                pVar.setPosition(j2);
                pVar.setBufferedPosition(j5);
            }
            c cVar = this.s;
            removeCallbacks(cVar);
            if (l0Var == null) {
                playbackState = 1;
            } else {
                playbackState = l0Var.getPlaybackState();
            }
            long j7 = 1000;
            if (l0Var != null && ((a) l0Var).B()) {
                if (pVar != null) {
                    j6 = pVar.getPreferredUpdateDelay();
                } else {
                    j6 = 1000;
                }
                long min = Math.min(j6, 1000 - (j2 % 1000));
                float f4 = l0Var.a().f2255a;
                if (f4 > 0.0f) {
                    j7 = ((float) min) / f4;
                }
                postDelayed(cVar, w.i(j7, this.P, 1000L));
            } else if (playbackState != 4 && playbackState != 1) {
                postDelayed(cVar, 1000L);
            }
        }
    }

    public final void n() {
        ImageView imageView;
        if (d() && this.I && (imageView = this.f445i) != null) {
            if (this.Q == 0) {
                imageView.setVisibility(8);
                return;
            }
            l0 l0Var = this.G;
            String str = this.f457x;
            Drawable drawable = this.f455u;
            if (l0Var == null) {
                i(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            i(imageView, true);
            int repeatMode = l0Var.getRepeatMode();
            if (repeatMode != 0) {
                if (repeatMode != 1) {
                    if (repeatMode == 2) {
                        imageView.setImageDrawable(this.w);
                        imageView.setContentDescription(this.f459z);
                    }
                } else {
                    imageView.setImageDrawable(this.f456v);
                    imageView.setContentDescription(this.f458y);
                }
            } else {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            }
            imageView.setVisibility(0);
        }
    }

    public final void o() {
        ImageView imageView;
        if (d() && this.I && (imageView = this.f446j) != null) {
            l0 l0Var = this.G;
            if (!this.R) {
                imageView.setVisibility(8);
                return;
            }
            String str = this.F;
            Drawable drawable = this.B;
            if (l0Var == null) {
                i(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            i(imageView, true);
            if (l0Var.t()) {
                drawable = this.A;
            }
            imageView.setImageDrawable(drawable);
            if (l0Var.t()) {
                str = this.E;
            }
            imageView.setContentDescription(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
        long j2 = this.S;
        if (j2 != -9223372036854775807L) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                b();
            } else {
                postDelayed(this.f454t, uptimeMillis);
            }
        } else if (d()) {
            c();
        }
        l();
        k();
        n();
        o();
        p();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I = false;
        removeCallbacks(this.s);
        removeCallbacks(this.f454t);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.p():void");
    }

    public void setControlDispatcher(@Nullable j jVar) {
        if (jVar == null) {
            jVar = new j3.a(8);
        }
        this.H = jVar;
    }

    public void setFastForwardIncrementMs(int i3) {
        this.N = i3;
        k();
    }

    public void setPlayer(@Nullable l0 l0Var) {
        boolean z3;
        boolean z5 = false;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z3 = true;
        } else {
            z3 = false;
        }
        b.h(z3);
        b.e((l0Var == null || l0Var.s() == Looper.getMainLooper()) ? true : true);
        l0 l0Var2 = this.G;
        if (l0Var2 == l0Var) {
            return;
        }
        d dVar = this.f439a;
        if (l0Var2 != null) {
            l0Var2.u(dVar);
        }
        this.G = l0Var;
        if (l0Var != null) {
            l0Var.b(dVar);
        }
        l();
        k();
        n();
        o();
        p();
    }

    public void setRepeatToggleModes(int i3) {
        this.Q = i3;
        l0 l0Var = this.G;
        if (l0Var != null) {
            int repeatMode = l0Var.getRepeatMode();
            if (i3 == 0 && repeatMode != 0) {
                j jVar = this.H;
                l0 l0Var2 = this.G;
                ((j3.a) jVar).getClass();
                l0Var2.setRepeatMode(0);
            } else if (i3 == 1 && repeatMode == 2) {
                j jVar2 = this.H;
                l0 l0Var3 = this.G;
                ((j3.a) jVar2).getClass();
                l0Var3.setRepeatMode(1);
            } else if (i3 == 2 && repeatMode == 1) {
                j jVar3 = this.H;
                l0 l0Var4 = this.G;
                ((j3.a) jVar3).getClass();
                l0Var4.setRepeatMode(2);
            }
        }
        n();
    }

    public void setRewindIncrementMs(int i3) {
        this.M = i3;
        k();
    }

    public void setShowMultiWindowTimeBar(boolean z3) {
        this.J = z3;
        p();
    }

    public void setShowShuffleButton(boolean z3) {
        this.R = z3;
        o();
    }

    public void setShowTimeoutMs(int i3) {
        this.O = i3;
        if (d()) {
            c();
        }
    }

    public void setShowVrButton(boolean z3) {
        int i3;
        View view = this.f447k;
        if (view != null) {
            if (z3) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public void setTimeBarMinUpdateInterval(int i3) {
        this.P = w.h(i3, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f447k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, attributeSet);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [c2.c] */
    /* JADX WARN: Type inference failed for: r1v3, types: [c2.c] */
    public PlayerControlView(Context context, AttributeSet attributeSet, int i3, AttributeSet attributeSet2) {
        super(context, attributeSet, i3);
        int i5 = l.exo_player_control_view;
        this.M = 5000;
        this.N = 15000;
        this.O = 5000;
        this.Q = 0;
        this.P = 200;
        this.S = -9223372036854775807L;
        this.R = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, n.PlayerControlView, 0, 0);
            try {
                this.M = obtainStyledAttributes.getInt(n.PlayerControlView_rewind_increment, this.M);
                this.N = obtainStyledAttributes.getInt(n.PlayerControlView_fastforward_increment, this.N);
                this.O = obtainStyledAttributes.getInt(n.PlayerControlView_show_timeout, this.O);
                i5 = obtainStyledAttributes.getResourceId(n.PlayerControlView_controller_layout_id, i5);
                this.Q = obtainStyledAttributes.getInt(n.PlayerControlView_repeat_toggle_modes, this.Q);
                this.R = obtainStyledAttributes.getBoolean(n.PlayerControlView_show_shuffle_button, this.R);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(n.PlayerControlView_time_bar_min_update_interval, this.P));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.b = new CopyOnWriteArrayList();
        this.q = new s0();
        this.f453r = new t0();
        StringBuilder sb = new StringBuilder();
        this.f451o = sb;
        this.f452p = new Formatter(sb, Locale.getDefault());
        this.T = new long[0];
        this.U = new boolean[0];
        this.V = new long[0];
        this.W = new boolean[0];
        d dVar = new d(this);
        this.f439a = dVar;
        this.H = new j3.a(8);
        this.s = new Runnable(this) { // from class: c2.c
            public final /* synthetic */ PlayerControlView b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView playerControlView = this.b;
                switch (r2) {
                    case 0:
                        int i6 = PlayerControlView.f438c0;
                        playerControlView.m();
                        return;
                    default:
                        playerControlView.b();
                        return;
                }
            }
        };
        this.f454t = new Runnable(this) { // from class: c2.c
            public final /* synthetic */ PlayerControlView b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView playerControlView = this.b;
                switch (r2) {
                    case 0:
                        int i6 = PlayerControlView.f438c0;
                        playerControlView.m();
                        return;
                    default:
                        playerControlView.b();
                        return;
                }
            }
        };
        LayoutInflater.from(context).inflate(i5, this);
        setDescendantFocusability(262144);
        int i6 = c2.j.exo_progress;
        p pVar = (p) findViewById(i6);
        View findViewById = findViewById(c2.j.exo_progress_placeholder);
        if (pVar != null) {
            this.f450n = pVar;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i6);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f450n = defaultTimeBar;
        } else {
            this.f450n = null;
        }
        this.f448l = (TextView) findViewById(c2.j.exo_duration);
        this.f449m = (TextView) findViewById(c2.j.exo_position);
        p pVar2 = this.f450n;
        if (pVar2 != null) {
            ((DefaultTimeBar) pVar2).w.add(dVar);
        }
        View findViewById2 = findViewById(c2.j.exo_play);
        this.f441e = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(dVar);
        }
        View findViewById3 = findViewById(c2.j.exo_pause);
        this.f442f = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(dVar);
        }
        View findViewById4 = findViewById(c2.j.exo_prev);
        this.c = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(dVar);
        }
        View findViewById5 = findViewById(c2.j.exo_next);
        this.d = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(dVar);
        }
        View findViewById6 = findViewById(c2.j.exo_rew);
        this.f444h = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(dVar);
        }
        View findViewById7 = findViewById(c2.j.exo_ffwd);
        this.f443g = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(dVar);
        }
        ImageView imageView = (ImageView) findViewById(c2.j.exo_repeat_toggle);
        this.f445i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(dVar);
        }
        ImageView imageView2 = (ImageView) findViewById(c2.j.exo_shuffle);
        this.f446j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(dVar);
        }
        this.f447k = findViewById(c2.j.exo_vr);
        setShowVrButton(false);
        Resources resources = context.getResources();
        this.C = resources.getInteger(k.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = resources.getInteger(k.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f455u = resources.getDrawable(i.exo_controls_repeat_off);
        this.f456v = resources.getDrawable(i.exo_controls_repeat_one);
        this.w = resources.getDrawable(i.exo_controls_repeat_all);
        this.A = resources.getDrawable(i.exo_controls_shuffle_on);
        this.B = resources.getDrawable(i.exo_controls_shuffle_off);
        this.f457x = resources.getString(m.exo_controls_repeat_off_description);
        this.f458y = resources.getString(m.exo_controls_repeat_one_description);
        this.f459z = resources.getString(m.exo_controls_repeat_all_description);
        this.E = resources.getString(m.exo_controls_shuffle_on_description);
        this.F = resources.getString(m.exo_controls_shuffle_off_description);
    }

    public void setPlaybackPreparer(@Nullable i0 i0Var) {
    }

    public void setProgressUpdateListener(@Nullable e eVar) {
    }
}

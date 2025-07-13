package t;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import c0.n;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.o;
import com.bumptech.glide.p;
import g.l;
import i.m;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final f.d f3557a;
    public final Handler b;
    public final ArrayList c;
    public final p d;

    /* renamed from: e  reason: collision with root package name */
    public final j.b f3558e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3559f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3560g;

    /* renamed from: h  reason: collision with root package name */
    public o f3561h;

    /* renamed from: i  reason: collision with root package name */
    public d f3562i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3563j;

    /* renamed from: k  reason: collision with root package name */
    public d f3564k;

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f3565l;

    /* renamed from: m  reason: collision with root package name */
    public d f3566m;

    /* renamed from: n  reason: collision with root package name */
    public int f3567n;

    /* renamed from: o  reason: collision with root package name */
    public int f3568o;

    /* renamed from: p  reason: collision with root package name */
    public int f3569p;

    public g(com.bumptech.glide.b bVar, f.d dVar, int i3, int i5, Bitmap bitmap) {
        o.e eVar = o.e.b;
        j.b bVar2 = bVar.f234a;
        com.bumptech.glide.f fVar = bVar.c;
        Context baseContext = fVar.getBaseContext();
        c0.g.c(baseContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        p b = com.bumptech.glide.b.b(baseContext).f236f.b(baseContext);
        Context baseContext2 = fVar.getBaseContext();
        c0.g.c(baseContext2, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        p b5 = com.bumptech.glide.b.b(baseContext2).f236f.b(baseContext2);
        b5.getClass();
        o a5 = new o(b5.f287a, b5, Bitmap.class, b5.b).a(p.f286k).a(((y.e) ((y.e) ((y.e) new y.a().d(m.b)).o()).l()).g(i3, i5));
        this.c = new ArrayList();
        this.d = b;
        Handler handler = new Handler(Looper.getMainLooper(), new f(this));
        this.f3558e = bVar2;
        this.b = handler;
        this.f3561h = a5;
        this.f3557a = dVar;
        c(eVar, bitmap);
    }

    public final void a() {
        int i3;
        int i5;
        if (this.f3559f && !this.f3560g) {
            d dVar = this.f3566m;
            if (dVar != null) {
                this.f3566m = null;
                b(dVar);
                return;
            }
            this.f3560g = true;
            f.d dVar2 = this.f3557a;
            f.b bVar = dVar2.f1791l;
            int i6 = bVar.c;
            if (i6 > 0 && (i5 = dVar2.f1790k) >= 0) {
                if (i5 >= 0 && i5 < i6) {
                    i3 = ((f.a) bVar.f1775e.get(i5)).f1771i;
                } else {
                    i3 = -1;
                }
            } else {
                i3 = 0;
            }
            long uptimeMillis = SystemClock.uptimeMillis() + i3;
            int i7 = (dVar2.f1790k + 1) % dVar2.f1791l.c;
            dVar2.f1790k = i7;
            this.f3564k = new d(this.b, i7, uptimeMillis);
            o v5 = this.f3561h.a((y.e) new y.a().k(new b0.b(Double.valueOf(Math.random())))).v(dVar2);
            v5.u(this.f3564k, v5);
        }
    }

    public final void b(d dVar) {
        g gVar;
        int i3;
        this.f3560g = false;
        boolean z3 = this.f3563j;
        Handler handler = this.b;
        if (z3) {
            handler.obtainMessage(2, dVar).sendToTarget();
        } else if (!this.f3559f) {
            this.f3566m = dVar;
        } else {
            if (dVar.f3555g != null) {
                Bitmap bitmap = this.f3565l;
                if (bitmap != null) {
                    this.f3558e.e(bitmap);
                    this.f3565l = null;
                }
                d dVar2 = this.f3562i;
                this.f3562i = dVar;
                ArrayList arrayList = this.c;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    GifDrawable gifDrawable = (GifDrawable) ((e) arrayList.get(size));
                    Drawable.Callback callback = gifDrawable.getCallback();
                    while (callback instanceof Drawable) {
                        callback = ((Drawable) callback).getCallback();
                    }
                    if (callback == null) {
                        gifDrawable.stop();
                        gifDrawable.invalidateSelf();
                    } else {
                        gifDrawable.invalidateSelf();
                        d dVar3 = gifDrawable.f267a.f3551a.f3562i;
                        if (dVar3 != null) {
                            i3 = dVar3.f3553e;
                        } else {
                            i3 = -1;
                        }
                        if (i3 == gVar.f3557a.f1791l.c - 1) {
                            gifDrawable.f269f++;
                        }
                        int i5 = gifDrawable.f270g;
                        if (i5 != -1 && gifDrawable.f269f >= i5) {
                            ArrayList arrayList2 = gifDrawable.f274k;
                            if (arrayList2 != null) {
                                int size2 = arrayList2.size();
                                for (int i6 = 0; i6 < size2; i6++) {
                                    ((Animatable2Compat.AnimationCallback) gifDrawable.f274k.get(i6)).onAnimationEnd(gifDrawable);
                                }
                            }
                            gifDrawable.stop();
                        }
                    }
                }
                if (dVar2 != null) {
                    handler.obtainMessage(2, dVar2).sendToTarget();
                }
            }
            a();
        }
    }

    public final void c(l lVar, Bitmap bitmap) {
        c0.g.c(lVar, "Argument must not be null");
        c0.g.c(bitmap, "Argument must not be null");
        this.f3565l = bitmap;
        this.f3561h = this.f3561h.a(new y.a().m(lVar, true));
        this.f3567n = n.c(bitmap);
        this.f3568o = bitmap.getWidth();
        this.f3569p = bitmap.getHeight();
    }
}

package t;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import c0.n;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements z.d {

    /* renamed from: a  reason: collision with root package name */
    public final int f3552a;
    public final int b;
    public y.c c;
    public final Handler d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3553e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3554f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f3555g;

    public d(Handler handler, int i3, long j2) {
        if (n.h(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            this.f3552a = Integer.MIN_VALUE;
            this.b = Integer.MIN_VALUE;
            this.d = handler;
            this.f3553e = i3;
            this.f3554f = j2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
    }

    @Override // z.d
    public final void a(z.c cVar) {
        ((y.g) cVar).m(this.f3552a, this.b);
    }

    @Override // z.d
    public final void d(y.c cVar) {
        this.c = cVar;
    }

    @Override // z.d
    public final y.c e() {
        return this.c;
    }

    @Override // z.d
    public final void f(Drawable drawable) {
        this.f3555g = null;
    }

    @Override // z.d
    public final void g(Object obj) {
        this.f3555g = (Bitmap) obj;
        Handler handler = this.d;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f3554f);
    }

    @Override // z.d
    public final void b(Drawable drawable) {
    }

    @Override // z.d
    public final void c(Drawable drawable) {
    }

    @Override // z.d
    public final void h(z.c cVar) {
    }

    @Override // v.f
    public final void i() {
    }

    @Override // v.f
    public final void onStart() {
    }

    @Override // v.f
    public final void onStop() {
    }
}

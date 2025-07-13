package l0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class q implements f {
    public d b;
    public d c;
    public d d;

    /* renamed from: e  reason: collision with root package name */
    public d f2562e;

    /* renamed from: f  reason: collision with root package name */
    public ByteBuffer f2563f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f2564g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2565h;

    public q() {
        ByteBuffer byteBuffer = f.f2535a;
        this.f2563f = byteBuffer;
        this.f2564g = byteBuffer;
        d dVar = d.f2533e;
        this.d = dVar;
        this.f2562e = dVar;
        this.b = dVar;
        this.c = dVar;
    }

    @Override // l0.f
    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.f2564g;
        this.f2564g = f.f2535a;
        return byteBuffer;
    }

    @Override // l0.f
    public final void b() {
        this.f2565h = true;
        h();
    }

    @Override // l0.f
    public final d c(d dVar) {
        this.d = dVar;
        this.f2562e = f(dVar);
        if (isActive()) {
            return this.f2562e;
        }
        return d.f2533e;
    }

    @Override // l0.f
    public boolean d() {
        if (this.f2565h && this.f2564g == f.f2535a) {
            return true;
        }
        return false;
    }

    public abstract d f(d dVar);

    @Override // l0.f
    public final void flush() {
        this.f2564g = f.f2535a;
        this.f2565h = false;
        this.b = this.d;
        this.c = this.f2562e;
        g();
    }

    @Override // l0.f
    public boolean isActive() {
        if (this.f2562e != d.f2533e) {
            return true;
        }
        return false;
    }

    public final ByteBuffer j(int i3) {
        if (this.f2563f.capacity() < i3) {
            this.f2563f = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
        } else {
            this.f2563f.clear();
        }
        ByteBuffer byteBuffer = this.f2563f;
        this.f2564g = byteBuffer;
        return byteBuffer;
    }

    @Override // l0.f
    public final void reset() {
        flush();
        this.f2563f = f.f2535a;
        d dVar = d.f2533e;
        this.d = dVar;
        this.f2562e = dVar;
        this.b = dVar;
        this.c = dVar;
        i();
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }
}

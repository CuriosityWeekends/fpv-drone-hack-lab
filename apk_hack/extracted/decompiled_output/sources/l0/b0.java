package l0;

import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b0 extends q {

    /* renamed from: i  reason: collision with root package name */
    public int f2525i;

    /* renamed from: j  reason: collision with root package name */
    public int f2526j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2527k;

    /* renamed from: l  reason: collision with root package name */
    public int f2528l;

    /* renamed from: m  reason: collision with root package name */
    public byte[] f2529m;

    /* renamed from: n  reason: collision with root package name */
    public int f2530n;

    /* renamed from: o  reason: collision with root package name */
    public long f2531o;

    @Override // l0.q, l0.f
    public final ByteBuffer a() {
        int i3;
        if (super.d() && (i3 = this.f2530n) > 0) {
            j(i3).put(this.f2529m, 0, this.f2530n).flip();
            this.f2530n = 0;
        }
        return super.a();
    }

    @Override // l0.q, l0.f
    public final boolean d() {
        if (super.d() && this.f2530n == 0) {
            return true;
        }
        return false;
    }

    @Override // l0.f
    public final void e(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - position;
        if (i3 == 0) {
            return;
        }
        int min = Math.min(i3, this.f2528l);
        this.f2531o += min / this.b.d;
        this.f2528l -= min;
        byteBuffer.position(position + min);
        if (this.f2528l > 0) {
            return;
        }
        int i5 = i3 - min;
        int length = (this.f2530n + i5) - this.f2529m.length;
        ByteBuffer j2 = j(length);
        int h5 = g2.w.h(length, 0, this.f2530n);
        j2.put(this.f2529m, 0, h5);
        int h6 = g2.w.h(length - h5, 0, i5);
        byteBuffer.limit(byteBuffer.position() + h6);
        j2.put(byteBuffer);
        byteBuffer.limit(limit);
        int i6 = i5 - h6;
        int i7 = this.f2530n - h5;
        this.f2530n = i7;
        byte[] bArr = this.f2529m;
        System.arraycopy(bArr, h5, bArr, 0, i7);
        byteBuffer.get(this.f2529m, this.f2530n, i6);
        this.f2530n += i6;
        j2.flip();
    }

    @Override // l0.q
    public final d f(d dVar) {
        if (dVar.c == 2) {
            this.f2527k = true;
            if (this.f2525i == 0 && this.f2526j == 0) {
                return d.f2533e;
            }
            return dVar;
        }
        throw new e(dVar);
    }

    @Override // l0.q
    public final void g() {
        if (this.f2527k) {
            this.f2527k = false;
            int i3 = this.f2526j;
            int i5 = this.b.d;
            this.f2529m = new byte[i3 * i5];
            this.f2528l = this.f2525i * i5;
        } else {
            this.f2528l = 0;
        }
        this.f2530n = 0;
    }

    @Override // l0.q
    public final void h() {
        int i3;
        if (this.f2527k) {
            if (this.f2530n > 0) {
                this.f2531o += i3 / this.b.d;
            }
            this.f2530n = 0;
        }
    }

    @Override // l0.q
    public final void i() {
        this.f2529m = g2.w.f1962f;
    }
}

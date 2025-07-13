package l0;

import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class y extends q {

    /* renamed from: i  reason: collision with root package name */
    public int f2608i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2609j;

    /* renamed from: k  reason: collision with root package name */
    public byte[] f2610k;

    /* renamed from: l  reason: collision with root package name */
    public byte[] f2611l;

    /* renamed from: m  reason: collision with root package name */
    public int f2612m;

    /* renamed from: n  reason: collision with root package name */
    public int f2613n;

    /* renamed from: o  reason: collision with root package name */
    public int f2614o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2615p;
    public long q;

    @Override // l0.f
    public final void e(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !this.f2564g.hasRemaining()) {
            int i3 = this.f2612m;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int limit = byteBuffer.limit();
                        int k5 = k(byteBuffer);
                        byteBuffer.limit(k5);
                        this.q += byteBuffer.remaining() / this.f2608i;
                        m(byteBuffer, this.f2611l, this.f2614o);
                        if (k5 < limit) {
                            l(this.f2611l, this.f2614o);
                            this.f2612m = 0;
                            byteBuffer.limit(limit);
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    int limit2 = byteBuffer.limit();
                    int k6 = k(byteBuffer);
                    int position2 = k6 - byteBuffer.position();
                    byte[] bArr = this.f2610k;
                    int length = bArr.length;
                    int i5 = this.f2613n;
                    int i6 = length - i5;
                    if (k6 < limit2 && position2 < i6) {
                        l(bArr, i5);
                        this.f2613n = 0;
                        this.f2612m = 0;
                    } else {
                        int min = Math.min(position2, i6);
                        byteBuffer.limit(byteBuffer.position() + min);
                        byteBuffer.get(this.f2610k, this.f2613n, min);
                        int i7 = this.f2613n + min;
                        this.f2613n = i7;
                        byte[] bArr2 = this.f2610k;
                        if (i7 == bArr2.length) {
                            if (this.f2615p) {
                                l(bArr2, this.f2614o);
                                this.q += (this.f2613n - (this.f2614o * 2)) / this.f2608i;
                            } else {
                                this.q += (i7 - this.f2614o) / this.f2608i;
                            }
                            m(byteBuffer, this.f2610k, this.f2613n);
                            this.f2613n = 0;
                            this.f2612m = 2;
                        }
                        byteBuffer.limit(limit2);
                    }
                }
            } else {
                int limit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit3, byteBuffer.position() + this.f2610k.length));
                int limit4 = byteBuffer.limit() - 1;
                while (true) {
                    if (limit4 >= byteBuffer.position()) {
                        if (Math.abs((int) byteBuffer.get(limit4)) > 4) {
                            int i8 = this.f2608i;
                            position = ((limit4 / i8) * i8) + i8;
                            break;
                        }
                        limit4 -= 2;
                    } else {
                        position = byteBuffer.position();
                        break;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.f2612m = 1;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    j(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.f2615p = true;
                    }
                }
                byteBuffer.limit(limit3);
            }
        }
    }

    @Override // l0.q
    public final d f(d dVar) {
        if (dVar.c == 2) {
            if (!this.f2609j) {
                return d.f2533e;
            }
            return dVar;
        }
        throw new e(dVar);
    }

    @Override // l0.q
    public final void g() {
        if (this.f2609j) {
            d dVar = this.b;
            int i3 = dVar.d;
            this.f2608i = i3;
            int i5 = dVar.f2534a;
            int i6 = ((int) ((150000 * i5) / 1000000)) * i3;
            if (this.f2610k.length != i6) {
                this.f2610k = new byte[i6];
            }
            int i7 = ((int) ((20000 * i5) / 1000000)) * i3;
            this.f2614o = i7;
            if (this.f2611l.length != i7) {
                this.f2611l = new byte[i7];
            }
        }
        this.f2612m = 0;
        this.q = 0L;
        this.f2613n = 0;
        this.f2615p = false;
    }

    @Override // l0.q
    public final void h() {
        int i3 = this.f2613n;
        if (i3 > 0) {
            l(this.f2610k, i3);
        }
        if (!this.f2615p) {
            this.q += this.f2614o / this.f2608i;
        }
    }

    @Override // l0.q
    public final void i() {
        this.f2609j = false;
        this.f2614o = 0;
        byte[] bArr = g2.w.f1962f;
        this.f2610k = bArr;
        this.f2611l = bArr;
    }

    @Override // l0.q, l0.f
    public final boolean isActive() {
        return this.f2609j;
    }

    public final int k(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.get(position)) > 4) {
                int i3 = this.f2608i;
                return (position / i3) * i3;
            }
        }
        return byteBuffer.limit();
    }

    public final void l(byte[] bArr, int i3) {
        j(i3).put(bArr, 0, i3).flip();
        if (i3 > 0) {
            this.f2615p = true;
        }
    }

    public final void m(ByteBuffer byteBuffer, byte[] bArr, int i3) {
        int min = Math.min(byteBuffer.remaining(), this.f2614o);
        int i5 = this.f2614o - min;
        System.arraycopy(bArr, i3 - i5, this.f2611l, 0, i5);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f2611l, i5, min);
    }
}

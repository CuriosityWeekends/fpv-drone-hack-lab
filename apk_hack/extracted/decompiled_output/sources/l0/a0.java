package l0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a0 implements f {
    public int b;
    public float c;
    public float d;

    /* renamed from: e  reason: collision with root package name */
    public d f2512e;

    /* renamed from: f  reason: collision with root package name */
    public d f2513f;

    /* renamed from: g  reason: collision with root package name */
    public d f2514g;

    /* renamed from: h  reason: collision with root package name */
    public d f2515h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2516i;

    /* renamed from: j  reason: collision with root package name */
    public z f2517j;

    /* renamed from: k  reason: collision with root package name */
    public ByteBuffer f2518k;

    /* renamed from: l  reason: collision with root package name */
    public ShortBuffer f2519l;

    /* renamed from: m  reason: collision with root package name */
    public ByteBuffer f2520m;

    /* renamed from: n  reason: collision with root package name */
    public long f2521n;

    /* renamed from: o  reason: collision with root package name */
    public long f2522o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2523p;

    @Override // l0.f
    public final ByteBuffer a() {
        ByteBuffer byteBuffer = this.f2520m;
        this.f2520m = f.f2535a;
        return byteBuffer;
    }

    @Override // l0.f
    public final void b() {
        z zVar = this.f2517j;
        if (zVar != null) {
            int i3 = zVar.f2623k;
            float f4 = zVar.c;
            float f5 = zVar.d;
            float f6 = zVar.f2617e * f5;
            int i5 = zVar.f2625m + ((int) ((((i3 / (f4 / f5)) + zVar.f2627o) / f6) + 0.5f));
            short[] sArr = zVar.f2622j;
            int i6 = zVar.f2620h * 2;
            zVar.f2622j = zVar.c(sArr, i3, i6 + i3);
            int i7 = 0;
            while (true) {
                int i8 = zVar.b;
                if (i7 >= i6 * i8) {
                    break;
                }
                zVar.f2622j[(i8 * i3) + i7] = 0;
                i7++;
            }
            zVar.f2623k = i6 + zVar.f2623k;
            zVar.f();
            if (zVar.f2625m > i5) {
                zVar.f2625m = i5;
            }
            zVar.f2623k = 0;
            zVar.f2629r = 0;
            zVar.f2627o = 0;
        }
        this.f2523p = true;
    }

    @Override // l0.f
    public final d c(d dVar) {
        if (dVar.c == 2) {
            int i3 = this.b;
            if (i3 == -1) {
                i3 = dVar.f2534a;
            }
            this.f2512e = dVar;
            d dVar2 = new d(i3, dVar.b, 2);
            this.f2513f = dVar2;
            this.f2516i = true;
            return dVar2;
        }
        throw new e(dVar);
    }

    @Override // l0.f
    public final boolean d() {
        z zVar;
        if (this.f2523p && ((zVar = this.f2517j) == null || zVar.f2625m * zVar.b * 2 == 0)) {
            return true;
        }
        return false;
    }

    @Override // l0.f
    public final void e(ByteBuffer byteBuffer) {
        z zVar = this.f2517j;
        zVar.getClass();
        boolean hasRemaining = byteBuffer.hasRemaining();
        int i3 = zVar.b;
        if (hasRemaining) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f2521n += remaining;
            int remaining2 = asShortBuffer.remaining() / i3;
            short[] c = zVar.c(zVar.f2622j, zVar.f2623k, remaining2);
            zVar.f2622j = c;
            asShortBuffer.get(c, zVar.f2623k * i3, ((remaining2 * i3) * 2) / 2);
            zVar.f2623k += remaining2;
            zVar.f();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int i5 = zVar.f2625m * i3 * 2;
        if (i5 > 0) {
            if (this.f2518k.capacity() < i5) {
                ByteBuffer order = ByteBuffer.allocateDirect(i5).order(ByteOrder.nativeOrder());
                this.f2518k = order;
                this.f2519l = order.asShortBuffer();
            } else {
                this.f2518k.clear();
                this.f2519l.clear();
            }
            ShortBuffer shortBuffer = this.f2519l;
            int min = Math.min(shortBuffer.remaining() / i3, zVar.f2625m);
            int i6 = min * i3;
            shortBuffer.put(zVar.f2624l, 0, i6);
            int i7 = zVar.f2625m - min;
            zVar.f2625m = i7;
            short[] sArr = zVar.f2624l;
            System.arraycopy(sArr, i6, sArr, 0, i7 * i3);
            this.f2522o += i5;
            this.f2518k.limit(i5);
            this.f2520m = this.f2518k;
        }
    }

    @Override // l0.f
    public final void flush() {
        if (isActive()) {
            d dVar = this.f2512e;
            this.f2514g = dVar;
            d dVar2 = this.f2513f;
            this.f2515h = dVar2;
            if (this.f2516i) {
                this.f2517j = new z(dVar.f2534a, dVar.b, this.c, this.d, dVar2.f2534a);
            } else {
                z zVar = this.f2517j;
                if (zVar != null) {
                    zVar.f2623k = 0;
                    zVar.f2625m = 0;
                    zVar.f2627o = 0;
                    zVar.f2628p = 0;
                    zVar.q = 0;
                    zVar.f2629r = 0;
                    zVar.s = 0;
                    zVar.f2630t = 0;
                    zVar.f2631u = 0;
                    zVar.f2632v = 0;
                }
            }
        }
        this.f2520m = f.f2535a;
        this.f2521n = 0L;
        this.f2522o = 0L;
        this.f2523p = false;
    }

    @Override // l0.f
    public final boolean isActive() {
        if (this.f2513f.f2534a != -1 && (Math.abs(this.c - 1.0f) >= 0.01f || Math.abs(this.d - 1.0f) >= 0.01f || this.f2513f.f2534a != this.f2512e.f2534a)) {
            return true;
        }
        return false;
    }

    @Override // l0.f
    public final void reset() {
        this.c = 1.0f;
        this.d = 1.0f;
        d dVar = d.f2533e;
        this.f2512e = dVar;
        this.f2513f = dVar;
        this.f2514g = dVar;
        this.f2515h = dVar;
        ByteBuffer byteBuffer = f.f2535a;
        this.f2518k = byteBuffer;
        this.f2519l = byteBuffer.asShortBuffer();
        this.f2520m = byteBuffer;
        this.b = -1;
        this.f2516i = false;
        this.f2517j = null;
        this.f2521n = 0L;
        this.f2522o = 0L;
        this.f2523p = false;
    }
}

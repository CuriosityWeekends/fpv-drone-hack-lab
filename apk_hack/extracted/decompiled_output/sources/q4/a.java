package q4;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import n4.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends AtomicReferenceArray implements c {

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f3357f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;

    /* renamed from: a  reason: collision with root package name */
    public final int f3358a;
    public final AtomicLong b;
    public long c;
    public final AtomicLong d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3359e;

    public a(int i3) {
        super(1 << (32 - Integer.numberOfLeadingZeros(i3 - 1)));
        this.f3358a = length() - 1;
        this.b = new AtomicLong();
        this.d = new AtomicLong();
        this.f3359e = Math.min(i3 / 4, f3357f.intValue());
    }

    @Override // n4.d
    public final boolean a(Object obj) {
        if (obj != null) {
            AtomicLong atomicLong = this.b;
            long j2 = atomicLong.get();
            int i3 = this.f3358a;
            int i5 = ((int) j2) & i3;
            if (j2 >= this.c) {
                long j5 = this.f3359e + j2;
                if (get(i3 & ((int) j5)) == null) {
                    this.c = j5;
                } else if (get(i5) != null) {
                    return false;
                }
            }
            lazySet(i5, obj);
            atomicLong.lazySet(j2 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // n4.d
    public final Object b() {
        AtomicLong atomicLong = this.d;
        long j2 = atomicLong.get();
        int i3 = ((int) j2) & this.f3358a;
        Object obj = get(i3);
        if (obj == null) {
            return null;
        }
        atomicLong.lazySet(j2 + 1);
        lazySet(i3, null);
        return obj;
    }

    @Override // n4.d
    public final void clear() {
        while (true) {
            if (b() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // n4.d
    public final boolean isEmpty() {
        if (this.b.get() == this.d.get()) {
            return true;
        }
        return false;
    }
}

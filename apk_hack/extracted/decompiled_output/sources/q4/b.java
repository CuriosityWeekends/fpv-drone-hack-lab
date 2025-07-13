package q4;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import n4.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements c {

    /* renamed from: i  reason: collision with root package name */
    public static final int f3360i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j  reason: collision with root package name */
    public static final Object f3361j = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicLong f3362a;
    public final int b;
    public long c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicReferenceArray f3363e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3364f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicReferenceArray f3365g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicLong f3366h;

    public b(int i3) {
        AtomicLong atomicLong = new AtomicLong();
        this.f3362a = atomicLong;
        this.f3366h = new AtomicLong();
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, i3) - 1));
        int i5 = numberOfLeadingZeros - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(numberOfLeadingZeros + 1);
        this.f3363e = atomicReferenceArray;
        this.d = i5;
        this.b = Math.min(numberOfLeadingZeros / 4, f3360i);
        this.f3365g = atomicReferenceArray;
        this.f3364f = i5;
        this.c = numberOfLeadingZeros - 2;
        atomicLong.lazySet(0L);
    }

    @Override // n4.d
    public final boolean a(Object obj) {
        if (obj != null) {
            AtomicReferenceArray atomicReferenceArray = this.f3363e;
            AtomicLong atomicLong = this.f3362a;
            long j2 = atomicLong.get();
            int i3 = this.d;
            int i5 = ((int) j2) & i3;
            if (j2 < this.c) {
                atomicReferenceArray.lazySet(i5, obj);
                atomicLong.lazySet(j2 + 1);
                return true;
            }
            long j5 = this.b + j2;
            if (atomicReferenceArray.get(((int) j5) & i3) == null) {
                this.c = j5 - 1;
                atomicReferenceArray.lazySet(i5, obj);
                atomicLong.lazySet(j2 + 1);
                return true;
            }
            long j6 = j2 + 1;
            if (atomicReferenceArray.get(((int) j6) & i3) == null) {
                atomicReferenceArray.lazySet(i5, obj);
                atomicLong.lazySet(j6);
                return true;
            }
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.f3363e = atomicReferenceArray2;
            this.c = (j2 + i3) - 1;
            atomicReferenceArray2.lazySet(i5, obj);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i5, f3361j);
            atomicLong.lazySet(j6);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // n4.d
    public final Object b() {
        boolean z3;
        AtomicReferenceArray atomicReferenceArray = this.f3365g;
        AtomicLong atomicLong = this.f3366h;
        long j2 = atomicLong.get();
        int i3 = this.f3364f;
        int i5 = ((int) j2) & i3;
        Object obj = atomicReferenceArray.get(i5);
        if (obj == f3361j) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (obj != null && !z3) {
            atomicReferenceArray.lazySet(i5, null);
            atomicLong.lazySet(j2 + 1);
            return obj;
        } else if (!z3) {
            return null;
        } else {
            int i6 = i3 + 1;
            AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i6);
            atomicReferenceArray.lazySet(i6, null);
            this.f3365g = atomicReferenceArray2;
            Object obj2 = atomicReferenceArray2.get(i5);
            if (obj2 != null) {
                atomicReferenceArray2.lazySet(i5, null);
                atomicLong.lazySet(j2 + 1);
            }
            return obj2;
        }
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
        if (this.f3362a.get() == this.f3366h.get()) {
            return true;
        }
        return false;
    }
}

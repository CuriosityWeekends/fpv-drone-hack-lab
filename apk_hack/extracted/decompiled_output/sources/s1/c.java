package s1;

import com.tencent.bugly.proguard.l0;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class c implements f, m0.b {

    /* renamed from: a  reason: collision with root package name */
    public final l0 f3492a;

    /* renamed from: f  reason: collision with root package name */
    public final m0.e[] f3494f;

    /* renamed from: h  reason: collision with root package name */
    public int f3496h;

    /* renamed from: i  reason: collision with root package name */
    public m0.d f3497i;

    /* renamed from: j  reason: collision with root package name */
    public g f3498j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3499k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3500l;

    /* renamed from: m  reason: collision with root package name */
    public int f3501m;
    public final Object b = new Object();
    public final ArrayDeque c = new ArrayDeque();
    public final ArrayDeque d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    public final m0.d[] f3493e = new i[2];

    /* renamed from: g  reason: collision with root package name */
    public int f3495g = 2;

    public c() {
        d[] dVarArr = new d[2];
        int i3 = 0;
        while (true) {
            if (i3 >= this.f3495g) {
                break;
            }
            this.f3493e[i3] = new m0.d(1);
            i3++;
        }
        this.f3494f = dVarArr;
        this.f3496h = 2;
        for (int i5 = 0; i5 < this.f3496h; i5++) {
            this.f3494f[i5] = new d(this, 0);
        }
        l0 l0Var = new l0(2, this);
        this.f3492a = l0Var;
        l0Var.start();
        int i6 = this.f3495g;
        m0.d[] dVarArr2 = this.f3493e;
        g2.b.h(i6 == dVarArr2.length);
        for (m0.d dVar : dVarArr2) {
            dVar.c(1024);
        }
    }

    @Override // m0.b
    public final void b(Object obj) {
        boolean z3;
        m0.d dVar = (m0.d) obj;
        synchronized (this.b) {
            try {
                g gVar = this.f3498j;
                if (gVar == null) {
                    if (dVar == this.f3497i) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    g2.b.e(z3);
                    this.c.addLast(dVar);
                    if (!this.c.isEmpty() && this.f3496h > 0) {
                        this.b.notify();
                    }
                    this.f3497i = null;
                } else {
                    throw gVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // m0.b
    public final Object c() {
        synchronized (this.b) {
            try {
                g gVar = this.f3498j;
                if (gVar == null) {
                    if (this.d.isEmpty()) {
                        return null;
                    }
                    return (m0.e) this.d.removeFirst();
                }
                throw gVar;
            } finally {
            }
        }
    }

    @Override // m0.b
    public final Object d() {
        boolean z3;
        m0.d dVar;
        synchronized (this.b) {
            try {
                g gVar = this.f3498j;
                if (gVar == null) {
                    if (this.f3497i == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    g2.b.h(z3);
                    int i3 = this.f3495g;
                    if (i3 == 0) {
                        dVar = null;
                    } else {
                        m0.d[] dVarArr = this.f3493e;
                        int i5 = i3 - 1;
                        this.f3495g = i5;
                        dVar = dVarArr[i5];
                    }
                    this.f3497i = dVar;
                } else {
                    throw gVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public abstract e e(byte[] bArr, int i3, boolean z3);

    public final g f(m0.d dVar, m0.e eVar, boolean z3) {
        i iVar = (i) dVar;
        d dVar2 = (d) eVar;
        try {
            ByteBuffer byteBuffer = iVar.b;
            byteBuffer.getClass();
            e e5 = e(byteBuffer.array(), byteBuffer.limit(), z3);
            long j2 = iVar.c;
            long j5 = iVar.f3504f;
            dVar2.timeUs = j2;
            dVar2.f3502a = e5;
            if (j5 != Long.MAX_VALUE) {
                j2 = j5;
            }
            dVar2.b = j2;
            dVar2.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (g e6) {
            return e6;
        }
    }

    @Override // m0.b
    public final void flush() {
        synchronized (this.b) {
            try {
                this.f3499k = true;
                this.f3501m = 0;
                m0.d dVar = this.f3497i;
                if (dVar != null) {
                    dVar.clear();
                    int i3 = this.f3495g;
                    this.f3495g = i3 + 1;
                    this.f3493e[i3] = dVar;
                    this.f3497i = null;
                }
                while (!this.c.isEmpty()) {
                    m0.d dVar2 = (m0.d) this.c.removeFirst();
                    dVar2.clear();
                    int i5 = this.f3495g;
                    this.f3495g = i5 + 1;
                    this.f3493e[i5] = dVar2;
                }
                while (!this.d.isEmpty()) {
                    ((m0.e) this.d.removeFirst()).release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [s1.g, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r4v4, types: [s1.g, java.lang.Exception] */
    public final boolean g() {
        synchronized (this.b) {
            while (!this.f3500l && (this.c.isEmpty() || this.f3496h <= 0)) {
                try {
                    this.b.wait();
                } finally {
                }
            }
            if (this.f3500l) {
                return false;
            }
            m0.d dVar = (m0.d) this.c.removeFirst();
            m0.e[] eVarArr = this.f3494f;
            int i3 = this.f3496h - 1;
            this.f3496h = i3;
            m0.e eVar = eVarArr[i3];
            boolean z3 = this.f3499k;
            this.f3499k = false;
            if (dVar.isEndOfStream()) {
                eVar.addFlag(4);
            } else {
                if (dVar.isDecodeOnly()) {
                    eVar.addFlag(Integer.MIN_VALUE);
                }
                try {
                    this.f3498j = f(dVar, eVar, z3);
                } catch (OutOfMemoryError e5) {
                    this.f3498j = new Exception("Unexpected decode error", e5);
                } catch (RuntimeException e6) {
                    this.f3498j = new Exception("Unexpected decode error", e6);
                }
                if (this.f3498j != null) {
                    synchronized (this.b) {
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                try {
                    if (this.f3499k) {
                        eVar.release();
                    } else if (eVar.isDecodeOnly()) {
                        this.f3501m++;
                        eVar.release();
                    } else {
                        eVar.skippedOutputBufferCount = this.f3501m;
                        this.f3501m = 0;
                        this.d.addLast(eVar);
                    }
                    dVar.clear();
                    int i5 = this.f3495g;
                    this.f3495g = i5 + 1;
                    this.f3493e[i5] = dVar;
                } finally {
                }
            }
            return true;
        }
    }

    public final void h(m0.e eVar) {
        synchronized (this.b) {
            eVar.clear();
            int i3 = this.f3496h;
            this.f3496h = i3 + 1;
            this.f3494f[i3] = eVar;
            if (!this.c.isEmpty() && this.f3496h > 0) {
                this.b.notify();
            }
        }
    }

    @Override // m0.b
    public final void release() {
        synchronized (this.b) {
            this.f3500l = true;
            this.b.notify();
        }
        try {
            this.f3492a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // s1.f
    public final void a(long j2) {
    }
}

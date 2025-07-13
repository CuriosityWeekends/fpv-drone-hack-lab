package y0;

import android.util.Log;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4086a;
    public boolean b;
    public long c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f4087e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f4088f;

    /* renamed from: g  reason: collision with root package name */
    public Object f4089g;

    public g(List list) {
        this.f4086a = 0;
        this.f4088f = list;
        this.f4089g = new p0.u[list.size()];
    }

    @Override // y0.h
    public final void a(c0.b bVar) {
        p0.u[] uVarArr;
        boolean z3;
        boolean z5;
        switch (this.f4086a) {
            case 0:
                if (this.b) {
                    if (this.d == 2) {
                        if (bVar.a() == 0) {
                            z5 = false;
                        } else {
                            if (bVar.n() != 32) {
                                this.b = false;
                            }
                            this.d--;
                            z5 = this.b;
                        }
                        if (!z5) {
                            return;
                        }
                    }
                    if (this.d == 1) {
                        if (bVar.a() == 0) {
                            z3 = false;
                        } else {
                            if (bVar.n() != 0) {
                                this.b = false;
                            }
                            this.d--;
                            z3 = this.b;
                        }
                        if (!z3) {
                            return;
                        }
                    }
                    int i3 = bVar.b;
                    int a5 = bVar.a();
                    for (p0.u uVar : (p0.u[]) this.f4089g) {
                        bVar.y(i3);
                        uVar.b(a5, bVar);
                    }
                    this.f4087e += a5;
                    return;
                }
                return;
            default:
                if (this.b) {
                    int a6 = bVar.a();
                    int i5 = this.f4087e;
                    if (i5 < 10) {
                        int min = Math.min(a6, 10 - i5);
                        byte[] bArr = bVar.f187a;
                        int i6 = bVar.b;
                        c0.b bVar2 = (c0.b) this.f4088f;
                        System.arraycopy(bArr, i6, bVar2.f187a, this.f4087e, min);
                        if (this.f4087e + min == 10) {
                            bVar2.y(0);
                            if (73 == bVar2.n() && 68 == bVar2.n() && 51 == bVar2.n()) {
                                bVar2.z(3);
                                this.d = bVar2.m() + 10;
                            } else {
                                Log.w("Id3Reader", "Discarding invalid ID3 tag");
                                this.b = false;
                                return;
                            }
                        }
                    }
                    int min2 = Math.min(a6, this.d - this.f4087e);
                    ((p0.u) this.f4089g).b(min2, bVar);
                    this.f4087e += min2;
                    return;
                }
                return;
        }
    }

    @Override // y0.h
    public final void b() {
        switch (this.f4086a) {
            case 0:
                this.b = false;
                return;
            default:
                this.b = false;
                return;
        }
    }

    @Override // y0.h
    public final void c(int i3, long j2) {
        switch (this.f4086a) {
            case 0:
                if ((i3 & 4) != 0) {
                    this.b = true;
                    this.c = j2;
                    this.f4087e = 0;
                    this.d = 2;
                    return;
                }
                return;
            default:
                if ((i3 & 4) != 0) {
                    this.b = true;
                    this.c = j2;
                    this.d = 0;
                    this.f4087e = 0;
                    return;
                }
                return;
        }
    }

    @Override // y0.h
    public final void d(p0.k kVar, c0 c0Var) {
        switch (this.f4086a) {
            case 0:
                int i3 = 0;
                while (true) {
                    p0.u[] uVarArr = (p0.u[]) this.f4089g;
                    if (i3 < uVarArr.length) {
                        b0 b0Var = (b0) ((List) this.f4088f).get(i3);
                        c0Var.a();
                        c0Var.b();
                        p0.u g5 = kVar.g(c0Var.d, 3);
                        c0Var.b();
                        g5.d(Format.m(c0Var.f4054e, "application/dvbsubs", 0, Collections.singletonList(b0Var.b), b0Var.f4051a, null));
                        uVarArr[i3] = g5;
                        i3++;
                    } else {
                        return;
                    }
                }
            default:
                c0Var.a();
                c0Var.b();
                p0.u g6 = kVar.g(c0Var.d, 4);
                this.f4089g = g6;
                c0Var.b();
                g6.d(Format.o(c0Var.f4054e, "application/id3"));
                return;
        }
    }

    @Override // y0.h
    public final void e() {
        int i3;
        switch (this.f4086a) {
            case 0:
                if (this.b) {
                    for (p0.u uVar : (p0.u[]) this.f4089g) {
                        uVar.c(this.c, 1, this.f4087e, 0, null);
                    }
                    this.b = false;
                    return;
                }
                return;
            default:
                if (this.b && (i3 = this.d) != 0 && this.f4087e == i3) {
                    ((p0.u) this.f4089g).c(this.c, 1, i3, 0, null);
                    this.b = false;
                    return;
                }
                return;
        }
    }

    public g() {
        this.f4086a = 1;
        this.f4088f = new c0.b(10);
    }
}

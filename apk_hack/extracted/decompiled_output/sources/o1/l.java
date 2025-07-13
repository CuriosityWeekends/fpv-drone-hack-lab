package o1;

import com.google.android.exoplayer2.Format;
import g2.w;
import j1.j0;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3017a;
    public final p b;
    public int c = -1;

    public l(p pVar, int i3) {
        this.b = pVar;
        this.f3017a = i3;
    }

    @Override // j1.j0
    public final void a() {
        int i3 = this.c;
        p pVar = this.b;
        if (i3 != -2) {
            if (i3 == -1) {
                pVar.D();
                return;
            } else if (i3 != -3) {
                pVar.D();
                b3.e eVar = pVar.s[i3].f2420f;
                if (eVar != null) {
                    e2.b bVar = (e2.b) eVar.b;
                    bVar.getClass();
                    throw bVar;
                }
                return;
            } else {
                return;
            }
        }
        pVar.m();
        throw new IOException(a1.i.i("Unable to bind a sample queue to TrackGroup with mime type ", pVar.F.b[this.f3017a].b[0].f311i, "."));
    }

    public final void b() {
        boolean z3;
        if (this.c == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        p pVar = this.b;
        pVar.m();
        pVar.H.getClass();
        int[] iArr = pVar.H;
        int i3 = this.f3017a;
        int i5 = iArr[i3];
        if (i5 == -1) {
            if (pVar.G.contains(pVar.F.b[i3])) {
                i5 = -3;
            }
            i5 = -2;
        } else {
            boolean[] zArr = pVar.K;
            if (!zArr[i5]) {
                zArr[i5] = true;
            }
            i5 = -2;
        }
        this.c = i5;
    }

    @Override // j1.j0
    public final int c(j0.b bVar, m0.d dVar, boolean z3) {
        Format format;
        int i3 = -3;
        if (this.c == -3) {
            dVar.addFlag(4);
            return -4;
        }
        if (d()) {
            int i5 = this.c;
            p pVar = this.b;
            if (!pVar.B()) {
                ArrayList arrayList = pVar.f3032l;
                int i6 = 0;
                if (!arrayList.isEmpty()) {
                    int i7 = 0;
                    loop0: while (i7 < arrayList.size() - 1) {
                        int i8 = ((i) arrayList.get(i7)).f2977j;
                        int length = pVar.s.length;
                        for (int i9 = 0; i9 < length; i9++) {
                            if (pVar.K[i9] && pVar.s[i9].x() == i8) {
                                break loop0;
                            }
                        }
                        i7++;
                    }
                    w.z(arrayList, 0, i7);
                    i iVar = (i) arrayList.get(0);
                    Format format2 = iVar.c;
                    if (!format2.equals(pVar.D)) {
                        pVar.f3029i.b(pVar.f3024a, format2, iVar.d, iVar.f2638e, iVar.f2639f);
                    }
                    pVar.D = format2;
                }
                i3 = pVar.s[i5].y(bVar, dVar, z3, pVar.Q, pVar.M);
                if (i3 == -5) {
                    Format format3 = (Format) bVar.d;
                    format3.getClass();
                    if (i5 == pVar.f3042y) {
                        int x3 = pVar.s[i5].x();
                        while (i6 < arrayList.size() && ((i) arrayList.get(i6)).f2977j != x3) {
                            i6++;
                        }
                        if (i6 < arrayList.size()) {
                            format = ((i) arrayList.get(i6)).c;
                        } else {
                            format = pVar.C;
                            format.getClass();
                        }
                        format3 = format3.g(format);
                    }
                    bVar.d = format3;
                }
            }
        }
        return i3;
    }

    public final boolean d() {
        int i3 = this.c;
        if (i3 != -1 && i3 != -3 && i3 != -2) {
            return true;
        }
        return false;
    }

    @Override // j1.j0
    public final int g(long j2) {
        if (!d()) {
            return 0;
        }
        int i3 = this.c;
        p pVar = this.b;
        if (pVar.B()) {
            return 0;
        }
        o oVar = pVar.s[i3];
        if (pVar.Q && j2 > oVar.o()) {
            return oVar.f();
        }
        return oVar.e(j2);
    }

    @Override // j1.j0
    public final boolean isReady() {
        if (this.c != -3) {
            if (d()) {
                int i3 = this.c;
                p pVar = this.b;
                if (pVar.B() || !pVar.s[i3].u(pVar.Q)) {
                }
            }
            return false;
        }
        return true;
    }
}

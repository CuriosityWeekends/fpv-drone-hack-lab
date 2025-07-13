package a2;

import g2.w;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends s1.c {

    /* renamed from: n  reason: collision with root package name */
    public final c0.b f50n = new c0.b();

    /* renamed from: o  reason: collision with root package name */
    public final e f51o = new e();

    @Override // s1.c
    public final s1.e e(byte[] bArr, int i3, boolean z3) {
        c0.b bVar = this.f50n;
        bVar.w(bArr, i3);
        ArrayList arrayList = new ArrayList();
        while (bVar.a() > 0) {
            if (bVar.a() >= 8) {
                int c = bVar.c();
                if (bVar.c() == 1987343459) {
                    int i5 = c - 8;
                    e eVar = this.f51o;
                    eVar.b();
                    while (i5 > 0) {
                        if (i5 >= 8) {
                            int c5 = bVar.c();
                            int c6 = bVar.c();
                            int i6 = c5 - 8;
                            String k5 = w.k(bVar.f187a, bVar.b, i6);
                            bVar.z(i6);
                            i5 = (i5 - 8) - i6;
                            if (c6 == 1937011815) {
                                i.c(k5, eVar);
                            } else if (c6 == 1885436268) {
                                i.d(null, k5.trim(), eVar, Collections.emptyList());
                            }
                        } else {
                            throw new Exception("Incomplete vtt cue box header found.");
                        }
                    }
                    arrayList.add(eVar.a());
                } else {
                    bVar.z(c - 8);
                }
            } else {
                throw new Exception("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new c(arrayList);
    }
}

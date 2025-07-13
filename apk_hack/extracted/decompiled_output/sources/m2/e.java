package m2;

import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.q;
import com.google.gson.s;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends s {
    public static final a b = new a(2);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2843a;

    public /* synthetic */ e(int i3) {
        this.f2843a = i3;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, com.google.gson.l, com.google.gson.q] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, com.google.gson.l, com.google.gson.q] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, com.google.gson.l, com.google.gson.q] */
    public static com.google.gson.l b(p2.a aVar) {
        int b5 = com.bumptech.glide.i.b(aVar.u());
        if (b5 != 0) {
            if (b5 != 2) {
                if (b5 != 5) {
                    if (b5 != 6) {
                        if (b5 != 7) {
                            if (b5 == 8) {
                                aVar.q();
                                return n.f510a;
                            }
                            throw new IllegalArgumentException();
                        }
                        Boolean valueOf = Boolean.valueOf(aVar.k());
                        ?? obj = new Object();
                        obj.d(valueOf);
                        return obj;
                    }
                    l2.g gVar = new l2.g(aVar.s());
                    ?? obj2 = new Object();
                    obj2.d(gVar);
                    return obj2;
                }
                String s = aVar.s();
                ?? obj3 = new Object();
                obj3.d(s);
                return obj3;
            }
            o oVar = new o();
            aVar.b();
            while (aVar.h()) {
                oVar.f511a.put(aVar.o(), b(aVar));
            }
            aVar.f();
            return oVar;
        }
        com.google.gson.k kVar = new com.google.gson.k();
        aVar.a();
        while (aVar.h()) {
            kVar.f509a.add(b(aVar));
        }
        aVar.e();
        return kVar;
    }

    public static void c(p2.b bVar, com.google.gson.l lVar) {
        boolean parseBoolean;
        if (lVar != null && !(lVar instanceof n)) {
            boolean z3 = lVar instanceof q;
            if (z3) {
                if (z3) {
                    q qVar = (q) lVar;
                    Object obj = qVar.f512a;
                    if (obj instanceof Number) {
                        bVar.l(qVar.a());
                        return;
                    } else if (obj instanceof Boolean) {
                        if (obj instanceof Boolean) {
                            parseBoolean = ((Boolean) obj).booleanValue();
                        } else {
                            parseBoolean = Boolean.parseBoolean(qVar.b());
                        }
                        bVar.n(parseBoolean);
                        return;
                    } else {
                        bVar.m(qVar.b());
                        return;
                    }
                }
                throw new IllegalStateException("Not a JSON Primitive: " + lVar);
            }
            boolean z5 = lVar instanceof com.google.gson.k;
            if (z5) {
                bVar.b();
                if (z5) {
                    Iterator it = ((com.google.gson.k) lVar).f509a.iterator();
                    while (it.hasNext()) {
                        c(bVar, (com.google.gson.l) it.next());
                    }
                    bVar.e();
                    return;
                }
                throw new IllegalStateException("Not a JSON Array: " + lVar);
            }
            boolean z6 = lVar instanceof o;
            if (z6) {
                bVar.c();
                if (z6) {
                    Iterator it2 = ((l2.i) ((o) lVar).f511a.entrySet()).iterator();
                    while (((l2.h) it2).hasNext()) {
                        l2.j b5 = ((l2.h) it2).b();
                        bVar.g((String) b5.getKey());
                        c(bVar, (com.google.gson.l) b5.getValue());
                    }
                    bVar.f();
                    return;
                }
                throw new IllegalStateException("Not a JSON Object: " + lVar);
            }
            throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
        }
        bVar.h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f1, code lost:
        if (r10.m() != 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f4, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f5, code lost:
        r1 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ff, code lost:
        if (java.lang.Integer.parseInt(r1) != 0) goto L76;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [l2.k] */
    @Override // com.google.gson.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(p2.a r10) {
        /*
            Method dump skipped, instructions count: 1170
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.e.a(p2.a):java.lang.Object");
    }

    public e(com.google.gson.j jVar) {
        this.f2843a = 0;
    }
}

package m2;

import com.google.gson.t;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements t {

    /* renamed from: a  reason: collision with root package name */
    public final com.bumptech.glide.h f2846a;
    public final com.google.gson.f b;
    public final l2.f c;
    public final c d;

    public g(com.bumptech.glide.h hVar, l2.f fVar, c cVar) {
        com.google.gson.a aVar = com.google.gson.f.f503a;
        this.f2846a = hVar;
        this.b = aVar;
        this.c = fVar;
        this.d = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x01a7, code lost:
        r27 = r7;
        r6 = new o2.a(l2.d.i(r1, r27, r27.getGenericSuperclass(), new java.util.HashSet()));
        r7 = r6.f3050a;
        r0 = r33;
        r11 = r34;
        r12 = r12;
        r8 = r8;
        r9 = r9;
        r10 = r10;
        r13 = r13;
        r15 = r15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016c A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v27, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List] */
    @Override // com.google.gson.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.s a(com.google.gson.j r34, o2.a r35) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.g.a(com.google.gson.j, o2.a):com.google.gson.s");
    }

    public final boolean b(Field field, boolean z3) {
        List list;
        Class<?> type = field.getType();
        l2.f fVar = this.c;
        if (!fVar.b(type, z3) && (field.getModifiers() & 136) == 0 && !field.isSynthetic()) {
            Class<?> type2 = field.getType();
            if (Enum.class.isAssignableFrom(type2) || (!type2.isAnonymousClass() && !type2.isLocalClass())) {
                if (z3) {
                    list = fVar.f2691a;
                } else {
                    list = fVar.b;
                }
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    if (it.hasNext()) {
                        com.bumptech.glide.i.a(it.next());
                        throw null;
                    }
                }
                return true;
            }
        }
        return false;
    }
}

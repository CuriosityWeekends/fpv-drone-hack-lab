package l2;

import com.google.gson.s;
import com.google.gson.t;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends s {

    /* renamed from: a  reason: collision with root package name */
    public s f2689a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ com.google.gson.j c;
    public final /* synthetic */ o2.a d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ f f2690e;

    public e(f fVar, boolean z3, boolean z5, com.google.gson.j jVar, o2.a aVar) {
        this.f2690e = fVar;
        this.b = z3;
        this.c = jVar;
        this.d = aVar;
    }

    @Override // com.google.gson.s
    public final Object a(p2.a aVar) {
        if (this.b) {
            aVar.z();
            return null;
        }
        s sVar = this.f2689a;
        if (sVar == null) {
            com.google.gson.j jVar = this.c;
            List list = jVar.c;
            t tVar = this.f2690e;
            if (!list.contains(tVar)) {
                tVar = jVar.f508e;
            }
            Iterator it = list.iterator();
            boolean z3 = false;
            while (true) {
                boolean hasNext = it.hasNext();
                o2.a aVar2 = this.d;
                if (hasNext) {
                    t tVar2 = (t) it.next();
                    if (!z3) {
                        if (tVar2 == tVar) {
                            z3 = true;
                        }
                    } else {
                        s a5 = tVar2.a(jVar, aVar2);
                        if (a5 != null) {
                            this.f2689a = a5;
                            sVar = a5;
                            break;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("GSON cannot serialize " + aVar2);
                }
            }
        }
        return sVar.a(aVar);
    }
}

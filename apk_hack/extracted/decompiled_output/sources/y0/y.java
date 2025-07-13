package y0;

import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final List f4221a;
    public final p0.u[] b;

    public y(List list, int i3) {
        switch (i3) {
            case 1:
                this.f4221a = list;
                this.b = new p0.u[list.size()];
                return;
            default:
                this.f4221a = list;
                this.b = new p0.u[list.size()];
                return;
        }
    }

    public void a(p0.k kVar, c0 c0Var) {
        boolean z3;
        int i3 = 0;
        while (true) {
            p0.u[] uVarArr = this.b;
            if (i3 < uVarArr.length) {
                c0Var.a();
                c0Var.b();
                p0.u g5 = kVar.g(c0Var.d, 3);
                Format format = (Format) this.f4221a.get(i3);
                String str = format.f311i;
                if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                g2.b.d("Invalid closed caption mime type provided: " + str, z3);
                String str2 = format.f306a;
                if (str2 == null) {
                    c0Var.b();
                    str2 = c0Var.f4054e;
                }
                g5.d(Format.q(str2, str, format.c, format.A, format.B, null, Long.MAX_VALUE, format.f313k));
                uVarArr[i3] = g5;
                i3++;
            } else {
                return;
            }
        }
    }
}

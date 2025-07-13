package e2;

import android.text.TextUtils;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class t extends v {

    /* renamed from: a  reason: collision with root package name */
    public final String f1751a;
    public final m0 b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1752e;

    public t(String str, q qVar, int i3, int i5, boolean z3) {
        if (!TextUtils.isEmpty(str)) {
            this.f1751a = str;
            this.b = qVar;
            this.c = i3;
            this.d = i5;
            this.f1752e = z3;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // e2.v
    public final y createDataSourceInternal(x xVar) {
        s sVar = new s(this.f1751a, this.c, this.d, this.f1752e, xVar);
        m0 m0Var = this.b;
        if (m0Var != null) {
            sVar.addTransferListener(m0Var);
        }
        return sVar;
    }
}

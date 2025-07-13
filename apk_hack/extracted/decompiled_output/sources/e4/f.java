package e4;

import edu.cmu.pocketsphinx.Hypothesis;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f extends d {
    public final Hypothesis b;
    public final boolean c;

    public f(h hVar, Hypothesis hypothesis, boolean z3) {
        super(hVar);
        this.b = hypothesis;
        this.c = z3;
    }

    @Override // e4.d
    public final void a(a aVar) {
        boolean z3 = this.c;
        Hypothesis hypothesis = this.b;
        if (z3) {
            aVar.d(hypothesis);
        } else {
            aVar.f(hypothesis);
        }
    }
}

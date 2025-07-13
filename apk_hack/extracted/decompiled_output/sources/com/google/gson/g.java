package com.google.gson;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends s {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f504a;

    @Override // com.google.gson.s
    public final Object a(p2.a aVar) {
        switch (this.f504a) {
            case 0:
                if (aVar.u() == 9) {
                    aVar.q();
                    return null;
                }
                return Double.valueOf(aVar.l());
            default:
                if (aVar.u() == 9) {
                    aVar.q();
                    return null;
                }
                return Float.valueOf((float) aVar.l());
        }
    }
}

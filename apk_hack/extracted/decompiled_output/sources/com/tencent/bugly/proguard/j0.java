package com.tencent.bugly.proguard;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1501a;
    public final /* synthetic */ int b;

    public j0(int i3, int i5) {
        this.b = i5;
        this.f1501a = i3;
    }

    public final boolean a() {
        switch (this.b) {
            case 0:
                return at.a().k();
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return at.a().j();
            case 4:
                if ((at.a().B & 2) > 0) {
                    return true;
                }
                return false;
            case 5:
                if ((at.a().B & 1) > 0) {
                    return true;
                }
                return false;
            case 6:
                return at.a().j();
            default:
                if ((at.a().B & 4) > 0) {
                    return true;
                }
                return false;
        }
    }
}

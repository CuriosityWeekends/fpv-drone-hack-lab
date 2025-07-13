package j;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f extends a {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i3) {
        super(0);
        this.b = i3;
    }

    public final j D() {
        switch (this.b) {
            case 0:
                return new e(this);
            default:
                return new l(this);
        }
    }
}

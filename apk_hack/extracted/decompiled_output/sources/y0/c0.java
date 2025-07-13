package y0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f4053a;
    public final int b;
    public final int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public String f4054e;

    public c0(int i3, int i5) {
        this(Integer.MIN_VALUE, i3, i5);
    }

    public final void a() {
        int i3;
        int i5 = this.d;
        if (i5 == Integer.MIN_VALUE) {
            i3 = this.b;
        } else {
            i3 = i5 + this.c;
        }
        this.d = i3;
        this.f4054e = this.f4053a + this.d;
    }

    public final void b() {
        if (this.d != Integer.MIN_VALUE) {
            return;
        }
        throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
    }

    public c0(int i3, int i5, int i6) {
        String str;
        if (i3 != Integer.MIN_VALUE) {
            str = i3 + "/";
        } else {
            str = "";
        }
        this.f4053a = str;
        this.b = i5;
        this.c = i6;
        this.d = Integer.MIN_VALUE;
    }
}

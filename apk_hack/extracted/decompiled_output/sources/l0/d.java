package l0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: e  reason: collision with root package name */
    public static final d f2533e = new d(-1, -1, -1);

    /* renamed from: a  reason: collision with root package name */
    public final int f2534a;
    public final int b;
    public final int c;
    public final int d;

    public d(int i3, int i5, int i6) {
        int i7;
        this.f2534a = i3;
        this.b = i5;
        this.c = i6;
        if (g2.w.v(i6)) {
            i7 = g2.w.o(i6, i5);
        } else {
            i7 = -1;
        }
        this.d = i7;
    }

    public final String toString() {
        return "AudioFormat[sampleRate=" + this.f2534a + ", channelCount=" + this.b + ", encoding=" + this.c + ']';
    }
}

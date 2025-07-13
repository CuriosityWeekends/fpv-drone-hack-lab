package a2;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    public final int f74a;
    public final d b;

    public h(int i3, d dVar) {
        this.f74a = i3;
        this.b = dVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f74a - ((h) obj).f74a;
    }
}

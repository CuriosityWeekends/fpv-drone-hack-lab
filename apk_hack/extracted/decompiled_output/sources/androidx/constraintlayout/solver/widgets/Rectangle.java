package androidx.constraintlayout.solver.widgets;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x  reason: collision with root package name */
    public int f120x;

    /* renamed from: y  reason: collision with root package name */
    public int f121y;

    public boolean contains(int i3, int i5) {
        int i6;
        int i7 = this.f120x;
        if (i3 >= i7 && i3 < i7 + this.width && i5 >= (i6 = this.f121y) && i5 < i6 + this.height) {
            return true;
        }
        return false;
    }

    public int getCenterX() {
        return (this.f120x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f121y + this.height) / 2;
    }

    public void grow(int i3, int i5) {
        this.f120x -= i3;
        this.f121y -= i5;
        this.width = (i3 * 2) + this.width;
        this.height = (i5 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i3;
        int i5;
        int i6 = this.f120x;
        int i7 = rectangle.f120x;
        if (i6 >= i7 && i6 < i7 + rectangle.width && (i3 = this.f121y) >= (i5 = rectangle.f121y) && i3 < i5 + rectangle.height) {
            return true;
        }
        return false;
    }

    public void setBounds(int i3, int i5, int i6, int i7) {
        this.f120x = i3;
        this.f121y = i5;
        this.width = i6;
        this.height = i7;
    }
}

package i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b0 implements Appendable {

    /* renamed from: a  reason: collision with root package name */
    public final Appendable f2046a;
    public boolean b = true;

    public b0(Appendable appendable) {
        this.f2046a = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        boolean z3 = this.b;
        Appendable appendable = this.f2046a;
        if (z3) {
            this.b = false;
            appendable.append("  ");
        }
        this.b = c == '\n';
        appendable.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i3, int i5) {
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z3 = this.b;
        Appendable appendable = this.f2046a;
        boolean z5 = false;
        if (z3) {
            this.b = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i5 - 1) == '\n') {
            z5 = true;
        }
        this.b = z5;
        appendable.append(charSequence, i3, i5);
        return this;
    }
}

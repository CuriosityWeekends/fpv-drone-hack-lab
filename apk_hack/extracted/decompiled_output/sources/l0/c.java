package l0;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c {
    public static final c c = new c(8, new int[]{2});
    public static final c d = new c(8, new int[]{2, 5, 6});

    /* renamed from: a  reason: collision with root package name */
    public final int[] f2532a;
    public final int b;

    public c(int i3, int[] iArr) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f2532a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f2532a = new int[0];
        }
        this.b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Arrays.equals(this.f2532a, cVar.f2532a) && this.b == cVar.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f2532a) * 31) + this.b;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", supportedEncodings=" + Arrays.toString(this.f2532a) + "]";
    }
}

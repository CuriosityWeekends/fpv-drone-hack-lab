package androidx.core.util;

import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f4, S s) {
        this.first = f4;
        this.second = s;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a5, B b) {
        return new Pair<>(a5, b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat.equals(pair.first, this.first) || !ObjectsCompat.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        F f4 = this.first;
        int i3 = 0;
        if (f4 == null) {
            hashCode = 0;
        } else {
            hashCode = f4.hashCode();
        }
        S s = this.second;
        if (s != null) {
            i3 = s.hashCode();
        }
        return hashCode ^ i3;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}

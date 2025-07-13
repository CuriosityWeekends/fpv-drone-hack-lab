package r4;

import java.io.Serializable;
import java.util.Objects;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = -8759979445933046293L;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f3457a;

    public e(Throwable th) {
        this.f3457a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return Objects.equals(this.f3457a, ((e) obj).f3457a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3457a.hashCode();
    }

    public final String toString() {
        return "NotificationLite.Error[" + this.f3457a + "]";
    }
}

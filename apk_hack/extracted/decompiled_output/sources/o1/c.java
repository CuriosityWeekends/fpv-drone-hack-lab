package o1;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends LinkedHashMap {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2956a = 4;

    public c(int i3) {
        super(i3, 1.0f, false);
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        if (size() > this.f2956a) {
            return true;
        }
        return false;
    }
}

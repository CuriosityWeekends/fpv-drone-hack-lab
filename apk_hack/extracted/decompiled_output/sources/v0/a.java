package v0;

import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends c {
    public final long b;
    public final ArrayList c;
    public final ArrayList d;

    public a(int i3, long j2) {
        super(i3);
        this.b = j2;
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    public final a c(int i3) {
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            a aVar = (a) arrayList.get(i5);
            if (aVar.f3791a == i3) {
                return aVar;
            }
        }
        return null;
    }

    public final b d(int i3) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) arrayList.get(i5);
            if (bVar.f3791a == i3) {
                return bVar;
            }
        }
        return null;
    }

    @Override // v0.c
    public final String toString() {
        return c.a(this.f3791a) + " leaves: " + Arrays.toString(this.c.toArray()) + " containers: " + Arrays.toString(this.d.toArray());
    }
}

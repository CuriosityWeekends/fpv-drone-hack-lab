package a2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements s1.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f52a;
    public final List b;

    public /* synthetic */ c(List list, int i3) {
        this.f52a = i3;
        this.b = list;
    }

    @Override // s1.e
    public final int b(long j2) {
        switch (this.f52a) {
            case 0:
                return j2 < 0 ? 0 : -1;
            case 1:
                return j2 < 0 ? 0 : -1;
            case 2:
                return -1;
            default:
                return -1;
        }
    }

    @Override // s1.e
    public final long e(int i3) {
        boolean z3;
        boolean z5;
        switch (this.f52a) {
            case 0:
                if (i3 == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                g2.b.e(z3);
                return 0L;
            case 1:
                if (i3 == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                g2.b.e(z5);
                return 0L;
            case 2:
                return 0L;
            default:
                return 0L;
        }
    }

    @Override // s1.e
    public final List i(long j2) {
        switch (this.f52a) {
            case 0:
                if (j2 >= 0) {
                    return this.b;
                }
                return Collections.emptyList();
            case 1:
                if (j2 >= 0) {
                    return this.b;
                }
                return Collections.emptyList();
            case 2:
                return this.b;
            default:
                return this.b;
        }
    }

    @Override // s1.e
    public final int n() {
        switch (this.f52a) {
            case 0:
                return 1;
            case 1:
                return 1;
            case 2:
                return 1;
            default:
                return 1;
        }
    }

    public c(ArrayList arrayList) {
        this.f52a = 0;
        this.b = Collections.unmodifiableList(arrayList);
    }
}

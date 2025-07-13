package g2;

import java.util.ArrayList;
import java.util.Collections;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r {

    /* renamed from: h  reason: collision with root package name */
    public static final f2.n f1949h = new f2.n(1);

    /* renamed from: i  reason: collision with root package name */
    public static final f2.n f1950i = new f2.n(2);

    /* renamed from: a  reason: collision with root package name */
    public final int f1951a;

    /* renamed from: e  reason: collision with root package name */
    public int f1952e;

    /* renamed from: f  reason: collision with root package name */
    public int f1953f;

    /* renamed from: g  reason: collision with root package name */
    public int f1954g;
    public final q[] c = new q[5];
    public final ArrayList b = new ArrayList();
    public int d = -1;

    public r(int i3) {
        this.f1951a = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(float f4, int i3) {
        q qVar;
        int i5 = this.d;
        ArrayList arrayList = this.b;
        if (i5 != 1) {
            Collections.sort(arrayList, f1949h);
            this.d = 1;
        }
        int i6 = this.f1954g;
        q[] qVarArr = this.c;
        if (i6 > 0) {
            int i7 = i6 - 1;
            this.f1954g = i7;
            qVar = qVarArr[i7];
        } else {
            qVar = new Object();
        }
        int i8 = this.f1952e;
        this.f1952e = i8 + 1;
        qVar.f1948a = i8;
        qVar.b = i3;
        qVar.c = f4;
        arrayList.add(qVar);
        this.f1953f += i3;
        while (true) {
            int i9 = this.f1953f;
            int i10 = this.f1951a;
            if (i9 > i10) {
                int i11 = i9 - i10;
                q qVar2 = (q) arrayList.get(0);
                int i12 = qVar2.b;
                if (i12 <= i11) {
                    this.f1953f -= i12;
                    arrayList.remove(0);
                    int i13 = this.f1954g;
                    if (i13 < 5) {
                        this.f1954g = i13 + 1;
                        qVarArr[i13] = qVar2;
                    }
                } else {
                    qVar2.b = i12 - i11;
                    this.f1953f -= i11;
                }
            } else {
                return;
            }
        }
    }

    public final float b() {
        int i3 = this.d;
        ArrayList arrayList = this.b;
        if (i3 != 0) {
            Collections.sort(arrayList, f1950i);
            this.d = 0;
        }
        float f4 = 0.5f * this.f1953f;
        int i5 = 0;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            q qVar = (q) arrayList.get(i6);
            i5 += qVar.b;
            if (i5 >= f4) {
                return qVar.c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((q) arrayList.get(arrayList.size() - 1)).c;
    }
}

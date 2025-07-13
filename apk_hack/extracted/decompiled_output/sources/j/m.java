package j;

import android.graphics.Bitmap;
import android.os.Build;
import c0.n;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m implements i {
    public static final Bitmap.Config[] d;

    /* renamed from: e  reason: collision with root package name */
    public static final Bitmap.Config[] f2199e;

    /* renamed from: f  reason: collision with root package name */
    public static final Bitmap.Config[] f2200f;

    /* renamed from: g  reason: collision with root package name */
    public static final Bitmap.Config[] f2201g;

    /* renamed from: h  reason: collision with root package name */
    public static final Bitmap.Config[] f2202h;

    /* renamed from: a  reason: collision with root package name */
    public final f f2203a = new f(1);
    public final c1.b b = new c1.b(9);
    public final HashMap c = new HashMap();

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            config = Bitmap.Config.RGBA_F16;
            configArr[configArr.length - 1] = config;
        }
        d = configArr;
        f2199e = configArr;
        f2200f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f2201g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f2202h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String c(int i3, Bitmap.Config config) {
        return "[" + i3 + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap d5 = d(bitmap.getConfig());
        Integer num2 = (Integer) d5.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                d5.remove(num);
                return;
            } else {
                d5.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(n.c(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a3 A[EDGE_INSN: B:45:0x00a3->B:41:0x00a3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(int r12, int r13, android.graphics.Bitmap.Config r14) {
        /*
            r11 = this;
            r0 = 0
            r1 = 1
            int r2 = c0.n.b(r12, r13, r14)
            j.f r3 = r11.f2203a
            java.lang.Object r4 = r3.f2183a
            java.util.ArrayDeque r4 = (java.util.ArrayDeque) r4
            java.lang.Object r4 = r4.poll()
            j.j r4 = (j.j) r4
            if (r4 != 0) goto L18
            j.j r4 = r3.D()
        L18:
            j.l r4 = (j.l) r4
            r4.b = r2
            r4.c = r14
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 26
            if (r5 < r6) goto L31
            android.graphics.Bitmap$Config r5 = androidx.core.view.a.z()
            boolean r5 = r5.equals(r14)
            if (r5 == 0) goto L31
            android.graphics.Bitmap$Config[] r5 = j.m.f2199e
            goto L54
        L31:
            int[] r5 = j.k.f2197a
            int r6 = r14.ordinal()
            r5 = r5[r6]
            if (r5 == r1) goto L52
            r6 = 2
            if (r5 == r6) goto L4f
            r6 = 3
            if (r5 == r6) goto L4c
            r6 = 4
            if (r5 == r6) goto L49
            android.graphics.Bitmap$Config[] r5 = new android.graphics.Bitmap.Config[r1]
            r5[r0] = r14
            goto L54
        L49:
            android.graphics.Bitmap$Config[] r5 = j.m.f2202h
            goto L54
        L4c:
            android.graphics.Bitmap$Config[] r5 = j.m.f2201g
            goto L54
        L4f:
            android.graphics.Bitmap$Config[] r5 = j.m.f2200f
            goto L54
        L52:
            android.graphics.Bitmap$Config[] r5 = j.m.d
        L54:
            int r6 = r5.length
        L55:
            if (r0 >= r6) goto La3
            r7 = r5[r0]
            java.util.NavigableMap r8 = r11.d(r7)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            java.lang.Object r8 = r8.ceilingKey(r9)
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto La1
            int r9 = r8.intValue()
            int r10 = r2 * 8
            if (r9 > r10) goto La1
            int r0 = r8.intValue()
            if (r0 != r2) goto L82
            if (r7 != 0) goto L7c
            if (r14 == 0) goto La3
            goto L82
        L7c:
            boolean r0 = r7.equals(r14)
            if (r0 != 0) goto La3
        L82:
            r3.C(r4)
            int r0 = r8.intValue()
            java.lang.Object r1 = r3.f2183a
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1
            java.lang.Object r1 = r1.poll()
            j.j r1 = (j.j) r1
            if (r1 != 0) goto L99
            j.j r1 = r3.D()
        L99:
            r4 = r1
            j.l r4 = (j.l) r4
            r4.b = r0
            r4.c = r7
            goto La3
        La1:
            int r0 = r0 + r1
            goto L55
        La3:
            c1.b r0 = r11.b
            java.lang.Object r0 = r0.r(r4)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto Lb9
            int r1 = r4.b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.a(r1, r0)
            r0.reconfigure(r12, r13, r14)
        Lb9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.m.b(int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    public final NavigableMap d(Bitmap.Config config) {
        HashMap hashMap = this.c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            hashMap.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    public final void e(Bitmap bitmap) {
        int c = n.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        f fVar = this.f2203a;
        j jVar = (j) ((ArrayDeque) fVar.f2183a).poll();
        if (jVar == null) {
            jVar = fVar.D();
        }
        l lVar = (l) jVar;
        lVar.b = c;
        lVar.c = config;
        this.b.u(lVar, bitmap);
        NavigableMap d5 = d(bitmap.getConfig());
        Integer num = (Integer) d5.get(Integer.valueOf(lVar.b));
        Integer valueOf = Integer.valueOf(lVar.b);
        int i3 = 1;
        if (num != null) {
            i3 = 1 + num.intValue();
        }
        d5.put(valueOf, Integer.valueOf(i3));
    }

    public final String toString() {
        StringBuilder l5 = a1.i.l("SizeConfigStrategy{groupedMap=");
        l5.append(this.b);
        l5.append(", sortedSizes=(");
        HashMap hashMap = this.c;
        for (Map.Entry entry : hashMap.entrySet()) {
            l5.append(entry.getKey());
            l5.append('[');
            l5.append(entry.getValue());
            l5.append("], ");
        }
        if (!hashMap.isEmpty()) {
            l5.replace(l5.length() - 2, l5.length(), "");
        }
        l5.append(")}");
        return l5.toString();
    }
}

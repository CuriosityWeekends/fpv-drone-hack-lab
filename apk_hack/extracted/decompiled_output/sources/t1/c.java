package t1;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends h {

    /* renamed from: h  reason: collision with root package name */
    public final int f3637h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3638i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3639j;

    /* renamed from: m  reason: collision with root package name */
    public List f3642m;

    /* renamed from: n  reason: collision with root package name */
    public List f3643n;

    /* renamed from: o  reason: collision with root package name */
    public int f3644o;

    /* renamed from: p  reason: collision with root package name */
    public int f3645p;
    public boolean q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3646r;
    public byte s;

    /* renamed from: t  reason: collision with root package name */
    public byte f3647t;

    /* renamed from: v  reason: collision with root package name */
    public boolean f3649v;
    public static final int[] w = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: x  reason: collision with root package name */
    public static final int[] f3633x = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f3634y = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f3635z = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] A = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 251};
    public static final int[] B = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] C = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] D = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: g  reason: collision with root package name */
    public final c0.b f3636g = new c0.b();

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f3640k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public b f3641l = new b(0, 4);

    /* renamed from: u  reason: collision with root package name */
    public int f3648u = 0;

    public c(String str, int i3) {
        int i5;
        if ("application/x-mp4-cea-608".equals(str)) {
            i5 = 2;
        } else {
            i5 = 3;
        }
        this.f3637h = i5;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        Log.w("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
                        this.f3639j = 0;
                        this.f3638i = 0;
                    } else {
                        this.f3639j = 1;
                        this.f3638i = 1;
                    }
                } else {
                    this.f3639j = 0;
                    this.f3638i = 1;
                }
            } else {
                this.f3639j = 1;
                this.f3638i = 0;
            }
        } else {
            this.f3639j = 0;
            this.f3638i = 0;
        }
        j(0);
        i();
        this.f3649v = true;
    }

    @Override // t1.h
    public final a2.c e() {
        List list = this.f3642m;
        this.f3643n = list;
        return new a2.c(list, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x007e A[SYNTHETIC] */
    @Override // t1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(t1.g r15) {
        /*
            Method dump skipped, instructions count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.c.f(t1.g):void");
    }

    @Override // t1.h, m0.b
    public final void flush() {
        super.flush();
        this.f3642m = null;
        this.f3643n = null;
        j(0);
        this.f3645p = 4;
        this.f3641l.f3632h = 4;
        i();
        this.q = false;
        this.f3646r = false;
        this.s = (byte) 0;
        this.f3647t = (byte) 0;
        this.f3648u = 0;
        this.f3649v = true;
    }

    @Override // t1.h
    public final boolean g() {
        if (this.f3642m != this.f3643n) {
            return true;
        }
        return false;
    }

    public final ArrayList h() {
        ArrayList arrayList = this.f3640k;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        int i3 = 2;
        for (int i5 = 0; i5 < size; i5++) {
            s1.b b = ((b) arrayList.get(i5)).b(Integer.MIN_VALUE);
            arrayList2.add(b);
            if (b != null) {
                i3 = Math.min(i3, b.f3485h);
            }
        }
        ArrayList arrayList3 = new ArrayList(size);
        for (int i6 = 0; i6 < size; i6++) {
            s1.b bVar = (s1.b) arrayList2.get(i6);
            if (bVar != null) {
                if (bVar.f3485h != i3) {
                    bVar = ((b) arrayList.get(i6)).b(i3);
                }
                arrayList3.add(bVar);
            }
        }
        return arrayList3;
    }

    public final void i() {
        b bVar = this.f3641l;
        bVar.f3631g = this.f3644o;
        bVar.f3628a.clear();
        bVar.b.clear();
        bVar.c.setLength(0);
        bVar.d = 15;
        bVar.f3629e = 0;
        bVar.f3630f = 0;
        ArrayList arrayList = this.f3640k;
        arrayList.clear();
        arrayList.add(this.f3641l);
    }

    public final void j(int i3) {
        int i5 = this.f3644o;
        if (i5 == i3) {
            return;
        }
        this.f3644o = i3;
        if (i3 == 3) {
            int i6 = 0;
            while (true) {
                ArrayList arrayList = this.f3640k;
                if (i6 < arrayList.size()) {
                    ((b) arrayList.get(i6)).f3631g = i3;
                    i6++;
                } else {
                    return;
                }
            }
        } else {
            i();
            if (i5 == 3 || i3 == 1 || i3 == 0) {
                this.f3642m = Collections.emptyList();
            }
        }
    }

    @Override // t1.h, m0.b
    public final void release() {
    }
}

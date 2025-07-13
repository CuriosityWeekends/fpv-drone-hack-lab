package l0;

import android.media.AudioTrack;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2568a;
    public final int b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2569e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2570f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2571g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2572h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2573i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f2574j;

    /* renamed from: k  reason: collision with root package name */
    public final f[] f2575k;

    public s(boolean z3, int i3, int i5, int i6, int i7, int i8, int i9, boolean z5, boolean z6, f[] fVarArr) {
        int i10;
        int i11;
        boolean z7;
        this.f2568a = z3;
        this.b = i3;
        this.c = i5;
        this.d = i6;
        this.f2569e = i7;
        this.f2570f = i8;
        this.f2571g = i9;
        if (z3) {
            int minBufferSize = AudioTrack.getMinBufferSize(i7, i8, i9);
            if (minBufferSize != -2) {
                z7 = true;
            } else {
                z7 = false;
            }
            g2.b.h(z7);
            i11 = g2.w.h(minBufferSize * 4, ((int) ((250000 * i7) / 1000000)) * i6, (int) Math.max(minBufferSize, ((750000 * i7) / 1000000) * i6));
        } else {
            if (i9 != 5) {
                if (i9 != 6) {
                    if (i9 != 7) {
                        if (i9 != 8) {
                            if (i9 != 14) {
                                if (i9 != 17) {
                                    if (i9 != 18) {
                                        throw new IllegalArgumentException();
                                    }
                                } else {
                                    i10 = 336000;
                                }
                            } else {
                                i10 = 3062500;
                            }
                        } else {
                            i10 = 2250000;
                        }
                    } else {
                        i10 = 192000;
                    }
                }
                i10 = 768000;
            } else {
                i10 = 80000;
            }
            i11 = (int) (((i9 == 5 ? i10 * 2 : i10) * 250000) / 1000000);
        }
        this.f2572h = i11;
        this.f2573i = z5;
        this.f2574j = z6;
        this.f2575k = fVarArr;
    }
}

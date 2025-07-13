package b2;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f152a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final int f153e;

    /* renamed from: f  reason: collision with root package name */
    public final int f154f;

    /* renamed from: g  reason: collision with root package name */
    public final int f155g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f156h;

    public h(Format format, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int i3, String str) {
        boolean z3;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = false;
        this.b = i.e(i3, false);
        int i5 = format.c & (~defaultTrackSelector$Parameters.f416e);
        if ((i5 & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.c = z3;
        if ((i5 & 2) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        String str2 = defaultTrackSelector$Parameters.b;
        int c = i.c(format, str2, defaultTrackSelector$Parameters.d);
        this.f153e = c;
        int i6 = format.d;
        int bitCount = Integer.bitCount(defaultTrackSelector$Parameters.c & i6);
        this.f154f = bitCount;
        if ((i6 & 1088) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.f156h = z6;
        if ((c > 0 && !z5) || (c == 0 && z5)) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.d = z7;
        if (i.h(str) == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        int c5 = i.c(format, str, z8);
        this.f155g = c5;
        if (c > 0 || ((str2 == null && bitCount > 0) || z3 || (z5 && c5 > 0))) {
            z9 = true;
        }
        this.f152a = z9;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public final int compareTo(h hVar) {
        boolean z3 = hVar.b;
        boolean z5 = this.b;
        if (z5 != z3) {
            if (!z5) {
                return -1;
            }
            return 1;
        }
        int i3 = this.f153e;
        int i5 = hVar.f153e;
        if (i3 != i5) {
            return i.a(i3, i5);
        }
        int i6 = this.f154f;
        int i7 = hVar.f154f;
        if (i6 != i7) {
            return i.a(i6, i7);
        }
        boolean z6 = hVar.c;
        boolean z7 = this.c;
        if (z7 != z6) {
            if (!z7) {
                return -1;
            }
            return 1;
        }
        boolean z8 = hVar.d;
        boolean z9 = this.d;
        if (z9 != z8) {
            if (!z9) {
                return -1;
            }
            return 1;
        }
        int i8 = this.f155g;
        int i9 = hVar.f155g;
        if (i8 != i9) {
            return i.a(i8, i9);
        }
        if (i6 == 0) {
            boolean z10 = hVar.f156h;
            boolean z11 = this.f156h;
            if (z11 != z10) {
                if (z11) {
                    return -1;
                }
                return 1;
            }
            return 0;
        }
        return 0;
    }
}

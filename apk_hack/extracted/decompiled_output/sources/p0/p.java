package p0;

import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p {

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f3117h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f3118i = {44100, 48000, 32000};

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f3119j = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f3120k = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f3121l = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f3122m = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f3123n = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* renamed from: a  reason: collision with root package name */
    public int f3124a;
    public String b;
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f3125e;

    /* renamed from: f  reason: collision with root package name */
    public int f3126f;

    /* renamed from: g  reason: collision with root package name */
    public int f3127g;

    public static int a(int i3) {
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if ((i3 & (-2097152)) == -2097152) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 || (i5 = (i3 >>> 19) & 3) == 1 || (i6 = (i3 >>> 17) & 3) == 0 || (i7 = (i3 >>> 12) & 15) == 0 || i7 == 15 || (i8 = (i3 >>> 10) & 3) == 3) {
            return -1;
        }
        int i11 = f3118i[i8];
        if (i5 == 2) {
            i11 /= 2;
        } else if (i5 == 0) {
            i11 /= 4;
        }
        int i12 = (i3 >>> 9) & 1;
        if (i6 == 3) {
            if (i5 == 3) {
                i10 = f3119j[i7 - 1];
            } else {
                i10 = f3120k[i7 - 1];
            }
            return (((i10 * 12) / i11) + i12) * 4;
        }
        if (i5 == 3) {
            if (i6 == 2) {
                i9 = f3121l[i7 - 1];
            } else {
                i9 = f3122m[i7 - 1];
            }
        } else {
            i9 = f3123n[i7 - 1];
        }
        int i13 = IjkMediaMeta.FF_PROFILE_H264_HIGH_444;
        if (i5 == 3) {
            return ((i9 * IjkMediaMeta.FF_PROFILE_H264_HIGH_444) / i11) + i12;
        }
        if (i6 == 1) {
            i13 = 72;
        }
        return ((i13 * i9) / i11) + i12;
    }

    public static boolean b(int i3, p pVar) {
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        if ((i3 & (-2097152)) == -2097152) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 || (i5 = (i3 >>> 19) & 3) == 1 || (i6 = (i3 >>> 17) & 3) == 0 || (i7 = (i3 >>> 12) & 15) == 0 || i7 == 15 || (i8 = (i3 >>> 10) & 3) == 3) {
            return false;
        }
        int i13 = f3118i[i8];
        int i14 = 2;
        if (i5 == 2) {
            i13 /= 2;
        } else if (i5 == 0) {
            i13 /= 4;
        }
        int i15 = (i3 >>> 9) & 1;
        int i16 = 1152;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    i16 = 384;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } else if (i5 != 3) {
            i16 = 576;
        }
        if (i6 == 3) {
            if (i5 == 3) {
                i9 = f3119j[i7 - 1];
            } else {
                i9 = f3120k[i7 - 1];
            }
            i12 = (((i9 * 12) / i13) + i15) * 4;
        } else {
            if (i5 == 3) {
                if (i6 == 2) {
                    i9 = f3121l[i7 - 1];
                } else {
                    i9 = f3122m[i7 - 1];
                }
                i11 = (i9 * IjkMediaMeta.FF_PROFILE_H264_HIGH_444) / i13;
            } else {
                i9 = f3123n[i7 - 1];
                if (i6 == 1) {
                    i10 = 72;
                } else {
                    i10 = IjkMediaMeta.FF_PROFILE_H264_HIGH_444;
                }
                i11 = (i10 * i9) / i13;
            }
            i12 = i11 + i15;
        }
        String str = f3117h[3 - i6];
        if (((i3 >> 6) & 3) == 3) {
            i14 = 1;
        }
        pVar.f3124a = i5;
        pVar.b = str;
        pVar.c = i12;
        pVar.d = i13;
        pVar.f3125e = i14;
        pVar.f3126f = i9;
        pVar.f3127g = i16;
        return true;
    }
}

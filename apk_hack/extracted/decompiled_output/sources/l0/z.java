package l0;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final int f2616a;
    public final int b;
    public final float c;
    public final float d;

    /* renamed from: e  reason: collision with root package name */
    public final float f2617e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2618f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2619g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2620h;

    /* renamed from: i  reason: collision with root package name */
    public final short[] f2621i;

    /* renamed from: j  reason: collision with root package name */
    public short[] f2622j;

    /* renamed from: k  reason: collision with root package name */
    public int f2623k;

    /* renamed from: l  reason: collision with root package name */
    public short[] f2624l;

    /* renamed from: m  reason: collision with root package name */
    public int f2625m;

    /* renamed from: n  reason: collision with root package name */
    public short[] f2626n;

    /* renamed from: o  reason: collision with root package name */
    public int f2627o;

    /* renamed from: p  reason: collision with root package name */
    public int f2628p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public int f2629r;
    public int s;

    /* renamed from: t  reason: collision with root package name */
    public int f2630t;

    /* renamed from: u  reason: collision with root package name */
    public int f2631u;

    /* renamed from: v  reason: collision with root package name */
    public int f2632v;

    public z(int i3, int i5, float f4, float f5, int i6) {
        this.f2616a = i3;
        this.b = i5;
        this.c = f4;
        this.d = f5;
        this.f2617e = i3 / i6;
        this.f2618f = i3 / 400;
        int i7 = i3 / 65;
        this.f2619g = i7;
        int i8 = i7 * 2;
        this.f2620h = i8;
        this.f2621i = new short[i8];
        this.f2622j = new short[i8 * i5];
        this.f2624l = new short[i8 * i5];
        this.f2626n = new short[i8 * i5];
    }

    public static void e(int i3, int i5, short[] sArr, int i6, short[] sArr2, int i7, short[] sArr3, int i8) {
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i6 * i5) + i9;
            int i11 = (i8 * i5) + i9;
            int i12 = (i7 * i5) + i9;
            for (int i13 = 0; i13 < i3; i13++) {
                sArr[i10] = (short) (((sArr3[i11] * i13) + ((i3 - i13) * sArr2[i12])) / i3);
                i10 += i5;
                i12 += i5;
                i11 += i5;
            }
        }
    }

    public final void a(short[] sArr, int i3, int i5) {
        short[] c = c(this.f2624l, this.f2625m, i5);
        this.f2624l = c;
        int i6 = this.b;
        System.arraycopy(sArr, i3 * i6, c, this.f2625m * i6, i6 * i5);
        this.f2625m += i5;
    }

    public final void b(short[] sArr, int i3, int i5) {
        int i6 = this.f2620h / i5;
        int i7 = this.b;
        int i8 = i5 * i7;
        int i9 = i3 * i7;
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                i11 += sArr[(i10 * i8) + i9 + i12];
            }
            this.f2621i[i10] = (short) (i11 / i8);
        }
    }

    public final short[] c(short[] sArr, int i3, int i5) {
        int length = sArr.length;
        int i6 = this.b;
        int i7 = length / i6;
        if (i3 + i5 <= i7) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i7 * 3) / 2) + i5) * i6);
    }

    public final int d(short[] sArr, int i3, int i5, int i6) {
        int i7 = i3 * this.b;
        int i8 = 255;
        int i9 = 1;
        int i10 = 0;
        int i11 = 0;
        while (i5 <= i6) {
            int i12 = 0;
            for (int i13 = 0; i13 < i5; i13++) {
                i12 += Math.abs(sArr[i7 + i13] - sArr[(i7 + i5) + i13]);
            }
            if (i12 * i10 < i9 * i5) {
                i10 = i5;
                i9 = i12;
            }
            if (i12 * i8 > i11 * i5) {
                i8 = i5;
                i11 = i12;
            }
            i5++;
        }
        this.f2631u = i9 / i10;
        this.f2632v = i11 / i8;
        return i10;
    }

    public final void f() {
        int i3;
        int i5;
        int i6;
        float f4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z3;
        int i16 = this.f2625m;
        float f5 = this.c;
        float f6 = this.d;
        float f7 = f5 / f6;
        float f8 = this.f2617e * f6;
        double d = f7;
        int i17 = this.f2616a;
        int i18 = this.b;
        int i19 = 1;
        if (d <= 1.00001d && d >= 0.99999d) {
            a(this.f2622j, 0, this.f2623k);
            this.f2623k = 0;
        } else {
            int i20 = this.f2623k;
            int i21 = this.f2620h;
            if (i20 >= i21) {
                int i22 = 0;
                while (true) {
                    int i23 = this.f2629r;
                    if (i23 > 0) {
                        int min = Math.min(i21, i23);
                        a(this.f2622j, i22, min);
                        this.f2629r -= min;
                        i22 += min;
                        i6 = i16;
                        f4 = f8;
                        i5 = i17;
                    } else {
                        short[] sArr = this.f2622j;
                        if (i17 > 4000) {
                            i3 = i17 / 4000;
                        } else {
                            i3 = 1;
                        }
                        int i24 = this.f2619g;
                        int i25 = this.f2618f;
                        if (i18 == i19 && i3 == i19) {
                            i7 = d(sArr, i22, i25, i24);
                            i6 = i16;
                            f4 = f8;
                            i5 = i17;
                        } else {
                            b(sArr, i22, i3);
                            i5 = i17;
                            i6 = i16;
                            short[] sArr2 = this.f2621i;
                            f4 = f8;
                            int d5 = d(sArr2, 0, i25 / i3, i24 / i3);
                            if (i3 != 1) {
                                int i26 = d5 * i3;
                                int i27 = i3 * 4;
                                int i28 = i26 - i27;
                                int i29 = i26 + i27;
                                if (i28 >= i25) {
                                    i25 = i28;
                                }
                                if (i29 <= i24) {
                                    i24 = i29;
                                }
                                if (i18 == 1) {
                                    i7 = d(sArr, i22, i25, i24);
                                } else {
                                    b(sArr, i22, 1);
                                    i7 = d(sArr2, 0, i25, i24);
                                }
                            } else {
                                i7 = d5;
                            }
                        }
                        int i30 = this.f2631u;
                        int i31 = this.f2632v;
                        if (i30 == 0 || (i8 = this.s) == 0 || i31 > i30 * 3 || i30 * 2 <= this.f2630t * 3) {
                            i8 = i7;
                        }
                        this.f2630t = i30;
                        this.s = i7;
                        if (d > 1.0d) {
                            short[] sArr3 = this.f2622j;
                            if (f7 >= 2.0f) {
                                i10 = (int) (i8 / (f7 - 1.0f));
                            } else {
                                this.f2629r = (int) (((2.0f - f7) * i8) / (f7 - 1.0f));
                                i10 = i8;
                            }
                            short[] c = c(this.f2624l, this.f2625m, i10);
                            this.f2624l = c;
                            int i32 = i22;
                            e(i10, this.b, c, this.f2625m, sArr3, i32, sArr3, i22 + i8);
                            this.f2625m += i10;
                            i22 = i8 + i10 + i32;
                        } else {
                            int i33 = i22;
                            short[] sArr4 = this.f2622j;
                            if (f7 < 0.5f) {
                                i9 = (int) ((i8 * f7) / (1.0f - f7));
                            } else {
                                this.f2629r = (int) ((((2.0f * f7) - 1.0f) * i8) / (1.0f - f7));
                                i9 = i8;
                            }
                            int i34 = i8 + i9;
                            short[] c5 = c(this.f2624l, this.f2625m, i34);
                            this.f2624l = c5;
                            System.arraycopy(sArr4, i33 * i18, c5, this.f2625m * i18, i8 * i18);
                            e(i9, this.b, this.f2624l, this.f2625m + i8, sArr4, i33 + i8, sArr4, i33);
                            this.f2625m += i34;
                            i22 = i33 + i9;
                        }
                    }
                    if (i22 + i21 > i20) {
                        break;
                    }
                    i17 = i5;
                    i16 = i6;
                    f8 = f4;
                    i19 = 1;
                }
                int i35 = this.f2623k - i22;
                short[] sArr5 = this.f2622j;
                System.arraycopy(sArr5, i22 * i18, sArr5, 0, i35 * i18);
                this.f2623k = i35;
                if (f4 == 1.0f && this.f2625m != (i11 = i6)) {
                    int i36 = i5;
                    int i37 = (int) (i36 / f4);
                    int i38 = i36;
                    while (true) {
                        if (i37 <= 16384 && i38 <= 16384) {
                            break;
                        }
                        i37 /= 2;
                        i38 /= 2;
                    }
                    int i39 = this.f2625m - i11;
                    short[] c6 = c(this.f2626n, this.f2627o, i39);
                    this.f2626n = c6;
                    System.arraycopy(this.f2624l, i11 * i18, c6, this.f2627o * i18, i39 * i18);
                    this.f2625m = i11;
                    this.f2627o += i39;
                    int i40 = 0;
                    while (true) {
                        i12 = this.f2627o;
                        i13 = i12 - 1;
                        if (i40 >= i13) {
                            break;
                        }
                        while (true) {
                            i14 = this.f2628p + 1;
                            int i41 = i14 * i37;
                            i15 = this.q;
                            if (i41 <= i15 * i38) {
                                break;
                            }
                            this.f2624l = c(this.f2624l, this.f2625m, 1);
                            for (int i42 = 0; i42 < i18; i42++) {
                                short[] sArr6 = this.f2626n;
                                int i43 = (i40 * i18) + i42;
                                short s = sArr6[i43];
                                short s5 = sArr6[i43 + i18];
                                int i44 = this.f2628p;
                                int i45 = i44 * i37;
                                int i46 = (i44 + 1) * i37;
                                int i47 = i46 - (this.q * i38);
                                int i48 = i46 - i45;
                                this.f2624l[(this.f2625m * i18) + i42] = (short) ((((i48 - i47) * s5) + (s * i47)) / i48);
                            }
                            this.q++;
                            this.f2625m++;
                        }
                        this.f2628p = i14;
                        if (i14 == i38) {
                            this.f2628p = 0;
                            if (i15 == i37) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            g2.b.h(z3);
                            this.q = 0;
                        }
                        i40++;
                    }
                    if (i13 != 0) {
                        short[] sArr7 = this.f2626n;
                        System.arraycopy(sArr7, i13 * i18, sArr7, 0, (i12 - i13) * i18);
                        this.f2627o -= i13;
                        return;
                    }
                    return;
                }
            }
        }
        i6 = i16;
        f4 = f8;
        i5 = i17;
        if (f4 == 1.0f) {
        }
    }
}
